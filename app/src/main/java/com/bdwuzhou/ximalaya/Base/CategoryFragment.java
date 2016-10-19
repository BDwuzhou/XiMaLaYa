package com.bdwuzhou.ximalaya.Base;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.bdwuzhou.ximalaya.Adapter.CategoryListAdapter;
import com.bdwuzhou.ximalaya.AsyncTask.CategoryAsyncTask;
import com.bdwuzhou.ximalaya.Bean.Category;
import com.bdwuzhou.ximalaya.Callback.OnCategoryListResult;
import com.bdwuzhou.ximalaya.Helper.LogHelper;
import com.bdwuzhou.ximalaya.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class CategoryFragment extends Fragment {

    private ListView mListView;
    private List<ArrayList<HashMap<String, Object>>> mList = new ArrayList<>();
    private List<Category> mCategoryList = new ArrayList<>();

    public CategoryFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View ret = inflater.inflate(R.layout.fragment_category, container, false);
        initView(ret);
        initListView();
        return ret;
    }

    private void initListView() {

        CategoryListAdapter adapter = new CategoryListAdapter(getContext());
        adapter.setList(mList);
        initListData();
//        mListView.setAdapter(adapter);
    }

    private void initListData() {
        new CategoryAsyncTask(new OnCategoryListResult() {
            @Override
            public void onListBack(List<Category> list) {
                mCategoryList.addAll(list);
                LogHelper.d("mCategory", mCategoryList);
            }
        }).execute(Constant.CATEGORY_URL);
        HashMap<String, Object> map;
        ArrayList<HashMap<String, Object>> listForEachGrid;
        // TODO: 2016/10/19  初始化数据
        for (int i = 0; i < 10; i++) {
            listForEachGrid = new ArrayList<>();
            for (int j = 0; j < mCategoryList.size(); j++) {
                map = new HashMap<>();
                map.put("title", mCategoryList.get(j).getTitle());
                listForEachGrid.add(map);
            }
            mList.add(listForEachGrid);
        }
    }

    private void initView(View view) {
        mListView = (ListView) view.findViewById(R.id.lv_category);
    }
}
