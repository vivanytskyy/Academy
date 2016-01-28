<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<link href="${pageContext.request.contextPath}/assets/css/bootstrap.min.css" type="text/css" rel="stylesheet">
	<!-- Custom styles for this template -->
    <link href="${pageContext.request.contextPath}/assets/css/offcanvas.css" type="text/css" rel="stylesheet">
    <title>Edit Schedule Item</title>
</head>
<body>
	<jsp:include page="../fragments/bodyHeader.jsp"/>
    <div class="container">
      <div class="starter-template">
        <h1>Edit the schedule item</h1>      
        <form:form commandName="scheduleItem">
        	<form:errors path="*" cssClass="errorblock" element="div" />
        	<table>
        		<tr>
        			<td width="25%" style="vertical-align: middle;">Date: </td>
        			<td width="75%" style="vertical-align: middle;">
        				<form:select path="schedule">
        					<form:option value="${scheduleItem.schedule.id}">
        						<fmt:formatDate value="${scheduleItem.schedule.timeStamp}" pattern="dd-MM-yyyy"/>
        					</form:option>
        					<form:options items="${schedulesList}" itemValue="id" itemLabel="timeStamp"/>
        				</form:select>
        			</td>        			
        		</tr>
        		<tr>
        			<td width="25%" style="vertical-align: middle;">Group: </td>
        			<td width="75%" style="vertical-align: middle;">
        				<form:select path="group">
        					<form:option value="${scheduleItem.group.id}" label="${scheduleItem.group.name}"/>
        					<form:options items="${groupsList}" itemValue="id" itemLabel="name"/>
        				</form:select>
        			</td>        			
        		</tr>
        		<tr>
        			<td width="25%" style="vertical-align: middle;">Lecturer: </td>
        			<td width="75%" style="vertical-align: middle;">
        				<form:select path="lecturer">
        					<form:option value="${scheduleItem.lecturer.id}" label="${scheduleItem.lecturer.name}"/>
        					<form:options items="${lecturersList}" itemValue="id" itemLabel="name"/>
        				</form:select>
        			</td>        			
        		</tr>
        		<tr>
        			<td width="25%" style="vertical-align: middle;">Classroom: </td>
        			<td width="75%" style="vertical-align: middle;">
        				<form:select path="classroom">
        					<form:option value="${scheduleItem.classroom.id}" label="${scheduleItem.classroom.name}"/>
        					<form:options items="${classroomsList}" itemValue="id" itemLabel="name"/>
        				</form:select>
        			</td>        			
        		</tr>
        		<tr>
        			<td width="25%" style="vertical-align: middle;">Subject: </td>
        			<td width="75%" style="vertical-align: middle;">
        				<form:select path="subject">
        					<form:option value="${scheduleItem.subject.id}" label="${scheduleItem.subject.name}"/>
        					<form:options items="${subjectsList}" itemValue="id" itemLabel="name"/>
        				</form:select>
        			</td>        			
        		</tr>
        		<tr>
        			<td width="25%" style="vertical-align: middle;">Lesson Interval: </td>        			
        			<td width="75%" style="vertical-align: middle;">
        				<form:select path="lessonInterval">
        					<form:option value="${scheduleItem.lessonInterval.id}">
        						<c:out value="${scheduleItem.lessonInterval.lessonStart} - ${scheduleItem.lessonInterval.lessonFinish}"/>
        					</form:option>
        					<c:forEach items="${lessonIntervalsList}" var="lessonInterval">
        						<form:option value="${lessonInterval.id}">
        							<c:out value="${lessonInterval.lessonStart} - ${lessonInterval.lessonFinish}"/>
        						</form:option>
        					</c:forEach>
        				</form:select>
        			</td>       			
        		</tr>	        		
        		<tr>
        			<td colspan="2">
        				<input type="submit" class="btn" value="Edit"/>
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