<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link type="text/css" rel="stylesheet" href="./resources/headerfooter.css">
<link type="text/css" rel="stylesheet" href="./resources/board.css">
</head>
<body>
<jsp:include page="../headerFooter/header.jsp" flush="false" />

<div class="questionBoard">
<fieldset>
	<legend>공지사항</legend>
	<table>
		<colgroup>
			<col width="5%"/>
			<col width="*"/>
			<col width="10%"/>
			<col width="10%"/>
			<col width="7%"/>
		</colgroup>
		<thead>
			<tr>
				<th colspan="2">제목</th>
				<th>작성자</th>
				<th>작성일</th>
				<th>조회</th>
			</tr>
		</thead>
		<tbody>
			<tr>
				<td>4</td>
				<td>모르게따</td>
				<td>나</td>
				<td>2016.1.19</td>
				<td>2</td>
			</tr>
			<tr>
				<td>3</td>
				<td>아 어쩌지</td>
				<td>나</td>
				<td>2016.1.19</td>
				<td>1</td>
			</tr>
			<tr>
				<td>2</td>
				<td>여행사</td>
				<td>나</td>
				<td>2016.1.19</td>
				<td>2</td>
			</tr>
			<tr>
				<td>1</td>
				<td>프로젝트</td>
				<td>나</td>
				<td>2016.1.19</td>
				<td>2</td>
			</tr>
		</tbody>
	</table>
</fieldset>
</div>

<jsp:include page="../headerFooter/footer.jsp" flush="false" />
</body>
</html>