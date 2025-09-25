<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Lab 3 | Cau 1</title>
</head>
<body>
	<style>
		.container {
			display: flex;
			justify-content: center;
			align-items: center;
			height: 100vh;
		}
	</style>
	<div class="container">
		<h2>Chọn thành phố của bạn:</h2>
		<select name="country">
			<c:forEach var="country" items="${country }">
				<option value="${country.id }">${country.name }</option>
			</c:forEach>
		</select>
	</div>
</body>
</html>