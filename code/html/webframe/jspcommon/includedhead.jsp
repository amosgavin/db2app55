<%--<html>
/************************************************
  Copyright by asiaifo, 2004-05-25
  Created Date:       2004-05-25
  Project Name:       AIAppFrame2
  Module Name:        WebFrame
  Author:             zhongrui
  Version:            2
************************************************/
--%>
<%@ include file="commonhead.jsp"%>
<%@ page language="java"%>
<%@ page import="java.sql.*" %>
<%@ page import="java.io.*" %>
<%@ page import="java.util.*" %>
<%@ page import="com.ai.appframe2.web.*"%>
<%@ page import="com.ai.appframe2.common.SessionManager"%>
<%@ page import="com.ai.appframe2.privilege.*"%>



<%!
//??????????????????????begin
public UserInfoInterface g_GetUserInfo()
{
  return SessionManager.getUser();
}
//??????????????????????end
%>


<%
String g_ServerPort = request.getServerPort()+"";
if ("80".equals(g_ServerPort))
{
  g_ServerPort = "";
}
else
{
  g_ServerPort = ":"+g_ServerPort;
}

String  g_RootPath = "";//    "http://"+request.getServerName()+g_ServerPort+request.getContextPath();
String  g_LoginPageName = BaseServer.getLoginHTML();
String  g_LogoutPageName = BaseServer.getLogoutHTML();
UserInfoInterface global_UserInfo = null;
try
{
  global_UserInfo = BaseServer.getCurUser(request);
}
catch(Exception ex)
{
  out.println("<B>[ERROR]includedhead.jsp. getUserInfo Error.ex:"+ex.getMessage()+"</B>");
  return;
}
SessionManager.setUser(global_UserInfo);

%>
