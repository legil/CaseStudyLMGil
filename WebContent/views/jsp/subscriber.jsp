<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Subscriber Page</title>
</head>
<body>
	<jsp:include page="header.jsp" />
	<jsp:include page="menu.jsp" />
	You've reached to the subscription page!

	<form action="main.jsp" method="GET">

		<table>
			<tr>
				<td><label>First Name: </label></td>
				<td><input type="text" placeholder="First Name" /></td>
				<%-- <td><form:errors path="name" cssClass="error"></form:errors></td>--%>
			</tr>
			<tr>
				<td><label>Email: </label></td>
				<td><input type="text" placeholder="Email" /></td>

			</tr>
			<tr>
				<td><label>Password: </label></td>
				<td><input type="password" placeholder="Email" /></td>

			</tr>
			<tr>
				<td><label>Password</label></td>
				<td><input type="password" name="confPassword" id="password"
					placeholder="Confirm Password" /></td>
			</tr>
			<tr>
				<td></td>
				<td><button name="Login" id="Login">Login</button></td>
			</tr>
		</table>
	</form>


	<jsp:include page="footer.jsp" />
</body>
</html>