<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Staff Form</title>
</head>
<body>
    <h2>Staff Form</h2>
    <form action="${pageContext.request.contextPath}/lab5/slider/staff" method="post">
        Full Name: <input type="text" name="fullName"><br><br>
        Age: <input type="number" name="age"><br><br>
        Gender:
        <input type="radio" name="gender" value="true"> Male
        <input type="radio" name="gender" value="false"> Female <br><br>
        Salary: <input type="number" step="0.01" name="salary"><br><br>
        Country: <input type="text" name="country"><br><br>
        Photo: <input type="text" name="photo"><br><br>
        Hobbies:
        <input type="checkbox" name="hobbies" value="1"> Reading
        <input type="checkbox" name="hobbies" value="2"> Music
        <input type="checkbox" name="hobbies" value="3"> Sports <br><br>
        Recruit Date: <input type="date" name="recruit"><br><br>
        <button type="submit">Submit</button>
    </form>
</body>
</html>
