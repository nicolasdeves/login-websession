<%-- 
    Document   : computador
    Created on : 29 de abr. de 2024, 21:55:44
    Author     : nicolas.deves
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Computador</h1>
        <p>Para comprar seu computador acesse:</p>
        <a href="https://www.pichau.com.br/">Link</a>
        <a href="menu.jsp">Retornar ao menu</a>
        
        <%
          Cookie computadorCookie = new Cookie("Computador", "ultima_pagina_visitada");
          computadorCookie.setMaxAge(3600);
          response.addCookie(computadorCookie);
          
          Cookie notebookCookie = new Cookie("Notebook", "");
          notebookCookie.setMaxAge(0);
          response.addCookie(notebookCookie);
          
          Cookie celularCookie = new Cookie("Celular", "");
          celularCookie.setMaxAge(0);
          response.addCookie(celularCookie);
        %>
        
    </body>
</html>
