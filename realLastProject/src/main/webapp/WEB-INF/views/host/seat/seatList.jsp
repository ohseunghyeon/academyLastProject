<%@page import="java.util.List"%>
<%@page import="java.util.Arrays"%>
<%@ page import="com.first.lastproject.dto.SeatDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.sql.*"%>
<jsp:include page="../../menu/hostHeader.jsp" flush="false" />
<%
	List<Integer> td = Arrays.asList(2, 4, 8, 10, 12, 23);
	request.setAttribute("td", td);

	List<Integer> tr = Arrays.asList(6, 13, 14, 15);
	request.setAttribute("tr", tr);

	List<Integer> nineTd = Arrays.asList(14, 15);
	request.setAttribute("nineTd", nineTd);
%>
<head>
<style>
#red {
	background: red;
}

#blue {
	background: blue;
}
</style>
</head>
<body>
	<div id="wrap">
		<table align="center">
			<tr>
				<c:forEach var="seat" items="${seats}" varStatus="i">
					<c:if test="${nineTd.indexOf(i.count) > -1}">
						<c:forEach begin="0" end="8">
							<td width="60" height="60"></td>
						</c:forEach>
					</c:if>
					<td id="${seat.occupied == 0 ? 'blue' : 'red'}" width="60"
						height="60"><a href="seatInformation?seat_num=${seat.seat_num}">${i.count}</a></td>
			${td.indexOf(i.count) > -1 ? '<td width="60" height="60"></td>':''}
			${tr.indexOf(i.count) > -1 ? '</tr><tr>':''}
			
			</c:forEach>
			</tr>
		</table>
	</div>
</body>
</html>
<jsp:include page="../../menu/hostFooter.jsp" flush="false" />