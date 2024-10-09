<%-- 
    Document   : home
    Created on : Jan 29, 2024, 10:11:53 PM
    Author     : hanto
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Staff Home Page</title>
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
            margin: 10px 0;
        }
        a:hover {
            text-decoration: underline;
        }
        h1 {
            color: #333333;
        }
    </style>
</head>
<body>
    <div class="container">
        <h1>Welcome back, staff!</h1>
        <a href="Load_staff_info">Manage Staffs' Information</a>
        <a href="Load_registration_info">Approve Registration</a>
        <a href="Load_vet_info">Manage Vet Information</a>
        <a href="Load_receptionist_info">Manage Receptionist Information</a>
        <a href="Load_working_rotas">Create Working Rota for Vet</a>
        <a href="Generate_analyzed_reports">Generate Analyzed Reports</a>
        <a href="Logout">Logout</a>
    </div>
</body>
</html>

