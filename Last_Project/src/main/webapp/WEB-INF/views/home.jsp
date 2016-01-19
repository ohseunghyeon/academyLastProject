<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<title>여행사</title>
<link type="text/css" rel="stylesheet" href="./resources/style.css">
</head>
<body>
	<header>
		<h1>
			<a href="./">OO여행사</a>
		</h1>
		<ul class="header_side">
		<c:if test="${sessionScope.LoginId == null}">
			<li><a href="">로그인</a></li>
			<li><a href="">회원가입</a></li>
		</c:if>
		<c:if test="${sessionScope.LoginId != null}">
			<li><a href="">로그아웃</a></li>
			<li><a href="">회원정보관리</a></li>
		</c:if>
		</ul>
	</header>
	<nav>
		<ul id="nav">
			<li><a href="">회사소개</a></li>
			<li><a href="">여행 패키지</a>
				<ul>
					<li><a href="">이용 안내</a></li>
					<li><a href="">서울</a></li>
					<li><a href="">강원도</a></li>
					<li><a href="">부산</a></li>
					<li><a href="">제주도</a></li>
				</ul>
			</li>
			<li><a href="">여행정보</a>
				<ul>
					<li><a href="">어딘가 정보</a></li>
					<li><a href="">날씨 정보</a></li>
				</ul>
			</li>
			<li><a href="">게시판</a>
				<ul>
					<li><a href="">공지사항</a></li>
					<li><a href="">여행문의</a></li>
				</ul>
			</li>
		</ul>
	</nav>
</body>
</html>