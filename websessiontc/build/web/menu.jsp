<%-- 
    Document   : menu
    Created on : 29 de abr. de 2024, 21:42:57
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
        <h1>Menu</h1>
        
        <div class="option">
            <a href="computador.jsp">Computador</a>
            <a href="notebook.jsp">Notebook</a>
            <a href="celular.jsp">Celular</a>
        </div>
        
        <%
            Cookie[] cookies = request.getCookies();
            if(cookies != null) {
                for (Cookie cookie : cookies) {
                    if(cookie.getName().equals("Computador")) {
                        %>
                        <p>Garanta seu COMPUTADOR com 30% somente hoje!!!</p>    
                        <p>Cookie: computador</p>
                        <%
                        
                    } else if (cookie.getName().equals("Notebook")) {
                        %>
                        <p>Garanta seu NOTEBOOK com 30% somente hoje!!!</p>    
                        <p>Cookie: notebook</p>
                        <%
                    } else if (cookie.getName().equals("Celular")) {
                        %>
                        <p>Garanta seu CELULAR com 30% somente hoje!!!</p>    
                        <p>Cookie: celular</p>
                        <%
                    }
                }
            }
        %>
        
    </body>
</html>
