<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
<script
	src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
<style>
#well {
background:#D2D2FF;
}
</style>



<title>ID/Password</title>
<br><br><br><br><br><br><br><br>
<div class="container-fluid">
<div class="row">
<div class="col-sm-4"></div>
<div class="col-sm-4">
 <div class="well well-lg" id="well">
<c:set var="member" value="${dto}"/>
<c:if test="${result == 1}">
	<c:if test="${idorpass != 1}">
	 <p class="text-center"> 당신의 아이디는 <mark>${member.id}</mark>입니다.
	<button type="button" class="btn btn-warning" onclick="window.location='index'">확인</button>
	</c:if>
	<c:if test="${idorpass == 1}">
	당신의 비밀번호는 ${member.passwd}입니다.
	<button type="button" class="btn btn-warning" onclick="window.location='index'">확인</button>
	</c:if>
</c:if>
<c:if test="${result == -1}">
	<script type="text/javascript">
		alert("입력하신 정보가 맞지 않습니다. 다시 입력하세요.");
	</script>
	<c:redirect url="memberFindForm" />
</c:if>
<c:if test="${result == 0}">
	<script type="text/javascript">
		alert("처리 오류가 발생했습니다. 다시 시도하세요.");
	</script>
	<c:redirect url="memberFindForm" />
</c:if>
</div>
</div>
<div class="col-sm-4"></div>
</div>
</div>