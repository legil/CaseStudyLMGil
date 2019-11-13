<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Welcome Home!</title>
</head>
<body>
<jsp:include page="header.jsp"/>


Welcome ${credential.user.name}!
<br>

<br>
Username: ${credential.username} <%--maintain a session? --%>
<br>
Password: ${credential.password}
<br>
This is an authenticated homepage!

<br>
<br>
<a href="${pageContext.request.contextPath}/boards">My Boards</a>

<jsp:include page="footer.jsp"/>
</body>
</html>