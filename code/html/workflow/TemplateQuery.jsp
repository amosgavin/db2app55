<%@ page contentType="text/html; charset=GBK" %>
<%@ include file="/workflow/common/WorkflowHead.jsp"%>
<html>
<head>
  <title><i18n:message res="i18n.comframe_resource"  key="html.workfow.templateQuery_query"></i18n:message></title></head>
<body>
<ai:contractframe i18nRes="i18n.comframe_resource" title="html.workflow.templatepublish_queryCond" id="" width="100%" allowcontract="false">
<ai:contractitem>
<div class="t-bot-mc-button">
<ai:button id="btnQry" i18nRes="i18n.comframe_resource" text="html.workfow.templateQuery_query" onclick="queryTemplate()" />
</div>
</ai:contractitem>
<ai:dbform formid="frmQry"  setname="com.ai.comframe.config.set.SETVmTemplate" initial="false" >
<table width="98%" align="center" cellspacing="2" cellpadding="1" border="0">
    <tr>
      <td class="td_font"><i18n:message res="i18n.comframe_resource"  key="html.workflow.alarm_queue"></i18n:message>:</td>      
      <td><ai:dbformfield formid="frmQry" fieldname="QUEUE_ID" width="150" /></td>
      <td class="td_font"><i18n:message res="i18n.comframe_resource"  key="html.workfow.templateQuery_templateTag"></i18n:message>:</td>      
      <td><ai:dbformfield formid="frmQry" fieldname="TEMPLATE_TAG" width="150" /></td>
      <td class="td_font"><i18n:message res="i18n.comframe_resource"  key="html.workfow.templateQuery_templateType"></i18n:message>£º</td> 
      <td><ai:dbformfield formid="frmQry" fieldname="TEMPLATE_TYPE" width="150" /></td>
     </tr>
</table>
</ai:dbform>
</ai:contractframe> 
<ai:contractframe i18nRes="i18n.comframe_resource" title="html.workfow.templateQuery_templateAttrReg" id="" width="100%" allowcontract="false">
<ai:contractitem>
<div class="t-bot-mc-button">
	<ai:button  text="Dojo" onclick="showTemplateDojo()"/>&nbsp;&nbsp;
	<ai:button  text="Svg" onclick="showTemplateSvg()"/>&nbsp;&nbsp;
	<ai:button i18nRes="i18n.comframe_resource" text="html.workfow.templateQuery_modify" onclick="modifyVmTemplate()"/>&nbsp;&nbsp;
	<ai:button i18nRes="i18n.comframe_resource" text="html.workfow.templateQuery_save" onclick="saveVmTemplate()"/>
</div>
</ai:contractitem>
    <ai:table  tableid="tblTemplate" setname="com.ai.comframe.config.set.SETVmTemplate"
	    tablemodel="com.ai.appframe2.web.datamodel.MethodModelForService"
	    implservice_name="com.ai.comframe.config.service.interfaces.IWorkflowConsoleSV"
	    implservice_querymethod="getVmTemplates(String queueID,String templateTag,String templateType,int $STARTROWINDEX,int $ENDROWINDEX)"
	    implservice_countmethod="getVmTemplatesCount(String queueID,String templateTag,String templateType)"
	    needrefresh="true" editable="false" onrowchange="getTemplateVersion"  
	    initial="false" width="100%" height="120" footdisplay="true" rowsequence="true" pagesize="8">
	    <ai:col fieldname="TEMPLATE_TAG" width="25%" />
	    <ai:col fieldname="TEMPLATE_TYPE" width="10%"/>
	    <ai:col fieldname="LABEL" width="25%"/>
	  	<ai:col fieldname="QUEUE_ID" width="10%"/>
	  	<ai:col fieldname="ENGINE_TYPE" width="10%"/>
	  	<ai:col fieldname="PUBLISH" width="10%"/>
	  	<ai:col fieldname="CREATE_DATE" width="10%"/>
	  	<ai:col fieldname="CREATE_STAFF" width="10%" visible="false"/>
		</ai:table>
</ai:contractframe>
<ai:contractframe i18nRes="i18n.comframe_resource" title="html.workfow.templateQuery_templateVersion" id="" width="100%" allowcontract="false">
<ai:contractitem>
<div class="t-bot-mc-button">
	<ai:button i18nRes="i18n.comframe_resource" text="html.workfow.templateQuery_modify" onclick="modifyVmTemplateVersion()"/>&nbsp;&nbsp;
	<ai:button i18nRes="i18n.comframe_resource" text="html.workfow.templateQuery_save" onclick="saveVmTemplateVersion()"/>
