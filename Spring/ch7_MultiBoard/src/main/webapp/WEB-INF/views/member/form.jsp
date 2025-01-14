<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<fmt:setBundle basename="i18n/member"/>
<!DOCTYPE html>
<html>
<jsp:include page="/WEB-INF/views/include/staticFiles.jsp"/>
<body>
<jsp:include page="/WEB-INF/views/include/bodyHeader.jsp"/>
<div class="container">
	<div class="pg-opt">
		<div class="row">
			<div class="col-md-6 pc">
				<h2><fmt:message key="INSERT_USER_INFO"/></h2>${message}
			</div>
			<div class="col-md-6">
				<ol class="breadcrumb">
					<li><fmt:message key="MEMBER"/></li>
					<li class="active"><fmt:message key="INSERT_USER_INFO"/></li>
				</ol>
			</div>
		</div>
	</div>
	<div class="content">
		<form action="<c:url value='/member/insert'/>" method="post" id="joinForm" class="form-horizontal">
			<input type="hidden" name="csrfToken" value="${sessionScope.csrfToken}"/>
			<div class="form-group">
				<label class="control-label col-sm-2" for="userid">
					<fmt:message key="MEMBER_ID"/>
				</label>
				<div class="col-sm-4">
					<input type="text" name="userid" id="userid" class="form-control" value="${member.userid}"
					${!empty member.userid ? "readonly" : ""} title="<fmt:message key="USERID_TITLE"/>" pattern="\w+"
					placeholder="<fmt:message key="MEMBER_ID"/>" required>
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-2" for="password">
					<fmt:message key="MEMBER_PW"/>
				</label>
				<div class="col-sm-4">
					<input type="password" name="password" id="password" class="form-control" value="${member.password}"
					title="<fmt:message key="PASSWORD_TITLE"/>" pattern="(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{6,}"
					required>
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-2" for="password2">
					<fmt:message key="MEMBER_PW_RE"/>
				</label>
				<div class="col-sm-4">
					<input type="password" name="password2" id="password2" class="form-control" required>
					<span id="passwordConfirm"></span>
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-2" for="name">
					<fmt:message key="MEMBER_NAME"/>
				</label>
				<div class="col-sm-4">
					<input type="text" name="name" id="name" class="form-control" value="${member.name}"
					autocomplete="off" required>
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-2" for="phone">
					<fmt:message key="MEMBER_PHONE"/>
				</label>
				<div class="col-sm-6">
					<input type="text" name="phone" id="phone" class="form-control" value="${member.phone}"
					autocomplete="off" required>
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-2" for="email">
					<fmt:message key="MEMBER_EMAIL"/>
				</label>
				<div class="col-sm-8">
					<input type="email" name="email" id="email" class="form-control" value="${member.email}"
					autocomplete="off" required>
				</div>
			</div>
			<div class="form-group">
				<div class="col-sm-8 col-sm-offset-2">
					<input type="submit" class="btn btn-info" value="<fmt:message key="SAVE"/>">
					<input type="reset" class="btn btn-info" value="<fmt:message key="CANCEL"/>">
				</div>
			</div>
		</form>
	</div>
</div>
<jsp:include page="/WEB-INF/views/include/footer.jsp"/>
</body>
<script type="text/javascript">
var pw1 = document.querySelector("#password");
var pw2 = document.querySelector("#password2");
var pwConfirm = document.querySelector("#passwordConfirm");
pw2.onkeyup = function(event) {
	if (pw1.value !== pw2.value) {
		pwConfirm.innerText = "비밀번호가 일치하지 않습니다.";
	} else {
		pwConfirm.innerText = "";
	}
}
</script>
</html>