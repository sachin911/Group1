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
<body onload="document.adminform.submit()">

	<header class="menu">
		<img class="menu__logo" src="images/Logo.png">
	</header>

	<form name="adminform" action="AdminServlet" method="get"></form>


	<main>
	<article class="employeetable">
		<h2>Employees</h2>
		<table class="employee__table" name="employeelist">

			<tr>
				<th name="employeename">Name</th>
				<th name="employeerole">Role</th>
				<th name="employeebuttonbox">Options</th>
			</tr>

			<% ArrayList<Employee> list = (ArrayList<Employee>) request.getAttribute("el");
                   if(list!=null){
				for(int i = 0;i<list.size();i++){ %>
			<tr>
				<th><%=list.get(i).getFirst_Name() %></th>
				<th><%=list.get(i).getRole()%></th>
				<th><%=list.get(i).getLast_Name()%></th>

			</tr>
			<% 	}}%>

			<tbody>

			</tbody>
		</table>
	</article>
	</main>
</body>
</html>