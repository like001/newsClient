package com.example.mynewsclient.base.menudetail;

import java.util.ArrayList;

import com.example.mynewsclient.R;
import com.example.mynewsclient.domain.NewsData;
import com.example.mynewsclient.domain.NewsData.NewsTabData;

import android.app.Activity;
import android.view.View;

public class TopicDetailPager extends BaseMenuDetailPager {
    
	
	public TopicDetailPager(Activity activity,NewsData newsData) {
		super(activity,newsData);
	}
	
	//供外部调用
	public void initData() {
		
		
	}
	
	public void initView() {
		mView = View.inflate(mActivity, R.layout.topic_detail, null);
		
	}
}
