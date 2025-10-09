<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Send Mail</title>
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
	width: 420px;
	display: flex;
	flex-direction: column;
	gap: 15px;
}

h2 {
	text-align: center;
	color: #2563eb;
	margin-bottom: 10px;
}

input {
	padding: 5px;
}

button {
	background-color: #2563eb;
	color: #fff;
	padding: 10px;
	border: none;
	font-size: 15px;
	font-weight: 500;
	cursor: pointer;
}


.success {
	background: #dcfce7;
	color: #166534;
}

.error {
	background: #fee2e2;
	color: #991b1b;
}
</style>
</head>
<body>
	<c:url value="/lab5/mail/sendmailfile" var="mail" />
	<form action="${mail}" method="post" enctype="multipart/form-data">
		<h2>Send Mail</h2>

		<label>From:</label> <input type="email" name="from"
			value="chauunhatduyyit@gmail.com" required /> <label>To:</label> <input
			type="email" name="to" placeholder="recipient@example.com" required />

		<label>Subject:</label> <input type="text" name="subject"
			placeholder="Enter mail subject..." required /> <label>Body:</label>
		<textarea name="body" placeholder="Write your message here..."></textarea>

		<label>File:</label> <input type="file" name="file" />

		<button type="submit">Send</button>

		<div class="msg ${message.contains('error') ? 'error' : 'success'}">${message}</div>
	</form>
</body>
</html>
