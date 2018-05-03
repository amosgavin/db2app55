<%@ page import="com.ai.appframe2.common.SessionManager" %>  
<%@ page import="com.ai.appframe2.privilege.UserInfoInterface" %>  
<%@ page contentType="text/html; charset=GBK"%>
<meta http-equiv="refresh" content="10" />
<script language="javascript">
<%
  String path = request.getContextPath();
  UserInfoInterface user = SessionManager.getUser();
  if (null == user){
	  out.write("alert('您的登录已超时, 请点确定后重新登录!');");
	  out.write("window.top.location.href='"+request.getContextPath()+"/index.jsp';");
  }
 %>
</script>

