<%@ page import="com.ai.appframe2.common.SessionManager" %>
<%@ page import="com.ai.appframe2.privilege.UserInfoInterface" %>
<%@ page import="com.asiainfo.bass.components.models.DES" %>
<%@ page contentType="text/html; charset=GBK"%>
<%
  String path = request.getContextPath();
  UserInfoInterface user = SessionManager.getUser();
  String staffCode = user.getCode();
  String access_user_id = DES.encode(staffCode);
  String sid = (String)request.getParameter("sid");
  if(sid!=null){
	  response.sendRedirect("http://10.25.124.29/mvc/report/"+sid+"?access_user_id="+access_user_id);
           //response.sendRedirect("http://10.25.124.112:8088/pst/report/conf");//ÕýÊ½
  }

 %>