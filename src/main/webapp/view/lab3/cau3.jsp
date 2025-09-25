<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Lab 3 | Cau 3</title>
</head>
<body>
	<style>
		.container {
		  display: flex;
		  flex-direction: column;
		  align-items: center;
		  justify-content: center;
		  height: 50vh;
		}
		ul {
			list-style: none;
		}
	</style>
	<div class="container">
		<h2>Iphone:</h2>
		<ul>
			<li>Name: ${iphone.name }</li>
			<li>Price: 
			<fmt:formatNumber value="${iphone.price }" pattern="#,###.00"/>
			</li>
			<li> Date:
			<fmt:formatDate value="${iphone.date }" pattern="dd/MM/yyyy"/>
			</li>
		</ul>
	</div>
</body>
</html>