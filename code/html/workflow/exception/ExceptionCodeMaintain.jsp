<%@ page contentType="text/html; charset=GBK" %>
<%@ include file="/workflow/common/WorkflowHead.jsp"%>
<html>
  <head>
  <title>Comframe<i18n:message res="i18n.comframe_resource"  key="comframe.html.workflow.exception.exceptionCodeMaintain5"></i18n:message></title>
  </head>

  <body>
<ai:contractframe width="100%" title="comframe.html.jsv2.udfpage.UserDefineFieldQuery34" id="comframe.html.jsv2.udfpage.UserDefineFieldQuery34" i18nRes="i18n.comframe_resource">
	<ai:contractitem>
	<div class="t-bot-mc-button">
		<ai:button i18nRes="i18n.comframe_resource" text="comframe.html.jsv2.udfpage.UserDefineFieldQuery53" id="query"  enable="true" onclick="do_query()"/>
	</div>
	</ai:contractitem>
	<table width="98%" cellspacing="2" cellpadding="1" border="0">
		<tr>
			<td class="td_font"><i18n:message res="i18n.comframe_resource"  key="comframe.html.workflow.exception.exceptionCodeDescRelation47"></i18n:message>:</td>
			<td><input type="text" id="code" width="150"></td>
			<td class="td_font"><i18n:message res="i18n.comframe_resource"  key="comframe.html.workflow.WorkflowInst21"></i18n:message>:</td>
			<td><input type="text" id="WFobject" width="150"></td>
		</tr>
	</table>
</ai:contractframe>
<ai:contractframe width="100%" title="comframe.html.workflow.exception.exceptionCodeDescRelation76" id="comframe.html.workflow.exception.exceptionCodeDescRelation76" i18nRes="i18n.comframe_resource">
<ai:contractitem></ai:contractitem>				
<ai:table setname="com.ai.comframe.config.set.SETVmExceptionCode" 
				tableid="exceptionCode"
				editable="false" 
				multiselect="true"
				tablemodel="com.ai.appframe2.web.datamodel.MethodModelForService"
				implservice_name="com.ai.comframe.config.service.interfaces.IExceptionConfigSV"
				implservice_querymethod="queryExceptionCode(String workFlowType,String ExCode,int $STARTROWINDEX, int $ENDROWINDEX)"
				implservice_countmethod="queryExceptionCodeCount(String workFlowType,String ExCode)"	
		        needrefresh="true"
		        rowsequence="true"
		        height="300" width="100%"
		        initial="false"
		        footdisplay="block"
		        rowheight="-1"
                pagesize="20"
		        >
		
		<ai:col fieldname="EXCEPTION_CODE"  visible="true" width="30%"/>
		<ai:col fieldname="EXCEPTION_NAME"   visible="true" width="40%"/>
		<ai:col fieldname="WORKFLOW_OBJECT_TYPE"   visible="true" width="20%"/>
		<ai:col fieldname="STATE"   visible="true" width="10%"/>
		</ai:table>	
</ai:contractframe>
		<div class="area_button">
				<ai:button text="comframe.html.jsv2.udfpage.UserDefineFieldQuery91" i18nRes="i18n.comframe_resource" id="add"  enable="true" onclick="do_add()"/>
				<ai:button i18nRes="i18n.comframe_resource" text="comframe.html.workflow.exception.exceptionCodeMaintain52" id="edit"  enable="true" onclick="do_edit()"/>
				<ai:button text="comframe.html.jsv2.udfpage.UserDefineFieldQuery97" i18nRes="i18n.comframe_resource" id="delete"  enable="true" onclick="do_delete()"/>
				<ai:button i18nRes="i18n.comframe_resource" text="comframe.html.jsv2.udfpage.PageDesign116" id="save"  enable="true" onclick="do_save()"/>		
		</div>
  </body>
</html>
<script>
window.onload= function(){
	//g_getListBox("WorkFlowTypeDs").addItem("","");
	//g_getListBox("CodeDs").addItem("","");
}

function getExcepCodeGird(){
	return g_TableRowSetManager.get("exceptionCode");
}

function do_add(){
	var ExGird=getExcepCodeGird();
	ExGird.newRow(false);
	do_edit();
}

function do_query(){
	var workFlowType=document.getElementById("WFobject").value;
	var ExCode=document.getElementById("code").value;
	getExcepCodeGird().refresh("&workFlowType="+workFlowType+"&ExCode="+ExCode);
}
function do_edit(){
	getExcepCodeGird().setEditSts(true);
}
function do_delete(){
	if(!confirm(g_I18NMessage("comframe_resources","comframe_html_workflow_Alarm185"))){
	return;
	}
	var ExGird=getExcepCodeGird();
	var selectedRows=ExGird.getSelectedRows();
    
	for (var i=selectedRows.length-1;i>=0;i--){
	//alert(selectedRows[i]);
	ExGird.deleteRow(selectedRows[i]);
	}
	do_save();
}


function do_save(){
//var a=g_TableRowSetManager.get("exceptionCode").getTotalRowCount();
//var a=g_TableRowSetManager.get("exceptionCode").count();
//alert(a);
	var grid=getExcepCodeGird();
	if (grid.getTotalRowCount()>0){
		for (var i=0;i<grid.getTotalRowCount();i++)
		{
		if(grid.getValue(i,"EXCEPTION_CODE")==""){
			alert(g_I18NMessage("comframe_resources","comframe_html_workflow_exception_exceptionDescMain_noNullException"));
			return;
		}
			if((grid.getValue(i,"EXCEPTION_CODE")=="")&&(grid.getValue(i,"EXCEPTION_NAME")=="")&&(grid.getValue(i,"WORKFLOW_OBJECT_TYPE_ID")=="")&&(grid.getValue(i,"STATE")==""))
			{
				alert(g_I18NMessage("comframe_resources","comframe_html_workflow_exception_exceptionDescMain_noEnptyLineSave"));
				return;
			}
		}
	}
	var list = new Array(); 
	list.push(g_TableRowSetManager.get("exceptionCode"));
	var url = _gModuleName+"/business/com.ai.comframe.config.action.ExceptionAction?action=SaveExCode";
	var rtn=saveRowSet(url,list,false,false);
	getExcepCodeGird().setEditSts(false);
}
</script>
