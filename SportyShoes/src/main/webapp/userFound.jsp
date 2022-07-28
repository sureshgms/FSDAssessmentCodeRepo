<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<%
	Object obj = session.getAttribute("user");
	
		if (obj != null) { 
	
			%><h2>User Found</h2>
	<% } else { %> <h2>User Not Found</h2>   <% }%>	
	
<br/>
<a href="Users.jsp">Back To Users Page</a><br />
</body>
</html>