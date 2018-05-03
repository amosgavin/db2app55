<%@ page contentType="text/html; charset=GBK"%>
<%@ include file="/bce/configtool/common/bcetoolhead.jsp"%>
<%@page import="com.ai.bce.util.LocaleResourceFactory"%>
<%@page import="com.ai.appframe2.web.HttpUtil"%>
<%
String pageFrameId = request.getParameter("pageFrameId");
if(null == pageFrameId || "".equals(pageFrameId)){
	pageFrameId = "-1";
}

		String moduleId = HttpUtil.getAsString(request,"module_id");
		if(moduleId !=null && !"".equals(moduleId)){
			request.setAttribute("cond","MODULE_ID="+moduleId + " or module_id='0' or module_id is null");
		}
%>
<html>
	<head>
		<script language="javascript" src="../common/js/configtool.js"></script>
	</head>

	<body onload="init()">
				<ai:table tableid="pageDbTable"
					setname="com.ai.bce.web.BceFrame" needrefresh="true"
					tablemodel="com.ai.appframe2.web.datamodel.MethodModelForService"
					implservice_name="com.ai.bce.configtool.service.interfaces.IConfFrameSV"
					implservice_querymethod="getBceFrameValues(String cond,int $STARTROWINDEX,int $ENDROWINDEX)"
					implservice_countmethod="getBceFrameValuesCount(String cond)"
					initial="false" height="220" width="100%" editable="false"
					multiselect="false" footdisplay="block" pagesize="10"
					rowsequence="true" >
					<ai:col fieldname="REMARKS" title="BES0000032" i18nRes="CRM" width="200" />
					<ai:col fieldname="BCE_FRAME_ID" width="100"/>
					<ai:col fieldname="BUSINESS_ID" width="100"/>
					<ai:col fieldname="PAGE_FRAME_ID" width="100" />
					<ai:col fieldname="DATA_PARSER" width="350" />
					<ai:col fieldname="DEAL_SERVICE" width="200" />
					<ai:col fieldname="ENTRY_PAGE_URL" width="100"/>
					<ai:col fieldname="WORKFLOW_CODE" width="400" />
					<ai:col fieldname="PARAM_DATA" width="150"/>
					<ai:col fieldname="STATE" width="50" />
				</ai:table>
	</body>
	<script type="text/javascript">
	
	    function init(){
	    var pageFrameId = "<%=pageFrameId%>";
	    if(pageFrameId != null && pageFrameId != ''){
	    getPageFrameTab().refresh("cond=PAGE_FRAME_Id=<%=pageFrameId%>");
	    }
	    }
	    
    	function getPageFrameTab(){
    	return g_TableRowSetManager.get("pageDbTable");
    	}
    	
    	
</script>
</html>



