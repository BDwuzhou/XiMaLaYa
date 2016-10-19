package com.bdwuzhou.ximalaya.AsyncTask;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.widget.ImageView;

import com.bdwuzhou.ximalaya.Util.HttpUtil;

/**
 * Created by BDwuzhou on 2016/10/17.
 */

public class ImageAsyncTask extends AsyncTask<String, Void, Bitmap> {

    private ImageView mImageView;

    public ImageAsyncTask(ImageView imageView) {
        mImageView = imageView;
    }

    @Override
    protected Bitmap doInBackground(String... params) {
        byte[] bytes = HttpUtil.loadBytesFrmURL(params[0]);
        return BitmapFactory.decodeByteArray(bytes, 0, bytes.length);
    }

    @Override
    protected void onPostExecute(Bitmap bitmap) {
        super.onPostExecute(bitmap);
        if (mImageView != null) {
            mImageView.setScaleType(ImageView.ScaleType.FIT_XY);
            mImageView.setImageBitmap(bitmap);
        }
    }
}
