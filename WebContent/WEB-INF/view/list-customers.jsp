<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page import="com.livelycodes.utils.SortUtils"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
	rel="stylesheet">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/resources/css/add-customer-style.css">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/resources/css/style.css">
<title>List customers</title>
</head>
<body>
	<div id="wrapper">
		<div id="header">
			<h2>CRM - Customer Relationship Manager</h2>
		</div>
		<div class="button-container">
			<button type="button" class="btn btn-info"
				onclick="window.location.href='showFormForAdd'; return false;">Add
				Customer</button>
		</div>
	</div>

	<div id="container">
		<div id="content">

			<!--  add a search box -->
			<form:form action="search" method="GET">
                Search customer: <input type="text" name="theSearchName" />

				<input type="submit" value="Search" class="add-button" />
			</form:form>

			<!-- Add html table here -->

			<!-- construct a sort link for first name -->
			<c:url var="sortLinkFirstName" value="/customer/list">
				<c:param name="sort"
					value="<%=Integer.toString(SortUtils.FIRST_NAME)%>" />
			</c:url>

			<!-- construct a sort link for last name -->
			<c:url var="sortLinkLastName" value="/customer/list">
				<c:param name="sort"
					value="<%=Integer.toString(SortUtils.LAST_NAME)%>" />
			</c:url>

			<!-- construct a sort link for email -->
			<c:url var="sortLinkEmail" value="/customer/list">
				<c:param name="sort" value="<%=Integer.toString(SortUtils.EMAIL)%>" />
			</c:url>

			<table class="table table-striped">
				<thead>
					<tr>
						<th><a href="${sortLinkFirstName}" title="sort by first name">First Name</a></th>
						<th><a href="${sortLinkLastName}" title="sort by last name">Last Name</a></th>
						<th><a href="${sortLinkEmail}" title="sort by email">Email</a></th>
						<th>Action</th>
					</tr>
				</thead>
				<tbody>
					<!-- Loop over and print customers -->
					<c:forEach var="customer" items="${customers}">

						<!-- Construct an update link with customer id -->
						<c:url var="updateLink" value="/customer/showFormForUpdate">
							<c:param name="customerId" value="${customer.id}" />
						</c:url>

						<c:url var="deleteLink" value="/customer/delete">
							<c:param name="deleteId" value="${customer.id}" />
						</c:url>

						<tr>
							<td scope="row">${ customer.firstName }</td>
							<td>${ customer.lastName }</td>
							<td>${ customer.email }</td>

							<!--Display the update link -->
							<td><a href="${updateLink}">Update</a></td>
							<td>|</td>
							<!--Display the delete link -->
							<td><a href="${deleteLink}"
								onclick="if(!(confirm('Are you sure you want to delete this customer?'))) return false;">Delete</a>
							</td>
						</tr>
					</c:forEach>

				</tbody>
			</table>

		</div>
	</div>
</body>
</html>