<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!doctype html>
<html>
<head>
<meta charset="UTF-8" />
<title>Result</title>
</head>
<body>

<p id="antwoord">
Het antwoord is: <%= request.getAttribute("result") %> keer.
</p>

</body>
</html>
