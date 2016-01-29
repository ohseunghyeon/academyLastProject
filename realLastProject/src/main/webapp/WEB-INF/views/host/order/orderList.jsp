<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.sql.*"%>

<body>
	<form>
		<fieldset id="content">
			<legend>
				<font color="orange" size="6"><b>Order </b></font>
			</legend>
			<br>

			<fieldset>
				<legend>
					<font color="orange"><b>OrderList</b></font>
				</legend>

				<table id="payment" cellspacing="10" cellpadding="0">

					<tr>
						<th width="200" height="15">주문 번호</th>
						<th width="200" height="15">테이블 번호</th>
						<th width="200" height="15">주문내역</th>
					</tr>

					<c:forEach var="" items="" begin="0" end="">
						<font size="1">
							<tr>
								<td>1</td>
								<td>2</td>
								<td>아메리카노(2)<br> 치즈 케익(1) <input class="inputclass"
									type="checkbox"> <input type="button" value="확인"></td>
							</tr>
					</c:forEach>
					</font>
				</table>
			</fieldset>
		</fieldset>
	</form>
</body>
