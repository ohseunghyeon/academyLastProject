<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> 
<style>
	#list {
	display:inline;
	width : 240px;
	}
</style> 
<jsp:include page="../../menu/hostHeader.jsp" flush="false" />

<div class="container-fluid">

<h3><p class="text-center">정산<mark><small>${time}</small></mark></p></h3>
<br><br><br>
<div class="row">
<div class="col-sm-1"></div>
<div class="col-sm-7">
	<form method="get" action="accountMonth">
	<table class="table table-bordered table-hover table-condensed text-center ">
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
 <form method="get" action="accountDateSelect">
	<table class="table table-bordered table-hover table-condensed text-center ">
		<tr>
			<td><input type="submit" value="기간선택"> <input
				type="date" value="dateselect" name="startday"> ~ <input
				type="date" value="dateselect" name="endday"></td>
		</tr>
	</table>
</form>
<form>	
		<table class="table table-bordered table-hover table-condensed text-center " id="list" border ="1">
			
			<tr>
				<th>일자</th>	
			</tr>
			 <c:forEach var="mList" items="${mList}">
			<tr>
				<td><a href="accountDay?dayDate=${mList.date}"><fmt:formatDate value="${mList.date}" type="date" /></a></td>						
			</tr>
		 </c:forEach>		
		</table>
		<table class="table table-bordered table-hover table-condensed text-center " id="list" border ="1">
			<tr>	
				<th>일간 수익</th>
			</tr>
			 <c:forEach var="mPrice" items="${mPrice}">	
			<tr>
				<td>${mPrice.price}</td>	
			</tr>
		 </c:forEach>		
		</table>
		<table class="table table-bordered table-hover table-condensed text-center " id="list" border = "1">
			<tr>
				<th>일간 사용 시간</th>
			</tr>
			<tr>
				<td>0</td>	
			</tr>
		</table>
	</form>
</div>
<div class="col-sm-3">
	<table class="table table-bordered table-hover table-condensed text-center ">
		<tr>
			<th style=" background-color:lavender; width : 100px"><h4><p class="text-danger">Total Price</p></h4></th>
			<c:set var="mTotal" value="${mTotal}" />
				<td><h4>${mTotal.total_price}</h4></td>
		</tr>	
		</table></div>
<div class="col-sm-1"></div>
</div>
</div>
	<jsp:include page="../../menu/hostFooter.jsp" flush="false" />