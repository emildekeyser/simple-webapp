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
            <li><a href="index.jsp">Overzicht</a></li>
            <li><a href="tabel.jsp">Tabel</a></li>
            <li class="hier"><a href="voeg_toe.jsp">Voeg toe</a></li>
        </ul>
    </nav>

    <main>
       <form action="AddContainerToDB" method="get">
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

            <input type="submit" value="Voeg toe">
       </form>
    </main>

</body>
</html>