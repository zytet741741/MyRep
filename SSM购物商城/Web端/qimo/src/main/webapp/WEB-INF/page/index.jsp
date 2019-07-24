<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<span id="user_account" hidden="true" name="user_account">用户名：${user.account}</span>
	<%-- <a href="${pageContext.request.contextPath}/goods/afterSale.do">全部订单</a> --%>
	<a href="${pageContext.request.contextPath}/goods/allSale
	.do?user_account=${user.account}">全部订单</a>
	<a href="${pageContext.request.contextPath}/user/userInfo.do?user_account=${user.account}">个人信息</a>
	<a href="${pageContext.request.contextPath}/goods/allGood.do">商品主页</a>
	<a href="${pageContext.request.contextPath}/goods/Unpay.do">待付款</a>
	<a href="${pageContext.request.contextPath}/goods/Unshiped.do">待发货</a>
	<a href="${pageContext.request.contextPath}/goods/Received.do">待收货</a>
	<a href="${pageContext.request.contextPath}/goods/Evaluated.do">待评价</a>
	<a href="${pageContext.request.contextPath}/goods/test.do">test</a>
	<a href="${pageContext.request.contextPath}/goods/afterSale.do">after</a>
	
	<%-- <c:forEach items="${user }" var="user">
		<td>${user.account }</td>
	</c:forEach> --%>
	
	<%-- <select id="userId" name="userId">
    <option value="0">=请选择=</option>
	<option value="1">请选择</option>
    <c:forEach var="listUsrUser" items="${listUsrUser}"> 
        <option value="${listUsrUser.usrId}">${listUsrUser.loginName}</option>
    </c:forEach>
	</select> --%>
</body>
</html>