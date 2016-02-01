<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<jsp:include page="../menu/guestHeader.jsp" flush="false"/>
<h3><p class="text-center">WRITE</p></h3>
<div class="container-fluid text-center">    
  <div class="row content">
    <div class="col-sm-2 sidenav">
    </div>
    <div class="col-sm-8 text-left"> 
	<body onload="passwdfocus()">
	<form action="boardModifyView" name="passwdform" method="post" onsubmit="return passwdcheck()">
		<input type="hidden" name="num" value="${num}">
		<input type="hidden" name="pageNum" value="${pageNum}">
	
		<table>
			<tr>
				<th colspan="2">
					비밀번호를 다시 확인해주세요.
				</th>
			</tr>
			<tr>
				<th>비밀번호</th>
				<td><input class="input" type="password" name="passwd" maxlength="12"></td>
			</tr>
			<tr>
				<th colspan="2">
					<input class="inputbutton" type="submit" value="글수정">
					<input class="inputbutton" type="button" value="수정취소" 
								onclick="window.location='list?pageNum=${pageNum}'">
				</th>
			</tr>
		</table>	
	
	</form>
</body>
</div>
<div class="col-sm-2 sidenav">
</div>
</div>
</div>
</html>
<jsp:include page="../menu/guestFooter.jsp" flush="false"/>