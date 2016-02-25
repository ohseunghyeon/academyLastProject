<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<jsp:include page="../../menu/hostHeader.jsp" flush="false" />
<script src= /lastproject/resources/JNscript.js></script>

<div class="container-fluid">

<h3><p class="text-center">정산<mark><small>${time}</small></mark></p></h3>
<br><br><br>
<div class="row">
<div class="col-sm-1"></div>
<div class="col-sm-7">
<form method="get" action="accountMonth" name="accountForm" onsubmit="return accountMonCheck()">
	<table class="table table-bordered table-hover table-condensed text-center ">
		<tr style="background-color:lavender;">
			<td>
			<button type="button" class="btn btn-success btn-sm" onclick="window.location='accountDay'">일간</button>
			<button type="submit" class="btn btn-danger btn-sm">월간</button>
			<input name="monlist" type="text" list="monthList" required /> <datalist
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
<form method="get" action="accountDateSelect"  name="accountForm" onsubmit="return accountSelCheck()">
	<table class="table table-bordered table-hover table-condensed text-center ">
		<tr style="background-color:lavender;">
			<td>
			<button type="submit" class="btn btn-info btn-sm">기간선택</button>
			 <input
				type="date" value="dateselect" name="startDay" required /> ~ <input
				type="date" value="dateselect" name="endDay" required /></td>
		</tr>
	</table>
</form>
<form>
	<table class="table table-bordered table-hover table-condensed text-center ">

		<tr style="background-color:lavender;"> 
			<th><p class="text-center">주문번호</p></th>
			<th><p class="text-center">좌석번호</p></th>
			<th><p class="text-center">주문시간</p></th>
			<th><p class="text-center">사용시간</p></th>
			<th><p class="text-center">가격</p></th>
		</tr>
		<c:forEach var="dayList" items="${list}">
			<tr>
				<td>${dayList.order_id}</td>
				<td>${dayList.seat_num}</td>
				<td><fmt:formatDate value="${dayList.order_time}" type="time" timeStyle="default" /></td>
				<td>${dayList.used_time}</td>
				<td>${dayList.price}</td>
			</tr>
		</c:forEach>
	</table >
</form>
</div>
<div class="col-sm-3"><c:set var="price" value="${price}" />
	<table class="table table-bordered table-hover table-condensed text-center ">
		<tr>
			<th style=" background-color:lavender; width : 100px"><h4><p class="text-danger">Total Price</p></h4></th>
			<td><h4><mark>${price.total_price}원</mark></h4></td>
		</tr>
	</table></div>
<div class="col-sm-1"></div>
</div>
</div>
<br><br><br>
<jsp:include page="../../menu/hostFooter.jsp" flush="false" />