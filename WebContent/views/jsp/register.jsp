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
	You've reached to the subscription page!

    <div></div>
    <form:form name="userRegistrationForm" id="userCredentialForm" modelAttribute="userCredentialFormObj"
           action="${pageContext.request.contextPath}/processUserCredential" method="post">
    

		<table>
			<tr>
				<td><label>First Name:</label></td>
				<td><input type="text" name="name" placeholder="First Name" /></td>
				<%-- <td><form:errors path="name" cssClass="error"></form:errors></td>--%>
			</tr>
			<tr>
				<td><form:label path="username"/>Email:</td>
				<td><form:input type="text" path="username" name="username" id="username" placeholder="Email" /></td>

			</tr>
			<tr>
				<td><form:label path="password" /> Password:</td>
				<td><form:password path="password" name="password" id="password" placeholder="Password" /></td>
			</tr>

			<tr>
				<td><label>Password</label></td>
				<td><input type="password" name="confPassword" id="password"
					placeholder="Confirm Password" /></td>
			</tr>
			<tr>
				<td></td>
				<td><button name="submit" value="submit" id="submit">Submit</button></td> <%--Setup register link --%>
			</tr>
		</table>
	</form:form>


	<jsp:include page="footer.jsp" />
</body>
</html>