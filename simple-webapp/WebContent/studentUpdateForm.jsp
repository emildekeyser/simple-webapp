<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList" %>
<%@ page import="domain.model.Student" %>

<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="css/sample.css">
<meta charset="UTF-8">
<title>Student Update Formulier</title>
</head>
<body>
	<header>
		<div>
			<h1>Studenten Update</h1>
			
			<%@include file="menu.jspf" %>
			
		</div>
		<img alt="Toscane" src="images/student.jpg">

	</header>
	
	<% ArrayList<String> errors = (ArrayList<String>)request.getAttribute("errors"); %>
	<% Student student = (Student) request.getAttribute("student"); %>
	<%-- <% Integer leeftijd = 0; %> --%>
	<%-- <% try { leeftijd = Integer.parseInt((String)request.getAttribute("leeftijd")); } catch(Exception e) {} %> --%>
	
	<main id="container">
	<article>
		<h2>Pas student gegevens aan</h2>
		<%if(errors != null){ %>
			<ul class="errors">
			<%for(String e : errors){ %>
				<li><%=e %></li>
			<%} %>
			</ul>
		<%} %>
		<form method="POST" action="StudentInfo?command=update" novalidate>
			<fieldset>
				<legend>Student informatie</legend>
				<p class="form-group">
					<label class="control-label" for="name">Naam: </label> <input
						id="naam" name="naam" type="text" value="<%=student == null ? "" : student.getNaam() %>" readonly>
				</p>
				<p class="form-group">
					<label class="control-label" for="name">Voornaam: </label> <input
						id="voornaam" name="voornaam" type="text" value="<%=student == null ? "" : student.getVoornaam() %>">
				</p>
				<p class="form-group">
					<label class="control-label" for="name">Leeftijd: </label> <input
						id="leeftijd" name="leeftijd" type="text" value="<%=student == null ? "" : student.getLeeftijd() %>">
				</p>
				<p class="form-group">
					<label class="control-label" for="name">Studierichting: </label> <input
						id="studierichting" name="studierichting" type="text" value="<%=student == null ? "" : student.getStudierichting()%>">
				</p>
			</fieldset>
			<p>
				<input id="update" name="update" type="submit" value="Update">
				<!-- <input id="cancel" name="cancel" type="submit" value="Cancel"> -->
				<a id="cancel" href="StudentInfo?command=overview">Cancel</a>
			</p>

		</form>
	</article>
	</main>
</body>
</html>