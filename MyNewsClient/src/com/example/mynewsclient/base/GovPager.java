package com.example.mynewsclient.base;

import com.example.mynewsclient.R;

import android.app.Activity;

public class GovPager extends BaseBottomButtonPager {

	public GovPager(Activity activity) {
		super(activity);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void initData() {
		mTextView.setText("ÕþÎñ");
		//mFrameLayout.setBackgroundResource(R.drawable.girl1);
	}

}
