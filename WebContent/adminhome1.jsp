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

	<button name = "AddUser" onclick="location.href='adminadduser.html'" >Add New User</button>

	<main>
	<article class="employeetable">
		<h2>Employees</h2>
		<table class="employee__table" name="employeelist">

			<tr>
				<th name="employeename">Name</th>
				<th name="employeerole">Role</th>
				<th name="employeeLogins">Login Attempts</th>
				<th name="employeebuttonbox">Remove Employee</th>
				<th name="employeeeditbox">Edit Employee</th>
				
				
			</tr>

			<% ArrayList<Employee> list = (ArrayList<Employee>) request.getAttribute("el");
                   if(list!=null){
				for(int i = 0;i<list.size();i++){ %>
			<tr>
				<th><%=list.get(i).getFirst_Name()  + " " + list.get(i).getLast_Name() %></th>
				<th><%=list.get(i).getRole()%></th>
				<th><%=list.get(i).getLoginAttempts()%></th>
				<th><button name = "remove" onclick="removeEmp()">Remove</button></th>
				<th><button name = "edit" onclick= "editEmp()">Reset Login</button></th>
				

			</tr>
			<% 	}}%>

			<tbody>

			</tbody>
		</table>
	</article>
	</main>
	<script>
	
/* 	$(function() {
		  var bid, trid;
		  $('#test tr').click(function() {
		       trid = $(this).attr('id'); // table row ID 
		       alert(trid);
		  });

   $(".remove").click(function(){
		  var rowOfData = $(this).closest(".row-of-data");
	   // now do something with the row, like rowOfData.text()
	 });
		  */ 
function removeEmp()
{ 
	Employee emp = list.get(element.parentNode.parentNode.rowIndex);
	alert(element.parentNode.parentNode.rowIndex);
     AdminController ac = new AdminController();
     ac.removeAdminController(emp);
     document.adminHomeForm.submit();

	} 

function editEmp()
{ 
	Employee emp = list.get(element.parentNode.parentNode.rowIndex);
	alert(element.parentNode.parentNode.rowIndex);     
	AdminController ac = new AdminController();
     ac.editAdminController(emp);
     document.adminHomeForm.submit();
	} 
</script>
	
</body>
</html>