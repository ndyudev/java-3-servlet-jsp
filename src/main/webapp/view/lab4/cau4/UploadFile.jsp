<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Upload File</title>
</head>
<body>
    <h2>Upload File Demo</h2>

    <c:url var="uploadfile" value="/lab4/cau4/uploadfile" />
    <form action="${uploadfile}" method="post" enctype="multipart/form-data">
        <input type="file" name="photo" required>
        <button type="submit">Upload</button>
    </form>

    <hr/>
    <c:if test="${not empty filename}">
        <p><b>Ảnh vừa upload:</b></p>
        <!-- Dùng URL hoàn chỉnh -->
        <img src="${fileUrl}" width="300"/>

        <p><b>Đường dẫn vật lý:</b> ${path}</p>
    </c:if>
</body>
</html>
