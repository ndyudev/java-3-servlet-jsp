<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Lab 2 | Cau 2</title>
</head>
<body>
	<div style="color: red; display:flex; align-items: center; justify-content: center;">
		<h3>${message}</h3>
		<jsp:include page="/view/lab2/user-info.jsp" />
	</div>
</body>
</html>