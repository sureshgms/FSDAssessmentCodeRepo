<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Sporty Shoes Web Store</title>
</head>
<body>
<form action="changePassword" method="post">
    <label>Old Password</label>
    <input type="password" name="oldpassword"><br/>
    <label>New Password</label>
    <input type="password" name="newpassword"><br/>
    <label>Confirm New Password</label>
    <input type="password" name="confirmpassword"><br/><br/>
    <input type="submit" value="Change Password">
    <input type="reset" value="Reset"> <br/><br/><br/>
</form>
<a href="AdminLoginSuccess.jsp">Back to Admin Page</a>
</body>
</html>