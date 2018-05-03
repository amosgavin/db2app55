<%@ page contentType="text/html; charset=GBK" %>
<%@ include file="/workflow/common/WorkflowHead.jsp"%>
<html>
<head>
  <title><i18n:message res="i18n.comframe_resource"  key="comframe.html.workflow.Holiday11"></i18n:message></title>
</head>
<body>
<ai:contractframe width="100%" i18nRes="i18n.comframe_resource"  title="comframe.html.workflow.Holiday28" id="holiday" allowcontract="false">
<ai:contractitem></ai:contractitem>
<ai:table  tableid="Holiday" setname="com.ai.comframe.config.set.SETVmHoliday"
	 tablemodel="com.ai.appframe2.web.datamodel.MethodModelForService"
	 implservice_name="com.ai.comframe.config.service.interfaces.IVmAlarmConfigSV"
	 implservice_querymethod="loadAllHolidays()"
	 needrefresh="true" multiselect="true"  
	 initial="true" width="100%" height="400" footdisplay="none">
	<ai:col fieldname="HOLIDAY" width="99%"/>
</ai:table>
</ai:contractframe>
<div class="area_button">
  <ai:button id="btnAdd" text="comframe.html.workflow.Alarm28" i18nRes="i18n.comframe_resource"	onclick="qryHoliday()"/>		  
  <ai:button id="btnAdd" text="comframe.html.workflow.Alarm77" i18nRes="i18n.comframe_resource"	onclick="add()"/>		  
  <ai:button id="btnEdit" text="comframe.html.workflow.Alarm79" i18nRes="i18n.comframe_resource" onclick="dele()"/>	  
  <ai:button id="btnSave" text="comframe.html.workflow.Alarm80" i18nRes="i18n.comframe_resource" onclick="save()"/>		  
</div>
</body>
</html>
<script language="javascript">
function getHolidayTable(){
	 return g_TableRowSetManager.get("Holiday");
}


function qryHoliday(){
		getHolidayTable().refresh();
		 if(getHolidayTable().count() == 0){
	    	alert(g_I18NMessage("comframe_resources","comframe_html_workflow_Alarm123"));	 	 }
 	 
 	 
}
function save(){
  if(!confirm(g_I18NMessage("comframe_resources","comframe_html_workflow_Alarm143"))){	  return;
	}
	var grid=getHolidayTable();
	if (grid.getTotalRowCount()>0){
		for (var i=0;i<grid.getTotalRowCount();i++)
		{
			if(grid.getValue(i,"HOLIDAY")==""){
				alert(g_I18NMessage("comframe_resources","comframe_html_workflow_Holiday69"));				return;
			}
		}
	}
	var list = new Array(); 
	list.push(getHolidayTable());
	var url = _gModuleName+"/business/com.ai.comframe.config.action.WorkflowAction?action=saveHolidayConfig";
	var rtn=saveRowSet(url,list,false,false);
	getHolidayTable().setEditSts(false);
	qryHoliday();
	//alert(g_I18NMessage("comframe_resources","comframe_html_workflow_Alarm162"));
}
function add(){
	getHolidayTable().newRow(false);
	edit();
}
function edit(){
	getHolidayTable().setEditSts(true);
}

function dele(){
	var HolidayGird=getHolidayTable();
  var selectedRows=HolidayGird.getSelectedRows();
	if(selectedRows.length == 0){
    alert(g_I18NMessage("comframe_resources","comframe_html_workflow_Alarm182"));    return;
  }
	if(!confirm(g_I18NMessage("comframe_resources","comframe_html_workflow_Alarm185"))){	  return;
	}
	for (var i=selectedRows.length-1;i>=0;i--){
	  HolidayGird.deleteRow(selectedRows[i]);
	}
}
function clear(){
	var HolidayGird=getHolidayTable();
	for (var i=HolidayGird.getTotalRowCount()-1;i>=0;i--){
		HolidayGird.deleteRow(i);
	}
}
</script>