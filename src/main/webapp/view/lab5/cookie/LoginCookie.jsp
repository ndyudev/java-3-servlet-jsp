<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login Page 🍪</title>
<style>
    body {
        font-family: "Poppins", sans-serif;
        background: #f7f8fc;
        display: flex;
        justify-content: center;
        align-items: center;
        height: 100vh;
    }
    form {
        background: white;
        padding: 30px 40px;
        border-radius: 16px;
        box-shadow: 0 4px 20px rgba(0,0,0,0.1);
        width: 320px;
    }
    h2 {
        text-align: center;
        margin-bottom: 20px;
    }
    input[type="text"],
    input[type="password"] {
        width: 100%;
        padding: 10px;
        margin-bottom: 15px;
        border: 1px solid #ddd;
        border-radius: 8px;
    }
    input[type="checkbox"] {
        margin-right: 5px;
    }
    button {
        width: 100%;
        padding: 10px;
        background: #4c6ef5;
        color: white;
        border: none;
        border-radius: 8px;
        cursor: pointer;
        font-size: 16px;
    }
    button:hover {
        background: #3b5bdb;
    }
    .msg {
        text-align: center;
        margin-top: 10px;
        color: #e03131;
        font-weight: 500;
    }
</style>
</head>
<body>
    <form action="${pageContext.request.contextPath}/lab5/login/cookie" method="post">
        <h2>🍪 Cookie Login</h2>

        <label>Username</label>
        <input type="text" name="username" value="${username}" placeholder="Enter username">

        <label>Password</label>
        <input type="password" name="password" value="${password}" placeholder="Enter password">

        <label>
            <input type="checkbox" name="remember-me"> Remember me
        </label>

        <button type="submit">Login</button>

        <div class="msg">${message}</div>
    </form>
</body>
</html>
