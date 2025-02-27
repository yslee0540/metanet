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
				<h2><fmt:message key="WRITE_NEW_ARTICLE"/></h2>
			</div>
			<div class="col-md-6">
				<ol class="breadcrumb">
					<li><fmt:message key="BOARD"/></li>
					<li class="active"><fmt:message key="WRITE_NEW_ARTICLE"/></li>
				</ol>
			</div>
		</div>
	</div>
	<div class="content">
		<form action="<c:url value='/board/write'/>" method="post" enctype="multipart/form-data" class="form-horizontal">
			<input type="hidden" name="csrfToken" value="${sessionScope.csrfToken}"/>
			<c:if test="${!empty categoryList}">
				<div class="form-group">
					<label class="control-label col-sm-2" for="categoryId">
						<fmt:message key="CATEGORY"/>
					</label>
					<div class="col-sm-4">
						<select name="categoryId" id="categoryId" class="form-control" required>
							<c:forEach var="category" items="${categoryList}">
								<option value="${category.categoryId}" ${category.categoryId eq requestScope.categoryId ? "selected":""}>
									${category.categoryName}
								</option>
							</c:forEach>
						</select>
					</div>
				</div>
			</c:if>
			<div class="form-group">
				<label class="control-label col-sm-2" for="writer">
					<fmt:message key="WRITER"/>
				</label>
				<div class="col-sm-2">
					<input type="text" name="writer" id="writer" class="form-control" value="${sessionScope.name}"
					${!empty sessionScope.name ? "readonly" : ""} autocomplete="off" required>
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-2" for="email">
					<fmt:message key="EMAIL"/>
				</label>
				<div class="col-sm-4">
					<input type="text" name="email" id="email" class="form-control" value="${sessionScope.email}"
					${!empty sessionScope.email ? "readonly" : ""} autocomplete="off" required>
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-2" for="password">
					<fmt:message key="PASSWORD"/>
				</label>
				<div class="col-sm-2">
					<input type="text" name="password" id="password" class="form-control" required>
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-2" for="title">
					<fmt:message key="SUBJECT"/>
				</label>
				<div class="col-sm-8">
					<input type="text" name="title" id="title" class="form-control" required>
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-2" for="content">
					<fmt:message key="CONTENT"/>
				</label>
				<div class="col-sm-8">
					<textarea name="content" id="content" rows="10" cols="100" class="form-control"></textarea>
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-2" for="file">
					<fmt:message key="FILE"/>
				</label>
				<div class="col-sm-8">
					<input type="file" name="file" id="file">
					<span id="droparea" class="help-block"><fmt:message key="FILESIZE_ERROR"/></span>
				</div>
			</div>
			<div class="form-group">
				<div class="col-sm-8 col-sm-offset-2">
					<input type="hidden" name="boardId" value="${board.boardId}">
					<input type="hidden" name="masterId" value="${board.masterId}">
					<input type="hidden" name="replyNumber" value="${board.replyNumber}">
					<input type="hidden" name="replyStep" value="${board.replyStep}">
					<input type="submit" class="btn btn-info" value="<fmt:message key="SAVE"/>">
					<input type="reset" class="btn btn-info" value="<fmt:message key="CANCEL"/>">
				</div>
			</div>
		</form>
	</div>
</div>
<jsp:include page="/WEB-INF/views/include/footer.jsp"/>
</body>
</html>