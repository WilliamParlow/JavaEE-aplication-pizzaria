/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.org.catolicasc.rolingo.cmds;

import br.org.catolicasc.rolingo.adapters.PersistenceFactory;
import br.org.catolicasc.rolingo.adapters.ReadParameterHelper;
import br.org.catolicasc.rolingo.daos.DrinkDAO;
import br.org.catolicasc.rolingo.daos.entities.Drink;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Cliente
 */
@WebServlet(name = "DrinkMvcServlet", urlPatterns = {"/mvcdrink"}, initParams = {
    @WebInitParam(name = "do", value = "")})
public class DrinkMvcServlet extends HttpServlet {

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

        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");

        String action = ReadParameterHelper.readParameter(request, "do");
        String nextAction;

        switch (action) {

            case "lstmodel":
                nextAction = buildLstModel(request, response);
                break;

            case "addmodel":
                nextAction = buildAddModel(request, response);
                break;

            case "updatemodel":
                nextAction = buildUpdateModel(request, response);
                break;

            case "deletemodel":
                nextAction = buildDeleteModel(request, response);
                break;

            case "newmodel":
                nextAction = buildDeleteModel(request, response);
                break;

            case "detailsmodel":
                nextAction = buildDeleteModel(request, response);
                break;

            case "delete":
                nextAction = buildDeleteModel(request, response);
                break;

            case "update":
                nextAction = buildDeleteModel(request, response);
                break;
                
            default:
                request.setAttribute("msg", String.format("Erro do controller, action %s não encontrada", action));
                nextAction = "Login.jsp";

        }

        request.getRequestDispatcher(nextAction).forward(request, response);

    }

    private String buildLstModel(HttpServletRequest request, HttpServletResponse response) {

        String nextAction = "/WEB-INF/views/Drinks.jsp";

        DrinkDAO drinkDao = new DrinkDAO(PersistenceFactory.getFactoryInstance());
        List<Drink> drinks = new ArrayList<Drink>();

        drinks = drinkDao.findDrinkEntities();
        request.setAttribute("datasource", drinks);
        request.setAttribute("mvcontroller", "mvcdrink");

        return nextAction;

    }

    private String buildAddModel(HttpServletRequest request, HttpServletResponse response) {
        return "";
    }

    private String buildUpdateModel(HttpServletRequest request, HttpServletResponse response) {
        return "";
    }

    private String buildDeleteModel(HttpServletRequest request, HttpServletResponse response) {
        return "";
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
