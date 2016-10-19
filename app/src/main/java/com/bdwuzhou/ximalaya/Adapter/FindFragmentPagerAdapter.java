package com.bdwuzhou.ximalaya.Adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by BDwuzhou on 2016/10/17.
 */

public class FindFragmentPagerAdapter extends FragmentPagerAdapter {

    private List<Fragment> mList;

    public FindFragmentPagerAdapter(FragmentManager fm) {
        super(fm);
        mList = new ArrayList<>();
    }

    public void setList(List<Fragment> list) {
        mList = list;
        notifyDataSetChanged();
    }

    public void addList(List<Fragment> list) {
        mList.addAll(list);
        notifyDataSetChanged();
    }

    @Override
    public Fragment getItem(int position) {
        return mList.get(position);
    }

    @Override
    public int getCount() {
        return mList != null ? mList.size() : 0;
    }
}
