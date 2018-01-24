package com.example.brian.testapplication;

/**
 * Created by Brian_Hsu on 2018/1/22.
 */

class UserInfo {
    private String mName;
    private int mAge;
    private String mLocation;

    public UserInfo(String name, int age, String location) {
        mName = name;
        mAge = age;
        mLocation = location;
    }

    public String getName() {
        return mName;
    }

    public int getAge() {
        return mAge;
    }

    public String getLocation() {
        return mLocation;
    }
}
