<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>主页商品</title>
</head>
<body>
	<span id="user_account" hidden="true" name="user_account">用户名：${user.account}</span>
	<div>
		<a href="${pageContext.request.contextPath}/goods/shopCar.do?user_account=${user.account}">购物车</a>
		<a href="${pageContext.request.contextPath}/user/userInfo.do?user_account=${user.account}">个人信息</a>
	</div>
	<div>
		<table>
			<tr>
				<th></th>
				<th>商品名称</th>
				<th>商品价格</th>
			</tr>
			<c:forEach items="${allGood}" var="allGood">
				<tr>
					<td><img height="100" width="100"
						src="${pageContext.request.contextPath}/${allGood.good_image }"></td>
					<td>
						<a href="${pageContext.request.contextPath}/goods/queryGoodInfo.do?good_name=${allGood.good_name}">${allGood.good_name}</a>
					</td>
					<td>${allGood.good_price}</td>
				</tr>
			</c:forEach>
		</table>
	</div>
</body>
</html>