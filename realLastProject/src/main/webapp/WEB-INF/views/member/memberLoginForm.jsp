<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="../menu/guestHeader.jsp" flush="false"/>
<title>로그인 재시도 화면</title>
</head>

<div class="container-fluid">
<form method="post" action="memberLoginPro">
		<tabel class="text-uppercase; text-danger">
		<h4><p class="text-center"><mark>로그인에 실패하였습니다.</mark></p></h4>
		<c:if test="${result != -1}">
		<h5><p class="text-center">아이디를 다시 확인하세요.</p></h5>
		</c:if>
		<c:if test="${result == -1}">
		<h5><p class="text-center">비밀번호를 다시 확인하세요.</p></h5>
		</c:if>
		</tabel>
 <div class="container-fluid">
		<div class="row">
 		<div class="col-sm-4" ></div>
 		 <div class="col-sm-4" ><br>
			<table class="table table-striped table-bordered table-hover table-condensed text-center bg-warning" >
				<tr>
					<th>ID</th>
					<td>
						<input class="input" type="text" name="id" maxlength="12">
					</td>
				<tr>
					<th>Password</th>
					<td>
						<input class="input" type="password" name="passwd" maxlength="10">
					</td>	
				</tr>
	
			</table>
			<div class="pull-right">
				<button type="submit" class="btn btn-warning">로그인</button>
				<button type="reset" class="btn btn-warning">취소</button>
			</div>
		<div class="col-sm-4" ></div>
		</div>
		</div>
	</form>
</div>