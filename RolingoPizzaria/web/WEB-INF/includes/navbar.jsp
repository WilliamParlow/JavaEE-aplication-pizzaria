<%-- 
    Document   : navbar
    Created on : 11/12/2017, 20:07:20
    Author     : Cliente
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<!-- Page navbar -->
<nav class="navbar-default navbar-fixed-top">
    <div class="navbar-header">
        <div class="navbar-item"><a href="mvcmenu?do=lstpizzas" class="${navbarClassName.pizza}">Pizzas</a></div>
        <div class="navbar-item"><a href="mvcmenu?do=lstdesserts" class="${navbarClassName.dessert}">Sobremesas</a></div>
        <div class="navbar-item"><a href="mvcmenu?do=lstdrinks" class="${navbarClassName.drink}">Bebidas</a></div>
    </div>
</nav>
