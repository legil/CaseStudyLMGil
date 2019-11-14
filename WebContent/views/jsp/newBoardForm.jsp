<jsp:include page="header.jsp"/>

<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>    
  
        <h1>Create a New Board</h1>  
       <form:form method="post"  modelAttribute="newBoardForm">    
        <table >    
         <tr>    
          <td>Board Title: </td>   
          <td><form:input path="title"  type="text"/></td>  
         </tr>    
         <tr>    
          <td>Description:</td>    
          <td><form:input path="description" type = "text"/></td>  
         </tr> 
         <tr>    
          <td> </td>    
          <td><input type="submit" value="Save" /></td>    
         </tr>     
        </table>    
       </form:form>    
<jsp:include page="footer.jsp"/>