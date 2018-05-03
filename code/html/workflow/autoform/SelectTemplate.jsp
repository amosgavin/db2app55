<%@ page contentType="text/html; charset=GBK" %>
<%@ include file="/workflow/common/WorkflowHead.jsp"%>
<html>
<head>
  <title><i18n:message res="i18n.comframe_resource" key="comframe.html.workflow.autoform.selectTemplate11"></i18n:message></title></head>
<body>
<ai:contractframe width="100%" title="" id="condition" allowcontract="false">
<ai:contractitem></ai:contractitem>
<table width="100%" height="100%">
  <tr>
  <td class="td_font">
  	<i18n:message res="i18n.comframe_resource"  key="comframe.html.workflow.Alarm22"></i18n:message>:
  </td>      
  <td>
  	  <input type="text" name="taskTag" id="taskTag" width="200" value=""/>
  </td>
  <td>
  	  <ai:button i18nRes="i18n.comframe_resource" text="comframe.html.workflow.TemplatePublish28" onclick="searchTemplate()"/>
  </td>
  </tr>
</table>
</ai:contractframe>
<ai:contractframe width="100%" title="" id="template" allowcontract="false">
<ai:contractitem></ai:contractitem>
    <ai:table  tableid="tblFile" setname="com.ai.comframe.config.set.SETVmTemplate"
	    tablemodel="com.ai.appframe2.web.datamodel.MethodModelForService"
	    implservice_name="com.ai.comframe.autoform.service.interfaces.IAutoFormSV"
	    implservice_querymethod="searchTemplate(String taskTag)"
	    needrefresh="true" multiselect="false" editable="false"
	    rowheight="-1" initial="false" width="100%" height="280" rowsequence="true">
	    <ai:col fieldname="TEMPLATE_TAG" width="100%"/>
	  </ai:table>
</ai:contractframe>
<div class="area_button">
 <ai:button i18nRes="i18n.comframe_resource" text="comframe.html.workflow.InstVars46" onclick="selectTemplate()"/>
  <ai:button i18nRes="i18n.comframe_resource" text="comframe.html.workflow.InstVars47" onclick="window.close()"/>
</div>
		

</body>
</html>
<script language="javascript">
function getFileTable(){
  return g_TableRowSetManager.get("tblFile");
}

function selectTemplate(){
 window.returnValue=getFileTable().getValue(getFileTable().getRow(),"TEMPLATE_TAG");
 window.close();
}
function searchTemplate(){
  var taskValue = document.getElementById("taskTag").value;  
  if(taskTag==""){
  	 alert(g_I18NMessage("comframe_resources","comframe_html_workflow_TemplatePublish139"));
  	 return false;
  }
  getFileTable().refresh("taskTag="+taskValue);
}



function tagFilter(obj,str){
  var dir = obj.value;  
  getFileTable().refresh("dir="+dir+"&classpath="+str);
  var tags = document.all.txtFilter.value;
  if(tags == ""){
    return;
  }
  var arrTag = tags.split(";");
  for(var i=getFileTable().count()-1;i>=0;i--){
    var tmp = getFileTable().getValue(i,"TEMPLATE_TAG");
    var delFlag = true;
    for(var k=0;k<arrTag.length;k++){
      if(tmp.indexOf(arrTag[k]) >= 0){
        delFlag = false;
        break;
      }
    }
    if(delFlag == true){
      getFileTable().deleteRow(i);
    }
  }
}


</script>
