<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
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
<c:if test="${result==0 }">
		<script type="text/javascript">
			<!-- 작성 실패 -->
		
			<!--
				erroralert(passwderror);
			
			//-->
		</script>
	</c:if>
	<c:if test="${result !=0 }">
		<body onload="modifyfocus()">
			<form action="boardModifyPro" name="modifyform" method="post" onsubmit="return modifycheck()">
				<input type="hidden" name="num" value="${num}">
				<input type="hidden" name="pageNum" value="${pageNum}">
				
				<table class="table table-striped table-bordered table-hover table-condensed text-center">
					<tr class="danger">
						<th colspan="2"><p class="text-center">
						<h4><p class="text-center">수정할 정보를 입력하세요.</p></h4>
						</th>
					</tr>
					<tr>
						<th class="info"><p class="text-center">작성자</p></th>
						<td class="warning"><p class="text-center">${dto.writer}</p></td>
					</tr>		
					<tr>
						<th class="info"><p class="text-center">이메일</p></th>
						<td class="warning">
							<c:if test="${dto.email == null}">
								<input placeholder="Enter email" type="text" name="email" class="form-control">
							</c:if>
							<c:if test="${dto.email !=null}">
								<input class="form-control" type="text" name="email" placeholder="Enter email" value="${dto.email}">							
							</c:if>
						</td>
					</tr>
					<tr>
						<th class="info"><p class="text-center">글제목</p></th>
						<td class="warning">
						<input class="form-control" type="text" name="subject"  placeholder="Enter subject" value="${dto.subject}">
						</td>
					</tr>	
					<tr>
						<th class="info"><p class="text-center">글내용</p></th>
						<td class="warning">
						<textarea placeholder="Enter content" name="content" rows="10" cols="70" >${dto.content}</textarea>
						</td>
					</tr>			
					<tr>
						<th class="info"><p class="text-center">비밀번호</p></th>
						<td class="warning">
						<input class="form-control" type="password" name="passwd" placeholder="Enter subject" value="${dto.passwd}">
						</td>
					</tr>	
					<tr class="danger">
						<th colspan="2"><p class="text-center"> 
						<button type="submit" class="btn btn-warning">글수정</button>
						<button type="reset" class="btn btn-warning">글취소</button>
						<button type="button" class="btn btn-warning" onclick="window.location='boardList?pageNum=${pageNum}'">목록보기</button>
						</p></th>
					</tr>
				</table>
			</form>
		</body>	
	</c:if>
</div>
<div class="col-sm-2 sidenav">
</div>
</div>
</div>
	<jsp:include page="../menu/guestFooter.jsp" flush="false"/>