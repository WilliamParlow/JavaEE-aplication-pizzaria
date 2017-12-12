<%-- 
    Document   : default_footer
    Created on : 18/10/2017, 17:06:00
    Author     : Cliente
--%>

<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!-- Footer -->
<footer class="default-footer">
    <address>Developed by Will - <% out.print(new SimpleDateFormat("YYYY").format(new Date()));%></address>
</footer>
<!-- JQUERY -->


<script src="assets/js/jquery/jquery-3.2.1.min.js"></script>

<!-- BOOTSTRAP -->
<script src="assets/js/bootstrap/bootstrap.min.js"></script>
