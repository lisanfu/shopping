package com.ay.shopping.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ay.shopping.dao.AdminDao;
import com.ay.shopping.entities.Admin_UserInfo;

/**
 * Servlet implementation class AddAdminServlet
 */
@WebServlet("/AddAdminServlet")
public class AddAdminServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public AddAdminServlet() {
        super();  
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		AdminDao adminDao = new AdminDao();
		Admin_UserInfo admin = new Admin_UserInfo();
		
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		
		String username = request.getParameter("admin");
		String password = request.getParameter("password");
		admin.setAdmin_username(username);
		admin.setAdmin_userpwd(password);
		
		int res = adminDao.addAdmin(admin);
		if(res > 0)
		{
			out.println("<script>alert('添加成功')</script>");
		}else
		{
			out.print("<script>alert('添加失败！');window.history.back();</script>");
		}
		
		
		System.out.println("AddAdminRequest......");
	}

}
