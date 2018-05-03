<%@ page contentType="text/html; charset=GBK"%>
<%@ include file="/bce/configtool/common/bcetoolhead.jsp"%>
<%@page import="com.ai.bce.util.LocaleResourceFactory"%>
<%@ page import="com.ai.appframe2.web.HttpUtil"%>


<html>
	<head>
		<title><%=LocaleResourceFactory.getResource("BES0000534")%></title>
	</head>
	<%
		String bce_frame_id = HttpUtil.getParameter(request, "bceFrameId");
		String moduleId = HttpUtil.getAsString(request, "module_id");
		String cond = "(MODULE_ID = " + moduleId
				+ " or MODULE_ID = 0 or MODULE_ID is null)";
		if (bce_frame_id == null || bce_frame_id.equals(""))
			bce_frame_id = "-1";
		cond += " and bce_frame_id = " + bce_frame_id + " AND FORM_TYPE=1";
		request.setAttribute("cond", cond);
	%>
	<body onload="init()">
		<ai:contentframe contenttype="table" title="BES0000634" i18nRes="CRM"
			id="" width="100%">
			<ai:table tableid="FormTable"
				setname="com.ai.bce.web.BceFrameAreaForm" needrefresh="true"
				tablemodel="com.ai.appframe2.web.datamodel.MethodModelForService"
				conditionname="condition"
				implservice_name="com.ai.bce.service.interfaces.IBceStudioSV"
				implservice_querymethod="getFrameAreaForm(String cond)"
				initial="true" height="100" width="100%" editable="true"
				footdisplay="block" pagesize="1000" rowsequence="false"
				onrowchange="refreshAll" ondbclick="refreshAll">
				<ai:col fieldname="BCE_FRAME_ID" />
				<ai:col fieldname="FORM_ID" />
				<ai:col fieldname="COLS" />
				<ai:col fieldname="DATA_MODEL" width="150" />
				<ai:col fieldname="SERVICE_NAME" width="150" />
				<ai:col fieldname="QUERY_METHOD" width="150" />
				<ai:col fieldname="COUNT_METHOD" width="150" />
				<ai:col fieldname="MODULE_ID" />
				<ai:col fieldname="CONDITION_NAME" />
				<ai:col fieldname="PARAMETER_NAME" />
				<ai:col fieldname="IS_INITIAL" />
				<ai:col fieldname="IS_EDITABLE" />
				<ai:col fieldname="NEED_REFRESH" />
				<ai:col fieldname="MULT_SELECT" />
				<ai:col fieldname="PAGE_SIZE" />
				<ai:col fieldname="WIDTH" />
				<ai:col fieldname="HEIGHT" />
				<ai:col fieldname="ROW_HEIGHT" />
				<ai:col fieldname="FOOT_DISPLAY" />
				<ai:col fieldname="ON_DBCLICK" />
				<ai:col fieldname="ON_ROWCHANGE" />
				<ai:col fieldname="ON_VALUECHANGE" />
				<ai:col fieldname="STATE" />
			</ai:table>
			<div class="area_button">
				<ai:button text="BES0000322" i18nRes="CRM" onclick="addForm()" />
				<ai:button text="BES0000323" i18nRes="CRM" onclick="modForm()" />
				<ai:button text="BES0000324" i18nRes="CRM" onclick="delForm()" />
				<%if("1".equals(moduleId)){%>
				    <%=LocaleResourceFactory.getResource("BES0000823")%>			
				<%}
			    %>
			</div>
		</ai:contentframe>
		<table align="center" width="100%" border="0" cellspacing="0" cellspacing="0">
			<tr>
				<td width="50%">
					<ai:contentframe contenttype="table" title="BES0000640"
						i18nRes="CRM" id="" width="100%">
						<ai:table tableid="FormGroupTable"
							setname="com.ai.bce.web.BceFormGroup" needrefresh="true"
							tablemodel="com.ai.appframe2.web.datamodel.MethodModelForService"
							conditionname="condition"
							implservice_name="com.ai.bce.service.interfaces.IBceStudioSV"
							implservice_querymethod="getBceFormGroup(String cond)"
							initial="false" height="180" width="100%" editable="true"
							multiselect="true" footdisplay="block" pagesize="1000"
							rowsequence="false" onrowchange="refreshAttr">
							<ai:col fieldname="GROUP_ID" />
							<ai:col fieldname="BCE_FRAME_ID" />
							<ai:col fieldname="FORM_ID" />
							<ai:col fieldname="GROUP_NAME" />
							<ai:col fieldname="SEQ_NO" />
							<ai:col fieldname="MODULE_ID" />
							<ai:col fieldname="IS_ALLOW_STRACT" />
							<ai:col fieldname="IS_CLOSED" />
							<ai:col fieldname="GROUP_STYLE" />
							<ai:col fieldname="ATTR_1" />
							<ai:col fieldname="ATTR_2" />
							<ai:col fieldname="ATTR_3" />
							<ai:col fieldname="ATTR_4" />
							<ai:col fieldname="ATTR_5" />
							<ai:col fieldname="STATE" />
						</ai:table>
						<div class="area_button">
							<ai:button text="BES0000322" i18nRes="CRM"
								onclick="addFormGroup()" />
							<ai:button text="BES0000323" i18nRes="CRM"
								onclick="modFormGroup()" />
							<ai:button text="BES0000324" i18nRes="CRM"
								onclick="delFormGroup()" />
							<ai:button text="BES0000633" i18nRes="CRM"
								onclick="saveFormGroup()" />
						</div>
					</ai:contentframe>
				</td>
				<td width="50%">
					<ai:contentframe contenttype="table" title="BES0000635"
						i18nRes="CRM" id="" width="100%">
						<ai:table tableid="FormAttrTable"
							setname="com.ai.bce.web.BceFrameAttr" needrefresh="true"
							tablemodel="com.ai.appframe2.web.datamodel.MethodModelForService"
							conditionname="condition"
							implservice_name="com.ai.bce.service.interfaces.IBceStudioSV"
							implservice_querymethod="getBceFrameAttr(String cond)"
							initial="false" height="180" width="100%" editable="true"
							multiselect="true" footdisplay="block" pagesize="1000"
							rowsequence="false">
	 						<ai:col fieldname="ATTR_ID"  width="200"/>
							<ai:col fieldname="ATTR_NAME"  width="200"/>
							<ai:col fieldname="BCE_FRAME_ID" />
							<ai:col fieldname="FORM_ID" />
							<ai:col fieldname="GROUP_ID" />
							<ai:col fieldname="SEQ_NO" />
							<ai:col fieldname="IS_NULLABLE" />
							<ai:col fieldname="IS_VISIBLE" />
							<ai:col fieldname="IS_EDITABLE" />
							<ai:col fieldname="EDIT_TYPE" />
							<ai:col fieldname="FIELD_WIDTH" />
							<ai:col fieldname="FIELD_HEIGHT" />
							<ai:col fieldname="MAX_LENGTH" />
			      	<ai:col fieldname="COL_SPAN" />
			        <ai:col fieldname="IS_MULTIVALUEABLE" />
							<ai:col fieldname="I18N_RES" />
							<ai:col fieldname="RES_SRC" />
							<ai:col fieldname="RES_PARAM" />
							<ai:col fieldname="DEFAULT_VALUE" />
							<ai:col fieldname="VALUE_CLASS" />
							<ai:col fieldname="IS_VALIDATE" />
							<ai:col fieldname="IS_LOG" />
							<ai:col fieldname="MODULE_ID" />
							<ai:col fieldname="STATE" />
						</ai:table>
						<div class="area_button">
							<ai:button text="BES0000322" i18nRes="CRM"
								onclick="addFormAttr()" />
							<ai:button text="BES0000323" i18nRes="CRM"
								onclick="modFormAttr()" />
							<ai:button text="BES0000324" i18nRes="CRM"
								onclick="delFormAttr()" />
							<ai:button text="BES0000633" i18nRes="CRM"
								onclick="saveFormAttr()" />
						</div>
					</ai:contentframe>
				</td>
			</tr>
		</table>
	</body>
