/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.47
 * Generated at: 2020-01-24 10:19:03 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import org.lebedeva.model.CdDisk;
import org.lebedeva.model.Archive;
import java.util.Collections;

public final class index_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.HashMap<java.lang.String,java.lang.Long>(2);
    _jspx_dependants.put("/WEB-INF/jsp/template/head.jsp", Long.valueOf(1579860707000L));
    _jspx_dependants.put("/WEB-INF/jsp/template/form.jsp", Long.valueOf(1579856245000L));
  }

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
        throws java.io.IOException, javax.servlet.ServletException {

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


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

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<html>\n");
      out.write("<head>\n");
      out.write("    <meta charset=\"utf-8\">\n");
      out.write("    <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\n");
      out.write("    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\n");
      out.write("    <title>CD archive</title>\n");
      out.write("    <link rel=\"stylesheet\" href=\"//cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css\">\n");
      out.write("    <link rel=\"stylesheet\" href=\"//cdnjs.cloudflare.com/ajax/libs/animate.css/3.5.2/animate.min.css\">\n");
      out.write("    <link rel=\"stylesheet\" href=\"//cdn.muicss.com/mui-latest/extra/mui-colors.min.css\">\n");
      out.write("    <link rel=\"stylesheet\" href=\"");
      out.print(request.getContextPath());
      out.write("/static/css/style.css\">\n");
      out.write("    <script src=\"//cdn.muicss.com/mui-latest/extra/mui-combined.min.js\"></script>\n");
      out.write("    <script src=\"https://code.jquery.com/jquery-2.1.0.js\"></script>\n");
      out.write("    <title>Home</title>\n");
      out.write("</head>\n");
      out.write("<body>\n");
      out.write("<header class=\"mui-appbar mui--z1\">\n");
      out.write("    <div class=\"mui-container\">\n");
      out.write("        <table>\n");
      out.write("            <tr class=\"mui--appbar-height\">\n");
      out.write("                <td class=\"mui--text-title\">CD.io</td>\n");
      out.write("                <td class=\"mui--text-right\">\n");
      out.write("                    <ul class=\"mui-list--inline mui--text-body2\">\n");
      out.write("                        <li><a href=\"");
      out.print(request.getContextPath());
      out.write("/\">Home</a></li>\n");
      out.write("                        <li><a href=\"");
      out.print(request.getContextPath());
      out.write("/index\">CD archive</a></li>\n");
      out.write("                        <li><a href=\"https://github.com/frytgy22/javahw/tree/master/sessionJSP\"><i class=\"fa fa-github\"\n");
      out.write("                             aria-hidden=\"true\"></i>Github</a></li>\n");
      out.write("                    </ul>\n");
      out.write("                </td>\n");
      out.write("            </tr>\n");
      out.write("        </table>\n");
      out.write("    </div>\n");
      out.write("</header>");
      out.write("\n");
      out.write("<script src=\"");
      out.print(request.getContextPath());
      out.write("/static/js/index.js\"></script>\n");
      out.write("\n");
      out.write("<button id=\"button\" class=\"mui-btn mui-btn--raised mui-btn--primary mui--pull-right\"\n");
      out.write("        onclick=\"location.href='");
      out.print(request.getContextPath());
      out.write("/add'\">add new cd\n");
      out.write("</button>\n");
      out.write("\n");
      out.write("<table class=\"mui-table mui-table--bordered padding\" id=\"table\">\n");
      out.write("    <thead>\n");
      out.write("    <tr>\n");
      out.write("        <th>Id</th>\n");
      out.write("        <th>Name</th>\n");
      out.write("        <th>Singer</th>\n");
      out.write("        <th></th>\n");
      out.write("    </tr>\n");
      out.write("    </thead>\n");
      out.write("    <tbody>\n");
      out.write("    ");

        if (session.getAttribute("Archive") != null) {
            Archive archive = (Archive) session.getAttribute("Archive");
            Collections.sort(archive.getCdDiskList());

            for (CdDisk cdDisk : archive.getCdDiskList()) { 
      out.write("\n");
      out.write("    <tr>\n");
      out.write("        <td>");
      out.print(cdDisk.getId());
      out.write("\n");
      out.write("        </td>\n");
      out.write("        <td>");
      out.print(cdDisk.getName());
      out.write("\n");
      out.write("        </td>\n");
      out.write("        <td>");
      out.print(cdDisk.getSinger());
      out.write("\n");
      out.write("        </td>\n");
      out.write("        <td>\n");
      out.write("            <button name=\"edit\" class=\"mui-btn mui-btn--small mui-btn--primary\">edit</button>\n");
      out.write("            <button name=\"delete\" class=\"mui-btn mui-btn--small mui-btn--danger\">delete</button>\n");
      out.write("        </td>\n");
      out.write("    </tr>\n");
      out.write("    ");
 }
    }
      out.write("\n");
      out.write("    </tbody>\n");
      out.write("</table>\n");
      out.write("\n");
      out.write("<form class=\"mui-form padding\" id=\"edit\" action=\"");
      out.print(request.getContextPath());
      out.write("/edit\" method=\"post\">\n");
      out.write("    <legend id=\"info\"></legend>\n");
      out.write("    <input type=\"hidden\" name=\"id\">\n");
      out.write("    ");
      out.write("<div class=\"mui-textfield\">\n");
      out.write("    <input autofocus name=\"name\" maxlength=\"40\"><label>Name CD</label>\n");
      out.write("</div>\n");
      out.write("<div class=\"mui-textfield\">\n");
      out.write("    <input name=\"singer\" maxlength=\"40\"><label>Singer</label>\n");
      out.write("</div>\n");
      out.write("<button type=\"submit\" class=\"mui-btn mui-btn--raised\">Submit</button>\n");
      out.write("\n");
      out.write("    <button type=\"button\" class=\"mui-btn mui-btn--flat mui-btn--danger\"\n");
      out.write("            onclick=\"location.href='");
      out.print(request.getContextPath());
      out.write("/index'\">cancel\n");
      out.write("    </button>\n");
      out.write("</form>\n");
      out.write("\n");
      out.write("<form id=\"delete\" action=\"");
      out.print(request.getContextPath());
      out.write("/delete\" method=\"post\">\n");
      out.write("    <input type=\"hidden\" name=\"id\">\n");
      out.write("</form>\n");
      out.write("\n");
      out.write("</body>\n");
      out.write("</html>\n");
      out.write("\n");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try { out.clearBuffer(); } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}