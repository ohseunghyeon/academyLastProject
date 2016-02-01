<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<head>
<script type="text/javascript">
	function orderDoneConfirm(order_id) {
		if (confirm(order_id + "의 주문을 완료함?")) {
			return window.location="makeOrderDone?order_id=" + order_id;
		} else {
			return false;
		}
	}
	
</script>
</head>
<body>
	<div id="nav">
		<p>CAFE SASAEG</p>
		<ul>
			<li><a href="seatList">좌석 </a></li>

			<li><a href="hostOrderList">주문 </a></li>

		</ul>
	</div>
	<fieldset>
		<legend>
			<font color="orange"><b>OrderList</b></font>
		</legend>

		<table border="1" id="payment" cellspacing="0" cellpadding="0">
			<tr>
				<th width="200" height="15">주문 번호</th>
				<th width="200" height="15">테이블 번호</th>
				<th width="200" height="15">주문내역</th>
				<th width="200" height="15">확인</th>				
			</tr>
			<c:if test="${hostOrderlist != null}">
				<c:forEach var="hostOrder" items="${hostOrderlist}">
					<tr>
						<td>${hostOrder.order_id}</td>
						<td>${hostOrder.seat_num}</td>
						<td>${hostOrder.food_name}</td>
						<td><input type="button" value="확인"
							onclick="orderDoneConfirm(${hostOrder.order_id})"> </td>
					</tr>
				</c:forEach>
			</c:if>
			<c:if test="${hostOrderlist == null}">
				<tr>
					<td colspan="4">나갈 주문이 없습니다.</td>
				</tr>
			</c:if>
		</table>
	</fieldset>
</body>
