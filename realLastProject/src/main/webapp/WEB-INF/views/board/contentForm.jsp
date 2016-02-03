<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.first.lastproject.dto.BoardDto" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %> 
<%@ page import="java.text.SimpleDateFormat" %>
<c:if test="${sessionScope.id == 'host'}">
<jsp:include page="../menu/hostHeader.jsp" flush="false" />
</c:if>
<c:if test="${sessionScope.id != 'host'}">
<jsp:include page="../menu/guestHeader.jsp" flush="false" />
</c:if>
<h3><p class="text-center">WRITE</p></h3>
<div class="container text-center">    
  <div class="row content">
    <div class="col-sm-2 sidenav">
    </div>
    <div class="col-sm-8 text-left"> 
	<table class="table table-bordered table-hover table-condensed text-center ">
		<tr>
			<th style="width : 150px"><p class="text-center bg-warning" >글번호</p></th>
			<td style="width: 150px" align="center"><p class="text-center">${number}</p></td>
			<th style="width : 150px"><p class="text-center bg-warning">조회수</p></th>
			<td style="width: 150px" align="center"><p class="text-center">${dto.readcount}</p></td>
		</tr>
		<tr>
		<th><input type="hidden" name="id" value="${sessionScope.id}"><p class="text-center bg-warning">작성자</p></th>
		<td align="center"><p class="text-center">${dto.writer}</p></td>
		<th><p class="text-center bg-warning">작성일</p></th>
		<td align="center"><p class="text-center">
		<fmt:formatDate value="${dto.reg_date}" type="both" pattern="yyyy-MM-dd HH:mm"/></p> </td>
		</tr>
		<tr>
		<th><p class="text-center bg-warning">글제목</p></th>
		<td align="center"><p class="text-center">${dto.subject}</p></td>
		<th><p class="text-center bg-warning">이메일</p></th>
		<td align="center"><p class="text-center">${dto.email}</p></td>
		</tr>
		<tr>
		<th><p class="text-center bg-warning">글내용</p></th>
		<td colspan="3">
			<pre class="bg-warning">${dto.content}</pre></td>
		</tr>
		<tr>
			<th colspan="4">
			<p class="text-center">
			<button type="button" class="btn btn-warning" onclick="window.location='boardModifyForm?num=${dto.num}&pageNum=${pageNum}'">글수정</button>
			<button type="button" class="btn btn-warning" onclick="window.location='deleteForm?num=${dto.num}&pageNum=${pageNum}'">글삭제</button>
			<button type="button" class="btn btn-warning" onclick="window.location='boardList?pageNum=${pageNum}'">목록보기</button>
			</p>
				</th>
		</tr>
	</table>
</div>
 <div class="col-sm-2 sidenav">
    </div>
</div>
</div>
</html>
<jsp:include page="../menu/guestFooter.jsp" flush="false"/>