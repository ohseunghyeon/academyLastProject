<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html lang="en" xmlns="http://www.w3.org/1999/xhtml">
<head>
<script src="/lastproject/resources/angular.js"></script>
<script type="text/javascript">

function couponPage(){
	window.open("coupon" ,"manubar=no,width= 500,height=200");
}

</script>
</head>
<!--쿠폰 페이지  -->
<!--  -->

<c:if test="${sessionScope.id == 'nomember'}">
<jsp:include page="../../menu/noMemberHeader.jsp" flush="false" />
</c:if>
<c:if test="${sessionScope.id != 'nomember'}">
<jsp:include page="../../menu/guestHeader.jsp" flush="false" />
</c:if>

<body>
<h3><p class="text-center">Coupon</p></h3>
<div class="container-fluid text-center">    
  <div class="row content">
    <div class="col-sm-2 sidenav">
    </div>
    <div class="col-sm-8 text-left"> 

	<form action="paymentFinish" method="post" name="paymentForm">
		<fieldset id="content">
			<legend>
				<font color="orange" size="6"><b>Payment </b></font>
			</legend>
			<br>
			<fieldset>
				<legend>
					<font color="orange"><b>ProductInfo</b></font>
				</legend>
				<table id="payment" cellspacing="10" cellpadding="0">
					<tr>
						<th width="200" height="15">상품정보</th>
						<td width="50" height="15" align="center">수량</td>
						<td width="200" height="15" align="center">상품금액</td>
						<td width="80" height="15" align="center">마일리지</td>
						<td width="200" height="15" align="center">주문금액</td>
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

				<table id="payment" cellspacing="5">
					<tr>
						<th width="200" height="15">보유 쿠폰 할인</th>
						<td><input type="text" name="coupon" size="10"
							value="쿠폰번호 입력" /></td>
						<td><input class="inputbutton" type="button" name="coupon1"
							value="쿠폰 조회" onclick="couponPage()" /></td>
					</tr>
					<tr>
						<th width="200" height="15">보유 마일리지</th>
						<td>${mileage}원</td>
					</tr>
					<tr>	
						<th width="200" height="15">사용 마일리지</th>
						<td><input type="text" name="mileage" size="10"/>원</td>
					</tr>
					<tr>
						<th width="200" height="15">할인합계</th>
						<td><input type="text" name="discount" size="10" value="" />원</td>
					</tr>
<!-----------------------------------angularJS-------------------------------------------->
	<div ng-app="myApp" ng-controller="costCtrl">
	<%-- 보유마일리지:<input type="number" ng-model="${mileage}"> --%>
	 사용마일리지:<input type="number" ng-model="mileage">
	<p>할인합계={{( mileage) | currency : "￦"}}원</p>
	</div>
	<script>
		var app = angular.module('myApp', []);
		app.controller('costCtrl', function($scope) {
			$scope.salePrice;
			$scope.mileage;
		});
	</script>
<!------------------------------------------------------------------------------->	
		</table>
			</fieldset>
			<fieldset>
				<legend>
					<font color="orange"><b>Final Amount</b></font>
				</legend>
				
		<table id="payment" cellspacing="5">
					<tr>
						<th width="200" height="15">최종 결제 금액</th>
						<td>원</td>
					</tr>
		</table>
			</fieldset>
			<br> <br> <br> <input class="inputbutton"
				type="submit" value="결제하기"> <input class="inputbutton"
				type="button" value="결제취소" onclick="window.location='goodsList'">

		</fieldset>
	</form>
	
</div>
<div class="col-sm-2 sidenav"></div>
</div>
</div>
<jsp:include page="../../menu/guestFooter.jsp" flush="false"/>
</body>
</html>