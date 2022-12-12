package com.thefu.androidstudyproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.thefu.androidstudyproject.VPFragment.VPFragmentBottomActivity;

import java.io.File;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private Button navigation_bar;
    private Button transition_btn;
    private Button file_btn;
    private Button frag_btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        navigation_bar = findViewById(R.id.navigation_bar_btn);
        transition_btn = findViewById(R.id.transition_btn);
        file_btn = findViewById(R.id.file_btn);
        frag_btn = findViewById(R.id.Fragment_btn);
        navigation_bar.setOnClickListener(this);
        transition_btn.setOnClickListener(this);
        file_btn.setOnClickListener(this);
        frag_btn.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        Intent intent = null;
        switch (view.getId()) {
            case R.id.navigation_bar_btn:
                intent = new Intent(this, VPFragmentBottomActivity.class);
                break;
            case R.id.transition_btn:
                intent = new Intent(this, TransitionDrawableActivity.class);
                break;
            case R.id.file_btn:
                intent = new Intent(this, FileActivity.class);
                break;
            case R.id.Fragment_btn:
                intent = new Intent(this, FragmentActivity.class);
                break;
            default:
                intent = new Intent();
                break;
        }
        startActivity(intent);
    }
}