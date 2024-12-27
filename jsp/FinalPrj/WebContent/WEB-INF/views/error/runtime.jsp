<%@page import="java.io.PrintWriter"%>
<%@ page contentType="text/html; charset=UTF-8"
		 isErrorPage="true"
%>
<%
	response.setStatus(200);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Error</title>
</head>
<body>
<h1>런타임 예외 발생.</h1>
<h2><%= exception.getMessage() %></h2>
<!-- 
<pre>
<%
	exception.printStackTrace(new PrintWriter(out));
%>
</pre>
-->
</body>
</html>