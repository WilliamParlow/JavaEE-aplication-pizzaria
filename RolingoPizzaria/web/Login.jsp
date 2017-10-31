<%-- 
    Document   : Login
    Created on : 16/10/2017, 21:12:04
    Author     : Cliente
--%>

<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">

        <%@include file="default_header.jsp"%>

        <link rel="stylesheet" href="login.css">
        <link rel="stylesheet" href="loading.css">

        <title>Entre na Rolingo - O Melhor Sistema de gerenciamento de Pizzaria</title>

    </head>
    <body>
        
        
        <!-- Loading ring -->
        <div id="dualRingLoading" class="lds-css">
            <div class="lds-dual-ring">
                <div class="spinner-container">
                    <div></div>
                </div>
            </div>
        </div>

        <!-- Page navbar -->
        <nav class="navbar-login navbar-fixed-top">
            <div class="container-fluid">
                <div class="navbar-header">
                    <a class="navbar-brand" href="#">Rolingo Pizzaria</a>
                </div>
            </div>
        </nav>
        
        

        <!-- Page content - Signup and Signin forms -->
        <section class="login-relative container-fluid">

            <div class="col-xs-12">
                
                
                
                <!-- Signin form -->
                <form id="signin" method="POST" action="login/UserAuthenticationServlet" class="loginForm panel fade-out">

                    <header class="panel-heading text-center">

                        <h4 class="bold">
                            <b>Entre na Rolingo!</b>
                        </h4>

                    </header>

                    <main class="panel-body">

                        <div class="form-group">
                            <label for="login">Email:&nbsp;</label>
                            <input class="form-control" name="login" id="login" type="email" placeholder="Entre com seu email!" required>
                        </div>

                        <div class="form-group">
                            <label for="passwd">Senha:&nbsp;</label>
                            <input class="form-control" name="passwd" id="passwd" type="password" placeholder="Entre com sua senha!" required>
                        </div>
                        
                        <div class="invalid-text-form">${msg}</div>

                    </main>

                    <footer class="panel-footer text-center">

                        <button type="submit" class="login-btn">Entrar!</button>

                        <div class="form-toggler-container">
                            <a class="form-toggler" data-fade_in_target="#signup" data-fade_out_target="#signin">Não possui conta? Crie uma!</a>
                        </div>

                    </footer>

                </form>
                
                
                
                
                <!-- Signup form -->
                <form id="signup" action="login/CreateNewUser" method="POST" class="loginForm panel fade-in">

                    <header class="panel-heading text-center">

                        <h4 class="bold">
                            <b>Cadastre-se na Rolingo!</b>
                        </h4>

                    </header>

                    <main class="panel-body">

                        <div class="form-group">
                            <label for="name">Nome:&nbsp; </label>
                            <input class="form-control" name="name" id="name" type="text" placeholder="Digite seu nome!" required>
                        </div>

                        <div class="form-group">
                            <label for="login">Email:&nbsp; </label>
                            <input class="form-control" name="login" id="login" type="email" placeholder="Digite seu email!" required>
                        </div>

                        <div class="form-group">
                            <label for="passwd">Senha:&nbsp;</label>
                            <input class="form-control" name="passwd" id="passwd" type="password" placeholder="Digite sua senha!" required>
                        </div>
                        
                        <div class="invalid-text-form">${msg}</div>

                    </main>

                    <footer class="panel-footer text-center">

                        <button type="submit" class="login-btn">Cadastrar e entrar!</button>

                        <div class="form-toggler-container">
                            <a class="form-toggler" data-fade_in_target="#signin" data-fade_out_target="#signup">Já possui uma conta? Entre!</a>
                        </div>

                    </footer>

                </form>
                
                

                
            </div>

        </section>

        <!-- Footer -->
        <footer class="login-footer">
            <address>Developed by Will - <% out.print(new SimpleDateFormat("YYYY").format(new Date()));%></address>
        </footer>

        
        
        <%@include file="default_footer.jsp"%>

        <script src="loginEvents.js"></script>
        

    </body>
    
</html>
