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

        String nextAction = "/WEB-INF/views/Drinks.jsp";

        DrinkDAO drinkDao = new DrinkDAO(PersistenceFactory.getFactoryInstance());
        List<Drink> drinks = new ArrayList<>();

        drinks = drinkDao.findDrinkEntities();
        request.setAttribute("datasource", drinks);
        request.setAttribute("mvcontroller", "mvcdrink");

        return nextAction;

    }

    private String buildAddModel(HttpServletRequest request, HttpServletResponse response) {

        String nextAction = "/WEB-INF/views/GenericFormView.jsp";

        FormPageModel formPageModel = new FormPageModel("Novo Drink", "mvcdrink", "", "hidden", "lstdrinks", "new", 0);

        List<InputFormModel> inputs = new ArrayList<>();

        inputs.add(new InputFormModel("name", "name", "text", "", "form-control", "Digite o nome da bebida", "Nome: ", "input", true, false, false));
        inputs.add(new InputFormModel("recipe", "recipe", "text", "", "form-control input-text-area", "Digite a receita da bebida", "Receita: ", "textarea", true, false, false));
        inputs.add(new InputFormModel("ingredient", "ingredient", "text", "", "form-control input-text-area", "Digite os ingredientes da babida", "Ingredientes: ", "textarea", true, false, false));
        inputs.add(new InputFormModel("description", "description", "text", "", "form-control input-text-area", "Digite a descrição da bebida", "Descrição: ", "textarea", true, false, false));
        inputs.add(new InputFormModel("imageurl", "imageurl", "text", "", "form-control", "Digite a URL da imagem", "URL da imagem: ", "input", true, false, false));

        request.setAttribute("formmodel", formPageModel);
        request.setAttribute("formobject", inputs);

        return nextAction;

    }

    private String buildUpdateModel(HttpServletRequest request, HttpServletResponse response) {

        String nextAction = "/WEB-INF/views/GenericFormView.jsp";
        String drinkId = (String) request.getParameter("id");

        DrinkDAO DrinkDao = new DrinkDAO(PersistenceFactory.getFactoryInstance());
        Drink drink = DrinkDao.findDrink(Long.parseLong(drinkId));

        FormPageModel formPageModel = new FormPageModel("Editar ".concat(drink.getName()), "mvcdrink", "", "hidden", "lstdrinks", "update", drink.getId());

        List<InputFormModel> inputs = new ArrayList<>();

        inputs.add(new InputFormModel("name", "name", "text", drink.getName(), "form-control", "Digite o nome da bebida", "Nome: ", "input", true, false, false));
        inputs.add(new InputFormModel("recipe", "recipe", "text", drink.getRecipe(), "form-control input-text-area", "Digite a receita da bebida", "Receita: ", "textarea", true, false, false));
        inputs.add(new InputFormModel("ingredient", "ingredient", "text", drink.getIngredient(), "form-control input-text-area", "Digite os ingredientes da bebida", "Ingredientes: ", "textarea", true, false, false));
        inputs.add(new InputFormModel("description", "description", "text", drink.getDescription(), "form-control input-text-area", "Digite a descrição da bebida", "Descrição: ", "textarea", true, false, false));
        inputs.add(new InputFormModel("imageurl", "imageurl", "text", drink.getImageUrl(), "form-control", "Digite a URL da imagem", "URL da imagem: ", "input", true, false, false));

        request.setAttribute("formmodel", formPageModel);
        request.setAttribute("formobject", inputs);

        return nextAction;
    }

    private String buildDetailsModel(HttpServletRequest request, HttpServletResponse response) {

        String nextAction = "/WEB-INF/views/GenericFormView.jsp";
        String drinkId = (String) request.getParameter("id");

        DrinkDAO DrinkDao = new DrinkDAO(PersistenceFactory.getFactoryInstance());
        Drink drink = DrinkDao.findDrink(Long.parseLong(drinkId));

        FormPageModel formPageModel = new FormPageModel("Visualizar ".concat(drink.getName()), "mvcdrink", "hidden", "", "lstdrinks", "", drink.getId());

        List<InputFormModel> inputs = new ArrayList<>();

        inputs.add(new InputFormModel("name", "name", "text", drink.getName(), "form-control", "Digite o nome da bebida", "Nome: ", "input", false, true, false));
        inputs.add(new InputFormModel("recipe", "recipe", "text", drink.getRecipe(), "form-control input-text-area", "Digite a receita da bebida", "Receita: ", "textarea", false, true, false));
        inputs.add(new InputFormModel("ingredient", "ingredient", "text", drink.getIngredient(), "form-control input-text-area", "Digite os ingredientes da bebida", "Ingredientes: ", "textarea", false, true, false));
        inputs.add(new InputFormModel("description", "description", "text", drink.getDescription(), "form-control input-text-area", "Digite a descrição da bebida", "Descrição: ", "textarea", false, true, false));
        inputs.add(new InputFormModel("imageurl", "imageurl", "text", drink.getImageUrl(), "form-control", "Digite a URL da imagem", "URL da imagem: ", "input", false, true, false));

        request.setAttribute("formmodel", formPageModel);
        request.setAttribute("formobject", inputs);

        return nextAction;
    }

    private String doUpdate(HttpServletRequest request, HttpServletResponse response) {

        String nextAction;

        try {

            String drinkId = (String) request.getParameter("id");

            DrinkDAO DrinkDao = new DrinkDAO(PersistenceFactory.getFactoryInstance());
            Drink drink = DrinkDao.findDrink(Long.parseLong(drinkId));

            drink.setDescription(request.getParameter("description"));
            drink.setImageUrl(request.getParameter("imageurl"));
            drink.setIngredient(request.getParameter("ingredient"));
            drink.setName(request.getParameter("name"));
            drink.setRecipe(request.getParameter("recipe"));

            DrinkDao.edit(drink);

            nextAction = "mvcmenu?do=lstdrinks";

        } catch (Exception e) {

            String drinkId = (String) request.getParameter("id");

            DrinkDAO DrinkDao = new DrinkDAO(PersistenceFactory.getFactoryInstance());
            Drink drink = DrinkDao.findDrink(Long.parseLong(drinkId));

            FormPageModel formPageModel = new FormPageModel("Editar ".concat(drink.getName()), "mvcdrink", "", "hidden", "lstdrinks", "update", drink.getId());

            request.setAttribute("formmodel", formPageModel);

            nextAction = "mvcdrink?do=updatemodel&id=".concat(drinkId);
            request.setAttribute("error", "Não foi possível atualizar os dados da");

        }

        return nextAction;
    }

    private String doDel(HttpServletRequest request, HttpServletResponse response) {

        String nextAction;

        try {

            String drinkId = (String) request.getParameter("id");

            DrinkDAO DrinkDao = new DrinkDAO(PersistenceFactory.getFactoryInstance());
            DrinkDao.destroy(Long.parseLong(drinkId));

            nextAction = "mvcmenu?do=lstdrinks";

        } catch (Exception e) {

            String drinkId = (String) request.getParameter("id");

            System.out.println("Erro ao deletar registro! " + drinkId);
            nextAction = "mvcmenu?do=lstdrinks";

        }

        return nextAction;

    }

    private String doNew(HttpServletRequest request, HttpServletResponse response) {

        String nextAction;

        try {

            DrinkDAO DrinkDao = new DrinkDAO(PersistenceFactory.getFactoryInstance());
            Drink drink = new Drink();

            drink.setDescription(request.getParameter("description"));
            drink.setImageUrl(request.getParameter("imageurl"));
            drink.setIngredient(request.getParameter("ingredient"));
            drink.setName(request.getParameter("name"));
            drink.setRecipe(request.getParameter("recipe"));

            DrinkDao.create(drink);
            
            nextAction = "mvcmenu?do=lstdrinks";

        } catch (Exception e) {
            
            System.out.println("Erro ao criar registro! ");
            nextAction = "mvcmenu?do=lstdrinks";
            
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
