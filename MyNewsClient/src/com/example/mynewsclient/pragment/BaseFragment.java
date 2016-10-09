package com.example.mynewsclient.pragment;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

 abstract class BaseFragment extends Fragment {

	public Activity mActivity;
	
	//fragment被创建时调用
	@Override
	public void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		mActivity=getActivity();
	}
	
	//处理fragment的布局, 返回的view即为fragment的布局
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		return initViews();
	}
	
	//当依附的activity被创建完毕
	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onActivityCreated(savedInstanceState);
		initData();
		}

	abstract View initViews();
	
	void initData(){}
}
