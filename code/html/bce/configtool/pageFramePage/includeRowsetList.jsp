<%@ page contentType="text/html; charset=GBK"%>
<%@ include file="/bce/configtool/common/bcetoolhead.jsp"%>
<%@ page import="com.ai.appframe2.web.HttpUtil"%>
<%@page import="com.ai.bce.util.LocaleResourceFactory"%>
<%@page import="com.ai.appframe2.web.HttpUtil"%>

<html>
	<%
		String pFramePageId = request.getParameter("pFramePageId");
		if (null == pFramePageId || "".equals(pFramePageId)) {
			pFramePageId = "-1";
		}
	 	String moduleId = HttpUtil.getAsString(request,"module_id");
		if("".equals(moduleId)){
			request.setAttribute("cond", "PAGE_FRAME_PAGE_ID=" + pFramePageId);
		}else{
			request.setAttribute("cond", "PAGE_FRAME_PAGE_ID=" + pFramePageId
				+" and (MODULE_ID="+moduleId + " or module_id='0' or module_id is null)");
		}
	%>
	<head>
		<title><%=LocaleResourceFactory.getResource("BES0000036")%></title>

		<script language="javascript" src="../common/js/configtool.js"></script>
	</head>

	<body>
			<ai:table tableid="PageRowsetDBTable"
				setname="com.ai.bce.web.SETBcePageRowset" needrefresh="true"
				tablemodel="com.ai.appframe2.web.datamodel.MethodModelForService"
				conditionname="condition"
				implservice_name="com.ai.bce.configtool.service.interfaces.IConfRowsetSV"
				implservice_querymethod="getPageRowsetValues(String cond)"
				initial="true" height="230" width="100%" editable="false"
				multiselect="false" footdisplay="true" pagesize="8"
				rowsequence="false">

				<ai:col fieldname="PAGE_FRAME_PAGE_ID" width="10%" />
				<ai:col fieldname="RELATE_STATE" width="10%" />
				<ai:col fieldname="MODULE_ID" width="10%" />
				<ai:col fieldname="ROWSET_ID" width="10%" />
				<ai:col fieldname="ROWSET_TYPE" width="15%" />
				<ai:col fieldname="ROWSET_KEY" width="15%" />
				<ai:col fieldname="ROWSET_METHOD" width="15%" />
				<ai:col fieldname="STATE" width="10%"  />
				<ai:col fieldname="REMARKS" width="20%" />
			</ai:table>
			<div class="area_button">
				<%
					if (!"-1".equals(pFramePageId)) {
				%>
							<ai:button text="BES0000322" i18nRes="CRM" onclick="add()" />
							<ai:button text="BES0000323" i18nRes="CRM" onclick="edit()" />
							<ai:button text="BES0000324" i18nRes="CRM" onclick="del()" />
					</tr>
				</table>
				<%
					}
				%>
		</div>
	</body>
	<script>
	
	function getPageRowset(){
		return g_TableRowSetManager.get("PageRowsetDBTable");
	}
	
	/**
	 * 新增页面与数据集关联
	 */
	function add(){
		var pFramePageId = "<%=pFramePageId%>";
		var rtnVal = window.showModalDialog("../pagerowset/addPageRowset.jsp?pFramePageId="+pFramePageId, <%=moduleId%>,"dialogWidth=700px;dialogHeight=300px");
	    if(rtnVal == 1){
	    getPageRowset().refresh("cond=PAGE_FRAME_PAGE_ID="+pFramePageId);
	    refreshTopByQuoteChange();
	    }
	}
	
	   function getRowsetId(){
			var index = getPageRowset().getRow();
			if(index == -1){
			alert(crm_i18n_msg("BEC0000014"));
			return false;
			}
			var rowsetId = getPageRowset().getValue(index,"ROWSET_ID");
			return rowsetId;
		}
		
		function del(){
			var index = getPageRowset().getRow();
			if(index == -1){
			alert(crm_i18n_msg("BEC0000014"));
			return false;
			}
			if(!confirm(crm_i18n_msg("BEC0000015"))){
				return;
				}
		   getPageRowset().deleteRow(index);
    	var list = new Array();
    	list.push(getPageRowset());
    	var ud = saveRowSet("<%=request.getContextPath()%>/business/com.ai.bce.configtool.web.ConfRowsetAction?action=savePageRowset",list,false);
    	if (ud.getValueByName("FLAG") == "ERROR" ) {
			  alert(crm_i18n_msg("BEC0000013"));
			  return;
			} 	
		   getPageRowset().refresh("cond=PAGE_FRAME_PAGE_ID="+pFramePageId);
		   refreshTopByQuoteChange();
		}
		
		function edit(){
			var rowsetId = getRowsetId();
			var pFramePageId = "<%=pFramePageId%>";
			if(rowsetId != false){
			var rtnVal = window.showModalDialog("../pagerowset/addPageRowset.jsp?pFramePageId="+pFramePageId+"&rowsetId="+rowsetId, "","dialogWidth=700px;dialogHeight=300px");
			if(rtnVal == 1){
		    getPageRowset().refresh("cond=PAGE_FRAME_PAGE_ID="+pFramePageId);
		    refreshTopByQuoteChange();
		    }
		 }
		}
		
</script>
</html>


