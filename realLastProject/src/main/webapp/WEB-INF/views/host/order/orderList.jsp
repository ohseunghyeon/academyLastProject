<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="../../menu/hostHeader.jsp" flush="false" />
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
<div class="container-fluid">
<h2><p class="text-center">OrderList</p></h2>
  <div class="row">
  <div class="col-sm-2" style="background-color:lavender;"></div>
  <div class="col-sm-8" style="background-color:lavender;">
		<table class="table table-striped table-bordered table-hover table-condensed text-center" >
		<thead>
			<tr><p class="text-center">
				<th width="100"><h4><p class="text-center">주문 번호</p></h4></th>
				<th width="100"><h4><p class="text-center">테이블 번호</p></h4></th>
				<th width="400"><h4><p class="text-center">주문내역</p></h4></th>
				<th width="150"><h4><p class="text-center">확인</p></h4></th></p>			
			</tr>
			</thead>
			<c:if test="${hostOrderlist != null}">
				<c:forEach var="hostOrder" items="${hostOrderlist}">
					<tr>
						<td><t4>${hostOrder.order_id}</t4></td>
						<td><t4>${hostOrder.seat_num}</t4></td>
						<td><t4>${hostOrder.food_name}</t4></td>
						<td><t4><input type="button" value="확인"
							onclick="orderDoneConfirm(${hostOrder.order_id})"></t4> </td>
					</tr>
				</c:forEach>
			</c:if>
			<c:if test="${hostOrderlist == null}">
				<tr>
					<td colspan="4">나갈 주문이 없습니다.</td>
				</tr>
			</c:if>
		</table>
	</div>
	<div class="col-sm-2" style="background-color:lavender;"></div>
</div>
</div>
<jsp:include page="../../menu/hostFooter.jsp" flush="false" />
