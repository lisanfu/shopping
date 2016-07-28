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

@WebServlet("/UpdateAdminServlet")
public class UpdateAdminServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public UpdateAdminServlet() {
        super();
       
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Admin_UserInfo admin = new Admin_UserInfo();
		AdminDao adminDao = new AdminDao();
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		 
		int userId =Integer.parseInt(request.getParameter("userId"));
		String username = request.getParameter("admin");
		String password = request.getParameter("password");
		
		admin.setAdmin_username(username);
		admin.setAdmin_userpwd(password);
		 int res = adminDao.updateAdmin(admin);
		 if(res>0){
				out.print("<script>alert('修改成功！');</script>");
			}else{
				out.print("<script>alert('修改失败！');window.history.back();</script>");
			}
			 
			 
		
		System.out.println("hello updateAdminServlet");
	}

}
