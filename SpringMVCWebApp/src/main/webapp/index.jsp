<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<title>Home Page</title>
<link type="text/css" rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/styles/bootstrap.min.css" />
</head>
<body>
	<div class="container">
		<h1 class="text-uppercase font-weight-bold">Home Page</h1>
		<a href="reservation/bookingForm">Click here for reservation.</a> <br>
		<br> <a href="customer/list">Click here For Form Data</a>
	</div>
</body>
</html>