<%@page import="org.apache.commons.lang.StringUtils"%>
<%@page import="com.ai.appframe2.web.HttpUtil"%>
<%@page import="java.io.File"%>
<%@page import="java.io.FileInputStream"%>
<%@page import="org.apache.commons.io.FileUtils"%>
<% response.setHeader("Cache-Control", "no-cache"); %>
<%@ taglib uri="/WEB-INF/appframe2.tld" prefix="ai" %>
<%@ taglib uri="/WEB-INF/appframe-i18n.tld" prefix="i18n" %>
<%@ page contentType="text/html; charset=GBK"%>
<%@ include file="/bce/configtool/common/bcetoolhead.jsp"%>
<html>
<%
	String fileType = HttpUtil.getParameter(request, "fileType");
	String filePath = HttpUtil.getParameter(request, "filePath");
	String content = "";
	if(StringUtils.isNotBlank(fileType) && StringUtils.isNotEmpty(filePath)){
		content = FileUtils.readFileToString(new File(filePath), null);
	}else{
		content = "NULL";
	}

	String clsName = "xml";
	if("JSP".equals(fileType)){
		clsName = "xml";
	}else if("WVM".equals(fileType)){
		clsName = "xml";
	}else if("JS".equals(fileType)){
		clsName = "js";
	}

%>
<head>
<script type="text/javascript">
var fileType = "<%=fileType%>";

if(fileType == "JSP" || fileType == "JS"){
	window.onerror = function(msg, url, line){
		//alert("³ö´íÀ²");
		return true;
	}
}
</script>
<title>test</title>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
<script src="<%=request.getContextPath()%>/jsv2/UserData_v2.js"></script>
<script src="<%=request.getContextPath()%>/jsv2/Globe_v2.jsp"></script>
<script type="text/javascript" src="SyntaxHighliter/scripts/shCore.js"></script>
<script type="text/javascript" src="SyntaxHighliter/scripts/shBrushJScript.js"></script>
<script type="text/javascript" src="SyntaxHighliter/scripts/shBrushJava.js"></script>
<script type="text/javascript" src="SyntaxHighliter/scripts/shBrushXml.js"></script>
<link type="text/css" rel="stylesheet" href="SyntaxHighliter/styles/shCoreDefault.css"/>
<script type="text/javascript">SyntaxHighlighter.all();</script>
</head>
<body>
<pre class="brush:<%=clsName%>;gutter:false:toolbar:false;width:500" id="srcArea">
<%=content %>
</pre>
</body>
</html>