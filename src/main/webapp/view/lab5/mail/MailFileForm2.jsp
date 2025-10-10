<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Send Mail With Attachment</title>
</head>
<body>
    <h2>Send Mail With Attachment</h2>
    <c:url value="send-mail-2" var="link"/>
    <form action="${link }" method="post" enctype="multipart/form-data">
        <label>From:</label><br>
        <input type="email" name="from" value="chauunhatduyyit@gmail.com" required><br><br>

        <label>To:</label><br>
        <input type="email" name="to" placeholder="Receiver email" required><br><br>

        <label>Subject:</label><br>
        <input type="text" name="subject" required><br><br>

        <label>Message:</label><br>
        <textarea name="body" rows="6" cols="40" required></textarea><br><br>

        <label>File Attachment:</label><br>
        <input type="file" name="file" required><br><br>

        <button type="submit">Send Mail</button>
    </form>
</body>
</html>
