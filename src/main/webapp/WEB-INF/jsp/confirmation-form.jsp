<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<body>

	First Name : ${student.firstName}
	<br> Last Name : ${student.lastName}
	<br> Country : ${student.country }
	<br> Favorite Language: ${student.favoriteLanguage }
	<br> Operating System:
	<ul>
		<c:forEach var="temp" items="${student.operatingSystem}">
			<li>${temp}</li>
		</c:forEach>
	</ul>
</body>
</html>