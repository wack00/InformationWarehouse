/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.47
 * Generated at: 2015-12-17 17:37:42 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import com.vacko.springapp.web.controllers.UserController;

public final class reportPannel_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.HashMap<java.lang.String,java.lang.Long>(1);
    _jspx_dependants.put("/WEB-INF/jsp/taglib.jsp", Long.valueOf(1450372996822L));
  }

  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fc_005furl_0026_005fvar_005fvalue_005fnobody;
  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvar_005fitems;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _005fjspx_005ftagPool_005fc_005furl_0026_005fvar_005fvalue_005fnobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvar_005fitems = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
  }

  public void _jspDestroy() {
    _005fjspx_005ftagPool_005fc_005furl_0026_005fvar_005fvalue_005fnobody.release();
    _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvar_005fitems.release();
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
      response.setContentType("text/html");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("<!DOCTYPE html>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      if (_jspx_meth_c_005furl_005f0(_jspx_page_context))
        return;
      out.write('\r');
      out.write('\n');
      if (_jspx_meth_c_005furl_005f1(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<html lang=\"en\">\r\n");
      out.write("\r\n");
      out.write("<head>\r\n");
      out.write("\r\n");
      out.write("<meta charset=\"utf-8\">\r\n");
      out.write("<meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\r\n");
      out.write("<meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\r\n");
      out.write("<meta name=\"description\" content=\"\">\r\n");
      out.write("<meta name=\"author\" content=\"\">\r\n");
      out.write("\r\n");
      out.write("<title>Report Pannel</title>\r\n");
      out.write("\r\n");
      out.write("<!-- Bootstrap Core CSS -->\r\n");
      out.write("<link href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${rootLink}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/resources/bootstrap/css/bootstrap.min.css\"\r\n");
      out.write("\trel=\"stylesheet\">\r\n");
      out.write("\r\n");
      out.write("<!-- Custom CSS -->\r\n");
      out.write("<link href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${rootLink}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/resources/css/sb-admin.css\" rel=\"stylesheet\">\r\n");
      out.write("\r\n");
      out.write("<!--     Morris Charts CSS -->\r\n");
      out.write("<!--     <link href=\"css/plugins/morris.css\" rel=\"stylesheet\"> -->\r\n");
      out.write("\r\n");
      out.write("<!--     Custom Fonts -->\r\n");
      out.write("<!--     <link href=\"font-awesome/css/font-awesome.min.css\" rel=\"stylesheet\" type=\"text/css\"> -->\r\n");
      out.write("\r\n");
      out.write("<!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->\r\n");
      out.write("<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->\r\n");
      out.write("<!--[if lt IE 9]>\r\n");
      out.write("        <script src=\"https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js\"></script>\r\n");
      out.write("        <script src=\"https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js\"></script>\r\n");
      out.write("    <![endif]-->\r\n");
      out.write("\r\n");
      out.write("</head>\r\n");
      out.write("\r\n");
      out.write("<body>\r\n");
      out.write("\r\n");
      out.write("<script type='text/javascript'>\t\r\n");
      out.write("\r\n");
      out.write("function acceptReportedComment(id)\r\n");
      out.write("{\r\n");
      out.write("\t\r\n");
      out.write("//\talert(id);\r\n");
      out.write("\r\n");
      out.write("\t $.ajax({\r\n");
      out.write("         type: \"GET\",\r\n");
      out.write("         url: \"http://localhost:8080/InformationWarehouse/acceptReportedComment/\" + id,\r\n");
      out.write("         data: \"id=\" + id + \"&name=\" ,\r\n");
      out.write("         success: function(msg){\r\n");
      out.write("                  //alert(msg);\r\n");
      out.write("                  $(\"#tableRow\"+id).fadeOut();\r\n");
      out.write("                  }\r\n");
      out.write("    });\r\n");
      out.write("}\t\r\n");
      out.write("\r\n");
      out.write("function denyReportedComment(id)\r\n");
      out.write("{\r\n");
      out.write("\t//alert(id);\r\n");
      out.write("\r\n");
      out.write("\t$.ajax({\r\n");
      out.write("        type: \"GET\",\r\n");
      out.write("        url: \"http://localhost:8080/InformationWarehouse/denyComment/\" + id,\r\n");
      out.write("        data: \"id=\" + id + \"&name=\" ,\r\n");
      out.write("        success: function(msg){\r\n");
      out.write("                 //alert(msg);\r\n");
      out.write("                 $(\"#tableRow\"+id).fadeOut();\r\n");
      out.write("                 }\r\n");
      out.write("   });\r\n");
      out.write("}\t\r\n");
      out.write("</script>\r\n");
      out.write("\r\n");
      out.write("\t<div id=\"wrapper\">\r\n");
      out.write("\r\n");
      out.write("\t\t<!-- Navigation -->\r\n");
      out.write("\t\t<nav class=\"navbar navbar-inverse navbar-fixed-top\" role=\"navigation\">\r\n");
      out.write("\t\t\t<!-- Brand and toggle get grouped for better mobile display -->\r\n");
      out.write("\t\t\t<div class=\"navbar-header\">\r\n");
      out.write("\t\t\t\t<button type=\"button\" class=\"navbar-toggle\" data-toggle=\"collapse\"\r\n");
      out.write("\t\t\t\t\tdata-target=\".navbar-ex1-collapse\">\r\n");
      out.write("\t\t\t\t\t<span class=\"sr-only\">Toggle navigation</span> <span\r\n");
      out.write("\t\t\t\t\t\tclass=\"icon-bar\"></span> <span class=\"icon-bar\"></span> <span\r\n");
      out.write("\t\t\t\t\t\tclass=\"icon-bar\"></span>\r\n");
      out.write("\t\t\t\t</button>\r\n");
      out.write("\t\t\t\t<a class=\"navbar-brand\" href=\"#\">Admin Dashboard</a>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t\t<!-- Top Menu Items -->\r\n");
      out.write("\t\t\t<ul class=\"nav navbar-right top-nav\">\r\n");
      out.write("\t\t\t\t\r\n");
      out.write("\t\t\t\t<li class=\"dropdown\"><a href=\"#\" class=\"dropdown-toggle\"\r\n");
      out.write("\t\t\t\t\tdata-toggle=\"dropdown\"><i class=\"fa fa-user\"></i> ");
      out.print(UserController.getCurrentUser().getName() );
      out.write("  <b\r\n");
      out.write("\t\t\t\t\t\tclass=\"caret\"></b></a>\r\n");
      out.write("\t\t\t\t\t<ul class=\"dropdown-menu\">\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t\t\t<li><a href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${rootLink}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/logout\"><i class=\"fa fa-fw fa-power-off\"></i> Log\r\n");
      out.write("\t\t\t\t\t\t\t\tOut</a></li>\r\n");
      out.write("\t\t\t\t\t</ul></li>\r\n");
      out.write("\t\t\t</ul>\r\n");
      out.write("\t\t\t<!-- Sidebar Menu Items - These collapse to the responsive navigation menu on small screens -->\r\n");
      out.write("\t\t\t<div class=\"collapse navbar-collapse navbar-ex1-collapse\">\r\n");
      out.write("\t\t\t\t<ul class=\"nav navbar-nav side-nav\">\r\n");
      out.write("\t\t\t\t\t<li><a href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${rootLink}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/adminPannel\"><i\r\n");
      out.write("\t\t\t\t\t\t\tclass=\"fa fa-fw fa-dashboard\"></i> Dashboard</a></li>\r\n");
      out.write("\t\t\t\t\t<li ><a href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${rootLink}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/postPannel\"><i\r\n");
      out.write("\t\t\t\t\t\t\tclass=\"fa fa-fw fa-bar-chart-o\"></i> Posts Waiting Approval</a></li>\r\n");
      out.write("\t\t\t\t\t<li ><a  href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${rootLink}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/commentPannel\"><i class=\"fa fa-fw fa-table\"></i>\r\n");
      out.write("\t\t\t\t\t\t\tComments Waiting Approval</a></li>\r\n");
      out.write("\t\t\t\t\t<li class=\"active\"><a href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${rootLink}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/reportPannel\"><i class=\"fa fa-fw fa-edit\"></i>\r\n");
      out.write("\t\t\t\t\t\t\tReported Comments</a></li>\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t</ul>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t\t<!-- /.navbar-collapse -->\r\n");
      out.write("\t\t</nav>\r\n");
      out.write("\r\n");
      out.write("\t\t<div id=\"page-wrapper\">\r\n");
      out.write("\r\n");
      out.write("\t\t\t<div class=\"container-fluid\">\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t<!-- Page Heading -->\r\n");
      out.write("\t\t\t\t<div class=\"row\">\r\n");
      out.write("\t\t\t\t\t<div class=\"col-lg-12\">\r\n");
      out.write("\t\t\t\t\t\t<h1 class=\"page-header\">\r\n");
      out.write("\t\t\t\t\t\t\tReport Pannel<small>  Statistics Overview</small>\r\n");
      out.write("\t\t\t\t\t\t</h1>\r\n");
      out.write("\t\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t<!-- /.row -->\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t<!-- /.row -->\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t<div class=\"row\">\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t\t<div class=\"col-lg-8\">\r\n");
      out.write("\t\t\t\t\t\t<div class=\"panel panel-default\">\r\n");
      out.write("\t\t\t\t\t\t\t<div class=\"panel-heading\">\r\n");
      out.write("\t\t\t\t\t\t\t\t<h3 class=\"panel-title\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<i class=\"fa fa-money fa-fw\"></i> Comment Panel\r\n");
      out.write("\t\t\t\t\t\t\t\t</h3>\r\n");
      out.write("\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t<div class=\"panel-body\">\r\n");
      out.write("\t\t\t\t\t\t\t\t<div class=\"table-responsive\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<table class=\"table table-bordered table-hover table-striped\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<thead>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t<th>Comment id #</th>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t<th>Comment Date</th>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t<th>Description</th>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t<th>Approve</th>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t<th>Disapprove</th>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t<th>&nbsp;</th>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t<th>&nbsp;</th>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t</thead>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<tbody>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t");
      if (_jspx_meth_c_005fforEach_005f0(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t</tbody>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t</table>\r\n");
      out.write("\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t<!-- /.row -->\r\n");
      out.write("\t\t\t\t                <!-- /.row -->\r\n");
      out.write("                <!-- /.row -->\r\n");
      out.write("                <div class=\"row\">&nbsp;</div>\r\n");
      out.write("                 <!-- /.row -->\r\n");
      out.write("                <div class=\"row\">&nbsp;</div>\r\n");
      out.write("                 <!-- /.row -->\r\n");
      out.write("                <div class=\"row\">&nbsp;</div>\r\n");
      out.write("                 <!-- /.row -->\r\n");
      out.write("                <div class=\"row\">&nbsp;</div>\r\n");
      out.write("                 <!-- /.row -->\r\n");
      out.write("                <div class=\"row\">&nbsp;</div>\r\n");
      out.write("                <!-- /.row -->\r\n");
      out.write("                <div class=\"row\">&nbsp;</div>\r\n");
      out.write("                <!-- /.row -->\r\n");
      out.write("                <div class=\"row\">&nbsp;</div>\r\n");
      out.write("                <!-- /.row -->\r\n");
      out.write("                <div class=\"row\">&nbsp;</div>\r\n");
      out.write("                <!-- /.row -->\r\n");
      out.write("                <div class=\"row\">&nbsp;</div>\r\n");
      out.write("                <!-- /.row -->\r\n");
      out.write("                <div class=\"row\">&nbsp;</div>\r\n");
      out.write("                <!-- /.row -->\r\n");
      out.write("                <div class=\"row\">&nbsp;</div>\r\n");
      out.write("                <!-- /.row -->\r\n");
      out.write("                <div class=\"row\">&nbsp;</div>\r\n");
      out.write("                <!-- /.row -->\r\n");
      out.write("                <div class=\"row\">&nbsp;</div>\r\n");
      out.write("                <!-- /.row -->\r\n");
      out.write("                <div class=\"row\">&nbsp;</div>\r\n");
      out.write("                <!-- /.row -->\r\n");
      out.write("                <div class=\"row\">&nbsp;</div>\r\n");
      out.write("                <!-- /.row -->\r\n");
      out.write("                <div class=\"row\">&nbsp;</div>\r\n");
      out.write("                <!-- /.row -->\r\n");
      out.write("                <div class=\"row\">&nbsp;</div>\r\n");
      out.write("                <!-- /.row -->\r\n");
      out.write("                <div class=\"row\">&nbsp;</div>\r\n");
      out.write("                <!-- /.row -->\r\n");
      out.write("                <div class=\"row\">&nbsp;</div>\r\n");
      out.write("                <!-- /.row -->\r\n");
      out.write("                <div class=\"row\">&nbsp;</div>\r\n");
      out.write("                <!-- /.row -->\r\n");
      out.write("                <div class=\"row\">&nbsp;</div>\r\n");
      out.write("                <!-- /.row -->\r\n");
      out.write("                <div class=\"row\">&nbsp;</div>\r\n");
      out.write("                <!-- /.row -->\r\n");
      out.write("                <div class=\"row\">&nbsp;</div>\r\n");
      out.write("                <!-- /.row -->\r\n");
      out.write("                <div class=\"row\">&nbsp;</div>\r\n");
      out.write("                <!-- /.row -->\r\n");
      out.write("                <div class=\"row\">&nbsp;</div>\r\n");
      out.write("                <!-- /.row -->\r\n");
      out.write("                <div class=\"row\">&nbsp;</div>\r\n");
      out.write("                <!-- /.row -->\r\n");
      out.write("                <div class=\"row\">&nbsp;</div>\r\n");
      out.write("                <!-- /.row -->\r\n");
      out.write("                <div class=\"row\">&nbsp;</div>\r\n");
      out.write("                <!-- /.row -->\r\n");
      out.write("                <div class=\"row\">&nbsp;</div>\r\n");
      out.write("                <!-- /.row -->\r\n");
      out.write("                <div class=\"row\">&nbsp;</div>\r\n");
      out.write("\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t\t<!-- /.container-fluid -->\r\n");
      out.write("\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\t<!-- /#page-wrapper -->\r\n");
      out.write("\r\n");
      out.write("\t</div>\r\n");
      out.write("\t<!-- /#wrapper -->\r\n");
      out.write("\r\n");
      out.write("\t<!-- jQuery -->\r\n");
      out.write("\t<script src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${rootLink}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/resources/bootstrap/js/jquery.js\"></script>\r\n");
      out.write("\r\n");
      out.write("\t<!-- Bootstrap Core JavaScript -->\r\n");
      out.write("\t<script src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${rootLink}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/resources/bootstrap/js/bootstrap.min.js\"></script>\r\n");
      out.write("\r\n");
      out.write("\t<!--     Morris Charts JavaScript -->\r\n");
      out.write("\t<!--     <script src=\"js/plugins/morris/raphael.min.js\"></script> -->\r\n");
      out.write("\t<!--     <script src=\"js/plugins/morris/morris.min.js\"></script> -->\r\n");
      out.write("\t<!--     <script src=\"js/plugins/morris/morris-data.js\"></script> -->\r\n");
      out.write("\r\n");
      out.write("</body>\r\n");
      out.write("\r\n");
      out.write("</html>\r\n");
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

  private boolean _jspx_meth_c_005furl_005f0(javax.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  c:url
    org.apache.taglibs.standard.tag.rt.core.UrlTag _jspx_th_c_005furl_005f0 = (org.apache.taglibs.standard.tag.rt.core.UrlTag) _005fjspx_005ftagPool_005fc_005furl_0026_005fvar_005fvalue_005fnobody.get(org.apache.taglibs.standard.tag.rt.core.UrlTag.class);
    _jspx_th_c_005furl_005f0.setPageContext(_jspx_page_context);
    _jspx_th_c_005furl_005f0.setParent(null);
    // /WEB-INF/jsp/taglib.jsp(7,0) name = var type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005furl_005f0.setVar("rootURL");
    // /WEB-INF/jsp/taglib.jsp(7,0) name = value type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005furl_005f0.setValue("/");
    int _jspx_eval_c_005furl_005f0 = _jspx_th_c_005furl_005f0.doStartTag();
    if (_jspx_th_c_005furl_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005furl_0026_005fvar_005fvalue_005fnobody.reuse(_jspx_th_c_005furl_005f0);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005furl_0026_005fvar_005fvalue_005fnobody.reuse(_jspx_th_c_005furl_005f0);
    return false;
  }

  private boolean _jspx_meth_c_005furl_005f1(javax.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  c:url
    org.apache.taglibs.standard.tag.rt.core.UrlTag _jspx_th_c_005furl_005f1 = (org.apache.taglibs.standard.tag.rt.core.UrlTag) _005fjspx_005ftagPool_005fc_005furl_0026_005fvar_005fvalue_005fnobody.get(org.apache.taglibs.standard.tag.rt.core.UrlTag.class);
    _jspx_th_c_005furl_005f1.setPageContext(_jspx_page_context);
    _jspx_th_c_005furl_005f1.setParent(null);
    // /WEB-INF/jsp/taglib.jsp(8,0) name = var type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005furl_005f1.setVar("rootLink");
    // /WEB-INF/jsp/taglib.jsp(8,0) name = value type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005furl_005f1.setValue("http://localhost:8080/InformationWarehouse");
    int _jspx_eval_c_005furl_005f1 = _jspx_th_c_005furl_005f1.doStartTag();
    if (_jspx_th_c_005furl_005f1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005furl_0026_005fvar_005fvalue_005fnobody.reuse(_jspx_th_c_005furl_005f1);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005furl_0026_005fvar_005fvalue_005fnobody.reuse(_jspx_th_c_005furl_005f1);
    return false;
  }

  private boolean _jspx_meth_c_005fforEach_005f0(javax.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  c:forEach
    org.apache.taglibs.standard.tag.rt.core.ForEachTag _jspx_th_c_005fforEach_005f0 = (org.apache.taglibs.standard.tag.rt.core.ForEachTag) _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvar_005fitems.get(org.apache.taglibs.standard.tag.rt.core.ForEachTag.class);
    _jspx_th_c_005fforEach_005f0.setPageContext(_jspx_page_context);
    _jspx_th_c_005fforEach_005f0.setParent(null);
    // /WEB-INF/jsp/reportPannel.jsp(162,11) name = var type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fforEach_005f0.setVar("comment");
    // /WEB-INF/jsp/reportPannel.jsp(162,11) name = items type = java.lang.Object reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fforEach_005f0.setItems((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${comments}", java.lang.Object.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
    int[] _jspx_push_body_count_c_005fforEach_005f0 = new int[] { 0 };
    try {
      int _jspx_eval_c_005fforEach_005f0 = _jspx_th_c_005fforEach_005f0.doStartTag();
      if (_jspx_eval_c_005fforEach_005f0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\r\n");
          out.write("\t\t\t\t\t\t\t\t\t\t\t\t<tr id=\"tableRow");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${comment.getCommentId() }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
          out.write("\">\r\n");
          out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t<td><a href=\"");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${rootLink}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
          out.write("/commentDetail/");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${comment.getCommentId()}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
          out.write('"');
          out.write('>');
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${comment.getCommentId()}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
          out.write("</a></td>\r\n");
          out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t<td>");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${comment.getDateCreated()}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
          out.write("</td>\r\n");
          out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t<td>");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${comment.getText()}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
          out.write("</td>\r\n");
          out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t<td>");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${comment.getCountApprove()}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
          out.write("</td>\r\n");
          out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t<td>");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${comment.getCountDisapprove()}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
          out.write("</td>\r\n");
          out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t<th><div  class=\"btn btn-success\" data-toggle=\"modal\" data-target=\"#myModal");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${comment.getCommentId() }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
          out.write("\">Accept</div></th>\r\n");
          out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t<th><div  class=\"btn btn-danger\" data-toggle=\"modal\" data-target=\"#myModalDeny");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${comment.getCommentId() }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
          out.write("\">Reject</div></th>\r\n");
          out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\r\n");
          out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<!-- Modal -->\r\n");
          out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"modal fade\" id=\"myModal");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${comment.getCommentId() }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
          out.write("\" tabindex=\"-1\" role=\"dialog\" aria-labelledby=\"myModalLabel\">\r\n");
          out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t  <div class=\"modal-dialog\" role=\"document\">\r\n");
          out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t    <div class=\"modal-content\">\r\n");
          out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t      <div class=\"modal-header\">\r\n");
          out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t        <button type=\"button\" class=\"close\" data-dismiss=\"modal\" aria-label=\"Close\"><span aria-hidden=\"true\">&times;</span></button>\r\n");
          out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t        <h4 class=\"modal-title\" id=\"myModalLabel\">Accept Reported Comment ");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${comment.getCommentId() }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
          out.write("</h4>\r\n");
          out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t      </div>\r\n");
          out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t      <div class=\"modal-body\">\r\n");
          out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t        Really Accept Reported Comment\r\n");
          out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t      </div>\r\n");
          out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t      <div class=\"modal-footer\">\r\n");
          out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t        <button type=\"button\" class=\"btn btn-default\" data-dismiss=\"modal\">Cancel</button>\r\n");
          out.write("<!-- \t\t\t\t\t\t\t\t\t\t\t\t\t        <a href=\"#\" class=\"btn btn-danger \">Reject</a> -->\r\n");
          out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t        <div onclick = \"acceptReportedComment(");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${comment.getCommentId()}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
          out.write(")\" class=\"btn btn-success \" data-dismiss=\"modal\">Accept</div>\r\n");
          out.write("\r\n");
          out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t      </div>\r\n");
          out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t    </div>\r\n");
          out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t  </div>\r\n");
          out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t</div>\r\n");
          out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t<!-- Modal  2 Deny-->\r\n");
          out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"modal fade\" id=\"myModalDeny");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${comment.getCommentId() }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
          out.write("\" tabindex=\"-1\" role=\"dialog\" aria-labelledby=\"myModalLabel\">\r\n");
          out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t  <div class=\"modal-dialog\" role=\"document\">\r\n");
          out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t    <div class=\"modal-content\">\r\n");
          out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t      <div class=\"modal-header\">\r\n");
          out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t        <button type=\"button\" class=\"close\" data-dismiss=\"modal\" aria-label=\"Close\"><span aria-hidden=\"true\">&times;</span></button>\r\n");
          out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t        <h4 class=\"modal-title\" id=\"myModalLabel\">Reject Reported Comment ");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${comment.getCommentId() }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
          out.write("</h4>\r\n");
          out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t      </div>\r\n");
          out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t      <div class=\"modal-body\">\r\n");
          out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t        Really Reject Reported Comment\r\n");
          out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t      </div>\r\n");
          out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t      <div class=\"modal-footer\">\r\n");
          out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t        <button type=\"button\" class=\"btn btn-default\" data-dismiss=\"modal\">Cancel</button>\r\n");
          out.write("<!-- \t\t\t\t\t\t\t\t\t\t\t\t\t        <a href=\"#\" class=\"btn btn-danger \">Reject</a> -->\r\n");
          out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t        <div onclick = \"denyReportedComment(");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${comment.getCommentId()}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
          out.write(")\" class=\"btn btn-danger \" data-dismiss=\"modal\">Reject</div>\r\n");
          out.write("\r\n");
          out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t      </div>\r\n");
          out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t    </div>\r\n");
          out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t  </div>\r\n");
          out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t</div>\r\n");
          out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\r\n");
          out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\r\n");
          out.write("\t\t\t\t\t\t\t\t\t\t\t\t</tr>\r\n");
          out.write("\t\t\t\t\t\t\t\t\t\t\t");
          int evalDoAfterBody = _jspx_th_c_005fforEach_005f0.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_c_005fforEach_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
    } catch (java.lang.Throwable _jspx_exception) {
      while (_jspx_push_body_count_c_005fforEach_005f0[0]-- > 0)
        out = _jspx_page_context.popBody();
      _jspx_th_c_005fforEach_005f0.doCatch(_jspx_exception);
    } finally {
      _jspx_th_c_005fforEach_005f0.doFinally();
      _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvar_005fitems.reuse(_jspx_th_c_005fforEach_005f0);
    }
    return false;
  }
}
