<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="domain.Vak" %>
<%@ page import="java.util.ArrayList" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<% 	ArrayList<Vak> vakken = new ArrayList<Vak>();
	Vak bop = new Vak("BOP", 6, "1TX");
	vakken.add(bop);
	Vak web2 = new Vak("Web2", 3, "1TX");
	vakken.add(web2);
	Vak web3 = new Vak("Web3", 3, "2TX");
	vakken.add(web3);
	Vak capita = new Vak("Capita Selecta", 3, "3TX");
	vakken.add(capita);
%>
</head>
<body>

	<table>

		<tr>		
			<th>Vak</th>
			<th>Studiepunten</th>
			<th>Jaar</th>
		</tr>
		
		
		<% for (Vak v : vakken) { %>
		<tr>
		<td><%= v.getNaam() %></td>
		<td><%= v.getStudiePunten() %></td>
		<td><%= v.getJaar() %></td>
		</tr>
		<%} %>
	
	</table>

</body>
</html>