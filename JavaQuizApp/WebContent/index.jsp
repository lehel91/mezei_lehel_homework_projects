<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login</title>
</head>
<body>

	<form method="POST" action="/JavaQuizApp/login">
		<label for="username">Felhasználónév:</label><input type="text" name="username" id="username" /> <br/>
		<label for="password">Jelszó:</label><input type="password" name="password" id="password"/> <br/>
		<input type="submit" value="Bejelentkezés" />
		<input type="reset" value="Törlés" />
	</form>
</body>
</html>