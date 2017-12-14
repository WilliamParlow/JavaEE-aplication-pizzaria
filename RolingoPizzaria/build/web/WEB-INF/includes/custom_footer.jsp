<%-- 
    Document   : custom_footer
    Created on : 14/12/2017, 16:53:00
    Author     : Cliente
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<!-- Custom Footer CSS -->
<link rel="stylesheet" href="assets/css/customs/customfooter.css">

<!-- Footer -->
<footer class="default-footer">

    <div class="footer-btn-container">

        <div class="footer-btn logout-wrap">
            <a href="logout"><i class="zmdi zmdi-replay"></i></a>
        </div>

        <div class="footer-btn new-wrap">
            <a href="${mvcontroller}?do=addmodel"><i class="zmdi zmdi-plus"></i></a>
        </div>

    </div>

</footer>
<!-- JQUERY -->


<script src="assets/js/jquery/jquery-3.2.1.min.js"></script>

<!-- BOOTSTRAP -->
<script src="assets/js/bootstrap/bootstrap.min.js"></script>
