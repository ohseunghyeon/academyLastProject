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
<script type="text/javascript">

	function getinbag(food_code) {
		var params = "food_code=" + encodeURI(food_code);
		sendRequest(intothebag, "shoppingBag", "POST", params);
	}
	
	function intothebag() {
		if (httpRequest.readyState == 4) {
			if (httpRequest.status == 200) {
				var bag = document.getElementById("shoppingBag");
				
				//eval("문자열") 함수 : 일반문자열을 수식으로 리턴해주는 역할을 한다.
				var data = eval("httpRequest.responseText");
				bag.innerHTML += data;
			}
		} else {
			result.innerHTML = "상태 : " + httpRequest.readyState;
		}
	}
</script>
<link href="/lastproject/resources/bootstrap.min.css" rel="stylesheet"/>
</head>
<body>
	<div class="container-fluid">
		<div class="row">
			<div class="col-sm-2 text-center">
				<form>
					<table class="table table-hover">
						<c:forEach var="goodslist" items="${goodslist}" begin="0" end="9">
							<tr>
								<td><a onclick="getinbag(${goodslist.food_code})">${goodslist.food_name}</a></td>
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
								<td><input type="checkbox" name="food_code"
									value="${goodslist.food_code}"></td>
								<td><a onclick="getinbag(${goodslist.food_code})">${goodslist.food_name}</a></td>
								<td>${goodslist.price}</td>
								<td>${goodslist.sold_out}</td>
							</tr>

						</c:forEach>
					</table>
				</form>
			</div>

			<div class="col-sm-8 text-center" ng-app="" ng-controller="CartForm">
				<form action="goodsListPro" name="bagform">
					<table class="table table-hover" id="shoppingBag">
						<tr ng-repeat="item in invoice.items">
							<td><input type="text" ng-model="item.description"
								class="input-small"></td>
							<td><input type="number" ng-model="item.qty" ng-required
								class="input-mini"></td>
							<td><input type="number" ng-model="item.cost" ng-required
								class="input-mini"></td>
							<td>{{item.qty * item.cost | currency}}</td>
							<td>[<a href ng-click="removeItem($index)">X</a>]
							</td>
						</tr>
						<tr>
							<td><a href ng-click="addItem()" class="btn btn-small">add item</a></td>
							<td></td>
							<td>Total:</td>
							<td>{{total() | currency}}</td>
						</tr>
					</table>
					<input type="submit" value="결제화면으로">
				</form>
				<h2>Shopping Card Example</h2>
<div ng-app="" ng-controller="CartForm">
    <table class="table">
        <tr>
            
            <th>Description</th>
            <th>Qty</th>
            <th>Cost</th>
            <th>Total</th>
            <th></th>
        </tr>
        <tr ng-repeat="item in invoice.items">
            <td><input type="text" ng-model="item.description"></td>           
            <td><input type="number" ng-model="item.qty"></td>
            <td><input type="number" ng-model="item.cost"></td>
            <td>{{item.qty * item.cost | currency}}</td>
            <td>
                [<a href ng-click="removeItem($index)">X</a>]
            </td>
        </tr>
        <tr>
            <td><a href ng-click="addItem()" class="btn btn-small">add item</a></td>
            <td></td>
            <td>Total:</td>
            <td>{{total() | currency}}</td>
        </tr>
    </table>
</div>
				
			</div>
		</div>
	</div>
	<script>
	function CartForm($scope) {
	    $scope.invoice = {
	        items: [{
	            qty: 10,
	            description: 'item',
	            cost: 9.95}]
	    };

	    $scope.addItem = function() {
	        $scope.invoice.items.push({
	            qty: 1,
	            description: '',
	            cost: 0
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
