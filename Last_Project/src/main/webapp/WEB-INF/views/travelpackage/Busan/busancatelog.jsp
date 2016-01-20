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
				<td>해동용궁사</td>
				<td>지역주소</td>
				<td>가격(협의가능)</td>
		</tr>		
		<tr>
				<td><input class="input" type="checkbox"></td>
				<td><a href="gwanganbridge">광안대교</a></td>
				<td>지역주소</td>
				<td>가격(협의가능)</td>
		</tr>		
		<tr>
				<td><input class="input" type="checkbox"></td>
				<td>광안리 해수욕장</td>
				<td>지역주소</td>
				<td>가격(협의가능)</td>
		</tr>
		<tr>
				<td><input class="input" type="checkbox"></td>
				<td>부산 아쿠아리움</td>
				<td>지역주소</td>
				<td>가격(협의가능)</td>
		</tr>		
		<tr>
				<td><input class="input" type="checkbox"></td>
				<td>허심청</td>
				<td>지역주소</td>
				<td>가격(협의가능)</td>
		</tr>		
		<tr>
				<td><input class="input" type="checkbox"></td>
				<td>벡스코</td>
				<td>지역주소</td>
				<td>가격(협의가능)</td>
		</tr>		
		<tr>
				<td><input class="input" type="checkbox"></td>
				<td>부산자갈치시장</td>
				<td>지역주소</td>
				<td>가격(협의가능)</td>
		</tr>		
		<tr>
				<td><input class="input" type="checkbox"></td>
				<td>달맞이길</td>
				<td>지역주소</td>
				<td>가격(협의가능)</td>
		</tr>		
		<tr>
				<td><input class="input" type="checkbox"></td>
				<td>부산 시립 박물관</td>
				<td>지역주소</td>
				<td>가격(협의가능)</td>
		</tr>		
		<tr>
				<td><input class="input" type="checkbox"></td>
				<td>해운대 해수욕장</td>
				<td>지역주소</td>
				<td>가격(협의가능)</td>
		</tr>		
		<tr>
				<td><input class="input" type="checkbox"></td>
				<td>태종대</td>
				<td>지역주소</td>
				<td>가격(협의가능)</td>
		</tr>
		<tr>
				<td><input class="input" type="checkbox"></td>
				<td>용두산 공원</td>
				<td>지역주소</td>
				<td>가격(협의가능)</td>
		</tr>		
		<tr>
				<td><input class="input" type="checkbox"></td>
				<td>국립 해양 박물관</td>
				<td>지역주소</td>
				<td>가격(협의가능)</td>
		</tr>		
		<tr>
				<td><input class="input" type="checkbox"></td>
				<td>가덕도</td>
				<td>지역주소</td>
				<td>가격(협의가능)</td>
		</tr>				
		<tr>
				<td><input class="input" type="checkbox"></td>
				<td>범어사</td>
				<td>지역주소</td>
				<td>가격(협의가능)</td>
		</tr>		
		<tr>
		<td><input class="input" type="checkbox"></td>
				<td>오륙도</td>
				<td>지역주소</td>
				<td>가격(협의가능)</td>
		</tr>			
		<tr>
				<td><input class="input" type="checkbox"></td>
				<td>국제시장</td>
				<td>지역주소</td>
				<td>가격(협의가능)</td>
		</tr>				
		<tr>
				<td><input class="input" type="checkbox"></td>
				<td>깡통시장</td>
				<td>지역주소</td>
				<td>가격(협의가능)</td>
		</tr>		
		<tr>
				<td><input class="input" type="checkbox"></td>
				<td>비프광장</td>
				<td>지역주소</td>
				<td>가격(협의가능)</td>
		</tr>		
		<tr>
				<td><input class="input" type="checkbox"></td>
				<td>헌책방 거리</td>
				<td>지역주소</td>
				<td>가격(협의가능)</td>
		</tr>		
		<tr>
		<th colspan="4">
			<input class="inputbutton" type="submit" value="예약"onclick="window.location='busanpackagecheck'">
			<input class="inputbutton" type="button" value="취소" onclick="window.location='''">
		</th>
		</tr>
</table>
<jsp:include page="../../headerFooter/footer.jsp" flush="false" />
</body>
</html>