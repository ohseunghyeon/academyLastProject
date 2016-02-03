<%@page import="java.util.Arrays"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.sql.*"%>
<c:if test="${sessionScope.id == 'nomember'}">
<jsp:include page="../../menu/noMemberHeader.jsp" flush="false" />
</c:if>
<c:if test="${sessionScope.id != 'nomember'}">
<jsp:include page="../../menu/guestHeader.jsp" flush="false" />
</c:if>

<%
	List<Integer> td = Arrays.asList(2, 4, 8, 10, 12, 23);
	request.setAttribute("td", td);

	List<Integer> tr = Arrays.asList(6, 13, 14, 15);
	request.setAttribute("tr", tr);

	List<Integer> nineTd = Arrays.asList(14, 15);
	request.setAttribute("nineTd", nineTd);
%>
<style>
#red {
	background: #FFA7A7;
}

#blue {
	background: #E4F7BA;
}
</style>
<body>
 <div class="container-fluid">
		<div class="row">
 		<div class="col-sm-2" ></div>
 		 <div class="col-sm-8" ><br>
	<table align="center">
		<tr>
			<!-- 좌석 반복 시작 -->
			<c:forEach var="seat" items="${seats}" varStatus="i">
			
				<!-- 14, 15번 앞에 9번 공백 있는 거 -->
				<c:if test="${nineTd.indexOf(i.count) > -1}">
					<c:forEach begin="0" end="8">
						<td width="70" height="70"></td>
					</c:forEach>
				</c:if>
				
				<!-- 기본적으로 좌석 뿌려주는 로직 -->	
				<td id="${seat.occupied == 0 ? 'blue' : 'red'}" width="70"height="70">
					<c:if test="${seat.occupied == 0}"><a href="seatConfirm?seat_num=${seat.seat_num}"></c:if>
						<p class="text-center">
							<button type="button" class="btn btn-default ${seat.occupied == 0 ? 'active' : 'disabled'}">${i.count}</button>
						</p>
					${seat.occupied == 0 ? '</a>' : ''}
				</td>
				
				<!-- 한 칸 띄워주는 로직 -->
			${td.indexOf(i.count) > -1 ? '<td width="70" height="70"></td>':''}
				<!-- tr써서 행 내려주는 로직 -->
			${tr.indexOf(i.count) > -1 ? '</tr><tr>':''}
			
			</c:forEach>
		</tr>
	</table><br><br>
</div>
<div class="col-sm-2" ></div>
</div>
</div>
<jsp:include page="../../menu/guestFooter.jsp" flush="false" />