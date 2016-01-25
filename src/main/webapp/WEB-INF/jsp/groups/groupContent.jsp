<%@ page language="java" contentType="text/html; UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<link href="${pageContext.request.contextPath}/assets/css/bootstrap.min.css" rel="stylesheet">
	<!-- Custom styles for this template -->
	<link href="${pageContext.request.contextPath}/assets/css/offcanvas.css" rel="stylesheet">
	<title>Group content</title>
</head>
<body>
	<jsp:include page="../fragments/bodyHeader.jsp"/>
	<div class="container">
		<div class="starter-template">
			<h1>Group content</h1>
			<p class="lead">Group name: ${group.name}</p>
			<table>
				<tr>
					<th width="30%" style="vertical-align: middle;">Student name</th>
					<th width="40%" style="vertical-align: middle;">Available actions</th>
				</tr>
				<c:forEach items="${group.students}" var="student">
					<tr>
						<td>${student.name}</td>
						<td>
    						<form action="<c:url value='/students/delete.html'/>" method="POST">
    							<a data-toggle="tooltip" class="my-tool-tip" data-placement="top" title="Delete">
									<button type="submit" name="id" value="${student.id}" class="btn btn-default btn-md">
										<span>Delete</span>
									</button>
								</a>
    						</form>   
						</td>
					</tr>
				</c:forEach>
			</table>
		</div>
	</div><!-- /.container -->
	<jsp:include page="../fragments/footer.jsp"/>
	<!-- Bootstrap core JavaScript
    ================================================== -->
    <script src="${pageContext.request.contextPath}/assets/js/jquery-1.11.3.js"></script>    
    <script src="${pageContext.request.contextPath}/assets/js/bootstrap.min.js"></script>
</body>
</html>