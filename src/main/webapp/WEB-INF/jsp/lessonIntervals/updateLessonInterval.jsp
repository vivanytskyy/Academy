<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<link href="${pageContext.request.contextPath}/assets/css/bootstrap.min.css" rel="stylesheet">
	<!-- Custom styles for this template -->
    <link href="${pageContext.request.contextPath}/assets/css/offcanvas.css" rel="stylesheet">
    <style>
		.error {
			color: #ff0000;
		}		
		.errorblock {
			color: #000;
			background-color: #ffEEEE;
			border: 3px solid #ff0000;
			padding: 8px;
			margin: 16px;
		}
	</style>  
	<title>Edit Lesson Interval</title>
</head>
<body>
	<jsp:include page="../fragments/bodyHeader.jsp"/>
		<div class="container">
			<div class="starter-template">
				<h1>Edit the lesson interval</h1>
				<form:form commandName="lessonInterval">
					<form:errors path="*" cssClass="errorblock" element="div"/>
					<table>
						<tr>
							<td width="50%" style="vertical-align: middle;">Lesson start</td>
							<td width="50%" style="vertical-align: middle;">
								<form:input path="lessonStart" cssErrorClass="error"/>
								<form:errors path="lessonStart" cssClass="error"/>
							</td>
						</tr>
						<tr>
							<td width="50%" style="vertical-align: middle;">Lesson finish</td>
							<td width="50%" style="vertical-align: middle;">
								<form:input path="lessonFinish" cssErrorClass="error"/>
								<form:errors path="lessonFinish" cssClass="error"/>
							</td>
						</tr>
						<tr>
							<td colspan="2">
								<input type="submit" class="btn" value="Edit">
							</td>
						</tr>
					</table>				
				</form:form>
			</div>                     
    </div><!-- /.container -->
    <jsp:include page="../fragments/footer.jsp"/>
    <!-- Bootstrap core JavaScript
    ================================================== -->
    <script src="${pageContext.request.contextPath}/assets/js/jquery-1.11.3.js"></script>    
    <script src="${pageContext.request.contextPath}/assets/js/bootstrap.min.js"></script>
</body>
</html>