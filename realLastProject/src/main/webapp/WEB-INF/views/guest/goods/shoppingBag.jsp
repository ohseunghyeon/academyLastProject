<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div id=${foodDto.food_code}"><tr><td><input type="hidden" name="food_code" value="${foodDto.food_code}">${foodDto.food_name}</td>
<td>수량 : <input type="number" name="food_num" value="1"></td></tr></div>