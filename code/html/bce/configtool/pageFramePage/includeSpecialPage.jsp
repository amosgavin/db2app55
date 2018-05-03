<%@ page contentType="text/html; charset=GBK"%>
<%@ include file="/bce/configtool/common/bcetoolhead.jsp"%>
<%@page import="com.ai.bce.util.LocaleResourceFactory"%>
<%@page import="com.ai.appframe2.web.HttpUtil"%>

<html>
	<%
		String pFramePageId = request.getParameter("pFramePageId");
		if (null == pFramePageId || "".equals(pFramePageId)) {
			pFramePageId = "-1";
		}
		String cond = "PAGE_FRAME_PAGE_ID=" + pFramePageId;
		//BCE_FRAME_ID
		String bceFrameId = request.getParameter("BCE_FRAME_ID");
		if (null == bceFrameId || "".equals(bceFrameId)) {
			bceFrameId = "-1";
		} else {
			cond += " and BCE_FRAME_ID=" + bceFrameId;
		}
		String moduleId = HttpUtil.getAsString(request,"module_id");
		if(moduleId !=null && !"".equals(moduleId)){
			cond += " and (MODULE_ID="+moduleId + " or module_id='0' or module_id is null)";
		}
		request.setAttribute("cond", cond);
		 
	%>
	<head>
		<script language="javascript" src="../common/js/configtool.js"></script>
	</head>

	<body>
			<ai:table tableid="specialPageTable"
				setname="com.ai.bce.web.BceFrameSpecialPage" needrefresh="true"
				tablemodel="com.ai.appframe2.web.datamodel.MethodModelForService"
				implservice_name="com.ai.bce.configtool.service.interfaces.IConfSpecialPageSV"
				implservice_querymethod="getSpecialPageValues(String cond,int $STARTROWINDEX,int $ENDROWINDEX)"
				implservice_countmethod="getSpecialPageValuesCount(String cond)"
				initial="true" height="230" width="100%" editable="false"
				multiselect="false" footdisplay="block" pagesize="8"
				rowsequence="true">
				<ai:col fieldname="BCE_FRAME_ID" width="100"/>
				<ai:col fieldname="PAGE_FRAME_PAGE_ID" width="110"/>
				<ai:col fieldname="PAGE_TITLE" width="150"/>
				<ai:col fieldname="MODULE_ID" width="300"/>
				<ai:col fieldname="PAGE_PARAM" width="100"/>
				<ai:col fieldname="IS_GET_PAGE_DATA" width="140"/>
				<ai:col fieldname="IS_DATA_MUST" width="140"/>
				<ai:col fieldname="PAGE_RULESET_ID" width="100"/>
				<ai:col fieldname="STATE" width="100"/>
				<ai:col fieldname="REMARKS" width="300"/>
			</ai:table>
			<div class="area_button">
				<%
					if (!"-1".equals(pFramePageId)) {
				%>							
							<div id="isshow" style="display: inline">
								<ai:button text="BES0000322" i18nRes="CRM" onclick="add()" />
							</div>
							<ai:button text="BES0000323" i18nRes="CRM" onclick="edit()" />
							<ai:button text="BES0000324" i18nRes="CRM" onclick="del()" />
				<%
					}
				%>
				</div>
	</body>


	<script type="text/javascript">
		function init(){
		var bceFrameId = "<%=bceFrameId%>";
			if(getSpecialPageTable.getTotalRowCount()>0){
				document.getElementById('isshow').style.display="none";
				}
		}
    	function add(){
    		if("<%=bceFrameId%>"!='-1'){
    			if(getSpecialPageTable().count() > 0){
    				alert(crm_i18n_msg("BEC0000022"));
    				return;
    			}
    		}
	    	var url = "../specialPage/selectSpecialPage.jsp?pFramePageId=<%=pFramePageId%>";
	    	url = genUrl(url,"<%=bceFrameId%>");
	    	var rtnVal = window.showModalDialog(url,{moduleId:<%=moduleId%>},"dialogWidth=700px;dialogHeight=260px");
		    if(rtnVal == 1){
		    	refresh();
	    	}
    	}
    	
    	function genUrl(url,bceFrameId){
    		if(bceFrameId != -1){
    			return url+="&bceFrameId="+bceFrameId;
    		}
    		return url;
    	}
    	
    	function refresh(){
	    	getSpecialPageTable().refresh("cond=<%=cond%>");
	    	refreshTopByQuoteChange();
    	}
    	
    	function edit(){
    	var index = getSpecialPageTable().getRow();
    	if(getSpecialPageTable().getTotalRowCount() == 1){
    		index = 0;
    	}
    	if(index == -1){
	    	alert(crm_i18n_msg("BEC0000014"));
	    	return false;
    	}
    	var bceFrameId = getSpecialPageTable().getValue(index,"BCE_FRAME_ID");
    	var rtnVal = window.showModalDialog("../specialPage/selectSpecialPage.jsp?pFramePageId=<%=pFramePageId%>&bceFrameId="+bceFrameId,{isEdit:-10,moduleId:<%=moduleId%>},"dialogWidth=700px;dialogHeight=260px");
    	if(rtnVal == 1)
    		refresh();
    	}
    	
    	//É¾³ý²Ù×÷
    	function del(){
    	var index = getSpecialPageTable().getRow();
    	if(index == -1){
	    	alert(crm_i18n_msg("BEC0000014"));
	    	return false;
    	}
    	if(!confirm(crm_i18n_msg("BEC0000015"))){
    		return false;
    	}
    	getSpecialPageTable().deleteRow(index);
    	var list = new Array();
    	list.push(getSpecialPageTable());
    	var ud = saveRowSet("<%=request.getContextPath()%>/business/com.ai.bce.web.BceStudioAction?action=commonSaveRowset",list,false);
    	if (ud.getValueByName("FLAG") == "ERROR" ) {
    	  if(!ud.getValueByName("MESSAGE"))
			  alert(crm_i18n_msg("BEC0000013"));
			  return;
			}
		refresh();
    	}
    	
	  function getSpecialPageTable(){
	  	return g_TableRowSetManager.get("specialPageTable");
	  }
</script>
</html>