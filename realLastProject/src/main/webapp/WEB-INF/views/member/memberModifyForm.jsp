<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:include page="../menu/guestHeader.jsp" flush="false"/>

<div class="container-fluid">
	<form method="post" action="memberModifyView">
		<dl>
		<dt class="text-center"><h4><p class="text-danger">확인을 위해 비밀번호를 다시 입력해 주세요.</p></h4></dt>
		</dl>
	<div class="row">
 		<div class="col-sm-4" ></div>
 		 <div class="col-sm-4" ><br>
		<table class="table table-bordered table-hover table-condensed text-center bg-success" >
			<tr>
				<th>Password</th>
					<td>
						<input class="input" type="password" name="passwd" maxlength="10">
					</td>	
				</tr>
	
		</table>
			<div class="pull-right">
				<button type="submit" class="btn btn-warning">로그인</button>
				<button type="button" class="btn btn-warning" onclick="window.location='seatList'">돌아가기</button>
			</div>
		</div>
		<div class="col-sm-4" ></div>
	</div>
	</form>	
</div>

