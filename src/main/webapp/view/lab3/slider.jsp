<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<%@page import="java.util.Date"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Lab 3 Slider</title>
</head>
<body>
	<!-- Tạo 1 Object -->
	<jsp:useBean id="d" class="java.util.Date" />
	<p>Raw Date: ${d}</p>

	<!-- Format Date -->
	<fmt:formatDate value="${d}" pattern="dd-MM-yyyy" var="now" />
	<p>Formatted Date: ${now}</p>

	<!-- Dùng biến -->
	<c:set var="x" value="18" />
	<c:set var="fullName" value="Chauu Nhat Duyy" />

	<p>Age: ${x}</p>
	<p>Họ Và Tên: ${fullName}</p>

	<!-- Format Number -->
	<c:set var="y" value="23423432.2342" />
	<p>
		Formatted Number:
		<fmt:formatNumber value="${y}" pattern="#,###.0" />
	</p>

	<!-- Function -->
	<p>Uppercase Name: ${fn:toUpperCase(fullName)}</p>

	<!-- Lấy link URL -->
	<c:url var="link" value="/crud/update" />
	${link }
</body>
</html>
