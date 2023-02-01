<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Reservation detail</title>
</head>
<body>
<h1>Flight Details</h1>
flightNumber:${flight.flightNumber}<br/>
opertingAirlines:${flight.opertingAirlines}<br/>
departureCity:${flight.departureCity}<br/>
arrivalCity:${flight.arrivalCity}<br/>
dateOfDeparture:${flight.dateOfDeparture}<br/>

<h1>Passenger Details </h1>
<form action="confirmationReservation" method="post">
<pre>

FirstName<input type="text" name="firstName"/>
LastName<input type="text" name="lastName"/>
middleName<input type="text" name="middleName"/>
Email<input type="text" name="email"/>
Phone<input type="text" name="phone"/>
<input type="hidden" name="flightId" value="${flight.id}"/>
<h1>Enter payments Details</h1>
Name Of Card<input type="text" name="nameOfTheCard"/>
Card Number<input type="text" name="cardNumber"/>
CVV<input type="text" name="cvv"/>
Expiry Date<input type="text" name="expiryDate"/>
<input type="submit" value="complete reservation"/>




</pre>






</form>
</body>
</html>