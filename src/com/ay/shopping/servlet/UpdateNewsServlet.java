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


@WebServlet("/UpdateNewsServlet")
public class UpdateNewsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public UpdateNewsServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		NewsInfo newsInfo = new NewsInfo();
		NewsDao newsDao = new NewsDao();
		int newsId = Integer.parseInt(request.getParameter("newsId"));
		String newsTitle = request.getParameter("newsTitle");
		String newsContent = request.getParameter("newsContent");
		newsInfo.setNewsTitle(newsTitle);
		newsInfo.setNewsId(newsId);
		newsInfo.setNewsContent(newsContent);
		int res = newsDao.updateNews(newsInfo);
		if(res>0){
			out.print("<script>alert('修改成功！');</script>");
		}else{
			out.print("<script>alert('修改失败！');window.history.back();</script>");
		}
	}

}
