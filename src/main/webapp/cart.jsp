<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="beans.CartItemBean" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>

<%
    List<CartItemBean> cartItems = new ArrayList<>();
    Object cartItemsObj = session.getAttribute("cartItems");
    if (cartItemsObj != null) {
        System.out.println("cart.jsp cartItemsObj=" + cartItemsObj.toString());
    }

    if (cartItemsObj instanceof List<?>) {
    	cartItems = (List<CartItemBean>) cartItemsObj;
    }
%>


<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Shopping Cart</title>
    <link rel="stylesheet" href="css/style.css">
</head>
<body>
	<h2>JHU Online Bookstore</h2>
	
    <h1>Your Shopping Cart</h1>

	<% if (cartItems.isEmpty()){ %>
    	<p> Your cart is empty </p>
    <% } %>
    
    
    <% 	for (CartItemBean item : cartItems) { %>
        <p>Book ID: <%= item.getBookID() %>, Quantity: <%= item.getQuantity() %></p>
    <% } %>    
    
    <a href="checkout.jsp">Proceed to Checkout</a>
    
    <footer>
        <p>&copy; 2024 JHU Online Bookstore. All rights reserved.</p>
    </footer>    
</body>
</html>

