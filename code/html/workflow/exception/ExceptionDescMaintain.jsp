<%@ page contentType="text/html; charset=GBK" %>
<%@ include file="/workflow/common/WorkflowHead.jsp"%>
<html>
  <head>
  <title>Comframe<i18n:message res="i18n.comframe_resource"  key="comframe.html.workflow.exception.exceptionDescMaintain9"></i18n:message></title>  
</head>  
  <body>
  <ai:contractframe width="100%" title="comframe.html.jsv2.udfpage.UserDefineFieldQuery34" id="comframe.html.jsv2.udfpage.UserDefineFieldQuery34" i18nRes="i18n.comframe_resource">
	  <ai:contractitem>
	  <div class="t-bot-mc-button">
	  <ai:button text="comframe.html.jsv2.udfpage.UserDefineFieldQuery53" i18nRes="i18n.comframe_resource" id="query"  enable="true" onclick="do_query()"/>
	 </div>
	  </ai:contractitem>
	  <table style="width: 98%;" cellspacing="2" cellpadding="1" border="0">
	  	<tr>
	  	 <td class="td_font"><i18n:message res="i18n.comframe_resource"  key="comframe.html.workflow.exception.exceptionDescMaintain23"></i18n:message>:</td>
	  	 <td><input type="text"  id="Desc"  width="150"></td>
	  	</tr>
	  </table>
  </ai:contractframe>
<ai:contractframe width="100%" title="comframe.html.workflow.exception.exceptionCodeDescRelation76" id="comframe.html.workflow.exception.exceptionCodeDescRelation76" i18nRes="i18n.comframe_resource">
<ai:contractitem></ai:contractitem>
	<ai:table setname="com.ai.comframe.config.set.SETVmExceptionDesc" 
				tableid="exceptionDesc"
				editable="false" 
				multiselect="false"
				tablemodel="com.ai.appframe2.web.datamodel.MethodModelForService"
				implservice_name="com.ai.comframe.config.service.interfaces.IExceptionConfigSV"
				implservice_querymethod="queryExceptionDesc(String descType,int $STARTROWINDEX, int $ENDROWINDEX))"
				implservice_countmethod="queryExceptionDescCount(String descType)"		
		        needrefresh="true"
		        rowsequence="true"
		        height="300" width="100%"
		        initial="false"
		        footdisplay="true"
		        rowheight="-1"
		        pagesize="20"            
		        >
		<ai:col fieldname="EXCEPTION_DESC_CODE"  visible="true" width="33%"/>
		<ai:col fieldname="EXCEPTION_DESC_NAME"   visible="true" width="33%"/>	
		<ai:col fieldname="EXCEPTION_DESC_TYPE"   visible="true" width="33%"/>		
		</ai:table>	
	
</ai:contractframe>
 <div class="area_button">
		<ai:button text= "comframe.html.jsv2.udfpage.UserDefineFieldQuery91" i18nRes="i18n.comframe_resource" id="add"  enable="true" onclick="do_add()"/>
		<ai:button text="comframe.html.workflow.exception.exceptionCodeMaintain52" i18nRes="i18n.comframe_resource"  id="edit"  enable="true" onclick="do_edit()"/>
		<ai:button text="comframe.html.jsv2.udfpage.UserDefineFieldQuery97" i18nRes="i18n.comframe_resource"  id="delete"  enable="true" onclick="do_delete()"/>
		<ai:button text="comframe.html.jsv2.udfpage.PageDesign116"  i18nRes="i18n.comframe_resource" id="save"  enable="true" onclick="do_save()"/>
	</div>
  </body>
</html>
<script>

function queryDescCode(){

		var selectedrows=getExcepDescGird().getRow();
		if (selectedrows<0)
		return "noValue";
		else
	return	getExcepDescGird().getValue(selectedrows,"EXCEPTION_DESC_CODE");
		
}
function queryDescName(){

		var selectedrows=getExcepDescGird().getSelectedRows();
		if (selectedrows[0]==null)
		return "noValue";
		else
	return	getExcepDescGird().getValue(selectedrows[0],"EXCEPTION_DESC_NAME");
		
}



function getExcepDescGird(){
	return g_TableRowSetManager.get("exceptionDesc");
}

function do_add(){
	var ExGird=getExcepDescGird();
	ExGird.newRow(false);

	do_edit();
}

function do_query(){
	var descType=document.getElementById("Desc");
	getExcepDescGird().refresh("&descType="+descType.value);
	
}
function do_edit(){
	getExcepDescGird().setEditSts(true);
}
function do_delete(){
if(!confirm(g_I18NMessage("comframe_resources","comframe_html_workflow_Alarm185"))){
	return;
	}
	var ExGird=getExcepDescGird();
	var selectedRows=ExGird.getSelectedRows();
	for (var i=selectedRows.length-1;i>=0;i--){
		ExGird.deleteRow(selectedRows[i]);
	}
	do_save();
}


function do_save(){
var grid=getExcepDescGird();
if (grid.getTotalRowCount()>0){
		for (var i=0;i<grid.getTotalRowCount();i++)
		{
			if(grid.getValue(i,"EXCEPTION_DESC_CODE")==""){
				alert(g_I18NMessage("comframe_resources","comframe_html_workflow_exception_exceptionDescMain_noNullException"));
				return;
			}
			if((grid.getValue(i,"EXCEPTION_DESC_CODE")=="")&&(grid.getValue(i,"EXCEPTION_DESC_NAME")==""))
			{
				alert(g_I18NMessage("comframe_resources","comframe_html_workflow_exception_exceptionDescMain_noEnptyLineSave"));
				return;
			}
		}
	}
	var list = new Array(); 
	list.push(g_TableRowSetManager.get("exceptionDesc"));
	var url = _gModuleName+"/business/com.ai.comframe.config.action.ExceptionAction?action=SaveExDesc";

	var rtn=saveRowSet(url,list,false,false);
	
	getExcepDescGird().setEditSts(false);

}
</script>
