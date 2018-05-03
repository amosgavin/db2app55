<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%@ page import="com.asiainfo.task.web.AssignTaskAction"%>
<%
String path = request.getContextPath();
String url = AssignTaskAction.forward(request,response);
String templateTag = request.getParameter("templateTag");
String taskTag = request.getParameter("taskTag");
String recordId = request.getParameter("recordId");
String recordType = request.getParameter("recordType");
request.getRequestDispatcher(url).forward(request,response);
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
  </head>
  <body>
  </body>
</html>
