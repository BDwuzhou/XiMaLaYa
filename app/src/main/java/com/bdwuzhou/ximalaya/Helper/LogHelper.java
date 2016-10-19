package com.bdwuzhou.ximalaya.Helper;

import android.util.Log;

/**
 * Created by BDwuzhou on 2016/10/18.
 */

public class LogHelper {

    private static boolean isDebug = true;

    public static void i(String tag, Object log) {
        Log.i("flag", "----------info: " + tag + log.toString());
    }

    public static void d(String tag, Object log) {
        Log.d("flag", "----------debug: " + tag + log.toString());
    }

    public static void e(String tag, Object log) {
        Log.e("flag", "----------error: " + tag + log.toString());
    }
}
