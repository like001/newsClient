package com.example.mynewsclient;

import com.example.mynewsclient.pragment.ContentFragment;
import com.example.mynewsclient.pragment.LeftFragment;
import com.jeremyfeinstein.slidingmenu.lib.SlidingMenu;
import com.jeremyfeinstein.slidingmenu.lib.app.SlidingFragmentActivity;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.Menu;
import android.view.MenuItem;


/*
 * 主界面
 * */
public class MainActivity extends SlidingFragmentActivity {

	
public String FRAGMENT_LEFT_MENU="fragment_left_menu";	
public String FRAGMENT_CONTENT="fragment_content";	
@Override
public void onCreate(Bundle savedInstanceState) {
	// TODO Auto-generated method stub
	super.onCreate(savedInstanceState);
	setContentView(R.layout.activity_main);
	
	//侧边栏的布局文件
	setBehindContentView(R.layout.left_menu);
	SlidingMenu slidingMenu = getSlidingMenu();
	slidingMenu.setTouchModeAbove(SlidingMenu.TOUCHMODE_FULLSCREEN);
	slidingMenu.setMode(SlidingMenu.LEFT);	
	slidingMenu.setBehindOffset(300);
	
	initFragment();
}


//初始化左边侧边栏的fragment，使用fragment来填充侧边栏和主界面
private void initFragment() {
	// TODO Auto-generated method stub
	FragmentManager fragmentManager = getSupportFragmentManager();
	FragmentTransaction transaction = fragmentManager.beginTransaction();
	transaction.replace(R.id.fl_left_menu, new LeftFragment(),FRAGMENT_LEFT_MENU );
	transaction.replace(R.id.fl_content, new ContentFragment(),FRAGMENT_CONTENT );
	transaction.commit();
}
}
