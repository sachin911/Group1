<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"
	import="java.util.*,com.group1.Controllers.*,com.group1.Models.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html lang="en">
<head>
<meta charset="UTF-8">
<title>Trader Make a Trade</title>
<link rel="stylesheet" href="style/style.css">
</head>
<body>
	<header class="menu"> <img class="menu__logo"
		src="images/Logo.png"> <!-- Menu buttons -->

	</div>
	</header>
	<!-- Header menu buttons end -->
	<form name="historyform" action="TradeHistoryServlet" method="get"></form>

			<div class="menu__buttonbox">
				<input type="button" class="menu__button" value="HOME" onClick="location.href='TraderHomeServlet'">
				<input type="button" class="menu__button" value="INBOX" onClick="location.href='traderinbox.jsp'">
				<input type="button" class="menu__button selected" value="MAKE A TRADE" onClick="location.href='tradermakeatrade.html'">
				<input type="button" class="menu__button" value="PROFIT/LOSS" onClick="location.href='traderprofitloss.html'">
				<input type="button" class="menu__button" value="ORDER HISTORY" onClick="document.historyform.submit()">
				<input type="button" class="menu__button logoutbutton" value="LOG OUT" onClick="location.href='logoutservlet'">
			</div>
		</header>
		<!-- Header menu buttons end -->
	<main class="tradermakeatrademain">
	<div class="makeatrade">
		<h2 class="makeatrade__header">Make a Trade</h2>
		<div class="scrollwrapper">
			<form method="post" action='TraderServlet' id="submit_form">
				<table class="makeatrade__table" id="maketradetable"
					name="tradetable">
					<tr>
						<th name="side">Side</th>
						<th name="symbol">Symbol</th>
						<th name="totalquantity">Total Quantity</th>
						<th name="currency">Currency</th>
						<th name="limitprice">Limit Price</th>
						<th name="stopprice">Stop Price</th>
						<th name="ordertype">Order Type</th>
						<th name="checkbox"></th>
						<th style="display: none" name="OrderId">OrderId</th>
					</tr>
					<tbody>
						<tr>
							<td><select name="ordertypeinput">
									<option value="BUY">Buy</option>
									<option value="SELL">Sell</option>
							</select></td>
							


							<td><input type="text" class="table__input"
								name="symbolinput"></td>

							<td><input type="number" step="1" class="table__input" onkeyup="validate()"
								name="totalquantityinput"></td>

							<td><select name="currencyinput">
									<option value="AUD">AUD</option>
									<option value="CAD">CAD</option>
									<option value="CHF">CHF</option>
									<option value="EUR">EUR</option>
									<option value="GBP">GBP</option>
									<option value="INR">INR</option>
									<option value="USD">USD</option>
							</select></td>

							<td><input type="text" class="table__input"
								name="limitpriceinput"></td>

							<td><input type="text" class="table__input"
								name="stoppriceinput"></td>

							<td><select name="ordertypeinput">
									<option value="LIMIT">Limit</option>
									<option value="STOP">Stop</option>
									<option value="STOP LIMIT">Stop Limit</option>
									<option value="MARKET">Market</option>
							</select></td>
							<td class="displaynone"><input type="checkbox"
								class="checkbox" name="checkbox"></td>
