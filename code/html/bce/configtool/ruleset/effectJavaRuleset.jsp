<%@ page contentType="text/html; charset=GBK"%>
<%@ include file="/bce/configtool/common/bcetoolhead.jsp"%>
<%@page import="com.ai.appframe2.web.HttpUtil"%>
<html>
<%
	String rulesetId = request.getParameter("rulesetId");
	if (null == rulesetId || "".equals(rulesetId)) {
		rulesetId = "-1";
	}
	String cond = "RULESET_ID="+rulesetId;
	
	String moduleId = HttpUtil.getAsString(request,"module_id");
	if(moduleId !=null && !"".equals(moduleId)){
		cond = cond + " and (MODULE_ID="+moduleId + " or module_id='0' or module_id is null)";
	}
	
	request.setAttribute("cond",cond);
%>
<head>
</head>
<body  >
	<ai:table tableid="javarulesetrelDBTable"
		setname="com.ai.bce.web.BceFrameJavaRulesetRel" needrefresh="true"
		tablemodel="com.ai.appframe2.web.datamodel.MethodModelForService"
		implservice_name="com.ai.bce.configtool.service.interfaces.IConfJavaRuleSV"		
		implservice_querymethod="getJavaRulesetByCond(String cond,int $STARTROWINDEX,int $ENDROWINDEX)"
		implservice_countmethod="getJavaRulesetByCondCount(String cond)"
		initial="true" height="220" width="100%" editable="false"
		multiselect="false" footdisplay="block" pagesize="10"
		rowsequence="true" onrowchange="dbclick" ondbclick="dbclick">
		<ai:col fieldname="RELATE_ID" width="10%"/>
		<ai:col fieldname="BCE_FRAME_ID" width="10%"/>
		<ai:col fieldname="CHECK_TYPE" width="10%"/>
		<ai:col fieldname="PARAM_DATA" width="10%"/>					
		<ai:col fieldname="REMARKS" width="30%"/>
		<ai:col fieldname="RULESET_ID" width="10%"/>
		<ai:col fieldname="RULESET_TYPE" width="15%"/>
		<ai:col fieldname="STATE" width="10%"/>
	</ai:table>
</body>
<script type="text/javascript">
function test(){
	var result = PostInfo("<%=request.getContextPath()%>/business/linz.MyAction?action=test");
	alert(result);
}

 
function dbclick(){
	
}
</script>
</html>