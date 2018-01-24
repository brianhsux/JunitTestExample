package com.example.brian.testapplication;

import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;

/**
 * Created by Brian_Hsu on 2018/1/22.
 */

public class LoginPresenterTest {

    @Mock
    private ServerAPI serverApi;

    @Mock
    private Database db;

    @Test
    public void login_should_save_userInfo_to_db() throws Exception {
        //arrange
        MockitoAnnotations.initMocks(this);
        final UserInfo verifyData = new UserInfo("john", 20, "taipei city");
        LoginPresenter presenter = new LoginPresenter(db, serverApi);

        Mockito.doAnswer(new Answer() {
           public Object answer(InvocationOnMock invocation) {
               ServerAPI.Callback callback = (ServerAPI.Callback) invocation.getArguments()[2];
               //拿login的第三的參數來轉型
               callback.onComplete(verifyData);
               return null;
           }})
        .when(serverApi)
        .login(Mockito.anyString(), Mockito.anyString(), Mockito.any(ServerAPI.Callback.class));

        //act
        presenter.onLoginClick();
        //assert
        Mockito.verify(db).saveUserInfo(verifyData);
        //在這裡驗證db是否有被確實呼叫
    }
}
