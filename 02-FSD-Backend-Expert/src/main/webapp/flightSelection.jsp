<%@page import="java.util.List"%>
<%@page import="com.bean.AvailableFlights"%>
<%@page import="com.bean.Places"%>
<%@page import="java.util.Iterator"%>
<%@page import="com.bean.Airlines"%>
<%@page import="com.bean.Flights"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>FlyAway Airlines</title>
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
	<form action="FlightBookController" method="post">
	<h2>Below are the available Flights. Select the one you prefer</h2>
	<br />

	<table border="1">

		<tr>
			<th>Select Flight</th>
			<th>Flight Number</th>
			<th>Source Place</th>
			<th>Destination Place</th>
			<th>Date</th>
			<th>Price</th>

		</tr>
		<%
		Object obj3 = session.getAttribute("availableFlightList");
		int passCount = Integer.parseInt((String) session.getAttribute("passengerCount"));
		
		if (obj3 != null) {
			List<AvailableFlights> listOfAFlights = (List<AvailableFlights>) obj3;

			for (AvailableFlights flightList : listOfAFlights) {
				String flightNumber = flightList.getFlightNumber();
				String sourcePlace = flightList.getSourcePlace();
				String destPlace = flightList.getDestinationPlace();
				String travelDate = flightList.getFlightDate();
				String price = String.valueOf((flightList.getPrice()* passCount));
			
				
		%>
		<tr>
		
			<td><input type="radio" name="selectedFlight" value="<%=flightList%>"></input></td>
			<td><%=flightNumber%></td>

			<td><%=sourcePlace%></td>

			<td><%=destPlace%></td>
			
			<td><%=travelDate%></td>

			<td><%=price%></td>

			

		</tr>
		<%
		}
		}
		%>
	</table>
	<br/> <br/>
	<h2>Provide Primary Passenger information</h2>
	<label>First Name</label> <input type="text" name="passFirstName" /><br/><br/>
	<label>Last Name</label> <input type="text" name="passLastName" /><br/><br/>
	<label>Gender</label><input type="text" name="passGender" /><br/><br/>
	<label>Age</label><input type="text" name="passAge" /><br/><br/>
	<label>Mobile Number</label><input type="text" name="passMobileNumber" /><br/><br/>
	
	<br/> <br/>
	<h2>Provide Payment information</h2>
	<label>Credit Card number</label><input type="text" name="ccNumber" /><br/><br/>
	<label>Credit Card Name</label><input type="text" name="ccName" /><br/><br/>
	<label>Expiry Date </label> <input type="text" id="datepicker" name="ccExpiry"><br/><br/>
	<label>CVV number</label><input type="text" name="ccCvv" /><br/><br/>
	
	<br/><input type="submit" value="Submit" /><br/>
	<br/><a href="SearchFlights.jsp">Back To Flight Search</a>
	</form>
</body>
</html>