<%-- 
    Document   : manage_appointments
    Created on : Feb 13, 2024, 10:26:02 PM
    Author     : hanto
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="JSP_utils.DropDownMenus" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Manage Appointments Page</title>
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
            width: auto;
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
            margin: 20px auto;
        }
        input[type=text], input[type=submit] {
            padding: 8px;
            margin: 8px 0;
            border: 1px solid #ccc;
            border-radius: 4px;
            box-sizing: border-box;
        }
        input[type=submit] {
            background-color: #333333;
            color: white;
            border: none;
            cursor: pointer;
        }
        input[type=submit]:hover {
            background-color: #555555;
        }
        h3 {
            color: #333333;
        }
    </style>
</head>
<body>
    <div class="container">
        <a href="Login">Return Home Page</a>
        <p>You can manage appointments here! You can create, edit, and cancel appointments. For each appointment created, you can create a customer profile and a pet profile, then assign a vet to the appointment:</p>
        <form method="POST" action="Create_appointment">
            <h3>Create Appointment</h3>
            <input type="text" name="year" placeholder="Year (Date)">
            <input type="text" name="month" placeholder="Month (Date)">
            <input type="text" name="day" placeholder="Day (Date)">
            <input type="text" name="hour" placeholder="Hour (Time)">
            <input type="text" name="minute" placeholder="Minute (Time)">
            <input type="text" name="assigned_vet" placeholder="Assigned Vet">
            <h3>Create Customer Profile</h3>
            <input type="text" name="cust_uname" placeholder="Customer Username (<= 8 characters)">
            <input type="text" name="gender" placeholder="Gender (M or F)">
            <input type="text" name="email_adr" placeholder="Email address">
            <input type="text" name="contact_num" placeholder="Contact Number">
            <input type="text" name="nationality" placeholder="Nationality">
            <input type="text" name="age" placeholder="Age">
            <h3>Create Pet Profile</h3>
            <input type="text" name="pet_name" placeholder="Pet name (<= 8 characters)">
            <p><%= new DropDownMenus().expertisesDropDown_JSP("species", "species") %></p>
            <p><input type="submit" value="Create"></p>
        </form>
    </div>
</body>
</html>


