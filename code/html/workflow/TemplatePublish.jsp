<%@ page contentType="text/html; charset=GBK" %>
<%@ include file="/workflow/common/WorkflowHead.jsp"%>
<html>
<head>
  <title><i18n:message res="i18n.comframe_resource"  key="comframe.html.workflow.TemplatePublish10"></i18n:message></title></head>
<body onLoad="init()">
<ai:contractframe width="100%" i18nRes="i18n.comframe_resource" title="html.workflow.templatepublish_queryCond" id="condition" allowcontract="false">
<ai:contractitem></ai:contractitem>
<table width="98%" cellspacing="2" cellpadding="1" border="0">
<tr>
  <td class="td_font"><i18n:message res="i18n.comframe_resource"  key="comframe.html.workflow.TemplatePublish_type"></i18n:message>:</td>
  <td ><ai:listbox ds="com.ai.comframe.config.ds.DSPublishType" id="upType" initial="true" width="150" onchange="typeChange"/></td>  
  <td id="tdLocal" style="display:none" >
  	<table width="98%" cellspacing="0" cellpadding="1" border="0">
  		<tr>
  			<td  class="td_font"><i18n:message res="i18n.comframe_resource"  key="comframe.html.workflow.TemplatePublish_path"></i18n:message>:</td>
  			<td><input id="txtDir" type="text" style="width:150px" value="classpath" /></td>
  			<td  class="td_font"><i18n:message res="i18n.comframe_resource"  key="comframe.html.workflow.TemplatePublish21"></i18n:message>:</td>
  			<td><input id="txtFilter" type="text" style="width:150px" value=""/><ai:button i18nRes="i18n.comframe_resource" text="comframe.html.workflow.TemplatePublish28" onclick="tagFilter(txtDir,'classpath')"/></td>
  		</tr>
  	</table>
  </td>
   <td id="tdDetailPath" style="display:none">
   <table width="98%" cellspacing="0" cellpadding="1" border="0">
  		<tr>
  			<td class="td_font"><i18n:message res="i18n.comframe_resource"  key="comframe.html.workflow.TemplatePublish_dir"></i18n:message>:</td>
  			<td><input id="txtDir1" type="text" style="width:380px" value=""/><ai:button i18nRes="i18n.comframe_resource" text="comframe.html.workflow.TemplatePublish28" onclick="search(txtDir1,'')"/></td>
  		</tr>
  	</table>
  </td>
  <td id="tdServer">
   <table width="98%" cellspacing="0" cellpadding="1" border="0">
  		<tr>
  			<td class="td_font"><i18n:message res="i18n.comframe_resource"  key="comframe.html.workflow.TemplatePublish_tempPath"></i18n:message>:</td>
  			<td> <input  id="fileUp" type="file" style="width:400px;"  onChange="setFileTable(this)"/>
	  			<ai:fileupload name="frmTestUpload"  submitFuncName="doUpload"  onFinishFuncName="doOnFinish" showProcessBar="true"></ai:fileupload></td>
  		</tr>
  	</table>
  </td>  
</tr>
</table>
</ai:contractframe>
<ai:contractframe width="100%" i18nRes="i18n.comframe_resource" title="comframe.html.workflow.Alarm85" id="" allowcontract="false">
<ai:contractitem></ai:contractitem>
    <ai:table  tableid="tblFile" setname="com.ai.comframe.config.set.SETVmTemplate"
	    tablemodel="com.ai.appframe2.web.datamodel.MethodModelForService"
	    implservice_name="com.ai.comframe.config.service.interfaces.IWorkflowConsoleSV"
	    implservice_querymethod="getTemplatesFromDir(String dir,String classpath)"
	    needrefresh="true" multiselect="true" editable="true" footdisplay="none" 
	    rowheight="-1" initial="false" width="100%" height="260" rowsequence="true">
	    <ai:col fieldname="TEMPLATE_TAG" width="100%"/>
	  </ai:table>
