<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">

<link rel="stylesheet"
	href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
<script
	src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
<script type="text/javascript">
	function confirmCheck() {
		if (!document.confirmForm.email.value) {
			alert(msg_email);
			document.confirmForm.email.focus();
			return false;
		}
	}
	function confirmFocus() {
		document.confirmForm.email.focus();
	}

	function setEmail(email) {
		opener.document.registerform.email.value = email;
		opener.document.registerform.confirmemail.value = 1;
		self.close();
	}
</script>
</head>

<!-- email 중복 -->
<body onload="confirmFocus()">
	<h4>
		<p class="text-center">
			<mark>중복확인</mark>
		</p>
	</h4>
	<c:if test="${result == 1}">
		<form action="confirmEmail" method="post" name="confirmForm"
			onsubmit="return confirmCheck()">
			<table
				class="table table-striped table-bordered table-hover table-condensed text-center">
				<tr class="danger">
					<th colspan="2"><p class="text-center">
							<mark>${email}</mark>
							는 사용할 수 없습니다.
						</p></th>
				</tr>
				<br>
				<tr>
					<th><p class="text-center">Email</p></th>
					<td><input type="email" class="input" name="email" maxlength="30">
					</td>
				</tr>
				<tr>
					<th colspan="2"><p class="text-center">
							<button type="submit" class="btn btn-warning">확인</button>
							<button type="reset" class="btn btn-warning"
								onclick="self.close()">취소</button></th>
				</tr>
			</table>
		</form>
</c:if>
<!-- email 중복이 아닌 경우 -->

<c:if test="${result != 1}">
	<br>
	<table
		class="table table-striped table-bordered table-hover table-condensed text-center">
		<tr class="danger">
			<td><p class="text-center">
					<mark>${email}</mark>
					는 사용할 수 있습니다.
				</p></td>
		</tr>
		<tr>
			<th><p class="text-center">
					<button type="button" class="btn btn-warning"
						onclick="setEmail('${email}')">확인</button>
		</tr>
	</table>
</c:if>
</body>
