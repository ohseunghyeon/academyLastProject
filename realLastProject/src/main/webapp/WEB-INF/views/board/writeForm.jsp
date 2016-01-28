<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 

<h2>글쓰기</h2>
<body onload="writefocus()">
	<form action="writePro" name="writeform" method="post" onsubmit="return writecheck()">
	
		<input type="hidden" name="num" value="${num}">
		<input type="hidden" name="ref" value="${ref}">
		<input type="hidden" name="re_step" value="${re_step}">
		<input type="hidden" name="re_level" value="${re_level}">
		
		<table border="1">
			<tr>
				<th colspan="2" align="right">
					<a href="list">글목록</a>
				</th>
			</tr>
			<tr>
				<th>작성자</th>
				<td>${id}</td>
			</tr>
			<tr>
				<th>이메일</th>
				<td>
					<input class="input" type="text" name="email" maxlength="40">
				</td>
			</tr>
			<tr>
				<th>글제목</th>
				<td>
					<input class="input" type="text" name="subject" maxlength="50">
				</td>
			</tr>
			<tr>
				<th>글내용</th>
				<td>
					<textarea rows="10" cols="50" class="input"  name="content"></textarea>
				</td>
			</tr>
			<tr>
				<th colspan="2">
					<input class="inputbutton" type="submit" value="작성">
					<input class="inputbutton" type="reset" value="취소">
					<input class="inputbutton" type="button" value="목록보기" onclick="window.location='list'">
				</th>
			</tr>
		</table>
	</form>
</body>
</html>