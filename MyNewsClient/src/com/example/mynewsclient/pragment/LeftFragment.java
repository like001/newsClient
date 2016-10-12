package com.example.mynewsclient.pragment;

import java.util.ArrayList;
import java.util.Iterator;

import com.example.mynewsclient.R;
import com.example.mynewsclient.domain.NewsData.NewsMenuData;
import com.example.mynewsclient.utils.PrefUtils;

import android.R.string;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

public class LeftFragment extends BaseFragment {

	
	String TAG = "LeftFragment";
	ListView lvLeft;
	
	@Override
	View initViews() {
		// TODO Auto-generated method stub
		View view = View.inflate(mActivity, R.layout.fragment_left_menu, null);
		lvLeft = (ListView) view.findViewById(R.id.lv_left);
		return view;
	}
    
	
	//activity创建完之后会被调用
	@Override
	void initData() {
		// TODO Auto-generated method stub
		super.initData();
		
	}
	
	//设置侧边栏的选项
	public void initLeftLV(final ArrayList<NewsMenuData> list)
	{
		PrefUtils.setBoolean(mActivity, PrefUtils.LEFT_INITED, true);
		Log.e(TAG, "initLeftLV");
		lvLeft.setAdapter(new BaseAdapter() {
			
			@Override
			public View getView(int position, View convertView, ViewGroup parent) {
				// TODO Auto-generated method stub
			
				View view =  View.inflate(mActivity, R.layout.item_left, null);
				TextView tv = (TextView) view.findViewById(R.id.tv_left_item);
	        	tv.setText(list.get(position).title);
	        	return view;
			}
			
			@Override
			public long getItemId(int position) {
				// TODO Auto-generated method stub
				return 0;
			}
			
			@Override
			public Object getItem(int position) {
				// TODO Auto-generated method stub
				return position;
			}
			
			@Override
			public int getCount() {
				// TODO Auto-generated method stub
				return list.size();
			}
		});
		
		
	
}

}
