<%@ page contentType="text/html; charset=GBK"%>
<%@ include file="/bce/configtool/common/bcetoolhead.jsp"%>
<%@page import="com.ai.bce.util.LocaleResourceFactory"%>
<%@page import="com.ai.appframe2.web.HttpUtil"%>
<html>
	<%
		String bcePageFrameId = request.getParameter("pageFrameId");
		if (null == bcePageFrameId || "".equals(bcePageFrameId)) {
			bcePageFrameId = "-1";
		}
		String moduleId = HttpUtil.getAsString(request,"module_id");
		if(!"".equals(moduleId)){
			request.setAttribute("cond","PAGE_FRAME_ID="+bcePageFrameId+" and (MODULE_ID="+moduleId + " or module_id='0' or module_id is null)");
		}else{
			request.setAttribute("cond","PAGE_FRAME_ID="+bcePageFrameId);
		}	
	%>
	<head><title>PageFramePage</title></head>
	<body >
			<ai:table tableid="pFramePageDBTable"
					setname="com.ai.bce.web.QPageFramePage" needrefresh="true"
					tablemodel="com.ai.appframe2.web.datamodel.MethodModelForService"
					implservice_name="com.ai.bce.configtool.service.interfaces.IConfPFramePageSV"
					implservice_querymethod="getBcePageFramePageValues(String cond,int $STARTROWINDEX,int $ENDROWINDEX)"
					implservice_countmethod="getBcePageFramePageValuesCount(String cond)"
					initial="true" height="180" width="100%" editable="false"
					multiselect="false" footdisplay="block" pagesize="8"
					rowsequence="true" ondbclick="dbclick">
					<ai:col fieldname="PAGE_TITLE" width="200" />
					<ai:col fieldname="PAGE_TYPE" width="100"/>
					<ai:col fieldname="PAGE_URL" width="300" />
					<ai:col fieldname="PAGE_FRAME_PAGE_ID" width="150"/>
					<ai:col fieldname="PAGE_FRAME_ID" width="100"/>
					<ai:col fieldname="PAGE_ID" width="100"/>
					<ai:col fieldname="MODULE_ID" width="100"/>
					<ai:col fieldname="SEQ_NO" width="100"/>
					<ai:col fieldname="IS_DISPLAY" width="100"/>
					<ai:col fieldname="IS_GET_PAGE_DATA" width="100"/>
					<ai:col fieldname="IS_DATA_MUST" width="100"/>
					<ai:col fieldname="PAGE_TEMPLATE" width="200"/>
					<ai:col fieldname="PAGE_RULESET_ID" width="100"/>
					<ai:col fieldname="PAGE_LOAD_TYPE" width="100"/>
					<ai:col fieldname="STATE" width="100"/>
					<ai:col fieldname="REMARKS"  width="200"/>
				</ai:table>
	    	<div class="area_button">
					<ai:button text="BES0000321" i18nRes="CRM" onclick="dbclick()"/>
					<ai:button text="BES0000320" i18nRes="CRM" onclick="window.close()"/>
				</div>
	</body>
	<script type="text/javascript">
	
	function getPageFramePageTable(){
		return g_TableRowSetManager.get("pFramePageDBTable");
	}

	function dbclick(){
		var i =getPageFramePageTable().getRow();
        if(i==-1){
        	alert(crm_i18n_msg("BEC0000014"));
        	return;
        	}
	          window.returnValue = getPageFramePageTable().getValue(i,"PAGE_FRAME_PAGE_ID");
	          window.close();
	}
	</script>
</html>