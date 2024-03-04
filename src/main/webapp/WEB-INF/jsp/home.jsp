<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="com.cogent.model.Candidate"%>
<%@page import="java.util.List"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Java Spring MVC</title>
</head>

<style>
table, th, td {
	border: 2px solid;
	border-style: solid;
	border-collapse: collapse;
	padding: 6px
}
.btn-link {
    border: none;
    outline: none;
    background: none;
    cursor: pointer;
    color: #0000EE;
    padding: 0;
    text-decoration: underline;
    font-family: inherit;
    font-size: inherit;
}
</style>
<body>
	<h1>Candidates</h1>
	<table>
		<tr>
			<th>ID</th>
			<th>Name</th>
			<th>Email</th>
			<th>Rating</th>
			<th>Update</th>
			<th>Delete</th>
		<tr>
			<%
			List<Candidate> candidates = (List<Candidate>) request.getAttribute("candidates");
			for (Candidate c : candidates) {
				out.println("<tr><td>" + c.getId() + "</td>");
				out.println("<td>" + c.getName() + "</td>");
				out.println("<td>" + c.getEmail() + "</td>");
				out.println("<td>" + c.getRating() + "</td>");
				out.println("<td><a href=\"" + c.getId() + "\">Update</a></td>");
				out.println("<td><form action=\"delete\" method=\"post\"><button type=\"submit\" name=\"id\" value="+ c.getId() +" class=\"btn-link\">Delete</button></form></td></tr>");
			}
			%>

		</tr>
	</table>



	<h3>Enter New Candidate</h3>
	<form action="new" method="post"
		enctype="application/x-www-form-urlencoded;charset=UTF-8">
		<input type="text" name="name" placeholder="Enter Name"> <br>
		<input type="text" name="email" placeholder="Enter Email"> <br>
		<input type="text" name="rating" placeholder="Enter Rating"> <br>
		<br> <input type="submit">
	</form>

</body>
</html>