</ai:contractframe>
<ai:contractframe width="100%" i18nRes="i18n.comframe_resource" title="html.workflow.templatepublish_publish" id="condition" allowcontract="false">
<ai:contractitem></ai:contractitem>
<ai:dbform setname="com.ai.comframe.config.set.SETVmTemplate" formid="vmTemplate" onvalchange="checkValChange" initial="false">
<table width="98%" cellspacing="2" cellpadding="1" border="0">
<tr>
  <td  class="td_font">
  <i18n:message res="i18n.comframe_resource"  key="comframe.html.workflow.TemplatePublish38"></i18n:message>:</td>
  <td>
  	<ai:dbformfield formid="vmTemplate" fieldname="ENGINE_TYPE" width="150"/>
  </td>
  <td class="td_font"><i18n:message res="i18n.comframe_resource"  key="html.workflow.templatepublish_relateQueue"></i18n:message>:</td> 
  <td>
  <ai:dbformfield formid="vmTemplate" fieldname="QUEUE_ID" width="150"/>
 </td>
 <td class="td_font"><i18n:message res="i18n.comframe_resource"  key="html.workflow.templatepublish_deployMode"></i18n:message>:</td> 
  <td>
	 <ai:dbformfield formid="vmTemplate" fieldname="PUBLISH" width="150" />
</td>
</tr>
<tr>
  <td class="td_font"><i18n:message res="i18n.comframe_resource"  key="comframe.html.workflow.TemplatePublish31"></i18n:message>:</td>
  <td><ai:dbformfield formid="vmTemplate" fieldname="VALID_DATE" width="150"/></td>
  <td class="td_font"><i18n:message res="i18n.comframe_resource"  key="html.workflow.templatepublish_expiredate"></i18n:message>:</td>
  <td><ai:dbformfield formid="vmTemplate" fieldname="EXPIRE_DATE" width="150"/></td>
   <td class="td_font"><i18n:message res="i18n.comframe_resource"  key="html.workflow.templatepublish_remark"></i18n:message>:</td>
  <td><ai:dbformfield formid="vmTemplate" fieldname="REMARK" width="150"/></td>
</tr>
</table>
</ai:dbform>
</ai:contractframe>
<div class="area_button">
	 <ai:button text="comframe.html.workflow.TemplatePublish48" i18nRes="i18n.comframe_resource" onclick="publish()"/> 
</div>
</body>
</html>
<script language="javascript">
function getVmTemplateForm(){
	return g_FormRowSetManager.get("vmTemplate");
}
function setFileTable(obj){
	getFileTable().clear();
	var tmpName=obj.value;
	if(tmpName==""){
		return;
	}
		
	if(tmpName.indexOf(".wvm")==-1){
	 	alert(g_I18NMessage("comframe_resources","comframe_html_workflow_TemplatePublish175"));    
	 	return false;
	}
	tmpName=tmpName.substring((tmpName.lastIndexOf("\\")+1),tmpName.indexOf(".wvm"));
	getFileTable().newRow(false);
	getFileTable().setValue(0,"TEMPLATE_TAG",tmpName,tmpName);
}

function checkValChange(colName){
 if(colName=="PUBLISH"){
 	if(getVmTemplateForm().getValue("PUBLISH")=="N"){
 		getVmTemplateForm().setColEditSts("VALID_DATE",false);
 		getVmTemplateForm().setColEditSts("EXPIRE_DATE",false);
 	}else{
 		getVmTemplateForm().setColEditSts("VALID_DATE",true);
 		getVmTemplateForm().setColEditSts("EXPIRE_DATE",true);
 	}
 }
}
function init(){
  var mDate = new Date();
  var mYear = mDate.getYear();
  var mMonth = mDate.getMonth()+1;
  var mDay = mDate.getDate();
  if(mMonth<10){
	mMonth="0"+mMonth;
  }
  if(mDay<10){
	mDay="0"+mDay;
  }
  var current = mYear+"-"+mMonth+"-"+mDay;
  getVmTemplateForm().setValue("VALID_DATE",current+" 00:00:00",current+" 00:00:00");
  typeChange();
}

function getFileTable(){
  return g_TableRowSetManager.get("tblFile");
}

function search(obj,str){
  var dir = obj.value;  
  if(dir==""){
  	 alert(g_I18NMessage("comframe_resources","comframe_html_workflow_TemplatePublish139"));
  	 return false;
  }
  getFileTable().refresh("dir="+dir+"&classpath="+str);
}

