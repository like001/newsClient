package com.example.mynewsclient.base.menudetail;

import java.util.ArrayList;

import com.example.mynewsclient.domain.NewsData.NewsTabData;

import android.app.Activity;

 public class BaseMenuDetailFactory {
     

	public static BaseMenuDetailPager createPager(Activity activity,String name )
	{
		
		BaseMenuDetailPager baseMenuDetailPager = null;
		switch (name) {
		case "新闻":
			baseMenuDetailPager = new NewsDetailPager(activity);	
			break;
        case "专题":
        	break;
        	case "组图":
        		break;
        	case "互动":
        		break;
		default:
			break;
		}
		
		return baseMenuDetailPager;
	}
}
