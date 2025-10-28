<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/fmt_rt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Quản Lý Sản Phẩm</title>
</head>
<body>
	<c:url var="path" value="/asm/topic1" /> 
	<h2>QUẢN LÝ SẢN PHẨM</h2> 
	<c:if test="${not empty message}">
		<p style="color:red">${message}</p>
	</c:if>
	<form method="post">
		<label>Mã Sản phẩm:</label><br> <input name="maSp" value="${item.maSp}"><br> 
		<label>Tên Sản phẩm:</label><br> <input name="tenSp" value="${item.tenSp}"><br> 
		<label>Giá:</label><br> <input name="gia" value="${item.gia}"><br>
	    <label>Loại Sản phẩm:</label><br> <input name="loaiSp" value="${item.loaiSp}"><br> <hr>
	    <button formaction="${path}/create">Thêm mới</button>
	    <button formaction="${path}/update">Cập nhật</button>
	    <button formaction="${path}/delete">Xóa</button>
	    <button formaction="${path}/reset">Reset</button>
	</form>
	
	<form action="${path}/search" method="get">
	    Lọc theo Loại:
	    <select name="loaiLoc">
            <option value="Tất cả" 
				   <c:if test="${param.loaiLoc == 'Tất cả' || empty param.loaiLoc}">selected</c:if>
			>Tất cả</option>
				
			<option value="Thiết bị điện tử" 
				   <c:if test="${param.loaiLoc == 'Thiết bị điện tử'}">selected</c:if>
			>Thiết bị điện tử</option>
				
			<option value="Thời trang" 
				    <c:if test="${param.loaiLoc == 'Thời trang'}">selected</c:if>
			>Thời trang</option>
        </select>
	    <button type="submit">Lọc</button>
	</form>
	<hr>
	<table border="1" style="width: 100%">
		<thead>
			<tr>
				<th>Mã Sản phẩm</th> 
				<th>Tên Sản phẩm</th>
				<th>Giá</th>
				<th>Loại Sản phẩm</th>
				<th>Thao tác</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="d" items="${list}" varStatus="vs">
				<tr>
					<td>${d.maSp}</td> <td>${d.tenSp}</td> 
					<td><fmt:formatNumber value="${d.gia}" pattern="#,###.00" /></td> 
					<td>${d.loaiSp}</td> 
					<td><a href="${path}/edit/${d.maSp}">Sửa đổi</a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>