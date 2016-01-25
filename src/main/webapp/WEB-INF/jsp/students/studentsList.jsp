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
	<title>Students</title>
</head>
<body>
	<jsp:include page="../fragments/bodyHeader.jsp"/>
	<div class="container">
		<div class="starter-template">
			<h1>Students list</h1>
			<table>
				<tr>
					<th width="30%" style="vertical-align: middle;">Name</th>
					<th width="30%" style="vertical-align: middle;">Group</th>
					<th width="20%" style="vertical-align: middle;" colspan="2">Available actions</th>
					<th width="20%" style="vertical-align: middle;">
						<a href="create.html">Create new student</a>
					</th>
				</tr>
				<c:forEach items="${students}" var="student">
					<tr>
						<td>${student.name}</td>
						<td>${student.group.name}</td>
						<td>
							<form action="<c:url value='/students/${student.id}/edit'/>" method="GET">
								<a data-toggle="tooltip" class="my-tool-tip" data-placement="top" title="Edit">
									<button type="submit" class="btn btn-default btn-md" > 
										<span>Edit</span>
									</button>
								</a>
							</form>
						</td>
						<td>
							<form action="delete.html" method="POST">
								<a data-toggle="tooltip" class="my-tool-tip" data-placement="top" title="Delete">
									<button type="submit" name="id" value="${student.id}" class="btn btn-default btn-md" > 
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
    <script type="text/javascript" src="${pageContext.request.contextPath}/assets/js/jquery-1.11.3.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/assets/js/bootstrap.min.js"></script>
</body>
</html>