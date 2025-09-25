<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Lab 3 | Cau 4</title>
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
		<h2>Nội dung:</h2>
		<ul>
			<li>Title: ${fn:toUpperCase(content.title )}</li>
			<li>Content:
			 <c:choose>
			 	<c:when test="${fn:length(content.content) > 100 }">
			 		${fn:substring(content.content, 0, 100) }
			 	</c:when>
			 	<c:otherwise>${content.content }</c:otherwise>
			 </c:choose>
			</li>
		</ul>
	</div>
</body>
</html>