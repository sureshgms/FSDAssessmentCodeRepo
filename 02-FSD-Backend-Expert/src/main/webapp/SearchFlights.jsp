<%@page import="java.util.List"%>
<%@page import="java.util.Map"%>
<%@page import="com.bean.Places"%>
<%@page import="java.util.Iterator"%>
<%@page import="com.bean.Airlines"%>
<%@page import="com.bean.Flights"%>
<%@page import="org.hibernate.SQLQuery"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>FlyAway Airlines : Book your flight</title>
<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<title>jQuery UI Datepicker - Default functionality</title>
	<link rel="stylesheet"
		href="//code.jquery.com/ui/1.13.1/themes/base/jquery-ui.css">
	<link rel="stylesheet" href="/resources/demos/style.css">
	<script src="https://code.jquery.com/jquery-3.6.0.js"></script>
	<script src="https://code.jquery.com/ui/1.13.1/jquery-ui.js"></script>
	<script>
		$(function() {
			$("#datepicker").datepicker();
		});
	</script>

</head>
<body>
	<h2>Please enter below information to search for available flights</h2>
	<form action="SearchFlightController" method="post">
		<label>Select Source Place</label> <select name="sourcePlace">
			<%
			Object obj1 = session.getAttribute("allPlaces");
			if (obj1 != null) {
				List<Places> listOfPlaces = (List<Places>) obj1;
				//Iterator<Places> li = listOfPlaces.listIterator();
				for (Places placevar : listOfPlaces) {
			%>

			<option value=<%=placevar.getPlaceId()%>><%=placevar.getPlacesName()%></option>
			<%
			}
			}
			%> } } %>
		</select> <br /> <br /> <label>Select Target Place</label> <select
			name="targetPlace">
			<%
			List<Places> listOfPlaces = (List<Places>) obj1;
			for (Places placevar : listOfPlaces) {
			%>

			<option value=<%=placevar.getPlaceId()%>><%=placevar.getPlacesName()%></option>
			<%
			}
			%> } } %> </select>
			<br/>
			<p>Travel Date: <input type="text" id="datepicker" name="travelDate"></p>
			<label>Number of Passengers</label> <input type="text" name="passengerCount"><br />
		

		<br/> <input type="submit" value="Search for Flights" /> <input type="reset"
			value="Reset" />
	</form>
	<br />
	<br />
	<br />

	

</body>
</html>