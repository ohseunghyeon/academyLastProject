<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<body>
<form method="post" action="memberModifyPro">
	<table border="1">
		<tr>
			<th colspan=2>회원 정보 수정 메뉴입니다. 수정할 정보를 입력하세요.</th>
		<tr>
		<tr>
			<th>아이디</th>
			<td>${dto.id}</td>	
		</tr>
		<tr>
			<th>비밀번호</th>
			<td><input type="password" name="passwd" maxlength="20" value="${dto.passwd}"></td>
		</tr>
		<tr>
			<th>전화번호</th>
			<td><input type="text" name="phone_number" maxlength="30" 
			value="${dto.phone_number}"></td>
		</tr>
		<tr>
			<th>이메일</th>
			<td><input type="text" name="email" maxlength="40" value="${dto.email}"></td>
		</tr>	
		<tr>
			<th>마일리지</th>
			<td>${dto.mileage}</td>
		</tr>
		<tr>
			<th colspan="3">
				<input class="inputbutton" type="submit" value="정보 수정">
				<input class="inputbutton" type="reset" value="초기화">
				<input class="inputbutton" type="button" value="돌아가기"
					onclick="window.location='memberMain'">
			</th>		
	</table>

</form>
</body>
