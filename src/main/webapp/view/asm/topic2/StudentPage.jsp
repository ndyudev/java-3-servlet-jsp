<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/fmt_rt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Quản Lý Sinh Viên</title>
</head>

<body>
	<c:url var="path" value="/asm/topic2" />
	<h2>QUẢN LÝ SINH VIÊN</h2>

	<c:if test="${not empty message}">
		<p style="color: red">${message}</p>
	</c:if>

	<form method="post">
		<label>Mã sinh viên:</label><br> <input name="masv"
			value="${item.masv}"><br> <label>Họ tên:</label><br>
		<input name="hoten" value="${item.hoten}"><br> <label>Năm
			sinh:</label><br> <input name="namsinh" value="${item.namsinh}"><br>

		<label>Giới tính:</label><br> <select name="gioitinh">
			<option value="true" <c:if test="${item.gioitinh}">selected</c:if>>Nam</option>
			<option value="false" <c:if test="${!item.gioitinh}">selected</c:if>>Nữ</option>
		</select><br> <label>Mã khoa:</label><br> <input name="makhoa"
			value="${item.makhoa}"><br>
		<hr>

		<button formaction="${path}/create">Thêm mới</button>
		<button formaction="${path}/update">Cập nhật</button>
		<button formaction="${path}/delete">Xóa</button>
		<button formaction="${path}/reset">Reset</button>
	</form>

	<form action="${path}/search" method="get" style="margin-top: 10px;">
		Chọn khoa: <input type="text" name="keyword"
			placeholder="Nhập mã khoa..." value="${param.keyword}">
		<button type="submit">Lọc</button>
	</form>

	<hr>

	<table border="1" style="width: 100%">
		<thead>
			<tr>
				<th>Mã SV</th>
				<th>Họ tên</th>
				<th>Năm sinh</th>
				<th>Giới tính</th>
				<th>Mã khoa</th>
				<th>Thao tác</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="d" items="${list}" varStatus="vs">
				<tr>
					<td>${d.masv}</td>
					<td>${d.hoten}</td>
					<td>${d.namsinh}</td>
					<td><c:out value="${d.gioitinh ? 'Nam' : 'Nữ'}" /></td>
					<td>${d.makhoa}</td>
					<td><a href="${path}/edit/${d.masv}">Sửa đổi</a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>
