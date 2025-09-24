<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Lab 3 Slider | Struct</title>
</head>
<body>
	<c:set var="x" value="53" />
	<c:if test="${x%2 ==0 }">{$x} chẳn</c:if>
	<c:if test="${x%2 !=0 }">{$x} lẻ</c:if>
	<br>

	<c:set var="age" value="34" />
	<c:choose>
		<c:when test="${age <=15 }">Thiếu Niên</c:when>
		<c:when test="${age <=45 }">Thanh Niên</c:when>
		<c:when test="${age <=60 }">Trung niên</c:when>
		<c:otherwise>Cao tuổi</c:otherwise>
	</c:choose>
	<br> Chon mùa:
	<select>
		<c:forTokens items="Xuan, Ha, Thu, Dong" delims="," var="mua">
			<option>${mua }</option>
		</c:forTokens>
	</select>

	<!-- Duyet Theo Chi So -->
	<c:forEach var="i" begin="5" end="10" step="1">
    ${i} - Hello <br>
	</c:forEach>


	<!-- Duyet theo danh sách -->
	<h3>Danh sách</h3>
	<ul>
		<c:forEach var="item" items="${list }">
			<li>${item }</li>
		</c:forEach>
	</ul>












</body>
</html>