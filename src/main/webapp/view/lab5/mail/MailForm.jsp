<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Send Mail 💌</title>
<style>
    body {
        font-family: 'Poppins', sans-serif;
        background: linear-gradient(135deg, #dbeafe, #f0f9ff);
        display: flex;
        justify-content: center;
        align-items: center;
        height: 100vh;
        margin: 0;
    }
    form {
        background: #fff;
        padding: 30px 40px;
        width: 400px;
        display: flex;
        flex-direction: column;
    }
    h2 {
        text-align: center;
        color: #2563eb;
        margin-bottom: 20px;
    }
    input, textarea {
        margin-bottom: 15px;
        padding: 10px 12px;
        border: 1px solid #ccc;
        font-size: 15px;
        outline: none;
        transition: 0.2s;
    }
    textarea {
        resize: none;
        height: 100px;
    }
    button {
        background: #2563eb;
        color: white;
        border: none;
        padding: 10px;
        font-size: 16px;
        cursor: pointer;
        transition: 0.2s;
    }
    .msg {
        text-align: center;
        margin-top: 15px;
        font-weight: 500;
    }
    .success {
        color: #16a34a;
    }
    .error {
        color: #dc2626;
    }
</style>
</head>
<body>
    <c:url value="/lab5/mail/sendmail" var="mail"/>
    <form action="${mail}" method="post"> 
        <h2>Send Mail</h2>
        <label>From:</label>
        <input name="from" value="chauunhatduyyit@gmail.com" required />
        
        <label>To:</label>
        <input name="to" placeholder="recipient@example.com" required />
        
        <label>Subject:</label>
        <input name="subject" placeholder="Enter mail subject..." required />
        
        <label>Body:</label>
        <textarea name="body" placeholder="Write your message here..."></textarea>
        
        <button type="submit">Send</button>
        <div class="msg ${message.contains('error') ? 'error' : 'success'}">${message}</div>
    </form>
</body>
</html>
