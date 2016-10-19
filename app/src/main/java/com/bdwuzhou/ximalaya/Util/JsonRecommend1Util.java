package com.bdwuzhou.ximalaya.Util;

import com.bdwuzhou.ximalaya.Bean.RecommendDiscovery;
import com.bdwuzhou.ximalaya.Bean.RecommendFour;
import com.bdwuzhou.ximalaya.Bean.RecommendHot;
import com.bdwuzhou.ximalaya.Bean.RecommendOne;
import com.bdwuzhou.ximalaya.Bean.RecommendSpecial;
import com.bdwuzhou.ximalaya.Bean.RecommendThree;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by BDwuzhou on 2016/10/19.
 */

public class JsonRecommend1Util {
    public static List<RecommendDiscovery> parseRecommendDiscoveryList(String data) {
        try {
            List<RecommendDiscovery> recommendDiscoveryList = new ArrayList<>();
            RecommendDiscovery recommendDiscovery = new RecommendDiscovery();
            List<RecommendOne> list = new ArrayList<>();
            JSONObject jsonObject = new JSONObject(data);
            JSONObject discoveryColumnJsonObject = jsonObject.optJSONObject("discoveryColumns");
            recommendDiscovery.setTitle(discoveryColumnJsonObject.optString("title"));
            JSONArray discoveryColumnsJsonArray = discoveryColumnJsonObject.optJSONArray("list");
            for (int i = 0; i < discoveryColumnsJsonArray.length(); i++) {
                JSONObject recommendOneJsonObject = discoveryColumnsJsonArray.optJSONObject(i);
                RecommendOne recommendOne = new RecommendOne();
                recommendOne.setTitle(recommendOneJsonObject.optString("title"));
                recommendOne.setCoverPath(recommendOneJsonObject.optString("coverPath"));
                list.add(recommendOne);
            }
            recommendDiscovery.setRecommendOneList(list);
            recommendDiscoveryList.add(recommendDiscovery);
            return recommendDiscoveryList;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static List<RecommendHot> parseRecommendHotList(String data) {
        List<RecommendHot> recommendHotList = new ArrayList<>();
        try {
            RecommendHot recommendHot = new RecommendHot();
            JSONObject jsonObject = new JSONObject(data);
            JSONObject recommendHotJsonObject = jsonObject.optJSONObject("editorRecommendAlbums");
            recommendHot.setTitle(recommendHotJsonObject.optString("title"));
            JSONArray recommendThreeJsonArray = recommendHotJsonObject.optJSONArray("list");
            List<RecommendThree> list = new ArrayList<>();
            for (int i = 0; i < recommendThreeJsonArray.length(); i++) {
                JSONObject recommendThreeJsonObject = recommendThreeJsonArray.optJSONObject(i);
                RecommendThree recommendThree = new RecommendThree();
                recommendThree.setTitle(recommendThreeJsonObject.optString("title"));
                recommendThree.setIntro(recommendThreeJsonObject.optString("intro"));
                recommendThree.setCoverSmall(recommendThreeJsonObject.optString("coverMiddle"));
                list.add(recommendThree);
            }
            recommendHot.setRecommendThreeList(list);
            recommendHotList.add(recommendHot);
            return recommendHotList;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static List<RecommendSpecial> parseRecommendSpecialList(String data) {
        try {
            List<RecommendSpecial> recommendSpecialList = new ArrayList<>();
            RecommendSpecial recommendSpecial = new RecommendSpecial();
            List<RecommendFour> list = new ArrayList<>();
            JSONObject jsonObject = new JSONObject(data);
            JSONObject specialJsonObject = jsonObject.optJSONObject("specialColumn");
            recommendSpecial.setTitle(specialJsonObject.optString("title"));
            JSONArray recommendFourList = specialJsonObject.optJSONArray("list");
            for (int i = 0; i < recommendFourList.length(); i++) {
                JSONObject recommendFourJsonObject = recommendFourList.optJSONObject(i);
                RecommendFour recommendFour = new RecommendFour();
                recommendFour.setTitle(recommendFourJsonObject.optString("title"));
                recommendFour.setSubtitle(recommendFourJsonObject.optString("subtitle"));
                recommendFour.setFootnote(recommendFourJsonObject.optString("footnote"));
                recommendFour.setCoverPath(recommendFourJsonObject.optString("coverPath"));
                list.add(recommendFour);
            }
            recommendSpecial.setRecommendFourList(list);
            recommendSpecialList.add(recommendSpecial);
            return recommendSpecialList;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
