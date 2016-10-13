package com.example.mynewsclient.base.menudetail;

import java.util.ArrayList;

import com.example.mynewsclient.domain.NewsData;
import com.example.mynewsclient.domain.NewsData.NewsTabData;

import android.app.Activity;

 public class BaseMenuDetailFactory {
     

	public static BaseMenuDetailPager createPager(Activity activity,String name,NewsData newsData)
	{
		
		BaseMenuDetailPager baseMenuDetailPager = null;
		switch (name) {
		case "新闻":
			baseMenuDetailPager = new NewsDetailPager(activity,newsData);	
			break;
        case "专题":
        	baseMenuDetailPager = new TopicDetailPager(activity,newsData);
        	break;
        	case "组图":
        		baseMenuDetailPager = new PictureDetailPager(activity,newsData);
        		break;
        	case "互动":
        		baseMenuDetailPager = new InterDetailPager(activity,newsData);
        		break;
		default:
			break;
		}
		
		return baseMenuDetailPager;
	}
}
