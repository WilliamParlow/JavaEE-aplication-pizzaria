<%-- 
    Document   : default_list
    Created on : 12/12/2017, 18:07:54
    Author     : Cliente
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:choose>
    <c:when test="${datasource.size() > 0 || datasource == null}">
        <c:forEach var="o" items="${datasource}">
            <div class="food-container">
                <div class="food-btn-container">
                    <a class="food-btn btn btn-danger" href="${mvcontroller}?do=deletemodel&id=${o.id}"><i class="zmdi zmdi-delete"></i></a>
                    <a class="food-btn btn btn-warning" href="${mvcontroller}?do=updatemodel&id=${o.id}"><i class="zmdi zmdi-edit"></i></a>
                </div>
                <div class="food-header" style="background-image: url(${o.imageUrl})">
                    <h1>${o.name}</h1>
                </div>
                <div class="food-body">
                    <div class="food-item">
                        <p><span class="food-label">Descrição:&nbsp;</span> ${o.description}</p>
                    </div>
                </div>
                <div class="seeplus-btn-container">
                    <a class="seeplus-btn" href="${mvcontroller}?do=detailsmodel&id=${o.id}">Veja mais...</i></a>
                </div>

            </div>
        </c:forEach>
    </c:when>
    <c:otherwise>
        <div class="food-container text-center alert alert-danger">
            <h3>Nenhum dado foi cadastrado até o momento!</h3>
        </div>
    </c:otherwise>
</c:choose>
