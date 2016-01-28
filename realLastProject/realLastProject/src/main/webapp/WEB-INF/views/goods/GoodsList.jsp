<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div>
	<table>
		<c:forEach var="goodslist" items="${goodslist}">
			<tr>
					<td>${goodslist.food_code}</td>
					<td>${goodslist.food_name}</td>
					<td>${goodslist.price}</td>
					<td>${goodslist.food_num}</td>
			</tr>
		</c:forEach>	
	</table>
</div>
