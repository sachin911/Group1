<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
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
				<h2>Add a user</h2>
				<form action="AddUserServlet" method="get">
				<table class="adduser__table">
					<tr>
						<th>First Name</th>
						<th>Last Name</th>
						<th>Username</th>
						<th>Password</th>
						<th>Role</th>
						<th>Manager</th>
					</tr>
					<tbody>
						<tr>
						<td><input type="text" name="first_name"></td>
						<td><input type="text" name="last_name"></td>
						<td><input type="text" name="username"></td>
						<td><input type="text" name="password"></td>
						<td><input type="text" name="role"></td>
						<td><input type="text" name="pm_id"></td>
					</tr>
					</tbody>
				</table>
				<input class="generalbutton" type = "submit" value = "Add" onClick="location.href='adminhome1.jsp'">
				</form>
			</article>
		</main>
	</body>
</html>