package com.thefu.androidstudyproject.fragmentTest;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.widget.Button;
import android.widget.LinearLayout;

import com.thefu.androidstudyproject.R;

public class FragmentActivity extends AppCompatActivity {

    private Button frag_btn;
    private LinearLayout linearLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //静态加载
        setContentView(R.layout.activity_ftagment);
//        frag_btn = findViewById(R.id.frg_btn);
//        frag_btn.setOnClickListener(new View.OnClickListener() {
//
//            @Override
//            public void onClick(View view) {
//                Toast.makeText(FragmentActivity.this, "您点击了按钮", Toast.LENGTH_SHORT).show();
//            }
//        });
        linearLayout = findViewById(R.id.layout);

        //动态加载
        MyFragment fragment = new MyFragment();
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction beginTransacction = fragmentManager.beginTransaction();
        beginTransacction.add(R.id.layout, fragment); //把碎片放到布局的layout容器里面
        beginTransacction.addToBackStack(null); //允许用户通过按键返回前一个Fragment状态
        beginTransacction.commit();

    }
}