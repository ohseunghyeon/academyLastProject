<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 

    <h3>정산 페이지(${time})</h3>
	<form>
	<table>
			<tr>
			<td><input type="button" value="일간" 
					onclick="window.location='accountDay'"></td>
			<td><input type="button" value="월간" 
			onclick="window.location='accountMonth?list=${list}'" >
			<input name="list" type="text" list="monthList">
			<datalist id = "monthList">
				<option value = "1월"></option>	
				<option value = "2월"></option>	
				<option value = "3월"></option>	
				<option value = "4월"></option>	
				<option value = "5월"></option>	
				<option value = "6월"></option>	
				<option value = "7월"></option>	
				<option value = "8월"></option>	
				<option value = "9월"></option>	
				<option value = "10월"></option>	
				<option value = "11월"></option>	
				<option value = "12월"></option>	
			</datalist></td>
			<td><input type="submit" value="기간선택" id="select">
			<input type = "date" value = "dateselect" id="select">
			~ <input type = "date" value = "dateselect" id="select">
			</td>
			</tr>	
		</table>
	
		<table border ="1">
		<c:forEach var="monthList" items="${MList}">
		<c:forEach var="monthprice" items="${MPrice}">
			<tr>
				<th>일자</th>
				<th>일간 사용 시간</th>
				<th>일간 수익</th>
				
			</tr>
			<tr>
				<td>${monthList.date}</td>
				<td>${monthprice.price}</td>
				<td></td>
					
			</tr>
		</c:forEach>
		</c:forEach>
		</table>
		<c:set var="mTotal" value="${mTotal}" />
		<table border="1">
			<tr>
				<th>총 가격</th>
			</tr>
			<tr>
				<td>${mTotal.total_price}</td>
			</tr>	
		</table>
	</form>