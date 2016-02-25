<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
<style>
#check {

display:inline;
}

#danger {
background:#FFB2AF;
}

#info {
background:#FAFAD2 ;

}

#warning {
background:#FAFAD2 ;
}

</style>	
	
	
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
			alert("아이디가 입력되지 않았네요.(^^;)");
			return false;
		}
		var url = "confirmId?id=" + document.registerform.id.value;
		window.open(url, "confirm", "menubar=no, width=500, height=300");
	}
	
	function confirmEmail() {
		if (!document.registerform.email.value) {
			alert("이메일이 입력되지 않았네요.(^^;)");
			return false;
		}
		var url = "confirmEmail?email=" + document.registerform.email.value;
		window.open(url, "confirm", "menubar=no, width=500, height=300");
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
		} else if (form.confirmemail.value == 2) { //중복확인을 하지 않은 경우 경고..
			alert("이메일 중복확인을 해주세요.");
			form.email.focus();
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

<br><br>
<h2>
	<p class="text-center">Register</p>
</h2><br>
<div class="container-fluid text-center">
	<div class="row content">
		<div class="col-sm-2 sidenav"></div>
		<div class="col-sm-8 text-left">

			<form method="post" action="memberRegisterPro" name="registerform" onsubmit="return inputCheck(this)">
					<input type="hidden" name="confirmid" value="2"><!-- 중복확인 했는지 알기 위함 -->
					<input type="hidden" name="confirmemail" value="2">
				<table
					class="table table-striped table-bordered table-hover table-condensed text-center">
					<tr id="danger">
						<th colspan=2><p class="text-center">
								<mark>회원 가입 메뉴입니다. 아래에 정보를 입력하세요.</mark>
							</p></th>
					<tr>
					<tr id="warning">
						<th><h4>
								<p class="text-center">ID</p>
							</h4></th>
						<td><input id="check" class="form-control" type="text" name="id"
							placeholder="Enter id" style="width:300px;">
							<button id="check" type="button" class="btn btn-warning" onclick="confirmId()">중복체크</button>
						</td>
					</tr>
					<tr id="info">
						<th><h4>
								<p class="text-center">Password</p>
							</h4></th>
						<td><input class="form-control" type="password" name="passwd"
							placeholder="Enter password"></td>
					</tr>
					<tr id="warning">
						<th><h4>
								<p class="text-center">Phone Number</p>
							</h4></th>
						<td><input class="form-control" type="text"
							name="phone_number" placeholder="Enter number"></td>
					</tr>
					<tr id="info">
						<th><h4>
								<p class="text-center">Email</p>
							</h4></th>
						<td><input id="check" class="form-control" type="email" name="email"
							placeholder="Enter email" style="width:500px;">
							<button id="check" type="button" class="btn btn-warning" onclick="confirmEmail()">중복체크</button>
						</td>
					</tr>
					<tr id="danger">
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