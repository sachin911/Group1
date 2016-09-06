<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html lang="en">
	<head>
		<meta charset="UTF-8">
		<title>PM Home Page</title>
		<link rel="stylesheet" href="style/style.css">
	</head>
	<body>
		<header class="menu">
			<img class="menu__logo" src="images/Logo.png">

			<!-- Menu buttons -->
			<div class="menu__buttonbox">
				<input type="button" class="menu__button selected" value="HOME" onClick="location.href='pmhome1.jsp'">
				<input type="button" class="menu__button" value="TRADERS" onClick="location.href='pmtraders.html'">
				<input type="button" class="menu__button" value="MAKE A TRADE" onClick="location.href='pmmakeatrade.html'">
				<input type="button" class="menu__button" value="PROFIT/LOSS" onClick="location.href='pmprofitloss.html'">
				<input type="button" class="menu__button" value="ORDER HISTORY" onClick="document.historyform.submit()">
				<input type="button" class="menu__button logoutbutton" value="LOG OUT" onClick="location.href='login.html'">
			</div>
		</header>
<form name="historyform" action="TradeHistoryServlet" method="get"></form>
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
							<th>VaR</th>
							<th>Abs. Value Risk</th>
							<th>Stress Testing Results</th>
							<th>Day Ahead</th>
							<th>Base Currency</th>
							<th>USD Value</th>
							<th>P/L</th>
						</tr>
						<tr>
							<td>data</td>
							<td>data</td>
							<td>data</td>
							<td>data</td>
							<td>data</td>
							<td>data</td>
							<td>data</td>
						</tr>
					</table>
				</div>
			</div>
		</main>
	</body>
</html>