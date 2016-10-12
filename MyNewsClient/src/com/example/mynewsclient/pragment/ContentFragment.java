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

import android.net.UrlQuerySanitizer.IllegalCharacterValueSanitizer;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class ContentFragment extends BaseFragment {

	View mView;//������Layout����
	public NoScrollViewPager mNoScrollViewPager;//�����ViewPager
	RadioGroup mRadioGroup;//�ײ���ѡ����
	RadioButton rbHome;//ÿһ��ѡ����
	RadioButton rbNews;
	RadioButton rbSmart;
	RadioButton rbGov;
	RadioButton rbSet;
	//ViewPager��adapter���
	ArrayList<BaseBottomButtonPager> mListBottomButtonPager;
	
	//��¼��ǰ����һҳ
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
		
		HomePager homePager = new HomePager(mActivity);
		homePager.initData();
		mListBottomButtonPager.add(homePager);
		mListBottomButtonPager.add(new NewsPager(mActivity));
		mListBottomButtonPager.add(new SmartPager(mActivity));
		mListBottomButtonPager.add(new GovPager(mActivity));
		mListBottomButtonPager.add(new SetPager(mActivity));
		mNoScrollViewPager.setAdapter(new MyPagerAdapter());
		
		mCurrentPagerNum = 0;
		mNoScrollViewPager.setCurrentItem(mCurrentPagerNum,false);
		
		mRadioGroup = (RadioGroup) mView.findViewById(R.id.rg_bottom);
		mRadioGroup.check(R.id.rb_home);
		
		rbHome = (RadioButton) mView.findViewById(R.id.rb_home);
		rbNews = (RadioButton) mView.findViewById(R.id.rb_news);
		rbSmart = (RadioButton) mView.findViewById(R.id.rb_smart);
		rbGov = (RadioButton) mView.findViewById(R.id.rb_gov);
		rbSet = (RadioButton) mView.findViewById(R.id.rb_set);
		
		//���ü����¼����������水ť��viewPagerҳ��仯
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
			// pager.initData();// ��ʼ������.... ��Ҫ���ڴ˴���ʼ������, �����Ԥ������һ��ҳ��
			return pager.mView;
		}


    	
		
    }
	
	private void initListener() {
		
    //�л��±�仯
		mRadioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
			
			@Override
			public void onCheckedChanged(RadioGroup group, int checkedId) {			                
				switch (checkedId) {
				case R.id.rb_home:
					mNoScrollViewPager.setCurrentItem(0,false);
					break;
				case R.id.rb_news:
					mNoScrollViewPager.setCurrentItem(1, false);// ���õ�ǰҳ��
					break;
				case R.id.rb_smart:
					mNoScrollViewPager.setCurrentItem(2, false);// ���õ�ǰҳ��
					break;
				case R.id.rb_gov:
					mNoScrollViewPager.setCurrentItem(3, false);// ���õ�ǰҳ��
					break;
				case R.id.rb_set:
					mNoScrollViewPager.setCurrentItem(4, false);// ���õ�ǰҳ��
					break;
				default:
					break;
				}
 			}
		});
		
		//Pager�仯
		mNoScrollViewPager.setOnPageChangeListener(new OnPageChangeListener() {
			
			@Override
			public void onPageSelected(int arg0) {
				// TODO Auto-generated method stub
				mCurrentPagerNum = arg0;
				mListBottomButtonPager.get(arg0).initData();
				
			}
			
			@Override
			public void onPageScrolled(int arg0, float arg1, int arg2) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void onPageScrollStateChanged(int arg0) {
				// TODO Auto-generated method stub
				
			}
		});
		
	}
	
	
	public BaseBottomButtonPager getCurrentPager()
	{
		return mListBottomButtonPager.get(mCurrentPagerNum);
	}
	
	

}