</html>

<script type="text/javascript">
function getTblForm(){
  return g_TableRowSetManager.get("FormTable");
}

function getTblFormAttr(){
  return g_TableRowSetManager.get("FormAttrTable");
}
function getFormGroupTbl(){
  return g_TableRowSetManager.get("FormGroupTable");
}

function init(){
  if(getTblForm().count()>0){
    for(var i=0;i<getTblForm().count();i++){
      getTblForm().setRowEditSts(i,false);
    }
  }
  else{
	if("<%=moduleId%>" == "1"){
	  getTblFormAttr().refresh("cond="+"bce_frame_id=<%=bce_frame_id%>");
	  if(getTblFormAttr().count()>0){
	    for(var i=0;i<getTblFormAttr().count();i++){
	      getTblFormAttr().setRowEditSts(i,false);
	    }
	  }
	}
  }
}

function addForm(){
	var rtnVal = window.showModalDialog("addDbformRelate.jsp?bceFrameId=<%=bce_frame_id%>",<%=moduleId%>,"dialogWidth=900px;dialogHeight=400px");
	if(rtnVal == 1){
		window.location.reload();
	}
}

function modForm(){
  var row = getTblForm().getRow();
  if(row == -1){
  	alert(crm_i18n_msg("BEC0000014"));
  	return;
  }
  var formId = getTblForm().getValue(row,"FORM_ID");
  var rtnVal = window.showModalDialog("addDbformRelate.jsp?bceFrameId=<%=bce_frame_id%>&formId="+formId,<%=moduleId%>,"dialogWidth=900px;dialogHeight=400px");
  if(rtnVal == 1){
  	window.location.reload();
  }
}

