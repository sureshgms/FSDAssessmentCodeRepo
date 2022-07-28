<%@page import="java.util.Optional"%>
<%@page import="com.bean.Users"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Sporty Shoes Web Store</title>
<h2>Search for Users</h2>
	<br />
	<form action="searchUsers" method="get">
		<label>User name</label> <input type="text" name="username">
		<input type="submit" value="Search User"> <br/><br/><br/>
		
	</form>
	
	<form action="searchAllUsers" method="get">
	<input type="submit" value="Find All Users">
	</form>

	<hr>
	
	
<a href="AdminLoginSuccess.jsp">Back To Home</a><br />

</head>
<body>

</body>
</html>