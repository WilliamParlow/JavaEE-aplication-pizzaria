/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.org.catolicasc.rolingo.json.servlets;

import br.org.catolicasc.rolingo.daos.UserDAO;
import br.org.catolicasc.rolingo.daos.entities.User;
import br.org.catolicasc.rolingo.json.results.SimpleResult;
import br.org.catolicasc.rolingo.json.results.Error;
import com.google.gson.Gson;
import java.io.IOException;
import java.io.PrintWriter;
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
@WebServlet(name = "CreateNewUser", urlPatterns = {"/login/CreateNewUser"})
public class CreateNewUser extends HttpServlet {

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
        response.setContentType("text/html;charset=UTF-8");

        EntityManagerFactory factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
        UserDAO userDao = new UserDAO(factory);

        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");

        String login = request.getParameter("login");
        String passwd = request.getParameter("passwd");
        String name = request.getParameter("name");

        SimpleResult result = new SimpleResult();

        if (login != null && passwd != null && name != null) {

            try {

                User user = new User(name, login, passwd, false, false);

                userDao.create(user);
                HttpSession session = request.getSession(true);

                session.setAttribute("userId", Long.toString(user.getId()));
                session.setAttribute("userName", user.getName());

                response.setContentType("application/json");

                result.setSuccess(true);
                result.setDatasource(user);

                Gson gson = new Gson();
                String json = gson.toJson(result);

                PrintWriter out = response.getWriter();
                out.append(json);
                out.flush();

            } catch (Exception e) {

                response.setContentType("application/json");

                System.err.println(String.format("Fail to create user with login: %s & pass: %s & name: %s", login, passwd, name));

                Error error = new Error(535, "Falha na autenticação. Usuário não encontrado!");

                result.addError(error);
                result.setDatasource(e.getLocalizedMessage());
                result.setSuccess(false);
                result.setCount(result.getCount());

                Gson gson = new Gson();
                String json = gson.toJson(result);

                PrintWriter out = response.getWriter();
                out.append(json);
                out.flush();

            }

        } else {

            response.setContentType("application/json");

            System.err.println(String.format("Fail to create user with login: %s & pass: %s & name: %s. Left answer some form fields", login, passwd, name));

            Error error = new Error(535, "Falha na autenticação. Preencha todos os campos corretamente!");

            result.addError(error);
            result.setDatasource("Falha na autenticação. Preencha todos os campos corretamente!");
            result.setSuccess(false);
            result.setCount(result.getCount());

            Gson gson = new Gson();
            String json = gson.toJson(result);

            PrintWriter out = response.getWriter();
            out.append(json);
            out.flush();

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
