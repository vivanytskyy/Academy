<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<link href="${pageContext.request.contextPath}/assets/css/bootstrap.min.css" type="text/css" rel="stylesheet">
	<!-- Custom styles for this template -->
    <link href="${pageContext.request.contextPath}/assets/css/offcanvas.css" type="text/css" rel="stylesheet">  
	<title>Academy</title>
</head>
<body>
	<jsp:include page="fragments/bodyHeader.jsp"/>	
    <div class="container">
      <div class="starter-template">
        <h1>Academy</h1>
        <p class="lead">
        	<spring:message code="academy.greeting"/>
        </p>
      </div>                     
    </div><!-- /.container -->    
    <jsp:include page="fragments/footer.jsp"/>
    <!-- Bootstrap core JavaScript
    ================================================== -->    
    <script src="${pageContext.request.contextPath}/assets/js/jquery-1.11.3.js"></script>    
    <script src="${pageContext.request.contextPath}/assets/js/bootstrap.min.js"></script>
</body>
</html>