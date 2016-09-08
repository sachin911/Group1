<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="java.util.*" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.group1.Models.Order" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
<meta charset="UTF-8">
<title>Trader Profile</title>
<link rel="stylesheet" href="style/style.css">
</head>
<body>
	<header class="menu"> <img class="menu__logo"
		src="images/Logo.png"> <!-- Menu buttons -->
	<div class="menu__buttonbox">
		<input type="button" class="menu__button" value="HOME"
			onClick="location.href='pmhome.html'"> <input type="button"
			class="menu__button selected" value="TRADERS"
			onClick="location.href='pmtraders.html'"> <input
			type="button" class="menu__button" value="MAKE A TRADE"
			onClick="location.href='pmmakeatrade.html'"> <input
			type="button" class="menu__button" value="PROFIT/LOSS"
			onClick="location.href='pmprofitloss.html'"> <input
			type="button" class="menu__button" value="ORDER HISTORY"
			onClick="location.href='pmorderhistory.html'"> <input
			type="button" class="menu__button logoutbutton" value="LOG OUT"
			onClick="location.href='logoutservlet'">
	</div>
	</header>
	<!-- Header menu buttons end -->

	<main class="pmviewtrader">
	<h2 class="pmviewtrader__header">Portfolio</h2>
	<table class="portfolio__table" name="traderportfolio">
		<tr>
			<th name="portfolioid">Portfolio ID</th>
			<th name="symbol">Symbol</th>
			<th name="quantity">Quantity</th>
			<th name="currency">Currency</th>
			<th name="executedprice">Executed Price</th>
			<th name="P/L">P/L</th>
					</tr>
					
					<% List<Order> list = (ArrayList<Order>) request.getAttribute("li");
                   if(list!=null){
				for(int i = 0;i<list.size();i++){ %>
					<tr>
					<td><%=list.get(i).getOrder_id()%></td>
							<td><%=list.get(i).getSymbol()%></td>
							<td><%=list.get(i).getOpen_quantity()%></td>
						<td><%=list.get(i).getCurrency()%></td>
							<td><%=list.get(i).getExecuted_price()%></td>
							<% Random rand = new Random();float current_price;%>
							<% current_price = (float)((list.get(i).getExecuted_price() + rand.nextDouble()*15) - 5); %>
							<%list.get(i).getCurrency();%>
							<td><%float pl; %><%= pl = (float) (list.get(i).getExecuted_price() - current_price) * list.get(i).getOpen_quantity() %></td>
						
							
							
						</tr>
		<% 	}}%>
		<tbody>

		</tbody>
	</table>

<%-- 
	<!-- profloss table -->
	<div class="profloss">
		<h2 class="profloss__header">Profit/Loss</h2>
		<div class="scrollwrapper">
			<table class="profloss__table" name="profitlosstable">
				<tr>
					<th name="symbol">Symbol</th>
					<th name="quantity">Quantity</th>
					<th name="ordertype">Order Type</th>
					<th name="priceexecuted">Price Executed</th>
					<th name="currentprice">Current Price</th>
					<th name="basecurrency">Base Currency</th>
					<th name="usdval">USD Value</th>
					<th name="pl">P/L</th>
				</tr>--%>
				<tbody>

				</tbody>
			</table>
		</div>
	</div>
	</main>
</body>
</html>
