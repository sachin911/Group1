<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
       pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<head>
<title>Login</title>
<link rel="stylesheet" href="style/style.css">
</head>
<body class="loginbody">
       <header class="title"> <img src="images/Logo.png">
       <h1>Money Tree</h1>
       </header>
       <main class="login">
       <form method="GET" action="LoginServlet">
              <input type="text" class="login__input" name="username"
                     placeholder="Username" required> <input type="password"
                     class="login__input" name="password" placeholder="Password" required>
                     <input type="submit" class="login__submit" value="Login"
                     name="submit" id="submitbutton" ">

<% if(null!=request.getAttribute("error"))
              {%>
       <p><%=request.getAttribute("error")%></p>
              <%}%>

       <%--   <%
                      if(request.getAttribute("buttondisable")){
              %>
                  <input type="submit" class="login__submit" value="Login"
                     name="submit" id="submitbutton"  disabled="disabled">

              <%
                      } else { 
              %>
                <input type="submit" class="login__submit" value="Login"
                     name="submit" id="submitbutton" ">

              <%
                      } 
              %>--%>
       </form>



       </main>
         
       
</body>
</html>

 
 
       </main>
        
      
</body>
</html>

