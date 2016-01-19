<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link type="text/css" rel="stylesheet" href="./resources/headerfooter.css">
</head>
<body>
<jsp:include page="../headerFooter/header.jsp" flush="false" />

	<form method="post" name="loginform">

		<table>
			<tr>
				<th>LOGIN</th>
			</tr>

			<tr>
				<th>아이디</th>
				<td><input class="input" type="text" name="id" maxlength="12">
				</td>
			</tr>
			<tr>
				<th>비밀번호</th>
				<td><input class="input" type="password" name="passwd"
					maxlength="10"></td>
			</tr>
			<tr>
				<th colspan="2">
				<br><input class="inputButton" type="submit" value="로그인"><br><br>
				<input class="inputButton" type="button" value="아이디/비번찾기" onclick="window.location='findidForm'"> 
				<input class="inputButton" type="button" value="회원가입" onclick="window.location='inputForm'"></th>
			</tr>
		</table>
	</form>
<jsp:include page="../headerFooter/footer.jsp" flush="false" />
</body>
</html>