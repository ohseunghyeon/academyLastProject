<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:if test="${sessionScope.id == 'nomember'}">
	<jsp:include page="../../menu/noMemberHeader.jsp" flush="false" />
</c:if>
<c:if test="${sessionScope.id != 'nomember'}">
	<jsp:include page="../../menu/guestHeader.jsp" flush="false" />
</c:if>



<!DOCTYPE html>
<html>
<head>
<style>
 #menu {
  background:#FFA7A7;
 }
 #menu1{
 background: #E4F7BA;
 }
 #menu2 {
 
 color:white;
 }
 #inline {
 display:inline;
 }
</style>
<script src="/lastproject/resources/angular.min.js"></script>
<!-- <link href="/lastproject/resources/bootstrap.min.css" rel="stylesheet"/> -->
</head>
<body>
	<div class="container">
		<div class="row" ng-app="" ng-controller="CartForm">
		
			<div>
			<ul class="nav nav-tabs">
			<li id="menu2">zzzzzz</li>
			<li class="active"><a id="menu" ng-click="drink()"><b>음료</b></a></li>
			<li ><a id="menu1" ng-click="dessert()"><b>디저트</b></a></li>
			</ul>
			</div>
			
			
			<!-- 음료 -->
			<div id="inline" class="col-sm-8 text-center" ng-hide="drinkHide">
			<div class="container">
			 <div class="col-sm-4">
			 <div class="panel panel-default">
			 <div class="panel-body">
			 <c:forEach var="goodslist" items="${goodslist}" begin="0" end="4">
				 <c:if test="${goodslist.sold_out == 1}">
				 <a><img src="/lastproject/resources/images/menu/${goodslist.image_name}.jpg"></a>
				 <p>${goodslist.food_name}</p>
	   			 <p>가격 : <b>${goodslist.price}</b></p>
	   			 </c:if>
	   			 <c:if test="${goodslist.sold_out == 0}">
				 <a><img src="/lastproject/resources/images/menu/${goodslist.image_name}.jpg" ng-click="addItem('${goodslist.food_code}', '${goodslist.food_name}', '${goodslist.price}')"></a>
				 <p><a ng-click="addItem('${goodslist.food_code}', '${goodslist.food_name}', '${goodslist.price}')"><b>${goodslist.food_name}</b></a></p>
	   			 <p>가격 : <b>${goodslist.price}</b></p>
	   			 <p>&nbsp</p>
	   			 </c:if>
	   			 <c:if test="${goodslist.sold_out == 1}">
	   			 <p>현재 매진되었습니다.</p>
	   			 </c:if>
   			 </c:forEach>
   			 </div>
   			 </div>
   			 
   			 </div>
   			<div class="col-sm-4">
   			<div class="panel panel-default">
			 <div class="panel-body">
   			 <c:forEach var="goodslist" items="${goodslist}" begin="5" end="9">
			 <c:if test="${goodslist.sold_out == 1}">
				 <a><img src="/lastproject/resources/images/menu/${goodslist.image_name}.jpg"></a>
				 <p>${goodslist.food_name}</p>
	   			 <p>가격 : <b>${goodslist.price}</b></p>
	   			 </c:if>
	   			 <c:if test="${goodslist.sold_out == 0}">
				 <a><img src="/lastproject/resources/images/menu/${goodslist.image_name}.jpg" ng-click="addItem('${goodslist.food_code}', '${goodslist.food_name}', '${goodslist.price}')"></a>
				 <p><a ng-click="addItem('${goodslist.food_code}', '${goodslist.food_name}', '${goodslist.price}')"><b>${goodslist.food_name}</b></a></p>
	   			 <p>가격 : <b>${goodslist.price}</b></p>
	   			 <p>&nbsp</p>
	   			 </c:if>
	   			 <c:if test="${goodslist.sold_out == 1}">
	   			 <p>현재 매진되었습니다.</p>
	   			 </c:if>
   			 </c:forEach>
   			</div>
   			<div class="col-sm-4"></div>
   			 </div>
   			 </div>
   			 </div>
   			 </div>
			
			
			
