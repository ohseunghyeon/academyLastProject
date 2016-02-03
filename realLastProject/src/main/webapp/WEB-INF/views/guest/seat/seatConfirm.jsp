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
<jsp:include page="../../menu/guestHeader.jsp" flush="false"/>

<div class="container-fluid">
	<div class="row">
 		<div class="col-sm-4" ></div>
 		 <div class="col-sm-4" ><br>
	<form action="seatSelectConfirmPro" method="post" name="seatConfirm">
		<fieldset id="content">
			<legend>
				<font color="orange" size="3"><b>Confirm</b></font>
			</legend>
			<input type="hidden" name="seat_num" value="${seat_num}">

			<br><h3><mark> ${seat_num}번</mark><small>자리 예약 하시겠습니까?</small></h3> <br> <br>
		</fieldset>


		<br> 
		<button type="submit" class="btn btn-warning">확인</button>
		<button type="button" class="btn btn-warning" onclick="window.location='seatList'">취소</button>

	</form>
</div>
<div class="col-sm-4" ></div>
</div>
</div>
<br>
<br>
<jsp:include page="../../menu/guestFooter.jsp" flush="false"/>