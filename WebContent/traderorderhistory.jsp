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
	<body onLoad="callservlet()">
		<header class="traderMenu">
			<img class="traderMenu__logo" src="images/Logo.png">

			<!-- Menu buttons -->
			<div class="traderMenu__buttonbox">
				<input type="button" class="traderMenu__button" value="HOME" onClick="location.href='traderhome.html'">
				<input type="button" class="traderMenu__button" value="INBOX" onClick="location.href='traderinbox.html'">
				<input type="button" class="traderMenu__button" value="MAKE A TRADE" onClick="location.href='tradermakeatrade.html'">
				<input type="button" class="traderMenu__button" value="PROFIT/LOSS" onClick="location.href='traderprofitloss.html'">
				<input type="button" class="traderMenu__button selected" value="ORDER HISTORY" onClick="location.href='TradeHistoryServlet.java'">
				<input type="button" class="traderMenu__button logoutbutton" value="LOG OUT" onClick="location.href='login.html'">
			</div>
		</header>
		<!-- Header menu buttons end -->
<form name="historyform" action="TradeHistoryServlet" method = "get"></form>
		<main class="traderorderhistorymain">
		<!-- orderhistory table -->
			<div class="orderhistory">
				<h2 class="orderhistory__header">Order History</h2>
				<div class="scrollwrapper">
					<table class="orderhistory__table" name="orderhistorytable">
						<tr>
							<th name="ordernumber">Order Number</th>
							<th name="date">Date</th>
							<th name="orderstatus">Order Status</th>
							<th name="ordertype">Order Type</th>
							<th name="quantity">Quantity</th>
							<th name="term">Term</th>
							<th name="price">Price</th>
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
			<%}}%>
						<tbody>
						</tbody>
					</table>
				</div>
			</div>
		</main>
	</body>
	<script>
	function callservlet()
	{
		document.historyform.submit();
	}
	</script>
</html>