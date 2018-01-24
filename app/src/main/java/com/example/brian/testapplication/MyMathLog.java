package com.example.brian.testapplication;

public class MyMathLog {

    private Logger logger;

    public MyMathLog(Logger logger){
        this.logger = logger;
    }

    public int add(int first, int second){
        int sum = first + second;
        if (sum < 0)
            logger.log(String.valueOf(sum));
        return first + second;
    }
}
