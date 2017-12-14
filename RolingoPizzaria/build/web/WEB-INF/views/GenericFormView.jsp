<%-- 
    Document   : GenericFormView
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
        <link rel="stylesheet" href="assets/css/forms/genericform.css">

        <title>${applicationName} - ${formmodel.pageName}</title>

    </head>
    <body>

        <%@include file="/WEB-INF/includes/customnavbar.jsp"%>



        <!-- Page content - Signup and Signin forms -->
        <section class="content-relative container-fluid">

            <div class="col-xs-12">

                <div class="list-container">

                    <div class="form-container">

                        <form id="generalForm" method="POST" action="${formmodel.controller}?do=${formmodel.formaction}&id=${formmodel.modelid}">

                            <input id="id" name="id" value="${formmodel.modelid}" class="hidden" disabled>

                            <c:forEach var="o" items="${formobject}">
                                <div class="form-view-item">
                                    <label for="${o.id}">${o.label}</label>
                                    <input class="${o.classname} ${o.isRequired()}" type="${o.type}" id="${o.id}" name="${o.name}" value="${o.value}" placeholder="${o.placeholder}" ${o.isDisable()} ${o.isRequired()}>
                                </div>
                            </c:forEach>

                            <div class="submit-btn-container">

                                <button class="${formmodel.formhidden}" type="submit">
                                    <i class="zmdi zmdi-check check-icon"></i>
                                </button>

                                <a class="${formmodel.formhidden}" href="mvcmenu?do=${formmodel.domenu}">
                                    <i class="zmdi zmdi-close cancel-icon"></i>
                                </a>

                            </div>

                        </form>

                    </div>

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
