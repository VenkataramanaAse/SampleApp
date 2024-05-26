<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta charset="UTF-8">
    <title>Create New Blog</title>
    <link rel="stylesheet" type="text/css" href="css/style.css">
    
    <style type="text/css">body {
    font-family: Arial, sans-serif;
    background-color: #f7f7f7;
    margin: 0;
    padding: 0;
}

.container {
    width: 80%;
    max-width: 600px;
    margin: 20px auto;
    background-color: #fff;
    border-radius: 8px;
    box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
    padding: 20px;
}

h2 {
    font-size: 24px;
    margin-bottom: 20px;
    color: #333;
}

table {
    width: 100%;
    margin-bottom: 20px;
}

td {
    padding: 10px 0;
}

input[type="text"],
textarea {
    width: calc(100% - 10px);
    padding: 10px;
    margin-bottom: 15px;
    border: 1px solid #ccc;
    border-radius: 4px;
    box-sizing: border-box;
}

textarea {
    height: 100px;
}

input[type="submit"] {
    background-color: #007bff;
    color: #fff;
    border: none;
    border-radius: 4px;
    padding: 10px 20px;
    cursor: pointer;
    font-size: 16px;
}

input[type="submit"]:hover {
    background-color: #0056b3;
}
    </style>
</head>
<body>
    <div class="container">
        <h2>Create New Blog</h2>
        <form action="saveBlog" method="post">
            <table>
                <tr>
                    <td>Author Name:</td>
                    <td><input type="text" name="authorName" /></td>
                </tr>
                <tr>
                    <td>Description:</td>
                    <td><textarea name="description"></textarea></td>
                </tr>
                <tr>
                    <td>Publishing Date:</td>
                    <td><input type="text" name="publishingdate" /></td>
                </tr>
                <tr>
                    <td>Email:</td>
                    <td><input type="text" name="email" /></td>
                </tr>
                <tr>
                    <td>Phone Number:</td>
                    <td><input type="text" name="phNo" /></td>
                </tr>
                <tr>
                    <td colspan="2">
                        <input type="submit" value="Save" />
                    </td>
                </tr>
            </table>
        </form>
    </div>
</body>
</html>