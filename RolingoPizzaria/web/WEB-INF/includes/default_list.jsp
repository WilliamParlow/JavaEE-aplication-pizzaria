<%-- 
    Document   : default_list
    Created on : 12/12/2017, 18:07:54
    Author     : Cliente
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:forEach var="o" items="${datasource}">
    <div class="food-container">
        <div class="food-header" style="background-image: url(${o.imageUrl})">
            <h1>${o.name}</h1>
        </div>
        <div class="food-body">
            <div class="food-item">
                <p><span class="food-label">Receita:&nbsp;</span> ${o.recipe}</p>
            </div>
            <div class="food-item">
                <p><span class="food-label">Ingrediente:&nbsp;</span>${o.ingredient}</p>
            </div>
        </div>

    </div>
</c:forEach>
