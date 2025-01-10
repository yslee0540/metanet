<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>사원 상세정보</title>
</head>
<body>
<h1>사원 정보 상세 조회</h1>
${message}
<table border="1">
<tr>
	<td>EMPLOYEE_ID</td>
	<td>${emp.employeeId}</td>
</tr>
<tr>
	<td>FIRST_NAME</td>
	<td>${emp.firstName}</td>
</tr>
<tr>
	<td>LAST_NAME</td>
	<td>${emp.lastName}</td>
</tr>
<tr>
	<td>EMAIL</td>
	<td>${emp.email}</td>
</tr>
<tr>
	<td>PHONE_NUMBER</td>
	<td>${emp.phoneNumber}</td>
</tr>
<tr>
	<td>HIRE_DATE</td>
	<td>${emp.hireDate}</td>
</tr>
<tr>
	<td>JOB_ID</td>
	<td>${emp.jobId}</td>
</tr>
<tr>
	<td>SALARY</td>
	<td>${emp.salary}</td>
</tr>
<tr>
	<td>COMMISSION_PCT</td>
	<td>${emp.commissionPct}</td>
</tr>
<tr>
	<td>MANAGER_ID</td>
	<td>${emp.managerId}</td>
</tr>
<tr>
	<td>DEPARTMENT_ID</td>
	<td>${emp.departmentId}</td>
</tr>
<tr>
</tr>
</table>
<a href="update?empid=${emp.employeeId}">수정하기</a>
<a href="delete?empid=${emp.employeeId}">삭제하기</a>
</body>
</html>