//级联删除，删除form的同时删除对应的关系表
function delForm(){
  var row = getTblForm().getRow();
  if(row == -1){
    alert(crm_i18n_msg("BEC0000014"));
  	return;
  }
  if(confirm(crm_i18n_msg("BEC0000015"))){
    getTblForm().setRow(-1);
    
    var formId = getTblForm().getValue(row,"FORM_ID");
    var cond = "cond="+"bce_frame_id=<%=bce_frame_id%> and form_id='"+formId+"'";
    getFormGroupTbl().refresh(cond);
    getTblFormAttr().refresh(cond);
    
    for(var i = getFormGroupTbl().count();i>=0;i--){
    	getFormGroupTbl().deleteRow(i);
    }
    for(var i = getTblFormAttr().count();i>=0;i--){
    	getTblFormAttr().deleteRow(i);
    }
    getTblForm().deleteRow(row);
    var list = new Array();
    list.push(getTblForm());
    list.push(getFormGroupTbl());
    list.push(getTblFormAttr());
    var msg = saveRowSet("<%=request.getContextPath()%>/business/com.ai.bce.web.BceStudioAction?action=commonSaveRowset",list,false);
	if(msg.getValueByName("FLAG")=="ERROR" ){
		 alert(crm_i18n_msg("BEC0000013"));
		return;
	}
	window.location.reload();
  }
}

function refreshAll(){
  var row = getTblForm().getRow();
  var formId = getTblForm().getValue(row,"FORM_ID");
   getFormGroupTbl().refresh("cond="+"bce_frame_id=<%=bce_frame_id%> and form_id='"+formId+"'");
   if(getFormGroupTbl().count()>0){
    for(var i=0;i<getFormGroupTbl().count();i++){
      getFormGroupTbl().setRowEditSts(i,false);
    }
  }
  
  getTblFormAttr().refresh("cond="+"bce_frame_id=<%=bce_frame_id%> and form_id='"+formId+"'");
  if(getTblFormAttr().count()>0){
    for(var i=0;i<getTblFormAttr().count();i++){
      getTblFormAttr().setRowEditSts(i,false);
    }
  }
}

function refreshAttr(){
  var row = getFormGroupTbl().getRow();
  var areaRow = getTblForm().getRow();
  var formId = getTblForm().getValue(areaRow,"FORM_ID");
  var cond = "cond="+"bce_frame_id=<%=bce_frame_id%> and form_id='"+formId+"'"
  if(row != -1){
	  var groupId = getFormGroupTbl().getValue(row,"GROUP_ID");
	  cond+=" and group_id="+groupId
  }
   getTblFormAttr().refresh(cond);
  if(getTblFormAttr().count()>0){
    for(var i=0;i<getTblFormAttr().count();i++){
      getTblFormAttr().setRowEditSts(i,false);
    }
  }
}

