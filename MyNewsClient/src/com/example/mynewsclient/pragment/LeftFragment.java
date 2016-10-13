package com.example.mynewsclient.pragment;

import java.util.ArrayList;
import java.util.Iterator;

import com.example.mynewsclient.R;
import com.example.mynewsclient.base.NewsPager;
import com.example.mynewsclient.base.menudetail.NewsDetailPager;
import com.example.mynewsclient.domain.NewsData.NewsMenuData;
import com.example.mynewsclient.utils.NewsPagerUtils;
import com.example.mynewsclient.utils.PrefUtils;
import com.lidroid.xutils.ViewUtils;
import com.lidroid.xutils.view.annotation.ViewInject;
import com.lidroid.xutils.view.annotation.event.OnItemClick;

import android.R.string;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

public class LeftFragment extends BaseFragment {

	
	String TAG = "LeftFragment";
	ListView lvLeft;
	ArrayList<NewsMenuData> mListData;
	
	
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
		initListener();
		
	}
	
	private void initListener() {
		lvLeft.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
				if(mListData!=null)
				{
					String name = mListData.get(arg2).title;
					NewsPager newsPager = NewsPagerUtils.getNewsPager();
				    if(newsPager !=null)
				    {
				    	newsPager.changeMenuDetailPager(name);
				    }
				}
				
			}
		});
		
	}


	//设置侧边栏的选项
	public void initLeftLV(final ArrayList<NewsMenuData> list)
	{
		Log.e(TAG, "initLeftLV");
		mListData = list;
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
