<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/fmt_rt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Quản Lý Sách</title>
</head>
<body>
	<c:url var="path" value="/practice/book" /> 
	<h2>QUẢN LÝ SÁCH</h2> 
	<c:if test="${not empty message}">
		<p style="color:red">${message}</p>
	</c:if>
	<form method="post">
		<label>Mã Sách:</label><br> <input name="idBook" value="${item.idBook}"><br> 
		<label>Tên Sách:</label><br> <input name="nameBook" value="${item.nameBook}"><br> 
		<label>Giá:</label><br> <input name="priceBook" value="${item.priceBook}"><br>
	    <label>Năm Xuất Bản:</label><br> <input name="yearBook" value="${item.yearBook}"><br>
	    <label>Mã Loại:</label><br> 
	    <select name="idCategory">
	        <option value="">Chọn loại...</option>
	        <option value="C01" ${item.idCategory == 'C01' ? 'selected' : ''}>C01 - Programming</option>
	        <option value="C02" ${item.idCategory == 'C02' ? 'selected' : ''}>C02 - Web Development</option>
	        <option value="C03" ${item.idCategory == 'C03' ? 'selected' : ''}>C03 - Database</option>
	        <option value="C04" ${item.idCategory == 'C04' ? 'selected' : ''}>C04 - Design UI/UX</option>
	        <option value="C05" ${item.idCategory == 'C05' ? 'selected' : ''}>C05 - Artificial Intelligence</option>
	    </select><br> <hr>
	    <button formaction="${path}/create">Thêm mới</button>
	    <button formaction="${path}/update">Cập nhật</button>
	    <button formaction="${path}/delete">Xóa</button>
	    <button formaction="${path}/reset">Reset</button>
	</form>
	
	<!-- Thêm Form Tìm Kiếm -->
	<form action="${path}/search" method="get">
	    Tìm theo Mã Loại hoặc Tên Sách: <input name="kw" value="${param.kw}" placeholder="Nhập mã loại (C01) hoặc tên sách...">
	    <button type="submit">Tìm</button>
	    <c:if test="${not empty param.kw}">
	        <a href="${path}/index">Xóa bộ lọc</a>
	    </c:if>
	</form>
	<hr>
	<table border="1" style="width: 100%">
		<thead>
			<tr>
				<th>Mã Sách</th> 
				<th>Tên Sách</th>
				<th>Giá</th>
				<th>Năm</th>
				<th>Loại</th>
				<th>Thao tác</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="d" items="${list}" varStatus="vs">
				<tr>
					<td>${d.idBook}</td> <td>${d.nameBook}</td> 
					<td><fmt:formatNumber value="${d.priceBook}" pattern="#,###.00" /></td> 
					<td>${d.yearBook}</td> 
					<td>${d.idCategory}</td> 
					<td><a href="${path}/edit/${d.idBook}">Sửa đổi</a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>