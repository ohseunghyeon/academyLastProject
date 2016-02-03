<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<head>
<title>회원가입</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
<script
	src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
<script type="text/javascript">
	function confirmId() {
		if (!document.registerform.id.value) {
			alert("아이디는 넣고 중복체크 버튼을 눌러-_-");
			return false;
		}
		var url = "confirmId?id=" + document.registerform.id.value;
		window.open(url, "confirm", "manubar=no, width=300, height=200");
	}
	function inputCheck(form) {
		if (!form.id.value) {
			alert("아이디를 입력하세요.");
			form.id.focus();
			return false;
		} else if (!form.passwd.value) {
			alert("비밀번호를 입력하세요.");
			form.passwd.focus();
			return false;
		} else if (form.confirmid.value == 2) { //중복확인을 하지 않은 경우 경고..
			alert("아이디 중복확인을 해주세요.");
			form.id.focus();
			return false;
		}
	}
</script>
</head>
<style>
th {
	width: 200px;
}
</style>


<h3>
	<p class="text-center">Register</p>
</h3>
<div class="container-fluid text-center">
	<div class="row content">
		<div class="col-sm-2 sidenav"></div>
		<div class="col-sm-8 text-left">

			<form method="post" action="memberRegisterPro" name="registerform" onsubmit="return inputCheck(this)">
					<input type="hidden" name="confirmid" value="2"><!-- 중복확인 했는지 알기 위함 -->
				<table
					class="table table-striped table-bordered table-hover table-condensed text-center">
					<tr class="danger">
						<th colspan=2><p class="text-center">
								<mark>회원 가입 메뉴입니다. 아래에 정보를 입력하세요.</mark>
							</p></th>
					<tr>
					<tr class="warning">
						<th><h4>
								<p class="text-center">ID</p>
							</h4></th>
						<td><input class="form-control" type="text" name="id"
							placeholder="Enter id"></td>
						<td>
							<input type="button" value="중복체크다" onclick="confirmId()">
						</td>
					</tr>
					<tr class="info">
						<th><h4>
								<p class="text-center">Password</p>
							</h4></th>
						<td><input class="form-control" type="password" name="passwd"
							placeholder="Enter password"></td>
					</tr>
					<tr class="warning">
						<th><h4>
								<p class="text-center">Phone Number</p>
							</h4></th>
						<td><input class="form-control" type="text"
							name="phone_number" placeholder="Enter number"></td>
					</tr>
					<tr class="info">
						<th><h4>
								<p class="text-center">Email</p>
							</h4></th>
						<td><input class="form-control" type="text" name="email"
							placeholder="Enter email"></td>
					</tr>
					<tr class="danger">
						<th colspan="3"><p class="text-center">
								<button type="submit" class="btn btn-warning">회원가입</button>
								<button type="reset" class="btn btn-warning">초기화</button>
								<button type="button" class="btn btn-warning"
									onclick="window.location='index'">돌아가기</button>
							</p></th>
				</table>
			</form>
		</div>
	</div>
</div>