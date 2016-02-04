<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="../menu/guestHeader.jsp" flush="false"/>

<h3><p class="text-center">Modify</p></h3><br>

<div class="container-fluid text-center">    
  <div class="row content">
    <div class="col-sm-3 sidenav"></div>
    <div class="col-sm-6 text-left"> 
<form method="post" action="memberModifyPro">
	<table class="table table-striped table-bordered table-hover table-condensed text-center">
		<tr class="danger">
			<th colspan=2><p class="text-center"><small>회원 정보 수정 메뉴입니다. 수정할 정보를 입력하세요.</small></p></th>
		</tr>
		<tr class="warning">
			<th><p class="text-center">아이디</p></th>
			<td>${dto.id}</td>	
		</tr>
		<tr class="warning">
			<th><p class="text-center">비밀번호</p></th>
			<td><input placeholder="Enter password" type="password" name="passwd" class="form-control" value="${dto.passwd}" required /></td>
		</tr>
		<tr class="warning">
			<th><p class="text-center">전화번호</p></th>
			<td><input placeholder="Enter number" type="text" name="phone_number" class="form-control" 
			value="${dto.phone_number}"></td>
		</tr>
		<tr class="warning">
			<th><p class="text-center">이메일</p></th>
			<td><input placeholder="Enter email" type="text" name="email" class="form-control" value="${dto.email}"></td>
		</tr>	
		<tr class="warning">
			<th><p class="text-center">마일리지</p></th>
			<td>${dto.mileage}</td>
		</tr>
		<tr class="danger">
			<th colspan="3"><p class="text-center"> 
			<button type="submit" class="btn btn-warning">정보 수정</button>
			<button type="reset" class="btn btn-warning">초기화</button>
			<button type="button" class="btn btn-warning" onclick="window.location='seatList'">돌아가기</button>
			</p></th>		
	</table>
</form>
</div>
<div class="col-sm-3 sidenav"></div>
</div>
</div>
