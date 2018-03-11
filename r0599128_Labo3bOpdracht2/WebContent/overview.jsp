<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="domain.db.StudentDB" %>
<%@ page import="domain.model.Student" %>    

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" />
<title>Insert title here</title>
</head>
<body>

<h1>Overzicht studenten</h1>

<a href="studentForm.jsp">voeg toe</a>

<table>
<tr>
	<th>Naam</th>
	<th>Voornaam</th>
	<th>Leeftijd</th>
	<th>Studierichting</th>
</tr>
<%for(Student st : StudentDB.theDB()) {%>
	<% String vn = st.getVoornaam(); String an = st.getAchternaam(); %>
	<tr id="<%= st.getAchternaam() %>">
	<td><a href="StudentInfo?naam=<%= an %>&voornaam=<%= vn %>"><%= an %></a></td>
	<td><%= st.getVoornaam() %></td>
	<td><%= st.getLeeftijd() %></td>
	<td><%= st.getStudierichting() %></td>
	</tr>
<%} %>
</table>

</body>
</html>