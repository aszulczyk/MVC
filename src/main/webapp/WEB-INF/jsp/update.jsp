<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="com.cogent.model.Candidate"%>
<%@page import="java.util.List"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Updating Candidate</title>
</head>
<body>
	<h3>Show Candidate</h3>
	<%Candidate can = (Candidate) request.getAttribute("can");%>
	<form action="update" method="post"
		enctype="application/x-www-form-urlencoded;charset=UTF-8">
		<input type="hidden" name="id" value="<%=can.getId()%>"> <br>
		<input type="text" name="name" placeholder="<%=can.getName()%>"> <br>
		<input type="text" name="email" placeholder="<%=can.getEmail()%>"> <br>
		<input type="text" name="rating" placeholder="<%=can.getRating()%>"> <br>
		<br> <input type="submit">
	</form>
	

</body>
</html>