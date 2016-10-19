package com.bdwuzhou.ximalaya.Base;


import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bdwuzhou.ximalaya.Adapter.FindFragmentPagerAdapter;
import com.bdwuzhou.ximalaya.AsyncTask.JsonAsyncTask;
import com.bdwuzhou.ximalaya.Bean.FindTab;
import com.bdwuzhou.ximalaya.Callback.OnMessageResult;
import com.bdwuzhou.ximalaya.R;
import com.bdwuzhou.ximalaya.Util.JsonUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class FindFragment extends Fragment {

    private String url = "http://mobile.ximalaya.com/mobile/discovery/v1/tabs?device=android";

    private TabLayout mTabLayout;
    private ViewPager mViewPager;
    private List<Fragment> mFragments = new ArrayList<>();
    private List<FindTab> mFindTabs = new ArrayList<>();

    public FindFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View ret = inflater.inflate(R.layout.fragment_find, container, false);
        initView(ret);
        initFragment();
        initViewPager();
        initListener();
        return ret;
    }

    private void initListener() {
        mTabLayout.addOnTabSelectedListener(new TabLayout.ViewPagerOnTabSelectedListener(mViewPager));
        mViewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(mTabLayout));
    }

    private void initViewPager() {
        FindFragmentPagerAdapter adapter = new FindFragmentPagerAdapter(getChildFragmentManager());
        adapter.addList(mFragments);
        mViewPager.setAdapter(adapter);
    }

    private void initFragment() {
        mFragments.add(new RecommendFragment());
        mFragments.add(new CategoryFragment());
        mFragments.add(new LiveFragment());
        mFragments.add(new RankingFragment());
        mFragments.add(new AnchorFragment());
    }

    private void initView(View view) {
        mTabLayout = (TabLayout) view.findViewById(R.id.tab_find);
        mViewPager = (ViewPager) view.findViewById(R.id.vp_find);

        new JsonAsyncTask(new OnMessageResult() {
            @Override
            public void onMessageBack(String message) {
                mFindTabs.addAll(JsonUtil.paresFindTabList(message));
                Log.d("flag", "----------initView: " + mFindTabs.toString());
                for (int i = 0; i < mFindTabs.size(); i++) {
                    mTabLayout.addTab(mTabLayout.newTab().setText(mFindTabs.get(i).getTitle()));
                }
            }
        }).execute(url);
    }
}