function addFormGroup(){
 
  var row = getTblForm().getRow();
  if(row<0){
    alert(crm_i18n_msg("BEC0000019"));
    return ;
  }
  var formId = getTblForm().getValue(row,"FORM_ID");
  var obj = {moduleId:'<%=moduleId%>',bceFrameId:'<%=bce_frame_id%>',formId:formId};
  var flag = window.showModalDialog("addGroup.jsp",obj,'resizable:no;help:no; status:no;resizable:yes;dialogWidth:800px;dialogHeight:530px') ;
  if(flag == 1){
      getFormGroupTbl().refresh("cond="+"bce_frame_id=<%=bce_frame_id%> and form_id='"+formId+"'");
       if(getFormGroupTbl().count()>0){
    for(var i=0;i<getFormGroupTbl().count();i++){
      getFormGroupTbl().setRowEditSts(i,false);
    }
  }
  }
  
}

function modFormGroup(){
  var rows = getFormGroupTbl().getSelectedRows();
  if(rows.length == 0){
    alert(crm_i18n_msg("BEC0000016"));
    return;
  }
  for(var i=0;i<rows.length;i++){
  	var row = rows[i];
  	getFormGroupTbl().setRowEditSts(row,true);
  	getFormGroupTbl().setCellEditSts(row,"BCE_FRAME_ID",false);
  	getFormGroupTbl().setCellEditSts(row,"FORM_ID",false);
    getFormGroupTbl().setCellEditSts(row,"GROUP_ID",false);	
  }
}

function delFormGroup(){
  var rows = getFormGroupTbl().getSelectedRows();
  if(rows.length == 0){
     alert(crm_i18n_msg("BEC0000016"));
    return;
  }
 if(confirm(crm_i18n_msg("BEC0000015"))){
    getFormGroupTbl().setRow(-1);
    for(var i=rows.length-1;i>=0;i--){
      var groupId = getFormGroupTbl().getValue(rows[i],"GROUP_ID");
      for(var j = getTblFormAttr().count();j>=0;j--){
    	  if(getTblFormAttr().getValue(j,"GROUP_ID") == groupId)
    	    getTblFormAttr().deleteRow(j);
      }
      getFormGroupTbl().deleteRow(rows[i]);
    }
    alert(crm_i18n_msg("BEC0000020"));
  }
}

function saveFormGroup(){
  if(getFormGroupTbl().toXmlString() == ""){
    alert(crm_i18n_msg("BEC0000021"));
    return;
  }
  var list = new Array();
  list.push(getFormGroupTbl());
  if(getTblFormAttr().toXmlString() != ""){
    list.push(getTblFormAttr());
  }
  var ud = saveRowSet("<%=request.getContextPath()%>/business/com.ai.bce.web.BceStudioAction?action=commonSaveRowset",list,false);
	if (ud.getValueByName("FLAG") == "ERROR"  ) {
		alert(crm_i18n_msg("BEC0000013"));
		return;
	}
	alert(crm_i18n_msg("BEC0000321"));
	refreshAll();
  if(getFormGroupTbl().count()>0){
    for(var i=0;i<getFormGroupTbl().count();i++){
      getFormGroupTbl().setRowEditSts(i,false);
    }
  }
}

