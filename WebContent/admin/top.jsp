<%@page import="com.ay.shopping.entities.Admin_UserInfo"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
<link type="text/css" rel="stylesheet" href="css/adminIndex.css">
</head>
<body>
 <%
		Admin_UserInfo au = (Admin_UserInfo)session.getAttribute("au");
	%>
	
	<div class="header_top">
		  <div class="navbar">
			<h1>管理系统后台</h1>
		</div>
		<div>
			<div class="loginbar">
				<a href="../Admin_UserZxServlet" target="_top"> 退出</a>
			</div>
			<div class="date">当前时间：2012年6月30日 13:07:42</div>
		</div>
		 <div class="notice">
				<div class="nt1"><a href="admin/main.jsp" target=""> 后台首页</a></div>
				<div class="nt2"><p>当前管理员：<span></span></p></div>
				<div class="nt1 nt4"><a href="admin/admin_user.jsp" target="mainFrame">修改密码</a></div>	
		</div>
	</div>
</body>
</html>

























