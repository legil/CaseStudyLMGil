<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<jsp:include page="header.jsp" />

	Board Collection!
	<br>
	<br>

	<h1>Employees List</h1>
	<table border="2" width="70%" cellpadding="2">
		<tr>
			<th>Category</th>
			<th>Description</th>
			<th>Last updated</th>
			
		</tr>
		<c:forEach var="emp" items="${list}">
			<tr>
				<td><a>My School Project</a></td>
				<td>For Photoshop class</td>
				<td> Last updated: 13-Nov-19 2:03pm</td>
				
				<td style="border: none;"><a href="editemp/#">Edit</a></td>
				<td style="border: none;"><a href="deleteemp/#">Delete</a></td>
			</tr>
			<tr>
				<td><a>Piano Songs To Try</a></td>
				<td>Learning piano</td>
				<td> Last updated: 12-Nov-19 7:10pm</td>
				<td style="border: none;"><a href="editemp/#">Edit</a></td>
				<td style="border: none;"><a href="deleteemp/#">Delete</a></td>
			</tr>
		</c:forEach>
	</table>
	<br />


	<a href="createBoard">Create a Board </a>
	<br>
	<%-- <a href="viewBoards">View Boards</a> //should see boards on this page with options --%>

	<jsp:include page="footer.jsp" />
</body>
</html>