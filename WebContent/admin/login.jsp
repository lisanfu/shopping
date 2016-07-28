<%@ page language="java" import="java.util.*" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>后台登录系统</title>
<link rel="stylesheet" href="css/login.css" type="text/css">
<script type="text/javascript" >
	function loginyz()
	{
		var adminUsername = document.getElementById("adminUsername");
		var adminPassword = document.getElementById("adminPassword");
		var yzm = document.getElementById("yzm");
		if(adminUsername.value.length <= 0)
			{
				alert("请输入用户名");
				return false;
			}
		if(adminPassword.value.length <=0)
			{
				alert("请输入密码");
				return false;
			}
		if(yzm.value.length <= 0)
			{
				alert("请输入验证码");
				return false;
			}else if(yzm.value != "AIKL" && yzm.value != "aikl")
				{
					alert("验证码有误");
					return false;
				}else{
					return ture;
				}
	}

</script>
</head>
<body>
	<div class="login">
		<form action="../Admin_LoginServlet" method="post" onSubmit="return loginyz()">
			<ul>
				<li>
					<label>管理员：</label>
					<span>
						<input type="text" id="adminUsername" name="adminUsername" />
					</span>
				</li>
				<li>
					<label>	密&nbsp;&nbsp;&nbsp;&nbsp;码</label>
					<span>
						<input type="password" id="adminPassword" name="adminPassword"/>
					</span>
				</li>
				<li>
					<label>验证码：</label>
	       			<input name="yzm" id="yzm" type="text" style="height:18px;width:65px;margin-left: 2px" />
	        		<div style="margin-top:-23px;margin-left: 145px;">
	        			<img alt="AIKL" src="images/code.gif" />
	        		</div>
				
				</li>
				<li>
					<label></label>
					<input class="tblg" type="submit" value="">
				</li>
			</ul>
		</form>
	
	</div>
</body>
</html>