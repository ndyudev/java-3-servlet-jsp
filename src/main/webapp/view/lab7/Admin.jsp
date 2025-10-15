<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Admin</title>

<style>
* {
	box-sizing: border-box;
	font-family: Arial, sans-serif;
	margin: 0;
	padding: 0;
}

body {
	background: #f5f5f5;
	color: #333;
}

.container {
	width: 100%;
	max-width: 1200px;
	margin: auto;
}

header {
	display: flex;
	align-items: center;
	justify-content: space-between;
	background: #17a2b8;
	color: white;
	padding: 15px 20px;
}

header h1 {
	font-size: 24px;
}

header .user {
	font-weight: bold;
}

nav {
	background: #ffc107;
	text-align: center;
	padding: 10px 0;
}

nav a {
	text-decoration: none;
	color: #000;
	font-weight: bold;
	margin: 0 15px;
	transition: 0.2s;
}

nav a:hover {
	color: #fff;
}

main {
	background: #fff;
	min-height: 500px;
	margin: 20px auto;
	padding: 20px;
	border-radius: 8px;
	box-shadow: 0 2px 5px rgba(0, 0, 0, 0.1);
}

footer {
	background: #17a2b8;
	color: white;
	text-align: center;
	padding: 15px;
	margin-top: 20px;
}
</style>
</head>
<body>

	<div class="container">
		<header>
			<div class="logo">Logo</div>
			<h1>Trang Quản Trị</h1>
			<div class="user">${user.fullname}</div>
		</header>

		<nav>
			<a href="${pageContext.request.contextPath}/department/index">Department</a>
			<a href="${pageContext.request.contextPath}/employee/index">Employees</a>

		</nav>

		<main>
			<jsp:include page="${page}" />
		</main>

		<footer>
			<p>© 2025 - Admin Panel</p>
		</footer>
	</div>

</body>
</html>
