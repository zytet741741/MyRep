<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>用户登录</title>
</head>
<body>
	<a href="${pageContext.request.contextPath}/user/toShangJia.do">商家登录</a>
	<form action="${pageContext.request.contextPath}/user/login.do" method="post">
		<input type="hidden" name="user_type_id" value="1" >
		账户:<input name="account" type="text"><br> 
		密码:<input name="password" type="password"><br>
		<input type="submit" value="登录" />
	</form>
		 <a href="${pageContext.request.contextPath}/user/toRegister.do"> 注册</a>
		
</body>
</html>