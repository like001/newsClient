package com.example.mynewsclient.base;

import com.example.mynewsclient.R;

import android.app.Activity;
import android.provider.ContactsContract.Contacts.Data;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.TextView;


/**�ײ���ť�����л�ҳ�棬�����л�ҳ��Ļ���
 */
public abstract class BaseBottomButtonPager {

    Activity mActivity;
	public View mView;
	ImageButton mImageButton;
	TextView mTextView;
	FrameLayout mFrameLayout;
	
	public BaseBottomButtonPager(Activity activity) {
		// TODO Auto-generated constructor stub
		mActivity=activity;
		initViews();
		//initData();
	}

	private void initViews() {
		mView = View.inflate(mActivity,R.layout.base_bottom_button_pager , null);
		mImageButton = (ImageButton) mView.findViewById(R.id.ibt_menu);
		mTextView = (TextView) mView.findViewById(R.id.tv_title);
		mFrameLayout = (FrameLayout) mView.findViewById(R.id.fl_title_down);
	}
	
	abstract public void initData();

}
