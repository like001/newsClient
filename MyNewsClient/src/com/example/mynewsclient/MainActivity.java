package com.example.mynewsclient;

import com.example.mynewsclient.pragment.ContentFragment;
import com.example.mynewsclient.pragment.LeftFragment;
import com.jeremyfeinstein.slidingmenu.lib.SlidingMenu;
import com.jeremyfeinstein.slidingmenu.lib.app.SlidingFragmentActivity;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.Menu;
import android.view.MenuItem;
import android.view.Window;


/*
 * ������
 * */
public class MainActivity extends SlidingFragmentActivity {

	
public String FRAGMENT_LEFT_MENU="fragment_left_menu";	
public String FRAGMENT_CONTENT="fragment_content";	
@Override
public void onCreate(Bundle savedInstanceState) {
	// TODO Auto-generated method stub
	super.onCreate(savedInstanceState);
	setContentView(R.layout.activity_main);
	//requestWindowFeature();
	//������Ĳ����ļ�
	setBehindContentView(R.layout.left_menu);
	SlidingMenu slidingMenu = getSlidingMenu();
	slidingMenu.setTouchModeAbove(SlidingMenu.TOUCHMODE_FULLSCREEN);
	slidingMenu.setMode(SlidingMenu.LEFT);	
	slidingMenu.setBehindOffset(300);
	
	initFragment();
}


//��ʼ����߲������fragment��ʹ��fragment�����������������
private void initFragment() {
	// TODO Auto-generated method stub
	FragmentManager fragmentManager = getSupportFragmentManager();
	FragmentTransaction transaction = fragmentManager.beginTransaction();
	transaction.replace(R.id.fl_left_menu, new LeftFragment(),FRAGMENT_LEFT_MENU );
	transaction.replace(R.id.fl_content, new ContentFragment(),FRAGMENT_CONTENT );
	transaction.commit();
}


// 获取侧边栏fragment
public LeftFragment getLeftMenuFragment() {
	FragmentManager fm = getSupportFragmentManager();
	LeftFragment fragment = (LeftFragment) fm
			.findFragmentByTag(FRAGMENT_LEFT_MENU);

	return fragment;
}

// 获取主页面fragment
public ContentFragment getContentFragment() {
	FragmentManager fm = getSupportFragmentManager();
	ContentFragment fragment = (ContentFragment) fm
			.findFragmentByTag(FRAGMENT_CONTENT);

	return fragment;
}

}
