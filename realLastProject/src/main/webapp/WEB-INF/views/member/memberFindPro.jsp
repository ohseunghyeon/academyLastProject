<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<title>아이디/비밀번호 확인</title>
<c:set var="member" value="${dto}"/>
<c:if test="${result == 1}">
	<c:if test="${idorpass != 1}">
	당신의 아이디는 ${member.id}입니다.
	<input type="button" value="확인" onclick="window.location='index'">
	</c:if>
	<c:if test="${idorpass == 1}">
	당신의 비밀번호는 ${member.passwd}입니다.
	<input type="button" value="확인" onclick="window.location='index'">
	</c:if>
</c:if>
<c:if test="${result == -1}">
	<script type="text/javascript">
		alert("입력하신 정보가 맞지 않습니다. 다시 입력하세요.");
	</script>
	<c:redirect url="memberFindForm" />
</c:if>
<c:if test="${result == 0}">
	<script type="text/javascript">
		alert("처리 오류가 발생했습니다. 다시 시도하세요.");
	</script>
	<c:redirect url="memberFindForm" />
</c:if>
</body>