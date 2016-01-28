<%@ page language="java" contentType="text/html; UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<link href="${pageContext.request.contextPath}/assets/css/bootstrap.min.css" type="text/css" rel="stylesheet">
	<!-- Custom styles for this template -->
	<link href="${pageContext.request.contextPath}/assets/css/offcanvas.css" type="text/css" rel="stylesheet">
	<title>Schedule content</title>
</head>
<body>
	<jsp:include page="../fragments/bodyHeader.jsp"/>
	<div id="wrap">
		<div class="container">
			<div class="starter-template">
				<h1>Schedule content</h1>
				<p class="lead">Schedule date: 
					<fmt:formatDate value="${schedule.timeStamp}" pattern="dd-MM-yyyy"/>
				</p>
				<table>
					<tr>
						<th width="10%" style="vertical-align: middle;">ID</th>
						<th width="10%" style="vertical-align: middle;">Group</th>										
						<th width="10%" style="vertical-align: middle;">Lecturer</th>
						<th width="10%" style="vertical-align: middle;">Classroom</th>
						<th width="10%" style="vertical-align: middle;">Subject</th>
						<th width="10%" style="vertical-align: middle;">Lesson Interval</th>
						<th width="20%" style="vertical-align: middle;">Available actions</th>
					</tr>
					<c:forEach items="${schedule.scheduleItems}" var="scheduleItem">
						<tr>
							<td>${scheduleItem.id}</td>
							<td>${scheduleItem.group.name}</td>
							<td>${scheduleItem.lecturer.name}</td>
							<td>${scheduleItem.classroom.name}</td>
							<td>${scheduleItem.subject.name}</td>
							<td>${scheduleItem.lessonInterval.lessonStart} - ${scheduleItem.lessonInterval.lessonFinish}</td>
							<td>
								<form action="<c:url value='/scheduleitems/delete.html'/>" method="POST">
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
		<div id="push"></div>
	</div>
	<jsp:include page="../fragments/footer.jsp"/>
	<!-- Bootstrap core JavaScript
    ================================================== -->
    <script src="${pageContext.request.contextPath}/assets/js/jquery-1.11.3.js"></script>    
    <script src="${pageContext.request.contextPath}/assets/js/bootstrap.min.js"></script>
</body>
</html>