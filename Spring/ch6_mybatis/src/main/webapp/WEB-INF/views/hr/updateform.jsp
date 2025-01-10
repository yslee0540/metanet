<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>수정</title>
</head>
<body>
<h1>사원정보 수정</h1>
<form action="./update" method="post">
<table border="1">
<tr>
	<td>EMPLOYEE_ID</td>
	<td><input type="number" name="employeeId" value="${emp.employeeId}" readonly/></td>
</tr>
<tr>
	<td>FIRST_NAME</td>
	<td><input type="text" name="firstName" value="${emp.firstName}"/></td>
</tr>
<tr>
	<td>LAST_NAME</td>
	<td><input type="text" name="lastName" value="${emp.lastName}"/></td>
</tr>
<tr>
	<td>EMAIL</td>
	<td><input type="text" name="email" value="${emp.email}"/></td>
</tr>
<tr>
	<td>PHONE_NUMBER</td>
	<td><input type="text" name="phoneNumber" value="${emp.phoneNumber}"/></td>
</tr>
<tr>
	<td>HIRE_DATE</td>
	<td><input type="date" name="hireDate" value="${emp.hireDate}"/></td>
</tr>
<tr>
	<td>JOB_ID</td>
	<td>
		<select name="jobId">
		<c:forEach var="job" items="${jobList}">
			<option value="${job.jobId}"
				<c:if test="${emp.jobId == job.jobId}">selected</c:if>
			>${job.jobTitle}</option>
		</c:forEach>
		</select>
	</td>
</tr>
<tr>
	<td>SALARY</td>
	<td><input type="number" name="salary" value="${emp.salary}"/></td>
</tr>
<tr>
	<td>COMMISSION_PCT</td>
	<td><input type="number" name="commissionPct" value="${emp.commissionPct}" step="0.1" min="0" max="0.99"/></td>
</tr>
<tr>
	<td>MANAGER</td>
	<td>
		<select name="managerId">
		<c:forEach var="manager" items="${managerList}">
			<option value="${manager.managerId}"
			<c:if test="${emp.managerId == manager.managerId}">selected</c:if>
			>${manager.firstName}</option>
		</c:forEach>
		</select>
	</td>
</tr>
<tr>
	<td>DEPARTMENT</td>
	<td>
		<select name="departmentId">
		<c:forEach var="department" items="${deptList}">
			<option value="${department.departmentId}"
			<c:if test="${emp.departmentId == department.departmentId}">selected</c:if>
			>${department.departmentName}</option>
		</c:forEach>
		</select>
	</td>
</tr>
<tr>
	<td colspan="2" style="text-align:center;">
		<input type="submit" value="수정">
		<input type="reset" value="취소" onclick="history.back()">
	</td>
</tr>
</table>
</form>
</body>
</html>