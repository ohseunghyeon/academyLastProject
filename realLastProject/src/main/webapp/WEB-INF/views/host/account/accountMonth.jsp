<%@page import="com.first.lastproject.dto.AccountDto"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%
	ArrayList<AccountDto> mList = (ArrayList<AccountDto>) request.getAttribute("mList");
	ArrayList<AccountDto> mPrice = (ArrayList<AccountDto>) request.getAttribute("mPrice");
%>
<head>
<script src="/lastproject/resources/JNscript.js"></script>
<script src="/lastproject/resources/Chart.js"></script>
<style>
#list {
	display: inline;
}
</style>
</head>
<jsp:include page="../../menu/hostHeader.jsp" flush="false" />
<body>
	<div class="container-fluid">

		<h3>
			<p class="text-center">
				정산
				<mark>
					<small>${time}</small>
				</mark>
			</p>
		</h3>
		<br> <br> <br>
		<div class="row">
			<div class="col-sm-1"></div>
			<div class="col-sm-5">
				<form method="get" action="accountMonth" name="accountForm"
					onsubmit="return accountMonCheck()">
					<table
						class="table table-bordered table-hover table-condensed text-center ">
						<tr style="background-color: lavender;">
							<td>
								<button type="button" class="btn btn-success btn-sm"
									onclick="window.location='accountDay'">일간</button>
								<button type="submit" class="btn btn-danger btn-sm">월간</button>
								<input name="monlist" type="text" list="monthList" required />
								<datalist id="monthList">
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
								</datalist>
							</td>
						</tr>
					</table>
				</form>
				<form method="get" action="accountDateSelect" name="accountForm"
					onsubmit="return accountSelCheck()">
					<table
						class="table table-bordered table-hover table-condensed text-center ">
						<tr style="background-color: lavender;">
							<td><button type="submit" class="btn btn-info btn-sm">기간선택</button>
								<input type="date" value="dateselect" name="startday" required />
								~ <input type="date" value="dateselect" name="endday" required /></td>
						</tr>
					</table>
				</form>
				<form>
					<table
						class="table table-bordered table-hover table-condensed text-center "
						id="list" border="1" style="width: 300px">
						<tr style="background-color: lavender;">
							<th><p class="text-center">일자</p></th>
						</tr>
						<c:forEach var="mList" items="${mList}">
							<tr>
								<td><a href="accountDay?dayDate=${mList.date}"><fmt:formatDate
											value="${mList.date}" type="date" /></a></td>
							</tr>
						</c:forEach>
					</table>
					<table
						class="table table-bordered table-hover table-condensed text-center "
						id="list" border="1" style="width: 150px">
						<tr style="background-color: lavender;">
							<th><p class="text-center">일간 수익</p></th>
						</tr>
						<c:forEach var="mPrice" items="${mPrice}">
							<tr>
								<td>${mPrice.price}</td>
							</tr>
						</c:forEach>
					</table>
					<!-- <table class="table table-bordered table-hover table-condensed text-center " id="list" border = "1" style="width : 170px">
			<tr style="background-color:lavender;">
				<th><p class="text-center">일간 사용 시간</p></th>
			</tr>
			<tr>
				<td>0</td>	
			</tr>
		</table> 현재 미 구현-->
				</form>
			</div>
		
			<div class="col-sm-5">
				<!-- 데이터 시각화 -->
				<br><br><br><br><br><br>
			<div style="width: 100%">
				<canvas id="canvas" height="450" width="600"></canvas>
			</div>
				<br>
				<table
					class="table table-bordered table-hover table-condensed text-center ">
					<tr>
						<th style="background-color: lavender; width: 100px"><h4>
								<p class="text-danger">Total Price</p>
							</h4></th>
						<c:set var="mTotal" value="${mTotal}" />
						<td><h4>
								<mark>${mTotal.total_price}원</mark>
							</h4></td>
					</tr>
				</table>
			</div>
			<div class="col-sm-1"></div>
		</div>
	</div>
	<script>
		var randomScalingFactor = function() {
			return Math.round(Math.random() * 100)
		};

		var barChartData = {
			labels : [<% for (int i = 0; i < mList.size(); i++) { %>"<%=mList.get(i).getDate().toString().substring(8, 10)%>일"<%=i< mList.size() - 1 ? "," : "" %> <% } %> ],
			datasets : [
					{
						fillColor : "#EB3232",
						strokeColor : "EB3232",
						highlightFill : "EB3232",
						highlightStroke : "EB3232",
						data : [ <% for (int i = 0; i < mPrice.size(); i++) { %>"<%=mPrice.get(i).getPrice()%>"<%=i< mPrice.size() - 1 ? "," : "" %> <% } %> ]
					}
					]

		}
		window.onload = function() {
			var ctx = document.getElementById("canvas").getContext("2d");
			window.myBar = new Chart(ctx).Bar(barChartData, {
				responsive : true
			});
		}
	</script>
</body>
<jsp:include page="../../menu/hostFooter.jsp" flush="false" />