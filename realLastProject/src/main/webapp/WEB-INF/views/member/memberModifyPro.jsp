<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<title>정보 수정 확인</title>
</head>
<body>
<c:if test="${result == 0}">
	<script type="text/javascript">
		erroralert();
	</script>	
</c:if>
<c:if test="${result != 0}">
	<script type="text/javascript">
		alert("정보가 수정되었습니다.");
	</script>
	<c:redirect url="memberMain" />
</c:if>
</body>
