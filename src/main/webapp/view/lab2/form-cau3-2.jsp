<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form
		action="${pageContext.request.contextPath}/lab2/cau4/form/update2"
		method="post">

		<div>Fullname:</div>
		<input name="fullname" value="${user.fullname}" ${editabled ? "" : "readonly"}>
		<div>Gender:</div>
		<input type="radio" name="gender" value="true" checked> Male<br>
		<input type="radio" name="gender" value="false"> Female<br>
		<div>Country:</div>
		<select name="country">
			<option value="VN" selected>Việt Nam</option>
			<option value="US">United States</option>
			<option value="CN">China</option>
		</select>
		<hr>
		<button disabled>Create</button>
		<button>Update</button>
	</form>
</body>
</html>