/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/8.5.69
 * Generated at: 2021-08-20 04:58:37 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.views.member;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import com.kh.member.model.vo.Member;
import com.kh.attachment.model.vo.ProfileAttachment;

public final class login_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.HashMap<java.lang.String,java.lang.Long>(2);
    _jspx_dependants.put("/views/member/../common/menubar.jsp", Long.valueOf(1629435486986L));
    _jspx_dependants.put("/views/member/../common/footer.jsp", Long.valueOf(1629160704073L));
  }

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_classes = new java.util.HashSet<>();
    _jspx_imports_classes.add("com.kh.attachment.model.vo.ProfileAttachment");
    _jspx_imports_classes.add("com.kh.member.model.vo.Member");
  }

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
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
      throws java.io.IOException, javax.servlet.ServletException {

    final java.lang.String _jspx_method = request.getMethod();
    if (!"GET".equals(_jspx_method) && !"POST".equals(_jspx_method) && !"HEAD".equals(_jspx_method) && !javax.servlet.DispatcherType.ERROR.equals(request.getDispatcherType())) {
      response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "JSP들은 오직 GET, POST 또는 HEAD 메소드만을 허용합니다. Jasper는 OPTIONS 메소드 또한 허용합니다.");
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

      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<script src=\"https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js\"></script> \r\n");
      out.write("<style>\r\n");
      out.write("    body{\r\n");
      out.write("        min-width:865px;\r\n");
      out.write("    }\r\n");
      out.write("   \r\n");
      out.write("    #title{\r\n");
      out.write("        margin: 100px;\r\n");
      out.write("        text-align: center;\r\n");
      out.write("       	font-size: 40px;\r\n");
      out.write("        font-weight:bold;\r\n");
      out.write("        color:rgba(156, 228, 228);\r\n");
      out.write("        margin-bottom: 0px;\r\n");
      out.write("    }\r\n");
      out.write("  \r\n");
      out.write("    table {font-size: 12pt;}\r\n");
      out.write("\r\n");
      out.write("    input {       \r\n");
      out.write("       padding:8px;\r\n");
      out.write("       width: 200px; \r\n");
      out.write("    }\r\n");
      out.write("\r\n");
      out.write("    #login{\r\n");
      out.write("        margin: 87px;\r\n");
      out.write("        margin-top:40px;\r\n");
      out.write("        display: flex;\r\n");
      out.write("        height:500px;\r\n");
      out.write("        justify-content: center;\r\n");
      out.write("        align-items: center;\r\n");
      out.write("    }\r\n");
      out.write("\r\n");
      out.write("    #loginBox{\r\n");
      out.write("        margin: 87px;\r\n");
      out.write("        margin-top:40px;\r\n");
      out.write("        height:350px;\r\n");
      out.write("        width: 600px;\r\n");
      out.write("        background-color: rgba(156, 228, 228, 0.253);\r\n");
      out.write("    }\r\n");
      out.write("\r\n");
      out.write("    table{\r\n");
      out.write("        margin-top:100px;\r\n");
      out.write("        margin-left:50px;\r\n");
      out.write("        display: flex;\r\n");
      out.write("        justify-content: center;\r\n");
      out.write("    }\r\n");
      out.write("\r\n");
      out.write("    #loginBtn{\r\n");
      out.write("        background-color: white;\r\n");
      out.write("        border:black 1px solid;\r\n");
      out.write("        font-weight:bold;\r\n");
      out.write("        border-radius: 5px;\r\n");
      out.write("        width:60px;\r\n");
      out.write("        height:35px;\r\n");
      out.write("    }\r\n");
      out.write("\r\n");
      out.write("    #loginBtn:hover{ \r\n");
      out.write("        background-color: rgb(31, 80, 126);\r\n");
      out.write("        color:white;\r\n");
      out.write("    }\r\n");
      out.write("      \r\n");
      out.write("</style>\r\n");
      out.write("<meta charset=\"UTF-8\">\r\n");
      out.write("<title>로그인</title>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write(" ");
      out.write("\r\n");
      out.write(" \r\n");
      out.write(" \r\n");
      out.write(" ");

 	Member loginUser = (Member)session.getAttribute("loginUser");
 	ProfileAttachment at = (ProfileAttachment)session.getAttribute("at");
 	String message = (String)session.getAttribute("msg");
 
      out.write("\r\n");
      out.write("<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\r\n");
      out.write("<title>Fund-ing</title>\r\n");
      out.write("</head>\r\n");
      out.write("<script src=\"https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js\"></script> \r\n");
      out.write("<link href=\"https://fonts.googleapis.com/css2?family=Black+Han+Sans&display=swap\" rel=\"stylesheet\">\r\n");
      out.write("<style>\r\n");
      out.write("body {\r\n");
      out.write("	min-width: 1200px;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".navWrap {\r\n");
      out.write("	width: 100%;\r\n");
      out.write("	height: 50px\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".navWrap>.nav {\r\n");
      out.write("	width: 1200px;\r\n");
      out.write("	margin: auto;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".navWrap>.logo {\r\n");
      out.write("	width: 700px;\r\n");
      out.write("	margin: auto;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".logo {\r\n");
      out.write("	text-align: center;\r\n");
      out.write("	color: rgb(31, 80, 126);\r\n");
      out.write("	font-weight: bold;\r\n");
      out.write("	width: 150px;\r\n");
      out.write("	height: 50px;\r\n");
      out.write("	display: table-cell;\r\n");
      out.write("	font-size: 30px;\r\n");
      out.write("	vertical-align: middle;\r\n");
      out.write("	font-family: 'Black Han Sans';\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".menu {\r\n");
      out.write("	text-align: center;\r\n");
      out.write("	color: black;\r\n");
      out.write("	font-weight: bold;\r\n");
      out.write("	width: 160px;\r\n");
      out.write("	height: 50px;\r\n");
      out.write("	display: table-cell;\r\n");
      out.write("	font-size: 15px;\r\n");
      out.write("	vertical-align: middle;\r\n");
      out.write("	font-family: sans-serif;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".menu:hover {\r\n");
      out.write("	color: blue;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".btn {\r\n");
      out.write("	background-color: white;\r\n");
      out.write("	border: black 1px solid;\r\n");
      out.write("	font-weight: bold;\r\n");
      out.write("	border-radius: 5px;\r\n");
      out.write("	height: 35px;\r\n");
      out.write("	width: 100px;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".btn:hover {\r\n");
      out.write("	background-color: rgb(31, 80, 126);\r\n");
      out.write("	color: white;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".info {\r\n");
      out.write("	float: right;\r\n");
      out.write("	margin-top: 10px;\r\n");
      out.write("	margin-right: 20px;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".userInfo {\r\n");
      out.write("	float: right;\r\n");
      out.write("	margin-top: 10px;\r\n");
      out.write("	margin-right: 10px;\r\n");
      out.write("	text-align: right;\r\n");
      out.write("	width: 150px;\r\n");
      out.write("	height: 40px;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("a:link {\r\n");
      out.write("	color: black;\r\n");
      out.write("	text-decoration: none;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("a:visited {\r\n");
      out.write("	color: black;\r\n");
      out.write("	text-decoration: none;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("a:hover {\r\n");
      out.write("	color: rgb(31, 80, 126);;\r\n");
      out.write("	text-decoration: none;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("#profile {\r\n");
      out.write("	float: right;\r\n");
      out.write("	margin-right: 20px;\r\n");
      out.write("	margin-top: 5px;\r\n");
      out.write("	border-radius: 70%;\r\n");
      out.write("}\r\n");
      out.write("</style>\r\n");
      out.write("<script>\r\n");
      out.write("$(function(){\r\n");
      out.write("    var msg = \"");
      out.print(message);
      out.write("\";\r\n");
      out.write("    \r\n");
      out.write("    if(msg != \"null\"){\r\n");
      out.write("       alert(msg);	\r\n");
      out.write("       \r\n");
      out.write("       ");
session.removeAttribute("msg");
      out.write("\r\n");
      out.write("    }\r\n");
      out.write(" 	});\r\n");
      out.write("</script>\r\n");
      out.write("\r\n");
      out.write("<body>\r\n");
      out.write("	");
 if(loginUser == null){ 
      out.write("\r\n");
      out.write("	<div class=\"navWrap\">\r\n");
      out.write("		<span class=\"nav\">\r\n");
      out.write("			<div class=\"logo\">fund-ing</div>\r\n");
      out.write("			<div class=\"menu\" style=\"width: 100px;\" onclick=\"goMain();\">홈</div>\r\n");
      out.write("			<div class=\"menu\" onclick=\"goProject();\">프로젝트 둘러보기</div>\r\n");
      out.write("			<div class=\"menu\" onclick=\"goProjectUp();\">프로젝트 올리기</div>\r\n");
      out.write("			<div class=\"menu\" style=\"width: 100px;\" onclick=\"goCommunity();\">커뮤니티</div>\r\n");
      out.write("			<div class=\"menu\" style=\"width: 100px;\" onclick=\"goConsumer();\">고객지원</div>\r\n");
      out.write("\r\n");
      out.write("		</span> \r\n");
      out.write("		<span class=\"info\">\r\n");
      out.write("			<button class=\"btn\" onclick=\"login()\">로그인</button>&nbsp;\r\n");
      out.write("			<button class=\"btn\" onclick=\"enroll()\">회원가입</button>\r\n");
      out.write("		</span>\r\n");
      out.write("		<hr style=\"height: 1px; background-color: black;\">\r\n");
      out.write("	</div>\r\n");
      out.write("	");
 }else{
      out.write("\r\n");
      out.write("	\r\n");
      out.write("		");
if(loginUser.getMemNo() == 100) { 
      out.write(" <!-- 관리자 로그인상태라면 -->\r\n");
      out.write("		<div class=\"navWrap\">\r\n");
      out.write("		<span class=\"nav\">\r\n");
      out.write("			<div class=\"logo\">fund-ing</div>\r\n");
      out.write("			<div class=\"menu\" style=\"width: 100px;\" onclick=\"goMain();\">홈</div>\r\n");
      out.write("			<div class=\"menu\" onclick=\"goProject();\">프로젝트 둘러보기</div>\r\n");
      out.write("			<div class=\"menu\" onclick=\"goProjectUp();\">프로젝트 올리기</div>\r\n");
      out.write("			<div class=\"menu\" style=\"width: 100px;\" onclick=\"goCommunity();\">커뮤니티</div>\r\n");
      out.write("			<div class=\"menu\" style=\"width: 100px;\" onclick=\"goConsumer();\">고객지원</div>\r\n");
      out.write("\r\n");
      out.write("		</span> \r\n");
      out.write("		\r\n");
      out.write("		<img id=\"profile\" src=\"");
      out.print(request.getContextPath());
      out.write("/resources/images/default.PNG\" style=\"width:50px; height:50px\"> \r\n");
      out.write("		\r\n");
      out.write("		<span class=\"userInfo\">\r\n");
      out.write("            <a href=\"");
      out.print(request.getContextPath());
      out.write("/memberList.bo\" style=\"font-size:15px; font-weight:bold;\">회원 리스트</a><br>\r\n");
      out.write("            <a href=\"");
      out.print(request.getContextPath());
      out.write("/logout.me\" style=\"font-size:10px; font-weight:bold; color:red;\"> 로그아웃</a>\r\n");
      out.write("        </span>\r\n");
      out.write("		<hr style=\"height: 1px; background-color: black;\">\r\n");
      out.write("		</div>\r\n");
      out.write("		\r\n");
      out.write("		");
} else {
      out.write("\r\n");
      out.write("		\r\n");
      out.write("		<div class=\"navWrap\">\r\n");
      out.write("		<span class=\"nav\">\r\n");
      out.write("			<div class=\"logo\">fund-ing</div>\r\n");
      out.write("			<div class=\"menu\" style=\"width: 100px;\" onclick=\"goMain();\">홈</div>\r\n");
      out.write("			<div class=\"menu\" onclick=\"goProject();\">프로젝트 둘러보기</div>\r\n");
      out.write("			<div class=\"menu\" onclick=\"goProjectUp();\">프로젝트 올리기</div>\r\n");
      out.write("			<div class=\"menu\" style=\"width: 100px;\" onclick=\"goCommunity();\">커뮤니티</div>\r\n");
      out.write("			<div class=\"menu\" style=\"width: 100px;\" onclick=\"goConsumer();\">고객지원</div>\r\n");
      out.write("\r\n");
      out.write("		</span> \r\n");
      out.write("		\r\n");
      out.write("		");
if(at == null){ 
      out.write("\r\n");
      out.write("		<img id=\"profile\" src=\"");
      out.print(request.getContextPath());
      out.write("/resources/images/default.PNG\" style=\"width:50px; height:50px\"> \r\n");
      out.write("		");
} else { 
      out.write("\r\n");
      out.write("		<img id=\"profile\"  src=\"");
      out.print(request.getContextPath() );
      out.write("/resources/upfiles_profile/");
      out.print( at.getChangeName());
      out.write("\" style=\"width:50px; height:50px\"> \r\n");
      out.write("		");
} 
      out.write("\r\n");
      out.write("		\r\n");
      out.write("		 \r\n");
      out.write("		<span class=\"userInfo\">\r\n");
      out.write("            <a href=\"\" style=\"font-size:15px; font-weight:bold;\">");
      out.print( loginUser.getMemName() );
      out.write("</a><br>\r\n");
      out.write("            <a href=\"");
      out.print(request.getContextPath());
      out.write("/logout.me\" style=\"font-size:10px; font-weight:bold; color:red;\"> 로그아웃</a>\r\n");
      out.write("        </span>\r\n");
      out.write("		<hr style=\"height: 1px; background-color: black;\">\r\n");
      out.write("		</div>\r\n");
      out.write("	\r\n");
      out.write("	");
 } 
      out.write('\r');
      out.write('\n');
      out.write('	');
} 
      out.write("\r\n");
      out.write("	\r\n");
      out.write("	<script>\r\n");
      out.write("        function goMain(){ \r\n");
      out.write("            location.href=\"");
      out.print(request.getContextPath());
      out.write("\";\r\n");
      out.write("        }\r\n");
      out.write("    \r\n");
      out.write("        function goProject(){ //프로젝트 둘러보기\r\n");
      out.write("            location.href=\"");
      out.print(request.getContextPath());
      out.write("/\";\r\n");
      out.write("		\r\n");
      out.write("		}\r\n");
      out.write("\r\n");
      out.write("		function goProjectUp() { //프로젝트 올리기\r\n");
      out.write("			location.href = \"");
      out.print(request.getContextPath());
      out.write("/\";\r\n");
      out.write("\r\n");
      out.write("        }\r\n");
      out.write("        \r\n");
      out.write("        function goCommunity(){ // 커뮤니티\r\n");
      out.write("            location.href=\"");
      out.print(request.getContextPath());
      out.write("/\";\r\n");
      out.write("        }\r\n");
      out.write("\r\n");
      out.write("        function goConsumer(){ //고객지원\r\n");
      out.write("            location.href=\"");
      out.print(request.getContextPath());
      out.write("/\";\r\n");
      out.write("        }\r\n");
      out.write("    \r\n");
      out.write("        function login(){ //로그인\r\n");
      out.write("        		 location.href=\"");
      out.print(request.getContextPath());
      out.write("/loginform.me\"\r\n");
      out.write("        }\r\n");
      out.write("\r\n");
      out.write("        function enroll(){//회원가입\r\n");
      out.write("        	  location.href=\"");
      out.print( request.getContextPath());
      out.write("/enrollForm.me\";\r\n");
      out.write("        }\r\n");
      out.write("\r\n");
      out.write("    \r\n");
      out.write("    </script>\r\n");
      out.write("</body>\r\n");
      out.write("</html>");
      out.write("\r\n");
      out.write("  		<div id=\"title\">\r\n");
      out.write("            <h1 style=\"margin-bottom:0px;\">login</h1>\r\n");
      out.write("        </div>\r\n");
      out.write("        \r\n");
      out.write("        <div id=\"login\">\r\n");
      out.write("            <div id=\"loginBox\">\r\n");
      out.write("            <form id=\"loginForm\" action=\"");
      out.print(request.getContextPath());
      out.write("/login.me\" method=\"post\" onsubmit=\"return loginValidate();\">\r\n");
      out.write("                <table>\r\n");
      out.write("                    <tr>\r\n");
      out.write("                        <th><input id=\"userId\" type=\"text\" name=\"userId\" placeholder=\"ID\"></th>\r\n");
      out.write("                        <th></th>\r\n");
      out.write("                    </tr>\r\n");
      out.write("                    \r\n");
      out.write("                    <tr>\r\n");
      out.write("                        <th><input id=\"userPwd\" type=\"password\" name=\"userPwd\" placeholder=\"PASSWORD\"></th> &nbsp;\r\n");
      out.write("                        <th><button id=\"loginBtn\" type=\"submit\">로그인</button></th>\r\n");
      out.write("                    </tr>\r\n");
      out.write("                    \r\n");
      out.write("                    <tr>\r\n");
      out.write("                        <td style=\"height:60px\"><a href=\"#\" onclick=\"findId();\">아이디 찾기</a> | <a href=\"#\" onclick=\"findPwd();\">비밀번호 찾기</a></td>\r\n");
      out.write("                        <th></th>\r\n");
      out.write("                     </tr>\r\n");
      out.write("                </table>\r\n");
      out.write("                <script>\r\n");
      out.write("                \r\n");
      out.write("                var popHeight = 430;     // 띄울 팝업창 높이                                    \r\n");
      out.write("                var popWidth = 600;     // 띄울 팝업창 너비                                  \r\n");
      out.write("\r\n");
      out.write("                var winHeight = document.body.clientHeight;	  // 현재창의 높이\r\n");
      out.write("                var winWidth = document.body.clientWidth;	  // 현재창의 너비\r\n");
      out.write("\r\n");
      out.write("                var winX = window.screenLeft;	// 현재창의 x좌표\r\n");
      out.write("                var winY = window.screenTop;	// 현재창의 y좌표\r\n");
      out.write("                	\r\n");
      out.write("                var popX = winX + (winWidth - popWidth)/2;\r\n");
      out.write("                var popY = winY + (winHeight - popHeight)/2;\r\n");
      out.write("                \r\n");
      out.write("                	function findId(){\r\n");
      out.write("                		window.open(\"");
      out.print(request.getContextPath());
      out.write("/findIdForm.me\", \"아이디 찾기\",  \"top=\"+popY+\", left=\"+popX+\",width=\"+popWidth+\",height=\"+popHeight+\", scrollbars=yes,resizable=yes\");\r\n");
      out.write("                	}\r\n");
      out.write("                	\r\n");
      out.write("                	function findPwd() {\r\n");
      out.write("                		window.open(\"");
      out.print(request.getContextPath());
      out.write("/findPwdForm.me\", \"비밀번호 찾기\", \"top=\"+popY+\", left=\"+popX+\",width=\"+popWidth+\",height=\"+popHeight+\", scrollbars=yes,resizable=yes\");\r\n");
      out.write("                	}\r\n");
      out.write("                	\r\n");
      out.write("                </script>\r\n");
      out.write("            </form> \r\n");
      out.write("            </div>      \r\n");
      out.write("        </div>\r\n");
      out.write("        ");
      out.write("\r\n");
      out.write("<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\r\n");
      out.write("<title>Insert title here</title>\r\n");
      out.write("</head>\r\n");
      out.write("<style>\r\n");
      out.write("    body{\r\n");
      out.write("        min-width:1200px;\r\n");
      out.write("    }\r\n");
      out.write("    #footer{\r\n");
      out.write("        width:100%;\r\n");
      out.write("        height:200px;\r\n");
      out.write("        background-color: lightgray;\r\n");
      out.write("    }\r\n");
      out.write("    #footer-content{\r\n");
      out.write("        width:80%;\r\n");
      out.write("        height:200px;\r\n");
      out.write("        margin:auto;\r\n");
      out.write("        padding-top:50px;\r\n");
      out.write("    }\r\n");
      out.write("    #footer-1{\r\n");
      out.write("        font: 20px bolder;\r\n");
      out.write("    }\r\n");
      out.write("    #footer-2{\r\n");
      out.write("        font: 5px bolder;\r\n");
      out.write("       \r\n");
      out.write("    }\r\n");
      out.write("</style>\r\n");
      out.write("<body>\r\n");
      out.write("	<div id=\"footer\">\r\n");
      out.write("   \r\n");
      out.write("    <div id=\"footer-content\">\r\n");
      out.write("        <div id=\"footer-1\">\r\n");
      out.write("            skyline\r\n");
      out.write("        </div><br>\r\n");
      out.write("\r\n");
      out.write("        <div id=\"footer-2\">\r\n");
      out.write("            <p id=\"p1\">\r\n");
      out.write("                <label style=\"color:gray;\">회사명</label> 국민체조  | <label style=\"color:gray;\">주소</label> 서울시 강남구 역삼동 KH\r\n");
      out.write("            </p>\r\n");
      out.write("            <p id=\"p2\">\r\n");
      out.write("                <label style=\"color:gray;\">대표번호</label> 02-0000-0000 | <label style=\"color:gray;\">운영시간</label> 9:00~18:00 (주말, 공휴일 제외)\r\n");
      out.write("            </p>\r\n");
      out.write("        </div>\r\n");
      out.write("    </div>\r\n");
      out.write("</div>\r\n");
      out.write("</body>\r\n");
      out.write("</html>");
      out.write("\r\n");
      out.write("</body>\r\n");
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
}
