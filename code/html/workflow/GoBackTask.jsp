<%@ page language="java" pageEncoding="GBK"%>
<%@page import="com.ai.appframe2.web.HttpUtil"%> 
<%@ include file="/workflow/common/WorkflowHead.jsp"%>
<%
  String workflowId = HttpUtil.getAsString(request,"workflowId");
  String regionID = HttpUtil.getAsString(request,"regionID");
  String templateTag=HttpUtil.getAsString(request,"templateTag");
  if(regionID==null||regionID.length()==0){
  	regionID="";
  }
  String dealType = HttpUtil.getAsString(request,"dealType");
  
%>
<html>
  <head>
    <title><i18n:message res="i18n.comframe_resource"  key="comframe.html.workflow.GoBackTask18"></i18n:message></title>    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
<body onload="init()" scroll="yes">
  	<div id="graphDiv" align="center"></div>
  	<br>
  	<div id="btnDiv" style="display:none" class="area_button">
  	<ai:button text="comframe.html.workflow.GoBackTask34" i18nRes="i18n.comframe_resource" onclick="goBack()"/></div>  	
<ai:contractframe width="100%" title="comframe.html.workflow.GoBackTask38" id="comframe.html.workflow.GoBackTask38" i18nRes="i18n.comframe_resource" allowcontract="false">
  	<ai:contractitem></ai:contractitem>  	
     <ai:table tableid="varTable" initial="false" setname="com.ai.comframe.config.set.SETVmWFAttr" 
              tablemodel="com.ai.appframe2.web.datamodel.MethodModelForService"
              implservice_name="com.ai.comframe.config.service.interfaces.IWorkflowConsoleSV"
              implservice_querymethod="getWorkflowInstVars(String workflowId,String templateCode)"
        width="100%" height="150" pagesize="100" needrefresh="true" multiselect="false" editable="true">
		<ai:col fieldname="ATTR_NAME" width="30%" visible="true" editable="false"/>
		<ai:col fieldname="ATTR_TYPE" width="30%" visible="true" editable="false"/>
		<ai:col fieldname="ATTR_VALUE" width="40%" visible="true" editable="true"/>
  </ai:table>
</ai:contractframe>
  </body>
</html>
<script type="text/javascript">
var currentWorkflowId = "";

function init(){
   document.all("graphDiv").innerHTML ="";
   var workflowId="<%=workflowId%>";
   var url = "<%=request.getContextPath()%>/business/com.ai.comframe.config.action.WorkflowAction?";
   url += "action=workflowInst2Svg&workflow_id=" + workflowId+getCenterStr('<%=regionID%>');
   currentWorkflowId = workflowId;
   g_TableRowSetManager.get("varTable").refresh("workflowId="+workflowId+"&templateCode=<%=templateTag%>"+getCenterStr('<%=regionID%>'));
   showSVG(url);
}

function showParentSVG(parentWorkflowId){
  var url = "<%=request.getContextPath()%>/business/com.ai.comframe.config.action.WorkflowAction?"
		      + "action=workflowInst2Svg&workflow_id="+parentWorkflowId+getCenterStr('<%=regionID%>');
  currentWorkflowId = parentWorkflowId;
	showSVG(url);
	document.all.btnDiv.style.display = "block";
	//document.all.tblParam.style.display = "none";
}

function onSvgClick(param1,param2){
  if(param1 == null){
    alert(g_I18NMessage("comframe_resources","comframe_html_workflow_GoBackTask80"));
    return;
  }
  if(currentWorkflowId != "<%=workflowId%>"){
//    alert("不能回退到父任务!");
    return;
  }
  if(confirm(g_I18NMessage("comframe_resources","comframe_html_workflow_<%=dealType%>")+":"+param2+"?")){    var taskTemplateId = param1;
    
    var varTable = g_TableRowSetManager.get("varTable");
	  var count = varTable.count();
	  var vars = "";
	  for(var i=0;i<count;i++){
	    var name = varTable.getValue(i,"ATTR_NAME");
	    var value = varTable.getValue(i,"ATTR_VALUE");
	    vars += name+":"+value+"#";
	  }
    window.returnValue = taskTemplateId + "$$" + vars;
    window.close();
  }
}

function showSVG(url){
  document.all("graphDiv").innerHTML ="";
	var s = "<object type='image/svg+xml' width='600' height='460'>"
                          + "<param name='src' value='" + url + "'/>"
                          + "</object>";
  document.all("graphDiv").innerHTML = s;
}

function goBack(){
  	init();
	document.all.btnDiv.style.display = "none";
	//document.all.tblParam.style.display = "block";
}
</script>