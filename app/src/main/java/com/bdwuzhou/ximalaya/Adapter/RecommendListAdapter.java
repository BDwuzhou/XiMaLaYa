package com.bdwuzhou.ximalaya.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bdwuzhou.ximalaya.Bean.Recommend;
import com.bdwuzhou.ximalaya.Bean.RecommendDiscovery;
import com.bdwuzhou.ximalaya.Bean.RecommendGuess;
import com.bdwuzhou.ximalaya.Bean.RecommendHot;
import com.bdwuzhou.ximalaya.Bean.RecommendSpecial;
import com.bdwuzhou.ximalaya.Helper.ImageCacheHelper;
import com.bdwuzhou.ximalaya.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by BDwuzhou on 2016/10/18.
 */
public class RecommendListAdapter extends BaseAdapter {

    private List<Recommend> mList;
    private Context mContext;
    private ImageCacheHelper mImageCacheHelper = ImageCacheHelper.getImageCacheHelper();

    public RecommendListAdapter(Context context) {
        mContext = context;
        mList = new ArrayList<>();
    }

    public void setList(List<Recommend> list) {
        mList = list;
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return mList != null ? mList.size() : 0;
    }

    @Override
    public Object getItem(int position) {
        return mList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public int getItemViewType(int position) {
        return mList.get(position).getType();
    }

    @Override
    public int getViewTypeCount() {
        return Recommend.TYPE_COUNT;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        //获取类型号
        int type = mList.get(position).getType();
        ViewHolder1 viewHolder1 = null;
        ViewHolder2 viewHolder2 = null;
        ViewHolder3 viewHolder3 = null;
        ViewHolder4 viewHolder4 = null;
        if (convertView == null) {
            switch (type) {
                case Recommend.TYPE_1:
                    viewHolder1 = new ViewHolder1();
                    convertView = LayoutInflater.from(mContext).inflate(R.layout.list_item_type1, parent, false);
                    viewHolder1.mTextView1 = (TextView) convertView.findViewById(R.id.tv1_discovery);
                    viewHolder1.mTextView2 = (TextView) convertView.findViewById(R.id.tv2_discovery);
                    viewHolder1.mTextView3 = (TextView) convertView.findViewById(R.id.tv3_discovery);
                    viewHolder1.mTextView4 = (TextView) convertView.findViewById(R.id.tv4_discovery);
                    viewHolder1.mTextView5 = (TextView) convertView.findViewById(R.id.tv5_discovery);
                    viewHolder1.mTextView6 = (TextView) convertView.findViewById(R.id.tv6_discovery);
                    viewHolder1.mTextView7 = (TextView) convertView.findViewById(R.id.tv7_discovery);
                    viewHolder1.mTextView8 = (TextView) convertView.findViewById(R.id.tv8_discovery);
                    viewHolder1.mTextView9 = (TextView) convertView.findViewById(R.id.tv9_discovery);
                    viewHolder1.mTextView10 = (TextView) convertView.findViewById(R.id.tv10_discovery);
                    viewHolder1.mImageView1 = (ImageView) convertView.findViewById(R.id.iv1_discovery);
                    viewHolder1.mImageView2 = (ImageView) convertView.findViewById(R.id.iv2_discovery);
                    viewHolder1.mImageView3 = (ImageView) convertView.findViewById(R.id.iv3_discovery);
                    viewHolder1.mImageView4 = (ImageView) convertView.findViewById(R.id.iv4_discovery);
                    viewHolder1.mImageView5 = (ImageView) convertView.findViewById(R.id.iv5_discovery);
                    viewHolder1.mImageView6 = (ImageView) convertView.findViewById(R.id.iv6_discovery);
                    viewHolder1.mImageView7 = (ImageView) convertView.findViewById(R.id.iv7_discovery);
                    viewHolder1.mImageView8 = (ImageView) convertView.findViewById(R.id.iv8_discovery);
                    viewHolder1.mImageView9 = (ImageView) convertView.findViewById(R.id.iv9_discovery);
                    viewHolder1.mImageView10 = (ImageView) convertView.findViewById(R.id.iv10_discovery);
                    convertView.setTag(viewHolder1);
                    break;
                case Recommend.TYPE_2:
                    viewHolder2 = new ViewHolder2();
                    convertView = LayoutInflater.from(mContext).inflate(R.layout.list_item_type2, parent, false);
                    viewHolder2.title1 = (TextView) convertView.findViewById(R.id.title_guess_1);
                    viewHolder2.title2 = (TextView) convertView.findViewById(R.id.title_guess_2);
                    viewHolder2.title3 = (TextView) convertView.findViewById(R.id.title_guess_3);
                    viewHolder2.title4 = (TextView) convertView.findViewById(R.id.title_guess_4);
                    viewHolder2.title5 = (TextView) convertView.findViewById(R.id.title_guess_5);
                    viewHolder2.title6 = (TextView) convertView.findViewById(R.id.title_guess_6);
                    viewHolder2.tag1 = (TextView) convertView.findViewById(R.id.tag_guess_1);
                    viewHolder2.tag2 = (TextView) convertView.findViewById(R.id.tag_guess_2);
                    viewHolder2.tag3 = (TextView) convertView.findViewById(R.id.tag_guess_3);
                    viewHolder2.tag4 = (TextView) convertView.findViewById(R.id.tag_guess_4);
                    viewHolder2.tag5 = (TextView) convertView.findViewById(R.id.tag_guess_5);
                    viewHolder2.tag6 = (TextView) convertView.findViewById(R.id.tag_guess_6);
                    viewHolder2.cover1 = (ImageView) convertView.findViewById(R.id.cover_guess_1);
                    viewHolder2.cover2 = (ImageView) convertView.findViewById(R.id.cover_guess_2);
                    viewHolder2.cover3 = (ImageView) convertView.findViewById(R.id.cover_guess_3);
                    viewHolder2.cover4 = (ImageView) convertView.findViewById(R.id.cover_guess_4);
                    viewHolder2.cover5 = (ImageView) convertView.findViewById(R.id.cover_guess_5);
                    viewHolder2.cover6 = (ImageView) convertView.findViewById(R.id.cover_guess_6);
                    convertView.setTag(viewHolder2);
                    break;
                case Recommend.TYPE_3:
                    viewHolder3 = new ViewHolder3();
                    convertView = LayoutInflater.from(mContext).inflate(R.layout.list_item_type3, parent, false);
                    viewHolder3.mTitle = (TextView) convertView.findViewById(R.id.tv_title);
                    viewHolder3.title1 = (TextView) convertView.findViewById(R.id.title_1);
                    viewHolder3.title2 = (TextView) convertView.findViewById(R.id.title_2);
                    viewHolder3.title3 = (TextView) convertView.findViewById(R.id.title_3);
                    viewHolder3.tag1 = (TextView) convertView.findViewById(R.id.tag_1);
                    viewHolder3.tag2 = (TextView) convertView.findViewById(R.id.tag_2);
                    viewHolder3.tag3 = (TextView) convertView.findViewById(R.id.tag_3);
                    viewHolder3.cover1 = (ImageView) convertView.findViewById(R.id.cover_1);
                    viewHolder3.cover2 = (ImageView) convertView.findViewById(R.id.cover_2);
                    viewHolder3.cover3 = (ImageView) convertView.findViewById(R.id.cover_3);
                    convertView.setTag(viewHolder3);
                    break;
                case Recommend.TYPE_4:
                    viewHolder4 = new ViewHolder4();
                    convertView = LayoutInflater.from(mContext).inflate(R.layout.list_item_type4, parent, false);
                    viewHolder4.mImageView1 = (ImageView) convertView.findViewById(R.id.cover_good_1);
                    viewHolder4.mImageView2 = (ImageView) convertView.findViewById(R.id.cover_good_2);
                    viewHolder4.title1 = (TextView) convertView.findViewById(R.id.title_good_1);
                    viewHolder4.title2 = (TextView) convertView.findViewById(R.id.title_good_2);
                    viewHolder4.subTitle1 = (TextView) convertView.findViewById(R.id.subtitle_good_1);
                    viewHolder4.subTitle2 = (TextView) convertView.findViewById(R.id.subtitle_good_2);
                    viewHolder4.tag1 = (TextView) convertView.findViewById(R.id.tag_good_1);
                    viewHolder4.tag2 = (TextView) convertView.findViewById(R.id.tag_good_2);
                    convertView.setTag(viewHolder4);
                    break;
            }
        } else {
            switch (type) {
                case Recommend.TYPE_1:
                    viewHolder1 = (ViewHolder1) convertView.getTag();
                    break;
                case Recommend.TYPE_2:
                    viewHolder2 = (ViewHolder2) convertView.getTag();
                    break;
                case Recommend.TYPE_3:
                    viewHolder3 = (ViewHolder3) convertView.getTag();
                    break;
                case Recommend.TYPE_4:
                    viewHolder4 = (ViewHolder4) convertView.getTag();
                    break;
            }
        }
        //设置数据
        switch (type) {
            case Recommend.TYPE_1:
                RecommendDiscovery recommendDiscovery = (RecommendDiscovery) mList.get(position);
                viewHolder1.mTextView1.setText(recommendDiscovery.getRecommendOneList().get(0).getTitle());
                viewHolder1.mTextView2.setText(recommendDiscovery.getRecommendOneList().get(1).getTitle());
                viewHolder1.mTextView3.setText(recommendDiscovery.getRecommendOneList().get(2).getTitle());
                viewHolder1.mTextView4.setText(recommendDiscovery.getRecommendOneList().get(3).getTitle());
                viewHolder1.mTextView5.setText(recommendDiscovery.getRecommendOneList().get(4).getTitle());
                viewHolder1.mTextView6.setText(recommendDiscovery.getRecommendOneList().get(5).getTitle());
                viewHolder1.mTextView7.setText(recommendDiscovery.getRecommendOneList().get(6).getTitle());
                viewHolder1.mTextView8.setText(recommendDiscovery.getRecommendOneList().get(7).getTitle());
                viewHolder1.mTextView9.setText(recommendDiscovery.getRecommendOneList().get(8).getTitle());
                viewHolder1.mTextView10.setText(recommendDiscovery.getRecommendOneList().get(9).getTitle());
                mImageCacheHelper.loadImage(recommendDiscovery.getRecommendOneList().get(0).getCoverPath(), viewHolder1.mImageView1);
                mImageCacheHelper.loadImage(recommendDiscovery.getRecommendOneList().get(1).getCoverPath(), viewHolder1.mImageView2);
                mImageCacheHelper.loadImage(recommendDiscovery.getRecommendOneList().get(2).getCoverPath(), viewHolder1.mImageView3);
                mImageCacheHelper.loadImage(recommendDiscovery.getRecommendOneList().get(3).getCoverPath(), viewHolder1.mImageView4);
                mImageCacheHelper.loadImage(recommendDiscovery.getRecommendOneList().get(4).getCoverPath(), viewHolder1.mImageView5);
                mImageCacheHelper.loadImage(recommendDiscovery.getRecommendOneList().get(5).getCoverPath(), viewHolder1.mImageView6);
                mImageCacheHelper.loadImage(recommendDiscovery.getRecommendOneList().get(6).getCoverPath(), viewHolder1.mImageView7);
                mImageCacheHelper.loadImage(recommendDiscovery.getRecommendOneList().get(7).getCoverPath(), viewHolder1.mImageView8);
                mImageCacheHelper.loadImage(recommendDiscovery.getRecommendOneList().get(8).getCoverPath(), viewHolder1.mImageView9);
                mImageCacheHelper.loadImage(recommendDiscovery.getRecommendOneList().get(9).getCoverPath(), viewHolder1.mImageView10);
                break;
            case Recommend.TYPE_2:
                RecommendGuess recommendGuess = (RecommendGuess) mList.get(position);
                viewHolder2.title1.setText(recommendGuess.getRecommendTwoList().get(0).getIntro());
                viewHolder2.title2.setText(recommendGuess.getRecommendTwoList().get(1).getIntro());
                viewHolder2.title3.setText(recommendGuess.getRecommendTwoList().get(2).getIntro());
                viewHolder2.title4.setText(recommendGuess.getRecommendTwoList().get(3).getIntro());
                viewHolder2.title5.setText(recommendGuess.getRecommendTwoList().get(4).getIntro());
                viewHolder2.title6.setText(recommendGuess.getRecommendTwoList().get(5).getIntro());
                viewHolder2.tag1.setText(recommendGuess.getRecommendTwoList().get(0).getTags());
                viewHolder2.tag2.setText(recommendGuess.getRecommendTwoList().get(1).getTags());
                viewHolder2.tag3.setText(recommendGuess.getRecommendTwoList().get(2).getTags());
                viewHolder2.tag4.setText(recommendGuess.getRecommendTwoList().get(3).getTags());
                viewHolder2.tag5.setText(recommendGuess.getRecommendTwoList().get(4).getTags());
                viewHolder2.tag6.setText(recommendGuess.getRecommendTwoList().get(5).getTags());
                mImageCacheHelper.loadImage(recommendGuess.getRecommendTwoList().get(0).getCoverSmall(), viewHolder2.cover1);
                mImageCacheHelper.loadImage(recommendGuess.getRecommendTwoList().get(1).getCoverSmall(), viewHolder2.cover2);
                mImageCacheHelper.loadImage(recommendGuess.getRecommendTwoList().get(2).getCoverSmall(), viewHolder2.cover3);
                mImageCacheHelper.loadImage(recommendGuess.getRecommendTwoList().get(3).getCoverSmall(), viewHolder2.cover4);
                mImageCacheHelper.loadImage(recommendGuess.getRecommendTwoList().get(4).getCoverSmall(), viewHolder2.cover5);
                mImageCacheHelper.loadImage(recommendGuess.getRecommendTwoList().get(5).getCoverSmall(), viewHolder2.cover6);
                break;
            case Recommend.TYPE_3:
                RecommendHot recommendHot = (RecommendHot) mList.get(position);
                viewHolder3.mTitle.setText(recommendHot.getTitle());
                viewHolder3.title1.setText(recommendHot.getRecommendThreeList().get(0).getIntro());
                viewHolder3.title2.setText(recommendHot.getRecommendThreeList().get(1).getIntro());
                viewHolder3.title3.setText(recommendHot.getRecommendThreeList().get(2).getIntro());
                viewHolder3.tag1.setText(recommendHot.getRecommendThreeList().get(0).getTitle());
                viewHolder3.tag2.setText(recommendHot.getRecommendThreeList().get(1).getTitle());
                viewHolder3.tag3.setText(recommendHot.getRecommendThreeList().get(2).getTitle());
                mImageCacheHelper.loadImage(recommendHot.getRecommendThreeList().get(0).getCoverSmall(), viewHolder3.cover1);
                mImageCacheHelper.loadImage(recommendHot.getRecommendThreeList().get(1).getCoverSmall(), viewHolder3.cover2);
                mImageCacheHelper.loadImage(recommendHot.getRecommendThreeList().get(2).getCoverSmall(), viewHolder3.cover3);
                break;
            case Recommend.TYPE_4:
                RecommendSpecial recommendSpecial = (RecommendSpecial) mList.get(position);
                viewHolder4.title1.setText(recommendSpecial.getRecommendFourList().get(0).getTitle());
                viewHolder4.title2.setText(recommendSpecial.getRecommendFourList().get(1).getTitle());
                viewHolder4.subTitle1.setText(recommendSpecial.getRecommendFourList().get(0).getSubtitle());
                viewHolder4.subTitle2.setText(recommendSpecial.getRecommendFourList().get(1).getSubtitle());
                viewHolder4.tag1.setText(recommendSpecial.getRecommendFourList().get(0).getFootnote());
                viewHolder4.tag2.setText(recommendSpecial.getRecommendFourList().get(1).getFootnote());
                mImageCacheHelper.loadImage(recommendSpecial.getRecommendFourList().get(0).getCoverPath(), viewHolder4.mImageView1);
                mImageCacheHelper.loadImage(recommendSpecial.getRecommendFourList().get(1).getCoverPath(), viewHolder4.mImageView2);
                break;
        }
        return convertView;
    }

    private class ViewHolder1 {
        ImageView mImageView1, mImageView2, mImageView3, mImageView4, mImageView5, mImageView6, mImageView7, mImageView8, mImageView9, mImageView10;
        TextView mTextView1, mTextView2, mTextView3, mTextView4, mTextView5, mTextView6, mTextView7, mTextView8, mTextView9, mTextView10;
    }

    private class ViewHolder2 {
        ImageView cover1, cover2, cover3, cover4, cover5, cover6;
        TextView title1, title2, title3, title4, title5, title6, tag1, tag2, tag3, tag4, tag5, tag6;
    }

    private class ViewHolder3 {
        ImageView cover1, cover2, cover3;
        TextView mTitle, title1, title2, title3, tag1, tag2, tag3;
    }

    private class ViewHolder4 {
        ImageView mImageView1, mImageView2;
        TextView title1, title2, subTitle1, subTitle2, tag1, tag2;
    }
}