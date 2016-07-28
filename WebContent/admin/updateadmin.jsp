<%@page import="com.ay.shopping.dao.AdminDao"%>
<%@page import="com.ay.shopping.entities.Admin_UserInfo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="../updateAdminServlet" method="post">
		<div>
			<div>
				<div class="content">
					<div class="rthbd">
							<div class="jyjl">
	              <h2><img src="images/ibg1.jpg" />修改管理员</h2>
	            </div>
	        	<table class="tblist" width="100%" cellspacing="0" cellpadding="0">   
	        	<%
	        		int userid = Integer.parseInt(request.getParameter("userId"));
	        		Admin_UserInfo admin = new Admin_UserInfo();
	        		AdminDao adminDao = new AdminDao();
	        		admin = adminDao.getAdmin(userid);
	        		
	        	 %>                    
	              <tr>
	                <td align="right">管理员：<input type="hidden" name="userId" id="userId" value="<%=userid%>"/></td>
	                <td><input type="text" name="admin" id="admin" value="<%=admin.getAdmin_username() %>"/></td>
	              </tr>
	              <tr>
	              	<td align="right">密码：</td>
	              	<td><input type="password" style="width: 155px;" name="password" id="password" value="<%=admin.getAdmin_userpwd() %>"></td>
	              </tr>
	              <tr>
	              	<td></td>
	                <td><input type="submit" class="btnbg" value="确认修改"></td>
	              </tr>
	            </table>
					
					</div>
				
				
				</div>
			
			
			</div>
		
		</div>
	
	
	
	
	
	</form>
</body>
</html>