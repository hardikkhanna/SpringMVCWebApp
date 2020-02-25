<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<title>Result Page</title>
<link type="text/css" rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/styles/bootstrap.min.css" />
</head>
<body>
	<div class="col-sm-2">
		First Name : ${student.firstName} <br> Last Name :
		${student.lastName} <br> Roll No. : ${student.rollNo} <br>
		Postal Code : ${student.postalCode} <br> Course Code :
		${student.studentCourse } <br> Country : ${student.country } <br>
		Favorite Language: ${student.favoriteLanguage } <br> Operating
		System:
		<ul>
			<c:forEach var="temp" items="${student.operatingSystem}">
				<li class=".text-primary">${temp}</li>
			</c:forEach>
		</ul>
	</div>
</body>
</html>