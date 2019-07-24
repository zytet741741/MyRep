<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>用户信息</title>
</head>
<body>
	<div>
		<button id="back">返回</button>	
		<form action="${pageContext.request.contextPath}/user/updateUserInfo.do?account=${user.account}">
			<input type="hidden" name="account" value="${user.account}" />
			<table>
				<tr>
					<td>账户:</td>
					<td>${ user.account }</td>
				</tr>
				<tr>
					<td>用户名:</td>
					<td><input type="text" name="username" required="required" value="${ user.username }" /></td>
				</tr>
				<tr>
					<td>密码:</td>
					<td><input type="text" name="password" required="required" value="${ user.password }" /></td>
				</tr>
				<tr>
					<td>性别:</td>
					<td><input type="text" name="sex" required="required" value="${ user.sex }" /></td>
				</tr>
				<tr>
					<td>手机:</td>
					<td><input type="text" name="phone" required="required" value="${ user.phone }" /></td>
				</tr>
				<tr>
					<td>地址:</td>
					<td><input type="text" name="address" required="required" value="${ user.address }" /></td>
				</tr>
				<tr>
					<td><input type="submit" value="确认修改"></td>
					<td><input type="reset" value="重置"></td>
				</tr>
			</table>
		</form>
	</div>
	
	
	<script type="text/javascript"
		src="${pageContext.request.contextPath}/js/jquery.js"></script>
	<script>
		$(function() {
			$("#back")
					.on(
							"click",
							function() {

								window.location.href = "${pageContext.request.contextPath}/user/UserInfo.do";
							});
		});
	</script>
</body>
</html>