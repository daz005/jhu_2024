<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Login</title>
    <link rel="stylesheet" href="css/style.css">
</head>
<body>
	<h2>JHU Online Bookstore</h2>
	
    <h1>Login</h1>
    
    <form action="UserServlet" method="post">
        <input type="hidden" name="action" value="login">
        <label>Email:</label>
        <input type="email" name="email" required><br>
        
        <label>Password:</label>
        <input type="password" name="password" required><br>
        
        <button type="submit">Login</button>
    </form>
    <p style="color:red;">${errorMessage}</p>
    
    
    <footer>
        <p>&copy; 2024 JHU Online Bookstore. All rights reserved.</p>
    </footer>    
</body>
</html>
    