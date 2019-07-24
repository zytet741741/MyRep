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
			<input type="hidden" name="account" value="${user.account}" />
			<table>
				<tr>
					<td>账户:</td>
					<td>${ user.account }</td>
				</tr>
				<tr>
					<td>用户名:</td>
					<td>${ user.username }</td>
				</tr>
				<tr>
					<td>密码:</td>
					<td>${ user.password }</td>
				</tr>
				<tr>
					<td>性别:</td>
					<td>${ user.sex }</td>
				</tr>
				<tr>
					<td>手机:</td>
					<td>${ user.phone }</td>
				</tr>
				<tr>
					<td>地址:</td>
					<td>${ user.address }</td>
				</tr>
				<tr>
					<td><a href="${pageContext.request.contextPath}/user/toUpdate.do?user_account=${user.account}">修改信息</a></td>
				</tr>
			</table>
		</form>
	</div>
	<p style="color: red;">${msg}</p>
	
	
	<script type="text/javascript"
		src="${pageContext.request.contextPath}/js/jquery.js"></script>
	<script>
		$(function() {
			$("#back")
					.on(
							"click",
							function() {

								window.location.href = "${pageContext.request.contextPath}/goods/allGood.do";
							});
		});
	</script>
</body>
</html>