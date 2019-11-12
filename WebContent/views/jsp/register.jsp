<%@include file="header.jsp" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<h1 class="display-2">${message}</h1>
<form:form id="registrationForm" modelAttribute="userCredentialFormObj"
           action="register" method="POST">
    <table>
        <tr>
            <td>Name:</td>
            <td><input type="text" name="name" placeholder="Enter your name"/></td>
        </tr>
        
        <tr>
            <td>Email:</td>
            <td><input type="text" path="username" name="username" placeholder="Enter your email"/></td>
        </tr>
        <tr>
            <td>Password:</td>
            <td><input type="password" path="password" name="password" placeholder="Enter your password"/></td>
        </tr>
        <tr>
            <td>Confirm Password:</td>
            <td><input type="password" name="confirmPassword" id="confirmPassword" placeholder="Confirm password"/></td>
        </tr>
        <tr>
            <td>
                <button type="submit">Register</button>
            </td>
        </tr>
    </table>
</form:form>


</body>
</html>
