<%@include file="header.jsp" %>


<p class="h2">${message}</p>

<a href="${pageContext.request.contextPath}/login">
    <button class="btn-danger" value="login" name="Login">Login</button>
</a>

<%@include file="footer.jsp" %>