package com.example.android.app;

/**
 * Created by Sylwek on 19.03.2017.
 */

public class Division implements Operation {
    @Override
    public float calculate(float a, float b) {
        if(b!= 0){
            return a/b;
        }else {
            return 0;
        }
    }
}

