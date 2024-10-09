<%-- 
    Document   : home
    Created on : Feb 3, 2024, 1:12:43 AM
    Author     : hanto
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Vet Home Page</title>
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
    </style>
</head>
<body>
    <div class="container">
        <h1>Welcome back!</h1>
        <a href="Load_profile">Edit profile</a>
        <a href="Load_workingRota">Check working rota</a>
        <a href="Load_appointments_by_vet">View Pending Appointments</a>
        <a href="Load_completed_appointments_by_vet">View Completed Appointments</a>
        <a href="Logout">Logout</a>
    </div>
</body>
</html>

