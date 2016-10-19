package com.bdwuzhou.ximalaya.Util;

import com.bdwuzhou.ximalaya.Bean.RecommendGuess;
import com.bdwuzhou.ximalaya.Bean.RecommendHot;
import com.bdwuzhou.ximalaya.Bean.RecommendThree;
import com.bdwuzhou.ximalaya.Bean.RecommendTwo;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by BDwuzhou on 2016/10/19.
 */

public class JsonRecommend2Util {
    public static List<RecommendGuess> parseRecommendGuessList(String data) {
        try {
            List<RecommendGuess> recommendGuessList = new ArrayList<>();
            RecommendGuess recommendGuess = new RecommendGuess();
            List<RecommendTwo> list = new ArrayList<>();
            JSONObject jsonObject = new JSONObject(data);
            JSONObject guessJsonObject = jsonObject.optJSONObject("guess");
            recommendGuess.setTitle(guessJsonObject.optString("title"));
            JSONArray guessJsonArray = guessJsonObject.optJSONArray("list");
            for (int i = 0; i < guessJsonArray.length(); i++) {
                JSONObject recommendTwoJsonObject = guessJsonArray.optJSONObject(i);
                RecommendTwo recommendTwo = new RecommendTwo();
                recommendTwo.setIntro(recommendTwoJsonObject.optString("intro"));
                recommendTwo.setCoverSmall(recommendTwoJsonObject.optString("coverMiddle"));
                recommendTwo.setTags(recommendTwoJsonObject.optString("tags"));
                list.add(recommendTwo);
            }
            recommendGuess.setRecommendTwoList(list);
            recommendGuessList.add(recommendGuess);
            return recommendGuessList;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static List<RecommendHot> parseRecommendHotList(String data) {
        try {
            List<RecommendHot> recommendHotList = new ArrayList<>();
            JSONObject jsonObject = new JSONObject(data);
            JSONObject hotJsonObject = jsonObject.optJSONObject("hotRecommends");
            JSONArray recommendHotJsonArray = hotJsonObject.optJSONArray("list");
            for (int i = 0; i < recommendHotJsonArray.length(); i++) {
                JSONObject recommendHotJsonObject = recommendHotJsonArray.optJSONObject(i);
                RecommendHot recommendHot = new RecommendHot();
                recommendHot.setTitle(recommendHotJsonObject.optString("title"));
                JSONArray recommendThreeJsonArray = recommendHotJsonObject.optJSONArray("list");
                List<RecommendThree> list = new ArrayList<>();
                for (int j = 0; j < recommendThreeJsonArray.length(); j++) {
                    JSONObject recommendThreeJsonObject = recommendThreeJsonArray.optJSONObject(j);
                    RecommendThree recommendThree = new RecommendThree();
                    recommendThree.setIntro(recommendThreeJsonObject.optString("intro"));
                    recommendThree.setTitle(recommendThreeJsonObject.optString("title"));
                    recommendThree.setCoverSmall(recommendThreeJsonObject.optString("coverMiddle"));
                    list.add(recommendThree);
                }
                recommendHot.setRecommendThreeList(list);
                recommendHotList.add(recommendHot);
            }
            return recommendHotList;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
