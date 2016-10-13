package com.example.mynewsclient.base.menudetail;

import java.util.ArrayList;

import com.example.mynewsclient.R;
import com.example.mynewsclient.domain.NewsData;
import com.example.mynewsclient.domain.NewsData.NewsTabData;

import android.app.Activity;
import android.view.View;

public class InterDetailPager extends BaseMenuDetailPager {
    
	
	
	ArrayList<NewsTabData> children;
	public InterDetailPager(Activity activity,NewsData newsData) {
		super(activity,newsData);
	}
	
	//供外部调用
	public void initData(ArrayList<NewsTabData> children) {
		this.children =children;
		
	}
	
	@Override
	void initView() {
		// TODO Auto-generated method stub
		mView = View.inflate(mActivity, R.layout.news_detail, null);
		
	}
}
