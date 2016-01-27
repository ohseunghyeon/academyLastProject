<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<title>Insert title here</title>

<body>
	<form method="post" action="memberModifyView">
		<table class="member">
				<tr>
					<th colspan="2">확인을 위해 비밀번호를 다시 입력해 주세요.</th>
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
					<input type="button" value="돌아가기" onclick="window.location='memberMain'"> 
				</td>
		</tr>
		</table>
	</form>	
</body>
