package com.ay.shopping.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ay.shopping.dao.NewsDao;


@WebServlet("/DeleteNewsServlet")
public class DeleteNewsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public DeleteNewsServlet() {
        super();
        
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	doPost(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		NewsDao newsDao = new NewsDao();
		int newsId = Integer.parseInt(request.getParameter("newsId"));
		int res = newsDao.deleteNews(newsId);
		if(res > 0){
			out.print("<script>window.location.href='../admin/newslist.jsp';</script>");
		}else{
			out.print("<script>alert('删除失败！');window.history.back();</script>");
		}
		
	}

}
