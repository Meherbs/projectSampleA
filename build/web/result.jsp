<%@page import="edu.umsl.java.web.PrimeFact"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Result Page</title>
</head>
<body>
    <a href="/start" >Back to Home</a><br /><br />
    
    <% PrimeFact primeFact = (PrimeFact) request.getAttribute("data"); %>
    <%= primeFact.getDecomposedResult() %>
</body>
</html>