<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:include page="../menu/guestHeader.jsp" flush="false"/>
<title>회원가입</title>

<body>
<form method="post" action="memberRegisterPro">
	<table border="1">
		<tr>
			<th colspan=2>회원 가입 메뉴입니다. 아래에 정보를 입력하세요.</th>
		<tr>
		<tr>
			<th>아이디</th>
			<td><input type="text" name="id" maxlength="20"></td>	
		</tr>
		<tr>
			<th>비밀번호</th>
			<td><input type="password" name="passwd" maxlength="20"></td>
		</tr>
		<tr>
			<th>전화번호</th>
			<td><input type="text" name="phone_number" maxlength="30"></td>
		</tr>
		<tr>
			<th>이메일</th>
			<td><input type="text" name="email" maxlength="40"></td>
		</tr>	
		<tr>
			<th colspan="3">
				<input class="inputbutton" type="submit" value="회원 가입">
				<input class="inputbutton" type="reset" value="초기화">
				<input class="inputbutton" type="button" value="돌아가기"
					onclick="window.location='index'">
			</th>		
	</table>

</form>
</body>
</html>