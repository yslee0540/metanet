<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Member</title>
</head>
<body>
	<h1>회원 정보 입력 폼</h1>
	<form action="/member/Member.do" method="post">
		<fieldset>
			<legend>회원정보</legend>
			<table>
				<tr>
					<td class="label">아이디</td>
					<td class="field"><input type="text" name="userid" value="${member.userid}" ${empty member.userid ? "" : "readonly"}></td>
				</tr>
				<tr>
					<td class="label">비밀번호</td>
					<td class="field"><input type="password" name="password" value="${member.password}"></td>
				</tr>
				<tr>
					<td class="label">이름</td>
					<td class="field"><input type="text" name="name" value="${member.name}"></td>
				</tr>
				<tr>
					<td class="label">이메일</td>
					<td class="field"><input type="text" name="email" value="${member.email}"></td>
				</tr>
				<tr>
					<td class="label">주소</td>
					<td class="field"><input type="text" name="address" size="50" value="${member.address}"></td>
				</tr>
			</table>
			<input type="hidden" name="action" value="${action}">
			<input type="submit" value=" 저 장 ">
			<input type="reset" value=" 취 소 ">
		</fieldset>
	</form>
</body>
</html>