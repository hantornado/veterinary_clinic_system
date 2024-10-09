<%-- 
    Document   : login
    Created on : Jan 29, 2024, 10:19:34 PM
    Author     : hanto
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Login Page</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background: #f4f4f4;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
            margin: 0;
        }
        .login-container {
            background: #cccccc; /* Adjusted to match the grayscale theme */
            padding: 20px;
            border-radius: 5px;
            width: 300px;
            text-align: center;
            box-shadow: none; /* No shadow for a flat design */
        }
        .login-form {
            margin: 0 auto;
        }
        .login-form input[type="text"],
        .login-form input[type="password"],
        .login-form select {
            width: 100%; /* Full width */
            padding: 10px;
            margin: 10px 0; /* Space between inputs */
            background: #e7e7e7; /* Light gray background */
            border: none; /* No borders */
            box-sizing: border-box;
        }
        .login-form button {
            width: 100%;
            padding: 10px;
            border: none;
            background: #333; /* Dark gray background */
            color: white;
            cursor: pointer;
            border-radius: 0; /* No border radius */
        }
        .login-form button:hover {
            background: #555;
        }
        .register-link {
            color: #000; /* Black text for visibility */
            text-decoration: none;
        }
        .register-link:hover {
            text-decoration: underline;
        }
    </style>
</head>
<body>
    <div class="login-container">
        <h1>APU Vet Clinic</h1>
        <form action="Login" method="POST" class="login-form">
            <input type="text" name="uname" placeholder="Username" required>
            <input type="password" name="pwd" placeholder="Password" required>
            <select id="userType" name="userType">
                <option value="managingStaff">Managing Staff</option>
                <option value="vet">Vet</option>
                <option value="receptionist">Receptionist</option>
            </select>
            <button type="submit">Sign in</button>
        </form>
        <p class="register-link"><a href="register.jsp">New user? Press here to register</a></p>
    </div>
</body>
</html>

