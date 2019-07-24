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
				<li><span class="h-menu-t"><a href="${pageContext.request.contextPath}/goods/allSale.do">订单</a></span></li>
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

    <span id="user_account" hidden="true" name="user_account">用户名：${user.account}</span>
	<table class="table table-bordered table-striped" id="mytable" border="1">
		<tr>
			<th>商品名称</th>
			<th>商品价格</th>
			<th>商品数量</th>
			<th>退款状态</th>
			<th>交易操作</th>
		</tr>
	 	<%-- <c:if test="${allSale !=null }">   --%>
	 	<%-- <span>${allSale }</span> --%>
			<c:forEach items="${allSale }" var="allSale">
				<tr>
					<td>
						<div>
							<img height="100" width="100" src="${pageContext.request.contextPath}/${allSale.order.good_image }">
						</div>
						<div>
							${allSale.good_name}
						</div>
					</td>
					<td>${allSale.good_price }</td>
					<td>${allSale.order.good_number }</td>
					<td>${allSale.orderType.order_status_name }</td>
					 
					<td>
						<div class="btn-group">
							<button class="btn btn-default dropdown-toggle"
								data-toggle="dropdown" type="button">
								操作<span class="caret"></span>
							</button>
							<ul class="dropdown-menu">
								<li><a href="##">详情</a></li>
								 <c:if test="${allSale.order.order_type_id == 1}"> 
									<li><a class="pay" data-payid="${allSale.order.id}">立即付款</a></li>
								 </c:if>
								<c:if test="${allSale.order.order_type_id == 3}">
									<li><a class="received" data-reid="${allSale.order.id}">确认收货</a></li>
								</c:if>
								<c:if test="${allSale.order.order_type_id == 4}">
									<li><a href="${pageContext.request.contextPath}/goods/ToEvaluated.do?orderId=${allSale.order.id}&&user_account=${user.account}">立即评价</a></li>
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
		
		//立即付款
		$(document).on("click", ".pay", function(){
			var orderId = $(this).data("payid");
			var account = $("#account").html();
			//alert("account"+account);
			$.ajax({
				url:"${pageContext.request.contextPath}/goods/ToPay.do",
				data: {"orderId": orderId, "username": account},
				success:function(data){
					window.location.href="${pageContext.request.contextPath}/goods/allSale.do?user_account="+account;
				},
				error: function(data){
					alert("error");
				}				
			});
		});
		
		//确认收货
		$(document).on("click", ".received", function(){
			var orderId = $(this).data("reid");
			var account = $("#account").html();
			/* alert("orderId"+orderId); */
			 $.ajax({
				url:"${pageContext.request.contextPath}/goods/ToReceived.do",
				data: {"orderId": orderId, "username": account},
				success:function(data){
					alert(data);
					window.location.href="${pageContext.request.contextPath}/goods/allSale.do?user_account="+account;
				},
				error: function(data){
					alert(data);
				}				
			}); 
		});
		
		
	</script>

</body>
</html>