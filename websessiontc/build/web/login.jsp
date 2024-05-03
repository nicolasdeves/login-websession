<%-- 
    Document   : login
    Created on : 29 de abr. de 2024, 20:44:41
    Author     : nicolas.deves
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login</title>
    </head>
    <body>
        <h1>Login</h1>
        
        <form action="login" method="post">
            <input type="text" name="user">
            <input type="password" name="password">
            <input type="submit" value="Entrar">
        </form>
    </body>
</html>
