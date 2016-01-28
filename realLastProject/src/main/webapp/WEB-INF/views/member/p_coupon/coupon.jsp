<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<title>Insert title here</title>
</head>
<body>

 <table border="1">
	<strong>coupon</strong> <br>
	<tr>
	<th>coupon</th>
	<th> 쿠폰 사용기간</th>
	</tr>
	<tr>
	<td>
	<img src="/lastproject/resources/images/coupon.jpg" width =500px height=250px>
	</td>
	<td>${coupon_code}</td>
	<td> 2016.01.01 ~ 2016.08.30</td>
	</tr>
	
	<tr>
	<td colspan="2">
		 <input class="inputbutton" type="button" value="사용하기" 
		 		onclick="window.location='payment.html'"> </td>
		 		
	</tr>
	</table>
</body>
