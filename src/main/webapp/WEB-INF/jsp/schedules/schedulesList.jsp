<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<link href="${pageContext.request.contextPath}/assets/css/bootstrap.min.css" type="text/css" rel="stylesheet">
	<!-- Custom styles for this template -->
	<link href="${pageContext.request.contextPath}/assets/css/offcanvas.css" type="text/css" rel="stylesheet">
	<title>Schedules</title>
</head>
<body>
	<jsp:include page="../fragments/bodyHeader.jsp"/>
	<div class="container">
		<div class="starter-template">
			<h1>Schedules list</h1>
			<table>
				<tr>
					<th width="30%" style="vertical-align: middle;">Date</th>
					<th width="40%" style="vertical-align: middle;" colspan="3">Available actions</th>
					<th width="50%" style="vertical-align: middle;">
						<a href="create.html">Create new schedule</a>
					</th>
				</tr>
				<c:forEach items="${schedules}" var="schedule">
					<tr>
						<td><fmt:formatDate value="${schedule.timeStamp}" pattern="dd-MM-yyyy"/></td>
						<td>
							<form action="<c:url value='/schedules/${schedule.id}/edit'/>" method="GET">
								<a data-toggle="tooltip" class="my-tool-tip" data-placement="top" title="Edit">
									<button type="submit" class="btn btn-default btn-md">
										<span>Edit</span>
									</button>
								</a>
							</form>
						</td>
						<td>
							<form action="<c:url value='/schedules/${schedule.id}/delete'/>" method="GET">
								<a data-toggle="tooltip" class="my-tool-tip" data-placement="top" title="Delete">
									<button type="submit" class="btn btn-default btn-md">
										<span>Delete</span>
									</button>
								</a>
							</form>
						</td>
						<td>
							<form action="<c:url value='/schedules/${schedule.id}/scheduleitemslist'/>" method="GET">
								<a data-toggle="tooltip" class="my-tool-tip" data-placement="top" title="Schedule items list">
									<button type="submit" class="btn btn-default btn-md">
										<span>Schedule items list</span>
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