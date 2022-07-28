<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@page import="com.bean.Users"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<h2>List of All Users</h2>
<br />

	<table border="1">


		<tr>

			<th>User Name</th>

		</tr>
		<%
		Object obj = session.getAttribute("allusers");
		if (obj != null) {
			List<Users> userList = (List<Users>) obj;

			for (Users user : userList) {
		%>
		<tr>
			<td><%=user.getEmailId()%></td>
			<%--<td>Sample text</td> --%>
		</tr>
		<%
		}
		}
		%>
	</table>
	
	<br />
	<br />
	<a href="Users.jsp">Back To Users Page</a>
	<br />
	<br />

</body>
</html>