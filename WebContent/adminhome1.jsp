<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
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
				<table class="employee__table" name="employeelist">
					<tr>
						<th name="employeename">Name</th>
						<th name="employeerole">Role</th>
						<th name="employeebuttonbox">Options</th>
					</tr>
					<tbody>
						
					</tbody>
				</table>
			</article>
		</main>
	</body>
</html>