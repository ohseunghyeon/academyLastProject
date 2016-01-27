<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    

<title>재고 목록 페이지</title>


</head>

	<h2>재고목록 페이지</h2>
	<body onload="">
		<form>
		<table border="1">
			<tr>
					<th>재고 품목</th>
					<th>재고 수량</th>
	
			</tr>		
			<c:forEach var="ingredient" items="${ingredientList}">
				<tr>
				<td>
				<a href="modifyForm?ingredient_code=${ingredient.ingredient_code}&ingre_num=${ingredient.ingre_num}">${ingredient.ingredient}</a></td>
	            <td>${ingredient.ingre_num}</td>
	         </tr>
			</c:forEach>
			<tr>
				<th colspan="2">
				<input class="inputbutton" type="button" value="품목 추가" onclick="window.location='inputForm'">
				</th>
			</tr>
		</table>
		
		<table border="1">
			<tr>
					<th>재고 품목</th>
					<th>재고 수량</th>
	
			</tr>		
			<c:forEach var="food" items="${goodslist}">
				<tr>
				<td>
				<a href="foodmodifyForm?food_code=${food.food_code}">${food.food_name}</a></td>
	            <td>${food.food_num}</td>
	
	         </tr>
			</c:forEach>
			<tr>
				<th colspan="2">
				<input class="inputbutton" type="button" value="품목 추가" onclick="window.location='inputForm'">
				</th>
			</tr>
		</table>
		</form>
	</body>
</html>