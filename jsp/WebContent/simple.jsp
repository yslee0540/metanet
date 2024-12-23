<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
// scriptlet, 자바코드를 작성
	out.println("Hello JSP");
	out.println(new java.util.Date());
%>
</body>
</html>