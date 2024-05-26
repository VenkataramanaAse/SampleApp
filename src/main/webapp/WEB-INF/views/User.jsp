<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ page import="java.util.*" %>
    <%@ page import="java.time.LocalDateTime" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title>User Details</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 0;
            padding: 0;
            background-color: #f2f2f2;
        }
        .container {
            max-width: 800px;
            margin: 20px auto;
        }
        .card {
            background-color: #fff;
            border-radius: 8px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
            padding: 20px;
            margin-bottom: 20px;
        }
        .card-title {
            font-size: 24px;
            margin-bottom: 10px;
            color: #333;
        }
        .card-info {
            color: #666;
            margin-bottom: 10px;
        }
        .card-description {
            color: #333;
            margin-bottom: 20px;
        }
        .card-link {
            color: #007bff;
            text-decoration: none;
            font-weight: bold;
        }
    </style>
</head>
<body>
    <div class="container">
        <div class="card">
            <h2 class="card-title">Java Developer</h2>
            <% LocalDateTime postTime = (LocalDateTime) session.getAttribute("LoginTime"); %>
            <p class="card-info">Date: <%= postTime %></p>
            <p class="card-info">Author: ${user.user_Name}</p>
            <p class="card-description">${user.user_Name} is a Good tester</p>
            <p class="card-info">Author Email: ${user.user_Email}</p>
            <p class="card-info">Author Phone Number: ${user.user_Phno}</p>
            <a href="#" class="card-link">Read more</a>
        </div>
    </div>
</body>
</html>