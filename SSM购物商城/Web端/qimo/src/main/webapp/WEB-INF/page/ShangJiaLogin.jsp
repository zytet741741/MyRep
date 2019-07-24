<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>商家登录</title>
</head>
<body>
	<a href="${pageContext.request.contextPath}/user/toLogin.do">用户登录</a>
	<form action="${pageContext.request.contextPath}/user/ShangJialogin.do" method="post">
		<input type="hidden" name="user_type_id" value="2" >
		账户:<input name="account" type="text"><br> 
		密码:<input name="password" type="password"><br>
		<input type="submit" value="登录" />
	</form>
		 <a href="${pageContext.request.contextPath}/user/ShangJiaToRegister.do"> 注册</a>
		 <td><input type="button" value="注册" onclick="${pageContext.request.contextPath}/user/toRegister.do">
</body>
</html>