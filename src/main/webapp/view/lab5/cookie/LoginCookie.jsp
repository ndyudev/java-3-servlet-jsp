<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login Page 🍪</title>
<style>
body {
	font-family: "Poppins", sans-serif;
	background: linear-gradient(135deg, #dbeafe, #f0f9ff);
	display: flex;
	justify-content: center;
	align-items: center;
	height: 100vh;
	margin: 0;
}

form {
	background: white;
	padding: 35px 40px;
	width: 340px;
	display: flex;
	flex-direction: column;
	gap: 12px;
}

h2 {
	text-align: center;
	margin-bottom: 10px;
	color: #1e3a8a;
	font-weight: 600;
}

label {
	font-weight: 500;
	color: #374151;
	margin-top: 10px;
}

input[type="text"], input[type="password"] {
	width: 100%;
	padding: 10px 0px 10px 0px;
	border: 1px solid #d1d5db;
	font-size: 14px;
	outline: none;
}

input:focus {
	border-color: #2563eb;
}

input[type="checkbox"] {
	margin-right: 6px;
	accent-color: #2563eb;
}

button {
	display: block;
	width: 100%;
	padding: 12px;
	background: linear-gradient(90deg, #3b82f6, #2563eb);
	color: white;
	border: none;
	font-size: 16px;
	font-weight: 600;
	cursor: pointer;
	margin-top: 8px;
}

.msg {
	text-align: center;
	margin-top: 15px;
	color: #e03131;
	font-weight: 500;
	font-size: 14px;
}
</style>
</head>
<body>
	<form action="${pageContext.request.contextPath}/lab5/login/cookie"
		method="post">
		<h2>Cookie Login</h2>

		<label>Username</label> <input type="text" name="username"
			value="${username}" placeholder="Enter username"> <label>Password</label>
		<input type="password" name="password" value="${password}"
			placeholder="Enter password"> <label
			style="display: flex; align-items: center; font-size: 14px;">
			<input type="checkbox" name="remember-me"> Remember me
		</label>

		<button type="submit">Login</button>

		<div class="msg">${message}</div>
	</form>
</body>
</html>
