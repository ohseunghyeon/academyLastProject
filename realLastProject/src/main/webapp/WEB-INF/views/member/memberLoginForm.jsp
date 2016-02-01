<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="../menu/guestHeader.jsp" flush="false"/>
<title>로그인 재시도 화면</title>
</head>


<body>
<form method="post" action="memberLoginPro">
	<fieldset>
		<legend>로그인에 실패하였습니다. 
		<c:if test="${result != -1}">
		아이디를 다시 확인하세요.
		</c:if>
		<c:if test="${result == -1}">
		비밀번호를 다시 확인하세요.
		</c:if>
		</legend>
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
				</td>
		</tr>
		</table>
	</fieldset>
	</form>
</body>
</html>