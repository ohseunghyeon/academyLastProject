<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<title>로그인 화면</title>

<body>
<form method="post" action="memberLoginPro">
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
						<input class="input" type="password" name="passwd" maxlength="10">
					</td>	
				</tr>
	
			</table>
		<table class="button">
		<tr>
			<td>
				<input type="submit" value="로그인" >
				<input type="reset" value="취소">
				<input type="button" value="회원가입" onclick="window.location='memberRegister'"> 
				</td>
		</tr>
		</table>
	</fieldset>
	<fieldset>
	<legend> 비회원 로그인 </legend>
	<table class="nomember">
	<p>
	<a href ="takeOutSelect.html"><strong>비회원</strong></a><br>
	<img src = "/views/html/image/nom.png" width = 70 height=70><br>
	</p>
	</table>
	</fieldset>
	
	<a href="hostlogin.html"><img class="host" src = "/views/html/image/mem.png" width = 70 height=70></a>
	
	</form>
</body>
</html>