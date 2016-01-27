<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<title>글삭제 페이지</title>
</head>
<body onload="passwdfocus()">
	<form action="deletePro" name="passwdform" method="post"  onsubmit="return passwdcheck()">
		<input type="hidden" name="num" value="${num}">
		<input type="hidden" name="pageNum" value="${pageNum}">
		
		<table>
			<tr>
				<th colspan="2">
					비밀번호를 다시 확인해 주세요.
				</th>
			<tr>
				<th> 비밀번호</th>
				<td>
					<input class="input" type="password" name="passwd" maxlength="12">
				</td>
			</tr>
			<tr>
				<th colspan="2">
					<input class="inputbutton" type="submit" value="글삭제">
					<input class="inputbutton" type="button" value=" 삭제취소" 
								onclick="window.location='list?pageNum=${pageNum}'">
				</th>
			</tr>
		</table>
	</form>
</body>
</html>