<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
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
	<title>Create Schedule Item</title>
</head>
<body>
	<jsp:include page="../fragments/bodyHeader.jsp"/>
    <div class="container">
      <div class="starter-template">
        <h1>Create new schedule item</h1>      
        <form:form commandName="scheduleItem">
        	<form:errors path="*" cssClass="errorblock" element="div" />
        	<table>
        		<tr>
        			<td width="25%" style="vertical-align: middle;">Date: </td>
        			<td width="75%" style="vertical-align: middle;" colspan="3">
        				<form:select path="schedule">
        					<%-- <form:option value="-" label="--Please Select"/> --%>
        					<form:options items="${schedulesList}" itemValue="id" itemLabel="timeStamp"/>
        				</form:select>
        			</td>        			
        		</tr>
        		<tr>
        			<td width="25%" style="vertical-align: middle;">Group: </td>
        			<td width="75%" style="vertical-align: middle;" colspan="3">
        				<%-- <form:input path="group.name" cssErrorClass="error"/>
        				<form:errors path="name" cssClass="error" />
        				<form:errors path="*" cssClass="error" /> --%>
        				<form:select path="group">
        					<%-- <form:option value="-" label="--Please Select"/> --%>
        					<form:options items="${groupsList}" itemValue="id" itemLabel="name"/>
        				</form:select>
        			</td>        			
        		</tr>
        		<tr>
        			<td width="25%" style="vertical-align: middle;">Lecturer: </td>
        			<td width="75%" style="vertical-align: middle;" colspan="3">
        				<form:select path="lecturer">
        					<%-- <form:option value="-" label="--Please Select"/> --%>
        					<form:options items="${lecturersList}" itemValue="id" itemLabel="name"/>
        				</form:select>
        			</td>        			
        		</tr>
        		<tr>
        			<td width="25%" style="vertical-align: middle;">Classroom: </td>
        			<td width="75%" style="vertical-align: middle;" colspan="3">
        				<form:select path="classroom">
        					<%-- <form:option value="-" label="--Please Select"/> --%>
        					<form:options items="${classroomsList}" itemValue="id" itemLabel="name"/>
        				</form:select>
        			</td>        			
        		</tr>
        		<tr>
        			<td width="25%" style="vertical-align: middle;">Subject: </td>
        			<td width="75%" style="vertical-align: middle;" colspan="3">
        				<form:select path="subject">
        					<%-- <form:option value="-" label="--Please Select"/> --%>
        					<form:options items="${subjectsList}" itemValue="id" itemLabel="name"/>
        				</form:select>
        			</td>        			
        		</tr>
        		<tr>
        			<td width="25%" style="vertical-align: middle;">Lesson Start: </td>        			
        			<td width="25%" style="vertical-align: middle;">
        				<form:select path="lessonInterval">
        					<%-- <form:option value="-" label="--Please Select"/> --%>
        					<form:options items="${lessonIntervalsList}" itemValue="id" itemLabel="lessonStart"/>
        				</form:select>
        			</td>
        			<td width="25%" style="vertical-align: middle;">Lesson Finish: </td>        			
        			<td width="25%" style="vertical-align: middle;">
        				<%-- <form:select path="lessonInterval">
        					<form:option value="-" label="--Please Select"/>
        					<form:options items="${lessonIntervalsList}" itemValue="id" itemLabel="lessonFinish"/>
        				</form:select> --%>
        			</td>         			
        		</tr>	        		
        		<tr>
        			<td colspan="4">
        				<input type="submit" class="btn" value="Create"/>
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