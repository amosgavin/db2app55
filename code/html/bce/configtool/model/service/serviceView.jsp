<%@page import="com.ai.appframe2.web.HttpUtil"%>
<% response.setHeader("Cache-Control", "no-cache"); %>
<%@ taglib uri="/WEB-INF/appframe2.tld" prefix="ai" %>
<%@ taglib uri="/WEB-INF/appframe-i18n.tld" prefix="i18n" %>
<%@ page contentType="text/html; charset=GBK"%>
<%@ include file="/bce/configtool/common/bcetoolhead.jsp"%>
<html>
<%
	String filePath = HttpUtil.getParameter(request, "filePath");
%>
<head>
<title><%=LocaleResourceFactory.getResource("BES0000611")%> Service</title>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
<script src="<%=request.getContextPath()%>/jsv2/Globe_v2.jsp"></script>
</head>
<body>
	<ai:table tableid="methodDBTable"
		setname="com.ai.bce.web.BOListItem" needrefresh="true"
		tablemodel="com.ai.appframe2.web.datamodel.MethodModelForService"
		implservice_name="com.ai.bce.configtool.service.interfaces.IConfServiceSV"
		implservice_querymethod="getJavaMethodValues(String cond)"
		initial="true" height="400" width="100%" editable="false"
		multiselect="false" footdisplay="none" pagesize="19"
		rowsequence="true" onrowchange="" ondbclick="">
		<ai:col fieldname="ITEM1" title="BES0000812" i18nRes="CRM" width="100%"/>
		<ai:col fieldname="ITEM2" visible="false"/>
	</ai:table>
</body>
<script type="text/javascript">
var filePath = "<%=filePath%>";

function getDBTable(){
	return g_TableRowSetManager.get("methodDBTable");
}

function refresh(filePath){
	getDBTable().refresh("cond=" + filePath);
}

function getValue(){
	var row = getDBTable().getRow();
	if(row >=0){
		return getDBTable().getValue(row, "ITEM2");
	}else{
		return null;
	}
}
</script>
</html>