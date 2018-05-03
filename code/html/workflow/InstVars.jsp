<%@ page contentType="text/html; charset=GBK" %>
<%@page import="com.ai.appframe2.web.HttpUtil"%>
<%@ include file="/workflow/common/WorkflowHead.jsp"%>
<%
	String workflowId = HttpUtil.getAsString(request,"workflowId");
	String type = HttpUtil.getAsString(request,"showType");
	String templateTag=HttpUtil.getAsString(request,"templateTag");
	String regionID = HttpUtil.getAsString(request,"regionID");
	String editable = "true";
	String td1 = "block";
	String td2 = "none";
	if(type != null && type.equals("view")){
	  editable = "false";
	  td1 = "none";
	  td2 = "block";
	}
	if(regionID==null||regionID.length()==0){
		regionID="";
	}
%>
<html>
<head>
<title><i18n:message res="i18n.comframe_resource"  key="comframe.html.workflow.InstVars23"></i18n:message></title></head>
<body>
<ai:contractframe width="100%" title="comframe.html.workflow.GoBackTask38" id="comframe.html.workflow.GoBackTask38" i18nRes="i18n.comframe_resource" allowcontract="false">
<ai:contractitem></ai:contractitem>
<ai:table tableid="varTable" initial="false" setname="com.ai.comframe.config.set.SETVmWFAttr"
         tablemodel="com.ai.appframe2.web.datamodel.MethodModelForService"
         implservice_name="com.ai.comframe.config.service.interfaces.IWorkflowConsoleSV"
         implservice_querymethod="getWorkflowInstVars(String workflowId,String templateTag)"
   		 width="100%" height="200"  footdisplay="none" needrefresh="true" multiselect="false" editable="true">
<ai:col fieldname="ATTR_NAME" width="30%" visible="true" editable="false"/>
<ai:col fieldname="ATTR_TYPE" width="30%" visible="true" editable="false"/>
<ai:col fieldname="ATTR_VALUE" width="40%" visible="true" editable="<%=editable %>"/>
</ai:table>
</ai:contractframe>
<div class="area_button">
	<span style="display:<%=td1%>">
    <ai:button id="btnsave" text="comframe.html.workflow.InstVars46" i18nRes="i18n.comframe_resource" onclick="saveFunc()"/>&nbsp;&nbsp;   
    <ai:button id="btncancel" text="comframe.html.workflow.InstVars47" i18nRes="i18n.comframe_resource" onclick="cancelFunc()"/>
    </span>
    <span  style="display:<%=td2%>">
    <ai:button id="btnsave" text="comframe.html.workflow.autoform.errorInfo25" i18nRes="i18n.comframe_resource" onclick="cancelFunc()"/>
	</span>
</div>
</body>
</html>
<script language="javascript">
function saveFunc(){
  var varTable = g_TableRowSetManager.get("varTable");
  var count = varTable.count();
  var vars = "";
  for(var i=0;i<count;i++){
    var name = varTable.getValue(i,"ATTR_NAME");
    var value = varTable.getValue(i,"ATTR_VALUE");
    vars += name+":"+value+"#";
  }
  vars = g_ConditonStrEncode(vars);

  //ÉèÖÃ
  if("<%=type%>" == "edit"){
    if(vars == ""){
      alert(g_I18NMessage("comframe_resources","comframe_html_workflow_InstVars70"));      
      window.close();
    }
	  var url = "<%=request.getContextPath()%>/business/com.ai.comframe.config.action.WorkflowAction"
	          + "?action=setWorkflowVars&workflowId=<%=workflowId%>&vars="+vars+getCenterStr('<%=regionID%>');
	  var rtn = sendToServer(url,null);
	  ret = rtn.getValueByName("FLAG");
	  if (ret == "INFO"){
	    window.close();
	  }
  }
  //»Øµ¥
  else{
	  if(!confirm(g_I18NMessage("comframe_resources","comframe_html_workflow_InstVars83"))){	    
	  	return;
	  }
    window.returnValue = vars;
    window.close();
  }
}

function cancelFunc(){
	window.close();
}
g_TableRowSetManager.get("varTable").refresh("workflowId=<%=workflowId%>&templateTag=<%=templateTag%>"+getCenterStr('<%=regionID%>'));
</script>