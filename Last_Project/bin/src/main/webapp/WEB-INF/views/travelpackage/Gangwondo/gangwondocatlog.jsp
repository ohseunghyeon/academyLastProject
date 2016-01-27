<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link type="text/css" rel="stylesheet" href="resources/headerfooter.css">
<title>부산여행 목록</title>
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
<jsp:include page="../../headerFooter/header.jsp" flush="false" />
<table border = "3">
	<caption><font color ="blue"> <h4>강원도 여행 맞춤 패키지 목록</h4> </caption>
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
				<td></td>
				<td><a href="seungbokleejsp">이승복기념관</a></td>
				<td>가격(협의가능)</td>
		</tr>		
		<tr>
				<td><input class="input" type="checkbox"></td>
				<td>남이섬</td>
				<td>지역주소</td>
				<td>가격(협의가능)</td>
		</tr>		
		<tr>
				<td><input class="input" type="checkbox"></td>
				<td>설악산</td>
				<td>지역주소</td>
				<td>가격(협의가능)</td>
		</tr>
		<tr>
				<td><input class="input" type="checkbox"></td>
				<td>속초해수욕장</td>
				<td>지역주소</td>
				<td>가격(협의가능)</td>
		</tr>		
		<tr>
				<td><input class="input" type="checkbox"></td>
				<td>속초엑스포타워</td>
				<td>지역주소</td>
				<td>가격(협의가능)</td>
		</tr>		
		<tr>
				<td><input class="input" type="checkbox"></td>
				<td>주문진항</td>
				<td>지역주소</td>
				<td>가격(협의가능)</td>
		</tr>		
		<tr>
				<td><input class="input" type="checkbox"></td>
				<td>화진포해수욕장</td>
				<td>지역주소</td>
				<td>가격(협의가능)</td>
		</tr>		
		<tr>
				<td><input class="input" type="checkbox"></td>
				<td>정동진</td>
				<td>지역주소</td>
				<td>가격(협의가능)</td>
		</tr>		
		<tr>
				<td><input class="input" type="checkbox"></td>
				<td>낙산사</td>
				<td>지역주소</td>
				<td>가격(협의가능)</td>
		</tr>		
		<tr>
				<td><input class="input" type="checkbox"></td>
				<td>대포항</td>
				<td>지역주소</td>
				<td>가격(협의가능)</td>
		</tr>		
		<tr>
				<td><input class="input" type="checkbox"></td>
				<td>통일전망대</td>
				<td>지역주소</td>
				<td>가격(협의가능)</td>
		</tr>
		<tr>
				<td><input class="input" type="checkbox"></td>
				<td>낙산해수욕장</td>
				<td>지역주소</td>
				<td>가격(협의가능)</td>
		</tr>		
		<tr>
				<td><input class="input" type="checkbox"></td>
				<td>경포대해수욕장</td>
				<td>지역주소</td>
				<td>가격(협의가능)</td>
		</tr>		
		<tr>
				<td><input class="input" type="checkbox"></td>
				<td>영월고씨굴</td>
				<td>지역주소</td>
				<td>가격(협의가능)</td>
		</tr>				
		<tr>
				<td><input class="input" type="checkbox"></td>
				<td>DMZ박물관</td>
				<td>지역주소</td>
				<td>가격(협의가능)</td>
		</tr>		
		<tr>
		<td><input class="input" type="checkbox"></td>
				<td>대관령양떼목장</td>
				<td>지역주소</td>
				<td>가격(협의가능)</td>
		</tr>			
		<tr>
				<td><input class="input" type="checkbox"></td>
				<td>강원랜드</td>
				<td>지역주소</td>
				<td>가격(협의가능)</td>
		</tr>				
		<tr>
				<td><input class="input" type="checkbox"></td>
				<td>오죽헌</td>
				<td>지역주소</td>
				<td>가격(협의가능)</td>
		</tr>		
		<tr>
				<td><input class="input" type="checkbox"></td>
				<td>속초아바이마을</td>
				<td>지역주소</td>
				<td>가격(협의가능)</td>
		</tr>		
		<tr>
				<td><input class="input" type="checkbox"></td>
				<td>백담사</td>
				<td>지역주소</td>
				<td>가격(협의가능)</td>
		</tr>		
		<tr>
		<th colspan="4">
			<input class="inputbutton" type="submit" value="예약">
			<input class="inputbutton" type="button" value="취소" onclick="window.location='''">
		</th>
		</tr>
</table>
<jsp:include page="../../headerFooter/footer.jsp" flush="false" />
</body>
</html>