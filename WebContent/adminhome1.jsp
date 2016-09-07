<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"
    import="java.util.*,com.group1.Models.*"%>
<!DOCTYPE html>
<html lang="en">
	<head>
		<meta charset="UTF-8">
		<title>Admin Home Page</title>
		<link rel="stylesheet" href="style/style.css">
	</head>
	<body>
		<header class="menu">
			<img class="menu__logo" src="images/Logo.png">
		</header>
		
		<form name="adminform" action="AdminServlet" method = "get"></form>
		
		
		<main>
			<article class="employeetable">
				<h2>Employees</h2>
				<table class="employee__table" name="employeelist" id="etable">
					<tr>
						<th name="employeename">Name</th>
						<th name="employeerole">Role</th>
						<th name="employeelogins">Login Attempts</th>
						<th name="employeebuttonbox">Options</th>
					</tr>
					<tbody>
						<%ArrayList<Employee> elist = (ArrayList<Employee>)session.getAttribute("el");
						
						if(elist!=null)
							{ 
							for(int i=0;i<elist.size();i++) {
							
						%>
						<tr>
						<td><%=elist.get(i).getUserName() %></td>
						<td><%=elist.get(i).getRole() %></td>
						<td><%=elist.get(i).getLoginAttempts() %></td>
						<td ><button onclick="editemp(this)">Edit</button></td>
						</tr>
						<%}} %>
					</tbody>
				</table>
			</article>
		</main>
		
		<script type="text/javascript">
		function editemp(button)
		{
			
		
			//var elist =new ArrayList<Employee>();
			//elist=(ArrayList<Employee>)session.getAttribute("el");
			var t=button.parentNode.parentNode.rowIndex;
			var a=document.getElementById("etable").rows[t].cells[0].innerHTML;
			alert(a);
			
		}
		</script>
	</body>
</html>