/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/8.5.61
 * Generated at: 2022-04-19 09:48:46 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF.views.web;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class contact_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.HashMap<java.lang.String,java.lang.Long>(5);
    _jspx_dependants.put("/common/taglib.jsp", Long.valueOf(1649864792863L));
    _jspx_dependants.put("jar:file:/D:/SpringBoot_shop/.metadata/.plugins/org.eclipse.wst.server.core/tmp0/wtpwebapps/shop/WEB-INF/lib/spring-webmvc-5.3.18.jar!/META-INF/spring-form.tld", Long.valueOf(1648691400000L));
    _jspx_dependants.put("jar:file:/D:/SpringBoot_shop/.metadata/.plugins/org.eclipse.wst.server.core/tmp0/wtpwebapps/shop/WEB-INF/lib/jstl-1.2.jar!/META-INF/c.tld", Long.valueOf(1153359882000L));
    _jspx_dependants.put("/WEB-INF/lib/jstl-1.2.jar", Long.valueOf(1642891727448L));
    _jspx_dependants.put("/WEB-INF/lib/spring-webmvc-5.3.18.jar", Long.valueOf(1649094201830L));
  }

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_classes = null;
  }

  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fc_005furl_0026_005fvalue_005fnobody;

  private volatile javax.el.ExpressionFactory _el_expressionfactory;
  private volatile org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public java.util.Set<java.lang.String> getPackageImports() {
    return _jspx_imports_packages;
  }

  public java.util.Set<java.lang.String> getClassImports() {
    return _jspx_imports_classes;
  }

  public javax.el.ExpressionFactory _jsp_getExpressionFactory() {
    if (_el_expressionfactory == null) {
      synchronized (this) {
        if (_el_expressionfactory == null) {
          _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
        }
      }
    }
    return _el_expressionfactory;
  }

  public org.apache.tomcat.InstanceManager _jsp_getInstanceManager() {
    if (_jsp_instancemanager == null) {
      synchronized (this) {
        if (_jsp_instancemanager == null) {
          _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
        }
      }
    }
    return _jsp_instancemanager;
  }

  public void _jspInit() {
    _005fjspx_005ftagPool_005fc_005furl_0026_005fvalue_005fnobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
  }

  public void _jspDestroy() {
    _005fjspx_005ftagPool_005fc_005furl_0026_005fvalue_005fnobody.release();
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
      throws java.io.IOException, javax.servlet.ServletException {

    final java.lang.String _jspx_method = request.getMethod();
    if (!"GET".equals(_jspx_method) && !"POST".equals(_jspx_method) && !"HEAD".equals(_jspx_method) && !javax.servlet.DispatcherType.ERROR.equals(request.getDispatcherType())) {
      response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "JSPs only permit GET, POST or HEAD. Jasper also permits OPTIONS");
      return;
    }

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write('\r');
      out.write('\n');
      out.write('\n');
      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<head>\r\n");
      out.write("  <meta charset=\"UTF-8\">\r\n");
      out.write("  <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\r\n");
      out.write("  <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\r\n");
      out.write("  <title>Contact</title>\r\n");
      out.write("<link rel=\"stylesheet\" href=\"");
      if (_jspx_meth_c_005furl_005f0(_jspx_page_context))
        return;
      out.write(" \">\r\n");
      out.write("  <link rel=\"stylesheet\" href=\"");
      if (_jspx_meth_c_005furl_005f1(_jspx_page_context))
        return;
      out.write(" \">\r\n");
      out.write("</head>\r\n");
      out.write("\r\n");
      out.write("<body>\r\n");
      out.write("\r\n");
      out.write("  <!-- nav -->\r\n");
      out.write("  <nav class=\"navbar sticky-top navbar-expand-sm navbar-light  \" style=\"background-color: #f0ecdd;\"\r\n");
      out.write("    style=\"color: aqua ;\">\r\n");
      out.write("    <div class=\"container\">\r\n");
      out.write("      <a class=\"navbar-brand\" href=\"index.html\">\r\n");
      out.write("        <img src=\"./image/home.png\" alt=\"\" style=\"width: 40px;\">\r\n");
      out.write("      </a>\r\n");
      out.write("      <button class=\"navbar-toggler d-lg-none\" type=\"button\" data-toggle=\"collapse\" data-target=\"#mainmenu\"\r\n");
      out.write("        aria-expanded=\"false\" aria-label=\"Toggle navigation\">\r\n");
      out.write("        <span class=\"navbar-toggler-icon\"></span>\r\n");
      out.write("      </button>\r\n");
      out.write("      <div class=\"collapse navbar-collapse\" id=\"mainmenu\">\r\n");
      out.write("        <ul class=\"navbar-nav mr-auto mt-2 mt-lg-0\">\r\n");
      out.write("          <li class=\"nav-item active\"><a class=\"nav-link\" href=\"index.html\">HOME</span></a></li>\r\n");
      out.write("         \r\n");
      out.write("          <li class=\"nav-item dropdown\">\r\n");
      out.write("            <a class=\"nav-link dropdown-toggle\" href=\"#\" data-toggle=\"dropdown\">Product</a>\r\n");
      out.write("            <div class=\"dropdown-menu\">\r\n");
      out.write("              <a class=\"dropdown-item\" href=\"product.html\">Fresh Fruit</a>\r\n");
      out.write("              <a class=\"dropdown-item\" href=\"product.html\">Fresh Fruit</a>\r\n");
      out.write("              <a class=\"dropdown-item\" href=\"product.html\">Fresh Fruit</a>\r\n");
      out.write("              <a class=\"dropdown-item\" href=\"product.html\">Fresh Fruit</a>\r\n");
      out.write("            </div>\r\n");
      out.write("          </li>\r\n");
      out.write("          <li class=\"nav-item\"><a class=\"nav-link\" href=\"contact.html\">CONTACT</a></li>\r\n");
      out.write("          <li class=\"nav-item\"><a class=\"nav-link\" href=\"cart.html\">CART</a></li>\r\n");
      out.write("\r\n");
      out.write("        </ul>\r\n");
      out.write("        <form class=\"form-inline my-2 my-lg-0\">\r\n");
      out.write("          <input class=\"form-control mr-sm-2\" type=\"text\" placeholder=\"Search\">\r\n");
      out.write("          <button class=\"btn btn-outline-success my-2 my-sm-0\" type=\"submit\">Search</button>\r\n");
      out.write("        </form>\r\n");
      out.write("        <form class=\"form-inline  login\">\r\n");
      out.write("          <button class=\"btn btn-outline-success my-2 my-sm-0\" type=\"submit\">\r\n");
      out.write("            <a href=\"login.html\">\r\n");
      out.write("              Login\r\n");
      out.write("            </a>\r\n");
      out.write("          </button>\r\n");
      out.write("        </form>\r\n");
      out.write("        <form class=\"form-inline my-2 my-lg-0 sign-up\">\r\n");
      out.write("          <button class=\"btn btn-outline-success my-2 my-sm-0\" type=\"submit\">\r\n");
      out.write("            <a href=\"sign-up.html\"> Sign-up</a>\r\n");
      out.write("          </button>\r\n");
      out.write("        </form>\r\n");
      out.write("      </div>\r\n");
      out.write("    </div>\r\n");
      out.write("  </nav>\r\n");
      out.write("\r\n");
      out.write("  <!-- banner slide -->\r\n");
      out.write("  <div id=\"banner\" class=\"carousel slide\" data-ride=\"carousel\" >\r\n");
      out.write("    <img src=\"./image/banner_3.jpg\" alt=\"\" style=\"width:100% ;   height: 500px;\">\r\n");
      out.write("</div>\r\n");
      out.write("\r\n");
      out.write("  <!-- chia lÆ°á»t -->\r\n");
      out.write(" <div class=\"container\">\r\n");
      out.write("   <div class=\"row\">\r\n");
      out.write("     <div class=\"col-md-3 col-sm-6 text-center\">\r\n");
      out.write("       <div class=\"contact\">\r\n");
      out.write("        <img src=\"./image/phone-call-icon.png\" alt=\"\" style=\"  width: 36px;height: 36px; \">\r\n");
      out.write("        <h4>Phone</h4>\r\n");
      out.write("        <p>+01-234-567-89</p>\r\n");
      out.write("       </div>\r\n");
      out.write("      \r\n");
      out.write("      </div>\r\n");
      out.write("      <div class=\"col-md-3 col-sm-6 text-center\">\r\n");
      out.write("        <div class=\"contact\">\r\n");
      out.write("         <img src=\"./image/icon diachi.jpg\" alt=\"\" style=\"  width: 36px;height: 36px; \">\r\n");
      out.write("         <h4>Address</h4>\r\n");
      out.write("         <p>238-HoÃ ng Quá»c Viá»t</p>\r\n");
      out.write("        </div>\r\n");
      out.write("       \r\n");
      out.write("       </div>\r\n");
      out.write("       <div class=\"col-md-3 col-sm-6 text-center\">\r\n");
      out.write("        <div class=\"contact\">\r\n");
      out.write("         <img src=\"./image/icondongho.jpg\" alt=\"\" style=\"  width: 36px;height: 36px; \">\r\n");
      out.write("         <h4>Open Time</h4>\r\n");
      out.write("         <p>8:00 am to 8:00 pm</p>\r\n");
      out.write("        </div>\r\n");
      out.write("       \r\n");
      out.write("       </div>\r\n");
      out.write("       <div class=\"col-md-3 col-sm-6 text-center\">\r\n");
      out.write("        <div class=\"contact\">\r\n");
      out.write("         <img src=\"./image/iconmail.jpg\" alt=\"\" style=\"  width: 36px;height: 36px; \">\r\n");
      out.write("         <h4>Email</h4>\r\n");
      out.write("         <p>BkAptech@gmail.com</p>\r\n");
      out.write("        </div>\r\n");
      out.write("       \r\n");
      out.write("       </div>\r\n");
      out.write("    </div>\r\n");
      out.write(" </div>\r\n");
      out.write(" <!-- báº£n Äá» -->\r\n");
      out.write(" <iframe\r\n");
      out.write(" src=\"https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d59587.97785449821!2d105.80194400550647!3d21.02273601626801!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x3135ab9bd9861ca1%3A0xe7887f7b72ca17a9!2zSMOgIE7hu5lpLCBIb8OgbiBLaeG6v20sIEjDoCBO4buZaSwgVmnhu4d0IE5hbQ!5e0!3m2!1svi!2s!4v1645101482752!5m2!1svi!2s\"\r\n");
      out.write(" style=\"border:0; width: 100%; height: 500px;\" allowfullscreen=\"\" loading=\"lazy\" ></iframe>\r\n");
      out.write("\r\n");
      out.write(" <div class=\"contact-title\">\r\n");
      out.write("   <h2>Feedback </h2>\r\n");
      out.write(" </div>\r\n");
      out.write(" <!-- form -->\r\n");
      out.write(" <div class=\"container form-contact\">\r\n");
      out.write("  <form>\r\n");
      out.write("    <div class=\"form-row\">\r\n");
      out.write("      <div class=\"form-group col-md-6\">\r\n");
      out.write("        <label for=\"name\">Name</label>\r\n");
      out.write("        <input type=\"text\" class=\"form-control\" id=\"name\" placeholder=\"name\">\r\n");
      out.write("      </div>\r\n");
      out.write("      <div class=\"form-group col-md-6\">\r\n");
      out.write("        <label for=\"inputEmail4\">Email</label>\r\n");
      out.write("        <input type=\"email\" class=\"form-control\" id=\"inputEmail4\" placeholder=\"email@gmail.com\">\r\n");
      out.write("      </div>\r\n");
      out.write("      \r\n");
      out.write("    </div>\r\n");
      out.write("    <div class=\"form-group\">\r\n");
      out.write("      <label for=\"inputAddress\">Address</label>\r\n");
      out.write("      <input type=\"text\" class=\"form-control\" id=\"inputAddress\" placeholder=\"address\">\r\n");
      out.write("    </div>\r\n");
      out.write("     <div class=\"form-group\">\r\n");
      out.write("      <label for=\"inputNumber\">NumberPhone</label>\r\n");
      out.write("      <input type=\"number\" class=\"form-control\" id=\"inputNumber\" placeholder=\"NumberPhone\">\r\n");
      out.write("    </div>\r\n");
      out.write("    <div class=\"form-group\">\r\n");
      out.write("      <label for=\"exampleFormControlTextarea1\">Your Messager</label>\r\n");
      out.write("      <textarea class=\"form-control\" id=\"exampleFormControlTextarea1\" rows=\"3\" placeholder=\"your messager\"></textarea>\r\n");
      out.write("    </div>\r\n");
      out.write("    <button type=\"submit\" class=\"btn btn-primary text-center\">SEND MESSAGER</button>\r\n");
      out.write("  </form>\r\n");
      out.write(" </div>\r\n");
      out.write(" \r\n");
      out.write("  <!-- footer -->\r\n");
      out.write("  <footer class=\"footer  text-black-50 py-5 footer-style\">\r\n");
      out.write("    <div class=\"container footer-style\">\r\n");
      out.write("        <div class=\"row\">\r\n");
      out.write("            <div class=\"col-md-4\">\r\n");
      out.write("               <img src=\"./image/logo.png\" alt=\"\">\r\n");
      out.write("            <ul class = \"info\">\r\n");
      out.write("              <li>Address :238 ,Hoang Quoc Viet</li>\r\n");
      out.write("              <li>Phone :+0123456789</li>\r\n");
      out.write("              <li>Email : bkap@gmail.com</li>\r\n");
      out.write("            </ul>\r\n");
      out.write("            </div>\r\n");
      out.write("            <div class=\"col-md-2 useful-link \" >\r\n");
      out.write("                <h5>Useful Link</h5>\r\n");
      out.write("                 <ul>\r\n");
      out.write("                    <li><a href=\"\">Trang chủ</a></li>\r\n");
      out.write("                    <li><a href=\"\">Giới thiệu</a></li>\r\n");
      out.write("                    <li><a href=\"\">Đối Tác</a></li>\r\n");
      out.write("                    <li><a href=\"\">Liên hệ</a></li>\r\n");
      out.write("                </ul>\r\n");
      out.write("            </div>\r\n");
      out.write("            <div class=\"col-md-6\">\r\n");
      out.write("                <iframe\r\n");
      out.write("                    src=\"https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d59587.97785449821!2d105.80194400550647!3d21.02273601626801!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x3135ab9bd9861ca1%3A0xe7887f7b72ca17a9!2zSMOgIE7hu5lpLCBIb8OgbiBLaeG6v20sIEjDoCBO4buZaSwgVmnhu4d0IE5hbQ!5e0!3m2!1svi!2s!4v1645101482752!5m2!1svi!2s\"\r\n");
      out.write("                    style=\"border:0; width: 100%; height: 200px;\" allowfullscreen=\"\" loading=\"lazy\"></iframe>\r\n");
      out.write("            </div>\r\n");
      out.write("        </div>\r\n");
      out.write("    </div>\r\n");
      out.write("</footer>\r\n");
      out.write("\r\n");
      out.write("   <!-- Copyright -->\r\n");
      out.write("   <div class=\"footer-copyright text-center py-3\" style=\"background-color: darkmagenta;\">Â©238_HoangQuocViet:\r\n");
      out.write("    <a href=\"https://mdbootstrap.com/\"> BkAptech.com</a>\r\n");
      out.write("  </div>\r\n");
      out.write("  <!-- Copyright -->\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("  <!-- Footer -->\r\n");
      out.write("  <!-- chá»nh sá»­a thá»i gian slide cháº¡y -->\r\n");
      out.write("  <script>\r\n");
      out.write("    $('#carouselExampleIndicators').carousel({\r\n");
      out.write("      interval: 1000 * 3\r\n");
      out.write("    });\r\n");
      out.write("  </script>\r\n");
      out.write("  <script src=\"");
      if (_jspx_meth_c_005furl_005f2(_jspx_page_context))
        return;
      out.write("\"></script>\r\n");
      out.write("  <script src=\"");
      if (_jspx_meth_c_005furl_005f3(_jspx_page_context))
        return;
      out.write("\"></script>\r\n");
      out.write("</body>\r\n");
      out.write("\r\n");
      out.write("</html>");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try {
            if (response.isCommitted()) {
              out.flush();
            } else {
              out.clearBuffer();
            }
          } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }

  private boolean _jspx_meth_c_005furl_005f0(javax.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  c:url
    org.apache.taglibs.standard.tag.rt.core.UrlTag _jspx_th_c_005furl_005f0 = (org.apache.taglibs.standard.tag.rt.core.UrlTag) _005fjspx_005ftagPool_005fc_005furl_0026_005fvalue_005fnobody.get(org.apache.taglibs.standard.tag.rt.core.UrlTag.class);
    boolean _jspx_th_c_005furl_005f0_reused = false;
    try {
      _jspx_th_c_005furl_005f0.setPageContext(_jspx_page_context);
      _jspx_th_c_005furl_005f0.setParent(null);
      // /WEB-INF/views/web/contact.jsp(10,29) name = value type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
      _jspx_th_c_005furl_005f0.setValue("/template/web/css/bootstrap.min.css");
      int _jspx_eval_c_005furl_005f0 = _jspx_th_c_005furl_005f0.doStartTag();
      if (_jspx_th_c_005furl_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
      _005fjspx_005ftagPool_005fc_005furl_0026_005fvalue_005fnobody.reuse(_jspx_th_c_005furl_005f0);
      _jspx_th_c_005furl_005f0_reused = true;
    } finally {
      org.apache.jasper.runtime.JspRuntimeLibrary.releaseTag(_jspx_th_c_005furl_005f0, _jsp_getInstanceManager(), _jspx_th_c_005furl_005f0_reused);
    }
    return false;
  }

  private boolean _jspx_meth_c_005furl_005f1(javax.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  c:url
    org.apache.taglibs.standard.tag.rt.core.UrlTag _jspx_th_c_005furl_005f1 = (org.apache.taglibs.standard.tag.rt.core.UrlTag) _005fjspx_005ftagPool_005fc_005furl_0026_005fvalue_005fnobody.get(org.apache.taglibs.standard.tag.rt.core.UrlTag.class);
    boolean _jspx_th_c_005furl_005f1_reused = false;
    try {
      _jspx_th_c_005furl_005f1.setPageContext(_jspx_page_context);
      _jspx_th_c_005furl_005f1.setParent(null);
      // /WEB-INF/views/web/contact.jsp(11,31) name = value type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
      _jspx_th_c_005furl_005f1.setValue("/template/web/css/css/my_style.css");
      int _jspx_eval_c_005furl_005f1 = _jspx_th_c_005furl_005f1.doStartTag();
      if (_jspx_th_c_005furl_005f1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
      _005fjspx_005ftagPool_005fc_005furl_0026_005fvalue_005fnobody.reuse(_jspx_th_c_005furl_005f1);
      _jspx_th_c_005furl_005f1_reused = true;
    } finally {
      org.apache.jasper.runtime.JspRuntimeLibrary.releaseTag(_jspx_th_c_005furl_005f1, _jsp_getInstanceManager(), _jspx_th_c_005furl_005f1_reused);
    }
    return false;
  }

  private boolean _jspx_meth_c_005furl_005f2(javax.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  c:url
    org.apache.taglibs.standard.tag.rt.core.UrlTag _jspx_th_c_005furl_005f2 = (org.apache.taglibs.standard.tag.rt.core.UrlTag) _005fjspx_005ftagPool_005fc_005furl_0026_005fvalue_005fnobody.get(org.apache.taglibs.standard.tag.rt.core.UrlTag.class);
    boolean _jspx_th_c_005furl_005f2_reused = false;
    try {
      _jspx_th_c_005furl_005f2.setPageContext(_jspx_page_context);
      _jspx_th_c_005furl_005f2.setParent(null);
      // /WEB-INF/views/web/contact.jsp(188,15) name = value type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
      _jspx_th_c_005furl_005f2.setValue("/template/web/js/jquery.min.js");
      int _jspx_eval_c_005furl_005f2 = _jspx_th_c_005furl_005f2.doStartTag();
      if (_jspx_th_c_005furl_005f2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
      _005fjspx_005ftagPool_005fc_005furl_0026_005fvalue_005fnobody.reuse(_jspx_th_c_005furl_005f2);
      _jspx_th_c_005furl_005f2_reused = true;
    } finally {
      org.apache.jasper.runtime.JspRuntimeLibrary.releaseTag(_jspx_th_c_005furl_005f2, _jsp_getInstanceManager(), _jspx_th_c_005furl_005f2_reused);
    }
    return false;
  }

  private boolean _jspx_meth_c_005furl_005f3(javax.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  c:url
    org.apache.taglibs.standard.tag.rt.core.UrlTag _jspx_th_c_005furl_005f3 = (org.apache.taglibs.standard.tag.rt.core.UrlTag) _005fjspx_005ftagPool_005fc_005furl_0026_005fvalue_005fnobody.get(org.apache.taglibs.standard.tag.rt.core.UrlTag.class);
    boolean _jspx_th_c_005furl_005f3_reused = false;
    try {
      _jspx_th_c_005furl_005f3.setPageContext(_jspx_page_context);
      _jspx_th_c_005furl_005f3.setParent(null);
      // /WEB-INF/views/web/contact.jsp(189,15) name = value type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
      _jspx_th_c_005furl_005f3.setValue("/template/web/js/bootstrap.min.js");
      int _jspx_eval_c_005furl_005f3 = _jspx_th_c_005furl_005f3.doStartTag();
      if (_jspx_th_c_005furl_005f3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
      _005fjspx_005ftagPool_005fc_005furl_0026_005fvalue_005fnobody.reuse(_jspx_th_c_005furl_005f3);
      _jspx_th_c_005furl_005f3_reused = true;
    } finally {
      org.apache.jasper.runtime.JspRuntimeLibrary.releaseTag(_jspx_th_c_005furl_005f3, _jsp_getInstanceManager(), _jspx_th_c_005furl_005f3_reused);
    }
    return false;
  }
}