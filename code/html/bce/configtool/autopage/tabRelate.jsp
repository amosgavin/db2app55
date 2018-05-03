<%@ page contentType="text/html; charset=GBK"%>
<%@ include file="/bce/configtool/common/bcetoolhead.jsp"%>
<%@page import="com.ai.bce.util.LocaleResourceFactory"%>
<%@ page import="com.ai.appframe2.web.HttpUtil"%>


<html>
	<head>
		<title><%=LocaleResourceFactory.getResource("BES0000800")%></title>
	</head>
	<%
		String bce_frame_id = HttpUtil.getParameter(request, "bceFrameId");
		String moduleId = HttpUtil.getAsString(request, "module_id");
		String cond = "(MODULE_ID = " + moduleId
				+ " or MODULE_ID = 0 or MODULE_ID is null)";
		if (bce_frame_id == null || bce_frame_id.equals(""))
			bce_frame_id = "-1";
		cond += " and bce_frame_id = " + bce_frame_id;
		request.setAttribute("condition", "cond=" + cond);
	%>
	<body onload="init()">
		<ai:contentframe contenttype="table" id="" title="BES0000634"
			i18nRes="CRM" width="100%">
			<ai:table tableid="PageTabTable"
				setname="com.ai.bce.web.BceFrameAreaPagetab" needrefresh="true"
				tablemodel="com.ai.appframe2.web.datamodel.MethodModelForService"
				conditionname="condition"
				implservice_name="com.ai.bce.service.interfaces.IBceStudioSV"
				implservice_querymethod="getBceFrameAreaPagetab(String cond)"
				initial="true" height="50" width="100%" editable="false"
				footdisplay="block" pagesize="1000" rowsequence="false"
				onrowchange="refreshTabItem" ondbclick="refreshTabItem">
				<ai:col fieldname="TAB_ID" visible="false"/>
				<ai:col fieldname="BCE_FRAME_ID" />
				<ai:col fieldname="AREA_ID"/>
				<ai:col fieldname="TAB_TYPE"/>
				<ai:col fieldname="WIDTH"/>
				<ai:col fieldname="HEIGHT"/>
				<ai:col fieldname="VMFILE"/>
				<ai:col fieldname="GETPARAMETER" width="150" />
				<ai:col fieldname="BEFORESETTAB" width="150" />
				<ai:col fieldname="AFTERSETTAB" width="150" />
				<ai:col fieldname="REMARKS" width="150"/>
				<ai:col fieldname="MODULE_ID" />
				<ai:col fieldname="STATE" />

			</ai:table>
			<div class="area_button">
				<ai:button text="BES0000322" i18nRes="CRM" onclick="addTab()" />
				<ai:button text="BES0000323" i18nRes="CRM" onclick="modTab()" />
				<ai:button text="BES0000324" i18nRes="CRM" onclick="delTab()" />
			</div>
		</ai:contentframe>
		<ai:contentframe contenttype="table" title="TabItem"
			id="" width="100%">
			<ai:table tableid="TabItemTable"
				setname="com.ai.bce.web.BceFrameTabitem" needrefresh="true"
				tablemodel="com.ai.appframe2.web.datamodel.MethodModelForService"
				conditionname="condition"
				implservice_name="com.ai.bce.service.interfaces.IBceStudioSV"
				implservice_querymethod="getBceFrameTabitem(String cond)"
				initial="false" height="100" width="100%" editable="false"
				multiselect="false" footdisplay="block" pagesize="1000"
				rowsequence="false">
				<ai:col fieldname="TAB_ITEM_ID" visible="false"/>
				<ai:col fieldname="TAB_ID" visible="false"/>
				<ai:col fieldname="TITLE" />
				<ai:col fieldname="SRC" />
				<ai:col fieldname="SRC_PARAMS" />
				<ai:col fieldname="WIDTH" />
				<ai:col fieldname="I18NRES" />
				<ai:col fieldname="ISINITIAL" />
				<ai:col fieldname="ISDELETABLE" />
				<ai:col fieldname="MO" />
				<ai:col fieldname="OPERATOR" />
				<ai:col fieldname="MODULE_ID" />
				<ai:col fieldname="STATE" />
				<ai:col fieldname="REMARKS" />
			</ai:table>
			<div class="area_button">
				<ai:button text="BES0000322" i18nRes="CRM" onclick="addTabItem()" />
				<ai:button text="BES0000323" i18nRes="CRM" onclick="modTabItem()" />
				<ai:button text="BES0000324" i18nRes="CRM" onclick="delTabItem()" />
			</div>
		</ai:contentframe>
	</body>
