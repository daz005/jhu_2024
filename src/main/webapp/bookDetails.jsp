<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ page import="beans.BookBean" %>
<%
    BookBean book = (BookBean) request.getAttribute("book");
%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>${book.title} Details</title>
    <link rel="stylesheet" href="css/style.css">
</head>
<body>
    <h2>${book.title}</h2>
    <p>Author: ${book.author}</p>
    <p>Genre: ${book.genre}</p>
    <p>Price: $${book.price}</p>
    <p>Rating: ${book.rating} / 5</p>

    <form action="CartServlet" method="post">
        <input type="hidden" name="action" value="add">
        <input type="hidden" name="bookID" value="${book.bookID}">
        <label>Quantity:</label>
        <input type="number" name="quantity" value="1" min="1">
        <button type="submit">Add to Cart</button>
    </form>
    
    <footer>
        <p>&copy; 2024 JHU Online Bookstore. All rights reserved.</p>
    </footer>
        
</body>
</html>
