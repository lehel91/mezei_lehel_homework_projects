<%@ page import="java.util.List, com.bh08.javaquizapp.model.Question, com.bh08.javaquizapp.model.Answer" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Java Quiz</title>
</head>
<body>
	<form method = "POST" action="/JavaQuizApp/quiz">
	
	<%
	List<Question> questionList = (List<Question>)request.getAttribute("questionList");
	
	
	int i = 0;
	int j = 0;
	for (Question q : questionList) {
		i++;
		out.println("<div class=\"row\"><div>" + i + ". " + q.getQuestion() + "</div></div>");
		for (Answer a : q.getAnswers()) {	
			j++;
			out.println("<input type = 'checkbox' name = 'chBoxes' value = " + j + "/>"
					+ a.getAnswer() + "<br/>");

		}
		out.print("<br>");
	}	
	%>
	
		<br><br>
		<input type="submit" value="Beküldés">
		
		
	</form>
</body>
</html> 