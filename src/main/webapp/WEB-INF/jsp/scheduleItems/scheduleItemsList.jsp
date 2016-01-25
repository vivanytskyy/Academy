<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<link href="${pageContext.request.contextPath}/assets/css/bootstrap.min.css" rel="stylesheet">
	<!-- Custom styles for this template -->
	<link href="${pageContext.request.contextPath}/assets/css/offcanvas.css" rel="stylesheet">
	<title>Schedule Items</title>
</head>
<body>
	<jsp:include page="../fragments/bodyHeader.jsp"/>
	<div class="container">
		<div class="starter-template">
			<h1>Schedule items list</h1>
			<table>
				<tr>
					<th width="5%" style="vertical-align: middle;">ID</th>
					<th width="10%" style="vertical-align: middle;">Date</th>
					<th width="10%" style="vertical-align: middle;">Group</th>										
					<th width="10%" style="vertical-align: middle;">Lecturer</th>
					<th width="10%" style="vertical-align: middle;">Classroom</th>
					<th width="10%" style="vertical-align: middle;">Subject</th>
					<th width="10%" style="vertical-align: middle;">Lesson Interval</th>
					<th width="20%" style="vertical-align: middle;" colspan="2">Available actions</th>
					<th width="20%" style="vertical-align: middle;">
						<a href="create.html">Create new schedule item</a>
					</th>
				</tr>
				<c:forEach items="${scheduleItems}" var="scheduleItem">
					<tr>
						<td>${scheduleItem.id}</td>
						<td><fmt:formatDate value="${scheduleItem.schedule.timeStamp}" pattern="dd-MM-yyyy"/></td>
						<td>${scheduleItem.group.name}</td>
						<td>${scheduleItem.lecturer.name}</td>
						<td>${scheduleItem.classroom.name}</td>
						<td>${scheduleItem.subject.name}</td>
						<td>${scheduleItem.lessonInterval.lessonStart} - ${scheduleItem.lessonInterval.lessonFinish}</td>
						<td>
							<form action="<c:url value='/scheduleitems/${scheduleItem.id}/edit'/>" method="GET">
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
									<button type="submit" name="id" value="${scheduleItem.id}" class="btn btn-default btn-md" > 
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