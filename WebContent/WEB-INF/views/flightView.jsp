<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>FLIGHT</title>
<link rel="stylesheet" type="text/css" href="./assets/newstyle.css"/>
</head>
<body>
<header>
<img class="logo" src="./assets/logo.svg"></img>
</header>
<section class="result">
${param.msg}
<table>
<tr>
<td>TRIP TYPE</td>
<td> ${flight.getTriptype()}</td>
</tr>
<tr>
<td>CHECK-IN</td>
<td> ${flight.getFrom()}</td>
</tr>
<tr>
<td>CHECK-OUT</td>
<td> ${flight.getTo()}</td>
</tr>
<tr>
<td>TOTAL GUESTS</td>
<td>${flight.getNoOfPersons()}</td>
</tr>
<tr>
<td>TOTAL FARE</td>
<td>${flightfare }</td>
</tr>
</table>


</section>

<footer>
<div class="footer-content">CONTACT</div>
<div class="support">support[AT]gogoa.com</div>
</footer>
<p class="footer-text">Made with <img src="./assets/prograd-heart.svg"> by ProGrad</p>
</body>
</body>
</html>