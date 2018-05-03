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
 <ai:table tableid="rowsetDBTable" setname="com.ai.bce.web.SETBcePageRelRowset" needrefresh="true"
			   		tablemodel="com.ai.appframe2.web.datamodel.MethodModelForService" conditionname="condition"
			   		implservice_name="com.ai.bce.configtool.service.interfaces.IConfPageSV"
			   		implservice_querymethod="getRelateRowsetsByPageId(long pageId,int $STARTROWINDEX,int $ENDROWINDEX)" 
			   		implservice_countmethod="getRelateRowsetCountByPageId(long pageId)"	multiselect="false"
			   		initial="<%=initial %>" height="220" width="100%" editable="false" footdisplay="true" 
					pagesize="10" rowsequence="false"  >
					
		   			<ai:col fieldname="ROWSET_ID" width="10%"/>
		   			<ai:col fieldname="ROWSET_TYPE" width="15%"/>
		   			<ai:col fieldname="ROWSET_KEY" width="10%"/>
		   			<ai:col fieldname="ROWSET_METHOD" width="20%"/>
		   			<ai:col fieldname="MODULE_ID" width="15%"/>
					<ai:col fieldname="STATE" width="10%"/>	
					<ai:col fieldname="REMARKS" width="20%"/>					
   			</ai:table>	 

</body> 
</html>


