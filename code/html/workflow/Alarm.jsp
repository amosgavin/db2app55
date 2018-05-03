<%@ page contentType="text/html; charset=GBK" %>
<%@ include file="/workflow/common/WorkflowHead.jsp"%>
<html>
<head>
  <title><i18n:message res="i18n.comframe_resource"  key="comframe.html.workflow.Alarm11"></i18n:message></title></head>
<ai:contractframe width="100%" title="comframe.html.workflow.Alarm16" id="comframe.html.workflow.Alarm16" i18nRes="i18n.comframe_resource">
<ai:contractitem>
<div class="t-bot-mc-button">
<ai:button id="btnQry" text="comframe.html.workflow.Alarm28" i18nRes="i18n.comframe_resource" onclick="qry()"/>
</div>
</ai:contractitem>
  <ai:dbform formid="frmQry" setname="com.ai.comframe.config.set.SETVmTemplate" initial="false">
  <table width="98%" cellspacing="2" cellpadding="1" border="0">
    <tr>
      <td class="td_font"><i18n:message res="i18n.comframe_resource"  key="comframe.html.workflow.Alarm22"></i18n:message>:</td>      
      <td><ai:dbformfield formid="frmQry" fieldname="TEMPLATE_TAG" width="150" /></td>
      <td class="td_font"><i18n:message res="i18n.comframe_resource"  key="comframe.html.workflow.Alarm83"></i18n:message>:</td>      
      <td><ai:dbformfield formid="frmQry" fieldname="VALID_DATE" width="150" />
      <td class="td_font"><i18n:message res="i18n.comframe_resource"  key="comframe.html.workflow.Alarm84"></i18n:message>:</td>
      <td><ai:dbformfield formid="frmQry" fieldname="EXPIRE_DATE" width="150" /></td>
      </tr>
      <tr>
      <td class="td_font"><i18n:message res="i18n.comframe_resource"  key="html.workflow.alarm_queue"></i18n:message>:</td>      
      <td><ai:dbformfield formid="frmQry" fieldname="QUEUE_ID" width="150" /></td>
      </tr>
  </table>
  </ai:dbform>
</ai:contractframe>
<ai:contractframe i18nRes="i18n.comframe_resource" title="comframe.html.workflow.Alarm85" id="" allowcontract="false" width="100%">
<ai:contractitem></ai:contractitem>
<ai:table  tableid="tblTemplate" setname="com.ai.comframe.config.set.SETVmTemplate"
			    tablemodel="com.ai.appframe2.web.datamodel.MethodModelForService"
			    implservice_name="com.ai.comframe.config.service.interfaces.IWorkflowConsoleSV"
			    implservice_querymethod="getPublishedTemplates(String queueID,String taskTag,String sValidDate,String eValidDate,int $STARTROWINDEX,int $ENDROWINDEX)"
			    implservice_countmethod="getPublishedTemplatesCount(String queueID,String taskTag,String sValidDate,String eValidDate)"
			    needrefresh="true" multiselect="false" editable="false" ondbclick="qryAlarm"  onresize="false"
			    rowheight="-1" initial="false" width="100%" height="150" footdisplay="true" rowsequence="true" pagesize="20">
			    <ai:col fieldname="TEMPLATE_TAG" width="150"/>
			    <ai:col fieldname="TEMPLATE_TYPE" width="80"/>
			    <ai:col fieldname="LABEL" width="200"/>
			  	<ai:col fieldname="VALID_DATE" width="200"/>
			  	<ai:col fieldname="EXPIRE_DATE" width="200"/>
			  	<ai:col fieldname="CREATE_STAFF" width="100"/>
			  	<ai:col fieldname="CREATE_DATE" width="200"/>
			  	<ai:col fieldname="STATE" width="100"/>
			  	<ai:col fieldname="STATE_DATE" width="200"/>
				</ai:table>
</ai:contractframe>	
<ai:contractframe i18nRes="i18n.comframe_resource" title="comframe.html.workflow.Alarm86" id="" allowcontract="false" width="100%">
<ai:contractitem>
	<div class="t-bot-mc-word"><span class="font_red"><i18n:message res="i18n.comframe_resource"  key="comframe.html.workflow.Alarm87"></i18n:message></span><i18n:message res="i18n.comframe_resource"  key="comframe.html.workflow.Alarm82"></i18n:message></div>
</ai:contractitem>			
    <ai:table  tableid="Alarm" setname="com.ai.comframe.config.set.SETVmAlarm"
	    tablemodel="com.ai.appframe2.web.datamodel.MethodModelForService"
	    implservice_name="com.ai.comframe.config.service.interfaces.IWorkflowConsoleSV"
	    implservice_querymethod="getAlarmConfigs(String templateTag)"
	    needrefresh="true" multiselect="true" editable="false"  
	    rowheight="-1" initial="false" width="100%" height="150" footdisplay="none" rowsequence="true">
	    <ai:col fieldname="ALARM_CONFIG_ID" width="100" title="comframe.html.workflow.Alarm65" i18nRes="i18n.comframe_resource" visible="false"/>			    
	    <ai:col fieldname="TASK_TAG" width="100"  title="comframe.html.workflow.Alarm68" i18nRes="i18n.comframe_resource"/>	
	    <ai:col fieldname="TEMPLATE_TAG" width="100"  visible="false"/>		  	
	    <ai:col fieldname="DURATION_TIME_METHOD" width="300"  title="comframe.html.workflow.Alarm69" i18nRes="i18n.comframe_resource"/>			  	
	    <ai:col fieldname="ALARM_TIME_METHOD" width="300"  title="comframe.html.workflow.Alarm70" i18nRes="i18n.comframe_resource"/>			  	
	    <ai:col fieldname="ALARM_DEAL_METHOD" width="300"  title="comframe.html.workflow.Alarm71" i18nRes="i18n.comframe_resource"/>			  	
	    <ai:col fieldname="STATE" editable="false" width="100"/>
	  	<ai:col fieldname="IS_HOLIDAY" width="120"/>
		</ai:table>
