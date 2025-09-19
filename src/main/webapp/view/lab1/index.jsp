<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Home Page - Lab 1</title>
</head>
<body>
    <h2>Xin chào, ${username} 👋</h2>
    <p>${message}</p>

    <hr>
    <h3>Thông tin từ request</h3>
    <ul>
        <li>Context Path: ${pageContext.request.contextPath}</li>
        <li>Request URI: ${pageContext.request.requestURI}</li>
        <li>Servlet Path: ${pageContext.request.servletPath}</li>
    </ul>
</body>
</html>
