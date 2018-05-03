<script language="JavaScript" src="<%=request.getContextPath()%>/jsv2/i18n/secframe_js_resource_<%=com.ai.appframe2.util.locale.AppframeLocaleFactory.getCurrentLocale().toString()%>.js"></script>
<script language="JavaScript" src="<%=request.getContextPath()%>/secframe/common/common.js"/></script>
<%@ page import="com.ai.appframe2.common.SessionManager"%>
<%

  if(SessionManager.getUser()==null){
  return;
  }

%>


