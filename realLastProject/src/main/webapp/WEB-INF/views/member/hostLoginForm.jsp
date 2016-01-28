<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<title>관리자 로그인</title>

<body>
	<form method="post" action="hostLoginPro">
	<input type="hidden" name="memCode" value="0">
		<table class="member">
				<tr>
					<th colspan="2">관리자 메뉴에 접근하려면 비밀번호를 입력해 주세요.</th>
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
					<input type="button" value="돌아가기" onclick="window.location='index'"> 
				</td>
		</tr>
		</table>
	</form>	
</body>