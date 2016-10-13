package com.example.mynewsclient.base.menudetail;

import java.util.ArrayList;

import com.example.mynewsclient.R;
import com.example.mynewsclient.base.BaseBottomButtonPager;
import com.example.mynewsclient.base.detailpager.BaseDetailPager;
import com.example.mynewsclient.domain.NewsData;
import com.example.mynewsclient.domain.NewsData.NewsTabData;
import com.viewpagerindicator.TabPageIndicator;

import android.app.Activity;
import android.opengl.Visibility;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.View;
import android.view.ViewGroup;

public class NewsDetailPager extends BaseMenuDetailPager {
    
	
	ArrayList<BaseDetailPager> mListDetailPager;
	ArrayList<NewsTabData> mListNewsTabData;
	TabPageIndicator  indicator;
	ViewPager detailViewPager;
	public NewsDetailPager(Activity activity,NewsData newsData) {
		super(activity,newsData);
		mListNewsTabData = mNewsData.data.get(0).children;
	}
	
	//供外部调用
	public void initData() {
		initViewPager();
		initIndicator();
		mListDetailPager = new ArrayList<BaseDetailPager>();
		for(int i=0;i<mListNewsTabData.size();i++)
		{
			BaseDetailPager pager= new BaseDetailPager(mActivity, mListNewsTabData.get(i));
			pager.initData();
		   mListDetailPager.add(pager);	
		}
	}
	
	private void initViewPager() {
		detailViewPager.setAdapter(new MyPagerAdapter());
		detailViewPager.setOnPageChangeListener(new OnPageChangeListener() {
			
			@Override
			public void onPageSelected(int arg0) {
				initData();
				
				
			}
			
			@Override
			public void onPageScrolled(int arg0, float arg1, int arg2) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void onPageScrollStateChanged(int arg0) {
				// TODO Auto-generated method stub
				
			}
		});
	}

	private void initIndicator() {
		indicator.setViewPager(detailViewPager);
		indicator.setVisibility(View.VISIBLE);
	}

	public void initView() {
		mView = View.inflate(mActivity, R.layout.news_detail, null);
		detailViewPager = (ViewPager) mView.findViewById(R.id.vp_detail);	
		indicator = (TabPageIndicator) mView.findViewById(R.id.indicator);
	}
	
    class MyPagerAdapter extends PagerAdapter
    {
    	@Override
		public CharSequence getPageTitle(int position) {
			return mListNewsTabData.get(position).title;
		}

		@Override
		public int getCount() {
			// TODO Auto-generated method stub
			return mListNewsTabData.size();
		}

		@Override
		public boolean isViewFromObject(View arg0, Object arg1) {
			// TODO Auto-generated method stub
			return arg0 == arg1;
		}

		@Override
		public void destroyItem(ViewGroup container, int position, Object object) {
			// TODO Auto-generated method stub
			container.removeView((View)object);
		}

		@Override
		public Object instantiateItem(ViewGroup container, int position) {
			// TODO Auto-generated method stub	
//			BaseBottomButtonPager pager = children.get(position);
//			container.addView(pager.mView);
//			// pager.initData();// ��ʼ������.... ��Ҫ���ڴ˴���ʼ������, �����Ԥ������һ��ҳ��
			
			BaseDetailPager baseDetailPager = mListDetailPager.get(position);
			//baseDetailPager.setText(mListNewsTabData.get(position).title);
			container.addView(baseDetailPager.mView);
			return baseDetailPager.mView;
		}

    }
}
