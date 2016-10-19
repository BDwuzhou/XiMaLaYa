package com.bdwuzhou.ximalaya.Callback;

import com.bdwuzhou.ximalaya.Bean.Recommend;

import java.util.List;

/**
 * Created by BDwuzhou on 2016/10/19.
 */

public interface OnRecommendListResult {
    void onListBack(List<Recommend> list);
}
