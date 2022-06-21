<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>FlyAway Airlines</title>
</head>
<body>
<h2>Admin Login: Please enter user name and Password</h2>
<form action="LoginControllerFlyAway" method="post">
    <label>Email</label>
    <input type="email" name="email"><br/>
    <label>Password</label>
    <input type="password" name="password"><br/>
    <input type="submit" value="Login">
    <input type="reset" value="Reset">
</body>
</html>