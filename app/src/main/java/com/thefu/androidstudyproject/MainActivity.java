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
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        navigation_bar = findViewById(R.id.navigation_bar_btn);
        navigation_bar.setOnClickListener(this);
        Log.d("|||||||||", String.valueOf(new Test().print_func(9)));
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.navigation_bar_btn:
                Intent intent = new Intent(this, VPFragmentBottomActivity.class);
                startActivity(intent);
        }
    }
}