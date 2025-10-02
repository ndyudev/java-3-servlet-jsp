<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Bài 1 - Lab 4</title>
<style>
  body {
    display: flex;
    justify-content: center;
    align-items: center;
    height: 100vh;
    margin: 0;
    font-family: Arial, sans-serif;
    background: #f5f6fa;
  }

  form {
    padding: 30px 40px;
    border-radius: 10px;
    width: 300px;
  }

  form h2 {
    text-align: center;
    margin-bottom: 20px;
    color: #333;
  }

  label {
    display: block;
    margin-bottom: 6px;
    font-weight: bold;
    color: #444;
  }

  .message {
    margin-top: 10px;
    text-align: center;
    color: red;
    font-weight: bold;
  }
  
  input {
  	margin-bottom: 6px;
  }
  
</style>
</head>
<body>
  <c:url value="/lab4/cau1/account/login" var="url" />
  <form action="${url}" method="post">
    <h2>Login</h2>
    <label>Username:</label>
    <input name="username" type="text" />
    <label>Password:</label>
    <input name="password" type="password" />
    <br>
    <input type="submit" value="Login" />
    <p class="message">${message}</p>
  </form>
</body>
</html>
