<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="../addNewsServlet" method="post" onsubmit="return news()">
		<div>
			<div>
				<div class="content"> 
					<div class="rthbd">
						<div class="jyjl">
							<h2><img src="../images/ibg1.jpg">新闻添加</h2>
						</div>
						<table class="tblist" width="100%" cellpadding="0" cellspacing="0">
							<tr >
								<td align="right">新闻标题：</td>
								<td><input type="text" style="width:328px;" name="newsTitle" /></td>
							</tr>
							<br>
							<tr>
								<td align="right">新闻内容：</td>
								<td><textarea name="newsContent" cols="60" rows="10"></textarea></td>
							</tr>
							<br>
							<tr>
				              	<td width="200px;"></td>
				              	<td align="left"><input type="submit" style="margin-left: 200" class="btnbg" value="确认添加">
				              	</td>	              	
		             		 </tr>
						</table>
					</div>
				</div>
			</div>
		</div>
	</form>
	

</body>
</html>