<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Tính thuế</title>
</head>
<body>
	<form action="${pageContext.request.contextPath}/lab2/thue"
		method="post">
		<h2>Tính thuế</h2>
		Họ và tên: <input name="fullName" type="text"
			value="${param.fullName}"><br> Money: <input
			name="money" type="number" value="${param.tax }"><br> <input
			type="submit" value="Tính">
	</form>


	<p>Bạn: ${fullName}</p>
	<p>Thuế: ${tax}</p>

</body>
</html>
