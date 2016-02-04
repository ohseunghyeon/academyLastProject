<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
  <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
</head>
<style>
th{
background:#FAFAAA;
}
</style>
<br><br>
<h3>
	<p class="text-center">ID/Password 찾기</p>
</h3><br>
<br><br><br>
<div class="container-fluid text-center">
	<div class="row content">
<div class="col-sm-1 text-left"></div>
<div class="col-sm-5 text-left">
<form method="post" action="memberFindPro">
<input type="hidden" name="idorpass" value="0"> 
		<h4><p class="text-center"><mark>아이디</mark><small>가 생각나지 않으신다면 이하의 정보를 입력하세요.</small></p></h4>
		<table class="table table-striped table-bordered table-hover table-condensed text-center">
			<tr>
				<th><p class="text-center">Email</p></th>
				<td><div class="form-group">
				<input type="text" class="form-control" name="email" placeholder="Enter email"></div> 
			</tr>
			</tr>
		</table>
		<p class="text-center">
		<button type="submit" class="btn btn-warning">아이디 찾기</button>
		<button type="button" class="btn btn-warning" onclick="window.location='index'">돌아가기</button>
		</p>
</form>
</div>
<div class="col-sm-5 sidenav">
<form method="post" action="memberFindPro">
<input type="hidden" name="idorpass" value="1"> 
		<h4><p class="text-center"><mark>비밀번호</mark><small>가 생각나지 않으신다면 이하의 정보를 입력하세요.</small></p></h4>
		<table class="table table-striped table-bordered table-hover table-condensed text-center">
			<tr>
				<th><p class="text-center">ID</p></th>
				<td>
				<div class="form-group">
				<input type="text" class="form-control" name="id"placeholder="Enter id"></div> 
			</tr>
			<tr>
				<th><p class="text-center">Email</p></th>
				<td><div class="form-group">
				<input type="text" class="form-control" name="email" placeholder="Enter email"></div> 
			</tr>
		</table>
		<button type="submit" class="btn btn-warning">비밀번호 찾기</button>
		<button type="button" class="btn btn-warning" onclick="window.location='index'">돌아가기</button>
		
</form>
</div>
<div class="col-sm-1 text-left"></div>
</div>
</div>