<!DOCTYPE html>
<html>
	<head>
		<title>Login</title>
		<link rel="stylesheet" href="style/style.css">
	</head>
	<body class="loginbody">
		<header class="title">
			<img src="images/Logo.png">
			<h1>Money Tree</h1>
		</header>
		<main class="login">
			<form method="GET" action="LoginServlet">
				<input type="text" class="login__input" name="username" placeholder="Username" required>
				<input type="password" class="login__input" name="password" placeholder="Password" required>
				<input type="submit" class="login__submit" value="Login">
				
			</form>
			<p><%
request.getAttribute("error"); %></p>
		</main>
		
	</body>
	
</html>