<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>All Blogs</title>
    <style type="text/css">
        body {
            font-family: Arial, sans-serif;
            background-color: #f2f2f2;
            margin: 0;
            padding: 20px;
            
           

         
        }

        .blog-entry {
            width: 80%;
            max-width: 800px;
            background-color: #fff;
            border-radius: 8px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
            padding: 20px;
            margin-bottom: 20px;
        }

       
        

        

        .button {
            display: inline-block;
            background-color: #007bff;
            color: #fff;
            border: none;
            border-radius: 4px;
            padding: 8px 12px;
            cursor: pointer;
            margin-left: 10px;
            text-decoration: none;
        }

        .button:hover {
            background-color: #0056b3;
        }
    </style>
</head>
<body>
    <h2 style="text-align: center;">All Blogs</h2>
    <c:forEach var="blog" items="${blogs}">
        <div class="blog-entry">
            <h3>${blog.authorName}</h3>
            <p><strong>ID:</strong> ${blog.id}</p>
            <p><strong>Description:</strong> ${blog.description}</p>
            <p><strong>Publishing Date:</strong> ${blog.publishingdate}</p>
            <p><strong>Email:</strong> ${blog.email}</p>
            <p><strong>Phone Number:</strong> ${blog.phNo}</p>
            <div class="button-container">
                <a href="Blogedit?id=${blog.id}" class="button">Edit</a>
                
                <a href="delete?id=${blog.id}" class="button">Delete</a>
            </div>
        </div>
    </c:forEach>
</body>
</html>
