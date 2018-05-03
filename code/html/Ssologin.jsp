<%@ page contentType="text/html; charset=GBK"%>
<%@ page import="org.apache.commons.lang.StringUtils,com.ai.appframe2.web.*,com.ai.appframe2.privilege.*,com.ai.appframe2.complex.util.*,com.ai.appframe2.common.*"%>
<%
String path = request.getContextPath();
String token = request.getParameter("Token");
String usrid = token.split("@")[1];
request.getSession().setAttribute("Token0",token.split("@")[0]);

String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";

//String usrid = request.getParameter("USERID");

    String logUsr = usrid ;
    String logPass = "111";
    String verifyCode = "111";
    long CHANNEL_ID = -1L;


    long channelId = CHANNEL_ID;
    String s = "1";
    if (!(StringUtils.isBlank(s)))
      channelId = Long.parseLong(s);

    CustomProperty cp = CustomProperty.getInstance();
    cp.clear();
    try
    {
      Cookie c;
      String session_vertify_code = (String)request.getSession().getAttribute("VERTIFY_CODE_ATTR");

      if ((session_vertify_code != null) && (!(verifyCode.equals(session_vertify_code))))
      {
        throw new LoginException(15);
      }

      int curTime = UserManagerFactory.getUserManager().getFaultTime(request.getSession().getId());

      UserInfoInterface user = UserManagerFactory.getUserManager().loginIn(logUsr, logPass, channelId, curTime, request);

      if (user == null)
        throw new LoginException(2);

      UserManagerFactory.getUserManager().setLogined(user);

      UserManagerFactory.getUserManager().clearFaultTime(request.getSession().getId());

      //user.setIP(getIpAddr(request));
      user.setSessionID(request.getSession().getId());

      request.getSession().setAttribute("USERINFO_ATTR", user.getSerialID());
      try
      {
        c = new Cookie("USERINFO_ATTR", user.getSerialID());
        c.setMaxAge(-1);
        response.addCookie(c);
      }
      catch (Exception e) {
       // log.error(AppframeLocaleFactory.getResource("com.ai.appframe2.web.BaseServer.set_cookie_error"), e);
      }

      if (!(StringUtils.isBlank(RuntimeServerUtil.getServerName())))
        try {
          //e = new Cookie("_BelongedSrvId", RuntimeServerUtil.getServerName());
         // e.setMaxAge(-1);
         // response.addCookie(e);
        }
        catch (Exception e)
        {
          //log.error(AppframeLocaleFactory.getResource("com.ai.appframe2.web.BaseServer.set_cookie_error"), e);
          System.out.println(e.getMessage());
        }


      user.setDomainId(channelId);

      SessionManager.setUser(user);

      String login_success_msg = (String)request.getAttribute("MESSAGE");
      if (login_success_msg != null) {
        cp.set("SUCCESS_MESSAGE", login_success_msg);
      }

      cp.set("LOGIN_FLAG", "Y");
      cp.set("MESSAGE", "");
    }
    catch (LoginException ex)
    {
      UserManagerFactory.getUserManager().addFaultTime(request.getSession().getId());

      cp.set("LOGIN_FLAG", "N");
      cp.set("MESSAGE", ex.getErrorInfo());
    }
    finally {
     response.sendRedirect(basePath+"webframe/index.jsp");
    }
  

%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'Ssologin.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
    This is my JSP page. <br>
  </body>
</html>
