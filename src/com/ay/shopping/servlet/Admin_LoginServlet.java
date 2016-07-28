package com.ay.shopping.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ay.shopping.dao.AdminDao;
import com.ay.shopping.entities.Admin_UserInfo;

//@WebServlet("/Admin_LoginServlet")
public class Admin_LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public Admin_LoginServlet() {
        super();
      
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		String adminUsername = request.getParameter("adminUsername");
		String adminPassword = request.getParameter("adminPassword");
		AdminDao adminDao = new AdminDao();
		Admin_UserInfo au = adminDao.login(adminUsername, adminPassword);
		if(au != null)
		{
			HttpSession session = request.getSession();
			session.setAttribute("au", au);
			System.out.println(au);
			response.sendRedirect("/shopping/admin/index.jsp");
		}
		else 
		{
			out.print("<script>alert('name is error');window.history.back();</script>");
		}
	}

}
