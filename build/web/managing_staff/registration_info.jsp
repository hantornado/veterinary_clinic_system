<%-- 
    Document   : registration_info
    Created on : Feb 3, 2024, 11:45:21 PM
    Author     : hanto
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Approve Registration Page</title>
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
        h1 {
            color: #333333;
        }
        .return-link {
            position: absolute;
            top: 20px;
            left: 20px;
        }
    </style>
</head>
<body>
    <a href="Login" class="return-link">Return Home Page</a>
    <div class="container">
        <h1>Approve Registration</h1>
        <p>Pending registrations</p>

    </div>
</body>
</html>

