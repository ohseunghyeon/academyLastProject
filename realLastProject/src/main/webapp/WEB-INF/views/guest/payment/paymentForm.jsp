<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<jsp:include page="../../menu/guestHeader.jsp" flush="false"/>
<!DOCTYPE html>
<html lang="en" xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta charset="utf-8" />
<title></title>

<style>
div {
	border: 1px solid #D4EDE2;
	padding-top: 0px;
	padding-right: 0px;
	padding-left: 0px;
	padding-bottom: 0px;
	margin-top: 0px;
	margin-right: 0px;
	margin-left: 0px;
	margin-bottom: 0px;
	text-align: center;
}

#con {
	width: 1024px;
	margin: 0 auto;
	overflow: hidden;
}

#header {
	font-size: 14px;
	width: 400px;
	height: 30px;
	line-height: 30px;
	text-align: center;
	float: right;
	color: red;
}

#nav {
	width: 1024px;
	height: 80px;
	clear: both;
}

#nav ul {
	overflow: hidden;
	width: 1024px;
	height: 37px;
}

#nav ul li {
	width: 150px;
	height: 35px;
	line-height: 30px;
	text-align: center;
	list-style: none;
	float: left;
	border: 1px solid #dddddd;
	margin-right: auto;
}

body {
	width: 1024px;
}

#wrap {
	width: 1024px;
	overflow: hidden;
	height: 500px;
}

#content {
	width: 1024px;
	height: 500px;
	float: left;
}

#banner {
	width: 320px;
	height: 500px;
	float: left;
}

#footer {
	width: 1024px;
	height: 50px;
	line-height: 50px;
}

#con #nav p {
	height: 0px;
	line-height: 0px;
}
</style>


</head>
<body>
	<div id="con">


		<div id="header">guest</div>

		<div id="nav">
			<p>CAFE SASAEG</p>
			<ul>
				<li><a href="seat.html">좌석</a></li>
				<li><a href="menu.html">메뉴</a></li>
				<li><a href="guestBoard.html">게시판</a></li>
			</ul>
			<div id="wrap">
				<div id="content">CONTENT</div>
			</div>
			<div id="footer">FOOTER</div>
		</div>
	</div>

	<div ng-app="" ng-init="quantity=1; price=5000">
		quantity : <input type="number" ng-model="quantity" maxlength="6">
		price : <input type="number" ng-model="price"> total : {{
		quantity * price }}
	</div>

	<table>
		<%-- <c:forEach var="food" items="${foodList}">
			<tr>
				<td><input type="text" value="${food.food_name}"> <input
					type="text" value="${food.price}"> <input type="number"
					value="1"></td>
			</tr>
		</c:forEach> --%>
	</table>



	<form action="paymentFinish" method="post">
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
							<td>${foodDto.price * 0.05}</td>
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
							value="쿠폰 조회" onclick="window.location='coupon'" /></td>
						<td rowspan="3"><input class="inputbutton" type="button"
							name="coupon1" value="적용" /></td>
					</tr>
					<tr>
						<th width="200" height="15">마일리지 할인</th>
						<td><input type="checkbox" />사용</td>
						<td><input type="text" name="마일리지" size="10" value="" />원</td>



					</tr>

					<tr>
						<th width="200" height="15">할인합계</th>
						<td><input type="text" name="discount" size="10" value="3000" />원</td>
					</tr>

				</table>
			</fieldset>

			<fieldset>
				<legend>
					<font color="orange"><b>Final Amount</b></font>
				</legend>
				<table id="payment" cellspacing="5">
					<tr>
						<th width="200" height="15">최종 결제 금액</th>
						<td>13,000 원</td>
					</tr>
				</table>
			</fieldset>
			<br> <br> <br> <input class="inputbutton"
				type="submit" value="결제하기"> <input class="inputbutton"
				type="button" value="결제취소" onclick="window.location='goodsList'">

		</fieldset>
	</form>
	<script
		src="http://ajax.googleapis.com/ajax/libs/angularjs/1.2.15/angular.min.js"></script>
</body>
</html>