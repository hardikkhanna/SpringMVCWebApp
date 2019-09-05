<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<title>Information Details</title>
</head>
<h3>Student Information Details</h3>
<body>
	<form:form action="submitForm" modelAttribute="student">
		First name: <form:input path="firstName" />
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


