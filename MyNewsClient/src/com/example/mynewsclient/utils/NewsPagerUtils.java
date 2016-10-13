package com.example.mynewsclient.utils;

import com.example.mynewsclient.base.BaseBottomButtonPager;
import com.example.mynewsclient.base.NewsPager;
import com.example.mynewsclient.base.menudetail.BaseMenuDetailPager;

public class NewsPagerUtils {

	private static NewsPager newsPager;

	public static NewsPager getNewsPager() {
		return newsPager;
	}

	public static void setNewsPager(NewsPager pager) {
		newsPager = pager;
	}
	
}
