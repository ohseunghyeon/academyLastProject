<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<head>
<script type="text/javascript">
	function confirmCheck() {
		if (!document.confirmForm.id.value) {
			alert(msg_id);
			document.confirmForm.id.focus();
			return false;
		}
	}
	function confirmFocus() {
		document.confirmForm.id.focus();
	}

	function setId(id) {
		opener.document.registerform.id.value = id;
		opener.document.registerform.confirmid.value = 1;
		self.close();
	}
</script>
</head>
<h2>중복확인 페이지</h2>
<!-- id 중복 -->
<c:if test="${result == 1}">
	<body onload="confirmFocus()">
		<form action="confirmId" method="post" name="confirmForm"
			onsubmit="return confirmCheck()">
			<table>
				<tr>
					<th colspan="2"><span>${id}</span>는 사용할 수 없습니다.</th>
				</tr>
				<tr>
					<th>아이디 :</th>
					<td><input type="text" class="input" name="id" maxlength="12">
					</td>
				</tr>
				<tr>
					<th colspan="2"><input type="submit" class="inputbutton"
						value="확인"> <input type="reset" class="inputbutton"
						value="취소" onclick="self.close()"></th>
				</tr>
			</table>
		</form>
	</body>
</c:if>
<!-- id 중복이 아닌 경우 -->

<c:if test="${result != 1}">
	<table>
		<tr>
			<td align="center"><span>${id}</span>는 사용할 수 있습니다.</td>
		</tr>
		<tr>
			<th><input type="button" class="inputbutton" value="확인"
				onclick="setId('${id}')"></th>
		</tr>
	</table>
</c:if>
</body>
</html>