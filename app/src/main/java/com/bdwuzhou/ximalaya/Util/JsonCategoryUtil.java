package com.bdwuzhou.ximalaya.Util;

import com.bdwuzhou.ximalaya.Bean.Category;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by BDwuzhou on 2016/10/19.
 */

public class JsonCategoryUtil {
    public static List<Category> parseCategoryList(String data) {
        List<Category> categoryList = new ArrayList<>();
        try {
            JSONObject jsonObject = new JSONObject(data);
            JSONArray categoryJsonArray = jsonObject.optJSONArray("list");
            for (int i = 0; i < categoryJsonArray.length(); i++) {
                JSONObject categoryJsonObject = categoryJsonArray.optJSONObject(i);
                Category category = new Category();
                category.setTitle(categoryJsonObject.optString("title"));
                category.setCoverPath(categoryJsonObject.optString("coverPath"));
                categoryList.add(category);
            }
            return categoryList;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
