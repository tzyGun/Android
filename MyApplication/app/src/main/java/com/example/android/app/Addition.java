package com.example.android.app;

/**
 * Created by Sylwek on 19.03.2017.
 */


public class Addition  implements Operation{
    @Override
    public float calculate(float a, float b) {
        return a+b;
    }
}
