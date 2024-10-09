<%-- 
    Document   : manage_receptionist_info
    Created on : Feb 15, 2024, 2:14:10 AM
    Author     : hanto
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Manage Receptionist Info Page</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f4f4;
            display: flex;
            flex-direction: column;
            align-items: center;
            margin: 0;
            padding-top: 50px;
        }
        .container {
            background-color: #cccccc;
            padding: 20px;
            border-radius: 5px;
            width: 340px;
            text-align: center;
            color: #333333;
        }
        a {
            color: #333333;
            text-decoration: none;
            display: block;
            margin-bottom: 15px;
        }
        a:hover {
            text-decoration: underline;
        }
        input[type=text], input[type=submit] {
            padding: 10px;
            margin: 10px 0;
            border: 1px solid #ccc;
            border-radius: 4px;
        }
        input[type=submit] {
            background-color: #333333;
            color: white;
            cursor: pointer;
        }
        input[type=submit]:hover {
            background-color: #555555;
        }
        form {
            margin-top: 15px;
        }
    </style>
</head>
<body>
    <div class="container">
        <a href="Login">Return Home Page</a>
        <h1>Manage Receptionist Information</h1>
        <form method="POST" action="Search_receptionist">
            <label for="receptionist_uname">Receptionist's username:</label>
            <input type="text" id="receptionist_uname" name="receptionist_uname" required>
            <input type="submit" value="Search">
        </form>
    </div>
</body>
</html>

