<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
     <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta charset="UTF-8">
    <title>Blog Home</title>
    <link rel="stylesheet" type="text/css" href="css/style.css">
    <style type="text/css">
    

body {
    font-family: 'Arial', sans-serif;
    background-color: #f4f4f4;
    margin: 0;
    padding: 0;
}

.container {
    max-width: 800px;
    margin: 50px auto;
    padding: 20px;
    background-color: #ffffff;
    box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
    border-radius: 8px;
    text-align: center;
}

h1 {
    color: #333333;
    font-size: 2.5em;
    margin-bottom: 20px;
}

.button-container {
    margin-top: 30px;
}

.button {
    display: inline-block;
    padding: 15px 25px;
    font-size: 1em;
    color: #ffffff;
    background-color: #007bff;
    text-decoration: none;
    border-radius: 5px;
    transition: background-color 0.3s ease;
    margin: 10px;
}

.button:hover {
    background-color: #0056b3;
}

    </style>
</head>
<body>
    <div class="container">
        <h1>Welcome to the Blog</h1>
        <div class="button-container">
            <a href= "newBlog" class="button">Create New Blog</a>
            <a href= "showBlogs" class="button">Show All Blogs</a>
        </div>
    </div>
</body>
</html>