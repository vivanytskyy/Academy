<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<link href="${pageContext.request.contextPath}/assets/css/bootstrap.min.css" type="text/css" rel="stylesheet">
	<!-- Custom styles for this template -->
    <link href="${pageContext.request.contextPath}/assets/css/offcanvas.css" type="text/css" rel="stylesheet"> 
	<title>Classrooms</title>
</head>
<body>
	<jsp:include page="../fragments/bodyHeader.jsp"/>
    <div class="container">
      <div class="starter-template">
        <h1>Classrooms list</h1>
		<table>
			<tr>
				<th width="30%" style="vertical-align: middle;">Name</th>
				<th width="40%" style="vertical-align: middle;" colspan="2">Available actions</th>
				<th width="50%" style="vertical-align: middle;">
					<a href="create.html">Create new classroom</a>
				</th>
			</tr>
			<c:forEach items="${classrooms}" var="classroom">
				<tr>
					<td>${classroom.name}</td>
					<td>
						<form action="<c:url value='/classrooms/${classroom.id}/edit' />" method="GET">
							<a data-toggle="tooltip" class="my-tool-tip" data-placement="top" title="Edit">
								<button type="submit" class="btn btn-default btn-md">
									<span>Edit</span>
								</button>
							</a>
						</form>
					</td>
					<td>
						<form action="delete.html" method="POST">
							<a data-toggle="tooltip" class="my-tool-tip" data-placement="top" title="Delete">
								<button type="submit" name="id" value="${classroom.id}" class="btn btn-default btn-md">
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