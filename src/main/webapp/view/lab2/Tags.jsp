<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Tags Form</title>
</head>
<body>
    <h2>Form nhập dữ liệu</h2>
    <form action="${pageContext.request.contextPath}/Lab2/Tags" method="post">
        <label>Name:</label>
        <input name="name" type="text"><br>
        <label>Age:</label>
        <input type="number" name="age"><br>
        <input type="submit" value="Submit">
    </form>

    <hr>
    <h3>Kết quả nhập:</h3>
    <p>Name: ${name}</p>
    <p>Age: ${age}</p>
</body>
</html>