</div>
</ai:contractitem>	  
 <ai:table  tableid="templateVersion" setname="com.ai.comframe.config.set.SETVmTemplateVersion"
  tablemodel="com.ai.appframe2.web.datamodel.MethodModelForService"
  implservice_name="com.ai.comframe.config.service.interfaces.IWorkflowConsoleSV"
  implservice_querymethod="getAllTemplateVersionByTag(String templateTag)"
  needrefresh="true" rowsequence="true"  editable="true"
  initial="false" width="100%" height="160" footdisplay="none">
  <ai:col fieldname="TEMPLATE_VERSION_ID" width="100%" visible="false"/>
	<ai:col fieldname="TEMPLATE_TAG" width="40%" editable="false"/>
	<ai:col fieldname="CREATE_STAFF_ID"  visible="false"/>
	<ai:col fieldname="CREATE_DATE" width="13%" editable="false"/>
	<ai:col fieldname="VALID_DATE" width="13%"  editable="false" />
	<ai:col fieldname="EXPIRE_DATE" width="13%"  editable="false"/>	
	<ai:col fieldname="MODIFY_DESC" width="21%" editable="false"/>
</ai:table>
</ai:contractframe>		
<div class="area_button">
	<ai:button i18nRes="i18n.comframe_resource" text="html.workfow.templateQuery_deployNew" onclick="deployNewTemplate()"/>
</div>		
</body>
</html>
<script>
function getfrmQuery(){
	return g_FormRowSetManager.get("frmQry");
}
function getVmTemplate(){
	return g_TableRowSetManager.get("tblTemplate");
}
function getVmTemplateVersion(){
	return g_TableRowSetManager.get("templateVersion");
}
function queryTemplate(){
	var queueID = getfrmQuery().getValue("QUEUE_ID");
	var templateTag = getfrmQuery().getValue("TEMPLATE_TAG");
	var templateType=getfrmQuery().getValue("TEMPLATE_TYPE");
	getVmTemplate().refresh("queueID="+queueID+"&templateTag="+templateTag+"&templateType="+templateType);
	getVmTemplate().setEditSts(false);
}
function getTemplateVersion(){
	var selectTemplate = getVmTemplate().getRow();
	var templateTag = getVmTemplate().getValue(selectTemplate,"TEMPLATE_TAG");
	getVmTemplateVersion().refresh("templateTag="+templateTag);
	getVmTemplateVersion().setColEditSts("VALID_DATE",false);
	getVmTemplateVersion().setColEditSts("EXPIRE_DATE",false);
}

function deployNewTemplate(){
	var width = 880;
	var height= 600;
	var strUrl= 'TemplatePublish.jsp';
	var ret = window.showModalDialog(strUrl,window,'dialogWidth:'+width+'px;dialogHeight:'+height+'px;center:yes;status:no;scroll:auto;');
}

function modifyVmTemplate(){
	getVmTemplate().setEditSts(true);

}

function saveVmTemplate(){
	 var url = "<%=request.getContextPath()%>/business/com.ai.comframe.config.action.WorkflowAction?action=saveVmTemplate";
	 var xml = "<RootInfo>"+getVmTemplate().toXmlString(true)+"</RootInfo>";
	 var ret = PostInfo(url,xml);
	 alert(ret.getValueByName("MESSAGE"));
}

function modifyVmTemplateVersion(){
	getVmTemplateVersion().setColEditSts("VALID_DATE",true);
	getVmTemplateVersion().setColEditSts("EXPIRE_DATE",true);
}

function saveVmTemplateVersion(){
	 var url = "<%=request.getContextPath()%>/business/com.ai.comframe.config.action.WorkflowAction?action=saveVmTemplateVersion";
	 var xml = "<RootInfo>"+getVmTemplateVersion().toXmlString(true)+"</RootInfo>";
	 var ret = PostInfo(url,xml);
	 alert(ret.getValueByName("MESSAGE"));
}

function showTemplateSvg(){
	var width = 800;
	var height= 650;
	var rowid = getVmTemplate().getRow();
	if(rowid<0){
		alert(g_I18NMessage("comframe_resources","comframe_html_workflow_templateQuery_selectTemplate"));
		return;
	}
	var templateTag = getVmTemplate().getValue(rowid,"TEMPLATE_TAG");
	var strUrl= 'SvgView.jsp?task_tag='+templateTag;
	window.open(strUrl,"",'width='+width+'px,height='+height+'px;center:yes;status:no;scroll:auto;');
}

function showTemplateDojo(){
	var width = 1024;
	var height= 680;
	var rowid = getVmTemplate().getRow();
	if(rowid<0){
		alert(g_I18NMessage("comframe_resources","comframe_html_workflow_templateQuery_selectTemplate"));
		return;
	}
	var templateTag = getVmTemplate().getValue(rowid,"TEMPLATE_TAG");
	var strUrl= 'DojoView.jsp?task_tag='+templateTag;
	window.open(strUrl,"",'width='+width+'px,height='+height+'px;center:yes;status:no;scroll:auto;');
}



</script>