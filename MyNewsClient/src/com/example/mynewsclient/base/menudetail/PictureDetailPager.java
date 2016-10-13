package com.example.mynewsclient.base.menudetail;

import java.util.ArrayList;

import com.example.mynewsclient.R;
import com.example.mynewsclient.domain.NewsData;
import com.example.mynewsclient.domain.NewsData.NewsTabData;

import android.app.Activity;
import android.view.View;

public class PictureDetailPager extends BaseMenuDetailPager {
    
	
	
	ArrayList<NewsTabData> children;
	public PictureDetailPager(Activity activity,NewsData newsData) {
		super(activity,newsData);
	}
	
	//供外部调用
	public void initData() {
		
	}
	public void initView() {
		mView = View.inflate(mActivity, R.layout.news_detail, null);
		
	}
}
