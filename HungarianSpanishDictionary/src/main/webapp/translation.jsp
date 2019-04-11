<%@page import="com.bh08.hungarian_spanish_dictionary.model.Word"%>
<%@page import="java.util.Optional"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form method="GET" action="translation">

		<%
			Word wordToTranslate = (Word) request.getAttribute("translatedWord");

			if (wordToTranslate != null) {

				out.println("<b>Word searched: </b>" + wordToTranslate.getHungarianWord() + "<br/>");
				out.println("<b>Translation: </b>" + wordToTranslate.getSpanishWord() + "<br/>");			

			} else {
				out.println("<b>The word you are searching for is not yet in our dictionary.</b>");
			}
		%>


	</form>
</body>
</html>