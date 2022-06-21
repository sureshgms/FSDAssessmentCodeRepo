<%@page import="org.hibernate.internal.build.AllowSysOut"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@page import="com.bean.Airlines"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>FlyAway Airlines : Setup Airlines</title>
</head>
<body>
<h2>Enter AirLines Name</h2>
	<form action="AirLinesController" method="post">
		<label>Airlines Name</label> <input type="text" name="airlineName"><br />
		<input type="submit" value="Save"><br /> <br /> </form>

		<a href="AdminPage.jsp">Back To Home</a>
		
		<h2>Available Airlines</h2>
		<br />

		<table border="1">

			<tr>

				<th>Airline Name</th>

			</tr>
			<%
			Object obj = session.getAttribute("allAirlines");
			if (obj != null) {
				List<Airlines> listOfAirlines = (List<Airlines>) obj;

				for (Airlines airlinevar : listOfAirlines) {
			%>
			<tr>
				<td><%=airlinevar.getAirlineName()%></td>
				<%--<td>Sample text</td> --%>
			</tr>
			<%
			}
			}
			%>
		</table>

</body>
</html>