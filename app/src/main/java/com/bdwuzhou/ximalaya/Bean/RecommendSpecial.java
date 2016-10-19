package com.bdwuzhou.ximalaya.Bean;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by BDwuzhou on 2016/10/19.
 */

public class RecommendSpecial implements Recommend {

    private String title;
    private List<RecommendFour> recommendFourList;

    @Override
    public int getType() {
        return Recommend.TYPE_4;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<RecommendFour> getRecommendFourList() {
        return recommendFourList;
    }

    public void setRecommendFourList(List<RecommendFour> recommendFourList) {
        this.recommendFourList = recommendFourList;
    }
}
