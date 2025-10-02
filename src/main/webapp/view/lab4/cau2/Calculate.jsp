<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Lab 4 | Cau 2</title>
</head>
<style>
body {
	justify-content: center;
	align-items: center;
	height: 100vh;
	display: flex;
}

form {
	border: 1px black solid;
	padding: 20px;
	border-radius: 5px;
}
input {
	margin: 6px;
}
button {
	padding: 5px;
}
</style>
<body>
	<c:url value="/lab4/cau1/calculate" var="calculate" />
	<form action="calculate" method="post">
		<h2>Máy tính Cộng và trừ</h2>s
		<input name="a"> <br> <input name="b"><br>
		<button formaction="${calculate }/add">+</button>
		<button formaction="${calculate }/sub">-</button>
		<br>
		<p>Kết quả: ${message }</p>
	</form>
</body>
</html>