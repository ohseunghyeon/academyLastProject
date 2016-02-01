<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.sql.*"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title></title>
</head>
<body>
	<div id="wrap">
		<br>
		<form action="seatFinish" method="post" name="">
			<fieldset>
				<legend align="left">
					<font color="orange" size="3"><b>${orderDto.seat_num}번
							좌석</b></font>
				</legend>
				<input type="hidden" name="seat_num" value="${orderDto.seat_num}">
				<input type="hidden" name="order_id" value="${orderDto.order_id}">
				테이블 번호 :${orderDto.seat_num} <br> 아이디 :${orderDto.id} <br>
				주문시간: ${orderDto.order_time } <br> 종료시간:${orderDto.end_time} <br>
				<br> <input class="inputbutton" type="button" value="확인"
					onclick="window.location='seatList'" /> <input class="inputbutton"
					type="submit" value="테이블 사용 종료"
					onclick="return confirm('해당 테이블의 사용을 종료하시겠습니까?')">

			</fieldset>
		</form>
	</div>
</body>
</html>