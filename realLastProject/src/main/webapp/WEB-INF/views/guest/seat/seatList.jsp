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
#well{
width:230px;

}
#well1{
backgrond:FFFFA2;

}
</style>
<body>
 <div class="container-fluid">
		<div class="row">
 		<div class="col-sm-1" ></div>
 		 <div class="col-sm-8" ><br>
	<table align="center">
		<tr>
			<!-- 좌석 반복 시작 -->
			<c:forEach var="seat" items="${seats}" varStatus="i">
			
				<!-- 14, 15번 앞에 9번 공백 있는 거 -->
				<c:if test="${nineTd.indexOf(i.count) > -1}">
					<c:forEach begin="0" end="8">
						<td width="80" height="80"></td>
					</c:forEach>
				</c:if>
				
				<!-- 기본적으로 좌석 뿌려주는 로직 -->	
				<td id="${seat.occupied == 0 ? 'blue' : 'red'}" width="80"height="80">
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
<div class="col-sm-3" >
<br><br>
<br><br>
<br><br>
<table id="well" class="table table-bordered table-condensed ">
<tr>
<td><h4><span id="blue" class="label">색상</span>비점유좌석</h4>
	<h4><span id="red" class="label">색상</span>점유좌석 <br></h4>
	<span class="badge">1</span>커플석 : 16번~23번 좌석<br>
	<span class="badge">2</span>룸 : 13번~15번, 24번 좌석<br></td>
</tr>
</table>
</div>
</div>
</div>
<jsp:include page="../../menu/guestFooter.jsp" flush="false" />