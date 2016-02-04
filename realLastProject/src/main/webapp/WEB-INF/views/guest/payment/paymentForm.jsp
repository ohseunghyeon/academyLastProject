<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html lang="en" xmlns="http://www.w3.org/1999/xhtml">

<script src="/lastproject/resources/angular.js"></script>

<style>

#tt {

background:#FFBC9B;
}


</style>


<script type="text/javascript">


function couponPage(){
	window.open("coupon" ,"manubar=no,width= 500,height=200");
}
function sale(){
var mileage = document.getElementsByName("mileage1")[0].value;

document.paymentForm.discount.value = mileage;
}


</script>


</head>
<!--쿠폰 페이지  -->

<c:if test="${sessionScope.id == 'nomember'}">
<jsp:include page="../../menu/noMemberHeader.jsp" flush="false" />
</c:if>
<c:if test="${sessionScope.id != 'nomember'}">
<jsp:include page="../../menu/guestHeader.jsp" flush="false" />
</c:if>

<body>
<h3><p class="text-center"><font color="orange" size="6"><b>Payment </b></font></p></h3>
<div class="container-fluid text-center">    
  <div class="row content">
    <div class="col-sm-2 sidenav">
    </div>
    <div class="col-sm-8 text-left"> 

	<form action="paymentFinish" method="post" name="paymentForm">
		<fieldset id="content">
			<legend>
				<font color="orange"><b><small>Payment</small> </b></font>
			</legend>
			<br>
			<fieldset>
				<legend>
					<font color="orange"><b>ProductInfo</b></font>
				</legend>
				<table class="table table-striped table-bordered table-hover table-condensed text-center" id="payment" cellspacing="10" cellpadding="0">
					<tr id="tt" >
						<th width="200" height="15"><p class="text-center">상품정보</p></th>
						<th width="200" height="15"><p class="text-center">수량</p></th>
						<th width="200" height="15"><p class="text-center">상품금액</p></th>
						<th width="200" height="15"><p class="text-center">마일리지</p></th>
						<th width="200" height="15"><p class="text-center">주문금액</p></th>
					</tr>
					<c:forEach var="foodDto" items="${shoppingBagForPayment}">
						<input type="hidden" name="food_code" value="${foodDto.food_code}">
						<input type="hidden" name="food_num" value="${foodDto.food_num}">
						<tr>
							<td>${foodDto.food_name}</td>
							<td>${foodDto.food_num}</td>
							<td>${foodDto.price}원</td>
							<td>${foodDto.price * foodDto.food_num * 0.05}</td>
							<td>${foodDto.price * foodDto.food_num}원</td>
						</tr>
					</c:forEach>
				</table>
			</fieldset>

			<fieldset>
				<legend>
					<font color="orange"><b>Coupon/Discount</b></font>
				</legend>

				<table class="table table-bordered table-hover table-condensed text-center" id="payment" cellspacing="5">
					<tr>
						<th id="tt" width="200" height="15"><p class="text-center">보유 쿠폰 할인</p></th>
						<td>
						<input type="text" name="coupon" size="20" placeholder="Enter coupon number" />
						<button class="btn btn-warning" type="button" name="coupon1" onclick="couponPage()">쿠폰 조회</button>
						</td>
					</tr>
					<tr>
						<th id="tt" width="200" height="15"><p class="text-center">보유 마일리지</p></th>
						<td><mark>${mileage}</mark>원</td>
					</tr>
					<tr>	
						<th id="tt" width="200" height="15"><p class="text-center">사용 마일리지</p></th>
						<td><input type="text" name="mileage1" size="20"/> 원
							<input type="button" value="적용" onclick="sale()">
						</td>
					
					</tr>
					<tr>
						<th id="tt" width="200" height="15"><p class="text-center">할인합계</p></th>
						<td><input type="text" name="discount" size="20"/>원</td>
					</tr>

		</table>
			</fieldset>
			<fieldset>
				<legend>
					<font color="orange"><b>Final Amount</b></font>
				</legend>
				
		<table class="table table-bordered table-hover table-condensed text-center" id="payment" cellspacing="5">
					<tr>
						<th id="tt" width="200" height="15"><p class="text-center">최종 결제 금액</p></th>
						<td><mark>${price}</mark>원</td>
					</tr>
		</table>
			</fieldset>
			<br> <p class="text-center">
			<button type="submit" class="btn btn-warning">결제하기</button>
			<button type="button" onclick="window.location='goodsList'" class="btn btn-warning">결제 취소</button></p>
		</fieldset>
	</form>
</div>
<div class="col-sm-2 sidenav"></div>
</div>
</div>
<br><br>
<jsp:include page="../../menu/guestFooter.jsp" flush="false"/>

</html>