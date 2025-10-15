<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Employee Management</title>
<style>
    body {
        font-family: "Poppins", sans-serif;
        background: #f5f7fa;
        margin: 20px;
    }
    h3 {
        color: #333;
        text-align: center;
    }
    form {
        background: white;
        border-radius: 12px;
        box-shadow: 0 2px 10px rgba(0,0,0,0.1);
        padding: 20px;
        width: 60%;
        margin: 0 auto 30px auto;
    }
    label {
        font-weight: 500;
        color: #444;
    }
    input[type="text"], input[type="password"], input[type="file"], select {
        width: 100%;
        padding: 8px;
        border: 1px solid #ccc;
        border-radius: 8px;
        margin: 5px 0 15px 0;
    }
    input[type="radio"] {
        margin-right: 5px;
    }
    button {
        background-color: #007bff;
        border: none;
        color: white;
        padding: 8px 14px;
        border-radius: 6px;
        cursor: pointer;
        margin-right: 6px;
    }
    button:hover { background-color: #0056b3; }
    table {
        border-collapse: collapse;
        width: 90%;
        margin: 0 auto;
        background: white;
        box-shadow: 0 2px 8px rgba(0,0,0,0.1);
    }
    th, td {
        border: 1px solid #ccc;
        text-align: center;
        padding: 10px;
    }
    th { background: #007bff; color: white; }
    tr:nth-child(even) { background: #f2f2f2; }
    a { color: #007bff; text-decoration: none; }
    a:hover { text-decoration: underline; }
    img {
        border-radius: 8px;
        border: 1px solid #ddd;
        margin-bottom: 10px;
    }
</style>
</head>
<body>
    <c:url value="/employee" var="path"/>

    <form action="${path}/upload" method="post" enctype="multipart/form-data">
        <h3>Employee Form</h3>
        <div style="text-align:center">
            <img src="${pageContext.request.contextPath}/images1/${item.photo}" 
                 style="width:90px;height:90px;object-fit:cover;" />
        </div>

        <label>ID:</label>
        <input name="id" type="text" value="${item.id}" />

        <label>Full Name:</label>
        <input name="fullname" type="text" value="${item.fullname}" />

        <label>Password:</label>
        <input name="password" type="password" value="${item.password}" />

        <fmt:formatDate var="bd" value="${item.birthday}" pattern="dd-MM-yyyy" />
        <label>Birthday:</label>
        <input name="birthday" type="text" value="${bd}" placeholder="dd-MM-yyyy" />

        <label>Gender:</label><br>
        <input type="radio" name="gender" value="true" ${item.gender=='true'?'checked':''}> Male
        <input type="radio" name="gender" value="false" ${item.gender=='false'?'checked':''}> Female
        <br><br>

        <label>Department:</label>
        <select name="departmentid">
            <c:forEach var="dp" items="${listDepartments}">
                <option value="${dp.id}" ${dp.id.equals(item.departmentid)?'selected':''}>${dp.name}</option>
            </c:forEach>
        </select>

        <label>Salary:</label>
        <input name="salary" type="text" value="${item.salary}" />

        <label>Photo:</label>
        <input type="file" name="photo" onchange="this.form.submit()" />

        <div style="text-align:center; margin-top:15px;">
            <button formaction="${path}/create">Create</button>
            <button formaction="${path}/update">Update</button>
            <button formaction="${path}/delete" style="background:#dc3545;">Delete</button>
            <button formaction="${path}/reset" style="background:#6c757d;">Reset</button>
        </div>
    </form>

    <table>
        <thead>
            <tr>
                <th>No.</th>
                <th>ID</th>
                <th>Full Name</th>
                <th>Password</th>
                <th>Gender</th>
                <th>Birthday</th>
                <th>Salary</th>
                <th>Photo</th>
                <th>Department</th>
                <th>Action</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="employee" items="${list}" varStatus="vs">
                <tr>
                    <td>${vs.count}</td>
                    <td>${employee.id}</td>
                    <td>${employee.fullname}</td>
                    <td>${employee.password}</td>
                    <td>
                        <c:choose>
                            <c:when test="${employee.gender == true}">Male</c:when>
                            <c:otherwise>Female</c:otherwise>
                        </c:choose>
                    </td>
                    <td><fmt:formatDate value="${employee.birthday}" pattern="dd-MM-yyyy"/></td>
                    <td>${employee.salary}</td>
                    <td>
                        <img src="${pageContext.request.contextPath}/images1/${employee.photo}" 
                             style="width:60px;height:60px;object-fit:cover;"/>
                    </td>
                    <td>${employee.departmentid}</td>
                    <td><a href="${path}/edit/${employee.id}">Edit</a></td>
                </tr>
            </c:forEach>
        </tbody>
    </table>

    <p style="text-align:center;color:#007bff;">${message}</p>
</body>
</html>