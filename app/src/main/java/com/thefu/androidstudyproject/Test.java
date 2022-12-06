package com.thefu.androidstudyproject;

public class Test {
    static {
        System.loadLibrary("test");
    }

    public  native int print_func(int n);
}
