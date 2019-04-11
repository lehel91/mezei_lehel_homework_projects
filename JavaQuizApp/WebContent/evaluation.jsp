<%@page import="com.bh08.javaquizapp.model.Answer"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form method="GET" action="/JavaQuizApp/evaluation">
		<%
			int score = (int) request.getAttribute("score");
			List<String> toplist = (List<String>) request.getAttribute("toplist");

			out.println("<div class=\"row\"><div>Az eredmény: " + score + "</div></div>");
			out.println("<div class=\"row\"><div>A toplista</div>");
			for (int i = 0; i < toplist.size(); i++) {
				out.println("<div class=\"row\"><div>" + toplist.get(i) + "</div></div>");
			}
		%>

		<br> <br>

	</form>
</body>
</html>