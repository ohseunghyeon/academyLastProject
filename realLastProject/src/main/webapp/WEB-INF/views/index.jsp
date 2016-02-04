<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<style>
<!--
 span{
 background: #FF9E7D;

 }
</style>

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
<body>

	<div class="container">
		<div class="page-header">
			<h3>SASAEG CAFE</h3>
		</div>
	</div>
	<div class="container">

		<input type="hidden" name="memCode" value="0">
		<div class="row">
			<div class="col-xs-6">
				<form method="post" action="memberLoginPro">
					<div class="alert alert-success"
						style="width: 500px; height: 300px">
						<h3>
							<strong>로그인</strong>
						</h3>
						<table
							style="width: 400px; height: 100px;">
							<thead>
								<tr>
									<th><h3>
											<p class="text-center">
											<h2><span id="span" class="label">아이디</span></h2>
											</p>
										</h3></th>
									<th>
										<!-- <form role="form"> -->
										<div class="form-group">
											<br> <input type="text" class="form-control" name="id"
												placeholder="Enter id" required />
										</div> <!-- </form> -->
									</th>
								</tr>
								<tr>
									<th>
										<h3>
											<p class="text-center">
											<h2><span id="span" class="label">비밀번호</span></h2>
											</p>
										</h3>
									</th>
									<th>
										<!-- <form role="form"> -->
										<div class="form-group">
											<br> <input type="password" class="form-control"
												name="passwd" placeholder="Enter password" required />
										</div> <!-- </form> -->
									</th>
								</tr>
							</thead>
						</table>
						<div class="pull-right">
							<button type="submit" class="btn btn-warning">로그인</button>
							<!-- <button type="reset" class="btn btn-warning">취소</button> -->
							<button type="button" class="btn btn-warning"
								onclick="window.location='memberFindForm'">아이디/비밀번호 찾기</button>
							<button type="button" class="btn btn-warning"
								onclick="window.location='memberRegister'">회원가입</button>
						</div>
					</div>
				</form>
			</div>
			<div class="col-xs-6">
				<div class="alert alert-success"
					style="width: 500px; height: 300px;">
					<h3>
						<p class="text-center">
							<strong>비회원!</strong>
						</p>
					</h3>
					<br> <br>
					<p class="text-center">
						<a href="nomemberLoginPro" class="success"><img
							src="/lastproject/resources/images/nomember.png"
							class="img-rounded" alt="비회원" width="300" height="120"></a>
					</p>
				</div>
			</div>
		</div>

	</div>
	<br>
	<br>
	<br>
	<div class="container">
		<div class="row">
			<div class="col-xs-10"></div>
			<div class="col-xs-2">
				<div class="pull-right">
					<a href="hostLoginForm" class="success"><img
						src="/lastproject/resources/images/glyphicons_free/glyphicons_free/glyphicons/png/glyphicons-197-exclamation-sign.png"
						class="img-rounded" alt="관리자로그인" width="50" height="50"></a>
				</div>
			</div>
		</div>
	</div>
	<footer class="container-fluid text-center">
		<p>
			저희 카페에 찾아주셔셔 감사합니다. <a href="" title="Visit">SASAEG CAFE</a>
		</p>
	</footer>
</body>
</html>