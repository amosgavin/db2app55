<%@ page contentType="text/html; charset=GBK"%>
<%@ page import="com.ai.appframe2.web.BaseServer"%>
<%@ include file="/secframe/common/getMACIP.html"%>
  <%
  String path = request.getContextPath();
  String url = "SsologinBi.jsp?usrid="+"luming";
  response.sendRedirect(url);  
  %>  
