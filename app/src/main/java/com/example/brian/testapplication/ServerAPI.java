package com.example.brian.testapplication;

import java.util.concurrent.TimeUnit;

/**
 * Created by Brian_Hsu on 2018/1/22.
 */

public class ServerAPI{

    public void login(String name, String pwd, final Callback callback){
        //這裡模擬實際上的操作
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                callback.onComplete(new UserInfo("john", 20, "Taipei city"));
            }
        }).start();
    }

    public interface Callback{
        void onComplete(UserInfo userInfo);
    }

}