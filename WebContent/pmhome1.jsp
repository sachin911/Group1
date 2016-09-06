<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
    <%@page import="java.util.ArrayList,com.group1.Models.Order"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html lang="en">
	<head>
		<meta charset="UTF-8">
		<title>PM Home Page</title>
		<link rel="stylesheet" href="style/style.css">
	</head>
	<body onLoad="callservlet()">
		<header class="traderMenu">
			<img class="traderMenu__logo" src="images/Logo.png">

			<!-- Menu buttons -->
			<div class="traderMenu__buttonbox">
				<input type="button" class="Menu__button selected" value="HOME" onClick="document.homeform.submit()">
				<input type="button" class="Menu__button" value="TRADERS" onClick="location.href='pmtraders.html'">
				<input type="button" class="Menu__button" value="MAKE A TRADE" onClick="location.href='pmmakeatrade.html'">
				<input type="button" class="Menu__button" value="PROFIT/LOSS" onClick="location.href='pmprofitloss.html'">
				<input type="button" class="Menu__button" value="ORDER HISTORY" onClick="location.href='pmorderhistory.html'">
				<input type="button" class="Menu__button logoutbutton" value="LOG OUT" onClick="location.href='login.html'">
			</div>
		</header>
		
	<form name="homeform" action="PMHomeServlet" method="get"></form>
	<form name="historyform" action="PMHomeServlet" method="get"></form>

		<!-- Header menu buttons end -->
		<main class="pmhomemain">
			<div class="hero">
				<article class="hero__block">
					<h2 class="hero__heading">Total Assets</h2>
					<p class="hero__data" name="heroassets">data</p>
				</article>

				<article class="hero__block">
					<h2 class="hero__heading">Profit/ Loss</h2>
					<p class="hero__data" name="heropl">data</p>
				</article>

				<article class="hero__block">
					<h2 class="hero__heading">% Change</h2>
					<p class="hero__data" name="heropchange">data</p>
				</article>
			</div>
			
			
			<div class="portfolio">
				<h2 class="portfolio__header">Portfolio</h2>
				<div class="scrollwrapper">
					<table class="portfolio__table" name="pmportfolio">
						<tr>
							<th name="symbol">Symbol</th>
							<th name="quantity">Quantity</th>
							<th name="basecurrency">Base Currency</th>
							<th name="executedprice">Executed Price</th>
							<th name="currentshareprice">Current Share Price</th>
							<th name="marketvalue">Market Value</th>
							<th name="profitloss">Profit/loss</th>
						</tr>
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
					</table>
				</div>
			</div>
		</main>
	</body>
</html>