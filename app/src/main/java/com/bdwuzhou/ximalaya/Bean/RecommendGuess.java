package com.bdwuzhou.ximalaya.Bean;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by BDwuzhou on 2016/10/19.
 */

public class RecommendGuess implements Recommend {

    private String title;
    private List<RecommendTwo> recommendTwoList;

    @Override
    public int getType() {
        return Recommend.TYPE_2;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<RecommendTwo> getRecommendTwoList() {
        return recommendTwoList;
    }

    public void setRecommendTwoList(List<RecommendTwo> recommendTwoList) {
        this.recommendTwoList = recommendTwoList;
    }
}
