<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>商品详细信息</title>
</head>
<body>
	<span id="user_account" hidden="true" name="user_account">用户名：${user.account}</span>
	<div>
	</div>
	<div>
		
	</div>
	<div align="center">
		
			<input type="hidden" value="${ user.account }" name="user_account" />
			<input type="hidden" value="1" name="number" />
			<table>
				<tr>
					<td><img height="100" width="100"
						src="${pageContext.request.contextPath}/${good.good_image }"></td>
				</tr>
				
				<tr>
					<td>商品id：</td>
					<td>
						${ good.id }
					</td>
				</tr>
				<tr>
					<td>商品名：</td>
					<td>
						${ good.good_name }
						<input type="hidden" value="${ good.good_name }" name="good_name" />
					</td>
				</tr>
				<tr>
					<td>商品简介：</td>
					<td>
						${ good.good_content }
						<input type="hidden" value="${ good.good_content }" name="good_content" />
					</td>
				</tr>
				<tr>
					<td>商品价格：</td>
					<td>
						${ good.good_price }
						<input type="hidden" value="${ good.good_price }" name="good_price" />
					</td>
				</tr>
				

				
				<tr>
					<td><a href="${pageContext.request.contextPath}/goods/toUpdateGoods.do?user_account=${user.account}&&good_name=${good.good_name}">修改商品信息</a></td>
					
					<td><a href="${pageContext.request.contextPath}/goods/delGood.do?user_account=${user.account}&&good_name=${good.good_name}">删除商品</a></td>
				
				</tr>
				
				
				
			</table>
			<a href="${pageContext.request.contextPath}/goods/findGood.do?user_account=${user.account}">返回</a>
	</div>

</body>
</html>