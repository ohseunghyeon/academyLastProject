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
<script src="/lastproject/resources/angular.min.js"></script>
<link href="/lastproject/resources/bootstrap.min.css" rel="stylesheet"/>
</head>
<body>
	<div class="container-fluid">
		<div class="row"  ng-app="" ng-controller="CartForm">
			<div class="col-sm-2 text-center">
				<form>
					<table class="table table-hover">
						<c:forEach var="goodslist" items="${goodslist}" begin="0" end="9">
							<tr>
								<td><a ng-click="addItem()">${goodslist.food_name}</a></td>
								<td>${goodslist.price}</td>
								<td>${goodslist.sold_out}</td>
							</tr>
						</c:forEach>
					</table>
				</form>
			</div>
			<div class="col-sm-2 text-center">
				<form>
					<table class="table table-hover">
						<c:forEach var="goodslist" items="${goodslist}" begin="10"
							end="19">
							<tr>
								<td><a href ng-click="addItem('${goodslist.food_code}', '${goodslist.food_name}', '${goodslist.price}')">${goodslist.food_name}</a></td>
								<td>${goodslist.price}</td>
								<td>${goodslist.sold_out}</td>
							</tr>

						</c:forEach>
					</table>
				</form>
			</div>

			<div class="col-sm-8 text-center">
				<form action="goodsListPro" name="bagform">
					<table class="table table-hover" id="shoppingBag">
						<tr>
				        	<th>Description</th>
				            <th>Qty</th>
				            <th>Cost</th>
				            <th>Total</th>
				            <th></th>
						</tr>
						<tr ng-repeat="item in invoice.items">
							<td><input type="hidden" ng-model="item.food_code"><span ng-model="item.food_name">{{item.food_name}}</span></td>
							<td><input type="number" ng-model="item.qty" ng-required
								class="input-mini"></td>
							<td><input type="number" ng-model="item.price" ng-required
								class="input-mini"></td>
							<td>{{item.qty * item.price | currency}}</td>
							<td>[<a href ng-click="removeItem($index)">X</a>]
							</td>
						</tr>
						<tr>
							<td><a href class="btn btn-small">add item</a></td>
							<td></td>
							<td>Total:</td>
							<td>{{total() | currency}}</td>
						</tr>
					</table>
					<input type="submit" value="결제화면으로">
				</form>
			</div>
		</div>
	</div>
	<script>
	function CartForm($scope) {
 	    $scope.invoice = {
	        items: [{
	            qty: 10,
	            food_name: 'item',
	            price: 9.95}]
	    };

	    $scope.addItem = function(code, name, pric) {
	        $scope.invoice.items.push({
	            qty: 1,
	            food_code: code,
	            food_name: name,
	            price: pric
	        });
	    },

	    $scope.removeItem = function(index) {
	        $scope.invoice.items.splice(index, 1);
	    },

	    $scope.total = function() {
	        var total = 0;
	        angular.forEach($scope.invoice.items, function(item) {
	            total += item.qty * item.cost;
	        })

	        return total;
	    }
	}
	</script>
</body>
</html>
<jsp:include page="../../menu/guestFooter.jsp" flush="false" />
