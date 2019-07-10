<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="domain.model.Student" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Confirm Delete</title>
<link rel="stylesheet" href="css/sample.css">
</head>
<body>
<header>
	<div>
		<h1>Confirm Delete</h1>
		
			<%@include file="menu.jspf" %>
			
		</div>
				<img alt="Toscane" src="images/student.jpg">
		
</header>
<main>
<% String naam = (String)request.getAttribute("naam"); %>
<% String voornaam = (String)request.getAttribute("voornaam"); %>
<p id="boodschap">Delete: <%= voornaam %> <%= naam %>?</p>
<form method="POST" action="StudentInfo">
	<input type="hidden" name="command" value="delete" />
	<input type="hidden" name="naam" value="<%= naam %>" />
	<input type="hidden" name="voornaam" value="<%= voornaam %>" />
	<input id="deleteknop" type="submit" value="Delete" />
</form>
</main>

</body>
</html>