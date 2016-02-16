<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<jsp:include page="../../menu/hostHeader.jsp" flush="false" />
<div class="container">
<div class="row">
<h3><p class="text-center">재고 List</p></h3>
<div class="col-sm-6">
<body>
	<form>
		<table class="table table-hover text-center bg-success">
		<thead>
			<tr>
				<th><p class="text-center"><code>재고 품목</code></p></th>
				<th><p class="text-center"><code>재고 수량</code></p></th>

			</tr>
		</thead>
		<tbody>
			<c:forEach var="ingredient" items="${ingredientList}">
				<tr>
					<td><a
						href="ingredientModifyForm?ingredient_code=${ingredient.ingredient_code}&ingre_num=${ingredient.ingre_num}"><h4>${ingredient.ingredient}</h4></a></td>
					<td><h4>${ingredient.ingre_num}</h4></td>
				</tr>
			</c:forEach>
			<!-- <tr>
				<th colspan="2"><input class="inputbutton" type="button"
					value="품목 추가" onclick="window.location='inputForm'"></th>
			</tr> -->
		</tbody>
		</table>
		</form>
</div>
 <div class="col-sm-6">
 <form>
		<table class="table table-hover text-center" style="background-color:lavenderblush;">
		<thead>
			<tr class="text-center">
				<th><p class="text-center"><code>재고 품목</code></p></th>
				<th><p class="text-center"><code>재고 수량</code></p></th>

			</tr>
		</thead>
		<tbody>
			<c:forEach var="food" items="${goodsList}">
				<tr>
					<td><a
						href="foodModifyForm?food_code=${food.food_code}&food_num=${food.food_num}"><h4>${food.food_name}</h4></a></td>
					<td><h4>${food.food_num}</h4></td>

				</tr>
			</c:forEach>
			<!-- <tr>
				<th colspan="2"><input class="inputbutton" type="button"
					value="품목 추가" onclick="window.location='inputForm'"></th>
			</tr> -->
		</table>
		</form>
	</div>
</div>
</div>
<jsp:include page="../../menu/hostFooter.jsp" flush="false" />