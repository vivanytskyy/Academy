<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
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
	<div id="wrap">	
	    <div class="container">
	      <div class="starter-template">
	        <h1>About project</h1>
	        <p class="lead">
	        	Academy (as extension Institute project) is a simple java web application. My purpose was creating a simplified academy management system.
	        	<br>
	        	List of technologies were applied:
	        </p>
	        <ul>
	        	<li>Java SE;</li>
	        	<li>Apache Tomcat;</li>
	        	<li>Spring Framework (DI, XML and Annotations configuration, Spring MVC);</li>
	        	<li>JPA and Hibernate;</li>
	        	<li>Apache Maven;</li>
	        	<li>JSP (JSTL);</li>
	        	<li>JNDI (Data source obtaining)</li>
	        	<li>Bootstrap</li>
	        </ul>
	        <address>
			  <strong>Vitaliy Ivanytskyy</strong>
			  <br>Odessa, Ukraine<br>
			  <a href="https://github.com/vivanytskyy">Github profile</a>
			</address>
	      </div>                     
	    </div><!-- /.container -->
	    <div id="push"></div>
    </div>
    <jsp:include page="fragments/footer.jsp"/>    
    <!-- Bootstrap core JavaScript
    ================================================== -->
    <script src="${pageContext.request.contextPath}/assets/js/jquery-1.11.3.js"></script>    
    <script src="${pageContext.request.contextPath}/assets/js/bootstrap.min.js"></script>
</body>
</html>