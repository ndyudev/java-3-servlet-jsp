<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Staff Info | Bean Ultil</title>
</head>
<body>
    <h2>Staff Info</h2>
    <p>Full Name: ${staff.fullName}</p>
    <p>Age: ${staff.age}</p>
    <p>
        Gender:
        <c:choose>
            <c:when test="${staff.gender}">Male</c:when>
            <c:otherwise>Female</c:otherwise>
        </c:choose>
    </p>
    <p>Salary: ${staff.salary}</p>
    <p>Country: ${staff.country}</p>
    <p>Photo: ${staff.photo}</p>
    <p>Recruit Date: ${staff.recruit}</p>
    <p>
        Hobbies:
        <c:forEach var="h" items="${staff.hobbies}">
            ${h}
        </c:forEach>
    </p>
</body>
</html>
