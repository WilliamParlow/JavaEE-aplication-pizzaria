<%-- 
    Document   : home
    Created on : 19/10/2017, 17:31:19
    Author     : Cliente
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        
        <hr>
        
        <p>
            <b>UserID:&nbsp;</b><% session.getAttribute("userId"); %>
        </p>
        <p>
            <b>User name:&nbsp;</b><% session.getAttribute("userName"); %>
        </p>
        
    </body>
</html>
