<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>


<%@ page import="beans.UserBean" %>
<%
    // Check if a user is logged in by looking at the session attribute "user"
    UserBean user = (UserBean) session.getAttribute("user");
%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Home - JHU Online Bookstore</title>
    <link rel="stylesheet" href="css/style.css">
</head>
<body>
	<h2>JHU Online Bookstore</h2>
	<h1>Home Page</h1>
	
    <nav>
        <ul>
            <li><a href="BookServlet?action=viewCatalog">Browse Catalog</a></li>
            <li><a href="cart.jsp">View Cart</a></li>
        </ul>
    </nav>



        <% if (user == null) { %>
        	<p>Please <a href="login.jsp">log in</a> or <a href="register.jsp">register</a> to enjoy a personalized experience.</p>

            
        <% } else { %>
            <h2>Hello, <%= user.getName() %>!</h2> 
            <p>Welcome back! Start exploring our latest collection of books.</p>
            <p><a href="UserServlet?action=logout">Logout</a></p>              
        <% } %>
   

    <footer>
        <p>&copy; 2024 JHU Online Bookstore. All rights reserved.</p>
    </footer>
</body>
</html>
