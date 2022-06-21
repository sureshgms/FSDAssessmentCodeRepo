<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>FlyAway Airlines - Booking Confirmation</title>
</head>
<body>

<h2>Thank you for booking your flight. Below are the details</h2><br/>
<% Object obj1 = session.getAttribute("flightDtlsArray");
   String[] flightDtlsArray = (String[]) obj1; 
   Object obj2 = session.getAttribute("passFirstName");
   String passFirstName = (String) obj2;
		%>
<table border="1">
<tr>

<%
int index = 0;
while(index < flightDtlsArray.length) { %>
<th><%=flightDtlsArray[index]%></th>
<%index++;%>
<td><%=flightDtlsArray[index]%></td>
<%index++;%>
</tr>
<%} %>
<tr>
<th>Passenger First Name </th><td><%=session.getAttribute("passFirstName") %> </td>
</tr>
<tr>
<th>Last Name </th><td><%=session.getAttribute("passLastName") %> </td>
</tr>
<tr>
<th>Gender </th><td><%=session.getAttribute("passGender") %> </td>
</tr>
<tr>
<th>Age</th><td><%=session.getAttribute("passAge") %> </td>
</tr>
<tr>
<th>Mobile Number</th><td><%=session.getAttribute("passMobileNumber") %> </td>
</tr>
<tr>
<th>Credit Card number</th><td><%=session.getAttribute("ccNumber") %> </td>
</tr>
<tr>
<th>Credit Card Name</th><td><%=session.getAttribute("ccName") %> </td>
</tr>

</table>

<br/><br/>
<a href = "SearchFlights.jsp">Book another Flight</a>

</body>
</html>