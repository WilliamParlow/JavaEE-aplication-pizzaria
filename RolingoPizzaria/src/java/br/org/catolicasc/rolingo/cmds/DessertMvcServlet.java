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

        String nextAction;

        try {

            nextAction = "/WEB-INF/views/Desserts.jsp";

            DessertDAO dessertDao = new DessertDAO(PersistenceFactory.getFactoryInstance());
            List<Dessert> desserts = new ArrayList<>();

            desserts = dessertDao.findDessertEntities();
            request.setAttribute("datasource", desserts);
            request.setAttribute("mvcontroller", "mvcdessert");

        } catch (Exception e) {

            nextAction = "mvcmenu?do=lstdesserts";
            System.err.println(e.getMessage());
            System.err.println(e.getCause());

        }

        return nextAction;
    }

    private String buildAddModel(HttpServletRequest request, HttpServletResponse response) {

        String nextAction;

        try {

            nextAction = "/WEB-INF/views/GenericFormView.jsp";

            request.setAttribute("applicationName", "Pizzaria Rolingo");
            request.setAttribute("tittle", "Criar nova sobremesa");

            FormPageModel formPageModel = new FormPageModel("Nova Sobremesa", "mvcdessert", "", "hidden", "lstdesserts", "new", 0);

            List<InputFormModel> inputs = new ArrayList<>();

            inputs.add(new InputFormModel("name", "name", "text", "", "form-control", "Digite o nome da sobremesa", "Nome: ", "input", true, false, false));
            inputs.add(new InputFormModel("recipe", "recipe", "text", "", "form-control input-text-area", "Digite a receita da sobremesa", "Receita: ", "textarea", true, false, false));
            inputs.add(new InputFormModel("ingredient", "ingredient", "text", "", "form-control input-text-area", "Digite os ingredientes da sobremesa", "Ingredientes: ", "textarea", true, false, false));
            inputs.add(new InputFormModel("description", "description", "text", "", "form-control input-text-area", "Digite a descrição da sobremesa", "Descrição: ", "textarea", true, false, false));
            inputs.add(new InputFormModel("imageurl", "imageurl", "text", "", "form-control", "Digite a URL da imagem", "URL da imagem: ", "input", true, false, false));

            request.setAttribute("formmodel", formPageModel);
            request.setAttribute("formobject", inputs);

        } catch (Exception e) {

            nextAction = "mvcmenu?do=lstdesserts";
            System.err.println(e.getMessage());
            System.err.println(e.getCause());

        }

        return nextAction;

    }

    private String buildUpdateModel(HttpServletRequest request, HttpServletResponse response) {

        String nextAction;

        try {

            nextAction = "/WEB-INF/views/GenericFormView.jsp";
            String dessertId = (String) request.getParameter("id");

            DessertDAO dessertDao = new DessertDAO(PersistenceFactory.getFactoryInstance());
            Dessert dessert = dessertDao.findDessert(Long.parseLong(dessertId));

            request.setAttribute("applicationName", "Pizzaria Rolingo");
            request.setAttribute("tittle", "Atualizar sobremesa ".concat(dessert.getName()));

            FormPageModel formPageModel = new FormPageModel("Editar ".concat(dessert.getName()), "mvcdessert", "", "hidden", "lstdesserts", "update", dessert.getId());

            List<InputFormModel> inputs = new ArrayList<>();

            inputs.add(new InputFormModel("name", "name", "text", dessert.getName(), "form-control", "Digite o nome da sobremesa", "Nome: ", "input", true, false, false));
            inputs.add(new InputFormModel("recipe", "recipe", "text", dessert.getRecipe(), "form-control input-text-area", "Digite a receita da sobremesa", "Receita: ", "textarea", true, false, false));
            inputs.add(new InputFormModel("ingredient", "ingredient", "text", dessert.getIngredient(), "form-control input-text-area", "Digite os ingredientes da sobremesa", "Ingredientes: ", "textarea", true, false, false));
            inputs.add(new InputFormModel("description", "description", "text", dessert.getDescription(), "form-control input-text-area", "Digite a descrição da sobremesa", "Descrição: ", "textarea", true, false, false));
            inputs.add(new InputFormModel("imageurl", "imageurl", "text", dessert.getImageUrl(), "form-control", "Digite a URL da imagem", "URL da imagem: ", "input", true, false, false));

            request.setAttribute("formmodel", formPageModel);
            request.setAttribute("formobject", inputs);

        } catch (Exception e) {

            nextAction = "mvcmenu?do=lstdesserts";
            System.err.println(e.getMessage());
            System.err.println(e.getCause());

        }

        return nextAction;
    }

    private String buildDetailsModel(HttpServletRequest request, HttpServletResponse response) {

        String nextAction;

        try {

            nextAction = "/WEB-INF/views/GenericFormView.jsp";
            String dessertId = (String) request.getParameter("id");

            DessertDAO dessertDao = new DessertDAO(PersistenceFactory.getFactoryInstance());
            Dessert dessert = dessertDao.findDessert(Long.parseLong(dessertId));

            request.setAttribute("applicationName", "Pizzaria Rolingo");
            request.setAttribute("tittle", "Detalhes da sobremesa ".concat(dessert.getName()));

            FormPageModel formPageModel = new FormPageModel("Visualizar ".concat(dessert.getName()), "mvcdessert", "hidden", "", "lstdesserts", "", dessert.getId());

            List<InputFormModel> inputs = new ArrayList<>();

            inputs.add(new InputFormModel("name", "name", "text", dessert.getName(), "form-control", "Digite o nome da sobremesa", "Nome: ", "input", false, true, false));
            inputs.add(new InputFormModel("recipe", "recipe", "text", dessert.getRecipe(), "form-control input-text-area", "Digite a receita da sobremesa", "Receita: ", "textarea", false, true, false));
            inputs.add(new InputFormModel("ingredient", "ingredient", "text", dessert.getIngredient(), "form-control input-text-area", "Digite os ingredientes da sobremesa", "Ingredientes: ", "textarea", false, true, false));
            inputs.add(new InputFormModel("description", "description", "text", dessert.getDescription(), "form-control input-text-area", "Digite a descrição da sobremesa", "Descrição: ", "textarea", false, true, false));
            inputs.add(new InputFormModel("imageurl", "imageurl", "text", dessert.getImageUrl(), "form-control", "Digite a URL da imagem", "URL da imagem: ", "input", false, true, false));

            request.setAttribute("formmodel", formPageModel);
            request.setAttribute("formobject", inputs);

        } catch (Exception e) {

            nextAction = "mvcmenu?do=lstdesserts";
            System.err.println(e.getMessage());
            System.err.println(e.getCause());

        }

        return nextAction;
    }

    private String doUpdate(HttpServletRequest request, HttpServletResponse response) {

        String nextAction;

        try {

            String dessertId = (String) request.getParameter("id");

            DessertDAO dessertDao = new DessertDAO(PersistenceFactory.getFactoryInstance());
            Dessert dessert = dessertDao.findDessert(Long.parseLong(dessertId));

            dessert.setDescription(request.getParameter("description"));
            dessert.setImageUrl(request.getParameter("imageurl"));
            dessert.setIngredient(request.getParameter("ingredient"));
            dessert.setName(request.getParameter("name"));
            dessert.setRecipe(request.getParameter("recipe"));

            dessertDao.edit(dessert);

            nextAction = "mvcmenu?do=lstdesserts";

        } catch (Exception e) {

            String dessertId = (String) request.getParameter("id");

            DessertDAO dessertDao = new DessertDAO(PersistenceFactory.getFactoryInstance());
            Dessert dessert = dessertDao.findDessert(Long.parseLong(dessertId));

            FormPageModel formPageModel = new FormPageModel("Editar ".concat(dessert.getName()), "mvcdessert", "", "hidden", "lstdesserts", "update", dessert.getId());

            request.setAttribute("formmodel", formPageModel);

            nextAction = "mvcdessert?do=updatemodel&id=".concat(dessertId);
            request.setAttribute("error", "Não foi possível atualizar os dados da");

            System.err.println(e.getMessage());
            System.err.println(e.getCause());

        }

        return nextAction;
    }

    private String doDel(HttpServletRequest request, HttpServletResponse response) {

        String nextAction;

        try {

            String dessertId = (String) request.getParameter("id");

            DessertDAO dessertDao = new DessertDAO(PersistenceFactory.getFactoryInstance());
            dessertDao.destroy(Long.parseLong(dessertId));

            nextAction = "mvcmenu?do=lstdesserts";

        } catch (Exception e) {

            String dessertId = (String) request.getParameter("id");

            System.err.println(e.getMessage());
            System.err.println(e.getCause());

            nextAction = "mvcmenu?do=lstdesserts";

        }

        return nextAction;

    }

    private String doNew(HttpServletRequest request, HttpServletResponse response) {

        String nextAction;

        try {

            DessertDAO dessertDao = new DessertDAO(PersistenceFactory.getFactoryInstance());
            Dessert dessert = new Dessert();

            dessert.setDescription(request.getParameter("description"));
            dessert.setImageUrl(request.getParameter("imageurl"));
            dessert.setIngredient(request.getParameter("ingredient"));
            dessert.setName(request.getParameter("name"));
            dessert.setRecipe(request.getParameter("recipe"));

            dessertDao.create(dessert);

            nextAction = "mvcmenu?do=lstdesserts";

        } catch (Exception e) {

            System.err.println(e.getMessage());
            System.err.println(e.getCause());
            nextAction = "mvcmenu?do=lstdesserts";

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
