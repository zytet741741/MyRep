<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<style type="text/css">

/* #left {
	height: 200px;
	width: 300px;
	float: left;
} */
#right {
	height: 150px;
	width: 400px;
	float: left;
}

#input {
	height: 100px;
	width: 300px;
}

#content {
	height: 100%;
	width: 100%;
}

.sreach_photo {
	height: 50px;
	width: 100%;
	background-image: url(/image/1.jpg);
}

.one {
	width: 200%;
	height: 100%;
}

.menu {
	width: 100%;
	display: flex;
	align-items: center;
	justify-content: center;
}

.menu .menu-item {
	position: relative;
	cursor: pointer;
}

.menu .menu-item .wee {
	height: 2px;
	width: 100%;
	background-color: #002b75;
	position: absolute;
	left: 0;
	bottom: 0;
	transition: 0.75s;
}

.menu .menu-item h2 {
	margin: 0;
	padding: 0 9rem 1rem;
	font-size: 1rem;
	color: #232323;
	transition: 0.75s;
}

.menu .menu-item:hover h6 {
	color: #002b75;
}

.menu .current-menu-item h6 {
	color: #002b75;
}
</style>

<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/main.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/index.css">


<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/bootstrap.min.css">
<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/jquery.js"></script>
<script src="${pageContext.request.contextPath}/js/jquery.min.js"></script>
<script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
<title>Insert title here</title>


</head>
<body>
	<%--     <a href="${pageContext.request.contextPath}/goods/allSale.do">全部订单</a>
	<a href="${pageContext.request.contextPath}/goods/Unpay.do">待付款</a>
	<a href="${pageContext.request.contextPath}/goods/Unshiped.do">待发货</a>
	<a href="${pageContext.request.contextPath}/goods/Received.do">待收货</a>
	<a href="${pageContext.request.contextPath}/goods/Evaluated.do">待评价</a> --%>

	<header class="over-hid header ">
		<div class="w-width over-hid auto-m">
			<!-- 左边菜单 -->
			<ul class="l-ul  ">
				<li class="" style="position: relative;"><span class="h-menu-t">用户信息</span>
					<ul class="mean-text">
						<li>基本信息</li>
						<li>修改密码</li>
						<li>忘记密码</li>
					</ul></li>



				<li><span class="h-menu-t">消息</span></li>
				<li></li>
			</ul>
			<ul class="r-ul">
				<li><span class="h-menu-t">购物车</span></li>
				<li><span class="h-menu-t"><a
						href="${pageContext.request.contextPath}/goods/allSale.do">订单</a></span></span></li>
				<li><span class="h-menu-t">收藏夹</span></li>
				<li><span class="h-menu-t">愿望单</span></li>
			</ul>
		</div>
	</header>

	<!-- 搜索框 -->
	<div class="sreach_photo"></div>
	<c:forEach items="${AddEvaluated }" var="AddEvaluated">
		<img height="200" width="200" src="${pageContext.request.contextPath}/${AddEvaluated.good_image }">
		
		<form id="formOne" onsubmit="return false" method="post">
			<input type="text" name="orderId" hidden="hidden" value="${AddEvaluated.id }"/> 
			<div>
				评价：
				<textarea name="evaluated" style="resize: none" rows="3" cols="40"></textarea>
			</div>
			<div class="div-submit">
				<input type="button" value="发表评论" onclick="eva()">
			</div>
		</form>
	</c:forEach>
	
	
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.js"></script>
	<script src="${pageContext.request.contextPath}/js/jquery.min.js"></script>
	<script type="text/javascript">
	/* 	function evaluated(){
			$.ajax({
				type:"POST",
				dataType:"text",
				url:"${pageContext.request.contextPath}/goods/AddEvaluated.do",
				data:$('#formOne').serialize(),
				success:function(result){
					alert("SUCCESS");
				},
				error:function(result){
					alert("失败："+result);
				}
			});
		} */
		function eva(){
			$.ajax({
				type:"POST",
				dataType:"text",
				url:"${pageContext.request.contextPath}/goods/AddEvaluated.do",
				data:$('#formOne').serialize(),
				success:function(result){
					alert("评价成功");
					
						window.location.href="${pageContext.request.contextPath}/goods/allSale.do";
				
				},
				error:function(result){
					alert("失败："+result);
				}
			});
		}
	
	</script>

</body>
</html>