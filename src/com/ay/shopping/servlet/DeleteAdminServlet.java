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


@WebServlet("/DeleteAdminServlet")
public class DeleteAdminServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
    public DeleteAdminServlet() {
        super();
       
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	doPost(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-");
		PrintWriter out = response.getWriter();
		AdminDao adminDao = new AdminDao();
		int userId = Integer.parseInt(request.getParameter("userId"));
		int res = adminDao.deleteAdmin(userId);
		if(res > 0){
			out.print("<script>window.location.href='../admin/adminlist.jsp';</script>");
		}else{
			out.print("<script>alert('删除失败！');window.history.back();</script>");
		}
		
		
		System.out.println("hello deleteAdminServlet");
	}

}
