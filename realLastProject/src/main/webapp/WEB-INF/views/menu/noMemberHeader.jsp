<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">
<head>
  <title>사색카페 - 비회원</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
  <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
</head>
<div class="container">
  <div class="row">
    <div class="col-sm-6" style="background-color:lavender;"></div>
    <div class="col-sm-4" style="background-color:lavenderblush;"><mark>고객</mark>님 안녕하세요.</div>
   	<div class="col-sm-2" style="background-color:lavenderblush;">
    <a href="memberLogout"><span class="glyphicon glyphicon-log-out"></span>나가기</a>
    </div>
  </div>
  <blockquote>
   <h1>sasaeg cafe</h1>
  <p> 커피 한잔, 책 한권 북카페</p>
  </blockquote>
</div>

<nav class="navbar navbar-default">
  <div class="container">
    <div class="navbar-header">
      <a class="navbar-brand"><p>SASAEG <img src="/lastproject/resources/images/glyphicons_free/glyphicons_free/glyphicons/png/glyphicons-20-heart-empty.png"></p></a>
    </div>
    <ul class="nav navbar-nav">
      <li class="active"><a href="Home">이용안내</a></li>
      <li><a href="seatList">주문하기</a></li>
    </ul>
    <ul class="nav navbar-nav navbar-right">
      <li> <a href="index"><span class="glyphicon glyphicon-log-in"></span> Login</a></li>
      <li><a href="memberRegister"><span class="glyphicon glyphicon-user"></span> Sign Up</a></li>
    </ul>
  </div>
</nav>
