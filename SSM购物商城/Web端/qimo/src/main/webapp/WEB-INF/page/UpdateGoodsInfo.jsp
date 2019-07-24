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
	<div align="center">
		<button id="back">返回</button>	
		<form action="${pageContext.request.contextPath}/goods/updateGoodsInfo.do?account=${user.account}&&good_name=${good.good_name}">
			<input type="hidden" name="account" value="${user.account}" />
			<input type="hidden" name="good_name" value="${good.good_name}" />
			<table>
				
				<tr>
					<td>商品图片:</td>
					<td><img height="100" width="100"
						src="${pageContext.request.contextPath}/${good.good_image }">
					</td>
				</tr>
				<tr>
					<td>商品id:</td>
					<td>${ good.id }</td>
				</tr>
				<tr>
					<td>商品名:</td>
					<td>${ good.good_name }</td>
				</tr>
				<tr>
					<td>商品说明:</td>
					<td><input type="text" name="good_content" required="required" value="${ good.good_content }" /></td>
				</tr>
				<tr>
					<td>商品价格:</td>
					<td><input type="text" name="good_price" required="required" value="${ good.good_price }" /></td>
				</tr>
				<tr>
					<td><input type="submit" value="确认修改"></td>
					
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

								window.location.href = "${pageContext.request.contextPath}/goods/findGoodInfo.do?account=${user.account}&&good_name=${good.good_name}";
							});
		});
	</script>
</body>
</html>