<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>입력값 테스트</h1>
	<form action="/Form.do" method="post">
		아이디: <input type="text" name="id" size="10" maxlength="10" value="user01"><br>
		비밀번호: <input type="password" name="pw" size="10"><br>
		좋아하는 과일(복수선택):
		<input type="checkbox" name="fruit" value="10">사과
		<input type="checkbox" name="fruit" value="20" checked>귤
		<input type="checkbox" name="fruit" value="30">감<br>
		성별:
		<input type="radio" name="sex" value="M" checked>남자
		<input type="radio" name="sex" value="F">여자<br>
		직업:
		<select name="job">
			<option value="학생">학생
			<option value="회사원" selected>회사원
			<option value="변호사">변호사
			<option value="의사">의사
			<option value="감사">감사
		</select><br>
		<textarea name="data" cols="50" rows="5">기본값은 이곳에 넣습니다.
이곳에 입력한 텍스트는    공백도 그대로 출력됩니다.</textarea><br>
		<input type="file" name="file"><br>
		<input type="submit" value="저장">
		<input type="reset" value="취소">
	</form>
</body>
</html>