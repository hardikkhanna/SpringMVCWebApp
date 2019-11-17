<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>Save Customers</title>
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
			<div class="content table-responsive form-group">
				<form:form action="saveCustomer" modelAttribute="customer"
					method="POST">

					<!-- need to assosciate this data with customer id on form Submit it will set customer Id for Update Operations
						Very Very important to add this 
					 -->
					<form:hidden path="id" />
					<table
						class="table table-striped table-dark table-hover table-bordered">
						<tbody>
							<tr>
								<td scope="row"><label>First Name : </label></td>
								<td scope="row"><form:input type="text" path="firstName"
										class="form-control" /></td>
							</tr>
							<tr>
								<td scope="row"><label>Last Name : </label></td>
								<td scope="row"><form:input type="text" path="lastName"
										class="form-control" /></td>
							</tr>
							<tr>
								<td scope="row"><label>Email : </label></td>
								<td scope="row"><form:input type="text" path="email"
										class="form-control" /></td>
							</tr>
							<tr>
								<!-- There are two ways to reference the back button both are implemented below -->

								<!-- 1 method -->
								<!-- <td><input type="submit" class="btn btn-info"
									value="Back" 
								onclick="window.location.href='list'; return false" /></td> -->

								<!-- 2 method -->
								<td scope="row"><input type="submit" class="btn btn-info"
									value="Back"
									onclick="window.location.href='${pageContext.request.contextPath}/customer/list'; return false" /></td>


								<!-- Save Customer Button -->
								<td scope="row"><input type="submit"
									class="btn btn-success" value="Save" /></td>
							</tr>
						</tbody>
					</table>
				</form:form>
			</div>
		</div>
	</div>
</body>
</html>