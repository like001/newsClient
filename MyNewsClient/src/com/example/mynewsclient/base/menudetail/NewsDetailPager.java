package com.example.mynewsclient.base.menudetail;

import java.util.ArrayList;

import com.example.mynewsclient.R;
import com.example.mynewsclient.domain.NewsData.NewsTabData;

import android.app.Activity;
import android.view.View;

public class NewsDetailPager extends BaseMenuDetailPager {
    
	
	
	ArrayList<NewsTabData> children;
	public NewsDetailPager(Activity activity) {
		super(activity);
		initViews();
	}
	
	//供外部调用
	public void initData(ArrayList<NewsTabData> children) {
		this.children =children;
		
	}
	private void initViews() {
		mView = View.inflate(mActivity, R.layout.news_detail, null);
		
	}
}
