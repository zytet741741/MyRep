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
		<form action="${pageContext.request.contextPath}/goods/addGood.do?account=${user.account}">
			<input type="hidden" name="account" value="${user.account}" />
			<table>
			
					<tr>
					<td>商品图片:</td>
					<td><input type="text" name="good_image" /></td>
				</tr>
				<tr>
					<td>商品类型id:</td>
					<td><input type="text" name="good_type_id" required="required" placeholder="1为游戏,2为食物,3为服装" /></td>
				</tr>
				<tr>
					<td>商品名:</td>
					<td><input type="text" name="good_name" required="required" /></td>
				</tr>
				<tr>
					<td>商品说明:</td>
					<td><input type="text" name="good_content" required="required" /></td>
				</tr>
				<tr>
					<td>商品价格:</td>
					<td><input type="text" name="good_price" required="required" /></td>
				</tr>
				
				<tr>
					<td><input type="submit" value="确认添加"></td>
					
					
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

								window.history.back(-1);
							});
		});
	</script>
</body>
</html>