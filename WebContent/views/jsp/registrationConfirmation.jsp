<%@include file="header.jsp" %>


<h1 class="display-2">${message}</h1>

<a href="${pageContext.request.contextPath}/login">
    <button class="btn-danger" value="login" name="Login">Login</button>
</a>

<%@include file="footer.jsp" %>