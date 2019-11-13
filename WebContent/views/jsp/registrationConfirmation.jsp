<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@include file="header.jsp" %>


<p class="h5">${message}</p>

<a href="${pageContext.request.contextPath}/login">
    <button class="btn-default" value="login" name="Login">Login</button>
</a>

<%@include file="footer.jsp" %>