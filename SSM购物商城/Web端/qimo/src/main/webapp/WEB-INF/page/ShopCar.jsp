<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>购物车</title>
</head>
<body>
	<!-- ******************************zyt****************************** -->
	<span id="user_account" hidden="true" name="user_account">用户名：${user.account}</span>
	<div>
		<table>
			<tr>
				<th></th>
				<th>商品名称</th>
				<th>商品价格</th>
				<th>商品简介</th>
				<th>用户</th>
				<th>数量</th>
				<th>操作</th>
			</tr>
			<c:forEach items="${shopCar}" var="shopCar">
				<tr>
					<td><img height="100" width="100"
						src="${pageContext.request.contextPath}/${shopCar.good_image }"></td>
					<td>${shopCar.good_name}</td>
					<td>${shopCar.good_price}</td>
					<td>${shopCar.good_content}</td>
					<td>${shopCar.user_account}</td>
					<td>${shopCar.number}</td>
					<td><a href="${pageContext.request.contextPath}/goods/delCarGood.do?user_account=${user.account}&good_name=${shopCar.good_name}">删除</a></td>
				</tr>
				<tr>
					<td>
						<form action="${pageContext.request.contextPath}/goods/addInOrder.do?user_account=${user.account}"">
							<input type="hidden" value="${ shopCar.good_image }" name="good_image" />
							<input type="hidden" value="${ shopCar.good_name }" name="good_name" />
							<input type="hidden" value="${ shopCar.good_price }" name="good_price" />
							<input type="hidden" value="${ user.account }" name="user_account" />
							<input type="hidden" value="${ shopCar.number }" name="number" />
							<input type="hidden" value="${ shopCar.good_price }" name="good_total_price" />
							<input type="hidden" value="4" name="order_type_id" />
							<input type="submit" value="添加商品到订单" />
						</form>
				</td>
				</tr>
			</c:forEach>

		</table>
	</div>
</body>
</html>