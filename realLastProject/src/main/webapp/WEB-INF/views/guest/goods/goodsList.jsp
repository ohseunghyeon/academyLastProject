<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="../../menu/guestHeader.jsp" flush="false" />
<!DOCTYPE html>
<html>

<div class="container-fluid">
  <div class="row">
    <div class="col-sm-6 text-center">
	<form>
		<table class="table table-hover">
			<c:forEach var="goodslist" items="${goodslist}">
				<tr>
					<td><input type="checkbox" name="food_code"
						value="${goodslist.food_code}"></td>
					<td>${goodslist.food_name}</td>
					<td>${goodslist.price}</td>
					<td>${goodslist.sold_out}</td>
				</tr>
			</c:forEach>
		</table>
	</form>
	</div>
	<div class="col-sm-6 text-center">
		<form action="goodsListPro">
		<table class="table table-hover">
			<tr>
				<td>장바구니</td>
			<tr>
				<td><input type="hidden" name="food_code" value="1"> <input
					type="text" value="에스프레소"> <input type="number"
					name="food_num" value="4"></td>
			</tr>
			<tr>
				<td><input type="hidden" name="food_code" value="2"> <input
					type="text" value="아메리카노"> <input type="number"
					name="food_num" value="3"></td>
			</tr>
			<tr>
				<td><input type="hidden" name="food_code" value="3"> <input
					type="text" value="아이스아메리카노"> <input type="number"
					name="food_num" value="2"></td>
				<td><input type="submit" value="전송"></td>
			</tr>
		</table>
		</form>
		</div>
</div>
</div>
</html>
<jsp:include page="../../menu/guestFooter.jsp" flush="false"/>
