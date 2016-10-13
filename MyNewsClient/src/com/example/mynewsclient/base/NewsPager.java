package com.example.mynewsclient.base;

import java.util.ArrayList;
import java.util.Iterator;

import com.example.mynewsclient.MainActivity;
import com.example.mynewsclient.R;
import com.example.mynewsclient.base.menudetail.BaseMenuDetailFactory;
import com.example.mynewsclient.base.menudetail.BaseMenuDetailPager;
import com.example.mynewsclient.domain.NewsData;
import com.example.mynewsclient.domain.NewsData.NewsMenuData;
import com.example.mynewsclient.global.GlobalContants;
import com.example.mynewsclient.pragment.ContentFragment;
import com.example.mynewsclient.pragment.LeftFragment;
import com.example.mynewsclient.utils.NewsPagerUtils;
import com.example.mynewsclient.utils.PrefUtils;
import com.google.gson.Gson;
import com.lidroid.xutils.HttpUtils;
import com.lidroid.xutils.exception.HttpException;
import com.lidroid.xutils.http.ResponseInfo;
import com.lidroid.xutils.http.callback.RequestCallBack;
import com.lidroid.xutils.http.client.HttpRequest.HttpMethod;

import android.app.Activity;
import android.graphics.Color;
import android.provider.Settings.Global;
import android.util.Log;
import android.widget.Toast;

public class NewsPager extends BaseBottomButtonPager{

	String TAG = "NewsPager";
	private NewsData mNewsData;
	ContentFragment contentFragment;
	MainActivity mainActivity;
	Boolean leftIsInited = false;
	public NewsPager(Activity activity) {
		super(activity);
		mainActivity=(MainActivity)activity;
		contentFragment = mainActivity.getContentFragment();
		// TODO Auto-generated constructor stub
	}

	@Override
	public void initData() {
		mTextView.setText("新闻");
		getDataFromServer();		
		NewsPagerUtils.setNewsPager(this);

	}
	
	public void getDataFromServer()
	{
		HttpUtils httpUtils = new HttpUtils();
		httpUtils.configCurrentHttpCacheExpiry(1000*10);
		httpUtils.send(HttpMethod.GET, GlobalContants.CATEGORIES_URL, new RequestCallBack<String>() {

			@Override
			public void onFailure(HttpException arg0, String arg1) {
				Toast.makeText(mActivity, "链接网络服务器失败", Toast.LENGTH_SHORT).show();
				arg0.printStackTrace();
				Log.e(TAG, arg1);
				
			}

			@Override
			public void onSuccess(ResponseInfo<String> arg0) {
				Toast.makeText(mActivity, "链接网络服务器成功", Toast.LENGTH_SHORT).show();
				String jsonData = (String)arg0.result;
				parseData(jsonData);
				Log.e(TAG, mNewsData.toString());
				
				
				//得到javabean之后的处理
				if(mNewsData !=null )
				{
					//展示第一页content内容
					changeMenuDetailPager(mNewsData.data.get(0).title);	
					//初始化左边侧边栏
					if(!leftIsInited)
					{
						initSlidingMenuData();
						leftIsInited= true;
					}					
					
				}
			}
		});
	}
	
	//点击侧边栏之后，用于修改页面
	public void changeMenuDetailPager(String name)
	{
		BaseMenuDetailPager baseMenuDetailPager = 
				BaseMenuDetailFactory.createPager(mActivity, name,mNewsData);	
			BaseBottomButtonPager pager= contentFragment.getCurrentPager();
			//必须为新闻选项时才能切换这个页面
			if(pager.getClass() == this.getClass())
			{
			pager.mFrameLayout.removeAllViews();
			pager.mFrameLayout.setBackgroundResource(0);
			if(baseMenuDetailPager!=null)
			{
				baseMenuDetailPager.initData();
				pager.mFrameLayout.addView(baseMenuDetailPager.mView);
			}	
			}
			else
			{
				Toast.makeText(mainActivity, "非法", Toast.LENGTH_SHORT).show();
			}
					
	}
	
	//将返回json保存到javabean
	public void parseData(String data)
	{
		Gson gson = new Gson();
		mNewsData = gson.fromJson(data, NewsData.class);
	}
	
	//得到侧边栏数据之后就可以进行初始化操作了
	public void initSlidingMenuData()
	{
		Log.v(TAG, "initSlidingMenuData");
		MainActivity mainActivity = (MainActivity)mActivity;
		LeftFragment leftFragment = mainActivity.getLeftMenuFragment();
		leftFragment.initLeftLV(mNewsData.data);
	}

}
