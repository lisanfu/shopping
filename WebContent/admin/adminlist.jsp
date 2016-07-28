<%@page import="com.ay.shopping.entities.Admin_UserInfo"%>
<%@page import="com.ay.shopping.dao.AdminDao,java.util.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div>
		<div>
			<div class="content">
				<div class="rthbd'">
					<div class="jyjl">
						<h2><img src="images/ibg1.jpg" />管理员列表</h2>
					</div>
					<table class="tblist" width="100%" cellspacing="0" cellpadding="0">
						<% 
							AdminDao adminDao = new AdminDao();
							ArrayList<Admin_UserInfo> adminList = adminDao.getAll();
							for(Admin_UserInfo admin: adminList){
						%>
					<tr>
		                <td align="right">管理员：
		                	<input type="text" name="admin" id="admin" value="<%=admin.getAdmin_username() %>"/>
		                	<input type="hidden" name="userId" id="userId" value="<%=admin.getAdmin_userID()%>"/></td>
		                <td align="left">&nbsp;密码：<input type="password" style="width: 155px;" name="password" id="password" value="<%=admin.getAdmin_userpwd() %>"></td>
		                <td align="center">
		                	<a href="updateadmin.jsp?userId=<%=admin.getAdmin_userID() %>">修改</a>&nbsp;&nbsp;
		                	<a href="../deleteAdminServlet?userId=<%=admin.getAdmin_userID() %>" onclick="return confirm('确定要删除吗？')">删除</a>
		                </td>
	              </tr>
	               <%} %>
					
					</table>
				</div>
			</div>
		</div>
	</div>
</body>
</html>

















