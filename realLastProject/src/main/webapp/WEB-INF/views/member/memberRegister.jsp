<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:include page="../menu/guestHeader.jsp" flush="false"/>

<style>
 th {
 width:200px;
 }
</style>


<h3><p class="text-center">Register</p></h3>
<div class="container-fluid text-center">    
  <div class="row content">
    <div class="col-sm-2 sidenav">
    </div>
    <div class="col-sm-8 text-left"> 

<form method="post" action="memberRegisterPro">
	<table class="table table-striped table-bordered table-hover table-condensed text-center">
		<tr class="danger">
			<th colspan=2><p class="text-center"><mark>회원 가입 메뉴입니다. 아래에 정보를 입력하세요.</mark></p></th>
		<tr>
		<tr class="warning">
			<th><h4><p class="text-center">ID</p></h4></th>
			<td><input class="form-control" type="text" name="id" placeholder="Enter id"></td>	
		</tr>
		<tr class="info">
			<th><h4><p class="text-center">Password</p></h4></th>
			<td><input class="form-control"type="password" name="passwd" placeholder="Enter password"></td>
		</tr>
		<tr class="warning">
			<th><h4><p class="text-center">Phone Number</p></h4></th>
			<td><input class="form-control" type="text" name="phone_number" placeholder="Enter number"></td>
		</tr>
		<tr class="info">
			<th><h4><p class="text-center">Email</p></h4></th>
			<td><input class="form-control" type="text" name="email" placeholder="Enter email"></td>
		</tr>	
		<tr class="danger">
			<th colspan="3"><p class="text-center">
			<button type="submit" class="btn btn-warning">회원가입</button>
			<button type="reset" class="btn btn-warning">초기화</button>
			<button type="button" class="btn btn-warning" onclick="window.location='index'">돌아가기</button>
			</p></th>		
	</table>

</form>
</div>
</div>
</div>