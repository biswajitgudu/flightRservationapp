 <%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Flight Search Result</title>
</head>
<body>
<h1>Display Flights</h1>
<table border="1">
<tr>
<th>Airlines</th>
<th>Departure City</th>
<th>Arrival City</th>
<th>Departure Time</th>
<th>Select Flight</th>
</tr>
<c:forEach var="flights" items="${findflights}">
<tr>
<td>${flights.opertingAirlines}</td>
<td>${flights.departureCity}</td>
<td>${flights.arrivalCity}</td>
<td>${flights.dateOfDeparture}</td>
<td>
<a href="showCompleteReservation?flightId=${flights.id}">Select</a>
</td>

</tr>




</c:forEach>






</table>

</body>
</html>