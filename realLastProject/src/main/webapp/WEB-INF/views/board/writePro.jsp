<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<script src= /lastproject/resources/SJscript.js></script>

<title>글쓰기 처리 페이지 </title>

	<c:if test="${result==0 }">
		<script type="text/javascript">
			<!-- 작성 실패 -->
		
			<!--
				erroralert(inserterror);
			
			//-->
		</script>
	</c:if>
	<c:if test="${result !=0 }">
		<!-- 작성 성공 -->
		<c:redirect url="boardList" />
	</c:if>

</html>