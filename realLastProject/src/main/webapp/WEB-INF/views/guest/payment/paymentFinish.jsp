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
			

			<br> 결제내역 확인 페이지 <br> <br>
		</fieldset>


		<br> 
		<input class="inputbutton" type="button" value="처음으로" onclick="window.location='index'" />

	</form>
</body>
</html>
<jsp:include page="../../menu/guestFooter.jsp" flush="false"/>