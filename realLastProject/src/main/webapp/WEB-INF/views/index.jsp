<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="menu/guestHeader.jsp" %>	

<title>로그인 화면</title>

<body>
	<form method="post" action="memberLoginPro">
	<input type="hidden" name="memCode" value="0">
		<fieldset>
			<legend> 회원 로그인 </legend>
			<table class="member">
				<tr>
					<th>ID</th>
					<td>
						<input class="input" type="text" name="id" maxlength="12">
					</td>
				<tr>
					<th>Password</th>
					<td>
						<input class="input" type="password" name="passwd"
						maxlength="10">
					</td>
				</tr>

			</table>
			<table class="button">
				<tr>
					<td>
						<input type="submit" value="로그인"> 
						<input type="reset" value="취소"> 
						<input type="button" value="회원가입" onclick="window.location='memberRegister'">
					</td>
				</tr>
			</table>
		</fieldset>
		<fieldset>
			<legend>비회원 로그인</legend>
			<table class="nomember">
				<tr>
					<td>
						비회원<br> 
						<a href="nomemberLoginPro?memCode=0"><img src="/lastproject/resources/images/nom.png" width=70 height=70></a><br>
					</td>
				</tr>
			</table>
		</fieldset>

		<a href="hostLoginForm"><img class="host"
			src="/lastproject/resources/images/mem.png" width=70 height=70></a>

	</form>
</body>
</html>