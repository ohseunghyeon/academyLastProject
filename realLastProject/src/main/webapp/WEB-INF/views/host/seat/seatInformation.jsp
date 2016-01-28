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
<input type = "hidden" name="seat_num" value="${orderDto.seat_num}">

${orderDto.order_id}
${orderDto.seat_num}
${orderDto.id}
${orderDto.order_time }
${orderDto.end_time }
</body>
</html>