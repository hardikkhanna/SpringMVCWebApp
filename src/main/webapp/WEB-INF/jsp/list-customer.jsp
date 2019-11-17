<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>List Customers</title>
<!-- reference our style sheet -->
<link type="text/css" rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/styles/bootstrap.min.css" />
</head>
<body>
	<div class="container">
		<div class="row page-header">
			<h2>CRM - Customer Relational Manager</h2>
		</div>
		<div class="row">
			<!-- put new button : ADD Customer -->
			<input type="button" value="Add Customer"
				onclick="window.location.href='showFormForAdd'; return false"
				class="btn btn-primary" />
		</div>

		<div class="row">
			<div class="content">
				<table>
					<tr>
						<th>No.</th>
						<th>First Name</th>
						<th>Last Name</th>
						<th>Email</th>

					</tr>
					<c:forEach var="tempCustomer" items="${customers}">
						<tr>
							<td><input type="text" value="${tempCustomer.id}" /></td>
							<td><input type="text" value="${tempCustomer.firstName}" /></td>
							<td><input type="text" value="${tempCustomer.lastName}" /></td>
							<td><input type="text" value="${tempCustomer.email}" /></td>
						</tr>
					</c:forEach>
				</table>
			</div>
		</div>
	</div>
</body>
</html>