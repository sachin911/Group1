<!DOCTYPE html>
<html lang="en">
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.group1.Models.Order" %>
	<head>
		<meta charset="UTF-8">
		<title>Trader Order History</title>
		<link rel="stylesheet" href="style/style.css">
	</head>
	<body>
		<header class="menu">
			<img class="menu__logo" src="images/Logo.png">

			<!-- Menu buttons -->
			<div class="menu__buttonbox">
				<input type="button" class="menu__button" value="HOME" onClick="document.homeform.submit()">
				<input type="button" class="menu__button" value="TRADERS" onClick="location.href='pmtraders.html'">
				<input type="button" class="menu__button" value="MAKE A TRADE" onClick="location.href='pmmakeatrade.jsp'">
				<input type="button" class="menu__button" value="PROFIT/LOSS" onClick="document.plform.submit()">
				<input type="button" class="menu__button selected" value="ORDER HISTORY" onClick="document.historyform.submit()">
				<input type="button" class="menu__button logoutbutton" value="LOG OUT" onClick="location.href='logoutservlet'"
>
			</div>
		</header>
		<!-- Header menu buttons end -->
<form name="homeform" action="PMHomeServlet" method="get"></form>
<form name="historyform" action="TradeHistoryServlet" method = "get"></form>
<form name="plform" action="PLServlet" method = "get"></form>
		<main class="orderhistorymain">
		<!-- orderhistory table -->
			<div class="orderhistory">
				<h2 class="orderhistory__header">Order History</h2>
				<div class="scrollwrapper">
					<table class="orderhistory__table" name="orderhistorytable">
						<tr>
							<th name="ordernumber">Order Number</th>
							<th name="date">Date</th>
							<th name="symbol">Symbol</th>
							<th name="orderstatus">Order Status</th>
							<th name="ordertype">Order Type</th>
							<th name="quantity">Quantity</th>
							<th name="side">Side</th>
							<th name="price">Price</th>
						</tr>
						<% ArrayList<Order> list = (ArrayList<Order>) request.getAttribute("displayList");
                   if(list!=null){
				for(int i = 0;i<list.size();i++){ %>
					<tr>
							<td><%=list.get(i).getOrder_id()%></td>
							<td><%=list.get(i).getOrder_date()%></td>
							<td><%=list.get(i).getSymbol()%></td>
							<td><%=list.get(i).getStatus()%></td>
							<td><%=list.get(i).getOrder_type()%></td>
							<td><%=list.get(i).getOpen_quantity()%></td>
							<td><%=list.get(i).getSide()%></td>
							<td><%=list.get(i).getExecuted_price()%></td>
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