<%@ page import="com.first.lastproject.dto.SeatDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.sql.*"%>
<jsp:include page="../../menu/guestHeader.jsp" flush="false"/>
<html>
<body>
	<form action="seatSelectConfirmPro" method="post" name=seatConfirm>
		<fieldset id="content">
			<legend>
				<font color="orange" size="3"><b>Confirm</b></font>
			</legend>
			<input type="hidden" name="seat_num" value="${seat_num}">

			<br> ${seat_num}번 자리 예약 하시겠습니까? <br> <br>
		</fieldset>


		<br> <input class="inputbutton" type="submit" value="확인"/> 
		<input class="inputbutton" type="button" value="취소" onclick="window.location='seatList'" />

	</form>
</body>
</html>