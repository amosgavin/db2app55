<%@ page import="com.ai.appframe2.common.SessionManager" %>
<%@ page import="com.ai.appframe2.privilege.UserInfoInterface" %>
<%@ page contentType="text/html; charset=GBK"%>
<%
  UserInfoInterface user = SessionManager.getUser();
  String staffCode = user.getCode();
  String url = "http://10.25.125.12:808/jeecms/loginDb2app55.jspx?usercode="+staffCode+"&password=111&returnUrl=/";
  //String url = "http://localhost:8081/jeecms/loginDb2app55.jspx?usercode="+staffCode+"&password=111&returnUrl=/";//²âÊÔ
  response.sendRedirect(url);
 %>

