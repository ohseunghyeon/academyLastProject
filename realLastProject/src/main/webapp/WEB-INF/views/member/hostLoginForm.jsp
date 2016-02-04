<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html>
<html lang="en">
<head>
<title>사색 카페</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
<script
	src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
</head>    
<br><br><br>
<div class="container-fluid">
<div class="row">
<div class="col-sm-4" ></div>
<div class="col-sm-4" >
	<h1><p class="text-center">HOST LOGIN</p></h1><br><br><br><br><br><br>
	<form method="post" action="hostLoginPro">
	<input type="hidden" name="memCode" value="0">
		<table class="table table-striped table-bordered table-hover table-condensed text-center" >
				<tr class="danger">
					<th colspan="2"><mark>관리자 비밀번호</mark><small>를 입력해 주세요.</small></th>
				<tr>
					<th><h3><p class="text-center">Password</p></h3></th>
					<td><br>
						<input class="form-control" type="password" name="passwd" placeholder="Enter password" required />
					</td>	
				</tr>
		</table>
		<div class="pull-right">
				<button type="submit" class="btn btn-warning">로그인</button>
				<button type="button" class="btn btn-warning" onclick="window.location='index'">돌아가기</button>
		</div>
	</form>
</div>
<div class="col-sm-4" ></div>
</div>
</div>
<br><br><br><br>
	<footer class="container-fluid text-center">
		<p>
			여긴 관리자 전용 로그인 화면 입니다. <a href="" title="Visit">SASAEG CAFE</a>
		</p>
	</footer>
</body>
</html>