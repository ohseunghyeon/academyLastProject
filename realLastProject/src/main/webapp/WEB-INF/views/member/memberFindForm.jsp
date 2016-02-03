<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<title>ID/비밀번호 찾기</title>

<form method="post" action="memberFindPro">
<input type="hidden" name="idorpass" value="0"> 
	<fieldset>
		<legend>집 나간 아이디를 찾습니다.</legend>
		<h3>아이디가 생각나지 않으신다면 이하의 정보를 입력하세요.</h3>
		<table>
			<tr>
				<th>이메일</th>
				<td><input type="email" name="email" maxlength="20"></td>
			</tr>
		</table>
	</fieldset>
	<fieldset>
		<input type="submit" value="아이디 찾기"> <input type="button"
			value="돌아가기" onclick="window.location='index'">
	</fieldset>
</form>
<form method="post" action="memberFindPro">
<input type="hidden" name="idorpass" value="1"> 
	<fieldset>
		<legend>머리속 지우개가 지우고 간 비밀번호를 찾습니다.</legend>
		<h3>비밀번호가 생각나지 않으신다면 이하의 정보를 입력하세요.</h3>
		<table>
			<tr>
				<th>아이디</th>
				<td><input type="text" name="id" maxlength="10"></td>
			</tr>
			<tr>
				<th>이메일</th>
				<td><input type="email" name="email" maxlength="20"></td>
			</tr>
		</table>
	</fieldset>
	<fieldset>
		<input type="submit" value="비밀번호 찾기"> <input type="button"
			value="돌아가기" onclick="window.location='index'">
	</fieldset>
	<img src = "../resources/images/WantedPoster.png"
		width="300" height=300>
</form>