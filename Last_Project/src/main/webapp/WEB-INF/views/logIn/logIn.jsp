<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>


<script src="script.js"></script>
<link type="text/css" rel="stylesheet" href="">



<body>
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
				<input class="inputButton" type="button" value="아이디/비번찾기" onclick="window.location='findIdForm.jsp'"> 
				<input class="inputButton" type="button" value="회원가입" onclick="window.location='inputForm.jsp'"></th>
			</tr>
		</table>
	</form>
</body>
