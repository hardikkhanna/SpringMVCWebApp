<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<title>Reservation Form</title>
</head>
<h3>Railway Reservation Form</h3>
<body>
	<form:form action="submitForm" modelAttribute="reservation">
		First name: <form:input path="firstName" />
		<br>
		<br>
		Last name: <form:input path="lastName" />
		<br>
		<br>
		<form:select path="country">
			<form:options items="${reservation.countryOptions.value}" />
		</form:select>
		<input type="submit" value="Submit" />
	</form:form>
</body>
</html>


