<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.group1.Models.Notification" %>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<title>Trader Inbox</title>
<link rel="stylesheet" href="style/style.css">
</head>
<body>
	<header class="menu">
		<img class="menu__logo" src="images/Logo.png">

		<!-- Menu buttons -->

		<div class="menu__buttonbox">
			<input type="button" class="menu__button" value="HOME"
				onClick="location.href='traderhome1.jsp'"> <input
				type="button" class="menu__button selected" value="INBOX"
				onClick="location.href='traderinbox.jsp'"> <input
				type="button" class="menu__button" value="MAKE A TRADE"
				onClick="location.href='tradermaketrade.jsp'"> <input
				type="button" class="menu__button" value="PROFIT/LOSS"
				onClick="document.plform.submit()"> <input type="button"
				class="menu__button" value="ORDER HISTORY"
				onClick="document.historyform.submit()"> <input
				type="button" class="menu__button logoutbutton" value="LOG OUT"
				onClick="location.href='logoutservlet'">

		</div>
	</header>
	<!-- Header menu buttons end -->
	<form name="historyform" action="TradeHistoryServlet" method="get"></form>
	<form name="plform" action="PLServlet" method="get"></form>
	<form name="inboxform" action="NotificationServlet" method="get"></form>

	<main class="traderinboxmain">
	<div class="messages">
		<h2 class="messages__header">Messages</h2>
		<div class="scrollwrapper">
			<table class="messages__table" name="messagetable">
				<tr>
					<th name="date">Date</th>
					<th name="date">Sender</th>
					<th name="message">Message</th>
				</tr>
				<% ArrayList<Notification> list = (ArrayList<Notification>) request.getAttribute("displayList");
                   if(list!=null){
				for(int i = 0;i<list.size();i++){ %>
				<tr>
					<td><%=list.get(i).getSend_date()%></td>
					<td><%=list.get(i).getSender_id()%></td>
					<td><%=list.get(i).getContent()%></td>
				</tr>
				<% 	}}%>
			</table>
		</div>
	</div>
	</main>
</body>
</html>