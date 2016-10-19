package com.bdwuzhou.ximalaya.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bdwuzhou.ximalaya.R;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by BDwuzhou on 2016/10/19.
 */

public class CategoryGridAdapter extends BaseAdapter {

    private Context mContext;

    private ArrayList<HashMap<String, Object>> mList;

    public CategoryGridAdapter(Context context) {
        mContext = context;
        mList = new ArrayList<>();
    }

    public void setList(ArrayList<HashMap<String, Object>> list) {
        mList = list;
        notifyDataSetChanged();
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
            convertView = LayoutInflater.from(mContext).inflate(R.layout.grid_item_type1, parent, false);
            viewHolder.mImageView = (ImageView) convertView.findViewById(R.id.iv_grid_category);
            viewHolder.mTextView = (TextView) convertView.findViewById(R.id.tv_grid_category);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        if (mList != null) {
            HashMap<String, Object> map = mList.get(position);
            viewHolder.mTextView.setText(map.get("title").toString());
        }

        return convertView;
    }

    private class ViewHolder {
        ImageView mImageView;
        TextView mTextView;
    }
}
