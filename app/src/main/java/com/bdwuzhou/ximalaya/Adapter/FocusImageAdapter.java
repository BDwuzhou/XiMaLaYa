package com.bdwuzhou.ximalaya.Adapter;

import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by BDwuzhou on 2016/10/18.
 */

public class FocusImageAdapter extends PagerAdapter {

    private List<ImageView> mList = new ArrayList<>();

    public void setList(List<ImageView> list) {
        mList = list;
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return Integer.MAX_VALUE;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        if (mList.size() == 0) {
            return null;
        }
        ImageView ret = mList.get(position % mList.size());
        //添加之前进行移出
        ViewParent parent = ret.getParent();
        if (parent != null) {
            //ret所被添加的父容器 是 group
            ViewGroup group = (ViewGroup) parent;
            //移出，释放资源
            group.removeView(ret);
        }
        container.addView(ret);
        return ret;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
//        super.destroyItem(container, position, object);

    }
}
