/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.org.catolicasc.rolingo.cmds;

import br.org.catolicasc.rolingo.adapters.NavbarClassName;
import br.org.catolicasc.rolingo.adapters.ReadParameterHelper;
import java.io.IOException;
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
        
        String action = ReadParameterHelper.readParameter(request, "do");
        String nextAction;
        
        switch (action) {
            
            case "lstpizzas":
                nextAction = buildLstPizzaModel(request, response);
                break;
                
            case "lstdesserts":
                nextAction = buildLstDessertModel(request, response);
                break;
                
            case "lstdrinks":
                nextAction = buildLstDrinkModel(request, response);
                break;
                
            default:
                request.setAttribute("msg", String.format("Erro do controller, action %s não encontrada", action));
                nextAction = "Login.jsp";
                
        }

        request.getRequestDispatcher(nextAction).forward(request, response);
        
    }

    private String buildLstPizzaModel(HttpServletRequest request, HttpServletResponse response) {
        
        String nextAction = "mvcpizza?do=lstmodel";
        
        request.setAttribute("applicationName","Pizzaria Rolingo");
        request.setAttribute("tittle","Lista de pizzas");
        
        NavbarClassName navbarClassName = new NavbarClassName("nav-active", "", "");
        request.setAttribute("navbarClassName", navbarClassName);
        
        request.setAttribute("userName", (String) request.getSession().getAttribute("username"));
        
        return nextAction;
    }
    
    private String buildLstDessertModel(HttpServletRequest request, HttpServletResponse response) {
        
        String nextAction = "mvcdessert?do=lstmodel";
        
        request.setAttribute("applicationName","Pizzaria Rolingo");
        request.setAttribute("tittle","Lista de Sobremesas");            
        
        NavbarClassName navbarClassName = new NavbarClassName("", "nav-active", "");
        request.setAttribute("navbarClassName", navbarClassName);
        
        request.setAttribute("userName", (String) request.getSession().getAttribute("username"));
        
        return nextAction;
    }
    
    private String buildLstDrinkModel(HttpServletRequest request, HttpServletResponse response) {
        
        String nextAction = "mvcdrink?do=lstmodel";
        
        request.setAttribute("applicationName","Pizzaria Rolingo");
        request.setAttribute("tittle","Lista de bebidas");
        
        NavbarClassName navbarClassName = new NavbarClassName("", "", "nav-active");
        request.setAttribute("navbarClassName", navbarClassName);
        
        request.setAttribute("userName", (String) request.getSession().getAttribute("username"));
        
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
