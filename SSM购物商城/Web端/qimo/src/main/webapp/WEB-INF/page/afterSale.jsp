<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>我的订单</title>
</head>
<body>
	<div>
		<select id="statusName">
		 	 <option value="0">请选择</option> 
			<c:forEach var="order_type" items="${order_type }">
				<option 
					<c:if test="${order_type.id == orderTypeId }">selected="selected"
					</c:if>
						 value="${order_type.id }">
				 		${order_type.status_name }
				 </option>
			</c:forEach>
		</select>
		<button id="button_statusName">查询</button>
	</div>

<div id = "tableOne">
	<table class="table table-bordered table-striped" id="mytable"
							border="1">
		<tr>
			<th>商品名称</th>
			<th>商品价格</th>
			<th>商品数量</th>
			<th>退款状态</th>
			<th>交易操作</th>
		</tr>
	 	<c:if test="${goods_afterSale !=null }">  
			<c:forEach items="${goods_afterSale }" var="afterSale">
				<tr>
					<td>${afterSale.good_name }</td>
					<td>${afterSale.price }</td>
					<td>${afterSale.order.count }</td>
					<td>${afterSale.orderType.status_name }</td>
					
					<!-- 1111111111111111111111111111111111111111 -->
					<td>
						<a>详情</a>
					
					
					</td>
			
	
				    <!--111111111111111  -->
					
				</tr>
			</c:forEach>	
	 	</c:if> 
	</table>
</div>
	<%-- <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.js"> </
		var statusName = $("#statusName option:selected").val();
	</script> --%>
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.js"></script>
	<script src="${pageContext.request.contextPath}/js/jquery.min.js"></script>
	<script>
		$(function() {
			$("#button_statusName").click(
				function() {
					var orderTypeId = $("#statusName option:selected").val();
					alert(orderTypeId);
								$.ajax({
										url : "${pageContext.request.contextPath}/goods/afterSale1.do",
										data : {"orderTypeId" : orderTypeId},
											success : function(data) {
												if (data == 'SUCCESS') {
													alert("成功");
													 window.location.reload(); 
												} else {
													alert("失败");
												}
											},
											error : function(data) {
												alert("123：" + data.result);
											} 
										});
							});
		});
	</script>
</body>
</html>