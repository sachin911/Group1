<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="java.util.ArrayList,com.group1.Models.Order"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
	<head>
		<meta charset="UTF-8">
		<title>Trader Home Page</title>
		<link rel="stylesheet" href="style/style.css">
	</head>
	<body>
		<header class="menu">
			<img class="menu__logo" src="images/Logo.png">

			<!-- Menu buttons -->
			<div class="menu__buttonbox">
				<input type="button" class="menu__button selected" value="HOME" onClick="document.homeform.submit()">
				<input type="button" class="menu__button" value="INBOX" onClick="location.href='traderinbox.html'">
				<input type="button" class="menu__button" value="MAKE A TRADE" onClick="location.href='tradermakeatrade.html'">
				<input type="button" class="menu__button" value="PROFIT/LOSS" onClick="location.href='traderprofitloss.html'">
				<input type="button" class="menu__button" value="ORDER HISTORY" onClick="document.historyform.submit()">
				<input type="button" class="menu__button logoutbutton" value="LOG OUT" onClick="location.href='logoutservlet'">

			</div>
		</header>
<form name="homeform" action="TraderHomeServlet" method="get"></form>
<form name="historyform" action="TradeHistoryServlet" method="get"></form>

		<!-- Header menu buttons end -->
		<main class="traderhomemain">
			<div class="hero">
				<article class="hero__block">
					<h2 class="hero__heading">Current Assets</h2>
					<p class="hero__data" name="heroassets"><%= request.getAttribute("totalassets") %></p>
				</article>

				<article class="hero__block">
					<h2 class="hero__heading">Current Investment</h2>
					<p class="hero__data" name="heropl"><%= request.getAttribute("pl") %></p>
				</article>

				<article class="hero__block">
					<h2 class="hero__heading">% Change</h2>
					<p class="hero__data" name="heropchange">data</p>
				</article>
			</div>
			<div class="portfolio">
				<h2 class="portfolio__header">Portfolio</h2>
				<div class="scrollwrapper">
					<table class="portfolio__table" name="traderportfolio">
						<tr>
							<th name="symbol">Symbol</th>
							<th name="quantity">Quantity</th>
							<th name="basecurrency">Base Currency</th>
							<th name="usdvalue">USD Value</th>
							<th name="executedprice">Executed Price</th>
							<th name="averageprice">Average Price</th>
							<th name="currentshareprice">Current Share Price</th>
							<th name="marketvalue">Market Value</th>
							<th name="profitloss">Profit/loss</th>
						</tr>
						<%ArrayList<Order> tlist = (ArrayList<Order>)request.getAttribute("ol");
						
						if(tlist!=null)
							{
							for(Order o : tlist) {
							
						%>
						<tr>
						<td><%=o.getSymbol()%></td>
						<td><%=o.getTotal_quantity()%></td>
						<td><%=o.getCurrency() %></td>
						<td>USD value</td>
						<td><%=o.getExecuted_price() %></td>
						<td>average price</td>
						<td>current share price</td>
						<td>market value</td>
						<td><%=o.getPl() %></td>
						</tr><% }
						} %>
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