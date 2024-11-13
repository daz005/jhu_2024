<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="beans.BookBean" %>
<%@ page import="java.util.List" %>


<%
    List<BookBean> books = (List<BookBean>) request.getAttribute("books");
%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Book Catalog</title>
    <link rel="stylesheet" href="css/style.css">
</head>
<body>
	<h2>JHU Online Bookstore</h2>
	
    <h1>Book Catalog</h1>
    
    <% if (books.isEmpty()){ %>
    	<p> All books are sold out! </p>
    <% } %>
    
    <% 
        // Iterate over the list of books using a standard Java for-each loop
        for (BookBean book : books) { 
    %>
        <div>
            <h3><%= book.getTitle() %> by <%= book.getAuthor() %></h3>
            <p>Genre: <%= book.getGenre() %></p>
            <p>Price: $<%= book.getPrice() %></p>
            <a href="BookServlet?action=viewBook&bookID=<%= book.getBookID() %>">View Details</a>
        </div>
    <% 
        } 
    %>
    
    
    <footer>
        <p>&copy; 2024 JHU Online Bookstore. All rights reserved.</p>
    </footer>    
</body>
</html>