</ai:contractframe>
<div class="area_button">
		  <ai:button id="btnAdd" text="comframe.html.workflow.Alarm77" i18nRes="i18n.comframe_resource" onclick="add()"/>	 
		  <ai:button id="btnEdit" text="comframe.html.workflow.Alarm78" i18nRes="i18n.comframe_resource" onclick="edit()"/>	  
		  <ai:button id="btnDel" text="comframe.html.workflow.Alarm79" i18nRes="i18n.comframe_resource" onclick="dele()"/>	  
		  <ai:button id="btnSave" text="comframe.html.workflow.Alarm80" i18nRes="i18n.comframe_resource" onclick="save()"/>		  
</div>		  

</html>
<script language="javascript">
function getForm(){
  return g_FormRowSetManager.get("frmQry");
}
function getTable(){
  return g_TableRowSetManager.get("tblTemplate");
}
function getAlarmTable(){
	 return g_TableRowSetManager.get("Alarm");
}
function qry(){
  var templateId = getForm().getValue("TEMPLATE_ID");
  var taskTag = getForm().getValue("TEMPLATE_TAG");
  var sValidDate = getForm().getValue("VALID_DATE");
  var eValidDate = getForm().getValue("EXPIRE_DATE");
  
  if(!g_IsDateTime(sValidDate)){
    alert(g_I18NMessage("comframe_resources","comframe_html_monitor_analyse_AppframeStatSelectByServerId248"));    return;
  }
  if(!g_IsDateTime(eValidDate)){
    alert(g_I18NMessage("comframe_resources","comframe_html_monitor_analyse_AppframeStatSelectByServerId254"));    return;
  }
  var compare =g_CompareDate(sValidDate,eValidDate);
	if ((sValidDate!="")&&(eValidDate!="")&&(compare!=-1)){
		alert(g_I18NMessage("comframe_resources","comframe_html_workflow_Alarm114"));		return;
	}
  if(templateId == null || templateId == ""){
    templateId = "0";
  }
  getTable().refresh("templateId="+templateId+"&taskTag="+taskTag+"&sValidDate="+sValidDate+"&eValidDate="+eValidDate);
  
  if(getTable().count() == 0){
    alert(g_I18NMessage("comframe_resources","comframe_html_workflow_Alarm123"));  }
  clear();
}

function qryAlarm(){

	var row = getTable().getRow();
	  if(row == -1){
	    	return;
	  }
 	 else{
		getAlarmTable().refresh("templateTag="+getTable().getValue(row,"TEMPLATE_TAG"));
		 if(getAlarmTable().count() == 0){
	    	alert(g_I18NMessage("comframe_resources","comframe_html_workflow_Alarm123"));	 	 }
 	 }
 	 
}
function save(){
  if(!confirm(g_I18NMessage("comframe_resources","comframe_html_workflow_Alarm143"))){	  
  		return;
	}
	var grid=getAlarmTable();
	if (grid.getTotalRowCount()>0){
		for (var i=0;i<grid.getTotalRowCount();i++)
		{
			if(grid.getValue(i,"TEMPLATE_TAG")==""){
				alert(g_I18NMessage("comframe_resources","comframe_html_workflow_Alarm151"));
				return;
			}
		}
	}
	var list = new Array(); 
	list.push(getAlarmTable());
	var url = _gModuleName+"/business/com.ai.comframe.config.action.WorkflowAction?action=saveAlarmConfig";
	var rtn=saveRowSet(url,list,false,false);
	getAlarmTable().setEditSts(false);
	clear();
	alert(g_I18NMessage("comframe_resources","comframe_html_workflow_Alarm162"));
}
function add(){
	getAlarmTable().newRow(false);
	var templateRow = getTable().getRow();
	var alarmRow = getAlarmTable().getRow();
	if(templateRow != -1){
	  getAlarmTable().setValue(alarmRow,"TEMPLATE_TAG",getTable().getValue(templateRow,"TEMPLATE_TAG"));
	}
	edit();
}
function edit(){
	getAlarmTable().setEditSts(true);
}

function dele(){
	var AlarmGird=getAlarmTable();
	var selectedRows=AlarmGird.getSelectedRows();
  if(selectedRows.length == 0){
    alert(g_I18NMessage("comframe_resources","comframe_html_workflow_Alarm182"));    return;
  }
	if(!confirm(g_I18NMessage("comframe_resources","comframe_html_workflow_Alarm185"))){	  return;
	}
  
	for (var i=selectedRows.length-1;i>=0;i--){
    AlarmGird.deleteRow(selectedRows[i]);
	}
}

function clear(){
	var AlarmGird=getAlarmTable();
		for (var i=AlarmGird.getTotalRowCount()-1;i>=0;i--){
			AlarmGird.deleteRow(i);
		}
}
</script>