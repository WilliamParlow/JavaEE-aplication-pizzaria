/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.org.catolicasc.rolingo.cmds;

import br.org.catolicasc.rolingo.adapters.FormPageModel;
import br.org.catolicasc.rolingo.adapters.InputFormModel;
import br.org.catolicasc.rolingo.adapters.PersistenceFactory;
import br.org.catolicasc.rolingo.adapters.ReadParameterHelper;
import br.org.catolicasc.rolingo.daos.PizzaDAO;
import br.org.catolicasc.rolingo.daos.entities.Pizza;
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
@WebServlet(name = "PizzaMvcServlet", urlPatterns = {"/mvcpizza"}, initParams = {
    @WebInitParam(name = "do", value = "")})
public class PizzaMvcServlet extends HttpServlet {

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

        String nextAction = "/WEB-INF/views/Pizzas.jsp";

        PizzaDAO pizzaDao = new PizzaDAO(PersistenceFactory.getFactoryInstance());
        List<Pizza> pizzas = new ArrayList<>();

        pizzas = pizzaDao.findPizzaEntities();
        request.setAttribute("datasource", pizzas);
        request.setAttribute("mvcontroller", "mvcpizza");

        return nextAction;

    }

    private String buildAddModel(HttpServletRequest request, HttpServletResponse response) {

        String nextAction = "/WEB-INF/views/GenericFormView.jsp";

        FormPageModel formPageModel = new FormPageModel("Nova Pizza", "mvcpizza", "", "hidden", "lstpizzas", "new", 0);

        List<InputFormModel> inputs = new ArrayList<>();

        inputs.add(new InputFormModel("name", "name", "text", "", "form-control", "Digite o nome da pizza", "Nome: ", "input", true, false, false));
        inputs.add(new InputFormModel("recipe", "recipe", "text", "", "form-control input-text-area", "Digite a receita da pizza", "Receita: ", "textarea", true, false, false));
        inputs.add(new InputFormModel("ingredient", "ingredient", "text", "", "form-control input-text-area", "Digite os ingredientes da pizza", "Ingredientes: ", "textarea", true, false, false));
        inputs.add(new InputFormModel("description", "description", "text", "", "form-control input-text-area", "Digite a descrição da pizza", "Descrição: ", "textarea", true, false, false));
        inputs.add(new InputFormModel("imageurl", "imageurl", "text", "", "form-control", "Digite a URL da imagem", "URL da imagem: ", "input", true, false, false));

        request.setAttribute("formmodel", formPageModel);
        request.setAttribute("formobject", inputs);

        return nextAction;

    }

    private String buildUpdateModel(HttpServletRequest request, HttpServletResponse response) {

        String nextAction = "/WEB-INF/views/GenericFormView.jsp";
        String pizzaId = (String) request.getParameter("id");

        PizzaDAO pizzaDao = new PizzaDAO(PersistenceFactory.getFactoryInstance());
        Pizza pizza = pizzaDao.findPizza(Long.parseLong(pizzaId));

        FormPageModel formPageModel = new FormPageModel("Editar ".concat(pizza.getName()), "mvcpizza", "", "hidden", "lstpizzas", "update", pizza.getId());

        List<InputFormModel> inputs = new ArrayList<>();

        inputs.add(new InputFormModel("name", "name", "text", pizza.getName(), "form-control", "Digite o nome da pizza", "Nome: ", "input", true, false, false));
        inputs.add(new InputFormModel("recipe", "recipe", "text", pizza.getRecipe(), "form-control input-text-area", "Digite a receita da pizza", "Receita: ", "textarea", true, false, false));
        inputs.add(new InputFormModel("ingredient", "ingredient", "text", pizza.getIngredient(), "form-control input-text-area", "Digite os ingredientes da pizza", "Ingredientes: ", "textarea", true, false, false));
        inputs.add(new InputFormModel("description", "description", "text", pizza.getDescription(), "form-control input-text-area", "Digite a descrição da pizza", "Descrição: ", "textarea", true, false, false));
        inputs.add(new InputFormModel("imageurl", "imageurl", "text", pizza.getImageUrl(), "form-control", "Digite a URL da imagem", "URL da imagem: ", "input", true, false, false));

        request.setAttribute("formmodel", formPageModel);
        request.setAttribute("formobject", inputs);

        return nextAction;
    }

    private String buildDetailsModel(HttpServletRequest request, HttpServletResponse response) {

        String nextAction = "/WEB-INF/views/GenericFormView.jsp";
        String pizzaId = (String) request.getParameter("id");

        PizzaDAO pizzaDao = new PizzaDAO(PersistenceFactory.getFactoryInstance());
        Pizza pizza = pizzaDao.findPizza(Long.parseLong(pizzaId));

        FormPageModel formPageModel = new FormPageModel("Visualizar ".concat(pizza.getName()), "mvcpizza", "hidden", "", "lstpizzas", "", pizza.getId());

        List<InputFormModel> inputs = new ArrayList<>();

        inputs.add(new InputFormModel("name", "name", "text", pizza.getName(), "form-control", "Digite o nome da pizza", "Nome: ", "input", false, true, false));
        inputs.add(new InputFormModel("recipe", "recipe", "text", pizza.getRecipe(), "form-control input-text-area", "Digite a receita da pizza", "Receita: ", "textarea", false, true, false));
        inputs.add(new InputFormModel("ingredient", "ingredient", "text", pizza.getIngredient(), "form-control input-text-area", "Digite os ingredientes da pizza", "Ingredientes: ", "textarea", false, true, false));
        inputs.add(new InputFormModel("description", "description", "text", pizza.getDescription(), "form-control input-text-area", "Digite a descrição da pizza", "Descrição: ", "textarea", false, true, false));
        inputs.add(new InputFormModel("imageurl", "imageurl", "text", pizza.getImageUrl(), "form-control", "Digite a URL da imagem", "URL da imagem: ", "input", false, true, false));

        request.setAttribute("formmodel", formPageModel);
        request.setAttribute("formobject", inputs);

        return nextAction;
    }

    private String doUpdate(HttpServletRequest request, HttpServletResponse response) {

        String nextAction;

        try {

            String pizzaId = (String) request.getParameter("id");

            PizzaDAO pizzaDao = new PizzaDAO(PersistenceFactory.getFactoryInstance());
            Pizza pizza = pizzaDao.findPizza(Long.parseLong(pizzaId));

            pizza.setDescription(request.getParameter("description"));
            pizza.setImageUrl(request.getParameter("imageurl"));
            pizza.setIngredient(request.getParameter("ingredient"));
            pizza.setName(request.getParameter("name"));
            pizza.setRecipe(request.getParameter("recipe"));

            pizzaDao.edit(pizza);

            nextAction = "mvcmenu?do=lstpizzas";

        } catch (Exception e) {

            String pizzaId = (String) request.getParameter("id");

            PizzaDAO pizzaDao = new PizzaDAO(PersistenceFactory.getFactoryInstance());
            Pizza pizza = pizzaDao.findPizza(Long.parseLong(pizzaId));

            FormPageModel formPageModel = new FormPageModel("Editar ".concat(pizza.getName()), "mvcpizza", "", "hidden", "lstpizzas", "update", pizza.getId());

            request.setAttribute("formmodel", formPageModel);

            nextAction = "mvcpizza?do=updatemodel&id=".concat(pizzaId);
            request.setAttribute("error", "Não foi possível atualizar os dados da");

        }

        PizzaDAO pizzaDao = new PizzaDAO(PersistenceFactory.getFactoryInstance());

        return nextAction;
    }

    private String doDel(HttpServletRequest request, HttpServletResponse response) {

        String nextAction;

        try {

            String pizzaId = (String) request.getParameter("id");

            PizzaDAO pizzaDao = new PizzaDAO(PersistenceFactory.getFactoryInstance());
            pizzaDao.destroy(Long.parseLong(pizzaId));

            nextAction = "mvcmenu?do=lstpizzas";

        } catch (Exception e) {

            String pizzaId = (String) request.getParameter("id");

            System.out.println("Erro ao deletar registro! " + pizzaId);
            nextAction = "mvcmenu?do=lstpizzas";

        }

        return nextAction;

    }

    private String doNew(HttpServletRequest request, HttpServletResponse response) {

        String nextAction;

        try {

            PizzaDAO pizzaDao = new PizzaDAO(PersistenceFactory.getFactoryInstance());
            Pizza pizza = new Pizza();

            pizza.setDescription(request.getParameter("description"));
            pizza.setImageUrl(request.getParameter("imageurl"));
            pizza.setIngredient(request.getParameter("ingredient"));
            pizza.setName(request.getParameter("name"));
            pizza.setRecipe(request.getParameter("recipe"));

            pizzaDao.create(pizza);
            
            nextAction = "mvcmenu?do=lstpizzas";

        } catch (Exception e) {
            
            System.out.println("Erro ao criar registro! ");
            nextAction = "mvcmenu?do=lstpizzas";
            
        }

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
