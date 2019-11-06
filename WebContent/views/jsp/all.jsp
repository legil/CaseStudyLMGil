<%@ taglib uri="http://www.springframework.org/security/tags"
	prefix="sec"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>All Page</title>
</head>
<body>
	<jsp:include page="menu.jsp" />
	<sec:authorize access="hasRole('ADMIN')">
		<p>Only Admin Can See</p>
	</sec:authorize>
	<sec:authorize access="hasRole('USER')">
		<p>Only User Can See</p>
	</sec:authorize>
	
	<p>Everyone can see</p>
</body>
</html>