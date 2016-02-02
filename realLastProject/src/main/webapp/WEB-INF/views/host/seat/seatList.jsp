<%@ page import="com.first.lastproject.dto.SeatDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.sql.*"%>
<jsp:include page="../../menu/hostHeader.jsp" flush="false" />
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
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
				<c:if test="${seats[0].occupied==0}">
					<td id="blue" width="60" height="60"><a
						href="seatInfomation?=${seats[0].seat_num}">${seats[0].seat_num}</a></td>
				</c:if>

				<c:if test="${seats[0].occupied==1}">
					<td id="red" width="60" height="60"><a
						href="seatConfirm?seat_num=${seats[0].seat_num}">${seats[0].seat_num}</a></td>
				</c:if>

				<c:if test="${seats[1].occupied==0}">
					<td id="blue" width="60" height="60"><a
						href="seatConfirm?seat_num=${seats[1].seat_num}">${seats[1].seat_num}</a></td>
				</c:if>
				<c:if test="${seats[1].occupied==1}">
					<td id="red" width="60" height="60"><a
						href="seatConfirm?seat_num=${seats[1].seat_num}">${seats[1].seat_num}</a></td>

				</c:if>

				<td width="60" height="60"></td>


				<c:if test="${seats[2].occupied==0}">
					<td id="blue" width="60" height="60"><a
						href="seatConfirm?seat_num=${seats[2].seat_num}">${seats[2].seat_num}</a></td>

				</c:if>

				<c:if test="${seats[2].occupied==1}">
					<td id="red" width="60" height="60"><a
						href="seatConfirm?seat_num=${seats[2].seat_num}">${seats[2].seat_num}</a></td>
				</c:if>

				<c:if test="${seats[3].occupied==0}">
					<td id="blue" width="60" height="60"><a
						href="seatConfirm?seat_num=${seats[3].seat_num}">${seats[3].seat_num}</a></td>
				</c:if>

				<c:if test="${seats[3].occupied==1}">
					<td id="red" width="60" height="60"><a
						href="seatConfirm?seat_num=${seats[3].seat_num}">${seats[3].seat_num}</a></td>
				</c:if>



				<td width="60" height="60"></td>
				<c:if test="${seats[4].occupied==0}">
					<td id="blue" width="60" height="60"><a
						href="seatInformation?seat_num=${seats[4].seat_num}">${seats[4].seat_num}</a></td>
				</c:if>
				<c:if test="${seats[4].occupied==1}">
					<td id="red" width="60" height="60"><a
						href="seatInformation?seat_num=${seats[4].seat_num}">${seats[4].seat_num}</a></td>
				</c:if>

				<c:if test="${seats[5].occupied==0}">
					<td id="blue" width="60" height="60"><a
						href="seatConfirm?seat_num=${seats[5].seat_num}">${seats[5].seat_num}</a></td>
				</c:if>
				<c:if test="${seats[5].occupied==1}">
					<td id="red" width="60" height="60"><a
						href="seatConfirm?seat_num=${seats[5].seat_num}">${seats[5].seat_num}</a></td>
				</c:if>

				<td width="60" height="60"></td>
				<td width="60" height="60"></td>
			</tr>

			<tr>
				<c:if test="${seats[6].occupied==0}">
					<td id="blue" width="60" height="60"><a
						href="seatInformation?seat_num=${seats[6].seat_num}">${seats[6].seat_num}</a></td>
				</c:if>
				<c:if test="${seats[6].occupied==1}">
					<td id="red" width="60" height="60"><a
						href="seatInfo=${seats[6].seat_num}">${seats[6].seat_num}</a></td>
				</c:if>


				<c:if test="${seats[7].occupied==0}">
					<td id="blue" width="60" height="60"><a
						href="seatConfirm?seat_num=${seats[7].seat_num}">${seats[7].seat_num}</a></td>
				</c:if>
				<c:if test="${seats[7].occupied==1}">
					<td id="red" width="60" height="60"><a
						href="seatConfirm?seat_num=${seats[7].seat_num}">${seats[7].seat_num}</a></td>
				</c:if>

				<td width="60" height="60"></td>
				<c:if test="${seats[8].occupied==0}">
					<td id="blue" width="60" height="60"><a
						href="seatConfirm?seat_num=${seats[8].seat_num}">${seats[8].seat_num}</a></td>
				</c:if>
				<c:if test="${seats[8].occupied==1}">
					<td id="red" width="60" height="60"><a
						href="seatConfirm?seat_num=${seats[8].seat_num}">=${seats[8].seat_num}</a></td>
				</c:if>

				<c:if test="${seats[9].occupied==0}">
					<td id="blue" width="60" height="60"><a
						href="seatConfirm?seat_num=${seats[9].seat_num}">${seats[9].seat_num}</a></td>
				</c:if>
				<c:if test="${seats[9].occupied==1}">
					<td id="red" width="60" height="60"><a
						href="seatConfirm?seat_num=${seats[9].seat_num}">${seats[9].seat_num}</a></td>
				</c:if>

				<td width="60" height="60"></td>
				<c:if test="${seats[10].occupied==0}">
					<td id="blue" width="60" height="60"><a
						href="seatConfirm?seat_num=${seats[10].seat_num}">${seats[10].seat_num}</a></td>
				</c:if>
				<c:if test="${seats[10].occupied==1}">
					<td id="red" width="60" height="60"><a
						href="seatConfirm?seat_num=${seats[10].seat_num}">${seats[10].seat_num}</a></td>
				</c:if>

				<c:if test="${seats[11].occupied==0}">
					<td id="blue" width="60" height="60"><a
						href="seatConfirm?seat_num=${seats[11].seat_num}">${seats[11].seat_num}</a></td>
				</c:if>
				<c:if test="${seats[11].occupied==1}">
					<td id="red" width="60" height="60"><a
						href="seatConfirm?seat_num=${seats[11].seat_num}">${seats[11].seat_num}</a></td>
				</c:if>

				<td width="60" height="60"></td>
				<c:if test="${seats[12].occupied==0}">
					<td id="blue" width="60" height="60"><a
						href="seatConfirm?seat_num=${seats[12].seat_num}">${seats[12].seat_num}</a></td>
				</c:if>
				<c:if test="${seats[12].occupied==1}">
					<td id="red" width="60" height="60"><a
						href="seatConfirm?seat_num=${seats[12].seat_num}">${seats[12].seat_num}</a></td>
				</c:if>

			</tr>
			<tr>
				<td width="60" height="60"></td>
				<td width="60" height="60"></td>
				<td width="60" height="60"></td>
				<td width="60" height="60"></td>
				<td width="60" height="60"></td>
				<td width="60" height="60"></td>
				<td width="60" height="60"></td>
				<td width="60" height="60"></td>
				<td width="60" height="60"></td>
				<c:if test="${seats[13].occupied==0}">
					<td id="blue" width="60" height="60"><a
						href="seatConfirm?seat_num=${seats[13].seat_num}">${seats[13].seat_num}</a></td>
				</c:if>
				<c:if test="${seats[13].occupied==1}">
					<td id="red" width="60" height="60"><a
						href="seatConfirm?seat_num=${seats[13].seat_num}">${seats[13].seat_num}</a></td>
				</c:if>


			</tr>
			<tr>
				<td width="60" height="60"></td>
				<td width="60" height="60"></td>
				<td width="60" height="60"></td>
				<td width="60" height="60"></td>
				<td width="60" height="60"></td>
				<td width="60" height="60"></td>
				<td width="60" height="60"></td>
				<td width="60" height="60"></td>
				<td width="60" height="60"></td>
				<c:if test="${seats[14].occupied==0}">
					<td id="blue" width="60" height="60"><a
						href="seatConfirm?seat_num=${seats[14].seat_num}">${seats[14].seat_num}</a></td>
				</c:if>
				<c:if test="${seats[14].occupied==1}">
					<td id="red" width="60" height="60"><a
						href="seatConfirm?seat_num=${seats[14].seat_num}">${seats[14].seat_num}</a></td>
				</c:if>
			</tr>


			<tr>
				<c:if test="${seats[15].occupied==0}">
					<td id="blue" width="60" height="60"><a
						href="seatConfirm?seat_num=${seats[15].seat_num}">${seats[15].seat_num}</a></td>
				</c:if>
				<c:if test="${seats[15].occupied==1}">
					<td id="red" width="60" height="60"><a
						href="seatConfirm?seat_num=${seats[15].seat_num}">${seats[15].seat_num}</a></td>
				</c:if>

				<c:if test="${seats[16].occupied==0}">
					<td id="blue" width="60" height="60"><a
						href="seatConfirm?seat_num=${seats[16].seat_num}">${seats[16].seat_num}</a></td>
				</c:if>
				<c:if test="${seats[16].occupied==1}">
					<td id="red" width="60" height="60"><a
						href="seatConfirm?seat_num=${seats[16].seat_num}">${seats[16].seat_num}</a></td>
				</c:if>

				<c:if test="${seats[17].occupied==0}">
					<td id="blue" width="60" height="60"><a
						href="seatConfirm?seat_num=${seats[17].seat_num}">${seats[17].seat_num}</a></td>
				</c:if>
				<c:if test="${seats[17].occupied==1}">
					<td id="red" width="60" height="60"><a
						href="seatConfirm?seat_num=${seats[17].seat_num}">${seats[17].seat_num}</a></td>
				</c:if>
				<c:if test="${seats[18].occupied==0}">
					<td id="blue" width="60" height="60"><a
						href="seatConfirm?seat_num=${seats[18].seat_num}">${seats[18].seat_num}</a></td>
				</c:if>
				<c:if test="${seats[18].occupied==1}">
					<td id="red" width="60" height="60"><a
						href="seatConfirm?seat_num=${seats[18].seat_num}">${seats[18].seat_num}</a></td>
				</c:if>

				<c:if test="${seats[19].occupied==0}">
					<td id="blue" width="60" height="60"><a
						href="seatConfirm?seat_num=${seats[19].seat_num}">${seats[19].seat_num}</a></td>
				</c:if>
				<c:if test="${seats[19].occupied==1}">
					<td id="red" width="60" height="60"><a
						href="seatConfirm?seat_num=${seats[19].seat_num}">${seats[19].seat_num}</a></td>
				</c:if>

				<c:if test="${seats[20].occupied==0}">
					<td id="blue" width="60" height="60"><a
						href="seatConfirm?seat_num=${seats[20].seat_num}">${seats[20].seat_num}</a></td>
				</c:if>
				<c:if test="${seats[20].occupied==1}">
					<td id="red" width="60" height="60"><a
						href="seatConfirm?seat_num=${seats[20].seat_num}">${seats[20].seat_num}</a></td>
				</c:if>

				<c:if test="${seats[21].occupied==0}">
					<td id="blue" width="60" height="60"><a
						href="seatConfirm?seat_num=${seats[21].seat_num}">${seats[21].seat_num}</a></td>
				</c:if>
				<c:if test="${seats[21].occupied==1}">
					<td id="red" width="60" height="60"><a
						href="seatConfirm?seat_num=${seats[21].seat_num}">${seats[21].seat_num}</a></td>
				</c:if>

				<c:if test="${seats[22].occupied==0}">
					<td id="blue" width="60" height="60"><a
						href="seatConfirm?seat_num=${seats[22].seat_num}">${seats[22].seat_num}</a></td>
				</c:if>
				<c:if test="${seats[22].occupied==1}">
					<td id="red" width="60" height="60"><a
						href="seatConfirm?seat_num=${seats[22].seat_num}">${seats[22].seat_num}</a></td>
				</c:if>
				<td width="60" height="60"></td>
				<c:if test="${seats[23].occupied==0}">
					<td id="blue" width="60" height="60"><a
						href="seatConfirm?seat_num=${seats[23].seat_num}">${seats[23].seat_num}</a></td>
				</c:if>
				<c:if test="${seats[23].occupied==1}">
					<td id="red" width="60" height="60"><a
						href="seatConfirm?seat_num=${seats[23].seat_num}">${seats[23].seat_num}</a></td>
				</c:if>

			</tr>


		</table>

	</div>

</body>
</html>
<jsp:include page="../../menu/hostFooter.jsp" flush="false" />