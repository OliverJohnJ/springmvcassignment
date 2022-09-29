<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Employee Details</title>
</head>
<body>
<h1>Employee Details</h1>
</br></br>
<% Object rs=request.getAttribute("employee");%>
<h1><%= rs%></h1>
<br><br>
<a href="/assignmentapp">click here to index</a>
</body>
</html>