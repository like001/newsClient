package com.example.mynewsclient.pragment;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

 abstract class BaseFragment extends Fragment {

	public Activity mActivity;
	
	//fragment������ʱ����
	@Override
	public void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		mActivity=getActivity();
	}
	
	//����fragment�Ĳ���, ���ص�view��Ϊfragment�Ĳ���
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		return initViews();
	}
	
	//��������activity���������
	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onActivityCreated(savedInstanceState);
		initData();
		}

	abstract View initViews();
	
	void initData(){}
}
