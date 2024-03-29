<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/resources/css/style.css">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/resources/css/add-customer-style.css">
<title>Insert title here</title>
</head>
<body>

	<div id="wrapper">
		<div id="header">
			<h2>CRM - Customer Relationship Manager</h2>
		</div>

	</div>

	<div id="container">
		<h3>Save Customer</h3>

		<form:form action="customerProcessForm" modelAttribute="customer"
			method="POST">
			
			<!-- Need to associate this form with customer id -->
			<form:hidden path="id"/>
			<table>
				<tbody>
					<tr>
						<td><label>First Name: </label></td>
						<td><form:input path="firstName" /></td>
					</tr>
					<tr>
						<td><label>Last Name: </label></td>
						<td><form:input path="lastName" /></td>
					</tr>
					<tr>
						<td><label>Email: </label></td>
						<td><form:input path="email" /></td>
					</tr>
					<tr>
						<td><label></label></td>
						<td><input type="submit" value="submit" class="save" /></td>
					</tr>
				</tbody>
			</table>
			
			<div style="clear; both;"></div>
			
			<p>
				<a href="${pageContext.request.contextPath}/customer/list">Back to list</a>
			</p>

		</form:form>
	</div>

</body>
</html>