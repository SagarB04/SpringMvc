<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
	crossorigin="anonymous">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
	crossorigin="anonymous"></script>
<script
	src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js"
	integrity="sha384-IQsoLXl5PILFhosVNubq5LC7Qb9DXgDA9i+tQ8Zj3iwWAwPtgFTxbJ8NT4GN1R8p"
	crossorigin="anonymous"></script>
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.min.js"
	integrity="sha384-cVKIPhGWiC2Al4u+LWgxfKTRIcfu0JTxR+EQDz/bgldoEyl4H0zUF0QKbrJ0EcQF"
	crossorigin="anonymous"></script>
<title>Department</title>
</head>
<body>
	<%@ include file="navbar.jsp"%>

	<!-- form -->

	<form method="post" class="container  my-4">
		<h2>Department Data</h2>
		<div class="row">



			<c:if test="${department.getDept_id() ==null }">
				<input type="hidden" class="form-control" id="dept_id"
					name="dept_id" value="0">
			</c:if>

			<c:if test="${department.getDept_id() !=null }">
				<input type="hidden" class="form-control" id="dept_id"
					name="dept_id" value="${department.getDept_id() }">
			</c:if>


			<div class="form-group col-md-6">
				<label for="deptName">Department Name</label> <select id="deptName"
					class="form-control my-2" name="dept_name">
					<option selected>Choose...</option>
					<option>Administration</option>
					<option>Marketing</option>
					<option>Purchasing</option>
					<option>Human Resources</option>
					<option>Shipping</option>
					<option>IT</option>
					<option>Public Relations</option>
					<option>Sales</option>
					<option>Executive</option>
					<option>Finance</option>
					<option>Accounting</option>
					<option>Treasury</option>
					<option>Corporate Tax</option>
					<option>Control And Credit</option>
					<option>Shareholder Services</option>

				</select>
			</div>

			<div class="form-group col-md-6">
				<label for="man_id">Manager Id</label> <input type="number"
					maxlength="9" class="form-control my-2" id="man_id"
					placeholder="Manager Id" name="manager_id"
					value="${department.getManager_id()}">
			</div>
		</div>

		<div class="row">
			<div class="form-group col-md-6">
				<label for="loc_id">Location Id</label> <input type="number"
					maxlength="9" class="form-control my-2" id="loc_id"
					placeholder="Location Id" name="loc_id"
					value="${department.getLoc_id()}">
			</div>

			<div class="form-group col-md-2 d-flex align-items-end">

				<c:if test="${action!='update' }">
					<input type="submit" class="btn btn-primary form-control my-2"
						value="Save" />
				</c:if>
				<c:if test="${action=='update' }">
					<input type="submit" class="btn btn-success form-control my-2"
						value="Update" />
				</c:if>

			</div>
		</div>
	</form>

	<!-- table -->

	<table
		class="container table table-striped table-bordered  my-4 table-hover table-dark">
		<tr class="bg-secondary text-light text-center">
			<th>Department Id</th>
			<th>Department Name</th>
			<th>Manager Id</th>
			<th>Location Id</th>
			<th>Modify</th>
		</tr>


		<c:forEach var="row" items="${dept }">
			<tr class="text-center">
				<td><c:out value="${row.getDept_id()}" /></td>
				<td><c:out value="${row.getDept_name()}" /></td>
				<td><c:out value="${row.getManager_id()}" /></td>
				<td><c:out value="${row.getLoc_id()}" /></td>
				<td><a class="btn btn-success"
					href="/SpringMvc/department?action=update&id=${row.getDept_id()}">Update</a>
					<a class="btn btn-danger"
					href="/SpringMvc/department?action=delete&id=${row.getDept_id()}">Delete</a></td>
			</tr>
		</c:forEach>

	</table>


</body>
</html>