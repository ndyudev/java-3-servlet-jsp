<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<c:url var="link" value="/lab4/slider/uploadfile" />
	<form action="${link }" method="post" enctype="multipart/form-data">
		Chọn hình: <input type="file" name="file"><br> <br>
		<button>Upload</button>
	</form>
	Đường dẫn: ${path } Đường dẫn: ${path }
	<br>
	<img src="${pageContext.request.contextPath}/${path}" width="200">


</body>
</html>