</html>

<script type="text/javascript">
function getTblTab(){
  return g_TableRowSetManager.get("PageTabTable");
}

function getTblTabItem(){
  return g_TableRowSetManager.get("TabItemTable");
}

function init(){
  if(getTblTab().count()>0){
    for(var i=0;i<getTblTab().count();i++){
      getTblTab().setRowEditSts(i,false);
    }
  }
}

function addTab(){
  var rtnVal = window.showModalDialog("addTabRelate.jsp?bceFrameId=<%=bce_frame_id%>&moduleId=<%=moduleId%>","","dialogWidth=900px;dialogHeight=300px");
	if(rtnVal == 1){
		getTblTab().refresh("cond=<%=cond%>");
	}
}

function modTab(){
  var row = getTblTab().getRow();
  if(row == -1){
  	alert(crm_i18n_msg("BEC0000014"));
  	return;
  }
  var tabId = getTblTab().getValue(row,"TAB_ID");
  var rtnVal = window.showModalDialog("addTabRelate.jsp?tabId="+tabId,"","dialogWidth=900px;dialogHeight=300px");
  if(rtnVal == 1){
  	getTblTab().refresh("cond=<%=cond%>");
  }
}

function delTab(){
  var row = getTblTab().getRow();
  if(row == -1){
  	alert(crm_i18n_msg("BEC0000014"));
  	return;
  }
  if(confirm(crm_i18n_msg("BEC0000015"))){
    getTblTab().setRow(-1);
    var tabId = getTblTab().getValue(row,"TAB_ID");
    getTblTabItem().refresh("cond="+"tab_id="+tabId);
    for(var i = getTblTabItem().count();i>=0;i--){
    	getTblTabItem().deleteRow(i);
    }
    getTblTab().deleteRow(row);
    var list = new Array();
    list.push(getTblTab());
    list.push(getTblTabItem());
    var msg = saveRowSet("<%=request.getContextPath()%>/business/com.ai.bce.web.BceStudioAction?action=commonSaveRowset",list,false);
	if(msg.getValueByName("FLAG")=="ERROR" ){
		 alert(crm_i18n_msg("BEC0000013"));
		return;
	}
	getTblTab().refresh("cond=<%=cond%>");
  }
}

function refreshTabItem(){
  var row = getTblTab().getRow();
  if(row == -1)
    return;
  var tabId = getTblTab().getValue(row,"TAB_ID");
  getTblTabItem().refresh("cond="+"tab_id="+tabId);
  if(getTblTabItem().count()>0){
    for(var i=0;i<getTblTabItem().count();i++){
      getTblTabItem().setRowEditSts(i,false);
    }
  }
}

function addTabItem(){
  if(getTblTabItem().count()>0){
    for(var i=0;i<getTblTabItem().count();i++){
      getTblTabItem().setRowEditSts(i,false);
    }
  }
  var row = getTblTab().getRow();
  if(row<0){
   alert(crm_i18n_msg("BEC0000019"));
    return ;
  }
  var tabId = getTblTab().getValue(row,"TAB_ID");
  var rtnVal = window.showModalDialog("addTabItem.jsp?moduleId=<%=moduleId%>&tabId="+tabId,"",'resizable:no;help:no; status:no;resizable:yes;dialogWidth:800px;dialogHeight:280px') ;
  if(rtnVal == 1){
		refreshTabItem();
	}
}

function modTabItem(){
  var row = getTblTabItem().getRow();
  if(row == -1){
  	alert(crm_i18n_msg("BEC0000014"));
  	return;
  }
  var tabItemId = getTblTabItem().getValue(row,"TAB_ITEM_ID");
  var rtnVal = window.showModalDialog("addTabItem.jsp?tabItemId="+tabItemId,"","dialogWidth=900px;dialogHeight=280px");
  if(rtnVal == 1){
  	refreshTabItem();
  }
}

function delTabItem(){
  var row = getTblTabItem().getRow();
  if(row == -1){
    alert(crm_i18n_msg("BEC0000016"));
    return;
  }
  if(confirm(crm_i18n_msg("BEC0000015"))){
    getTblTabItem().deleteRow(row);
    var list = new Array();
    list.push(getTblTabItem());
    var msg = saveRowSet("<%=request.getContextPath()%>/business/com.ai.bce.web.BceStudioAction?action=commonSaveRowset",list,false);
		if(msg.getValueByName("FLAG")=="ERROR" ){
			 alert(crm_i18n_msg("BEC0000013"));
			return;
		}
	  refreshTabItem();
  }
}

</script>
