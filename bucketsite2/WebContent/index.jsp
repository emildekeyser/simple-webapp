<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="domain.db.FluidContainerDB" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Emmers en Vaten</title>
    <link rel="stylesheet" href="style.css">
</head>
<body>
    
    <nav>
        <ul>
            <li class="hier"><a href="index.jsp?cmd=overzicht"?cmd=overzicht">Overzicht</a></li>
            <li><a href="servlet">Tabel</a></li>
            <li><a href="voeg_toe.jsp">Voeg toe</a></li>
        </ul>
    </nav>

    <main>
        <section>
	        <h2>Gemiddelde</h2>
            <p>gemiddelde alle emmers: <output> <%= new FluidContainerDB().averageFilled() %> </output>L</p>
        </section>
        <section>
        	<h2>Som geboden bedragen</h2>
            <%FluidContainerDB db = (FluidContainerDB) request.getAttribute("db"); %>
            <p>Som boden: <%=db.SomBoden() %></p>
        </section>
    </main>

</body>
</html>