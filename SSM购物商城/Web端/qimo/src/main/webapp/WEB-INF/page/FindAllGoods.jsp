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
	
	<div align="center">
	<div>
		<a href="${pageContext.request.contextPath}/user/shangJiaInfo.do?user_account=${user.account}">商家个人信息</a>
		<a href="${pageContext.request.contextPath}/goods/findGood.do?user_account=${user.account}">查询商品信息</a>
		<a href="${pageContext.request.contextPath}/goods/toAddGood.do?user_account=${user.account}">增加商品</a>
		<a href="${pageContext.request.contextPath}/user/ShangJialogin.do">返回</a>
	</div>
		<table>
			<tr>
				
				<td>商品图片</td>
				<td>商品id</td>
				<td>商品名称</td>
				<td>商品价格</td>
				<td>操作</td>
			</tr>
			<c:forEach items="${findGood}" var="findGood">
				<tr>
					<td><img height="100" width="100"
						src="${pageContext.request.contextPath}/${findGood.good_image }"></td>
					<td>${findGood.id}</td>	
					<td>
						<a href="${pageContext.request.contextPath}/goods/findGoodInfo.do?good_name=${findGood.good_name}">${findGood.good_name}</a>
					</td>
					<td>${findGood.good_price}</td>
					<td>${findGood.goodType.good_type_name}</td>
					<td><a href="${pageContext.request.contextPath}/goods/delGood.do?user_account=${user.account}&&good_name=${findGood.good_name}">删除</a></td>
					
				</tr>
			</c:forEach>
		</table>
	</div>
</body>
</html>