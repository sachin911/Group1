<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
     pageEncoding="ISO-8859-1"
    import="java.util.*,com.group1.Controllers.*"%>
<!DOCTYPE html>
<html lang="en">
	<head>
		<meta charset="UTF-8">
		<title>Admin Edit User</title>
		<link rel="stylesheet" href="style/style.css">
	</head>
	<body>
		<header class="menu">
			<img class="menu__logo" src="images/Logo.png">
		</header>
		<main>
			<article class="adduser">
				<h2>Edit user</h2>
				<form action="EditUserServlet" method="get">
					<%String var=request.getParameter("att"); %>
				<p>Username <input type="text" name="username" value="<%=request.getParameter("uname") %>" readonly=true></td></p>
				<p>First Name <input type="text" name="firstname" value="<%=request.getParameter("fname") %>"/></p>
				<p>Last Name <input type="text" name="lastname" value="<%=request.getParameter("lname") %>"></p>
				<p>Password <input type="password" name="password" value="<%=request.getParameter("pass") %>"></p>
			<!--  	<p>Role <input type="text" name="role" value="<%=request.getParameter("role") %>"></p>
				<p>Manager <input type="text" name="pm_id"  value="<%=request.getParameter("mg") %>"></p>-->
				<select name="role" id="role" onchange="disable(this)">
				
				<option selected  value="<%=request.getParameter("role") %>"> <%=request.getParameter("role") %></option>
				<option value="Trader">Trader</option>
				<option value="PM">PM</option>
				<option value="Admin">Admin</option>
				</select></p>
				<p>Manager<!--  <input type="text" name="pm_id"  >--> 
				<select name="pm_id" id="pm_id" >
				<%AdminController ac = new AdminController(); 
				ArrayList<Integer> pmlist=ac.getpm_id();
				System.out.println(pmlist);
				for(int i=0;i<pmlist.size();i++)
				{
					if(Integer.parseInt(request.getParameter("mg"))==pmlist.get(i))
					{
						%><option selected="selected" value="<%=pmlist.get(i)%>"><%=pmlist.get(i)%></option>
					<%  }
					else
					{
				%>
				
				<option value="<%=pmlist.get(i)%>"><%=pmlist.get(i)%></option>
				<%} }%>
				</select></p>
				<input class="generalbutton" type = "submit" value = "Edit" onClick="AdminHomeServlet">
				</form>
			</article>
		</main>
		<script type="text/javascript" src="JavaScript/edituser.js"></script>
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