package com.bdwuzhou.ximalaya.AsyncTask;

import android.os.AsyncTask;

import com.bdwuzhou.ximalaya.Bean.Recommend;
import com.bdwuzhou.ximalaya.Callback.OnRecommendListResult;
import com.bdwuzhou.ximalaya.Util.HttpUtil;
import com.bdwuzhou.ximalaya.Util.JsonRecommend1Util;
import com.bdwuzhou.ximalaya.Util.JsonRecommend2Util;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by BDwuzhou on 2016/10/19.
 */

public class RecommendAsyncTask extends AsyncTask<String, Void, List<Recommend>> {

    private OnRecommendListResult mOnRecommendListResult;

    public RecommendAsyncTask(OnRecommendListResult onRecommendListResult) {
        this.mOnRecommendListResult = onRecommendListResult;
    }

    @Override
    protected List<Recommend> doInBackground(String... params) {
        List<Recommend> ret = new ArrayList<>();
        byte[] bytes1 = HttpUtil.loadBytesFrmURL(params[0]);
        byte[] bytes2 = HttpUtil.loadBytesFrmURL(params[1]);
        ret.addAll(JsonRecommend1Util.parseRecommendDiscoveryList(new String(bytes1)));
        ret.addAll(JsonRecommend2Util.parseRecommendGuessList(new String(bytes2)));
        ret.addAll(JsonRecommend1Util.parseRecommendHotList(new String(bytes1)));
        ret.addAll(JsonRecommend1Util.parseRecommendSpecialList(new String(bytes1)));
        ret.addAll(JsonRecommend2Util.parseRecommendHotList(new String(bytes2)));
        return ret;
    }

    @Override
    protected void onPostExecute(List<Recommend> list) {
        super.onPostExecute(list);
        if (list != null) {
            mOnRecommendListResult.onListBack(list);
        }
    }
}
