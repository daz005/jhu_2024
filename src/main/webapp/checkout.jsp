<%@ page language="java" contentType="text/html; charset=UTF-8"   pageEncoding="UTF-8"%>
<%@ page import="beans.UserBean" %>
<%
    // Check if a user is logged in by looking at the session attribute "user"
    UserBean user = (UserBean) session.getAttribute("user");
%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Checkout</title>
    <link rel="stylesheet" href="css/style.css">
</head>
<body>
	<h2>JHU Online Bookstore</h2>
	
    <h1>Checkout</h1>
    <p>Thank you for your order!</p>
    

    <% if (user == null) { %>
    	<p>You may <a href="login.jsp">log in</a> or <a href="register.jsp">register</a> to enjoy a personalized experience before check out.</p>
        
    <% } else { %>
        <h2>Hello, <%= user.getName() %>!</h2> 
        <p>TODO: Checkout page</p>
    
    <% } %>

    <footer>
        <p>&copy; 2024 JHU Online Bookstore. All rights reserved.</p>
    </footer>    
</body>
</html>
