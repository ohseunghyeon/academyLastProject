<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> ent="text/html; charset=EUC-KR">
<script src= /lastproject/resources/SJscript.js></script>
<h2>글 수정</h2>

	<c:if test="${result==0 }">
		<script type="text/javascript">
			<!-- 작성 실패 -->
		
			<!--
				erroralert(modifyerror);
			
			//-->
		</script>
	</c:if>
	<c:if test="${result !=0 }">
		<!-- 작성 성공 -->
		<c:redirect url="boardList?pageNum=${pageNum}" />
	</c:if>
</html>