<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Sporty Shoes Web Store</title>
</head>
<body>

<h2><center>Welcome to SportyShoes web Store</center></h2>

<center>
<h3> Admin login</h3>


<form action="checkAdminLogin" method="post">
    <label>User Name</label>
    <input type="email" name="email"><br/>
    <label>Password</label>
    <input type="password" name="password"><br/><br/>
    <input type="submit" value="Login">
    <input type="reset" value="Reset">
</form>
</center>

</body>
</html>

