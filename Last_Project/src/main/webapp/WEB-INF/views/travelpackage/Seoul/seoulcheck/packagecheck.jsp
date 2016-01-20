<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link type="text/css" rel="stylesheet" href="resources/headerfooter.css">
<title>Insert title here</title>
<style type="text/css">

		thead {
					background-color : pink;
				}
		td {
					text-align:center;
					background-color : #FFFFD2;
			}
		border-style:ridge;

</style>
</head>
<body>
<jsp:include page="../../../headerFooter/header.jsp" flush="false" />

<table border = "3">
	<caption><font color ="blue"> <h4>부산 여행 맞춤 패키지 목록</h4> </caption>
	<thead>
		<tr>
				<th>선택</th>
				<th>관광지이름</th>
				<th>지역주소</th>
				<th>가격(협의가능)</th>
		</tr>
	</thead>		
		<tr>
				<td><input class="input" type="checkbox"></td>
				<td>경복궁</td>
				<td>지역주소</td>
				<td>가격(협의가능)</td>
		</tr>		
		<tr>
				<td><input class="input" type="checkbox"></td>
				<td>롯데월드</td>
				<td>지역주소</td>
				<td>가격(협의가능)</td>
		</tr>		
		<tr>
				<td><input class="input" type="checkbox"></td>
				<td>코엑스</td>
				<td>지역주소</td>
				<td>가격(협의가능)</td>
		</tr>
		<tr>
				<td><input class="input" type="checkbox"></td>
				<td>가로수길</td>
				<td>지역주소</td>
				<td>가격(협의가능)</td>
		</tr>		
		<tr>
				<td><input class="input" type="checkbox"></td>
				<td>청계천</td>
				<td>지역주소</td>
				<td>가격(협의가능)</td>
		</tr>		
		<tr>
				<td><input class="input" type="checkbox"></td>
				<td><a href="namsan">남산</a></td>
				<td>지역주소</td>
				<td>가격(협의가능)</td>
		</tr>		
		<tr>
		<th colspan="4">
			<input class="inputbutton" type="submit" value="최종예약">
			<input class="inputbutton" type="button" value="수정" onclick="window.location='seoulcatalog'">
		</th>
		</tr>
</table>

<jsp:include page="../../../headerFooter/footer.jsp" flush="false" />
</body>
</html>