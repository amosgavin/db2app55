<%--<html>
/************************************************
  Copyright by asiaifo, 2004-05-25
  Created Date:       2004-05-25
  Project Name:       AIAppFrame2
  Module Name:        WebFrame
  Author:             zhongrui
  Version:            2	<link rel="stylesheet" href="<%=request.getContextPath()% >/webframe/css/AIFrameDBCSS_css.jsp" type="text/css">
************************************************/
--%>
<%@ page import="com.ai.appframe2.common.SessionManager"%>
<%
response.setHeader("Pragma","No-cache");
response.setHeader("Cache-Control","no-cache");
response.setDateHeader("Expires", 0);

%>
<%@ taglib uri="/WEB-INF/appframe2.tld" prefix="ai" %>
<%
 SessionManager.setContextName(request.getContextPath());
 SessionManager.setRequest(request);
%>

<link rel="stylesheet" href="<%=request.getContextPath()%>/jsv2/AppFrameCss.jsp" type="text/css">
<link rel="stylesheet" href="<%=request.getContextPath()%>/webframe/css/AIFrameDBCSS_css.jsp" type="text/css">
<script language="JavaScript" src="<%=request.getContextPath()%>/webframe/framehidden.js"></script>
