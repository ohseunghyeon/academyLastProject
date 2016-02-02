<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<h3>정산 페이지(${time})</h3>
<form method="get" action="accountMonth">
	<table>
		<tr>
			<td><input type="button" value="일간"
				onclick="window.location='accountDay'"></td>
			<td><input type="submit" value="월간"> 
			<input name="monlist" type="text" list="monthList"> <datalist
					id="monthList">
					<option value="01" label="january"></option>
					<option value="02" label="febuary"></option>
					<option value="03" label="march"></option>
					<option value="04" label="april"></option>
					<option value="05" label="may"></option>
					<option value="06" label="june"></option>
					<option value="07" label="july"></option>
					<option value="08" label="august"></option>
					<option value="09" label="setember"></option>
					<option value="10" label="october"></option>
					<option value="11" label="november"></option>
					<option value="12" label="december"></option>
				</datalist></td>
		</tr>
	</table>
</form>
<form method="get" action="accountDateSelect">
	<table>
		<tr>
			<td><input type="submit" value="기간선택"> <input
				type="date" value="dateselect" name="startday"> ~ <input
				type="date" value="dateselect" name="endday"></td>
		</tr>
	</table>
</form>
<form>
	<table border="1">

		<tr>
			<th>주문번호</th>
			<th>좌석번호</th>
			<th>주문시간</th>
			<th>사용시간</th>
			<th>가격</th>
		</tr>
		<c:forEach var="dayList" items="${list}">
			<tr>
				<td>${dayList.order_id}</td>
				<td>${dayList.seat_num}</td>
				<td>${dayList.order_time}</td>
				<td>${dayList.used_time}</td>
				<td>${dayList.price}</td>
			</tr>
		</c:forEach>
	</table>
	<c:set var="dto" value="${dto}" />
	<table border="1">
		<tr>
			<th>총 가격</th>
		</tr>
		<tr>
			<td>${dto.total_price}</td>
		</tr>
	</table>
</form>