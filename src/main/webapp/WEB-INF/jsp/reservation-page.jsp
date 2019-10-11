<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<title>Information Details</title>
<link href="<c:url value="/resources/styles/bootstrap.min.css" />"
	rel="stylesheet">
<script src="<c:url value="/resources/javascript/example.js" />"></script>
</head>

<body>
	<h3 class = "p-3">Student Information Details</h3>
	<form:form action="submitForm" modelAttribute="student" class = "p-3">
		First name: <form:input path="firstName" class = "text-warning"/>
		<br>
		<br>
		Last name: <form:input path="lastName" />
		<br>
		<br>
		<form:select path="country">
			<form:options items="${student.countryOptions}" />
		</form:select>
		<br>
		<br>
		Java<form:radiobutton path="favoriteLanguage" value="Java" />
		C#<form:radiobutton path="favoriteLanguage" value="C#" />
		PHP<form:radiobutton path="favoriteLanguage" value="PHP" />
		<br>
		<br>
		Linux <form:checkbox path="operatingSystem" value="OS" />
		Mac OS<form:checkbox path="operatingSystem" value="Mac OS" />
		Windows <form:checkbox path="operatingSystem" value="Windows" />
		<br>
		<br>
		<input type="submit" value="Submit" />
	</form:form>
</body>
</html>


