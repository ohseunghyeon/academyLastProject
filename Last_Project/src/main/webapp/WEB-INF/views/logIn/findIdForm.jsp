<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>


<script src="script.js"></script>
<link type="text/css" rel="stylesheet" href="">



<body>
	<form method="post" name="findForm">

		<table>
			<tr>
				<th>ID/PASSWD 찾기</th>
			</tr>

			<tr>
				<th>이름</th>
				<td><input class="input" type="text" name="name" maxlength="12">
				</td>
			</tr>
			<tr>
				<th>주민번호</th>
				<td><input class="input" type="text" name="jumin1"
					maxlength="6" style="width: 50px" onkeyup="nextjumin1()"> -
					<input class="input" type="text" name="jumin2" maxlength="7"
					style="width: 60px" onkeyup="nextjumin2()"></td>
			</tr>
			<tr>
				<th>이메일</th>
				<td><input class="input" type="text" name="email1"
					maxlength="15" style="width: 100px"> @ <select
					name="email2" class="input">
						<option value="0">직접입력</option>
						<option value="naver.com">네이버</option>
						<option value="daum.net">다음</option>
						<option value="nate.com">네이트</option>
						<option value="gmail.com">구글</option>
				</select></td>
			</tr>

			<tr>
				<th colspan="2"><br>
				<input class="inputButton" type="button" value="아이디 찾기" onclick="window.location='findIdView.jsp'"> 
				<input class="inputButton" type="button" value="비번밀번호찾기" onclick="window.location='findPasswdForm.jsp'">
			</tr>
		</table>
	</form>
</body>