package com.bdwuzhou.ximalaya.Bean;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by BDwuzhou on 2016/10/19.
 */

public class RecommendHot implements Recommend {

    private String title;
    private List<RecommendThree> mRecommendThreeList;

    @Override
    public int getType() {
        return Recommend.TYPE_3;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<RecommendThree> getRecommendThreeList() {
        return mRecommendThreeList;
    }

    public void setRecommendThreeList(List<RecommendThree> recommendThreeList) {
        mRecommendThreeList = recommendThreeList;
    }
}
