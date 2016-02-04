<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<c:if test="${sessionScope.id == 'host'}">
<jsp:include page="../menu/hostHeader.jsp" flush="false" />
</c:if>
<c:if test="${sessionScope.id != 'host'}">
<jsp:include page="../menu/guestHeader.jsp" flush="false" />
</c:if>
<h3><p class="text-center">WRITE</p></h3>
<div class="container-fluid text-center">    
  <div class="row content">
    <div class="col-sm-2 sidenav">
    </div>
    <div class="col-sm-8 text-left"> 
	<body onload="writefocus()">
	<form action="writePro" name="writeform" method="post" onsubmit="return writecheck()">
	
		<input type="hidden" name="num" value="${num}">
		<input type="hidden" name="ref" value="${ref}">
		<input type="hidden" name="re_step" value="${re_step}">
		<input type="hidden" name="re_level" value="${re_level}">
		<input type="hidden" name="writer" value="${id}">
		
		<table class="table table-striped table-bordered table-hover table-condensed text-center">
		
			<tr class="info">
				<th><p class="text-center">작성자</p></th>
				<td><p class="text-center">${id}</p></td>
			</tr>
			<tr class="warning">
				<th><p class="text-center">이메일</p></th>
				<td>
				 <input type="text" class="form-control" name="email" placeholder="Enter email">
				</td>
			</tr>
			<tr class="info">
				<th><p class="text-center">글제목</p></th>
				<td>
					 <input type="text" class="form-control" name="subject" placeholder="Enter subject">
				</td>
			</tr>
			<tr class="warning" >
				<th><p class="text-center">글내용</p></th>
				<td>
				 <textarea rows="10" cols="70" name="content" placeholder="Enter content"></textarea>
				</td>
			</tr>
			<tr class="info">
				<th><p class="text-center">비밀번호</p></th>
				<td>
					 <input type="password" class="form-control" name="passwd" placeholder="Enter password">
				</td>
			</tr>
			<tr class="info">
				<th colspan="2">
				<p class="text-center">
				<button type="submit" class="btn btn-warning">작성
				</button>
				<button type="reset" class="btn btn-warning">취소
				</button>
				<a href="boardList"><button type="button" class="btn btn-warning">목록보기
				</button></a>
				</p>
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