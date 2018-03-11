<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="domain.model.Student" %>

<!DOCTYPE >
<html>
<head>
<meta charset="UTF-8" />
<title>Insert title here</title>
</head>
<body>
<% Student st = (Student)request.getAttribute("student"); %>
<p>
Je vroeg naar volgende gegevens: 
<%= st.getAchternaam() %> <%= st.getVoornaam() %>
(<%= st.getLeeftijd() %> jaar): <%= st.getStudierichting() %>
</p>
</body>
</html>



