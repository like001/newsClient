package com.example.mynewsclient.domain;

import java.util.ArrayList;

/**
 * 网络分类信息的封装类
 * 
 * 字段名字必须和服务器返回的字段名对应, 方便gson解析
 * 
 * @author Kevin
 * 
 */
public class NewsData {

	public int retcode;
	public ArrayList<NewsMenuData> data;

	// 侧边栏数据对�?
	public class NewsMenuData {
		public String id;
		public String title;
		public int type;
		public String url;

		public ArrayList<NewsTabData> children;

		@Override
		public String toString() {
			return "NewsMenuData [title=" + title + ", children=" + children
					+ "]";
		}
	}

	// 新闻页面�?11个子页签的数据对�?
	public class NewsTabData {
		public String id;
		public String title;
		public int type;
		public String url;

		@Override
		public String toString() {
			return "NewsTabData [title=" + title + "]";
		}
	}

	@Override
	public String toString() {
		return "NewsData [data=" + data + "]";
	}

}
