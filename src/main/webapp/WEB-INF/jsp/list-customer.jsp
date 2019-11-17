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

		<div class="content mt-3 row">
			<div class="content table-responsive form-group">
				<table
					class="table table-striped table-dark table-hover table-bordered">
					<caption>List of Customers</caption>
					<tr>
						<th scope="col">First Name</th>
						<th scope="col">Last Name</th>
						<th scope="col">Email</th>
						<th scope="col">Action</th>
					</tr>
					<c:forEach var="tempCustomer" items="${customers}">

						<!-- Contruct an Update link with Customer Id -->
						<c:url var="updateLink" value="/customer/showFormForUpdate">
							<c:param name="customerId" value="${tempCustomer.id }"></c:param>
						</c:url>
						<tr>
							<td scope="row">${tempCustomer.firstName}</td>
							<td scope="row">${tempCustomer.lastName}</td>
							<td scope="row">${tempCustomer.email}</td>
							<!-- Display the Update Link -->
							<td scope="row"><a href="${updateLink }">Update</a></td>
						</tr>
					</c:forEach>
				</table>
			</div>
		</div>
	</div>
</body>
</html>