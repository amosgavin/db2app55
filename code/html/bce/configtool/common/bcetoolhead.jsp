<% response.setHeader("Cache-Control", "no-cache"); %>
<%@ taglib uri="/WEB-INF/appframe2.tld" prefix="ai" %>
<%@ taglib uri="/WEB-INF/appframe-i18n.tld" prefix="i18n" %>
<%@ page import="com.ai.appframe2.common.SessionManager"%>
<%@page import="com.ai.bce.util.LocaleResourceFactory"%>
<script src="<%=request.getContextPath()%>/jsv2/i18n/AILocale.jsp"></script>
<script language="JavaScript" src="<%=request.getContextPath()%>/jsv2/i18n/appframe_js_resource_<%=com.ai.appframe2.util.locale.AppframeLocaleFactory.getCurrentLocale().toString() %>.js"></script>
<script src="<%=request.getContextPath()%>/jsv2/Globe_v2.jsp"></script>
<script src="<%=request.getContextPath()%>/crm/common/CrmJsResource.jsp?v=<%=com.ai.common.util.WebUtil.getJsVersion()%>"></script>

<!-- 平台组件标准样式 -->

<link rel="stylesheet" href="<%=request.getContextPath()%>/bce/configtool/common/css/BceToolCss.jsp" type="text/css">
<link rel="stylesheet" href="<%=request.getContextPath()%>/webframe/common/AIFrameDBCSS_css.jsp" type="text/css">
 
<!-- 平台组件个性化样式 -->
<!-- 
<script src="<%=request.getContextPath()%>/webframe/common/cookie.jsp"></script>
<link rel="stylesheet" href="<%=request.getContextPath()%>/webframe/common/main.css" type="text/css">
<link id="theme_css_id" rel="stylesheet" type="text/css">

<script language="javascript">
document.onload = setupFontSize();
document.onload = setup();
</script>
 -->