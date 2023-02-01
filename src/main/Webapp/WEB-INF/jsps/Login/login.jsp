<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>LogIn here</title>
</head>
<body>
<h1>LogIn Here</h1>
<form action="veryFyLogin" method="post">
Email<input type="text" name="email"/>
Password<input type="password" name="password"/>
<input type="submit" value="login"/>
</form>
${error}
</body>
</html>