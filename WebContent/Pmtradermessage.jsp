<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
<meta charset="UTF-8">
<title>PM Send a Message</title>
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
			onClick="location.href='logoutServlet'">
	</div>
	</header>
	<!-- Header menu buttons end -->

	<main class="traderinboxmain">
	<div class="messages">
		<h2 class="messages__header">Messages</h2>
		<div class="scrollwrapper">
			<form method="post" action="MessageServlet">
				
				
					Message to <%=request.getParameter("uname") %><textarea style="width: 22rem;height: 10rem;position: relative;"rows="2" cols="16" name="message"></textarea>
				<br>
				
				<input type="text" name="user" value="<%=request.getParameter("uname") %>" style="display:none">
				<input type="submit" value="Submit"/>
			</form>
		</div>
	</div>
	</main>
</body>
</html>
