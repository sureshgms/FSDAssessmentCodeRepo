<%@page import="org.hibernate.internal.build.AllowSysOut"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@page import="com.bean.Places"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>FlyAway Airlines</title>
</head>
<body>
	<h2>Enter places for Source / Destination</h2>
	<form action="PlaceSetupController" method="post">
		<label>Place Name</label> <input type="text" name="placename"><br />
		<input type="submit" value="Save"><br /> <br /> <a
			href="AdminPage.jsp">Back To Home</a>

		<h2>Available Places</h2>
		<br />

		<table border="1">

			<tr>

				<th>Place Name</th>

			</tr>
			<%
			Object obj = session.getAttribute("allPlaces");
			if (obj != null) {
				List<Places> listOfPlaces = (List<Places>) obj;

				for (Places placevar : listOfPlaces) {
			%>
			<tr>
				<td><%=placevar.getPlacesName()%></td>
				<%--<td>Sample text</td> --%>
			</tr>
			<%
			}
			}
			%>
		</table>
</body>
</html>