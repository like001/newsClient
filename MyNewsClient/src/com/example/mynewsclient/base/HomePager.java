package com.example.mynewsclient.base;

import com.example.mynewsclient.R;

import android.app.Activity;

public class HomePager extends BaseBottomButtonPager {

	public HomePager(Activity activity) {
		super(activity);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void initData() {
		mTextView.setText("主页");
		//
		
	}
	

}
