package com.bdwuzhou.ximalaya.Adapter;

import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by BDwuzhou on 2016/10/17.
 */
public class RecommendPagerAdapter extends PagerAdapter {

    private List<ImageView> mList;

    public RecommendPagerAdapter() {
        mList = new ArrayList<>();
    }

    public void setList(List<ImageView> list) {
        mList = list;
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
//        return mList.size() != 0 ? mList.size() : 0;
        return Integer.MAX_VALUE;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        ImageView ret = mList.get(position % mList.size());
        ViewParent parent = ret.getParent();
        if (parent != null) {
            ViewGroup group = (ViewGroup) parent;
            group.removeView(ret);
        }
        container.addView(ret);
        return ret;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
//        super.destroyItem(container, position, object);
//        container.removeView(mList.get(position));
    }
}
