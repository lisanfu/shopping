package com.ay.shopping.test;

import static org.junit.Assert.*;

import java.util.Date;

import com.ay.shopping.dao.AdminDao;
import com.ay.shopping.dao.NewsDao;
import com.ay.shopping.entities.Admin_UserInfo;
import com.ay.shopping.entities.NewsInfo;

public class Test {

	@org.junit.Test
	public void test() {
		AdminDao adminDao = new AdminDao();
		System.out.println(adminDao.getAll());
	}
	@org.junit.Test
	public void testUpdateAdmin()
	{
		Admin_UserInfo admin = new Admin_UserInfo();
		admin.setAdmin_userID(2);
		admin.setAdmin_username("fu");
		admin.setAdmin_userpwd("123456");
		AdminDao adminDao = new AdminDao();
		int res = adminDao.updateAdmin(admin);
		System.out.println(res);
	}
	@org.junit.Test
	public void testDeleteAdmin()
	{
		AdminDao adminDao =  new AdminDao();
		int res = adminDao.deleteAdmin(2);
		System.out.println(res);
	}
	/**
	 * 
	 */
	@org.junit.Test
	public void testAddNews()
	{
		NewsInfo news = new NewsInfo();
		news.setNewsTitle("news");
		news.setNewsContent("this hot家");
		news.setNewsDate("2016-9-11");
		NewsDao newsDao =new NewsDao(); 
		int res = newsDao.addNews(news);
		System.out.println(res);
	
	}

}
