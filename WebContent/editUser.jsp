<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
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
				<table class="adduser__table" name="adduser">
					<tr>
						<th>Username</th>
						<th>First Name</th>
						<th>Last Name</th>
						<th>Password</th>
						<th>Role</th>
						<th>Manager</th>
					</tr>
					<tbody>
					<%String var=request.getParameter("att"); %>
						<tr>
						<td name="username"><%=request.getParameter("uname") %>></td>
						<td><input type="text" name="firstname" value="<%=request.getParameter("fname") %>"/></td>
						<td><input type="text" name="lastname" value="<%=request.getParameter("lname") %>"></td>
						<td><input type="password" name="password" value="<%=request.getParameter("pass") %>"></td>
						<td><input type="text" name="role" value="<%=request.getParameter("role") %>"></td>
						<td><input type="text" name="pm_id"  value="<%=request.getParameter("mg") %>"></td>
					</tr>
					</tbody>
				</table>
				<input class="generalbutton" type = "submit" value = "Edit" onClick="AdminHomeServlet">
			</article>
		</main>
		<script type="text/javascript" src="JavaScript/edituser.js"></script>
	</body>
</html>