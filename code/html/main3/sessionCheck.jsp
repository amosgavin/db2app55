<%@ page import="com.ai.appframe2.common.SessionManager" %>  
<%@ page import="com.ai.appframe2.privilege.UserInfoInterface" %>  
<%@ page contentType="text/html; charset=GBK"%>
<meta http-equiv="refresh" content="10" />
<script language="javascript">
<%
  String path = request.getContextPath();
  UserInfoInterface user = SessionManager.getUser();
  if (null == user){
	  out.write("alert('���ĵ�¼�ѳ�ʱ, ���ȷ�������µ�¼!');");
	  out.write("window.top.location.href='"+request.getContextPath()+"/index.jsp';");
  }
 %>
</script>

