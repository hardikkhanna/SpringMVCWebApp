<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<link href="<c:url value="/resources/styles/bootstrap.min.css" />"
	rel="stylesheet">
<script src="<c:url value="/resources/javascript/example.js" />"></script>
</head>
<body>
	<div class="col-sm-2">
		First Name : ${student.firstName} <br> Last Name :
		${student.lastName} <br> Country : ${student.country } <br>
		Favorite Language: ${student.favoriteLanguage } <br> Operating
		System:
		<ul>
			<c:forEach var="temp" items="${student.operatingSystem}">
				<li class = ".text-primary">${temp}</li>
			</c:forEach>
		</ul>
	</div>
</body>
</html>