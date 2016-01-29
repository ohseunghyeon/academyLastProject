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
				</table>
					
					<tr>
					<td>
						<c:forEach var="holDtoArray" items="${holDtoArray}">
							
							${holDtoArray.order_id}
						 	${holDtoArray.seat_num}
							${holDtoArray.food_name}
							<input type="submit" value="확인">
							<br>
						 	
						</c:forEach>
					</td>
					</tr>
				
					
				
			</fieldset>
		</fieldset>
		
		
		
		
	
	
		
	</form>
</body>
	