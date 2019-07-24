<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>商家界面</title>
</head>
<body>
<a href="${pageContext.request.contextPath}/user/shangJiaInfo.do?user_account=${user.account}">商家个人信息</a>
<a href="${pageContext.request.contextPath}/goods/findGood.do?user_account=${user.account}">查询商品信息</a>
<a href="${pageContext.request.contextPath}/goods/toAddGood.do?user_account=${user.account}">增加商品</a>
</body>
</html>