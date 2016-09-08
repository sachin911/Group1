
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
					
				<p>First Name <input type="text" name="firstname" required/></p>
				<p>Last Name <input type="text" name="lastname" required></p>
				<p>Username <input type="text" id="username" name="username" required ></p>
				<p>Password <input type="password" id="password" name="password" onkeyup="validate()" required></p>
				<p id ="keyup"></p>
				
				<p>Role <!--  <input type="text" name="role" >-->
				<select required name="role" id="role" onchange="disable(this)">
				<option selected value="Trader">Trader</option>
				<option value="PM">PM</option>
				<option value="Admin">Admin</option>
				</select></p>
				<p>Manager<!--  <input type="text" name="pm_id"  >--> 
				<select required name="pm_id" id="pm_id">
				<%AdminController ac = new AdminController(); 
				ArrayList<Integer> pmlist=ac.getpm_id();
				System.out.println(pmlist);
				for(int i=0;i<pmlist.size();i++)
				{
				%>
				
				<option value="<%=pmlist.get(i)%>"><%=pmlist.get(i)%></option>
				<%} %>
				</select></p>

				<input class="generalbutton" type = "submit" value = "Add">
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
		function validate(){
			
			var u=document.getElementById("username").value;
			var p=document.getElementById("password").value;
			
			if(u===p)
				{
				
				document.getElementById("keyup").innerHTML="Username = Password";
				
				}
			else if(p.length<8)
			{
				document.getElementById("keyup").innerHTML="Password too short, minimum 8 characters";
			}
			else 
				{
				document.getElementById("keyup").innerHTML="";
				}
			
		};
		</script>
	</body>
</html>