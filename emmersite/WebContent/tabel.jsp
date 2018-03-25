<%@page import="java.util.ArrayList"%>
<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="domain.db.FluidContainerDB" %>
<%@ page import="domain.model.FluidContainer" %>


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
            <li class="hier"><a href="servlet">Tabel</a></li>
            <li><a href="voeg_toe.jsp">Voeg toe</a></li>
        </ul>
    </nav>

    <main>
        <table>
            <tr>
                <th>Type</th>
                <th>Material</th>
                <th>Capacity</th>
                <th>Contents</th>
                <th>Contains</th>
            </tr>
           
           <% for(FluidContainer container : (ArrayList<FluidContainer>)request.getAttribute("db")){ %>
           		<tr>
           			<td><%= container.getType() %></td>
           			<td><%= container.getMaterial() %></td>
           			<td><%= container.getCapacityInLiters() %>L</td>
           			<td><%= container.getContentsInLiters() %>L</td>
           			<td><%= container.getContains() %></td>
           		</tr>
           <%} %>
        </table>
    </main>

</body>
</html>