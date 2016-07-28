<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="css/adminIndex.css" type="text/css" />
</head>
<body>
	<form action="../addAdminServlet" method="post" >
		<div id="container">
			<div id="right">
				<div class="content">
					<div class="jyjl">
						<h2>
							<img src="images/ibg1.jpg"/>新增管理员
						</h2>
					</div>
					<table class="tblist" width="100%" cellspacing="0" cellpadding="0">
						<tr>
							<td align="right">管理员:<input type="text" name="admin" id="admin" /></td>
							<td align="left">&nbsp;密码:<input type="password" style="width: 155px;" name="password" id="password" /></td>
							<td align="center"><input type="submit" class="btnbg" value="确认添加"/></td>
						
						</tr>
					</table>
				</div>
			</div>
		
		</div>
		
	
	
	</form>

</body>
</html>