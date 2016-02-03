<%@ page import="com.first.lastproject.dto.SeatDto"%>
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
<html>
<body>
	<form action="seatSelectConfirmPro" method="post" name=seatConfirm>
		<fieldset id="content">
			<legend>
				<font color="orange" size="3"><b>Confirm</b></font>
			</legend>
			

			<br> 결제가 완료되었습니다. <br> <br>
		</fieldset>


		<br> 
		<input class="inputbutton" type="button" value="처음으로" onclick="window.location='index'" />

	</form>
</body>
</html>
<jsp:include page="../../menu/guestFooter.jsp" flush="false"/>