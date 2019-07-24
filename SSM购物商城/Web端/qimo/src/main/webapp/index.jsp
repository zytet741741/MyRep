<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="ie=edge">
<title>主页</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/main.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/index.css">

</head>

<body>
	<!-- 头部菜单栏 -->
	<header class="over-hid header ">
		<div class="w-width over-hid auto-m">
			<!-- 左边菜单 -->
			<ul class="l-ul  ">
				<li class="" style="position: relative;"><span class="h-menu-t">用户信息</span>
					<ul class="mean-text">
						<li>基本信息</li>
						<li>修改密码</li>
						<li>忘记密码</li>
					</ul></li>



				<li><span class="h-menu-t">消息</span></li>
				<li></li>
			</ul>
			<ul class="r-ul">
				<li><span class="h-menu-t">购物车</span></li>
				<li><span class="h-menu-t">订单</span></li>
				<li><span class="h-menu-t">收藏夹</span></li>
				<li><span class="h-menu-t">愿望单</span></li>
			</ul>
		</div>
	</header>

	<!-- 搜索框 -->
	<div class="sreach">

		<div class="s-logo"></div>
		<div class="s-input">
			<form action="#" style="position: relative;">
				<span class="s-sreach"> <input type="text" name="sreach">
				</span> <input type="submit" value="搜索">
			</form>
		</div>

	</div>





</body>

</html>