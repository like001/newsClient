package com.example.mynewsclient.base;

import com.example.mynewsclient.R;

import android.app.Activity;

public class SetPager extends BaseBottomButtonPager{

	public SetPager(Activity activity) {
		super(activity);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void initData() {
		mTextView.setText("…Ë÷√");
		//mFrameLayout.setBackgroundResource(R.drawable.girl3);
	}

}
