package com.bdwuzhou.ximalaya.AsyncTask;

import android.os.AsyncTask;

import com.bdwuzhou.ximalaya.Bean.Category;
import com.bdwuzhou.ximalaya.Callback.OnCategoryListResult;
import com.bdwuzhou.ximalaya.Util.HttpUtil;
import com.bdwuzhou.ximalaya.Util.JsonCategoryUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by BDwuzhou on 2016/10/19.
 */

public class CategoryAsyncTask extends AsyncTask<String, Void, List<Category>> {

    private OnCategoryListResult onCategoryListResult;

    public CategoryAsyncTask(OnCategoryListResult onCategoryListResult) {
        this.onCategoryListResult = onCategoryListResult;
    }

    @Override
    protected List<Category> doInBackground(String... params) {
        List<Category> ret = new ArrayList<>();
        byte[] bytes = HttpUtil.loadBytesFrmURL(params[0]);
        ret.addAll(JsonCategoryUtil.parseCategoryList(new String(bytes)));
        return ret;
    }

    @Override
    protected void onPostExecute(List<Category> categories) {
        super.onPostExecute(categories);
        if (categories != null) {
            onCategoryListResult.onListBack(categories);
        }
    }
}
