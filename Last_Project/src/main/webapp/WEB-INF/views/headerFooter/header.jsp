<%@ page contentType = "text/html; charset=utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
	<header>
		<h1>
			<a href="./"><img src="/portfolio/resources/images/logo.png" width="332" height="163" alt=""/></a>
		</h1>
		<ul class="header_side">
		<c:if test="${sessionScope.LoginId == null}">
			<li><a href="login">로그인</a></li>
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
			<li><a href="companyIntro">회사소개</a></li>
			<li><a href="">여행 패키지</a>
				<ul>
					<li><a href="">이용 안내</a></li>
					<li><a href="seoulcatalog">서울</a></li>
					<li><a href="gangwondocatlog">강원도</a></li>
					<li><a href="busancatelog">부산</a></li>
					<li><a href="jejucatalog">제주도</a></li>
				</ul>
			</li>
			<li><a href="">여행정보</a>
				<ul>
					<li><a href="">여행정보</a></li>
					<li><a href="">날씨정보</a></li>
				</ul>
			</li>
			<li><a href="noticeBoard">공지사항</a>
				<ul>
					<li><a href="noticeBoard">공지사항</a></li>
					<li><a href="questionBoard">여행문의</a></li>
				</ul>
			</li>
		</ul>
	</nav>
	<div class="clear"></div>