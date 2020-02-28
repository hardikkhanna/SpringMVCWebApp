<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>
<title>Home Page</title>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">

<!-- Reference Bootstrap files -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">

<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>

<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

</head>

</head>
<body>
	<h2>Company Home Page</h2>
	<hr>
	Welcome to the Company Home Page!

	<form:form action="${pageContext.request.contextPath}/logout"
		method="POST">

		<div style="margin-top: 10px" class="form-group">
			<div class="col-sm-6 controls">
				<button type="submit" class="btn btn-success">Logout</button>
			</div>
		</div>

	</form:form>


</body>
</html>