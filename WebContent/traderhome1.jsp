<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="java.util.ArrayList,com.group1.Models.Order"%>
<%@ page import="java.util.*" %>
<%@ page import="java.text.DecimalFormat" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
<meta charset="UTF-8">
<title>Trader Home Page</title>
<link rel="stylesheet" href="style/style.css">
</head>
<body>
	<header class="menu"> <img class="menu__logo"
		src="images/Logo.png"> <!-- Menu buttons -->
	<div class="menu__buttonbox">
		<input type="button" class="menu__button selected" value="HOME"
			onClick="document.homeform.submit()"> 

		<input type="button" class="menu__button" value="INBOX"
			onClick="location.href='traderinbox.html'"> <input
			type="button" class="menu__button" value="MAKE A TRADE"
			onClick="location.href='tradermaketrade.jsp'"> <input
			type="button" class="menu__button" value="PROFIT/LOSS"
			onClick="document.plform.submit()"> <input type="button"
			class="menu__button selected" value="ORDER HISTORY"
			onClick="document.historyform.submit()"> <input type="button"
			class="menu__button logoutbutton" value="LOG OUT"
			onClick="location.href='login.html'">



	</div>
	</header>
	<form name="homeform" action="TraderHomeServlet" method="get"></form>
	<form name="historyform" action="TradeHistoryServlet" method="get"></form>
	<form name="plform" action="PLServlet" method="get"></form>

	<!-- Header menu buttons end -->
	<main class="traderhomemain">
	<div class="hero">
		<article class="hero__block">
		<h2 class="hero__heading">CURRENT ASSETS</h2>
		<p class="hero__data" name="heroassets">$ <%= request.getAttribute("current_assets") %></p>
		</article>

		<article class="hero__block">
		<h2 class="hero__heading">PROFIT/LOSS</h2>
		<p class="hero__data" name="heropl">$ <%= request.getAttribute("pl_assets") %></p>
		</article>

		<article class="hero__block">
		<h2 class="hero__heading">% CHANGE</h2>
		<p class="hero__data" name="heropchange"><%= request.getAttribute("change") %></p>
		</article>
	</div>
	<div class="portfolio">
		<h2 class="portfolio__header">USD vs.</h2>
		<div class="scrollwrapper">
			<table class="portfolio__table" name="traderportfolio">
				<tr>
					<th name="GBP">GBP</th>
					<th name="INR">INR</th>
					<th name="CAD">CAD</th>
					<th name="CHF">CHF</th>
					<th name="AUD">AUD</th>
					<th name="EUR">EUR</th>
				
				</tr>
				<% Map<String,Double> displayMap  = (Map<String,Double>) request.getAttribute("map");
					DecimalFormat nf = new DecimalFormat("0.00");%>
					<tr>
					<td name="GBP"><%= nf.format(displayMap.get("GBP")) %></td>
					<td name="INR"><%= nf.format(displayMap.get("INR")) %></td>
					<td name="CAD"><%= nf.format(displayMap.get("CAD")) %></td>
					<td name="CHF"><%= nf.format(displayMap.get("CHF")) %></td>
					<td name="AUD"><%= nf.format(displayMap.get("AUD")) %></td>
					<td name="EUR"><%= nf.format(displayMap.get("EUR")) %></td>
					</tr>
				<tbody>
					
				</tbody>
			</table>
		</div>
	</div>
	</main>
	<script src="http://code.jquery.com/jquery-latest.min.js"></script>
	<!--  <script>
    $(document).ready(function() {
    	 $.get("TraderHomeServlet", function(responseText) {   // Execute Ajax GET request on URL of "someservlet" and execute the following function with Ajax response text...
                 console.log("ready function")     // Locate HTML DOM element with ID "somediv" and set its text content with the response text.
         });
        });
   
</script>-->
	<script>

function initHome()
{ 
     document.homeform.submit();
	} 

</script>
</body>
</html>