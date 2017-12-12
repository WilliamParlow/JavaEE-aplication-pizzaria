/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.org.catolicasc.rolingo.controllers;

import br.org.catolicasc.rolingo.daos.UserDAO;
import br.org.catolicasc.rolingo.daos.entities.User;
import java.io.IOException;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Cliente
 */
@WebServlet(name = "AuthenticationControllerServlet", urlPatterns = {"/login"})
public class AuthenticationControllerServlet extends HttpServlet {

    private static final String PERSISTENCE_UNIT_NAME = "RolingoPersistensePU";

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        EntityManagerFactory factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
        UserDAO userDao = new UserDAO(factory);

        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");

        String login = request.getParameter("login");
        String passwd = request.getParameter("passwd");

        if (login != null && passwd != null) {

            try {

                User user = userDao.findUser(login, passwd);

                if (user != null) {

                    HttpSession session = request.getSession(true);
                    session.setAttribute("userId", Long.toString(user.getId()));
                    session.setAttribute("userName", user.getName());

                    request.getRequestDispatcher("mvcmenu?do=lstpizzas").forward(request, response);

                } else {
                    
                    request.setAttribute("msg", "O usuário " + login + "fornecido não existe ou a senha está incorreta.");
                    request.getRequestDispatcher("Login.jsp").forward(request, response);

                }

            } catch (Exception e) {

                request.setAttribute("msg", "O usuário " + login + "fornecido não existe ou a senha está incorreta.");
                request.getRequestDispatcher("Login.jsp").forward(request, response);

            }

        } else {

            request.setAttribute("msg", "Dados insufucientes. Forneça todos os dados para efetuar o login.");
            request.getRequestDispatcher("Login.jsp").forward(request, response);

        }

    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
