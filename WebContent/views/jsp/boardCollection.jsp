<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<jsp:include page="header.jsp"/>

This is your boardCollection!
<br><br>
<a href="createBoard">Create a Board </a> 
<br>
<%-- <a href="viewBoards">View Boards</a> //should see boards on this page with options --%>

<jsp:include page="footer.jsp"/>
</body>
</html>