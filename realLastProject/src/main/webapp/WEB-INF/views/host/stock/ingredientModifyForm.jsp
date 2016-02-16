<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<jsp:include page="../../menu/hostHeader.jsp" flush="false" />


<h2><p class="text-center">Drink Modify</p></h2>

<div class="container-fluid text-center">    
  <div class="row content">
    <div class="col-sm-4 sidenav">
    </div>
    <div class="col-sm-4 text-left"> 
	<form action="ingredientModifyPro" method="post">
		<table class="table table-striped table-bordered table-hover table-condensed text-center" >
			<tr class="info">
				<th colspan="2"><h4><p class="text-center">수정 정보를 입력하세요.</p></h4></th>
			</tr>
			<tr>
				<th><h4><p class="text-center">재고수량</p></h4></th>
				<td>
					<h4><input type="hidden" name="ingredient_code" value="${param.ingredient_code}"></h4>
				<h4><input class="input" type="number" name="ingre_num" min="0" max="999" value="${param.ingre_num}" required /></h4>
				</td>
			</tr>
			<tr class="info">
				<th colspan="2">
				<h4><p class="text-center">
				<button type="submit" class="btn btn-warning">수정확인
				</button>
				<button type="button" class="btn btn-warning" onclick="window.location='ingredient'">수정취소
				</button>
				</p></h4>
				</th>
			</tr>
		</table>
	</form>
</div>
</div>
</div>
<jsp:include page="../../menu/hostFooter.jsp" flush="false" />