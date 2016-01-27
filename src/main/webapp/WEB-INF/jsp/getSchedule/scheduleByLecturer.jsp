<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<link href="${pageContext.request.contextPath}/assets/css/bootstrap.min.css" rel="stylesheet">
	<!-- Custom styles for this template -->
    <link href="${pageContext.request.contextPath}/assets/css/offcanvas.css" rel="stylesheet">
    <style type="text/css">
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
	<title>Academy</title>
</head>
<body>
	<jsp:include page="../fragments/bodyHeader.jsp"/>
    <div class="container">
      <div class="starter-template">
        <h1>Schedule by Lecturer</h1>        
        <p class="lead">
        	<spring:message code="obtain.schedule.by.lecturer.greeting"/>
        </p>
		<form:form commandName="scheduleItem">
			<form:errors path="*" cssClass="errorblock"/>
			<table>
				<tr>
					<td width="25%" style="vertical-align: middle;">Lecturer name: </td>
					<td width="75%" style="vertical-align: middle;">
        				<form:select path="lecturer">
        					<form:options items="${lecturersList}" itemValue="id" itemLabel="name"/>
        				</form:select>
        			</td> 
				</tr>
				<tr>
        			<td width="25%" style="vertical-align: middle;">Date: </td>
        			<td width="75%" style="vertical-align: middle;">
        				<form:select path="schedule">
        					<%-- <form:option value="-" label="--Please Select"/> --%>
        					<form:options items="${schedulesList}" itemValue="id" itemLabel="timeStamp"/>
        				</form:select>
        			</td>        			
        		</tr>
        		<tr>
        			<td colspan="2">
        				<input type="submit" class="btn" value="Find"/>
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