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
	<title>Create Schedule Item</title>
</head>
<body>
	<jsp:include page="../fragments/bodyHeader.jsp"/>
	<div id="wrap">
	    <div class="container">
	      <div class="starter-template">
	        <h1>Create new schedule item</h1>      
	        <form:form commandName="scheduleItem">
	        	<form:errors path="*" cssClass="errorblock" element="div" />
	        	<table>
	        		<tr>
	        			<td width="30%" style="vertical-align: middle;">Date: </td>
	        			<td width="30%" style="vertical-align: middle;">
	        				<form:select path="schedule" cssErrorClass="error">
	        					<form:options items="${schedulesList}" itemValue="id" itemLabel="timeStamp"/>
	        				</form:select>
	        			</td>
	        			<td width="40%" style="vertical-align: middle;">
	        				<form:errors path="schedule" cssClass="error" />
	        			</td>       			
	        		</tr>
	        		<tr>
	        			<td width="30%" style="vertical-align: middle;">Group: </td>
	        			<td width="30%" style="vertical-align: middle;">
	        				<form:select path="group" cssErrorClass="error">
	        					<form:options items="${groupsList}" itemValue="id" itemLabel="name"/>
	        				</form:select>
	        			</td>
	        			<td width="40%" style="vertical-align: middle;">
	        				<form:errors path="group" cssClass="error" />
	        			</td>        			
	        		</tr>
	        		<tr>
	        			<td width="30%" style="vertical-align: middle;">Lecturer: </td>
	        			<td width="30%" style="vertical-align: middle;">
	        				<form:select path="lecturer" cssErrorClass="error">
	        					<form:options items="${lecturersList}" itemValue="id" itemLabel="name"/>
	        				</form:select>
	        			</td>
	        			<td width="40%" style="vertical-align: middle;">
	        				<form:errors path="lecturer" cssClass="error" />
	        			</td>       			
	        		</tr>
	        		<tr>
	        			<td width="30%" style="vertical-align: middle;">Classroom: </td>
	        			<td width="30%" style="vertical-align: middle;">
	        				<form:select path="classroom" cssErrorClass="error">
	        					<form:options items="${classroomsList}" itemValue="id" itemLabel="name"/>
	        				</form:select>
	        			</td>
	        			<td width="40%" style="vertical-align: middle;">
	        				<form:errors path="classroom" cssClass="error" />
	        			</td>       			
	        		</tr>
	        		<tr>
	        			<td width="30%" style="vertical-align: middle;">Subject: </td>
	        			<td width="30%" style="vertical-align: middle;">
	        				<form:select path="subject" cssErrorClass="error">
	        					<form:options items="${subjectsList}" itemValue="id" itemLabel="name"/>
	        				</form:select>
	        			</td>
	        			<td width="40%" style="vertical-align: middle;">
	        				<form:errors path="subject" cssClass="error" />
	        			</td>
					</tr>
	        		<tr>
	        			<td width="30%" style="vertical-align: middle;">Lesson Interval: </td>        			
	        			<td width="30%" style="vertical-align: middle;">
	        				<form:select path="lessonInterval" cssErrorClass="error">
	        					<c:forEach items="${lessonIntervalsList}" var="lessonInterval">
	        						<form:option value="${lessonInterval.id}">
	        							<c:out value="${lessonInterval.lessonStart} - ${lessonInterval.lessonFinish}"/>
	        						</form:option>
	        					</c:forEach>
	        				</form:select>
	        			</td>
	        			<td width="40%" style="vertical-align: middle;">
	        				<form:errors path="lessonInterval" cssClass="error" />
	        			</td>
	        		</tr>	        		
	        		<tr>
	        			<td colspan="3">
	        				<input type="submit" class="btn" value="Create"/>
	        			</td>
	        		</tr>
	        	</table>
			</form:form>		
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