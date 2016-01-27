<%@ page import="com.first.lastproject.dto.SeatDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.sql.*"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<style>
#red {
	background: red;
}

#blue {
	background: blue;
}
</style>
<body>
	<div id="wrap">

		<table align="center">
			<tr>

				<c:forEach var="seat" items="${seats}" begin="0" end="1">

					<c:if test="${seats.occupied==0}">
						<td id="blue" width="60" height="60">1</td>
					</c:if>

					<c:if test="${seats.occupied==1}">
						<td id="red" width="60" height="60">1</td>
					</c:if>



					<c:if test="${dto.occupied==0}">
						<td id="blue" width="60" height="60">2</td>
					</c:if>
					<c:if test="${dto.occupied==1}">
						<td id="red" width="60" height="60">2</td>
					</c:if>


					<td width="60" height="60"></td>


					<td id="blue" width="60" height="60">3</td>
					<td id="blue" width="60" height="60">4</td>
				</c:forEach>

				<td width="60" height="60"></td>
				<td id="blue" width="60" height="60">21</td>
				<td id="blue" width="60" height="60">22</td>
				<td width="60" height="60"></td>
				<td width="60" height="60"></td>
			</tr>

			<tr>
				<td id="red" width="60" height="60">5</td>
				<td id="red" width="60" height="60">6</td>
				<td width="60" height="60"></td>
				<td id="blue" width="60" height="60">7</td>
				<td id="red" width="60" height="60">8</td>
				<td width="60" height="60"></td>
				<td id="blue" width="60" height="60">23</td>
				<td id="blue" width="60" height="60">24</td>
				<td width="60" height="60"></td>
				<td id="blue" width="60" height="60">9</td>
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
				<td id="red" width="60" height="60">10</td>
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
				<td id="blue" width="60" height="60">11</td>
			</tr>
			
			
			<tr>
				<td id="red" width="60" height="60">13</td>
				<td id="red" width="60" height="60">14</td>
				<td id="blue" width="60" height="60">15</td>
				<td id="blue" width="60" height="60">16</td>
				<td id="red" width="60" height="60">17</td>
				<td id="red" width="60" height="60">18</td>
				<td id="blue" width="60" height="60">19</td>
				<td id="blue" width="60" height="60">20</td>
			</tr>
			<tr>	
			
				<td width="60" height="60"></td>
				<td id="blue" width="60" height="60">12</td>
			</tr>

		</table>

	</div>

</body>
</html>