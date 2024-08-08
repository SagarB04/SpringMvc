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
<title>Employees</title>
</head>
<body>
	<%@ include file="navbar.jsp"%>

	<!-- form -->

	<form method="post" class="container  my-4">
		<h2>Employee Data</h2>
		<div class="row">

			<c:if test="${emp1.getEmp_id()==null }">
				<input type="hidden" class="form-control" id="emp_id" name="emp_id"
					value="0">
			</c:if>
			<c:if test="${emp1.getEmp_id()!=null }">
				<input type="hidden" class="form-control" id="emp_id" name="emp_id"
					value="${emp1.getEmp_id()}">
			</c:if>



			<div class="form-group col-md-6">
				<label for="inputName">Name</label> <input type="text"
					class="form-control my-2" id="inputName" placeholder="Name"
					name="fname" value="${emp1.getFname()}">
			</div>
			<div class="form-group col-md-6">
				<label for="inputDept">Job ID</label> <select id="inputDept"
					class="form-control my-2" name="job_id">
					<option selected>Choose...</option>

					<option>AD_PRES</option>
					<option>AD_VP</option>
					<option>AD_ASST</option>
					<option>FI_MGR</option>
					<option>FI_ACCOUNT</option>
					<option>AC_MGR</option>
					<option>AC_ACCOUNT</option>
					<option>HR_REP</option>
					<option>PR_REP</option>
					<option>SH_CLERK</option>
					<option>IT_PROG</option>
					<option>MK_REP</option>
					<option>MK_MAN</option>
					<option>ST_CLERK</option>
					<option>ST_MAN</option>
					<option>PU_CLERK</option>
					<option>PU_MAN</option>
					<option>SA_REP</option>
					<option>SA_MAN</option>
				</select>
			</div>
		</div>

		<div class="row">

			<div class="form-group col-md-6">
				<label for="inputSal">Salary</label> <input type="number"
					maxlength="9" class="form-control my-2" id="inputSal"
					placeholder="Salary" name="sal" value="${emp1.getSal()}">
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
		class="container table table-striped table-bordered  my-4 table-hover">
		<tr class="bg-secondary text-light text-center">
			<th>Employee Id</th>
			<th>Name</th>
			<th>Job Id</th>
			<th>Salary</th>
			<th>Modify</th>
		</tr>


		<c:forEach var="emp" items="${empList }">
			<tr class="text-center">
				<td><c:out value="${emp.getEmp_id()}" /></td>
				<td><c:out value="${emp.getFname()}" /></td>
				<td><c:out value="${emp.getJob_id()}" /></td>
				<td><c:out value="${emp.getSal()}" /></td>
				<td><a class="btn btn-success"
					href="/SpringMvc/employee?action=update&id=${emp.getEmp_id()}">Update</a>
					<a class="btn btn-danger"
					href="/SpringMvc/employee?action=delete&id=${emp.getEmp_id()}">Delete</a></td>
			</tr>
		</c:forEach>



	</table>


</body>
</html>