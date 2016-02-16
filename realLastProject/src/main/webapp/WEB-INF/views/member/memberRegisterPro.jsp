<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<title>회원가입 확인</title>

<body>
<c:if test="${result == 0}">
	<script type="text/javascript">
		erroralert();
	</script>	
</c:if>
<c:if test="${result != 0}">
	<script type="text/javascript">
		alert("회원가입을 축하드립니다! 로그인하세요.");
	</script>
	<c:redirect url="index" />
</c:if>		
</body>
</html>