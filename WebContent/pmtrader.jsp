<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.List"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="java.util.HashSet"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
<meta charset="UTF-8">
<title>Trader Inbox</title>
<link rel="stylesheet" href="style/style.css">
</head>
<body>
	<header class="menu"> <img class="menu__logo"
		src="images/Logo.png"> <!-- Menu buttons -->
	<div class="menu__buttonbox">
		<input type="button" class="menu__button" value="HOME"
			onClick="location.href='pmhome1.jsp'"> <input type="button"
			class="menu__button selected" value="TRADERS"
			onClick="location.href='pmTraderServlet'"> <input
			type="button" class="menu__button" value="MAKE A TRADE"
			onClick="location.href='pmmakeatrade.html'"> <input
			type="button" class="menu__button" value="PROFIT/LOSS"
			onClick="location.href='pmprofitloss.html'"> <input
			type="button" class="menu__button" value="ORDER HISTORY"
			onClick="document.historyform.submit()"> <input type="button"
			class="menu__button logoutbutton" value="LOG OUT"
			onClick="location.href='Logoutservlet'">
	</div>
	</header>
	<!-- Header menu buttons end -->
	<form name="historyform" action="TradeHistoryServlet" method="get"></form>
	<main class="pmtraders">
	<h2>Traders</h2>
	<table class="trader__table" name="traderlist" id="trader">
		<tr>
			<th name="tradername">Name</th>
			<th name="traderbuttonbox">Send message</th>
			<th>View portfolio</th>>
		</tr>
		<%
			List<String> result = (ArrayList<String>) request.getAttribute("tli");
						HashSet<String> set = new HashSet<String>(result);
						
						List<String> list = new ArrayList<String>(set);
		                   if(list!=null){
				for(int i = 0;i<list.size();i++){
		%>
		<tr>
			<td><%=list.get(i)%></td>
			<td><input type="button" value="send" onClick="sendMessage(this)" /></td>
			<td><input type="button" value="view" onClick="viewPortfolio(this)" /></td>
		</tr>
		<%
			}}
		%>

		<tbody>

		</tbody>
	</table>
	</main>
</body>

<script type="text/javascript">
	
	function sendMessage(button) {
		
		var rown = button.parentNode.parentNode.rowIndex;
		var u = document.getElementById("trader").rows[rown].cells[0].innerHTML;

		window.location.href = "Pmtradermessage.jsp?uname=" + u;
	}
	function viewPortfolio(button) {
		var rown = button.parentNode.parentNode.rowIndex;
		var u = document.getElementById("trader").rows[rown].cells[0].innerHTML;

		window.location.href = "pmtraderviewportfolio.html?uname=" + u;
	}
	
	</script>

	</html>
<%--function myFunction(button){
	 var urlmenu = document.getElementById("select").value;
	 if(urlmenu=="SendMessage"){
	     
	     	
	      	//alert(button.parentNode.parentNode.rowIndex);    
	      	
	    	
	  	  }else if(urlmenu=="ViewPortfolio"){
	
	  		
	  		     console.log("redirecting");
		     	
		      	//alert(button.parentNode.parentNode.rowIndex);    
		      	var rown = button.parentNode.parentNode.rowIndex;
		      	var u=document.getElementById("trader").rows[rown].cells[0].innerHTML;
		      
		      	window.location.href="pmtraderviewportfolio.html?uname="+u;
		    	
		  	  }
	  		     }
		     	
		      	--%>
	
