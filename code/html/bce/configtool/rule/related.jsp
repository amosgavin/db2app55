<%@ page contentType="text/html; charset=GBK"%>
<%@ include file="/bce/configtool/common/bcetoolhead.jsp"%>
<%@ page import="com.ai.appframe2.web.HttpUtil"%>

<%
	
	//¹æÔòID
	String curRuleId = HttpUtil.getAsString(request ,"RULE_ID"); 
	String initial ="false";
	
	if(curRuleId != null && !"".equals(curRuleId))
	{
		request.setAttribute("ruleId",curRuleId);
		initial = "true";
	}
%>
<html>
<head>
<title>
</title>
</head>
<body>
 <ai:table tableid="rulesetDBTable"
					setname="com.ai.bce.web.BceRuleset" needrefresh="true"
					tablemodel="com.ai.appframe2.web.datamodel.MethodModelForService"
					implservice_name="com.ai.bce.configtool.service.interfaces.IConfRuleSV"
					implservice_querymethod="getRelateRulesetsByRuleId(long ruleId, int $STARTROWINDEX,int $ENDROWINDEX)"
					implservice_countmethod="getRelateRulesetCount(long ruleId)" 
					initial="<%=initial %>"  height="220" width="100%" editable="false"
					multiselect="false" footdisplay="block" pagesize="10"
					rowsequence="true"  >
					<ai:col fieldname="RULESET_ID" width="20%"/>
					<ai:col fieldname="MODULE_ID" width="20%"/>
					<ai:col fieldname="STATE" width="20%"/>
					<ai:col fieldname="REMARKS"  width="40%"/>
				</ai:table> 
</body> 
</html>
