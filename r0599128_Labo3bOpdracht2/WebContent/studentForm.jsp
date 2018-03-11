<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<h1>New Student</h1>

<a href="overview.jsp">home</a>

<form action="StudentInfo" method="post">

	<label for="voornaam">Voornaam</label><input id="voornaam" type="text" name="voornaam" />
	<label for="achternaam">Achternaam</label><input id="naam" type="text" name="achternaam" />
	<label for="leeftijd">Leeftijd</label><input id="leeftijd" type="text" name="leeftijd" />
	<label for="richting">Studierichting</label><input id="studierichting" type="text" name="richting" />
	<input id="bewaar" type="submit" value="Bewaar"/>

</form>

</body>
</html>