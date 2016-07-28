package com.ay.shopping.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ay.shopping.dao.NewsDao;
import com.ay.shopping.entities.NewsInfo;

/**
 * @author Fu_Yuan
 *
 */
@WebServlet("/AddNewsServlet")
public class AddNewsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public AddNewsServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		NewsDao newsDao = new NewsDao();
		NewsInfo newsInfo = new NewsInfo();
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		String newsTitle = request.getParameter("newsTitle");
		String newsContent = request.getParameter("newsContent");
		newsInfo.setNewsTitle(newsTitle);
		newsInfo.setNewsContent(newsContent);
		int res = newsDao.addNews(newsInfo);
		if(res > 0)
		{
			out.println("<script>alert('添加成功')</script>");
		}else
		{
			out.print("<script>alert('添加失败！');window.history.back();</script>");
		}
	}

}
