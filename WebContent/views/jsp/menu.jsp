<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<div>
		<a href="${pageContext.request.contextPath}/">Home</a> | &nbsp;
		<a href="${pageContext.request.contextPath}/admin">Admin</a> | &nbsp;
		<a href="${pageContext.request.contextPath}/subscriber">Subscriber</a> | &nbsp;
		<a href="${pageContext.request.contextPath}/all">All</a> | &nbsp;
		<a href="${pageContext.request.contextPath}/contactus">Contact Us</a> | &nbsp;
		<c:if test="${pageContext.request.userPrincipal.name == null}">
			<a href="${pageContext.request.contextPath}/login">Login</a> &nbsp;
		</c:if>
		<c:if test="${pageContext.request.userPrincipal.name != null}">
			<a href="${pageContext.request.contextPath}/logout">Logout</a> &nbsp;
		</c:if>
	</div>
	<br>
	<!--<img src="<c:url value='images/logo.jpg'/>"/> -->
	<br>
</body>
</html>