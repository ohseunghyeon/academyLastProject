<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<head>
<meta http-equiv="refresh" content="0; url=index" />
<title>회원가입 확인</title>
</head>
<body>
	<c:if test="${result == 0}">
		<script type="text/javascript">
			erroralert("회원가입에 실패하였습니다. 잠시 후 다시 시도해주세요.");
		</script>
	</c:if>
	<c:if test="${result != 0}">
		<script type="text/javascript">
			alert("회원가입을 축하드립니다! 로그인하세요.");
		</script>
	</c:if>
</body>
</html>