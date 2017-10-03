<%-- 
    Document   : login
    Created on : Oct 3, 2017, 1:06:22 PM
    Author     : 734972
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login</title>
    </head>
    
    <body>
        
        <form action="login" method="POST">
            <br>
            User name: <input type="text" name="username" value="${username}">
            <br>
            Password: <input type="password" name="password">
            <br>
            <input type="submit" value="Submit">
        </form>
        
            <input type="checkbox" name="remember"> Remember me
            <br>
        ${message}
        <br>
        ${logout}
    </body>
</html>
