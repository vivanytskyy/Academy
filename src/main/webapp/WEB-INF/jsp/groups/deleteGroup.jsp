<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<link href="${pageContext.request.contextPath}/assets/css/bootstrap.min.css" type="text/css" rel="stylesheet">
	<!-- Custom styles for this template -->
	<link href="${pageContext.request.contextPath}/assets/css/offcanvas.css" type="text/css" rel="stylesheet">
	<title>Delete Group</title>
</head>
<body>
	<jsp:include page="../fragments/bodyHeader.jsp"/>	
	<div class="container">
		<div class="starter-template">
			<h1>Delete the group</h1>
			<form:form commandName="group">
				<form:errors path="*" cssClass="errorblock" element="div"/>
				<table>
					<tr>
						<td width="20%" style="vertical-align: middle;">Name: </td>
						<td width="30%" style="vertical-align: middle;">
							<form:input path="name" cssErrorClass="error" readonly="true"/>
						</td>
						<td width="50%" style="vertical-align: middle;">
							<form:errors path="*" cssClass="error" />
						</td>
					</tr>
					<tr>
						<td colspan="3">
							<input type="submit" class="btn" value="Delete">
						</td>
					</tr>
				</table>
			</form:form>
		</div>
	</div><!-- /.container -->
	<jsp:include page="../fragments/footer.jsp"/>
	<!-- Bootstrap core JavaScript
    ================================================== -->
    <script type="text/javascript" src="${pageContext.request.contextPath}/assets/js/jquery-1.11.3.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/assets/js/bootstrap.min.js"></script>
</body>
</html>