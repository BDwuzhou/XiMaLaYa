package com.bdwuzhou.ximalaya.Bean;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by BDwuzhou on 2016/10/19.
 */

public class RecommendDiscovery implements Recommend {

    private String title;
    private List<RecommendOne> recommendOneList;

    @Override
    public int getType() {
        return Recommend.TYPE_1;
    }

    public List<RecommendOne> getRecommendOneList() {
        return recommendOneList;
    }

    public void setRecommendOneList(List<RecommendOne> recommendOneList) {
        this.recommendOneList = recommendOneList;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
