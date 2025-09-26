<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Lab 3 | Cau 5</title>
</head>
<style>
.container {
	display: flex;
	flex-direction: column;
	align-items: center;
	justify-content: center;
	height: 50vh;
}

table, th, tr, td {
	border: 1px black solid;
}

th, td {
	padding: 10px;
}

thead tr:hover {
	background-color: silver;
	cursor: pointer;
}

tbody tr:hover {
    background-color: silver;
    cursor: pointer;
}

a {
	color: blue;
}
</style>
<body>
	<div class="container">
		<h2>List Products</h2>
		<table>
			<thead>
				<tr>
					<th>No.</th>
					<th>ID</th>
					<th>Name</th>
					<th>Price</th>
					<th>Action</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="item" items="${productList}" varStatus="dem">
					<tr>
						<td>${dem.count}</td>
						<td>${item.idProduct}</td>
						<td>${item.nameProduct}</td>
						<td>${item.priceProduct}</td>
						<td><a
							href="${pageContext.request.contextPath }/lab3/cau5/product?action=delete&id=${item.idProduct}">Delete</a>
							<a
							href="${pageContext.request.contextPath }/lab3/cau5/product?action=edit&id=${item.idProduct}">Edit</a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<p>${message }</p>
	</div>
</body>
</html>