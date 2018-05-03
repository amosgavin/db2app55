<%@ page contentType="text/html; charset=GBK"%>
<%@ include file="/bce/configtool/common/bcetoolhead.jsp"%>
<%@ page import="com.ai.appframe2.web.HttpUtil"%>


<%
	
	//Êý¾Ý¼¯ID
	String curRowsetId = HttpUtil.getAsString(request ,"ROWSET_ID"); 
	String initial ="false";
	
	if(curRowsetId != null && !"".equals(curRowsetId))
	{
		request.setAttribute("rowsetId",curRowsetId);
		initial = "true";
	}
%>
<html>
<head>
<title>
</title>
</head>
<body>
<ai:table tableid="pageDBTable" setname="com.ai.bce.web.SETBceRowsetPage" needrefresh="true"
		   		tablemodel="com.ai.appframe2.web.datamodel.MethodModelForService" conditionname="condition"
		   		implservice_name = "com.ai.bce.configtool.service.interfaces.IConfPageSV"
		   		implservice_querymethod = "getRelatePagesByRowsetId(long rowsetId,int $STARTROWINDEX,int $ENDROWINDEX)"
		   		implservice_countmethod="getRelatePageCountByRowsetId(long rowsetId)" 				
		   		initial="<%=initial %>" height="220" width="100%" editable="false" multiselect="false"
				footdisplay="block" pagesize="10" rowsequence="true"  >
		   		<ai:col fieldname="PAGE_ID" width="8%"/>
		   		<ai:col fieldname="MODULE_ID" width="8%"/>
				<ai:col fieldname="PAGE_TYPE" width="10%"/>	
				<ai:col fieldname="PAGE_URL" width="25%"/>					
				<ai:col fieldname="IS_GET_PAGE_DATA" width="15%"/>
				<ai:col fieldname="IS_DATA_MUST" width="15%"/>
				<ai:col fieldname="PAGE_RULESET_ID" width="8%"/>
				<ai:col fieldname="PAGE_LOAD_TYPE" width="10%"/>
				<ai:col fieldname="STATE" width="5%"/>
				<ai:col fieldname="REMARKS" width="10%"/>
	   		</ai:table>	 
</body> 
</html>


