<%-- 
    Document   : manage_vet_info
    Created on : Feb 16, 2024, 2:23:53 AM
    Author     : hanto
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Manage Vet Info Page</title>
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
        input[type=text], input[type=password] {
            padding: 8px;
            margin: 8px 0;
            border: 1px solid #ccc;
            border-radius: 4px;
            box-sizing: border-box; /* Makes the input width more consistent */
        }
        input[type=submit] {
            padding: 10px 15px;
            background-color: #333333;
            color: white;
            border: none;
            border-radius: 4px;
            cursor: pointer;
            box-sizing: border-box;
        }
        input[type=submit]:hover {
            background-color: #555555;
        }
    </style>
</head>
<body>
    <div class="container">
        <a href="Login">Return Home Page</a>
        <h1>Manage Vet Information</h1>
        <p>Search for a vet and update his account.</p>
        <form method="POST" action="Search_vet">
            <input type="text" name="vet_uname" placeholder="Enter vet's username" required>
            <input type="submit" value="Search">
        </form>
    </div>
</body>
</html>

