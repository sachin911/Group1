<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<%@ page import="java.util.*" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.group1.Models.Order" %>
	<head>
		<meta charset="UTF-8">
		<title>Trader Profit Loss</title>
		<link rel="stylesheet" href="style/style.css">
	</head>
	<body>
		<header class="menu">
			<img class="menu__logo" src="images/Logo.png">

			<!-- Menu buttons -->
			<div class="menu__buttonbox">
				<input type="button" class="menu__button" value="HOME" onClick="document.homeform.submit()">
				<input type="button" class="menu__button" value="TRADERS" onClick="location.href='pmtraders.html'">
				<input type="button" class="menu__button" value="MAKE A TRADE" onClick="location.href='pmmakeatrade.html'">
				<input type="button" class="menu__button selected" value="PROFIT/LOSS" onClick="document.plform.submit()">
				<input type="button" class="menu__button" value="ORDER HISTORY" onClick="document.historyform.submit()">
				<input type="button" class="menu__button logoutbutton" value="LOG OUT" onClick="location.href='login.html'">
			</div>
		</header>
		<!-- Header menu buttons end -->
<form name="historyform" action="TradeHistoryServlet" method = "get"></form>
<form name="plform" action="PLServlet" method = "get"></form>
<form name="homeform" action="PMHomeServlet" method="get"></form>
		<main class="traderproflossmain">
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
							<th name="pl">P/L</th>
						</tr>
						<% List<Order> list = (ArrayList<Order>) request.getAttribute("displayPlList");
                   if(list!=null){
				for(int i = 0;i<list.size();i++){ %>
					<tr>
					
							<th><%=list.get(i).getSymbol()%></th>
							<th><%=list.get(i).getOpen_quantity()%></th>
							<th><%=list.get(i).getOrder_type()%></th>
							<th><%=list.get(i).getExecuted_price()%></th>
							<th ><% Random rand = new Random();float current_price;%>
							<%= current_price = (float)((list.get(i).getExecuted_price() + rand.nextDouble()*15) - 5) %></th>
							<th><%=list.get(i).getCurrency()%></th>
							<th><%float pl; %><%= pl = (float) (list.get(i).getExecuted_price() - current_price) * list.get(i).getOpen_quantity() %></th>
						</tr>
		<% 	}}%>
						<tbody>
							
						</tbody>
					</table>
				</div>
			</div>
		</main>
	</body>
</html>