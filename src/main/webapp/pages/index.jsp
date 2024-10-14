<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Reports App</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH"
	crossorigin="anonymous">
</head>
<body>
	<div class="container">
		<h3 class="pb-3 pt-3">Reports Application</h3>

		<form:form action="search" modelAttribute="search" method="post">
			<table>
				<tr>
					<td>Plan Name :</td>
					<td><form:select path="planName">
							<form:option value="">-select-</form:option>
							<form:options items="${plan}" />
						</form:select></td>
					<td>Plan Status :</td>
					<td><form:select path="planStatus">
							<form:option value="">-select-</form:option>
							<form:options items="${status}" />
						</form:select></td>
					<td>Gender :</td>
					<td><form:select path="gender">
							<form:option value="">-select-</form:option>
							<form:option value="Male">Male</form:option>
							<form:option value="Female">Female</form:option>
						</form:select></td>
				</tr>
				<tr>
					<td>Start Date :</td>
					<td><form:input path="startDate" type="date" /></td>
					<td>End Date :</td>
					<td><form:input path="endDate" type="date" /></td>
				</tr>
				<tr>
					<td><a href="/" class="btn btn-secondary">Reset</a></td>

					<td><input type="submit" value="Search"
						class="btn btn-primary"></td>
				</tr>
			</table>
		</form:form>

		<hr>
		<table class="table table-striped table-hover">
			<thead>
				<tr>
					<th>S.no.</th>
					<th>Holder Name</th>
					<th>Gender</th>
					<th>Plan Name</th>
					<th>Start Date</th>
					<th>End Date</th>
					<th>Plan Status</th>
					<th>Benefit Amoount</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${plans}" var="p" varStatus="index">
					<tr>
						<td>${index.count}</td>
						<td>${p.citizenName}</td>
						<td>${p.gender}</td>
						<td>${p.planName}</td>
						<td>${p.planStartDate}</td>
						<td>${p.planEndDate}</td>
						<td>${p.planStatus}</td>
						<td>${p.benefitAmt}</td>
					</tr>
				</c:forEach>
				<tr>
					<c:if test="${empty plans}">
						<td colspan="8" style="text-align: center;">No records found</td>
					</c:if>

				</tr>
			</tbody>
		</table>
		<hr>
		Export: <a href="excel">Excel</a> <a href="pdf">Pdf</a>
	</div>

	<script
		src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.8/dist/umd/popper.min.js"
		integrity="sha384-I7E8VVD/ismYTF4hNIPjVp/Zjvgyol6VFvRkX/vR+Vc4jQkC+hVqc2pM8ODewa9r"
		crossorigin="anonymous"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.min.js"
		integrity="sha384-0pUGZvbkm6XF6gxjEnlmuGrJXVbNuzT9qBBavbLwCsOGabYfZo0T0to5eqruptLy"
		crossorigin="anonymous"></script>
</body>
</html>
