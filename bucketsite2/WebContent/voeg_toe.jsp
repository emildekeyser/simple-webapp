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
            <li><a href="index.jsp?cmd=overzicht"">Overzicht</a></li>
            <li><a href="servlet">Tabel</a></li>
            <li class="hier"><a href="voeg_toe.jsp">Voeg toe</a></li>
        </ul>
    </nav>

    <main>
       <form action="servlet" method="post">
           <label for="type">Type</label> 
           <input type="text" name="type" id="type"/>
           <!-- <select name="type" id="type">
                <option value="placehold">placehold</option>
                <option value="placehold">placehold</option>
                <option value="placehold">placehold</option>
                <option value="placehold">placehold</option>
                <option value="placehold">placehold</option>
           </select> -->

            <label for="materiaal">Materiaal</label>
            <input type="text" name="materiaal" id="materiaal">
            
            <label for="totale_inhoud">Totale Inhoud</label> 
            <input type="number" name="totale_inhoud" id="totale_inhoud">
            
            <label for="inhoud_gevuld">Inhoud Gevuld</label> 
            <input type="number" name="inhoud_gevuld" id="inhoud_gevuld">
            
            <label for="bevat">Bevat</label> 
            <input type="text" name="bevat" id="bevat">
            
            <label for="bod">Geboden Bedrag</label> 
            <input type="number" name="bod" id="bod">

            <input id="submit" type="submit" value="Voeg toe">
       </form>
       <!-- VALIDATIE LATER -->
       <%-- <% int gelukt = (int)request.getAttribute("gelukt"); %>
       <% if(gelukt > 0) {%>
       		<p style="color: green">Toegevoegd</p>
       <% }%>
       <% if(gelukt < 0) {%>
       		<p style="color: red">Fout! kon niet toevoegen.</p>
       <% } %> --%>
    </main>

</body>
</html>