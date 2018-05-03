<%@ page import="com.ai.appframe2.common.SessionManager" %>  
<%@ page import="com.ai.appframe2.privilege.UserInfoInterface" %>  
<%@ page import="com.asiainfo.common.DES" %>  
<%@ page import="java.text.SimpleDateFormat" %> 
<%@ page import="java.util.Date" %> 
<%@ page contentType="text/html; charset=GBK"%>
<%
  String path = request.getContextPath();
  UserInfoInterface user = SessionManager.getUser();
  String staffCode = DES.encrypt(user.getCode());
  SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
  String time=DES.encrypt(df.format(new Date()));
  String url = "http://localhost:7080/mmp/loginNEW.jsp?userId="+staffCode+"&time="+time;//²âÊÔ
  //String url = "http://10.25.124.115:8084/mmp/login.jsp?userId="+staffCode+"&ailk_autoLogin_userId="+staffCode;//ÕýÊ½
  response.sendRedirect(url);
 %>