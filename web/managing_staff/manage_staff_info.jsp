<%-- 
    Document   : manage_staff_info
    Created on : Jan 29, 2024, 3:32:21 AM
    Author     : hanto
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Manage Staff's Info Page</title>
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
        table {
            margin-left: auto;
            margin-right: auto;
        }
        input[type=text], input[type=password] {
            padding: 8px;
            margin: 8px 0;
            border: 1px solid #ccc;
            border-radius: 4px;
        }
        input[type=submit] {
            padding: 10px 15px;
            background-color: #333333;
            color: white;
            border: none;
            border-radius: 4px;
            cursor: pointer;
        }
        input[type=submit]:hover {
            background-color: #555555;
        }
        h3 {
            color: #333333;
            margin: 20px 0;
        }
    </style>
</head>
<body>
    <div class="container">
        <a href="Login">Return Home Page</a>
        <h3>Manage the staff's information here:</h3> 
        <form method="POST" action="Add_staff_info">
            <h3>Add new staff</h3>
            <p>Only * characters for both username and password<p>
                
            </p>M for Male, F for Female</p>
            <table>
                <tr>
                    <td>Username:</td>
                    <td><input type="text" name="uname" maxlength="8"></td>
                </tr>
                <tr>
                    <td>Password:</td>
                    <td><input type="password" name="pwd" maxlength="8"></td>
                </tr>
                <tr>
                    <td>Gender:</td>
                    <td><input type="text" name="gender" maxlength="1"></td>
                </tr>
            </table>
            <p><input type="submit" value="Add"></p>
        </form>
        <form method="POST" action="Search_staff_info">
            <h3>Search for staff</h3>
            <table>
                <tr>
                    <td>Username:</td>
                    <td><input type="text" name="uname"></td>
                </tr>
            </table>
            <p><input type="submit" value="Search"></p>
        </form>
    </div>
</body>
</html>
