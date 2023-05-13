package com.thefu.androidstudyproject;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.thefu.androidstudyproject.VPFragment.VPFragmentBottomActivity;
import com.thefu.androidstudyproject.fileTest.FileActivity;
import com.thefu.androidstudyproject.fragmentTest.FragmentActivity;
import com.thefu.androidstudyproject.lifecycles.LifecycleActivity;
import com.thefu.androidstudyproject.mvptest.UserActivity;
import com.thefu.androidstudyproject.roomTest.RoomActivity;
import com.thefu.androidstudyproject.transitionDrawable.TransitionDrawableActivity;
import com.thefu.androidstudyproject.viewmodel.VmTestActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private Button navigation_bar;
    private Button transition_btn;
    private Button file_btn;
    private Button frag_btn;
    private Button mvp_btn;
    private Button viewModel_btn;
    private Button lifecycle_btn;
    private Button room_btn;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        navigation_bar = findViewById(R.id.navigation_bar_btn);
        transition_btn = findViewById(R.id.transition_btn);
        file_btn = findViewById(R.id.file_btn);
        frag_btn = findViewById(R.id.Fragment_btn);
        mvp_btn = findViewById(R.id.mvp_btn);
        viewModel_btn = findViewById(R.id.viewModel_btn);
        lifecycle_btn = findViewById(R.id.lifecycle_btn);
        room_btn = findViewById(R.id.room_btn);

        navigation_bar.setOnClickListener(this);
        transition_btn.setOnClickListener(this);
        file_btn.setOnClickListener(this);
        frag_btn.setOnClickListener(this);
        mvp_btn.setOnClickListener(this);
        viewModel_btn.setOnClickListener(this);
        lifecycle_btn.setOnClickListener(this);
        room_btn.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        Intent intent = null;
        switch (view.getId()) {
            //测试Viewpager+fragment
            case R.id.navigation_bar_btn:
                intent = new Intent(this, VPFragmentBottomActivity.class);
                break;
            case R.id.transition_btn:
                intent = new Intent(this, TransitionDrawableActivity.class);
                break;
                //测试文件管理
            case R.id.file_btn:
                intent = new Intent(this, FileActivity.class);
                break;
            case R.id.Fragment_btn:
                intent = new Intent(this, FragmentActivity.class);
                break;
            case R.id.mvp_btn:
                intent = new Intent(this, UserActivity.class);
                break;
            case R.id.viewModel_btn:
                intent = new Intent(this, VmTestActivity.class);
                break;
            case R.id.lifecycle_btn:
                intent = new Intent(this, LifecycleActivity.class);
                break;
            case R.id.room_btn:
                intent = new Intent(this, RoomActivity.class);
                break;
            default:
                intent = new Intent();
                break;
        }
        startActivity(intent);
    }
}