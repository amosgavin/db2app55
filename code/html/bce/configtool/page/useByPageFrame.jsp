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
 
			<ai:table tableid="pageDbTable"
					setname="com.ai.bce.web.SETBcePagePageFrame" needrefresh="true"
					tablemodel="com.ai.appframe2.web.datamodel.MethodModelForService"
					implservice_name="com.ai.bce.configtool.service.interfaces.IConfPageSV"
					implservice_querymethod="getRelatePageFramesByPageId(long pageId,  int $STARTROWINDEX,int $ENDROWINDEX)"   
					implservice_countmethod="getRelatePageFrameCount(long pageId)" 
					initial="<%=initial %>" height="220" width="100%" editable="false"
					multiselect="false" footdisplay="block" pagesize="10" rowsequence="true" >
					<ai:col fieldname="PAGE_FRAME_ID" width="10%"/>
					<ai:col fieldname="PAGE_FRAME_NAME" width="20%"/>
					<ai:col fieldname="MODULE_ID" width="15%"/>
					<ai:col fieldname="FRAME_TYPE" width="15%"/>
					<ai:col fieldname="STATE"  width="10%"/>
					<ai:col fieldname="REMARKS"  width="30%"  />
				</ai:table> 
</body> 
</html>


