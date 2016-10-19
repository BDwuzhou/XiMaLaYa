package com.bdwuzhou.ximalaya.Base;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;

import com.bdwuzhou.ximalaya.Adapter.RecommendListAdapter;
import com.bdwuzhou.ximalaya.Adapter.RecommendPagerAdapter;
import com.bdwuzhou.ximalaya.AsyncTask.ImageAsyncTask;
import com.bdwuzhou.ximalaya.AsyncTask.JsonAsyncTask;
import com.bdwuzhou.ximalaya.AsyncTask.RecommendAsyncTask;
import com.bdwuzhou.ximalaya.Bean.FocusImages;
import com.bdwuzhou.ximalaya.Bean.Recommend;
import com.bdwuzhou.ximalaya.Callback.OnRecommendListResult;
import com.bdwuzhou.ximalaya.Callback.OnMessageResult;
import com.bdwuzhou.ximalaya.Helper.LogHelper;
import com.bdwuzhou.ximalaya.R;
import com.bdwuzhou.ximalaya.Util.JsonUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class RecommendFragment extends Fragment {

    private String[] urls = new String[]{Constant.RECOMMEND_URL1, Constant.RECOMMEND_URL2, Constant.RECOMMEND_URL3};
    private ViewPager mViewPager;
    private LinearLayout mIndicator;
    private ListView mListView;
    private List<ImageView> mList = new ArrayList<>();
    private RecommendListAdapter mAdapter;
    //    private int currentPosition = Integer.MAX_VALUE / 2;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View ret = inflater.inflate(R.layout.fragment_recommend, container, false);
        initView(ret);
        initViewPagerData();
        initListView();
        return ret;
    }

    public RecommendFragment() {
        // Required empty public constructor
    }

    private void initViewPagerData() {
        new JsonAsyncTask(new OnMessageResult() {
            @Override
            public void onMessageBack(String message) {
                FocusImages focusImages = JsonUtil.parseFocusImage(message);
                List<FocusImages.ListBean> list = focusImages.getList();
                LogHelper.d("list", list.toString());
                for (int i = 0; i < list.size(); i++) {
                    ImageView imageView = new ImageView(getContext());
                    String picUrl = list.get(i).getPic();
                    LogHelper.d("picUrl" + (i + 1), picUrl);
                    new ImageAsyncTask(imageView).execute(picUrl);
                    mList.add(imageView);
                }
                LogHelper.d("mList", mList.toString());
                initViewPager(mList);
                initIndicator(mList);
                initListener();
            }
        }).execute(Constant.RECOMMEND_URL1);
    }

    private int lastIndicatorIndex = Integer.MAX_VALUE / 2;

    private void initListener() {
        mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                mIndicator.getChildAt(lastIndicatorIndex % mList.size()).setEnabled(true);
                mIndicator.getChildAt(position % mList.size()).setEnabled(false);
                lastIndicatorIndex = position % mList.size();
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    private void initIndicator(List<ImageView> list) {
        if (list != null) {
            for (int i = 0; i < list.size(); i++) {
                View indicator = new View(getContext());
                indicator.setBackgroundResource(R.drawable.indicator_header);
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(20, 20);
                layoutParams.leftMargin = 5;
                layoutParams.rightMargin = 5;
                layoutParams.gravity = Gravity.CENTER;
                indicator.setLayoutParams(layoutParams);
                mIndicator.addView(indicator);
            }
            mIndicator.getChildAt(0).setEnabled(false);
        }
    }

    private void initViewPager(List<ImageView> list) {
        RecommendPagerAdapter adapter = new RecommendPagerAdapter();
        adapter.setList(list);
        LogHelper.d("adapter", adapter.toString());
        LogHelper.d("mViewPager", mViewPager.toString());
        mViewPager.setAdapter(adapter);
    }

    private void initListView() {
        View headView = LayoutInflater.from(getContext()).inflate(R.layout.header_recommend, mListView, false);
        mViewPager = (ViewPager) headView.findViewById(R.id.vp_recommend);
        mIndicator = (LinearLayout) headView.findViewById(R.id.indicators);
        mListView.addHeaderView(headView);//添加头布局
        mAdapter = new RecommendListAdapter(getContext());
        initListData();
        mListView.setAdapter(mAdapter);
    }

    private void initListData() {
        new RecommendAsyncTask(new OnRecommendListResult() {
            @Override
            public void onListBack(List<Recommend> list) {
                mAdapter.setList(list);
            }
        }).execute(urls);
        LogHelper.d("adapter", mAdapter.toString());
    }

    private void initView(View view) {
        mListView = (ListView) view.findViewById(R.id.lv_recommend);
    }
}
