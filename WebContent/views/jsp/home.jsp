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
<jsp:include page="menu.jsp"/>

Welcome ${credential.appUser.name}!
<br>

<br>
Username: ${credential.username}
<br>
Password: ${credential.password}
<br>
This is an authenticated homepage!
</body>
</html>