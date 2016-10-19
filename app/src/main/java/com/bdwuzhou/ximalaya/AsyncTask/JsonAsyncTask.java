package com.bdwuzhou.ximalaya.AsyncTask;

import android.os.AsyncTask;

import com.bdwuzhou.ximalaya.Callback.OnMessageResult;
import com.bdwuzhou.ximalaya.Util.HttpUtil;

/**
 * Created by BDwuzhou on 2016/10/17.
 */

public class JsonAsyncTask extends AsyncTask<String, Void, String> {

    private OnMessageResult onMessageResult;

    public JsonAsyncTask(OnMessageResult onMessageResult) {
        this.onMessageResult = onMessageResult;
    }

    @Override
    protected String doInBackground(String... params) {
        byte[] bytes = HttpUtil.loadBytesFrmURL(params[0]);
        return new String(bytes);
    }

    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);
        if (onMessageResult != null) {
            onMessageResult.onMessageBack(s);
        }
    }
}
