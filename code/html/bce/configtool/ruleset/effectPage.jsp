<%@ page contentType="text/html; charset=GBK"%>
<%@ include file="/bce/configtool/common/bcetoolhead.jsp"%>
<html>
<%
	String rulesetId = request.getParameter("rulesetId");
	if (null == rulesetId || "".equals(rulesetId)) {
		rulesetId = "-1";
	}
	
	request.setAttribute("cond","PAGE_RULESET_ID='"+rulesetId +"'");
%>
<head>
</head>
<body  >
		<ai:table tableid="pageDBTable" setname="com.ai.bce.web.BcePage" needrefresh="true"
			tablemodel="com.ai.appframe2.web.datamodel.MethodModelForService" conditionname="condition"
		 	implservice_name = "com.ai.bce.configtool.service.interfaces.IConfPageSV"
			implservice_querymethod = "getBcePageValues(String cond, int $STARTROWINDEX, int $ENDROWINDEX)" 
			implservice_countmethod="getBcePageCount(String cond)"  			
			initial="true" height="220" width="100%" editable="false" multiselect="false"
			footdisplay="block" pagesize="10" rowsequence="true" onrowchange="showDetailInfo"
			ondbclick="showDetailInfo">
			<ai:col fieldname="PAGE_ID" width="100"/>
			<ai:col fieldname="MODULE_ID" width="100"/>
			<ai:col fieldname="PAGE_TYPE" width="150"/>	
			<ai:col fieldname="PAGE_URL" width="300"/>					
			<ai:col fieldname="IS_GET_PAGE_DATA" width="100"/>
			<ai:col fieldname="IS_DATA_MUST" width="150"/>
			<ai:col fieldname="PAGE_RULESET_ID" width="100"/>
			<ai:col fieldname="PAGE_LOAD_TYPE" width="200"/>
			<ai:col fieldname="STATE" width=""/>
			<ai:col fieldname="REMARKS" width="200"/>			
		</ai:table>	
</body>
<script type="text/javascript">
function test(){
	var result = PostInfo("<%=request.getContextPath()%>/business/linz.MyAction?action=test");
	alert(result);
}

 

function showDetailInfo(){
	
}
</script>
</html>