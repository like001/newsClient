package com.example.mynewsclient.base.menudetail;

import com.example.mynewsclient.domain.NewsData;

import android.app.Activity;
import android.view.View;

public abstract class BaseMenuDetailPager {

	public View mView;//总的View
    Activity mActivity;
    NewsData mNewsData;
    BaseMenuDetailPager(Activity activity,NewsData newsData)
    {
    	mActivity = activity;
    	mNewsData = newsData;
    	initView();
    }
	abstract void initView(); 
	
	public void initData(){};
}
