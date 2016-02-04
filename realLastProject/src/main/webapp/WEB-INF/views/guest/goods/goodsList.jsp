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
<!-- <link href="/lastproject/resources/bootstrap.min.css" rel="stylesheet"/> -->
</head>
<body>
	<div class="container-fluid">
		<div class="row"  ng-app="" ng-controller="CartForm">
			<div class="col-sm-2 text-center">
				<form>
					<table class="table table-hover">
						<c:forEach var="goodslist" items="${goodslist}" begin="0" end="9">
							<tr>
								<td><a ng-click="addItem('${goodslist.food_code}', '${goodslist.food_name}', '${goodslist.price}')" ng-click="show()">${goodslist.food_name}</a></td>
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
								<td><a href ng-click="addItem('${goodslist.food_code}', '${goodslist.food_name}', '${goodslist.price}')" ng-click="show()">${goodslist.food_name}</a></td>
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
							<td><input type=text name="food_code" ng-model="item.food_code" ng-hide="true">{{item.food_name}}</td>
							<td><input type="number" name="food_num" ng-model="item.qty" ng-required class="input-mini"></td>
							<td>{{item.price}}원</td>
							<td>{{item.qty * item.price}}원</td>
							<td>[<a href ng-click="removeItem($index)">X</a>]
							</td>
						</tr>
						<tr ng-hide="total">
							<td></td>
							<td></td>
							<c:if test="{{item.food_name}} != null">
							<td>Total:</td>
							<td>{{total()}}</td>
							</c:if>
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
	        items: [/* {
	            qty: 10,
	            food_name: 'item',
	            price: 9.95} */]
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
	        if(total != null) {
	        angular.forEach($scope.invoice.items, function(item) {
	            total += item.qty * item.price;
	        })
	        }
	        return total;
	    }
	    
	    /* $scope.show = function() {
	    	$scope.
	    } */
	}
	</script>
</body>
</html>
<jsp:include page="../../menu/guestFooter.jsp" flush="false" />
