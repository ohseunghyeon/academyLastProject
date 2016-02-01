<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<style>
th {
	font-size: 18px;
	font-family: "맑은 고딕";
}

td {
	font-size: 18px;
	font-family: "맑은 고딕";
	margin-left: 20px;
	text-align: center;
}

a {
	text-decoration: none;
}

.title {
	float: right;
	text-align: right;
	margin: 30px 280px;
}

.table {
	float: left;
	border: 3px solid;
	border-color: #FFE8FF;
	width: 500px;
	height: 400px;
	margin: 10px 100px;
}

.button {
	display: inline-block;
	outline: none;
	cursor: pointer;
	text-align: center;
	text-decoration: none;
	font: 13px/100% Arial, Helvetica, sans-serif;
	color: #5F00FF;
	background-color: #FFFFFF;
	border-color: #D4F4FA;
	padding: .5em .5em .55em;
	text-shadow: 0 1px 1px rgba(0, 0, 0, .1);
	-webkit-border-radius: .5em;
	-moz-border-radius: .5em;
	border-radius: .5em;
	-webkit-box-shadow: 0 1px 2px rgba(0, 0, 0, .1);
	-moz-box-shadow: 0 1px 2px rgba(0, 0, 0, .1);
	box-shadow: 0 1px 2px rgba(0, 0, 0,, .1);
	width: 70px;
}

.date {
	margin-left: 100px;
}

div {
	border: 1px solid #D4EDE2;
	padding-top: 0px;
	padding-right: 0px;
	padding-left: 0px;
	padding-bottom: 0px;
	margin-top: 0px;
	margin-right: 0px;
	margin-left: 0px;
	margin-bottom: 0px;
	text-align: center;
}

#con {
	width: 1024px;
	margin: 0 auto;
	overflow: hidden;
}

#header {
	width: 300px;
	height: 30px;
	line-height: 30px;
	text-align: center;
	float: right;
	font-size: 12px;
	color: red;
}

#nav {
	width: 1024px;
	height: 80px;
	clear: both;
}

#nav ul {
	overflow: hidden;
	width: 1024px;
	height: 37px;
}

#nav ul li {
	width: 150px;
	height: 35px;
	line-height: 30px;
	text-align: center;
	list-style: none;
	float: left;
	border: 1px solid #dddddd;
	margin-right: auto;
}

body {
	width: 1024px;
}

#wrap {
	width: 1024px;
	overflow: hidden;
	height: 1000px;
}

#content {
	width: 1024px;
	height: 1000px;
	float: left;
}

#banner {
	width: 320px;
	height: 500px;
	float: left;
}

#footer {
	width: 1024px;
	height: 50px;
	line-height: 50px;
}

#con #nav p {
	height: 0px;
	line-height: 0px;
}
</style>
<h3>정산 페이지(${time})</h3>
	<form>
		<table>
			<tr>
			<td><input class="button" type="button" value="일간" 
					onclick="window.location='accountDay'"></td>
			</tr>	
		</table>
	
		<table border ="1">
		<c:forEach var="dayList" items="${list}">
			<tr>
				<th>주문번호</th>
				<th>좌석번호</th>
				<th>주문시간</th>
				<th>사용시간</th>
				<th>가격</th>
			</tr>
			<tr>
				<td>${dayList.order_id}</td>
				<td>${dayList.seat_num}</td>
				<td>${dayList.order_time}</td>
				<td>${dayList.used_time}</td>
				<td>${dayList.price}</td>	
			</tr>
		</c:forEach>
		</table>
		<c:set var="dto" value="${dto}" />
		<table border="1">
			<tr>
				<th>총 가격</th>
			</tr>
			<tr>
				<td>${dto.total_price}</td>
			</tr>	
		</table>
	</form>