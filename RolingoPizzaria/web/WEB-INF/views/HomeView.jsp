<%-- 
    Document   : HomeView
    Created on : 05/12/2017, 11:38:24
    Author     : Cliente
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        
        <%@include file="/WEB-INF/includes/default_header.jsp"%>
        
        <meta name="description" content="${applicationName}">

        <title>${applicationName} -  ${tittle}</title>
    </head>
    
    <body>
        
        <div class="container-fluid">
            <c:forEach var="o" items="${datasource}">
                <h1>${o.name}</h1>
                <p>${o.url}</p>
            </c:forEach>
        </div>
        
    </body>
    
    <%@include file="/WEB-INF/includes/default_footer.jsp"%>
    
</html>
