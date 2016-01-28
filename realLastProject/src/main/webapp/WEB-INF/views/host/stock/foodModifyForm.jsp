<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<title>디저트 재고 수량 수정 페이지</title>
</head>

<h2>디저트 재고 수량 수정 페이지</h2>
<body>
	<form action="foodModifyPro" method="post">
		<table>
			<tr>
				<th colspan="2">수정정보를 입력하세요.</th>
			</tr>
			<tr>
				<th>재고수량</th>
				<td>
					<input type="hidden" name="food_code" value="${param.food_code}">
					<input class="input" type="number" name="food_num" min="0" max="999" value="${param.food_num}">
				</td>
			</tr>
			<tr>
				<th colspan="2">
					<input class="inputbutton" type="submit" value="수정확인">
					<input class="inputbutton" type="button" value="수정취소" 
						onclick="window.location='ingredient'">
				</th>
			</tr>
		</table>
	</form>
</body>

</html>