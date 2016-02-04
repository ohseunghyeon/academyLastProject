<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page import="java.sql.*"%>
<jsp:include page="../../menu/hostHeader.jsp" flush="false" />
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<div class="container-fluid">
	<div class="row">
 		<div class="col-sm-4" ></div>
 		 <div class="col-sm-4" ><br>
	<div id="wrap">
		<br>
		<form action="seatFinish" method="post" name="">
			<fieldset>
				<legend align="left">
					<font color="orange" size="5"><b>${orderDto.seat_num}번
							좌석</b></font>
				</legend>
				<table class="table table-bordered table-hover table-condensed text-center" >
				<input type="hidden" name="seat_num" value="${orderDto.seat_num}">
				<input type="hidden" name="order_id" value="${orderDto.order_id}">
				<tr>
				<td><h5><b>테이블 번호</b></h5></td><td>${orderDto.seat_num}</td>
				</tr>
				<tr>
				<td><h5><b>아이디</b></h5></td><td>${orderDto.id}</td>
				</tr>
				<tr>
				<td><h5><b>주문시간</b></h5></td><td><fmt:formatDate value="${orderDto.order_time}" type="time" pattern="(a)hh:mm:ss"/></td>
				</tr>
				<tr>
				<td><h5><b>종료시간</b></h5></td><td><fmt:formatDate value="${orderDto.end_time}" type="time" pattern="(a)hh:mm:ss"/></td>
				</tr>
				</table><p class="text-center">
				<button type="button" class="btn btn-warning" onclick="window.location='seatList'">확인</button>
				<button type="submit" class="btn btn-warning" onclick="return confirm('해당 테이블의 사용을 종료하시겠습니까?')">테이블 사용 종료</button>
				</p>
			</fieldset>
		</form>
	</div>
<div class="col-sm-4" ></div>
</div>
</div>
</div><br><br><br><br>
<jsp:include page="../../menu/hostFooter.jsp" flush="false" />