<%@ page contentType="text/html; charset=GBK"%>
<%@ include file="/workflow/common/WorkflowHead.jsp"%>
<html>
<head>
<title><i18n:message res="i18n.comframe_resource"  key="comframe.html.workflow.StartWorkFlow10"></i18n:message></title>
</head>
<body onload="init()">
<ai:contractframe title=""  width="100%" id="" allowcontract="false">
<ai:contractitem></ai:contractitem>
		<ai:dbform formid="startworkflowform"
			setname="com.ai.comframe.config.set.SETVmWF" initial="false" onvalchange="valChange">
			<table style="width: 98%" cellspacing="2" cellpadding="1" border="0" >
				<tr>
					<td class="td_font">
					<i18n:message res="i18n.comframe_resource"  key="comframe.html.workflow.ManualStartExceptionWorkFlow24"></i18n:message>:</td>
					<td><ai:dbformfield fieldname="QUEUE_ID"
						formid="startworkflowform" width="150" /></td>
					<td class="td_font" >
					<i18n:message res="i18n.comframe_resource"  key="comframe.html.workflow.ManualStartExceptionWorkFlow40"></i18n:message>:</td>
					<td  colspan="3"><ai:dbformfield fieldname="TEMPLATE_TAG" formid="startworkflowform" width="595"/></td>
				</tr>

				<tr>
					<td class="td_font">
					<i18n:message res="i18n.comframe_resource"  key="comframe.html.workflow.ManualStartExceptionWorkFlow28"></i18n:message>:</td>
					<td><ai:dbformfield fieldname="WORKFLOW_OBJECT_TYPE"
						formid="startworkflowform" width="150" /></td>
					<td class="td_font"><i18n:message res="i18n.comframe_resource"  key="comframe.html.workflow.ManualStartExceptionWorkFlow32"></i18n:message>:</td>
					<td><ai:dbformfield fieldname="WORKFLOW_OBJECT_ID"
						formid="startworkflowform" width="150" /></td>
					<td class="td_font">
					<i18n:message res="i18n.comframe_resource"  key="html.workflow.startWorkflow_area"></i18n:message>:</td>
					<td><ai:dbformfield fieldname="REGION_ID"
						formid="startworkflowform" width="150" />
						</td>

				<tr style="display: none">
					<td><i18n:message res="i18n.comframe_resource"  key="comframe.html.workflow.ManualStartExceptionWorkFlow53"></i18n:message>:</td>
					<td><ai:dbformfield fieldname="VARS"
						formid="startworkflowform" width="300" /></td>
				</tr>
			</table>
		</ai:dbform>
		</ai:contractframe>
		<ai:contractframe title="comframe.html.workflow.GoBackTask38" id="comframe.html.workflow.GoBackTask38" width="100%" i18nRes="i18n.comframe_resource" allowcontract="false">
		<ai:contractitem></ai:contractitem>
		<ai:table tableid="varTable" initial="false"
					setname="com.ai.comframe.config.set.SETVmWFAttr"
					tablemodel="com.ai.appframe2.web.datamodel.MethodModelForService"
					implservice_name="com.ai.comframe.config.service.interfaces.IWorkflowConsoleSV"
					implservice_querymethod="getTemplateVars(String templateCode)"
					width="100%" height="300" needrefresh="true" footdisplay="true"
					multiselect="false" editable="true">
					<ai:col fieldname="ATTR_NAME" width="33%" visible="true"
						editable="false" />
					<ai:col fieldname="ATTR_TYPE" width="33%" visible="true"
						editable="false" />
					<ai:col fieldname="ATTR_VALUE" width="34%" visible="true"
						editable="true" />
				</ai:table>
		</ai:contractframe>
		<div class="area_button">
		<ai:button i18nRes="i18n.comframe_resource"
					id="btnsave"
					text="html.workflow.startworkflow_createWorkflow" onclick="saveFunc()" />
		</div>
</body>
</html>


<SCRIPT LANGUAGE="JavaScript">
function getStartWorkFlowForm(){
	return g_FormRowSetManager.get("startworkflowform");
}
function getVarTable(){
	return g_TableRowSetManager.get("varTable");
}
function init(){
  var template =getStartWorkFlowForm().getValue("TEMPLATE_TAG");
  if(template != null && template != ""){
    getStartWorkFlowForm().setValue("TEMPLATE_TAG",template);
    getVarTable().refresh("templateCode="+template);
  }
  getStartWorkFlowForm().setFocus("WORKFLOW_OBJECT_TYPE");
  getStartWorkFlowForm().setFocus("WORKFLOW_OBJECT_ID");
}

function valChange(col){
  if(col=="TEMPLATE_TAG"){
  	getVarTable().refresh("templateCode="+getStartWorkFlowForm().getValue("TEMPLATE_TAG"));
  }
}



function saveFunc(){
  var count = getVarTable().count();
  var vars = "";
  for(var i=0;i<count;i++){
    var name = getVarTable().getValue(i,"ATTR_NAME");
    var value = getVarTable().getValue(i,"ATTR_VALUE");
    vars += name+":"+value+"#";
  }
  
  getStartWorkFlowForm().setValue("VARS",vars);
  
    var list=new Array();
    list.push(getStartWorkFlowForm());
    var rtn = saveRowSet('<%=request.getContextPath()%>/business/com.ai.comframe.config.action.WorkflowAction?action=startWorkflow'+getCenterStr(getStartWorkFlowForm().getValue("REGION_ID")),list, false);
		ret = rtn.getValueByName("FLAG");
		if (ret == "INFO") {
			window.returnValue = 1;
			window.close();
		}
	}

	function cancelFunc() {
		var template = getStartWorkFlowForm().getValue("TEMPLATE_TAG");
		getVarTable().refresh("templateCode=" + template);

		getStartWorkFlowForm().setValue(
				"WORKFLOW_OBJECT_ID", "");
	}
</SCRIPT>
