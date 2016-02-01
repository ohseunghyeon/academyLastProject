<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.first.lastproject.dto.BoardDto" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<%@ page import="java.text.SimpleDateFormat" %>
<jsp:include page="../menu/guestHeader.jsp" flush="false"/>
<title>글 보기 </title>
</head>
<body>
<h2>글보기 </h2>
	<table border="1">
		<tr>
			<th style="width : 150px">글번호</th>
			<th style="width: 150px" align="center">${number}</th>
			<th style="width : 150px">조회수</th>
			<th style="width: 150px" align="center">${dto.readcount}</th>
		</tr>
		<tr>
		<th>작성자</th>
		<td align="center">${dto.writer}</td>
		<th>작성일</th>
		<td align="center">
		<fmt:formatDate value="${dto.reg_date}" type="both" pattern="yyyy-MM-dd HH:mm"/> </td>
		</tr>
		<tr>
		<th>글제목</th>
		<td align="center">${dto.subject}</td>
		<th>이메일</th>
		<td align="center">${dto.email}</td>
		</tr>
		<tr>
		<th>글내용</th>
		<td colspan="3">
			<pre>${dto.content}</pre> </td>
		</tr>
		<tr>
			<th colspan="4">
				<input class="inputbutton" type="button" value="글수정" 
						onclick="window.location='boardModifyForm?num=${dto.num}&pageNum=${pageNum}'">
				<input class ="inputbutton" type="button" value="글삭제"
						onclick="window.location='deleteForm?num=${dto.num}&pageNum=${pageNum}'">
				<input class ="inputbutton" type="button" value="답글쓰기"
						onclick="window.location='writeForm?num=${dto.num}&ref=${dto.ref}&re_step=${dto.re_step}&re_level=${dto.re_level}'">
				<input class="inputbutton" type="button" value="목록보기" 
						onclick="window.location='list?pageNum=${pageNum}'">
				</th>
		</tr>
	</table>

</body>
</html>
<jsp:include page="../menu/guestFooter.jsp" flush="false"/>