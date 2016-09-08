<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"
	import="java.util.*,com.group1.Controllers.*,com.group1.Models.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
<meta charset="UTF-8">
<title>PM Make a Trade</title>
<link rel="stylesheet" href="style/style.css">
</head>
<body>
	<header class="menu"> <img class="menu__logo"
		src="images/Logo.png"> <!-- Menu buttons -->
	<div class="menu__buttonbox">
		<input type="button" class="menu__button" value="HOME"
			onClick="location.href='pmhome.html'"> <input type="button"
			class="menu__button" value="TRADERS"
			onClick="location.href='pmtraders.html'"> <input
			type="button" class="menu__button selected" value="MAKE A TRADE"
			onClick="location.href='pmmakeatrade.jsp'"> <input
			type="button" class="menu__button" value="PROFIT/LOSS"
			onClick="location.href='pmprofitloss.html'"> <input
			type="button" class="menu__button" value="ORDER HISTORY"
			onClick="location.href='pmorderhistory.html'"> <input
			type="button" class="menu__button logoutbutton" value="LOG OUT"
			onClick="location.href='login.html'">
	</div>
	</header>
	<!-- Header menu buttons end -->

	<main class="pmmakeatrademain">
	<div class="makeatrade">
		<h2 class="makeatrade__header">Make a Trade</h2>
		<div class="scrollwrapper">
			<table class="makeatrade__table" id="maketradetable"
				name="tradetable">
				<thead>
					<tr>
						<th name="Trader/Broker">Trader/Broker</th>
						<th name="TraderId">TraderId</th>
						<th name="sideinput">Side</th>
						<th name="symbolinput">Symbol</th>
						<th name="totalquantityinput">Total Quantity</th>
						<th name="currencyinput">Currency</th>
						<th name="limitpriceinput">Limit Price</th>
						<th name="stoppriceinput">Stop Price</th>
						<th name="ordertypeinput">Order Type</th>
					</tr>
				</thead>
				<tbody>
					<tr>
						<td><select name="Trader/Broker" onchange="disable(this)">
								<option selected value="Trader">Trader</option>
								<option value="Broker">Broker</option>
						</select></td>
						<td><select id="TraderId" name="TraderId">
								<%AdminController ac=new AdminController();
							Employee e = (Employee) session.getAttribute("obj");
							List<Integer> tlist = ac.getAllPMTraders(e.getEmployee_id());
							for(int i=0;i<tlist.size();i++)
							{
							%>
								<option value="<%=tlist.get(i)%>"><%=tlist.get(i)%></option>
								<%} %>
						</select>
						<td><select name="sideinput">
								<option value="BUY">Buy</option>
								<option value="SELL">Sell</option>
						</select></td>
						<td><input type="text" class="table__input"
							name="symbolinput"></td>
						<td><input type="text" class="table__input"
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

					</tr>
				</tbody>
			</table>
		</div>
		<input type="submit" class="submittrade generalbutton" value="Submit"
			name="submittradebutton">
	</div>
	</main>

	<script src="JavaScript/bundle.js"></script>
	<script src="https://code.jquery.com/jquery-3.1.0.js"
		integrity="sha256-slogkvB1K3VOkzAI8QITxV3VzpOnkeNVsKvtkYLMjfk="
		crossorigin="anonymous"></script>
	<script>
	
	$('.submittrade').on('click',function(){
		 //e.preventDefault();
		    var header = $('table thead tr th').map(function () {
		        return $(this).text();
		    });

		    var tableObj = $('table tbody tr').map(function (i) {
		        var row = {};
		        $(this).find('td').each(function (i) {
		            var rowName = header[i];
		            row[rowName] = $(this).find("input").val();
		            if(rowName==="Trader/Broker")
		            	row[rowName] = $(this).find("select").val();
		            else if(rowName==="TraderId")
		            row[rowName] = $(this).find("select").val();
		            else if(rowName==="Side")
		            	row[rowName] = $(this).find("select").val();
		            else if(rowName==="Currency")
		            	row[rowName] = $(this).find("select").val();
		            else if(rowName==="Order Type")
		            	row[rowName] = $(this).find("select").val();
		        });
		        return row;
		    }).get();

		    JSON.stringify(tableObj);
		    console.log(tableObj);
		    
		    $.ajax({
		    	url: 'PMTradeServlet',
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
function disable(sel)
{
	var droplistval=sel.value;
	if(droplistval==="Trader")
		document.getElementById("TraderId").disabled=false;
	else
		document.getElementById("TraderId").disabled=true;
}
</script>

</body>
</html>