function searchLocal(){
	
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

function typeChange(){
	getFileTable().clear();
  var type = g_getListBox("upType").getID();
  if(type == 0){
    document.all.tdServer.style.display = "block";
    document.all.tdLocal.style.display = "none";
    document.all.tdDetailPath.style.display = "none";
    getVmTemplateForm().setValue("PUBLISH","Y");
    getVmTemplateForm().setColEditSts("PUBLISH",false);
  }
  else if(type == 1){
    document.all.tdServer.style.display = "none";
    document.all.tdLocal.style.display = "block";
     document.all.tdDetailPath.style.display = "none";
     getVmTemplateForm().setColEditSts("PUBLISH",true);
  }else if(type == 2){
    document.all.tdDetailPath.style.display = "";
    document.all.tdLocal.style.display = "none";
    document.all.tdServer.style.display = "none";
    getVmTemplateForm().setValue("PUBLISH","Y");
    getVmTemplateForm().setColEditSts("PUBLISH",false);
  }
}

function publish(){	
  var file = g_StringTrim(document.all.fileUp.value);
  if(file != null && file != ""&&g_getListBox("upType").getID()==0){
    doUpload();
    return;
  }
  var EngineType = getVmTemplateForm().getValue("ENGINE_TYPE");

  var rows = getFileTable().getSelectedRows();
  if(rows == null || rows.length == 0){
    alert(g_I18NMessage("comframe_resources","comframe_html_workflow_TemplatePublish138"));    return;
  }
  if(EngineType==""){
	  alert(g_I18NMessage("comframe_resources","comframe_html_workflow_TemplatePublish144"));//请选择发布引擎类型
	  getVmTemplateForm().setFocus("ENGINE_TYPE");
	  return;
  }
  var queueId=getVmTemplateForm().getValue("QUEUE_ID");
  if(queueId==""){
	   alert(g_I18NMessage("comframe_resources","comframe_html_workflow_TemplatePublish145"));//请选择关联队列
	   getVmTemplateForm().setFocus("QUEUE_ID");
	   return;
  }
  var publish = getVmTemplateForm().getValue("PUBLISH");
  var validDate = getVmTemplateForm().getValue("VALID_DATE");  
  var expireDate = getVmTemplateForm().getValue("EXPIRE_DATE");
  if(publish==""){
	  alert(g_I18NMessage("comframe_resources","comframe_html_workflow_TemplatePublish146")); //请选择发布模式
	  getVmTemplateForm().setFocus("PUBLISH");
	  return;
  }else  if('Y'==publish){	 
	 if(validDate == ""){
	    alert(g_I18NMessage("comframe_resources","comframe_html_workflow_TemplatePublish147")); 
	    getVmTemplateForm().setFocus("VALID_DATE");
	    return;
	  }
	  if(!g_IsDateTime(validDate)){
	    alert(g_I18NMessage("comframe_resources","comframe_html_workflow_TemplatePublish152"));  
	    getVmTemplateForm().setValue("VALID_DATE","","");
	    getVmTemplateForm().setFocus("VALID_DATE");
	    return;
	  }
	
	  if(expireDate == ""){
	    alert(g_I18NMessage("comframe_resources","comframe_html_workflow_TemplatePublish148"));	//请输入失效时间  
	    getVmTemplateForm().setFocus("EXPIRE_DATE");
	    return;
	  }

	  if(!g_IsDateTime(expireDate)){
		    alert(g_I18NMessage("comframe_resources","comframe_html_workflow_TemplatePublish153"));  
		    getVmTemplateForm().setValue("EXPIRE_DATE","","");
		    getVmTemplateForm().setFocus("EXPIRE_DATE");
		    return;
	 }
	 if(validDate>=expireDate){
		 alert(g_I18NMessage("comframe_resources","comframe_html_workflow_TemplatePublish154"));
		// alert("生效时间必须小于失效时间");
		 return;
     }
	 
  }
  if(confirm(g_I18NMessage("comframe_resources","comframe_html_workflow_TemplatePublish141")) == false){ 
	     return;
  }
  var url = "<%=request.getContextPath()%>/business/com.ai.comframe.config.action.WorkflowAction"
      +"?action=deployTemplate&EngineType="+EngineType+"&pubType=localToCommer&validDate="+validDate+"&expireDate="+expireDate;

  var xml = "<RootInfo>"+getFileTable().toXmlStringOfSelects()+getVmTemplateForm().toXmlString(false)+"</RootInfo>";
  var ret = PostInfo(url,xml);
  alert(ret.getValueByName("msg"));
}

function doUpload(){
  var file = g_StringTrim(document.all.fileUp.value);
  if(file==null||file==""){
    alert(g_I18NMessage("comframe_resources","comframe_html_workflow_TemplatePublish170"));    return;
  }
  var fileType = file.substr(file.length-4,4).toLowerCase();
  if(fileType!=".wvm"){
    alert(g_I18NMessage("comframe_resources","comframe_html_workflow_TemplatePublish175"));    return;
  }
  var rows = getFileTable().getSelectedRows();
  if(rows == null || rows.length == 0){
    alert(g_I18NMessage("comframe_resources","comframe_html_workflow_TemplatePublish138"));    return;
  }
  var aFileUploadFormObj = frmTestUpload;
  var EngineType = getVmTemplateForm().getValue("ENGINE_TYPE");
  if(EngineType==""){
	  alert(g_I18NMessage("comframe_resources","comframe_html_workflow_TemplatePublish144"));//请选择发布引擎类型
	  getVmTemplateForm().setFocus("ENGINE_TYPE");
	  return;
  }
  var queueId=getVmTemplateForm().getValue("QUEUE_ID");
  if(queueId==""){
	   alert(g_I18NMessage("comframe_resources","comframe_html_workflow_TemplatePublish145"));//请选择关联队列
	   getVmTemplateForm().setFocus("QUEUE_ID");
	   return;
  }
  var expireDate = getVmTemplateForm().getValue("EXPIRE_DATE");
  var validDate =  getVmTemplateForm().getValue("VALID_DATE");
  var notes = getVmTemplateForm().getValue("REMARK");
  if(validDate == ""){
    alert(g_I18NMessage("comframe_resources","comframe_html_workflow_TemplatePublish147"));   
     getVmTemplateForm().setFocus("VALID_DATE");
    return;
  }
  if(!g_IsDateTime(validDate)){
    alert(g_I18NMessage("comframe_resources","comframe_html_workflow_TemplatePublish152"));    
     getVmTemplateForm().setValue("VALID_DATE","","");
    getVmTemplateForm().setFocus("VALID_DATE");
    return;
  }
  if(expireDate == ""){
	    alert(g_I18NMessage("comframe_resources","comframe_html_workflow_TemplatePublish148"));	//请输入失效时间  
	    getVmTemplateForm().setFocus("EXPIRE_DATE");
	    return;
	  }

	  if(!g_IsDateTime(expireDate)){
		    alert(g_I18NMessage("comframe_resources","comframe_html_workflow_TemplatePublish153"));  
		    getVmTemplateForm().setValue("EXPIRE_DATE","","");
		    getVmTemplateForm().setFocus("EXPIRE_DATE");
		    return;
	 }
	 if(validDate>=expireDate){
		 alert(g_I18NMessage("comframe_resources","comframe_html_workflow_TemplatePublish154"));
		// alert("生效时间必须小于失效时间");
		 return;
   }
  if(confirm(g_I18NMessage("comframe_resources","comframe_html_workflow_TemplatePublish141")) == false){   
	   return;
 }
  var queueID = getVmTemplateForm().getValue("QUEUE_ID"); 
  var EngineType = getVmTemplateForm().getValue("ENGINE_TYPE");
  var expireDate = getVmTemplateForm().getValue("EXPIRE_DATE");
  var aActionUrl="<%=request.getContextPath()%>/business/com.ai.comframe.config.action.WorkflowAction?"
        +"action=templateUpload&validDate="+validDate+"&expireDate="+expireDate+"&EngineType="+EngineType+"&TEMPLATE_TAG="+getFileTable().getValue(0,"TEMPLATE_TAG")+"&QUEUE_ID="+queueID;
//  aFileUploadFormObj.action=aActionUrl;
//  aFileUploadFormObj.submit();
//alert(aFileUploadFormObj);
   PostUploadInfo(aFileUploadFormObj,aActionUrl,null,null,null);
   
}

function doOnFinish(aUserDataXml){
  var errMsg = getReturnValueByName(aUserDataXml,"ERRMSG");
  if(errMsg!=null && errMsg!=""){
    alert(errMsg);
  }
  var msg = getReturnValueByName(aUserDataXml,"MESSAGE");
  if(msg!=null && msg!=""){
    document.all.fileUp.value = "";
    getVmTemplateForm().setValue("REMARK","","");
    alert(msg);
  }
}
</script>
