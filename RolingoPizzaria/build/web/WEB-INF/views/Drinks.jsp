<%-- 
    Document   : Login
    Created on : 16/10/2017, 21:12:04
    Author     : Cliente
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">

        <%@include file="/WEB-INF/includes/default_header.jsp"%>

        <title>${applicationName} - ${tittle}</title>

    </head>
    <body>
        
        <%@include file="/WEB-INF/includes/navbar.jsp"%>



        <!-- Page content - Signup and Signin forms -->
        <section class="content-relative container-fluid">

            <div class="col-xs-12">
                
                <div class="list-container">
                    
                    <h1 class="content-header">Lista de Bebidas</h1>
                    
                    <%@include file="/WEB-INF/includes/default_list.jsp"%>
                    
                </div>

            </div>

        </section>

        <!-- Footer -->
        <footer class="default-footer">
            <address>Developed by Will - <% out.print(new SimpleDateFormat("YYYY").format(new Date()));%></address>
        </footer>



        <%@include file="/WEB-INF/includes/default_footer.jsp"%>



    </body>

</html>
