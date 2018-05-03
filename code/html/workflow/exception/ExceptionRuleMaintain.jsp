<%@ page contentType="text/html; charset=GBK" %>
<%@page import="com.ai.appframe2.web.HttpUtil"%>
<%@ include file="/workflow/common/WorkflowHead.jsp"%>
<html>
  <head>
  <title>Comframe<i18n:message res="i18n.comframe_resource"  key="comframe.html.workflow.exception.exceptionRuleMaintain11"></i18n:message></title>
  </head>
 <%
 	String descCode = HttpUtil.getAsString(request,"desc");
  %>
  <body>
<ai:contractframe width="100%" title="comframe.html.workflow.exception.exceptionCodeDescRelation76" id="comframe.html.workflow.exception.exceptionCodeDescRelation76" i18nRes="i18n.comframe_resource">
<ai:contractitem></ai:contractitem>
	<ai:table setname="com.ai.comframe.config.set.SETVmExceptionRule" 
				tableid="exceptionRule"
				editable="false" 
				multiselect="true"
				tablemodel="com.ai.appframe2.web.datamodel.MethodModelForService"
				implservice_name="com.ai.comframe.config.service.interfaces.IExceptionConfigSV"
				implservice_querymethod="queryExceptionRule(String Desc)"	
		        needrefresh="true"
		        rowsequence="true"
		        height="380" width="100%"
		        initial="false"
		        footdisplay="none"
		        rowheight="-1"
		        >
		<ai:col fieldname="EXCEPTION_RULE_ID"   visible="false" width="200"/>		
		<ai:col fieldname="EXCEPTION_DESC_CODE"   editable="false" visible="true" width="25%"/>
		<ai:col fieldname="CURRENT_TEMPLATE_TAG"   visible="true" width="25%"/>
		<ai:col fieldname="NEXT_TEMPLATE_TAG"   visible="true" width="25%"/>
		<ai:col fieldname="EXCEPTION_RULE_REMARKS"   visible="true" width="25%"/>	
		</ai:table>
		
</ai:contractframe>	
<div class="area_button">
			<ai:button text="comframe.html.jsv2.udfpage.UserDefineFieldQuery91" i18nRes="i18n.comframe_resource" id="add"  enable="true" onclick="do_add()"/>
			<ai:button text="comframe.html.workflow.exception.exceptionCodeMaintain52" i18nRes="i18n.comframe_resource"  id="edit"  enable="true" onclick="do_edit()"/>
			<ai:button text="comframe.html.jsv2.udfpage.UserDefineFieldQuery97" i18nRes="i18n.comframe_resource"  id="delete"  enable="true" onclick="do_delete()"/>
			<ai:button text="comframe.html.jsv2.udfpage.PageDesign116" i18nRes="i18n.comframe_resource"  id="save"  enable="true" onclick="do_save()"/>	
	   </div>
  </body>
</html>
<script>
window.onload= function(){
	if ('<%=descCode%>'=="noValue"){
		alert(g_I18NMessage("comframe_resources","comframe_html_workflow_exception_exceptionCodeDesc_selectException"));
		parent.switchTab1();
	}
	else 
	do_query('<%=descCode%>');
}


	

function getExcepRuleGird(){
	return g_TableRowSetManager.get("exceptionRule");
}

function do_add(){
	var ExGird=getExcepRuleGird();
	ExGird.newRow(false);
	ExGird.setValue(ExGird.getRow(),"EXCEPTION_DESC_CODE",'<%=descCode%>');
	do_edit();
}

function do_query(DescCode){
	getExcepRuleGird().refresh("&Desc="+DescCode);
	
}
function do_edit(){
	getExcepRuleGird().setEditSts(true);
}
function do_delete(){
	if(!confirm(g_I18NMessage("comframe_resources","comframe_html_workflow_Alarm185"))){
		return;
		}
	var ExGird=getExcepRuleGird();
	var selectedRows=ExGird.getSelectedRows();
	for (var i=selectedRows.length-1;i>=0;i--){
	ExGird.deleteRow(selectedRows[i]);
	}
	do_save();
}


function do_save(){
	var grid=getExcepRuleGird();
if (grid.getTotalRowCount()>0){
		for (var i=0;i<grid.getTotalRowCount();i++)
		{
			if((grid.getValue(i,"EXCEPTION_RULE_REMARKS")=="")&&(grid.getValue(i,"EXCEPTION_DESC_CODE")=="")&&(grid.getValue(i,"CURRENT_WORK_FLOW_CODE")=="")&&(grid.getValue(i,"NEXT_WORK_FLOW_CODE")==""))
			{
				alert(g_I18NMessage("comframe_resources","comframe_html_workflow_exception_exceptionDescMain_noEnptyLineSave"));
				return;
			}
		}
	}
	var list = new Array(); 
	list.push(g_TableRowSetManager.get("exceptionRule"));
	var url = _gModuleName+"/business/com.ai.comframe.config.action.ExceptionAction?action=SaveExRule";
	var rtn=saveRowSet(url,list,false,false);
	getExcepRuleGird().setEditSts(false);
}
</script>
