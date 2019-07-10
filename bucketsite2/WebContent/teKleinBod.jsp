<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

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
            <li class="hier"><a href="index.jsp?cmd=overzicht"">Overzicht</a></li>
            <li><a href="servlet">Tabel</a></li>
            <li><a href="voeg_toe.jsp">Voeg toe</a></li>
        </ul>
    </nav>

    <main>
        <section>
	        <h2>Te weinig geboden</h2>
	        <% int bod = (int)request.getAttribute("bod"); %>
            <p>U bod van <output> <%= bod %> </output> euro is niet groot genoeg.</p>
        </section>
        <!-- <section>
        	<h2>ipsum dolor</h2>
            Lorem, ipsum dolor sit amet consectetur adipisicing elit. Optio quod quae voluptas ullam? Inventore tenetur eos, expedita suscipit dolore laudantium asperiores dolorem enim porro optio! Repudiandae cupiditate velit doloribus sapiente.
        </section> -->
    </main>

</body>
</html>