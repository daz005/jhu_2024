<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Register</title>
    <link rel="stylesheet" href="css/style.css">
</head>
<body>
	<h2>JHU Online Bookstore</h2>
	
    <h1>Register</h1>
    
    <form action="UserServlet" method="post">
        <input type="hidden" name="action" value="register">
        
        <label>Name:</label>
        <input type="text" name="name" required><br>

        <label>Email:</label>
        <input type="email" name="email" required><br>

        <label>Password:</label>
        <input type="password" name="password" required><br>

        <label>Address:</label>
        <input type="text" name="address" required><br>

        <button type="submit">Register</button>
    </form>
    <p style="color:red;">${errorMessage}</p>
    
    
    <footer>
        <p>&copy; 2024 JHU Online Bookstore. All rights reserved.</p>
    </footer>    
</body>
</html>
