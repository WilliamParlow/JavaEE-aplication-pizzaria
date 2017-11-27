package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public final class Login_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.ArrayList<String>(2);
    _jspx_dependants.add("/WEB-INF/includes/default_header.jsp");
    _jspx_dependants.add("/WEB-INF/includes/default_footer.jsp");
  }

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("    <head>\r\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\r\n");
      out.write("        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\r\n");
      out.write("\r\n");
      out.write("        ");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!-- BOOTSTRAP -->\n");
      out.write("<link href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css\" rel=\"stylesheet\" \n");
      out.write("        integrity=\"sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u\" \n");
      out.write("        crossorigin=\"anonymous\">\n");
      out.write("\n");
      out.write("<!-- FONT AWELSOME -->\n");
      out.write("<link href=\"https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css\" rel=\"stylesheet\" \n");
      out.write("        integrity=\"sha384-wvfXpqpZZVQGK6TAh5PVlGOfQNHSoD2xbE+QkPxCAFlNEevoEH3Sl0sibVcOQVnN\" \n");
      out.write("        crossorigin=\"anonymous\">\n");
      out.write("\n");
      out.write("<link rel=\"stylesheet\" href=\"assets/css/general/app.css\">");
      out.write("\r\n");
      out.write("\r\n");
      out.write("        <link rel=\"stylesheet\" href=\"assets/css/login/login.css\">\r\n");
      out.write("        <link rel=\"stylesheet\" href=\"assets/css/general/loading.css\">\r\n");
      out.write("\r\n");
      out.write("        <title>Entre na Rolingo - O Melhor Sistema de gerenciamento de Pizzaria</title>\r\n");
      out.write("\r\n");
      out.write("    </head>\r\n");
      out.write("    <body>\r\n");
      out.write("        \r\n");
      out.write("        \r\n");
      out.write("        <!-- Loading ring -->\r\n");
      out.write("        <div id=\"dualRingLoading\" class=\"lds-css\">\r\n");
      out.write("            <div class=\"lds-dual-ring\">\r\n");
      out.write("                <div class=\"spinner-container\">\r\n");
      out.write("                    <div></div>\r\n");
      out.write("                </div>\r\n");
      out.write("            </div>\r\n");
      out.write("        </div>\r\n");
      out.write("\r\n");
      out.write("        <!-- Page navbar -->\r\n");
      out.write("        <nav class=\"navbar-login navbar-fixed-top\">\r\n");
      out.write("            <div class=\"container-fluid\">\r\n");
      out.write("                <div class=\"navbar-header\">\r\n");
      out.write("                    <a class=\"navbar-brand\" href=\"#\">Rolingo Pizzaria</a>\r\n");
      out.write("                </div>\r\n");
      out.write("            </div>\r\n");
      out.write("        </nav>\r\n");
      out.write("        \r\n");
      out.write("        \r\n");
      out.write("\r\n");
      out.write("        <!-- Page content - Signup and Signin forms -->\r\n");
      out.write("        <section class=\"login-relative container-fluid\">\r\n");
      out.write("\r\n");
      out.write("            <div class=\"col-xs-12\">\r\n");
      out.write("                \r\n");
      out.write("                \r\n");
      out.write("                \r\n");
      out.write("                <!-- Signin form -->\r\n");
      out.write("                <form id=\"signin\" method=\"POST\" action=\"login\" class=\"loginForm panel fade-out\">\r\n");
      out.write("\r\n");
      out.write("                    <header class=\"panel-heading text-center\">\r\n");
      out.write("\r\n");
      out.write("                        <h4 class=\"bold\">\r\n");
      out.write("                            <b>Entre na Rolingo!</b>\r\n");
      out.write("                        </h4>\r\n");
      out.write("\r\n");
      out.write("                    </header>\r\n");
      out.write("\r\n");
      out.write("                    <main class=\"panel-body\">\r\n");
      out.write("\r\n");
      out.write("                        <div class=\"form-group\">\r\n");
      out.write("                            <label for=\"login\">Email:&nbsp;</label>\r\n");
      out.write("                            <input class=\"form-control\" name=\"login\" id=\"login\" type=\"email\" placeholder=\"Entre com seu email!\" required>\r\n");
      out.write("                        </div>\r\n");
      out.write("\r\n");
      out.write("                        <div class=\"form-group\">\r\n");
      out.write("                            <label for=\"passwd\">Senha:&nbsp;</label>\r\n");
      out.write("                            <input class=\"form-control\" name=\"passwd\" id=\"passwd\" type=\"password\" placeholder=\"Entre com sua senha!\" required>\r\n");
      out.write("                        </div>\r\n");
      out.write("                        \r\n");
      out.write("                        <div class=\"invalid-text-form\">");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${msg}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("</div>\r\n");
      out.write("\r\n");
      out.write("                    </main>\r\n");
      out.write("\r\n");
      out.write("                    <footer class=\"panel-footer text-center\">\r\n");
      out.write("\r\n");
      out.write("                        <button type=\"submit\" class=\"login-btn\">Entrar!</button>\r\n");
      out.write("\r\n");
      out.write("                        <div class=\"form-toggler-container\">\r\n");
      out.write("                            <a class=\"form-toggler\" data-fade_in_target=\"#signup\" data-fade_out_target=\"#signin\">Não possui conta? Crie uma!</a>\r\n");
      out.write("                        </div>\r\n");
      out.write("\r\n");
      out.write("                    </footer>\r\n");
      out.write("\r\n");
      out.write("                </form>\r\n");
      out.write("                \r\n");
      out.write("                \r\n");
      out.write("                \r\n");
      out.write("                \r\n");
      out.write("                <!-- Signup form -->\r\n");
      out.write("                <form id=\"signup\" action=\"create\" method=\"POST\" class=\"loginForm panel fade-in\">\r\n");
      out.write("\r\n");
      out.write("                    <header class=\"panel-heading text-center\">\r\n");
      out.write("\r\n");
      out.write("                        <h4 class=\"bold\">\r\n");
      out.write("                            <b>Cadastre-se na Rolingo!</b>\r\n");
      out.write("                        </h4>\r\n");
      out.write("\r\n");
      out.write("                    </header>\r\n");
      out.write("\r\n");
      out.write("                    <main class=\"panel-body\">\r\n");
      out.write("\r\n");
      out.write("                        <div class=\"form-group\">\r\n");
      out.write("                            <label for=\"name\">Nome:&nbsp; </label>\r\n");
      out.write("                            <input class=\"form-control\" name=\"name\" id=\"name\" type=\"text\" placeholder=\"Digite seu nome!\" required>\r\n");
      out.write("                        </div>\r\n");
      out.write("\r\n");
      out.write("                        <div class=\"form-group\">\r\n");
      out.write("                            <label for=\"login\">Email:&nbsp; </label>\r\n");
      out.write("                            <input class=\"form-control\" name=\"login\" id=\"login\" type=\"email\" placeholder=\"Digite seu email!\" required>\r\n");
      out.write("                        </div>\r\n");
      out.write("\r\n");
      out.write("                        <div class=\"form-group\">\r\n");
      out.write("                            <label for=\"passwd\">Senha:&nbsp;</label>\r\n");
      out.write("                            <input class=\"form-control\" name=\"passwd\" id=\"passwd\" type=\"password\" placeholder=\"Digite sua senha!\" required>\r\n");
      out.write("                        </div>\r\n");
      out.write("                        \r\n");
      out.write("                        <div class=\"invalid-text-form\">");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${msg}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("</div>\r\n");
      out.write("\r\n");
      out.write("                    </main>\r\n");
      out.write("\r\n");
      out.write("                    <footer class=\"panel-footer text-center\">\r\n");
      out.write("\r\n");
      out.write("                        <button type=\"submit\" class=\"login-btn\">Cadastrar e entrar!</button>\r\n");
      out.write("\r\n");
      out.write("                        <div class=\"form-toggler-container\">\r\n");
      out.write("                            <a class=\"form-toggler\" data-fade_in_target=\"#signin\" data-fade_out_target=\"#signup\">Já possui uma conta? Entre!</a>\r\n");
      out.write("                        </div>\r\n");
      out.write("\r\n");
      out.write("                    </footer>\r\n");
      out.write("\r\n");
      out.write("                </form>\r\n");
      out.write("                \r\n");
      out.write("                \r\n");
      out.write("\r\n");
      out.write("                \r\n");
      out.write("            </div>\r\n");
      out.write("\r\n");
      out.write("        </section>\r\n");
      out.write("\r\n");
      out.write("        <!-- Footer -->\r\n");
      out.write("        <footer class=\"login-footer\">\r\n");
      out.write("            <address>Developed by Will - ");
 out.print(new SimpleDateFormat("YYYY").format(new Date()));
      out.write("</address>\r\n");
      out.write("        </footer>\r\n");
      out.write("\r\n");
      out.write("        \r\n");
      out.write("        \r\n");
      out.write("        ");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!-- JQUERY -->\n");
      out.write("<script\n");
      out.write("    src=\"https://code.jquery.com/jquery-3.2.1.min.js\"\n");
      out.write("    integrity=\"sha256-hwg4gsxgFZhOsEEamdOYGBf13FyQuiTwlAQgxVSNgt4=\"\n");
      out.write("crossorigin=\"anonymous\"></script>\n");
      out.write("\n");
      out.write("<!-- BOOTSTRAP -->\n");
      out.write("<script src=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js\" \n");
      out.write("        integrity=\"sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa\" \n");
      out.write("crossorigin=\"anonymous\"></script>\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("        <script src=\"assets/js/events/login/loginEvents.js\"></script>\r\n");
      out.write("        \r\n");
      out.write("\r\n");
      out.write("    </body>\r\n");
      out.write("    \r\n");
      out.write("</html>\r\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
