<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>商家注册</title>
</head>
<body>
	<form action="${pageContext.request.contextPath}/user/ShangJiaAddRegister.do" method="post">
		账户:<input name="account" type="text"><br> 
		密码:<input name="password" type="password"><br>
		用户名:<input name="username" type="text"><br> 
		性别<input name="sex" type="radio" value="男" checkeed>男
		   <input name="sex" type="radio" value="女">女<br>
		<!-- 性别:<input name="sex" type="text"><br>  -->
		电话:<input name="phone" type="text"><br> 
		地址:<input name="address" type="text"><br> 
		<input type="hidden" name="user_type_id" value="2" >
		<input type="submit" value="注册" />
	</form>
</body>
</html>