<!-- 디저트 -->
			<div id="inline" class="col-sm-8 text-center" ng-hide="dessertHide">
			<div class="container">
			 <div class="col-md-4">
			 <div class="panel panel-default">
			 <div class="panel-body">
				<c:forEach var="goodslist" items="${goodslist}" begin="10" end="14">
				<c:if test="${goodslist.sold_out == 1}">
				 <a><img src="/lastproject/resources/images/menu/${goodslist.image_name}.jpg"></a>
				 <p>${goodslist.food_name}</p>
	   			 <p>가격 : <b>${goodslist.price}</b></p>
	   			 </c:if>
	   			 <c:if test="${goodslist.sold_out == 0}">
				 <a><img src="/lastproject/resources/images/menu/${goodslist.image_name}.jpg" ng-click="addItem('${goodslist.food_code}', '${goodslist.food_name}', '${goodslist.price}')"></a>
				 <p><a ng-click="addItem('${goodslist.food_code}', '${goodslist.food_name}', '${goodslist.price}')"><b>${goodslist.food_name}</b></a></p>
	   			 <p>가격 : <b>${goodslist.price}</b></p>
	   			 <p>&nbsp</p>
	   			 </c:if>
	   			 <c:if test="${goodslist.sold_out == 1}">
	   			 <p>현재 매진되었습니다.</p>
	   			 </c:if>
				</c:forEach>
			</div>
			</div>
			 </div>
   			<div class="col-md-4">
   			<div class="panel panel-default">
			 <div class="panel-body">
				<c:forEach var="goodslist" items="${goodslist}" begin="15" end="19">
				<c:if test="${goodslist.sold_out == 1}">
				 <a><img src="/lastproject/resources/images/menu/${goodslist.image_name}.jpg"></a>
				 <p>${goodslist.food_name}</p>
	   			 <p>가격 : <b>${goodslist.price}</b></p>
	   			 </c:if>
	   			 <c:if test="${goodslist.sold_out == 0}">
				 <a><img src="/lastproject/resources/images/menu/${goodslist.image_name}.jpg" ng-click="addItem('${goodslist.food_code}', '${goodslist.food_name}', '${goodslist.price}')"></a>
				 <p><a ng-click="addItem('${goodslist.food_code}', '${goodslist.food_name}', '${goodslist.price}')"><b>${goodslist.food_name}</b></a></p>
	   			 <p>가격 : <b>${goodslist.price}</b></p>
	   			 <p>&nbsp</p>
	   			 </c:if>
	   			 <c:if test="${goodslist.sold_out == 1}">
	   			 <p>현재 매진되었습니다.</p>
	   			 </c:if>
				</c:forEach>
			</div>
			</div>
   			
   			
   			</div>
			<div class="col-md-4"></div>
   			 </div>
</div>
			<!-- 장바구니 -->
			<div class="col-sm-4 text-center">
				<form action="goodsListPro" name="bagform">
					<table id="inline" class="table table-hover" ng-hide="totalHide">
						<tr id="menu">
							<th colspan="4">장바구니</th>
						</tr>
						<tr id="menu1">
							<th>메뉴</th>
							<th>수량</th>
							<th>가격</th> 
							<th></th>
						</tr>
						<tr ng-repeat="item in invoice.items">
							<td><input type=text name="food_code"
								ng-model="item.food_code" ng-hide="true">{{item.food_name}}</td>
							<td><input type="number" name="food_num" ng-model="item.qty"
								ng-required class="input-mini"></td>
							<td>{{item.price}}원</td>
							<td>[<a href ng-click="removeItem($index)">X</a>]
							</td>
						</tr>
						<tr id="menu">
							<td></td>
							<td><b>총 가격:</b></td>
							<td><b><mark>{{total()}}</mark></b></td>
							<td></td>
						</tr>
						<tr>
							<td>
							<button type="submit" class="btn btn-warning">결제화면</button>
						</tr>
					</table>

				</form>
			</div>
	</div>	
</div>

	<script>
		function CartForm($scope) {
			$scope.invoice = {
				items : [/* {
					            qty: 10,
					            food_name: 'item',
					            price: 9.95} */]
			};
			
			$scope.totalHide = true; /*클릭 전에 토탈 숨기기 위함*/
			$scope.drinkHide = false; /*클릭 전에 음료 안 숨기기 위함*/
			$scope.dessertHide = true; /*클릭 전에 디저트 숨기기 위함*/
			
			$scope.addItem = function(code, name, pric) {
				for (var i = 0; i < $scope.invoice.items.length; i++) {
					if ($scope.invoice.items[i].food_code == code) {
						$scope.invoice.items[i].qty += 1;
						return;
					}
				}
				$scope.invoice.items.push({
					qty : 1,
					food_code : code,
					food_name : name,
					price : pric
				});
			    
				$scope.totalHide = false;
			},
			
			
			$scope.drink = function() {	//음료 버튼
				$scope.drinkHide = false;
				$scope.dessertHide = true;
			},
			
			$scope.dessert = function() {	//디저트 버튼
				$scope.drinkHide = true;
				$scope.dessertHide = false;
			},
			
			$scope.removeItem = function(index) {	//아이템 제거하는 함수
				$scope.invoice.items.splice(index, 1);
				if ($scope.invoice.items.length == 0) {
					$scope.totalHide = true;
				}
			},

			$scope.total = function() {	//총 가격 구하는 함수
				var total = 0;
				if (total != null) {
					angular.forEach($scope.invoice.items, function(item) {
						total += item.qty * item.price;
					})
				}
				return total;
			};
		}
	</script>
</body>
</html>
<jsp:include page="../../menu/guestFooter.jsp" flush="false" />
