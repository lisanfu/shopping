<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="css/adminIndex.css" type="text/css" />
<script type="text/javascript">
	/*功能菜单折叠*/
	function displayNav(id){
		var nav = document.getElementById("nav" + id);
		if(nav.style.height == "30px")
			{
				nav.style.height="";
				
			}else
			{
				nav.style.height="30px"	
			}
	}
</script>
</head>
<body>
	<div id="left">
		<div id="nav0" class="nav">
			<dl>
				<dt onclick="displayNav(0)">基本功能</dt>
				<dd><a href="">图片管理</a></dd>
				<dd><a href="">系统日志</a></dd>
			</dl>
		</div>
		<div id="nav1" class="nav">
			<dl>
				<dt onclick="displayNav(1)">会员管理</dt>
				<dd><a href="">会员列表</a></dd>
				<dd><a href="">会员添加</a></dd>
				<dd><a href="">用户充值记录</a></dd>
			</dl>
		</div>
		<div id="nav2" class="nav">
			<dl>
				<dt onclick="displayNav(2)" >商品管理</dt>
				<dd><a href="">商品列表</a></dd>
				<dd><a href="">添加商品</a></dd>
				<dd><a href="">订单管理</a></dd>
				<dd><a href="">评价管理</a></dd>
			</dl>
		</div>
		<div id="nav3" class="nav">
			<dl>
				<dt onclick="displayNav(3)">新闻管理</dt>
				<dd><a href="">新闻列表</a></dd>
				<dd><a href="addnews.jsp" target="mainFrame">添加新闻</a></dd>
			</dl>
		</div>
		<div id="nav4" class="nav">	
    	<dl>
    		<dt onclick="displayNav(4)">管理员管理</dt>
    		<dd><a href="adminlist.jsp" target="mainFrame">管理员列表</a></dd>
    		<dd><a href="addAdmin.jsp" target="mainFrame">管理员添加</a></dd>
    	</dl>
    </div>	
	</div>
</body>
</html>