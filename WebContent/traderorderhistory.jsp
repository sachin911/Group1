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


		<!-- Header menu buttons end -->
<form name="historyform" action="TradeHistoryServlet" method = "get"></form>
<form name="homeform" action="TraderHomeServlet" method = "get"></form>
		<main class="traderorderhistorymain">

			<div class="menu__buttonbox">
				<input type="button" class="menu__button" value="HOME" onClick="document.homeform.submit()">
				<input type="button" class="menu__button" value="INBOX" onClick="location.href='traderinbox.html'">
				<input type="button" class="menu__button" value="MAKE A TRADE" onClick="location.href='tradermakeatrade.html'">
				<input type="button" class="menu__button" value="PROFIT/LOSS" onClick="location.href='traderprofitloss.html'">
				<input type="button" class="menu__button selected" value="ORDER HISTORY" onClick="document.historyform.submit()">
				<input type="button" class="menu__button logoutbutton" value="LOG OUT" onClick="location.href='login.html'">
			</div>
		</header>
		<!-- Header menu buttons end -->

		<main class="orderhistorymain">

		<!-- orderhistory table -->
			<div class="orderhistory">
				<h2 class="orderhistory__header">Order History</h2>
				<div class="scrollwrapper">
					<table class="orderhistory__table">
						<tr>
							<th>Order Number</th>
							<th>Date</th>
							<th>Order Status</th>
							<th>Order Type</th>
							<th>Quantity</th>
							<th>Term</th>
							<th>Price</th>
						</tr>
			<% ArrayList<Order> list = (ArrayList<Order>) request.getAttribute("displayList");
                   if(list!=null){
				for(int i = 0;i<list.size();i++){ %>
					<tr>
							<th><%=list.get(i).getOrder_id()%></th>
							<th><%=list.get(i).getOrder_date()%></th>
							<th><%=list.get(i).getStatus()%></th>
							<th><%=list.get(i).getAccount_type()%></th>
							<th><%=list.get(i).getOpen_quantity()%></th>
							<th><%=list.get(i).getSide()%></th>
							<th><%=list.get(i).getExecuted_price()%></th>
						</tr>
		<% 	}}%>
						<tbody>
						</tbody>
					</table>
				</div>
			</div>
		</main>
	</body>
	<script>

	</script>
</html>

