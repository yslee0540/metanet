<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>File List</title>
</head>
<body>
<h1>파일 목록</h1>
<a href="new">업로드</a>
<table border="1">
<tr>
	<th>ID</th>
	<th>분류</th>
	<th>파일명</th>
	<th>크기</th>
	<th>유형</th>
	<th>날짜/시간</th>
	<th>삭제</th>
</tr>
<c:forEach var="file" items="${fileList}">
<c:set var="type" value="${fn:split(file.fileContentType, '/')}"/>
<tr>
	<td>${file.fileId}</td>
	<td>${file.categoryName}</td>
	<td><a href="${file.fileId}">${file.fileName}</a>
		<c:if test="${type[0] eq 'image'}">
			<img src="${file.fileId}" width="100">
		</c:if>
	</td>
	<td><fmt:formatNumber value="${file.fileSize/1024}" pattern="#,###"/>KB</td>
	<td>${file.fileContentType}</td>
	<td><fmt:formatDate value="${file.fileUploadDate}" pattern="yy-MM-dd HH:mm:ss"/></td>
	<td><a href="delete/${file.fileId}" class="delete">삭제</a></td>
</tr>
</c:forEach>
</table>

<script type="text/javascript">
var deleteLinks = document.querySelectorAll(".delete");
for (let i = 0; i < deleteLinks.length; i++) {
	deleteLinks[i].onclick = function() {
		if (confirm("파일을 삭제하겠습니까?")) {
			return true;
		} else {
			return false;
		}
	}
}
</script>
</body>
</html>