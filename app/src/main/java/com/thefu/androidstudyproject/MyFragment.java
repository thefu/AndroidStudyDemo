package com.thefu.androidstudyproject;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


public class MyFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        /**
         * resource：fragment需要加载的布局支持
         * root：加载layout的父ViewGroup
         * attachGroup：false表示不反悔父ViewGroup
         */
        return inflater.inflate(R.layout.fragment_my, container, false);
    }
}