package com.example.brian.testapplication;

/**
 * Created by Brian_Hsu on 2018/1/22.
 */

public class LoginPresenter {
    private ServerAPI serverApi;
    private String loginName;
    private String loginPwd;
    private Database db;

    public LoginPresenter(Database db, ServerAPI serverApi){
        this.serverApi = serverApi;
        this.db = db;
    }

    public void onLoginClick(){
        serverApi.login(loginName, loginPwd, new ServerAPI.Callback(){
            @Override
            public void onComplete(UserInfo userInfo){
                db.saveUserInfo(userInfo);
            }
        });
    }
}