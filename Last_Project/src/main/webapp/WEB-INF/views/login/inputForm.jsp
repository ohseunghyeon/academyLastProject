<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link type="text/css" rel="stylesheet" href="./resources/headerfooter.css">
</head>
<body onload="inputfocus()">
<jsp:include page="../headerFooter/header.jsp" flush="false" />

<h2> 회원가입 </h2>
	<form method="post" name="inputform" onsubmit="return inputcheck()">
		<input type="hidden" name="confirmid" value="0">
		<table>
			<tr>
				<th colspan="2">회원정보를 입력하세요</th>
			</tr>
			<tr>
				<th> * 아이디 </th>
				<td>
					<input class="input" type="text" name="id" maxlength="12">
					<input class="inputbutton" type="button" value="중복확인" onclick="confirmId()">
				</td>
			</tr>
			<tr>
				<th> * 비밀번호 </th>
				<td>
					<input class="input" type="password" name="passwd" maxlength="12">
				</td>
			</tr>		
			<tr>
				<th> * 확인 </th>
				<td>
					<input class="input" type="password" name="repasswd" maxlength="12">
				</td>
			</tr>
			<tr>
				<th>* 이름 </th>
				<td>
					<input class="input" type="text" name="name" maxlength="12">
				</td>
			</tr>
			<tr>
				<th>* 주민번호 </th>
				<td>
					<input class="input" type="text" name="jumin1" maxlength="6"
						style="width: 50px" onkeyup="nextjumin1()">
					- <input class="input" type="text" name="jumin2" maxlength="7"
						style="width: 60px" onkeyup="nextjumin2()">
				</td>			
			</tr>
			<tr>
				<th> 전화번호 </th>
				<td>
					<input class="input" type="text" name="tel1" maxlength="3"
						style="width: 30px" onkeyup="nexttel1()">
					- <input class="input" type="text" name="tel2" maxlength="4"
						style="width:40px" onkeyup="nexttel2()">
					- <input class="input" type="text" name="tel3" maxlength="4"
						style="width:40px" onkeyup="nexttel3()">
				</td>
			</tr>
			<tr>
				<th> 이메일 </th>
				<td>
					<input class="input" type="text" name="email1" maxlength="15"
						style="width:100px">
					@
					<select name="email2" class="input">
						<option value="0"> 직접입력 </option>
						<option value="naver.com"> 네이버 </option>
						<option value="daum.net"> 다음 </option>
						<option value="nate.com"> 네이트 </option>
						<option value="gmail.com"> 구글 </option>
					</select>			
				</td>
			</tr>
			<tr>
				<th colspan="2">
					<input class="inputbutton" type="button" value="회원가입" onclick="window.location='login'">
					<input class="inputbutton" type="reset" value="취소">
					<input class="inputbutton" type="button" value="가입취소" onclick="window.location='login'">
				</th>
			</tr>

		</table>
	</form>
<jsp:include page="../headerFooter/footer.jsp" flush="false" />
</body>
</html>