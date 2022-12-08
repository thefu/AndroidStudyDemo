package com.thefu.androidstudyproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.thefu.androidstudyproject.VPFragment.VPFragmentBottomActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private Button navigation_bar;
    private Button transition_btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        navigation_bar = findViewById(R.id.navigation_bar_btn);
        transition_btn = findViewById(R.id.transition_btn);
        navigation_bar.setOnClickListener(this);
        transition_btn.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.navigation_bar_btn:
                Intent intent = new Intent(this, VPFragmentBottomActivity.class);
                startActivity(intent);
            case R.id.transition_btn:
                Intent intent_transition = new Intent(this, TransitionDrawableActivity.class);
                startActivity(intent_transition);
        }
    }
}