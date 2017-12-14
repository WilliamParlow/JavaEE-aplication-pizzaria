<%-- 
    Document   : customnavbar
    Created on : 13/12/2017, 19:40:41
    Author     : Cliente
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<nav class="navbar-default navbar-fixed-top">
    <div class="navbar-header">
        <div class="navbar-container">
            <div class="navbar-pagename">
                <a href="mvcmenu?do=${formmodel.domenu}">
                    <i class="zmdi zmdi-arrow-left"></i>
                </a>
                <div>${formmodel.pageName}</div>
            </div>
            <div>
                <a class="${formmodel.edithidden}" href="${formmodel.controller}?do=updatemodel&id=${formmodel.modelid}">
                    <i class="zmdi zmdi-edit edit-icon"></i>
                </a>
            </div>
        </div>
    </div>
</nav>
