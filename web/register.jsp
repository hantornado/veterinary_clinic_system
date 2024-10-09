<%-- 
    Document   : register
    Created on : Jan 30, 2024, 11:32:27 PM
    Author     : hanto
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Registration Page</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f4f4;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
            margin: 0;
        }
        .container {
            background-color: #cccccc;
            padding: 20px;
            border-radius: 5px;
            width: 340px;
            text-align: center;
        }
        h1 {
            color: #333333;
        }
        input[type=text], input[type=password], select {
            width: 100%;
            padding: 8px;
            margin: 8px 0;
            display: inline-block;
            border: 1px solid #ccc;
            border-radius: 4px;
            box-sizing: border-box;
        }
        input[type=submit] {
            width: 100%;
            background-color: #333333;
            color: white;
            padding: 14px 20px;
            margin: 8px 0;
            border: none;
            border-radius: 4px;
            cursor: pointer;
        }
        input[type=submit]:hover {
            background-color: #555555;
        }
        .note {
            font-size: 0.8em;
            color: #333333;
        }
        a {
            color: #333333;
            text-decoration: none;
        }
        a:hover {
            text-decoration: underline;
        }
    </style>
</head>
<body>
    <div class="container">
        <h1>Registration Page</h1>
        <form action="Register_vets_receptionists" method="POST">
            <input type="text" name="uname" placeholder="Username" required>
            <input type="password" name="pwd" placeholder="Password" required>
            <select id="userType" name="userType">
                <option value="">User Type</option>
                <option value="vet">Vet</option>
                <option value="receptionist">Receptionist</option>
            </select>
            <input type="submit" value="Register">
            <p class="note">Note: the registration may take a while, as the managing staff needs to approve the request.</p>
        </form>
        <a href="login.jsp">Return to Login Page</a>
    </div>
</body>
</html>

