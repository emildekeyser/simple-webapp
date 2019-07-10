<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList" %>
<%@ page import="domain.model.Student" %>

<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="css/sample.css">
<meta charset="UTF-8">
<title>Student Formulier</title>
</head>
<body>
	<header>
		<div>
			<h1>Studenten registratie</h1>
			
			<%@include file="menu.jspf" %>
			
		</div>
		<img alt="Toscane" src="images/student.jpg">

	</header>
	
	<% ArrayList<String> errors = (ArrayList<String>)request.getAttribute("errors"); %>
	<% Student student = (Student) request.getAttribute("student"); %>
	<% String leeftijd = (String) request.getAttribute("leeftijd"); %>

	<main id="container">
	<article>
		<h2>Voeg een student toe</h2>
		<%if(errors != null){ %>
			<ul class="errors">
			<%for(String e : errors){ %>
				<li><%=e %></li>
			<%} %>
			</ul>
		<%} %>
		<form method="POST" action="StudentInfo?command=add" novalidate>
			<fieldset>
				<legend>Student informatie</legend>
				<p class="form-group">
					<label class="control-label" for="name">Naam: </label> <input
						id="naam" name="naam" type="text" value="<%=student == null ? "" : student.getNaam() %>" required>
				</p>
				<p class="form-group">
					<label class="control-label" for="name">Voornaam: </label> <input
						id="voornaam" name="voornaam" type="text" value="<%=student == null ? "" : student.getVoornaam() %>">
				</p>
				<p class="form-group">
					<label class="control-label" for="name">Leeftijd: </label> <input
						id="leeftijd" name="leeftijd" type="text" value="<%=leeftijd == null ? "" : leeftijd %>">
				</p>
				<p class="form-group">
					<label class="control-label" for="name">Studierichting: </label> <input
						id="studierichting" name="studierichting" type="text" value="<%=student == null ? "" : student.getStudierichting()%>">
				</p>
			</fieldset>
			<p>
				<label for="bewaar">&nbsp;</label> <input id="bewaar" type="submit"
					value="Voeg Student Toe">
			</p>

		</form>
	</article>
	</main>
</body>
</html>