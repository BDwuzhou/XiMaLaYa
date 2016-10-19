package com.bdwuzhou.ximalaya.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.bdwuzhou.ximalaya.CustomView.MyGridView;
import com.bdwuzhou.ximalaya.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by BDwuzhou on 2016/10/19.
 */

public class CategoryListAdapter extends BaseAdapter {

    private Context mContext;
    private List<ArrayList<HashMap<String, Object>>> mList;

    public CategoryListAdapter(Context context) {
        mContext = context;
        mList = new ArrayList<>();
    }

    public void setList(List<ArrayList<HashMap<String, Object>>> list) {
        mList = list;
    }

    @Override
    public int getCount() {
        return mList != null ? mList.size() : 0;
    }

    @Override
    public Object getItem(int position) {
        return mList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder = null;
        if (convertView == null) {
            viewHolder = new ViewHolder();
            convertView = LayoutInflater.from(mContext).inflate(R.layout.list_item_category, parent, false);
            viewHolder.mGridView = (MyGridView) convertView.findViewById(R.id.gv_category);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        if (this.mList != null) {
            if (viewHolder.mGridView != null) {
                ArrayList<HashMap<String, Object>> list = mList.get(position);
                CategoryGridAdapter gridViewAdapter = new CategoryGridAdapter(mContext);
                gridViewAdapter.setList(list);
                viewHolder.mGridView.setAdapter(gridViewAdapter);
            }
        }
        return convertView;
    }

    private class ViewHolder {
        private MyGridView mGridView;
    }
}