function addFormAttr(){
  if(getTblFormAttr().count()>0){
    for(var i=0;i<getTblFormAttr().count();i++){
      getTblFormAttr().setRowEditSts(i,false);
    }
  }
  var row = getTblForm().getRow();
  var formId = "frmProductAttr";
  if(row<0){
	if("<%=moduleId%>" != "1"
		|| "<%=moduleId%>" == "1" 
		&& !confirm(crm_i18n_msg("BEC0000340"))){
	  alert(crm_i18n_msg("BEC0000019"));
	  return ;
	}
  }
  else{
	formId = getTblForm().getValue(row,"FORM_ID");
  }
  var bceAttrs = window.showModalDialog("BceAttr.jsp",<%=moduleId%>,'resizable:no;help:no; status:no;resizable:yes;dialogWidth:800px;dialogHeight:530px') ;
  if(bceAttrs == null || bceAttrs.length == 0){
    return;
  }
  var groupRow = getFormGroupTbl().getRow();
  for(var i=0;i<bceAttrs.length;i++){
	  getTblFormAttr().newRow();
	  var row2 = getTblFormAttr().getRow();
	  getTblFormAttr().setRowEditSts(row2,true);
	  getTblFormAttr().setValue(row2,"BCE_FRAME_ID","<%=bce_frame_id%>");
	  getTblFormAttr().setValue(row2,"FORM_ID",formId);
	  getTblFormAttr().setValue(row2,"ATTR_ID",bceAttrs[i].attrId);
	  getTblFormAttr().setValue(row2,"ATTR_NAME",bceAttrs[i].attrName);
	  getTblFormAttr().setValue(row2,"MODULE_ID",bceAttrs[i].moduleId);
	  getTblFormAttr().setValue(row2,"IS_NULLABLE",bceAttrs[i].isNullable);
	  getTblFormAttr().setValue(row2,"FIELD_WIDTH",bceAttrs[i].fieldWidth);
	  getTblFormAttr().setValue(row2,"EDIT_TYPE",bceAttrs[i].editType);
	  getTblFormAttr().setValue(row2,"MAX_LENGTH",bceAttrs[i].maxLength);
	  getTblFormAttr().setValue(row2,"RES_SRC",bceAttrs[i].resSrc);
	  getTblFormAttr().setValue(row2,"RES_PARAM",bceAttrs[i].resParam);
	  getTblFormAttr().setValue(row2,"DEFAULT_VALUE",bceAttrs[i].defaultValue);
	  getTblFormAttr().setValue(row2,"VALUE_CLASS",bceAttrs[i].valueClass);
	  if(groupRow != -1){
	  	getTblFormAttr().setValue(row2,"GROUP_ID",getFormGroupTbl().getValue(groupRow,"GROUP_ID"));
	  }
	  getTblFormAttr().setValue(row2,"IS_LOG",1);
	  getTblFormAttr().setValue(row2,"STATE",1);
	  getTblFormAttr().setValue(row2,"IS_VISIBLE",1);
	  getTblFormAttr().setValue(row2,"IS_EDITABLE",1);
	  getTblFormAttr().setCellEditSts(row2,"BCE_FRAME_ID",false);
	  getTblFormAttr().setCellEditSts(row2,"FORM_ID",false);
	  getTblFormAttr().setCellEditSts(row2,"ATTR_ID",false);
  }
}

function modFormAttr(){
  var rows = getTblFormAttr().getSelectedRows();
  if(rows.length == 0){
    alert(crm_i18n_msg("BEC0000016"));
    return;
  }
  for(var i=0;i<rows.length;i++){
  	var row = rows[i];
  	getTblFormAttr().setRowEditSts(row,true);
  	getTblFormAttr().setCellEditSts(row,"BCE_FRAME_ID",false);
  	getTblFormAttr().setCellEditSts(row,"FORM_ID",false);
    getTblFormAttr().setCellEditSts(row,"ATTR_ID",false);	
  }
}

function delFormAttr(){
  var rows = getTblFormAttr().getSelectedRows();
  if(rows.length == 0){
     alert(crm_i18n_msg("BEC0000016"));
    return;
  }
 if(confirm(crm_i18n_msg("BEC0000015"))){
    for(var i=rows.length-1;i>=0;i--){
      getTblFormAttr().deleteRow(rows[i]);
    }
    alert(crm_i18n_msg("BEC0000020"));
  }
}

function saveFormAttr(){
  if(getTblFormAttr().toXmlString() == ""){
    alert(crm_i18n_msg("BEC0000021"));
    return;
  }
  var list = new Array();
  list.push(getTblFormAttr());
  var ud = saveRowSet("<%=request.getContextPath()%>/business/com.ai.bce.web.BceStudioAction?action=commonSaveRowset",list,false);
	if (ud.getValueByName("FLAG") == "ERROR" ) {
		alert(crm_i18n_msg("BEC0000013"));
		return;
	}
	alert(crm_i18n_msg("BEC0000321"));
	refreshAttr();
  if(getTblFormAttr().count()>0){
    for(var i=0;i<getTblFormAttr().count();i++){
      getTblFormAttr().setRowEditSts(i,false);
    }
  }
}
</script>
