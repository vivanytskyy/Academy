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
	<title>Academy</title>
</head>
<body>
	<jsp:include page="../fragments/bodyHeader.jsp"/>
	<div id="wrap">
	    <div class="container">
	      <div class="starter-template">
	        <h1>Schedule by Group</h1>
	        <p class="lead">
	        	<spring:message code="obtain.schedule.by.group.greeting"/>
	        </p>
			<form:form commandName="scheduleItem">
				<form:errors path="*" cssClass="errorblock" element="div"/>
				<table>
					<tr>
						<td width="30%" style="vertical-align: middle;">Group name: </td>
						<td width="30%" style="vertical-align: middle;">
	        				<form:select path="group" cssErrorClass="error">
	        					<form:options items="${groupsList}" itemValue="id" itemLabel="name"/>
	        				</form:select>
	        			</td>
	        			<td width="40%" style="vertical-align: middle;">
	        				<form:errors path="group" cssClass="error"/>
	        			</td> 
					</tr>
					<tr>
	        			<td width="30%" style="vertical-align: middle;">Date: </td>
	        			<td width="30%" style="vertical-align: middle;">
	        				<form:select path="schedule" cssErrorClass="error">
	        					<form:options items="${schedulesList}" itemValue="id" itemLabel="timeStamp"/>
	        				</form:select>
	        			</td>
	        			<td width="40%" style="vertical-align: middle;">
	        				<form:errors path="schedule" cssClass="error"/>
	        			</td>        			
	        		</tr>
	        		<tr>
	        			<td colspan="3">
	        				<input type="submit" class="btn" value="Find"/>
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