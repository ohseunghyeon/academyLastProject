<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link type="text/css" rel="stylesheet" href="resources/headerfooter.css">
<title>날씨정보</title>
</head>
<body>
<jsp:include page="../headerFooter/header.jsp" flush="false" />
<form>
	<table>	
	<tr>
		<th>현재 날씨와 단기간의 날씨 예보를 알려 드립니다.</th>
	</tr>
	<tr>	
		<td><h4>현재 날씨 정보</h4>
		<a href= "http://www.kma.go.kr/weather/main-now-weather.jsp?myPointCode=4211070500"><img src="http://cfile22.uf.tistory.com/image/2337B73752FDE0E816CBD9" alt="현재 날씨 정보" title="누르면 현재 날씨 정보로 이동합니다."></a></td>
		<td><h4>오늘/내일 예보</h4>
		<a href= "http://www.kma.go.kr/weather/main-forecast.jsp?myPointCode=1144060000#"><img src="http://png.clipart.me/previews/6e8/weather-icon-psd-45670.jpg" alt="오늘/내일 날씨 예보" title="누르면 오늘/내일 예보로 이동합니다."></a></td>
	</tr>
	</table>	
	
	
<jsp:include page="../headerFooter/footer.jsp" flush="false" />
</form>
</body>
</html>