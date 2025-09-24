<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Lab 2 | Cau 2</title>
</head>
<body>
	<b>Thông tin cá nhân:</b>
	<ul style="list-style: none;">
		<li>Họ và tên: ${user.fullname}</li>
		<li>Giới tính: ${user.gender}</li>
		<li>Quốc tịch: ${user.country}</li>
	</ul>
</body>
</html>