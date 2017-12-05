/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.org.catolicasc.rolingo.cmds;

import br.org.catolicasc.rolingo.adapters.MenuItem;
import java.io.IOException;
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
@WebServlet(name = "MenuMvcServlet", urlPatterns = {"/mvcmenu"}, initParams = {
    @WebInitParam(name = "do", value = "")})
public class MenuMvcServlet extends HttpServlet {

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
        String action = this.readParameter(request, "do");
        String nextAction;
        switch (action) {
            case "lstmodel":
                nextAction = buildLstModel(request, response);
                break;
            default:
                request.setAttribute("msg", String.format("Erro do controller, action %s não encontrada", action));
                nextAction = "Login.jsp";
        }

        request.getRequestDispatcher(nextAction).forward(request, response);
    }

    private String buildLstModel(HttpServletRequest request, HttpServletResponse response) {
        String nextAction = "/WEB-INF/views/HomeView.jsp";
        request.setAttribute("applicationName","Pizzaria Rolingo");
        request.setAttribute("tittle","Menu Principal");
        
        
        request.setAttribute("userName", (String) request.getSession().getAttribute("username"));
        List<MenuItem> menu = new ArrayList<>();
        menu.add(new MenuItem("Clientes","mvccustomer?do=lstmodel"));
        menu.add(new MenuItem("Pizzas","mvcpizza?do=lstmodel"));
        menu.add(new MenuItem("Sobremesas","mvcdessert?do=lstmodel"));
        menu.add(new MenuItem("Bebidas","mvcdrink?do=lstmodel"));
        
        request.setAttribute("datasource", menu);
        
        
        return nextAction;
    }
    
    private String readParameter(HttpServletRequest req, String parameterName) {
        return readParameter(req, parameterName, "");
    }

    private String readParameter(HttpServletRequest req, String parameterName, String defaultValue) {
        String value = req.getParameter(parameterName);
        if ((value == null) || (value.equals(""))) {
            value = defaultValue;
        }

        return value;
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
