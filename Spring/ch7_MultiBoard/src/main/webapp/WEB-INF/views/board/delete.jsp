<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<fmt:setBundle basename="i18n/board"/>
<!DOCTYPE html>
<html>
<jsp:include page="/WEB-INF/views/include/staticFiles.jsp"/>
<body>
<jsp:include page="/WEB-INF/views/include/bodyHeader.jsp"/>
<div class="container">
	<div class="pg-opt">
		<div class="row">
			<div class="col-md-6 pc">
				<h2><fmt:message key="DELETE_ARTICLE"/></h2>
			</div>
			<div class="col-md-6">
				<ol class="breadcrumb">
					<li><fmt:message key="BOARD"/></li>
					<li class="active"><fmt:message key="DELETE_ARTICLE"/></li>
				</ol>
			</div>
		</div>
	</div>
	<div class="content">
		<h3><fmt:message key="DELETE_MSG"/></h3>
		<form action="<c:url value='/board/delete'/>" method="post" class="form-inline">
			<input type="hidden" name="boardId" value="${boardId}">
			<input type="hidden" name="categoryId" value="${categoryId}">
			<input type="hidden" name="replyNumber" value="${replyNumber}">
			<div class="form-group">
				<div class="col-sm-8">
					<input type="password" name="password" class="form-control" required>
						<c:if test="${!empty message}">
							<br><span style="color:red;"><fmt:message key="${message}"/></span>
						</c:if>
				</div>
				<div class="col-sm-2">
					<input type="submit" class="btn btn-danger" value="<fmt:message key="DELETE_ARTICLE"/>">
				</div>
			</div>
		</form>
	</div>
</div>
<jsp:include page="/WEB-INF/views/include/footer.jsp"/>
</body>
</html>