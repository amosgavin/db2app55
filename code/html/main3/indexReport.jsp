<%@ page import="com.ai.appframe2.common.SessionManager" %>
<%@ page import="com.ai.appframe2.privilege.UserInfoInterface" %>
<%@ page contentType="text/html; charset=GBK"%>
<%
  String path = request.getContextPath();
  UserInfoInterface user = SessionManager.getUser();
  /*
  String staffCode = DES.encrypt(user.getCode());
  //String url = "http://10.25.125.12:808/mmp/login.jsp?userId="+staffCode+"&ailk_autoLogin_userId="+staffCode;//测试
  String url = "http://10.25.124.115:8084/mmp/login.jsp?userId="+staffCode+"&ailk_autoLogin_userId="+staffCode;//正式
  response.sendRedirect(url);*/
 String sid = (String)request.getParameter("sid");
 // response.sendRedirect("http://localhost:8081/pst/index.jsp?sid="+sid);//测试
  if(sid==null){
           response.sendRedirect("http://10.25.124.112:8088/pst/report/conf");//正式
  }else{
          response.sendRedirect("http://10.25.124.112:8088/pst/report/"+sid);//测试
  }

 %>