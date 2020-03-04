<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
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
	<div class="container">
		<h2>Company Home Page</h2>
		<hr>
		Welcome to the Company Home Page!
		<form:form action="${pageContext.request.contextPath}/logout"
			method="POST">

			<div class=".container-fluid">

				<div class="row">
					<div class="col-sm-6">
						<span>User : </span><span><sec:authentication
								property="principal.username" /></span> <span>Roles : </span><span><sec:authentication
								property="principal.authorities" /></span>
					</div>
				</div>
				<hr>
				<div class="row">
					<div class="col-sm-6">
						<span><p>
								<a href="${pageContext.request.contextPath}/leaders">LeaderShip
									Meeting</a> Only For Manager Peeps
							</p></span>
					</div>
				</div>
				
				<!-- Only for Admins -->
				<div class="row">
					<div class="col-sm-6">
						<span><p>
								<a href="${pageContext.request.contextPath}/systems">IT Systems
									Meeting</a> Only For Admin Peeps
							</p></span>
					</div>
				</div>

				<div class="row" style="margin-top: 10px" class="form-group">
					<div class="col-sm-6 controls">
						<button type="submit" class="btn btn-success">Logout</button>
					</div>
				</div>



			</div>

		</form:form>
	</div>

</body>
</html>