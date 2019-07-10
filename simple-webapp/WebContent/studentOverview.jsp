<%@page import="domain.model.Student"%>
<%@page import="java.util.Collection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="css/sample.css">
<meta charset="UTF-8">
<title>Overzicht Studenten</title>
</head>
<body>
	<header>
		<div>
			<h1>Studenten Registratie</h1>
			
			<%@include file="menu.jspf" %>
			
		</div>
		<img alt="Toscane" src="images/student.jpg">

	</header>

	<main id="container">
	<article>
		<h2>Overzicht studenten</h2>
		<%
			Collection<Student> students = (Collection<Student>) request.getAttribute("studenten");
			if (students != null) {
		%>
		<table id="overview">
			<tr>
				<th>Naam</th>
				<th>Voornaam</th>
				<th class="getal">Leeftijd</th>
				<th>Studierichting</th>
			</tr>
			<%
				for (Student student : students) {
			%>
			<tr id="<%=student.getNaam()%>">
				<td><%=student.getNaam()%></td>
				<td><%=student.getVoornaam()%></td>
				<td class="getal"><%=student.getLeeftijd()%></td>
				<td><%=student.getStudierichting()%></td>
				<td><a id="deleteButton" href="StudentInfo?command=deleteconfirm&naam=<%= student.getNaam() %>&voornaam=<%= student.getVoornaam() %>">delete</a></td> <!-- LULKEK dit kan spaties in url zetten??, te lui om nu te fixen -->
				 <td><a id="updateButton" href="StudentInfo?command=updateForm&naam=<%= student.getNaam() %>&voornaam=<%= student.getVoornaam() %>">update</a></td>
			</tr>
			<%
				}
			%>
		</table>
		<%
			} else {
		%>
		<p>Er zijn nog geen studenten toegevoegd.</p>
		<%
			}
		%>

	</article>
	</main>
</body>
</html>