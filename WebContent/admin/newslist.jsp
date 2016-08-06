<%@ page language="java" import="java.util.*,com.ay.shopping.entities.*,com.ay.shopping.dao.*" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    	int pageSize = 5;//每页显示的条目数
    	int pageNow = 1;//默认显示第一页
    	int pageCount = 1;//默认只有一页
		NewsDao  newsDao = new NewsDao();
    	if(request.getParameter("pageNow") != null)
    	{
    		pageNow = Integer.parseInt(request.getParameter("pageNow"));
    	}
    	pageCount = newsDao.getNewsCount(pageSize);//获得总页数
    	if(pageNow <= 1)
    	{
    		pageNow = 1;
    	}
    	if(pageNow >= pageCount)
    	{
    		pageNow = pageCount;
    	}
    	ArrayList<NewsInfo> newsList = newsDao.getNewsForPage(pageSize,pageNow);
    
    %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="css/adminIndex.css" type="text/css" />
</head>
<script type="text/javascript">
 function pageGo(){
	 var pageNow = document.getElementById("pageNow");
	 if(pageNow.value.length == 0)
		 {
		 alert("请输入要跳转的页数");
		 pageNow.value = "";
		 pageNow.focus();
		 return ;
		 }
	 if(isNaN(pageNow.value))
		 {
		 alert("请输入正确的页数");
		 pageNow.value="";
		 pageNow.focus();
		 return ;
		 }
	 window.location.href="newslist.jsp?pageNow="+pageNow.value;	 
 }

</script>
<body>
	<div id="container">
		<div id="right">
			<div class="content">
				<div class="trdb">
					<div class="jyjl">
						<h2><img src="images/ibg1.jpg">新闻管理</h2>
					</div>
					<table class="user" width="100%" border="0" cellpadding="0" cellspacing="0">
						<tr>
							<th>新闻编号</th>
							<th>新闻标题</th>
							<th>发布时间</th>
							<th>操作</th>
						</tr>
						<%
							for(NewsInfo news : newsList)
							{
						%>
						<tr onmousemove="this.style.backgroundColor'#ffffcc'" onmountsetout="this.style.backgroundColor''">
							<td style="border-left:#D8E7F6 1px solid;"><%=news.getNewsId() %></td>
							<td><%=news.getNewsTitle() %></td>
							<td><%=news.getNewsDate() %></td>
							<td>
							 <a href="updatenews.jsp?newsId=<%=news.getNewsId() %>"><img alt="编辑新闻" src="images/icon3.gif" /></a>
							 	|<a href="../deleteNewsServlet?newsId=<%=news.getNewsId() %>" onclick="return confirm('确定要删除吗？')"><img alt="删除新闻" src="images/icon4.gif" /></a>
							</td>
						</tr>
						<%} %>
						<tr>
							<td style="border-left:#CFE0F0 1px solid;" colspan="7">
								<a href="newslist.jsp?pageNow=1">首页</a>
								<a href="newslist.jsp?pageNow=<%=pageNow-1 %>">上一页</a>
								<font style="color:red; font-size:12px;"><%=pageNow %>/<%=pageCount %></font>
								<a href="newslist.jsp?pageNow=<%=pageNow+1 %>">下一页</a>
								<a href="newslist.jsp?pageNow=<%=pageCount %>">尾页</a>
								<font style="color: red; font-size: 12px;">到第</font><input type="text" style="width: 20px;height: 20px;" id="pageNow"><font style="color: red; font-size: 12px;">页</font>
                  				<a href="javascript:pageGo()">跳转</a> 
							</td>
						</tr>
					</table>
				</div>
			</div>
		</div>
	</div>
</body>
</html>