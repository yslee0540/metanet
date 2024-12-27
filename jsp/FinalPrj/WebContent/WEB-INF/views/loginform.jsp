<%@ page contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>
</head>
<body>
<!-- 로그인 하지 않은 사용자일 경우 -->
<% 
String userid = (String)session.getAttribute("userid");
if (userid == null) {
%>
<h1>로그인 폼</h1>
<form action="/Login.do" method="post">
아이디: <input type="text" name="userid"><br>
비밀번호: <input type="password" name="password"><br>
<input type="submit" value="로그인">
<input type="reset" value="취 소">
</form>

<!-- 로그인 한 사용자일 경우 -->
<% } else { %>
<%= userid %>님 환영합니다.<br>
<a href="/member/Member.do?action=select">회원정보</a>
<a href="/member/Member.do?action=delete">탈퇴</a>
<a href="/Login.do">로그아웃</a>
<% } %>
</body>
</html>