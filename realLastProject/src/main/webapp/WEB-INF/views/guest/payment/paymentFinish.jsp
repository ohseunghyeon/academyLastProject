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

<div class="container-fluid">
	<div class="row">
 		<div class="col-sm-4" ></div>
 		 <div class="col-sm-4" ><br>
	<form action="seatSelectConfirmPro" method="post" name=seatConfirm>
		<fieldset id="content">
			<legend>
				<font color="orange" size="5"><b>Confirm</b></font>
			</legend>
			

			<br><h4>결제가 완료되었습니다.</h4> <br> <br>
		</fieldset>


		<br> 
		<button type="button" class="btn btn-warning" onclick="window.location='index'" >처음으로</button>
	</form>
</div>
<div class="col-sm-4" ></div>
</div>
</div>
<br>
<br>
<jsp:include page="../../menu/guestFooter.jsp" flush="false"/>