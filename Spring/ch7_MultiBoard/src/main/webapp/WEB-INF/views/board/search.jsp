<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<fmt:setBundle basename="i18n/board"/>
<%@ taglib prefix="jk" tagdir="/WEB-INF/tags"%>
<!DOCTYPE html>
<html>
<jsp:include page="/WEB-INF/views/include/staticFiles.jsp"/>
<body>
<jsp:include page="/WEB-INF/views/include/bodyHeader.jsp"/>
<div class="container">
	<div class="pg-opt">
		<div class="row">
			<div class="col-md-6">
				<h2><fmt:message key="BOARD_LIST"/>
				<c:if test="${empty name}">
				<small style="color:red;"><fmt:message key="LOGIN"/></small>
				</c:if>
				</h2>
			</div>
			<div class="col-md-6">
				<ol class="breadcrumb">
					<li><fmt:message key="BOARD"/></li>
					<li class="active"><fmt:message key="BOARD_LIST"/></li>
				</ol>
			</div>
		</div>
	</div>
	${message}
	<div class="content">
		<form action="<c:url value='/board/search/1'/>">
			<div class="pull-right" style="margin-bottom:5px;">
				<div class="col-xs-9">
					<input type="text" name="keyword" class="form-control">
				</div>
				<input type="submit" class="btn btn-warning" value="<fmt:message key='SEARCH'/>">
			</div>
		</form>
		<table class="table table-hover table-bordered">
			<thead>
				<tr>
					<td><fmt:message key="BOARD_ID"/></td>
					<td class="pc"><fmt:message key="WRITER"/></td>
					<td><fmt:message key="SUBJECT"/></td>
					<td class="pc"><fmt:message key="WRITE_DATE"/></td>
					<td class="pc"><fmt:message key="READ_COUNT"/></td>
				</tr>
			</thead>
			<c:forEach var="board" items="${boardList}">
				<tr>
					<td>${board.boardId}</td>
					<td class="pc">${board.writer}</td>
					<td>
					<jk:reply replynum="${board.replyNumber}" replystep="${board.replyStep}"/>
					<c:url var="viewLink" value="/board/${board.boardId}/${page}"/>
					<a href="${viewLink}">${board.title}</a>
					</td>
					<td class="pc"><fmt:formatDate value="${board.writeDate}" pattern="YYYY-MM-dd"/></td>
					<td class="pc">${board.readCount}</td>
				</tr>
			</c:forEach>
		</table>
		<table class="table">
			<tr>
				<td align="left">
					<jk:search-paging nowPage="${page}" keyword="${keyword}" totalPageCount="${totalPage}"/>				
				</td>
				<td align="right"><br></td>
			</tr>
		</table>
	</div>
</div>
<jsp:include page="/WEB-INF/views/include/footer.jsp"/>
</body>
</html>