<%@ page contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>비밀번호 입력</h1>
<form action="/member/Member.do" method="post">
	비밀번호: <input type="password" name="password">
	<input type="hidden" name="action" value="${action}">
	<input type="submit" value=" 삭 제 ">
</form>
</body>
</html>