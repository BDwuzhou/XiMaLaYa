package com.bdwuzhou.ximalaya.Util;

import android.os.Handler;
import android.os.Message;

import java.io.IOException;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by BDwuzhou on 2016/10/17.
 */

public class HttpUtil {
    public static byte[] loadBytesFrmURL(String url) {
        OkHttpClient client = new OkHttpClient();
        try {
            Request request = new Request.Builder().url(url).build();
            Response response = client.newCall(request).execute();
            if (response.isSuccessful()) {
                return response.body().bytes();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void getNetData(final String path, final Handler handler) {
        new Thread(new Runnable() {

            @Override
            public void run() {
                OkHttpClient client = new OkHttpClient();
                Request request = new Request.Builder().url(path).build();
                try {
                    Response response = client.newCall(request).execute();
                    if (response.isSuccessful()) {
                        String result = new String(response.body().bytes(), "UTF-8");
                        Message message = handler.obtainMessage();
                        // TODO: 2016/10/18
                        message.what = 1;
                        message.obj = result;
                        handler.sendMessage(message);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }
}
