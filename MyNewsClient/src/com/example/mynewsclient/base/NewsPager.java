package com.example.mynewsclient.base;

import com.example.mynewsclient.R;

import android.app.Activity;

public class NewsPager extends BaseBottomButtonPager{

	public NewsPager(Activity activity) {
		super(activity);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void initData() {
		mTextView.setText("пбне");
		//mFrameLayout.setBackgroundResource(R.drawable.girl2);
	}

}
