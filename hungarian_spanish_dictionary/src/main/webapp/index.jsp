<%@page import="com.bh08.hungarian_spanish_dictionary.model.Word"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Dictionary</title>
</head>
<body>

	<form method="POST" action="dictionary">

		<label for="char">Search: </label> <input type="text" name="word"
			id="word" /><br /> <input type="submit" value="Translate" /><br />
		<br />

	</form>


</body>
</html>