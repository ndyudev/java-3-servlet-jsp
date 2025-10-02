<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Lab 4 | Cau 3 Sign up</title>
</head>
<body>
	<c:url value="/lab4/cau3/signup" var="signup"/>
	<form action="${signup }" method="post">
		<h2>Sign Up User</h2>
		<label>Username:</label> 
		<input type="text" name="username" value="${param.username }"> <br>
		<label>Password:</label> 
		<input type="password" name="password"> <br>
		<label>Giới tính:</label> <br>
		<input type="radio" name="gender" value="Nam"> Nam
		<input type="radio" name="gender" value="Nu"> Nữ <br>
		<input type="checkbox" name="family"> Đã có gia đình? <br>
		<label>Quốc tịch:</label>
		<select name="country">
			<option value="VN">Việt Nam</option>
			<option value="US">United State</option>
			<option value="CN">China</option>
		</select> <br>
		Sở thích:
		<input name="hobbies" value="read" type="checkbox"> Đọc Sách
		<input name="hobbies" value="travel" type="checkbox"> Du lịch
		<input name="hobbies" value="music" type="checkbox"> Âm nhạc
		<input name="hobbies" value="football" type="checkbox"> Bóng đá
		<p>Ghi chú:</p>
		<textarea name="note" rows="4" cols="50"></textarea><br>
		<input type="submit" value="Sign Up" />
	</form>
	
	Username : ${name}<br>
	Gender: ${gender.equals("Nam")?'Nam':'Nữ'}<br>
	Tình trạng gia đình : ${married?"Đã có gia đình":"Chưa có gia đình"}<br>
	Quốc gia : ${country}<br>
	Sở thích : 
	<c:forEach var="hobby" items="${hobbies}">
	${hobby} 		
	</c:forEach>
	<br>
	Note:
	<textarea rows="4" cols="50">${note }</textarea>
</body>
</html>