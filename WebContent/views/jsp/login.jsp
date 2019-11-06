<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login</title>
</head>
<body>
<jsp:include page="header.jsp"/>
<!--<jsp:include page="menu.jsp"/>-->
	<form action= '<spring:url value="/loginAction" />'   method="post">

		<table>
			<tr>
				<td>Username</td>
				<td> <input type="text" name = "username"></td>
			</tr>
			<tr>
				<td>Password</td>
				<td> <input type="password" name = "password"></td>
			</tr>
			<tr>
				<td> <button type="submit">Login</button>   </td>
			</tr>
		</table>

	</form>
	
	<jsp:include page="footer.jsp"/>
</body>
</html>