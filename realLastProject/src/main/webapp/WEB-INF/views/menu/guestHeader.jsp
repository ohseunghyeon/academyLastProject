<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<!DOCTYPE html>
<html lang="en">
<head>
  <title>사색카페</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
  <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
</head>
<body>
<div class="container">
  <div class="row">
    <div class="col-sm-6" style="background-color:lavender;"></div>
    <div class="col-sm-4" style="background-color:lavenderblush;"><mark>${id}</mark>님 안녕하세요.</div>
   	<div class="col-sm-2" style="background-color:lavenderblush;">
    <a href="memberLogout"><span class="glyphicon glyphicon-log-out"></span>Logout</a>
    </div>
  </div>
  <blockquote>
   <h1>Sasaeg cafe</h1>
  <p> 커피 한잔, 책 한권 북카페</p>
  </blockquote>
</div>

<nav class="navbar navbar-default">
  <div class="container">
    <div class="navbar-header">
      <a class="navbar-brand"><span style="color:black">SASAEG<img src="/lastproject/resources/images/glyphicons_free/glyphicons_free/glyphicons/png/glyphicons-20-heart-empty.png"></span></a>
    </div>
    <ul class="nav navbar-nav">
    <li class="active"><a href="Home">이용안내</a></li>
      <li><a href="seatList">주문하기</a></li>
      <li><a href="boardList">게시판</a></li>
    </ul>
    <ul class="nav navbar-nav navbar-right">
      <li><a>마일리지:${mileage} point</a></li>
      <li>
      	  <c:if test="${coupon == 0}"><a>쿠폰이 없습니다.</a></c:if>
      	  <c:if test="${coupon != 0}"><a href="couponmain">쿠폰 보기</a></c:if>
      </li>
      <li><a href="memberModifyForm">회원정보수정</a></li>
    </ul>
  </div>
</nav>
