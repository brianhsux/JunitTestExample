package com.example.brian.testapplication;

import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

/**
 * Created by Brian_Hsu on 2018/1/22.
 */

public class MyMathTest {
    //@Mock 代表要讓這物件有 mock 的行為
    @Mock
    private Logger mockLogger = new Logger();

    @Test
    public void sample_log_call_once(){
        //arrange
        //要先呼叫initMocks，才能使mock的物件正常運作
        MockitoAnnotations.initMocks(this);


        //act
        //在這裡預期logger會被呼叫一次
        MyMath myMath = new MyMath(mockLogger);
        myMath.add(-1, -2);

        //assert
        //verify 相當於之前的 assert，這裡的意思是要驗證 mockLogger 這個物件
        //的某個 method 是否被呼叫一次，在這個例子中是 log 這個 method，並且不
        //需要在意參數的字串是甚麼(Mockito.anyString())
        Mockito.verify(mockLogger).log(Mockito.anyString());
    }

    @Test
    public void sample_logger_call_three_times(){
        MockitoAnnotations.initMocks(this);

        int expectCallTimes = 3;

        MyMath myMath = new MyMath(mockLogger);
        myMath.add(-1, 2);
        myMath.add(1, -2);
        myMath.add(3, 100);
        myMath.add(0, -2);
        myMath.add(-999, 33);
        myMath.add(-999, 1000);

        //verify 可以指定被呼叫的次數
        Mockito.verify(mockLogger, Mockito.times(expectCallTimes)).log(Mockito.anyString());
    }
}
