
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"
    import="java.util.*,com.group1.Controllers.*"%>
<!DOCTYPE html>
<html lang="en">
	<head>
		<meta charset="UTF-8">
		<title>Admin Add User</title>
		<link rel="stylesheet" href="style/style.css">
	</head>
	<body>
		<header class="menu">
			<img class="menu__logo" src="images/Logo.png">
		</header>
		<main>
			<article class="adduser">
				<h2>Add user</h2>
				<form action="AddUserServlet" method="get">
					
				<p>First Name <input type="text" name="firstname" /></p>
				<p>Last Name <input type="text" name="lastname" ></p>
				<p>Username <input type="text" name="username" ></p>
				<p>Password <input type="password" name="password" ></p>
				<p>Role <!--  <input type="text" name="role" >-->
				<select name="role" id="role" onchange="disable(this)">
				<option value="Trader">Trader</option>
				<option value="PM">PM</option>
				<option value="Admin">Admin</option>
				</select></p>
				<p>Manager<!--  <input type="text" name="pm_id"  >--> 
				<select name="pm_id" id="pm_id">
				<%AdminController ac = new AdminController(); 
				ArrayList<Integer> pmlist=ac.getpm_id();
				System.out.println(pmlist);
				for(int i=0;i<pmlist.size();i++)
				{
				%>
				
				<option value="<%=pmlist.get(i)%>"><%=pmlist.get(i)%></option>
				<%} %>
				</select></p>

				<input class="generalbutton" type = "submit" value = "Edit">
				<button class="generalbutton" onClick="adminhome1.jsp">Cancel</button>
				</form>
			</article>
		</main>
		<script>
		function disable(sel)
		{
			var droplistval=sel.value;
			if(droplistval==="Trader")
				document.getElementById("pm_id").disabled=false;
			else
				document.getElementById("pm_id").disabled=true;
		}
		</script>
	</body>
</html>