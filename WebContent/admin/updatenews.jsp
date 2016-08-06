<%@ page language="java" contentType="text/html; charset=UTF-8"
   import="com.ay.shopping.dao.*,com.ay.shopping.entities.*"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="css/adminIndex.css" type="text/css" />
</head>
<script type="text/javascript">
function news(){
	
	var neewsTitle = document.getElementById("newsTitle");
	var newsContent = document.getElementById("newsContent");
	if(newsTitle.value.length <= 0)
		{
		alert("请填写新闻标题");
		return false;
		}else if(newsTitle.value.length>25){
			alert("新闻标题太长不可长25！");
			return false;
		}
	if(newsContent.value.length <= 0)
		{
			alert("请填写内容！！！");
			return false;
		}
	return true;
}


</script>
<body>
	<%
		int newsid = Integer.parseInt(request.getParameter("newsId"));
		NewsDao newsDao = new NewsDao();
		NewsInfo newsInfo = newsDao.updateNews(newsid);
	%>
	<form action="../updateNewsServlet" method="post" onsubmit="return news()">
		<div id="container">
			<div id="right">
				<div class="content">
					<div class="rtbd">
						<div class="jyjl">
							<h2><img src="images/ibg1.jpg" />编辑新闻</h2>
						</div>
						<table class="tblist" width="100%" cellpadding="0" cellspacing="0">
							<tr>
								<td align="right">新闻标题</td>
								<td>
									<input type="text" style="width:328px;" name="newsTitle" id="newsTitle" value="<%=newsInfo.getNewsTitle() %>" />
									<input type="hidden" name="newsId" value="<%=newsid %>"/>
								</td>
							</tr>
							<tr>
								<td align="right">新闻内容</td>
								<td><textarea name="newsContent" id="newsContent" cols="60" rows="10"><%=newsInfo.getNewsContent() %></textarea></td>
							</tr>
							<tr>
								<td align="right">发布时间</td>
								<td><%=newsInfo.getNewsDate() %></td>
							</tr>
							<tr>
								<td width="200px;"></td>
								<td align="left"><input type="submit" style="margin-left:200" class="bbtnbg" value="确认修改"></td>
							</tr>
						</table>
					</div>
				</div>
			</div>
		</div>
	</form>
</body>
</html>