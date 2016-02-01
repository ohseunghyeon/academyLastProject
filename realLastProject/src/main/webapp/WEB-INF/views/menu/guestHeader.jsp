<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">
<head>
  <title>Bootstrap Example</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
  <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
</head>
<div class="container">
  <div class="row">
    <div class="col-sm-6" style="background-color:lavender;"></div>
    <div class="col-sm-4" style="background-color:lavenderblush;">고객님 안녕하세요.</div>
   	<div class="col-sm-2" style="background-color:lavenderblush;">
   	<a href=" "><span class="glyphicon glyphicon-user"></span> Sign Up</a>
    <a href=" "><span class="glyphicon glyphicon-log-in"></span> Login</a>
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
      <a class="navbar-brand">SASAEG</a>
    </div>
    <ul class="nav navbar-nav">
      <li class="active"><a href="#">Home</a></li>
      <li><a href=" ">좌석</a></li>
      <li class="dropdown"><a class="dropdown-toggle" data-toggle="dropdown" href="#">메뉴<span class="caret"></span></a>
        <ul class="dropdown-menu">
          <li><a href="#">음료</a></li>
          <li><a href="#">디저트</a></li>
        </ul>
      <li><a href=" ">게시판</a></li>
    </ul>
    <ul class="nav navbar-nav navbar-right">
      <li><a href="">마일리지:0원</a></li>
      <li><a href="" >쿠폰:1개</a></li>
      <li><a href="" >회원정보수정</a></li>
    </ul>
  </div>
</nav>


</body>
</html>