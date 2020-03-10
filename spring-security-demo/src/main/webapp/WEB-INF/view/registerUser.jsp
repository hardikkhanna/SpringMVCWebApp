<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<title>Registration Page</title>
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
<body>
	<!-- Registration Form -->
	<div class="container">
		<form:form
			action="${pageContext.request.contextPath}/register/processRegistrationForm"
			modelAttribute="crmUser" class="form-horizontal">
			<!-- Check for registration error -->
			<c:if test="${registrationError != null}">
				<div class="alert alert-danger col-xs-offset-1 col-xs-10">
					${registrationError}</div>
			</c:if>
			<div class="row">
				<fieldset>
					<div id="legend">
						<legend>Register</legend>
					</div>
				</fieldset>
			</div>
			<div class="control-group row">
				<!-- Username -->
				<label class="control-label" for="username">Username</label>
				<div class="controls">
					<!-- User name -->
					<form:input path="userName" placeholder="username"
						class="form-control" />
				</div>
			</div>
			<div class="control-group row">
				<!-- Password-->
				<label class="control-label" for="password">Password</label>
				<div class="controls">
					<!-- Password -->
					<form:password path="password" placeholder="password"
						class="form-control" />
				</div>
			</div>
			<div class="control-group row">
				<!-- Button -->
				<div class="controls">
					<button type="submit" class="btn btn-primary">Register</button>
				</div>
			</div>

		</form:form>

	</div>
</body>
</html>