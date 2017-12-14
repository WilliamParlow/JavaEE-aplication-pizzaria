/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.org.catolicasc.rolingo.cmds;

import br.org.catolicasc.rolingo.adapters.PersistenceFactory;
import br.org.catolicasc.rolingo.adapters.ReadParameterHelper;
import br.org.catolicasc.rolingo.daos.DessertDAO;
import br.org.catolicasc.rolingo.daos.entities.Dessert;
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
@WebServlet(name = "DessertMvcServlet", urlPatterns = {"/mvcdessert"}, initParams = {
    @WebInitParam(name = "do", value = "")})
public class DessertMvcServlet extends HttpServlet {

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

            case "detailsmodel":
                nextAction = buildDetailsModel(request, response);
                break;

            case "delete":
                nextAction = doDel(request, response);
                break;

            case "update":
                nextAction = doUpdate(request, response);
                break;

            case "new":
                nextAction = doNew(request, response);
                break;

            default:
                request.setAttribute("msg", String.format("Erro do controller, action %s não encontrada", action));
                nextAction = "Login.jsp";

        }

        request.getRequestDispatcher(nextAction).forward(request, response);

    }

    private String buildLstModel(HttpServletRequest request, HttpServletResponse response) {

        String nextAction = "/WEB-INF/views/Desserts.jsp";

        DessertDAO dessertDao = new DessertDAO(PersistenceFactory.getFactoryInstance());
        List<Dessert> desserts = new ArrayList<Dessert>();

        desserts = dessertDao.findDessertEntities();
        request.setAttribute("datasource", desserts);
        request.setAttribute("mvcontroller", "mvcdessert");

        return nextAction;
    }

    private String buildAddModel(HttpServletRequest request, HttpServletResponse response) {

        String nextAction = "/WEB-INF/views/GenericFormView.jsp";

        DessertDAO dessertDao = new DessertDAO(PersistenceFactory.getFactoryInstance());

        return nextAction;
    }

    private String buildUpdateModel(HttpServletRequest request, HttpServletResponse response) {

        String nextAction = "/WEB-INF/views/GenericFormView.jsp";

        DessertDAO dessertDao = new DessertDAO(PersistenceFactory.getFactoryInstance());

        return nextAction;
    }

    private String buildDetailsModel(HttpServletRequest request, HttpServletResponse response) {

        String nextAction = "/WEB-INF/views/GenericFormView.jsp";

        DessertDAO dessertDao = new DessertDAO(PersistenceFactory.getFactoryInstance());

        return nextAction;
    }

    private String doUpdate(HttpServletRequest request, HttpServletResponse response) {

        String nextAction = "/WEB-INF/views/Desserts.jsp";

        DessertDAO dessertDao = new DessertDAO(PersistenceFactory.getFactoryInstance());

        return nextAction;
    }

    private String doDel(HttpServletRequest request, HttpServletResponse response) {

        String nextAction = "/WEB-INF/views/Desserts.jsp";

        DessertDAO dessertDao = new DessertDAO(PersistenceFactory.getFactoryInstance());

        return nextAction;
    }
    
    private String doNew(HttpServletRequest request, HttpServletResponse response) {

        String nextAction = "/WEB-INF/views/Desserts.jsp";

        DessertDAO dessertDao = new DessertDAO(PersistenceFactory.getFactoryInstance());

        return nextAction;
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
