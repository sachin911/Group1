<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.List"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="com.group1.Models.Employee"%>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<title>Admin Home Page</title>
<link rel="stylesheet" href="style/style.css">
</head>

<header class="menu">
	<img class="menu__logo" src="images/Logo.png">
</header>

<form name="adminHomeForm" action="AdminServlet" method="get"></form>

<button name="AddUser" onClick="location.href='addUser.jsp'">Add</button>
<button name="LogOut" onClick="location.href='logoutservlet'">Log Out</button>

<main>
<article class="employeetable">
	<h2>Employees</h2>
	<table class="employee__table" name="employeelist" id="etable">

		<tr>
		<th>User name</th>
			<th>First Name</th>
			<th>Last Name</th>
			<th>Role</th>
			<th>Login Attempts</th>
			<th style="display:none">Password</th>
			<th>Manager</th>
			<th>Remove Employee</th>
			<th>Edit Employee</th>

		</tr>

		<% ArrayList<Employee> list = (ArrayList<Employee>) session.getAttribute("el");
                   if(list!=null){
				for(int i = 0;i<list.size();i++){
					session.setAttribute("id",list.get(i).getEmployee_id()); %>
		<tr>
		<td><%=list.get(i).getUserName()%></td>
			<td><%=list.get(i).getFirst_Name()%></td>
			<td> <%=list.get(i).getLast_Name() %></td>
			<td><%=list.get(i).getRole()%></td>
			<td><%=list.get(i).getLoginAttempts()%></td>
			<td style="display:none"><%=list.get(i).getPassword() %></td>
			<td><%=list.get(i).getPm_id() %></td>
			<td><button class="generalbutton" name="remove">Remove</button></td>
			<td><button class="generalbutton" name="edit" id="editButton"
					onclick="editEmp(this)">Edit</button></td>
		</tr>
		<% 	}}%>

		<tbody>

		</tbody>
	</table>
</article>
</main>
<script type="text/javascript">

function editEmp(button)
{ 	
	//alert(button.parentNode.parentNode.rowIndex);    
	var rown = button.parentNode.parentNode.rowIndex;
	var u=document.getElementById("etable").rows[rown].cells[0].innerHTML;
	var f=document.getElementById("etable").rows[rown].cells[1].innerHTML;
	var l=document.getElementById("etable").rows[rown].cells[2].innerHTML;
	var r=document.getElementById("etable").rows[rown].cells[3].innerHTML;
	var p=document.getElementById("etable").rows[rown].cells[5].innerHTML;
	var m=document.getElementById("etable").rows[rown].cells[6].innerHTML;
	//var username = a.get(rowIndex).getUserName();
	
	window.location.href="editUser.jsp?uname="+u+"&fname="+f+"&lname="+l+"&role="+r+"&pass="+p+"&mg="+m;
	
	} 
</script> 
<script type="text/javascript" src="JavaScript/edituser.js"></script>
</body>
</html>