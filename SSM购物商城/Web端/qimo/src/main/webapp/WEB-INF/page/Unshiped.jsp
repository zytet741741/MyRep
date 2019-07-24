<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<style type="text/css">

#content {
	height: 100%;
	width: 100%;
}

.sreach_photo{
height:50px;
width:100%;
background-image: url(/image/1.jpg);
}
.one{
	width:200%;
	height:100%;
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

.menu .menu-item:hover h6 { color: #002b75; }

.menu .current-menu-item h6 { color: #002b75; }            
</style>
	
	<link rel="stylesheet" href="${pageContext.request.contextPath}/css/main.css">
	<link rel="stylesheet" href="${pageContext.request.contextPath}/css/index.css">


	<link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.min.css">
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.js"></script>
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
				<li><span class="h-menu-t"><a href="${pageContext.request.contextPath}/goods/allSale.do">订单</a></span></span></li>
				<li><span class="h-menu-t">收藏夹</span></li>
				<li><span class="h-menu-t">愿望单</span></li>
			</ul>
		</div>
	</header>

	<!-- 搜索框 -->
	<div class="sreach_photo">

	</div>
	

	<div class="one"></div>
		<div class="menu">
		  <div class="menu-item current-menu-item">
		    <h2><a href="${pageContext.request.contextPath}/goods/allSale.do">全部订单</a></h2>
		    <div class="wee"></div>
		  </div>
		  <div class="menu-item">
		    <h2><a href="${pageContext.request.contextPath}/goods/Unpay.do">待付款</a></h2>
		  </div>
		  <div class="menu-item">
		    <h2> <a href="${pageContext.request.contextPath}/goods/Unshiped.do">待发货</a></h2>
		  </div>
		  <div class="menu-item">
		  <h2>  <a href="${pageContext.request.contextPath}/goods/Received.do">待收货</a></h2>
		  </div>
		  <div class="menu-item">
		  <h2>  <a href="${pageContext.request.contextPath}/goods/Evaluated.do">待评价</a></h2>
		  </div>
		</div>
</div>	

    
	<table class="table table-bordered table-striped" id="mytable" border="1">
		<tr>
			<th>商品名称</th>
			<th>商品价格</th>
			<th>商品数量</th>
			<th>退款状态</th>
			<th>交易操作</th>
		</tr>
	 	<%-- <c:if test="${allSale !=null }">   --%>
			<c:forEach items="${Unshiped }" var="Unshiped">
				<tr>
					<td>${Unshiped.good_name }</td>
					<td>${Unshiped.price }</td>
					<td>${Unshiped.order.count }</td>
					<td>${Unshiped.orderType.status_name }</td>
					<%-- <td>${allSale.orderType.id }</td> --%>
					
					<td>
						<div class="btn-group">
							<button class="btn btn-default dropdown-toggle"
								data-toggle="dropdown" type="button">
								操作<span class="caret"></span>
							</button>
							<ul class="dropdown-menu">
								<li><a href="##">详情</a></li>
								 <c:if test="${Unshiped.order.status == 1}"> 
									<li><a href="${pageContext.request.contextPath}/goods/ToPay.do?orderId=${allSale.order.id}">立即付款</a></li>
								 </c:if>
								<c:if test="${Unshiped.order.status == 3}">
									<li><a href="${pageContext.request.contextPath}/goods/ToReceived.do?orderId=${allSale.order.id}">确认收货</a></li>
								</c:if>
								<c:if test="${Unshiped.order.status == 4}">
									<li><a href="##">立即评价</a></li>
								</c:if>
							</ul>
						</div>
					</td>
					
				</tr>
			</c:forEach>	
	<%--  	</c:if>  --%>
	</table>

	<script src="js/jquery.min.js" type="text/javascript"></script></script>
	<script>window.jQuery || document.write('<script src="js/jquery-1.11.0.min.js"><\/script>')</script>
	<script type="text/javascript">
		$(document).ready(function() {
		  // cool nav menu
		  $(window).on('load resize', function() {
		    var $thisnav = $('.current-menu-item').offset().left;

		    $('.menu-item').hover(function() {
		      var $left = $(this).offset().left - $thisnav;
		      var $width = $(this).outerWidth();
		      var $start = 0;
		      $('.wee').css({ 'left': $left , 'width': $width });
		    }, function() {
		      var $initwidth = $('.current-menu-item').width();
		      $('.wee').css({ 'left': '0' , 'width': $initwidth });
		    });
		  });
		});
	</script>

</body>
</html>