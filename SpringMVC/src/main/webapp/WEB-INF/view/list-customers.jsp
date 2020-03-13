<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%><html>
<head>
<title>List Customers</title>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">

<!-- Reference Bootstrap files -->
<link type="text/css" rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/styles/bootstrap.min.css" />
</head>
<body>
	<div class="container">
		<div class="row page-header">
			<h2>CRM - Customer Relationship Manager</h2>
		</div>


		<div class="row">
			<div class = "content col-md-10">
			<h4>
				User:
				<security:authentication property="principal.username" />
				, Role(s):
				<security:authentication property="principal.authorities" />
			</h4></div>
			
			<div class = "content">
			
			<security:authorize access="hasAnyRole('MANAGER', 'ADMIN')">

				<!-- put new button: Add Customer -->

				<input type="button" value="Add Customer"
					onclick="window.location.href='showFormForAdd'; return false;"
					class="btn btn-primary" />

			</security:authorize></div>
		</div>


		<!--  add our html table here -->
		<div class="content mt-3 row">
			<div class="content table-responsive form-group">
				<table
					class="table table-striped table-dark table-hover table-bordered">
					<caption>List of Customers</caption>
					<tr>
						<th scope="col">First Name</th>
						<th scope="col">Last Name</th>
						<th scope="col">Email</th>

						<%-- Only show "Action" column for managers or admin --%>
						<security:authorize access="hasAnyRole('MANAGER', 'ADMIN')">

							<th>Action</th>

						</security:authorize>

					</tr>

					<!-- loop over and print our customers -->
					<c:forEach var="tempCustomer" items="${customers}">

						<!-- construct an "update" link with customer id -->
						<c:url var="updateLink" value="/customer/showFormForUpdate">
							<c:param name="customerId" value="${tempCustomer.id}" />
						</c:url>

						<!-- construct an "delete" link with customer id -->
						<c:url var="deleteLink" value="/customer/delete">
							<c:param name="customerId" value="${tempCustomer.id}" />
						</c:url>

						<tr>
							<td>${tempCustomer.firstName}</td>
							<td>${tempCustomer.lastName}</td>
							<td>${tempCustomer.email}</td>

							<security:authorize access="hasAnyRole('MANAGER', 'ADMIN')">

								<td><security:authorize
										access="hasAnyRole('MANAGER', 'ADMIN')">
										<!-- display the update link -->
										<a href="${updateLink}">Update</a>
									</security:authorize> <security:authorize access="hasAnyRole('ADMIN')">
										<a href="${deleteLink}"
											onclick="if (!(confirm('Are you sure you want to delete this customer?'))) return false">Delete</a>
									</security:authorize></td>

							</security:authorize>

						</tr>

					</c:forEach>

				</table>

			</div>

		</div>

		<p></p>

		<!-- Add a logout button -->
		<form:form action="${pageContext.request.contextPath}/logout"
			method="POST">
		
			<input type="submit" value="Logout" class="btn btn-success" />

		</form:form>
</body>
</html>