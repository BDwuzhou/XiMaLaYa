package com.bdwuzhou.ximalaya.Adapter;

import android.content.Context;
import android.widget.ArrayAdapter;

import java.util.List;

/**
 * Created by BDwuzhou on 2016/10/18.
 */

public class TestAdapter extends ArrayAdapter<String> {

    public TestAdapter(Context context, int resource, int textViewResourceId, List<String> objects) {
        super(context, resource, textViewResourceId, objects);
    }
}
