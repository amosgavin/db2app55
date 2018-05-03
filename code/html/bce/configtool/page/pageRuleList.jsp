<%@ page contentType="text/html; charset=GBK"%>
<%@ include file="/bce/configtool/common/bcetoolhead.jsp"%>
<%@ page import="com.ai.appframe2.web.HttpUtil"%>


<%
	
	//Ò³ÃæID
	String curPageId = HttpUtil.getAsString(request ,"PAGE_ID"); 
	String initial ="false";
	
	if(curPageId != null && !"".equals(curPageId))
	{
		request.setAttribute("pageId",curPageId);
		initial = "true";
	}
%>
<html>
<head>
<title> 
</title>
</head>
<body>

	  			<ai:table tableid="ruleDBTable" setname="com.ai.bce.web.SETBcePageRulesetRule" needrefresh="true"
	   				tablemodel="com.ai.appframe2.web.datamodel.MethodModelForService" 
	   				implservice_name = "com.ai.bce.configtool.service.interfaces.IConfPageSV"
	   				implservice_querymethod = "getRelateRulesByPageId(long pageId,int $STARTROWINDEX,int $ENDROWINDEX )"
	   				implservice_countmethod="getRelateRuleCountByPageId(long pageId)"	
	   				initial="<%=initial %>" height="160" width="100%" editable="false" multiselect="false"
					footdisplay="block" pagesize="100" rowsequence="true" >
  					<ai:col fieldname="RULE_ID" />
					<ai:col fieldname="RULE_NAME" width="200"/>
					<ai:col fieldname="RULE_TRIGGER_TYPE" width="100"/>
			        <ai:col fieldname="OBJ_NAME" width="100"/>
			        <ai:col fieldname="EVENT_NAME" width="100"/>
					<ai:col fieldname="MODULE_ID" />
					<ai:col fieldname="RULE_KIND" />
					<ai:col fieldname="RULE_TYPE" />
					<ai:col fieldname="FILE_NAME" width="360"/>	
					<ai:col fieldname="FUNC_NAME" width="200"/>					
					<ai:col fieldname="PARAM_LIST" width="230"/>
			        <ai:col fieldname="PARAM_VALUE_LIST" width="150"/>
					<ai:col fieldname="STATE"/>
					<ai:col fieldname="REMARKS" width="200"/>
  				</ai:table> 
</body> 
</html>


