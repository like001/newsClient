package com.example.mynewsclient.base.detailpager;

import java.net.URL;
import java.util.ArrayList;

import com.example.mynewsclient.R;
import com.example.mynewsclient.domain.NewsData.NewsTabData;
import com.example.mynewsclient.domain.TabData;
import com.example.mynewsclient.domain.TabData.TabNewsData;
import com.example.mynewsclient.domain.TabData.TopNewsData;
import com.example.mynewsclient.global.GlobalContants;
import com.google.gson.Gson;
import com.lidroid.xutils.BitmapUtils;
import com.lidroid.xutils.HttpUtils;
import com.lidroid.xutils.exception.HttpException;
import com.lidroid.xutils.http.ResponseInfo;
import com.lidroid.xutils.http.callback.RequestCallBack;
import com.lidroid.xutils.http.client.HttpRequest.HttpMethod;

import android.R.color;
import android.app.Activity;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class BaseDetailPager {

		public View mView;
		Activity mActivity;
		ViewPager vpTopNews;
		ListView lvNews;
		NewsTabData mNewsTabData;
		TabData mTabData;
		String mUrl;
		NewsAdapter mNewsAdapter;
		
		String TAG= "BaseDetailPager";
		private ArrayList<TopNewsData> mTopNewsList;
		private ArrayList<TabNewsData> mNewsList;
		
	public BaseDetailPager(Activity activity,NewsTabData mNewsTabData) {
		mActivity=activity;
		this.mNewsTabData = mNewsTabData;
		mUrl = GlobalContants.SERVER_URL + mNewsTabData.url;
		initView();
		
	}
	
	private void initView() {
		mView = View.inflate(mActivity, R.layout.detail_pager, null);	
	    vpTopNews = (ViewPager) mView.findViewById(R.id.vp_top_news);
	    lvNews = (ListView) mView.findViewById(R.id.lv_news);
	    lvNews.setBackgroundColor(color.white);
	    lvNews.getBackground().setAlpha(100);
	}
	
	public void initData()
	{
		if(mNewsTabData !=null)
		{
			getDataFromServer();
		}
	}
	

	private void getDataFromServer() {
		HttpUtils utils = new HttpUtils();
		utils.send(HttpMethod.GET, mUrl, new RequestCallBack<String>() {

			@Override
			public void onSuccess(ResponseInfo<String> responseInfo) {
				String result = (String) responseInfo.result;
				Log.v(TAG, "连接成功");
				parseData(result);
			}

			@Override
			public void onFailure(HttpException error, String msg) {
				Toast.makeText(mActivity, msg, Toast.LENGTH_SHORT).show();
				error.printStackTrace();
			}
		});
	}

	protected void parseData(String result) {
		Gson gson = new Gson();
		mTabData = gson.fromJson(result, TabData.class);
		Log.v(TAG, "获取数据为" + mTabData);
		mTopNewsList = mTabData.data.topnews;
		mNewsList = mTabData.data.news;

		if (mTopNewsList != null) {
			vpTopNews.setAdapter(new TopNewsAdapter());
//			mIndicator.setViewPager(mViewPager);
//			mIndicator.setSnap(true);// 鏀寔蹇収鏄剧ず
//			mIndicator.setOnPageChangeListener(this);

			//mIndicator.onPageSelected(0);// 璁╂寚绀哄櫒閲嶆柊瀹氫綅鍒扮涓�涓偣

			//tvTitle.setText(mTopNewsList.get(0).title);
		}

		if (mNewsList != null) {
			mNewsAdapter = new NewsAdapter();
			lvNews.setAdapter(mNewsAdapter);
		}
	}
	
	class TopNewsAdapter extends PagerAdapter {

		private BitmapUtils utils;

		public TopNewsAdapter() {
			utils = new BitmapUtils(mActivity);
			//设置默认图片
			utils.configDefaultLoadingImage(R.drawable.topnews_item_default);
		}

		@Override
		public int getCount() {
			return mTabData.data.topnews.size();
		}

		@Override
		public boolean isViewFromObject(View arg0, Object arg1) {
			return arg0 == arg1;
		}

		@Override
		public Object instantiateItem(ViewGroup container, int position) {
			ImageView image = new ImageView(mActivity);
			image.setScaleType(ScaleType.FIT_XY);// 鍩轰簬鎺т欢澶у皬濉厖鍥剧墖

			TopNewsData topNewsData = mTopNewsList.get(position);
			String newUrl = convertToNewUrl(topNewsData.topimage);
			utils.display(image, newUrl);// 浼犻�抜magView瀵硅薄鍜屽浘鐗囧湴鍧�

			container.addView(image);
			
			System.out.println("instantiateItem....." + position);
			return image;
		}

		@Override
		public void destroyItem(ViewGroup container, int position, Object object) {
			container.removeView((View) object);
		}
	}

	/**
	 * 鏂伴椈鍒楄〃鐨勯�傞厤鍣�
	 * 
	 * @author Kevin
	 * 
	 */
	class NewsAdapter extends  android.widget.BaseAdapter {

		private BitmapUtils utils;

		public NewsAdapter() {
			utils = new BitmapUtils(mActivity);
			utils.configDefaultLoadingImage(R.drawable.pic_item_list_default);
		}

		@Override
		public int getCount() {
			return mNewsList.size();
		}

		@Override
		public TabNewsData getItem(int position) {
			return mNewsList.get(position);
		}

		@Override
		public long getItemId(int position) {
			return position;
		}

		@Override
		public View getView(int position, View convertView, ViewGroup parent) {
			ViewHolder holder;
			if (convertView == null) {
				convertView = View.inflate(mActivity, R.layout.list_news_item,
						null);
				holder = new ViewHolder();
				holder.ivPic = (ImageView) convertView
						.findViewById(R.id.iv_pic);
				holder.tvTitle = (TextView) convertView
						.findViewById(R.id.tv_title);
				holder.tvDate = (TextView) convertView
						.findViewById(R.id.tv_date);

				convertView.setTag(holder);
			} else {
				holder = (ViewHolder) convertView.getTag();
			}

			TabNewsData item = getItem(position);

			holder.tvTitle.setText(item.title);
			holder.tvDate.setText(item.pubdate);
            String newUrl = convertToNewUrl(item.listimage);
			utils.display(holder.ivPic, newUrl);

			return convertView;
		}

	}

	static class ViewHolder {
		public TextView tvTitle;
		public TextView tvDate;
		public ImageView ivPic;
	}
	
	String convertToNewUrl(String url)
	{
		//http://10.0.2.2:8080/zhbj/10007/2078369924F9UO.jpg
		//http://10.11.1.60:8088/zhbj
		String result;
		int position = url.indexOf("/zhbj");
		String start = "http://10.11.1.60:8088";
		if(position>0)
		{
			result = start+url.substring(position);
		}
		else {
			result = url;
		}
		return result;
	}
}