<td style="display:none"><input type="text"
							class="table__input" readonly name="orderid1"
							value="on"></td>
						</tr>
					</tbody>
				</table>
			</form>
		</div>
		<button onclick="addRow('maketradetable')"
			class="createbutton generalbutton" name="addbutton">Add row</button>
		<button onclick="deleteRow('maketradetable')"
			class="deletebutton generalbutton" name="deletebutton">Delete
			row</button>
		<input type="submit" class="submittrade generalbutton" value="Submit"
			name="submittradebutton">
	</div>

	<!-- makeatrade table -->
	<div class="makeatradeinstructions">
		<h2 class="makeatradeinstructions__header">PM Trade Orders</h2>
		<div class="scrollwrapper">
			<table id="makeatradeinstructions__table"
				class="makeatradeinstructions__table" name="tradeinstructionstable">
				<thead>
					<tr>
						<th>Side</th>
						<th>Symbol</th>
						<th>Total Quantity</th>
						<th>Currency</th>
						<th>Limit Price</th>
						<th>Stop Price</th>
						<th>Order Type</th>
						<th style="display: none" name="OrderId">OrderId</th>
						<th></th>
					</tr>
				</thead>
				<tbody>
					<tr>
						<%Employee e = (Employee) session.getAttribute("obj");
							System.out.println("Session object : " + e.getEmployee_id());
							int tid=e.getEmployee_id();
							TraderController tc= new TraderController(); 
							ArrayList<Order> olist= tc.getPMOrders(tid);
							for(int i=0;i<olist.size();i++)
							{%>
						<td><select readonly
							name="sideinput1" value="<%=olist.get(i).getSide() %>"></select></td>
						<td><input type="text" class="table__input" readonly
							name="symbolinput1" value="<%=olist.get(i).getSymbol() %>"></td>
						<td><input type="number" id="quantity" class="table__input"
							name="totalquantityinput1" onkeyup="validate"
							value="<%=olist.get(i).getTotal_quantity() %>"></td>
						<td><select readonly 
							name="currencyinput1" value="<%=olist.get(i).getCurrency() %>"></select></td>
						<td><input type="text" class="table__input" readonly
							name="limitpriceinput1"
							value="<%=olist.get(i).getLimit_price() %>"></td>
						<td><input type="text" class="table__input" readonly
							name="stoppriceinput1" value="<%=olist.get(i).getStop_price() %>"></td>
						<td><select readonly
							name="ordertypeinput1" value="<%=olist.get(i).getOrder_type() %>"></select></td>
						<td style="display: none"><input type="text"
							class="table__input" readonly name="orderid1"
							value="<%=olist.get(i).getOrder_id() %>"></td>
						<td><input type="checkbox" class="checkbox"></td>
					</tr>
					<%} %>
				</tbody>
			</table>
		</div>
	</div>
	<p id="keyup"></p>
	</main>
	<script src="JavaScript/makeatrade.js"></script>
	<script src="JavaScript/bundle.js"></script>
	<script src="https://code.jquery.com/jquery-3.1.0.js"
		integrity="sha256-slogkvB1K3VOkzAI8QITxV3VzpOnkeNVsKvtkYLMjfk="
		crossorigin="anonymous"></script>
	<script>
		
		
		$('.submittrade').on('click',function(){
			 //e.preventDefault();
			    
			/*  var header = $('table thead tr th').map(function () {
			        return $(this).text();
			    });
			 */ 
			 var header = $('table thead tr th').map(function () {
			        return $(this).text();
			    });

			    var tableObj = $('table tbody tr').map(function (i) {
			        var row = {};
			        $(this).find('td').each(function (i) {
			            var rowName = header[i];
			            row[rowName] = $(this).find("input").val();
			            if(rowName=="Side")
			            	row[rowName] = $(this).find("select").val();
			            else if(rowName=="Currency")
			            	row[rowName] = $(this).find("select").val();
			            else if(rowName=="Order Type")
			            	row[rowName] = $(this).find("select").val();
			        });
			        return row;
			    }).get();

			    JSON.stringify(tableObj);
			    console.log(tableObj);
			    
			    $.ajax({
			    	url: 'TraderServlet',
			        type: 'POST',
			        //dataType: 'json',
					data: { 
					      tab_val: JSON.stringify(tableObj) // look here!
					    },
			       // contentType: 'application/json',
			    	success: function(response) {
/* 			    	         console.log(JSON.stringify(data))
			    	                     
			    	         console.log(JSON.parse(data)) */
			    	         
			    	         console.log("inserted into table");
			    	        
			    	    },
			    	fail : function(response){
			    		alert("its fucked");
			    	}
			    	});
			    
			});

		
		</script>
		
		
		<script>
		function validate(){
			
			var q=document.getElementById("quantity").value;
			
			if(Number.isInteger(q)==false)
				{
				
				document.getElementById("keyup").innerHTML="Quantity must be a whole number";
				
				}
			
		};
		</script>
</body>
</html>