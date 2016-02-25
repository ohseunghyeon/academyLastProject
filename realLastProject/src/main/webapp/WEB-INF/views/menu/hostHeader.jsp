<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
  <title>관리자 화면</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
  <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
</head>
<div class="container">
  <div class="row">
    <div class="col-sm-8" style="background-color:lavender;"></div>
    <div class="col-sm-4" style="background-color:lavender;">
    <div class="pull-right"><mark>관리자</mark>전용 모드입니다.</div> </div>
  </div>
  <blockquote>
   <h1>sasaeg cafe</h1>
  <p> 커피 한잔, 책 한권 북카페</p>
  </blockquote>
</div>

<nav class="navbar navbar-inverse">
  <div class="container">
    <div class="navbar-header">
      <h4><a class="navbar-brand">SASAEG<img src="/lastproject/resources/images/glyphicons_free/glyphicons_free/glyphicons/png/glyphicons-20-heart-empty.png"></a></h4>
    </div>
    <ul class="nav navbar-nav">
      <li><a href="seatList"><h4>좌석</h4></a></li>
      <li><a href="hostOrderList"><h4>주문</h4></a></li>
      <li><a href="ingredient"><h4>재고</h4></a></li>
       <li><a href="accountDay"><h4>정산</h4></a></li>
      <li><a href="boardList"><h4>게시판</h4></a></li>
    </ul>
     <ul class="nav navbar-nav navbar-right">
      <li><a href="memberLogout"><h4><span class="glyphicon glyphicon-log-out"></span> Logout</h4></a></li>
    </ul>
  </div>
</nav>