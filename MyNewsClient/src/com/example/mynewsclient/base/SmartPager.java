package com.example.mynewsclient.base;

import com.example.mynewsclient.R;

import android.app.Activity;

public class SmartPager extends BaseBottomButtonPager{

	public SmartPager(Activity activity) {
		super(activity);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void initData() {
		mTextView.setText("智能政务");
		//mFrameLayout.setBackgroundResource(R.drawable.girl4);
	}

}