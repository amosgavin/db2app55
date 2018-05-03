<%@ page contentType="text/html; charset=GBK"%>
<%@ include file="/bce/configtool/common/bcetoolhead.jsp"%>
<%@ page import="com.ai.appframe2.web.HttpUtil"%>
<%@page import="com.ai.bce.util.LocaleResourceFactory"%>


<%
	String pFramePageId = HttpUtil.getAsString(request, "pFramePageId");
	if (null == pFramePageId || "".equals(pFramePageId)) {
		pFramePageId = "-1";
	}
	String cond = "PAGE_FRAME_PAGE_ID=" + pFramePageId;

	//BCE_FRAME_ID
	String bceFrameId = HttpUtil.getAsString(request, "BCE_FRAME_ID");
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
<html>
	<head>
		<script language="javascript" src="../common/js/configtool.js"></script>

	</head>

	<body>
			<ai:table tableid="framePageRoleTab"
				setname="com.ai.bce.web.BceFramePageRole" needrefresh="true"
				tablemodel="com.ai.appframe2.web.datamodel.MethodModelForService"
				implservice_name="com.ai.bce.configtool.service.interfaces.IConfFramePageRoleSV"
				implservice_querymethod="getPageRoleValues(String cond,int $STARTROWINDEX,int $ENDROWINDEX)"
				implservice_countmethod="getPageRoleValuesCount(String cond)"
				initial="true" height="230" width="100%" editable="false"
				multiselect="false" footdisplay="block" pagesize="8"
				rowsequence="true">
				<ai:col fieldname="BCE_FRAME_ID" width="15%"/>
				<ai:col fieldname="PAGE_FRAME_PAGE_ID" width="15%"/>
				<ai:col fieldname="ROLE_ID" width="10%"/>
				<ai:col fieldname="MAX_NUM" width="15%"/>
				<ai:col fieldname="SEQ_NO" width="10%"/>
				<ai:col fieldname="STATE" width="10%"/>
				<ai:col fieldname="REMARKS" width="30%"/>
			</ai:table>
			
				<div class="area_button">
			<%
					if (!"-1".equals(pFramePageId)) {
				%>
							<div id="isshow" style="display: inline">
								<ai:button text="BES0000322" i18nRes="CRM" onclick="add()" />
							</div>
							<ai:button text="BES0000323" i18nRes="CRM"  onclick="edit()" />

							<ai:button text="BES0000324" i18nRes="CRM"  onclick="del()" />
				<%
					}
					
				%>
				</div>
	</body>
	<script type="text/javascript">
		function init(){
		var bceFrameId = "<%=bceFrameId%>";
			if(bceFrameId != '-1'&&getSpecialPageTable.getTotalRowCount()>0){
				document.getElementById('isshow').style.display="none";
				}
		}
		
		function genUrl(url,bceFrameId){
    		if(bceFrameId != -1){
    		 	url+="&bceFrameId="+bceFrameId;
    		}
    		return url;
    	}
    	
    	function refresh(){
    		getFramePageRoleTab().refresh("cond=<%=cond%>");
    		refreshTopByQuoteChange();
    	}
        //新增操作
    	function add(){
    	var url = "../framePageRole/selectFramePageRole.jsp?pFramePageId=<%=pFramePageId%>";
    	url = genUrl(url,"<%=bceFrameId%>");
    	var rtnVal = window.showModalDialog(url,<%=moduleId%>,"dialogWidth=750px;dialogHeight=260px");
    	if(rtnVal == 1){
	    	refresh();
    		}
    	}
    	//修改
    	function edit(){
    	var index = getFramePageRoleTab().getRow();
    	if(getFramePageRoleTab().getTotalRowCount() == 1){
    		index = 0;
    	}
    	if(index == -1){
	    	alert(crm_i18n_msg("BEC0000014"));
	    	return false;
    	}
    	var bceFrameId = getFramePageRoleTab().getValue(index,"BCE_FRAME_ID");
    	var roleId = getFramePageRoleTab().getValue(index,"ROLE_ID");
    	var rtnVal = window.showModalDialog("../framePageRole/selectFramePageRole.jsp?pFramePageId=<%=pFramePageId%>&bceFrameId="+bceFrameId+"&roleId="+roleId,"","dialogWidth=750px;dialogHeight=260px");
    	if(rtnVal == 1)
    		refresh();
    	}
    	//删除操作
    	function del(){
	    	var index = getFramePageRoleTab().getRow();
	    	if(index == -1){
	    		alert(crm_i18n_msg("BEC0000014"));
	    		return;
	    	}
	    	if(!confirm(crm_i18n_msg("BEC0000015"))){
	    		return false;
	    	}
	    	getFramePageRoleTab().deleteRow(index);
	    	var list = new Array();
	    	list.push(getFramePageRoleTab());
	    	var ud = saveRowSet("<%=request.getContextPath()%>/business/com.ai.bce.web.BceStudioAction?action=commonSaveRowset",list,false);
	    	if (ud.getValueByName("FLAG") == "ERROR" ) {
				  alert(crm_i18n_msg("BEC0000013"));
				  return false;
				}
			refresh();
    	}
    	
    	function getFramePageRoleTab(){
    		return g_TableRowSetManager.get("framePageRoleTab");
    	}
    	
</script>
</html>