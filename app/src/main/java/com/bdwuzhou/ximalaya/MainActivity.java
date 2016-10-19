package com.bdwuzhou.ximalaya;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.widget.RadioGroup;

import com.bdwuzhou.ximalaya.Base.FindFragment;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RadioGroup mRadioGroup;
    private List<Fragment> mFragments;
    private Fragment mFragment_find;
    private FragmentTransaction mTransaction;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initFragment();
        initView();
    }

    private void initView() {
        mRadioGroup = (RadioGroup) findViewById(R.id.tab_bottom);
        mRadioGroup.check(R.id.rb_main_find);
        mRadioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                // TODO: 2016/10/17
                switch (checkedId) {
                    case R.id.rb_main_find:

                        break;
                    case R.id.rb_main_subscribe:

                        break;
                }
            }
        });
    }

    private void initFragment() {
        mTransaction = getSupportFragmentManager().beginTransaction();
        mFragment_find = new FindFragment();
        mTransaction.add(R.id.fragments, mFragment_find, "find").show(mFragment_find).commit();
    }
}
