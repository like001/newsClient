package com.example.mynewsclient.pragment;

import java.util.ArrayList;
import java.util.concurrent.ConcurrentHashMap;

import com.example.mynewsclient.R;
import com.example.mynewsclient.base.BaseBottomButtonPager;
import com.example.mynewsclient.base.GovPager;
import com.example.mynewsclient.base.HomePager;
import com.example.mynewsclient.base.NewsPager;
import com.example.mynewsclient.base.SetPager;
import com.example.mynewsclient.base.SmartPager;
import com.example.mynewsclient.view.NoScrollViewPager;

import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class ContentFragment extends BaseFragment {

	View mView;//整个的Layout布局
	NoScrollViewPager mNoScrollViewPager;//上面的ViewPager
	RadioGroup mRadioGroup;//底部的选择组
	RadioButton rbHome;//每一个选择项
	RadioButton rbNews;
	RadioButton rbSmart;
	RadioButton rbGov;
	RadioButton rbSet;
	//ViewPager的adapter相关
	ArrayList<BaseBottomButtonPager> mListBottomButtonPager;
	
	//记录当前在哪一页
	int mCurrentPagerNum = 0;
	
	@Override
	View initViews() {
		// TODO Auto-generated method stub
		 mView= View.inflate(mActivity, R.layout.fragment_content, null);
		return mView;
	}
	
	@Override
	void initData() {
		// TODO Auto-generated method stub
		super.initData();
		mNoScrollViewPager = (NoScrollViewPager) mView.findViewById(R.id.vp_bottom);
		mListBottomButtonPager = new ArrayList<BaseBottomButtonPager>();
		mListBottomButtonPager.add(new HomePager(mActivity));
		mListBottomButtonPager.add(new NewsPager(mActivity));
		mListBottomButtonPager.add(new SmartPager(mActivity));
		mListBottomButtonPager.add(new GovPager(mActivity));
		mListBottomButtonPager.add(new SetPager(mActivity));
		mNoScrollViewPager.setAdapter(new MyPagerAdapter());
		
		mCurrentPagerNum = 0;
		mNoScrollViewPager.setCurrentItem(mCurrentPagerNum);
		
		mRadioGroup = (RadioGroup) mView.findViewById(R.id.rg_bottom);
		mRadioGroup.check(R.id.rb_home);
		
		rbHome = (RadioButton) mView.findViewById(R.id.rb_home);
		rbNews = (RadioButton) mView.findViewById(R.id.rb_news);
		rbSmart = (RadioButton) mView.findViewById(R.id.rb_smart);
		rbGov = (RadioButton) mView.findViewById(R.id.rb_gov);
		rbSet = (RadioButton) mView.findViewById(R.id.rb_set);
		
		//设置监听事件，包括下面按钮和viewPager页面变化
		initListener();
	}
	
	
    class MyPagerAdapter extends PagerAdapter
    {

		@Override
		public int getCount() {
			// TODO Auto-generated method stub
			return mListBottomButtonPager.size();
		}

		@Override
		public boolean isViewFromObject(View arg0, Object arg1) {
			// TODO Auto-generated method stub
			return arg0 == arg1;
		}

		@Override
		public void destroyItem(ViewGroup container, int position, Object object) {
			// TODO Auto-generated method stub
			container.removeView((View)object);
		}

		@Override
		public Object instantiateItem(ViewGroup container, int position) {
			// TODO Auto-generated method stub	
			BaseBottomButtonPager pager = mListBottomButtonPager.get(position);
			container.addView(pager.mView);
			// pager.initData();// 初始化数据.... 不要放在此处初始化数据, 否则会预加载下一个页面
			return pager.mView;
		}


    	
		
    }
	
	private void initListener() {
		mRadioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
			
			@Override
			public void onCheckedChanged(RadioGroup group, int checkedId) {			                
				switch (checkedId) {
				case R.id.rb_home:
					mNoScrollViewPager.setCurrentItem(0,false);
					break;
				case R.id.rb_news:
					mNoScrollViewPager.setCurrentItem(1, false);// 设置当前页面
					break;
				case R.id.rb_smart:
					mNoScrollViewPager.setCurrentItem(2, false);// 设置当前页面
					break;
				case R.id.rb_gov:
					mNoScrollViewPager.setCurrentItem(3, false);// 设置当前页面
					break;
				case R.id.rb_set:
					mNoScrollViewPager.setCurrentItem(4, false);// 设置当前页面
					break;
				default:
					break;
				}
 			}
		});
		
	}
	
	

}
