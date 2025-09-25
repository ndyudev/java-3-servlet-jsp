<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<meta charset="UTF-8">
<title>Lab 3 | Cau 2</title>
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
		
		table {
			border: 1px black solid;
		}
		
		td {
			padding: 20px
		}
		
		th {
			border: 1px black solid;
		}
	</style>
	<div class="container">
		<h2 style="display: inline-block;">Danh sách thành phố</h2>
		<table>
			<thead>
				<tr>
					<th>No.</th>
					<th>Id City</th>
					<th>Name City</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="country" items="${country }" varStatus="dem">
					<tr>
						<td>${dem.count }</td>
						<td>${country.id }</td>
						<td>${country.name }</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</body>
</html>