<%@ page contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Lab 2 | Cau 1</title>
</head>
<body>
	<style>
		.container {
			display: flex;
			height: 100vh;
			align-items: center;
			justify-content: center;
			color: red;
		}
	</style>
	<div class="container">
		Message: ${message } <br> Now: ${now.date } <br>
	</div>

	<!-- Format date
	yyyy-MM-dd	"1988-09-29"	
	dd/MM/yyyy	"29/09/1988"	
	dd-MMM-yyyy	"29-Sep-1988"	
	E, MMM dd yyyy	"Thu, Sep 29 1988"
	 -->
</body>
</html>