package com.bdwuzhou.ximalaya.Util;

import android.util.Log;

import com.bdwuzhou.ximalaya.Bean.FindTab;
import com.bdwuzhou.ximalaya.Bean.FocusImages;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by BDwuzhou on 2016/10/17.
 */

public class JsonUtil {
    public static List<FindTab> paresFindTabList(String data) {
        List<FindTab> ret = new ArrayList<>();
        try {
            JSONObject jsonObject = new JSONObject(data);
            JSONObject tabsJsonObject = jsonObject.optJSONObject("tabs");
            JSONArray tabsJsonArray = tabsJsonObject.optJSONArray("list");
            for (int i = 0; i < tabsJsonArray.length(); i++) {
                JSONObject tabJsonObject = tabsJsonArray.optJSONObject(i);
                FindTab findTab = new FindTab();
                findTab.setTitle(tabJsonObject.optString("title"));
                findTab.setContentType(tabJsonObject.optString("contentType"));
                ret.add(findTab);
            }
            Log.d("flag", "----------paresFindTabList: " + ret.toString());
            return ret;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static FocusImages parseFocusImage(String data) {
        FocusImages focusImages = new FocusImages();
        try {
            JSONObject jsonObject = new JSONObject(data);
            JSONObject focusImagesJsonObject = jsonObject.optJSONObject("focusImages");
            focusImages.setRet(focusImagesJsonObject.optInt("ret"));
            focusImages.setTitle(focusImagesJsonObject.optString("title"));

            JSONArray focusImageJsonArray = focusImagesJsonObject.optJSONArray("list");
            List<FocusImages.ListBean> listBeens = new ArrayList<>();
            for (int i = 0; i < focusImageJsonArray.length(); i++) {
                JSONObject focusImageJsonObject = focusImageJsonArray.optJSONObject(i);
                FocusImages.ListBean listBean = new FocusImages.ListBean();
                listBean.setId(focusImageJsonObject.optInt("id"));
                listBean.setShortTitle(focusImageJsonObject.optString("shortTitle"));
                listBean.setLongTitle(focusImageJsonObject.optString("longTitle"));
                listBean.setPic(focusImageJsonObject.optString("pic"));
                listBean.setType(focusImageJsonObject.optInt("type"));
                listBean.setUid(focusImageJsonObject.optInt("uid"));
                listBean.setAlbumId(focusImageJsonObject.optInt("albumId"));
                listBean.setIsShare(focusImageJsonObject.optBoolean("isShare"));
                listBean.setIs_External_url(focusImageJsonObject.optBoolean("is_External_url"));

                listBeens.add(listBean);
            }
            focusImages.setList(listBeens);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return focusImages;
    }
}
