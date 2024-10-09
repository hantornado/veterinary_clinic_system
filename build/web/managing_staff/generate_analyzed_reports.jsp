<%-- 
    Document   : generate_analyzed_reports
    Created on : Feb 14, 2024, 11:54:25 PM
    Author     : hanto
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Generate Analyzed Reports Page</title>
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
            margin-bottom: 15px;
        }
        a:hover {
            text-decoration: underline;
        }
        p {
            margin: 5px 0;
        }
        .report-image {
            width: 600px;
            height: 400px;
            background-color: #e7e7e7; /* Placeholder style for where the image would be */
            display: block;
            margin: 20px auto;
        }
    </style>
</head>
<body>
    <div class="container">
        <a href='Login'>Return Home Page</a>
        <h1>Analyzed Reports</h1>
        <p>Here is your analyzed reports:</p>

        <div class="report-image">Report Graph</div>
        
    </div>
</body>
</html>

