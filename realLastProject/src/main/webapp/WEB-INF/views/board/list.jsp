<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %> 
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="java.util.ArrayList"%>
<%@ page import="com.first.lastproject.dao.board.BoardDao"%>
<%@ page import="com.first.lastproject.dto.BoardDto" %>
<jsp:include page="../menu/guestHeader.jsp" flush="false"/>
<title>게시판</title>
<div class="container">
<h3><p class="text-center">WRITE LIST<small>(글개수 : ${count})</small></p></h3>
	<div class="pull-right">
	 <a href="writeForm"><button type="button" class="btn btn-warning">Write
	 </button></a><br>
	 </div>

<table class="table table-striped table-bordered table-hover table-condensed text-center">
	<thead>
	<tr class="info">
		<th style="width: 5%"><p class="text-center">글번호</p></th>
		<th style="width: 35%"><p class="text-center">글제목</p></th>
		<th style="width: 10%"><p class="text-center">작성자</p></th>
		<th style="width: 15%"><p class="text-center">작성일</p></th>
		<th style="width: 5%"><p class="text-center">조회수</p></th>
		<th style="width: 10%"><p class="text-center">IP</p></th>

	</tr>
	</thead>
	<tbody>
	<c:if test="${count >0}">
		<c:forEach var="dto" items="${list}">
			<tr class="warning">
				<td align="center">
				 ${number}
				 	<c:set var="number" value="${number-1}"></c:set>
				 </td>
				 <td>
				 <c:if test="${dto.re_level >1 }">
				 	<c:set var="wid" value="${(dto.re_level -1) *10}" />
				 	<img src="${project}images/level.gif" border="0" width="${wid}" height="15">
				 </c:if>
				 	<c:if test="${dto.re_level >0 }">
				 		<img src="${project}images/re.gif" border="0" width="20" height="15">
				 	</c:if>
				 	<a href="contentForm?num=${dto.num}&pageNum=${pageNum}&number=${number+1}">${dto.subject}</a>
				 	<c:if test="${dto.readcount >20}">
				 		<img src="${project}images/hot.gif" border="0" width="20" height="15">
				 	</c:if>
				 </td>
				 <td align="center">
				 	${dto.writer}
				 </td>
				 <td align="center">
				 	<fmt:formatDate type="both" pattern="yyyy-MM-dd HH:mm" value="${dto.reg_date}" />
				 </td>
				 <td align="center">
				 	${dto.readcount}
				 </td>
				 <td align="center">
				 	${dto.ip}
				 </td>
			</tr>
		</c:forEach>
	</c:if>
	<c:if test="${count == 0}}">
		<!-- 글이 없는 경우 -->
		<tr>
			<td colspan="6" align="center" style="height:40px">
				게시판에 글이 없습니다. 글쓰기를 선택해 주세요.
			</td>
		</tr>
	</c:if>
</tbody>
</table>
</div>
<br>
<div class="container text-center">
	<c:if test="${count>0 }">
	<!-- 처음[◀◀] 이전[▶▶] -->
		<c:if test="${startPage >pageBlock}">
		<ul class="pagination pagination-sm">
		<li><a href="boardList">◀◀</a></li>
		<li><a href="boardList?pageNum=${startPage - pageBlock -1 }"> ◀</a></li>
		</ul>
		</c:if>
		<c:forEach var="i" begin="${startPage}" end="${endPage}">
		<ul class="pagination pagination-sm">
		<li class="disable"><c:if test="${i==currentPage}">
			[${i}]
		</c:if></li>
		<li><c:if test="${i !=currentPage }">
			<a href="boardList?pageNum=${i}">${i}</a>
			</c:if></li>
		</ul>
		</c:forEach>
	<!-- 다음[▶] 끝[▶▶] -->
		<c:if test="${pageCount >endPage}">
		<ul class="pagination pagination-sm">
		<li><a href="boardList?pageNum=${startPage + pageBlock}">▶</a></li>
		<li><a href="boardList?pageNum=${pageCount}">▶▶</a></li>
			</ul>
			</c:if>
	</c:if>
	<jsp:include page="../menu/guestFooter.jsp" flush="false"/>
</div>
