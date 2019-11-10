<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!doctype html>
<html lang="en">
  <head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">

    <!-- Regular CSS comes after bootstrap CSS -->
    <link rel="stylesheet" type="text/css" href="css/goodVibes.css">

    <!-- This is needed in order to use font awesome -->
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.6.3/css/all.css" integrity="sha384-UHRtZLI+pbxtHCWp1t77Bi1L4ZtiqrqD80Kn4Z8NTSRyMA2Fd33n5dQ8lWUE00s/" crossorigin="anonymous">

    <title>PinBoard: All the links in One Place!</title>
  </head>
  
  <body>
    
    <!-- Start of Navbar -->
  <nav class="navbar navbar-expand-sm navbar-dark bg-dark">
    <a href="${pageContext.request.contextPath}/" class="navbar-brand"><i class="fas fa-map-pin mr-2"></i>Pinboard</a>
     <div class="container justify-content-start">
        <ul class="nav navbar-nav">
            <li class="nav-item">
                <a class="nav-link" href="${pageContext.request.contextPath}/">Home</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="#">About</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="${pageContext.request.contextPath}/contactus">Contact</a>
            </li>
        </ul>
    </div>
    <div class="container justify-content-end">
        <ul class="nav navbar-nav">
            <li class="nav-item">
            	<c:if test="${pageContext.request.userPrincipal.name == null}">
                <a class="nav-link" href="${pageContext.request.contextPath}/login">Login</a>
                </c:if>
            </li>
            <li class="nav-item">
            <c:if test="${pageContext.request.userPrincipal.name == null}">
                <a class="nav-link" href="${pageContext.request.contextPath}/register">Register</a>
            </c:if>
            </li>
            
            <li class="nav-item">
            <c:if test="${pageContext.request.userPrincipal.name != null}">
                <a class="nav-link" href="${pageContext.request.contextPath}/logout">Logout</a>
            </c:if>
            </li>
        </ul>
    </div>
</nav>
  <!-- End of Navbar -->