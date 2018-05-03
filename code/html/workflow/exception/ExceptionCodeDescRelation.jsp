<%@ page contentType="text/html; charset=GBK" %>
<%@page import="com.ai.appframe2.web.HttpUtil"%>
<%@ include file="/workflow/common/WorkflowHead.jsp"%>
<%
	String descCode = HttpUtil.getAsString(request,"desc2");
 %>
<html>
  <head>
  <title>Comframe<i18n:message res="i18n.comframe_resource"  key="comframe.html.workflow.exception.exceptionCodeDescRelation5"></i18n:message></title>  
  <script src="<%=request.getContextPath()%>/jsv2/TabPage.js"></script>
<script src="<%=request.getContextPath()%>/jsv2/HtmlParameter.js"></script>
<script type="text/javascript">  
  function getExcepCodeGird(){
	return g_TableRowSetManager.get("exceptionCode");
}
  function query(){
	  var Codeb=document.getElementById("Codeb").value;
	  var CodeName=document.getElementById("CodeName").value;
	  getExcepCodeGird().refresh("&Code="+Codeb+"&CodeName="+CodeName);
  
  }
  function confirm(){
	  var gridCode=getExcepCodeGird();
	  var selectedRows=gridCode.getSelectedRows();
	  var UnionGrid=getExcepRelationUnionGird();
	 for (var i=0;i<selectedRows.length;i++){
	 UnionGrid.newRow();
	 UnionGrid.setValue(UnionGrid.getRow(),"EXCEPTION_CODE",gridCode.getValue(selectedRows[i],"EXCEPTION_CODE"));
	UnionGrid.setValue(UnionGrid.getRow(),"EXCEPTION_DESC_CODE",parseHtmlParameter(document.location.toString()).getParameter("desc2"));
	 }
  }

  </script>
  </head>  
  <body>


<ai:contractframe width="100%" title="comframe.html.workflow.exception.exceptionCodeDescRelation76" id="comframe.html.workflow.exception.exceptionCodeDescRelation76" i18nRes="i18n.comframe_resource">
<ai:contractitem></ai:contractitem>
		<ai:table setname="com.ai.comframe.config.set.SETVmExcepitonCodeDescRelat" 
				tableid="exceptionRelationUnion"
				editable="false" 
				multiselect="true"
				tablemodel="com.ai.appframe2.web.datamodel.MethodModelForService"
				implservice_name="com.ai.comframe.config.service.interfaces.IExceptionConfigSV"
				implservice_querymethod="queryExceptionRelation(String DescCode)"	
		        needrefresh="true"
		        rowsequence="true"
		        height="380" width="100%"
		        initial="false"
		        footdisplay="none"
		        rowheight="-1"
            
		        >
		
		<ai:col fieldname="EXCEPTION_CODE"  visible="true" width="50%"/>
		<ai:col fieldname="EXCEPTION_DESC_CODE"   visible="true" width="50%"/>
		</ai:table>	
		
</ai:contractframe>
<div class="area_button">
		<ai:button text="comframe.html.workflow.exception.exceptionCodeDescRelation79" i18nRes="i18n.comframe_resource"  enable="true" onclick="openHidden()"/>		
		<ai:button text="comframe.html.jsv2.udfpage.UserDefineFieldQuery97" i18nRes="i18n.comframe_resource" id="delete" enable="true" onclick="delete1()"/>				
		<ai:button text="comframe.html.workflow.exception.exceptionCodeDescRelation81"  i18nRes="i18n.comframe_resource"  enable="true" onclick="rel()"/>
	</div>
  </body>
</html>
<script>
window.onload= function(){
	if ("<%=descCode%>"=="noValue"){
		alert(g_I18NMessage("comframe_resources","comframe_html_workflow_exception_exceptionCodeDesc_selectException"));
		parent.switchTab1();
	}
	else 
		queryByDescCode("<%=descCode%>");
		
}

function openHidden(){
var rtn=new Array();
rtn=window.showModalDialog("QueryExcepCode.jsp",null,'status:no;dialogWidth:500px;dialogHeight:400px');
	var UnionGrid=getExcepRelationUnionGird();
	for (var i=0;i<rtn.length;i++){
		UnionGrid.newRow(false);
	 	UnionGrid.setValue(UnionGrid.getRow(),"EXCEPTION_CODE",rtn[i]);
		UnionGrid.setValue(UnionGrid.getRow(),"EXCEPTION_DESC_CODE",parseHtmlParameter(document.location.toString()).getParameter("desc2"));
		UnionGrid.setValue(UnionGrid.getRow(),"EXCEPTION_DESC_NAME",parseHtmlParameter(document.location.toString()).getParameter("descname"));
	}

}

function getExcepRelationUnionGird(){
	return g_TableRowSetManager.get("exceptionRelationUnion");
}

function getExcepRelGird(){
	return g_TableRowSetManager.get("exceptionRelation");
}

function rel(){
	var gridCode=getExcepRelationUnionGird();
	var selectedRows=gridCode.getSelectedRows();
	if (selectedRows.length<1) 
	{
		alert(g_I18NMessage("comframe_resources","comframe_html_workflow_exception_exceptionCodeDesc_selectRelLine"));
		return;
	}
	
	var desc=gridCode.getValue(selectedRows[0],"EXCEPTION_DESC_CODE");
	if (desc=="noValue"){
	alert(g_I18NMessage("comframe_resources","comframe_html_workflow_exception_exceptionCodeDesc_selectExceptionFromTable"));
	top.switchTab1();
	return;
	}
	var url = _gModuleName+"/business/com.ai.comframe.config.action.ExceptionAction?action=SaveExUnion";
	url+="&length="+selectedRows.length;
	url+="&desc="+desc+"&isDelete=false";
	for (var i=0;i<selectedRows.length;i++){
	url+="&para"+i+"="+gridCode.getValue(selectedRows[i],"EXCEPTION_CODE");
	}
	var rt=PostInfo(url);
	alert(rt.getValueByName("MESSAGE"));
	queryByDescCode(_desc2);
}


function queryByDescCode(DescCode){
	getExcepRelationUnionGird().refresh("&DescCode="+DescCode);

}


function delete1(){
	var gridCode=getExcepRelationUnionGird();
	var selectedRows=gridCode.getSelectedRows();
	if (selectedRows.length<1) 
	{
		alert(g_I18NMessage("comframe_resources","comframe_html_workflow_exception_exceptionCodeDesc_selectRelLine"));
		return;
	}
	
	var desc=gridCode.getValue(selectedRows[0],"EXCEPTION_DESC_CODE");
	if (desc=="noValue"){
	alert(g_I18NMessage("comframe_resources","comframe_html_workflow_exception_exceptionCodeDesc_selectExceptionFromTable"));
	top.switchTab1();
	return;
	}
	var url = _gModuleName+"/business/com.ai.comframe.config.action.ExceptionAction?action=SaveExUnion";
	url+="&length="+selectedRows.length;
	url+="&desc="+desc+"&isDelete=true";
	for (var i=0;i<selectedRows.length;i++){
	url+="&para"+i+"="+gridCode.getValue(selectedRows[i],"EXCEPTION_CODE");
	}
	var rt=PostInfo(url);
	alert(rt.getValueByName("MESSAGE"));
	queryByDescCode(_desc2);
}
</script>
