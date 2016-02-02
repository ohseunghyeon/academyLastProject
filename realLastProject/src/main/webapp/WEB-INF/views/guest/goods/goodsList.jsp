<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="../../menu/guestHeader.jsp" flush="false" />
<!DOCTYPE html>
<html>
<script src="/ajaxEx/resources/request.js"></script>

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
<div class="container-fluid">
	<div class="row">
		<div class="col-sm-6 text-center">
			<form>
				<table class="table table-hover">
					<c:forEach var="goodslist" items="${goodslist}" begin="0" end="9">
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
		<div class="col-sm-6 text-center">
			<form>
				<table class="table table-hover">
					<c:forEach var="goodslist" items="${goodslist}" begin="10" end="19">
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
		<div class="col-sm-6 text-center">
			<form action="goodsListPro" name="bagform">
				<table class="table table-hover" id="shoppingBag">
				</table> 
				<input type="submit" value="결제화면으로">
			</form>
		</div>
	</div>
</div>
</html>
<jsp:include page="../../menu/guestFooter.jsp" flush="false" />
