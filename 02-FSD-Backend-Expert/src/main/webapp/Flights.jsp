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
<title>FlyAway Airlines : Setup Flights</title>


</head>
<body>
	<h2>Enter Flight Details</h2>
	<form action="FlightSetupController" method="post">
		<label>Source Place</label> <select name="sourcePlace">
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
		</select> <br /> <br /> <label>Target Place</label> <select
			name="targetPlace">
			<%
			List<Places> listOfPlaces = (List<Places>) obj1;
			for (Places placevar : listOfPlaces) {
			%>

			<option value=<%=placevar.getPlaceId()%>><%=placevar.getPlacesName()%></option>
			<%
			}
			%> } } %>
		</select> <br /> <br /> <label>Airline</label> <select name="airline">
			<%
			Object obj2 = session.getAttribute("allAirlines");
			if (obj1 != null) {
				List<Airlines> listOfAirlines = (List<Airlines>) obj2;
				//Iterator<Places> li = listOfPlaces.listIterator();
				for (Airlines airlinevar : listOfAirlines) {
			%>

			<option value=<%=airlinevar.getAirlineId()%>><%=airlinevar.getAirlineName()%></option>
			<%
			}
			}
			%> } } %>
		</select> <br /> <br /> <label>Flight Number</label> <input type="text"
			name="flightNumber" /><br />
		<br /> <label>Price</label> <input type="text" name="price" /><br />


		<br /> <input type="submit" value="Submit" /> <input type="reset"
			value="Reset" />
	</form>
	<br />
	<br />
	<a href="AdminPage.jsp">Back To Home</a>
	<br />
<h2>Available Flights</h2>
		<br />

		<table border="1">

			<tr>

				<th>Flight Name</th>
				<th>Source Place</th>
				<th>Destination Place</th>
				<th>Airline</th>
				<th>Price</th>

			</tr>
			<%
			Object obj3 = session.getAttribute("allFlights");
			if (obj3 != null) {
				List<Flights> listOfFlights = (List<Flights>) obj3;
				
				for (Flights flightList : listOfFlights) {
					Places sourcePlace = flightList.getSourcePlace();
					Airlines airlinedtls = flightList.getAirlineName();
					Places destinationplace = flightList.getDestinationPlace();
					
			%>
			<tr>
				<td><%=flightList.getFlightNumber()%></td>
			
				<td><%=sourcePlace.getPlacesName()%></td>
				
				<td><%=destinationplace.getPlacesName()%></td>
				
			    <td><%=airlinedtls.getAirlineName()%></td>
			    
			    <td><%=flightList.getPrice()%></td>
			    
			</tr>
			<%
			}
			}
			%>
		</table>
	

</body>
</html>