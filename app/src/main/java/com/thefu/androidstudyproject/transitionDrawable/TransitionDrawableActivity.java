package com.thefu.androidstudyproject.transitionDrawable;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.drawable.TransitionDrawable;
import android.os.Bundle;
import android.widget.ImageView;

import com.thefu.androidstudyproject.R;

public class TransitionDrawableActivity extends AppCompatActivity {

    private ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transition_drawable);
        imageView = findViewById(R.id.img_view);
        TransitionDrawable transitionDrawable = (TransitionDrawable) imageView.getDrawable();
        transitionDrawable.startTransition(3000);
        //也可以使用反过来播放，使用
//        transitionDrawable.reverseTransition(3000);

    }
}