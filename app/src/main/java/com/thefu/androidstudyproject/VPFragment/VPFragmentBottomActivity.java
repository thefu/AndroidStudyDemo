package com.thefu.androidstudyproject.VPFragment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.thefu.androidstudyproject.R;

import java.util.ArrayList;
import java.util.List;

public class VPFragmentBottomActivity extends AppCompatActivity implements View.OnClickListener{

    private ViewPager mViewpager;
    private ImageView ivHome, ivFind, ivMine;
    private TextView tvHome, tvFind, tvMine;
    private LinearLayout llHome, llFind, llMine;

    private MyFragmentVPAdapter myFragmentVPAdapter;
    private List<Fragment> mFragmentList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vpfragment_bottom);

        initView();
        initData();

        myFragmentVPAdapter = new MyFragmentVPAdapter(getSupportFragmentManager(), mFragmentList);

        mViewpager.setAdapter(myFragmentVPAdapter);
        mViewpager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                onViewPagerSelected(position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

        onViewPagerSelected(0);
        llHome.setOnClickListener(this);
        llFind.setOnClickListener(this);
        llMine.setOnClickListener(this);


    }

    private void onViewPagerSelected(int position) {
        resetBottomStatus();
        switch (position) {
            case 0:
                ivHome.setSelected(true);
                tvHome.setTextColor(getResources().getColor(R.color.purple_500));
                break;
            case 1:
                ivFind.setSelected(true);
                tvFind.setTextColor(getResources().getColor(R.color.purple_500));
                break;
            case 2:
                ivMine.setSelected(true);
                tvMine.setTextColor(getResources().getColor(R.color.purple_500));
                break;
        }
    }

    private void resetBottomStatus() {
        ivHome.setSelected(false);
        tvHome.setTextColor(getResources().getColor(R.color.grey));
        ivFind.setSelected(false);
        tvFind.setTextColor(getResources().getColor(R.color.grey));
        ivMine.setSelected(false);
        tvMine.setTextColor(getResources().getColor(R.color.grey));
    }

    private void initData() {
        mFragmentList = new ArrayList<>();

        VPFragment fragmentHome = VPFragment.newInstance("首页", "");
        VPFragment fragmentFind = VPFragment.newInstance("发现", "");
        VPFragment fragmentMine = VPFragment.newInstance("我的", "");

        mFragmentList.add(fragmentHome);
        mFragmentList.add(fragmentFind);
        mFragmentList.add(fragmentMine);

    }

    private void initView() {
        mViewpager = findViewById(R.id.vp);
        llHome = findViewById(R.id.ll_home);
        llFind = findViewById(R.id.ll_find);
        llMine = findViewById(R.id.ll_mine);

        ivFind = findViewById(R.id.iv_find);
        ivHome = findViewById(R.id.iv_home);
        ivMine = findViewById(R.id.iv_mine);

        tvFind = findViewById(R.id.tv_find);
        tvHome = findViewById(R.id.tv_home);
        tvMine = findViewById(R.id.tv_mine);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.ll_home:
                mViewpager.setCurrentItem(0);
                break;
            case R.id.ll_find:
                mViewpager.setCurrentItem(1);
                break;
            case R.id.ll_mine:
                mViewpager.setCurrentItem(2);
                break;
        }

    }
}