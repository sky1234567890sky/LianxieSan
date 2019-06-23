package com.example.lianxiesan;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v7.app.AppCompatActivity;
import android.widget.FrameLayout;
import android.widget.Toast;

import com.example.lianxiesan.api.SjBean;
import com.example.lianxiesan.dao.DaoUtil;
import com.example.lianxiesan.fragment.ShoucangFragment;
import com.example.lianxiesan.fragment.WodeFragment;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private TabLayout mTab;
    private ArrayList<Fragment> mFragments;
    private ArrayList<String> mList;
    private FrameLayout mFra;
    private WodeFragment mWodeFragment;
    private ShoucangFragment mShoucangFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        mTab = (TabLayout) findViewById(R.id.tab);
        mFra = (FrameLayout) findViewById(R.id.fra);

        mWodeFragment = new WodeFragment();
        mShoucangFragment = new ShoucangFragment();

        mTab.addTab(mTab.newTab().setText("我的"));
        mTab.addTab(mTab.newTab().setText("收藏"));

        getSupportFragmentManager().beginTransaction().add(R.id.fra,mWodeFragment).show(mWodeFragment).commit();
        getSupportFragmentManager().beginTransaction().add(R.id.fra,mShoucangFragment).hide(mShoucangFragment).commit();


        mTab.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                Toast.makeText(MainActivity.this, tab.getPosition()+"", Toast.LENGTH_SHORT).show();
                if (tab.getPosition()==0){
                    getSupportFragmentManager().beginTransaction().show(mWodeFragment).hide(mShoucangFragment).commit();

                }
                else {
                    getSupportFragmentManager().beginTransaction().show(mShoucangFragment).hide(mWodeFragment).commit();
                    ShoucangFragment.initxianshi();
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }

}
