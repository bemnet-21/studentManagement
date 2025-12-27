<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Student Registration</title>
</head>
<body>
	<h2>Student Registration</h2>
	
	<form action="register" method="post">
		Name: <input type="text" name="name" required/> <br/><br />
		Email: <input type="text" name="email" required/> <br/><br />
		Year: <input type="number" name="year" required/> <br/><br />
		<button type="submit">Register</button>
	</form>
	
	<br />
	<a href="show_all">View All Students</a>
</body>
</html>