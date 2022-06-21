<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>FlyAway Airlines</title>
</head>
<body>
<form action="ChangePasswordController" method="post">
<h2>Enter new password</h2>
    <label>Current Password</label>
    <input type="password" name="currentPassword"/><br/>
    <label>New Password</label>
    <input type="password" name="newpassword"/><br/>
    <label>Confirm New Password</label>
    <input type="password" name="confirmnewpassword"/><br/><br/>
    <input type="submit" value="Change Password"/>
    <input type="reset" value="Reset"/>
    <br/><br/>
    <a href="AdminPage.jsp">Back To Home</a>
</form>
</body>
</html>