<%@ page contentType="text/html; charset=GBK"%>
<%@ include file="/workflow/common/WorkflowHead.jsp"%>
<%@ taglib uri="/WEB-INF/appframe2.tld" prefix="ai"%>
<html>
<%
	long staffId = SessionManager.getUser().getID(); //员工ID
	String staffName = SessionManager.getUser().getName();
	//String regionId = (String) SessionManager.getUser().get("REGION_ID");
	Integer stations = (Integer)SessionManager.getUser().get("MANAGER_TYPE");       //岗位ID
%>
<head>
<title><i18n:message res="i18n.comframe_resource"  key="comframe.html.workflow.autoform.taskInfoMain23"></i18n:message></title></head>
<body>
<ai:contractframe width="100%" i18nRes="i18n.comframe_resource" title="comframe.html.jsv2.udfpage.UserDefineFieldQuery34" id="qryTask"  allowcontract="false"  >
<ai:contractitem>
	<div class="t-bot-mc-button">
      	<ai:button text="comframe.html.workflow.autoform.taskInfoMain46" i18nRes="i18n.comframe_resource" onclick="query();"/>
      </div>
</ai:contractitem>
	<ai:dbform formid="taskForm" setname="com.ai.comframe.config.set.SETQTaskInfo" 
 				 editable="true" initial="false">
	<table width="98%" align="center" cellspacing="2" cellpadding="1" border="0">
	<tr>
		<td class="td_font"><i18n:message res="i18n.comframe_resource"  key="html.workflow.alarm_queue"></i18n:message>：</td>		            
		<td><ai:dbformfield fieldname="QUEUE_ID" formid="taskForm" visible="true" width="150"></ai:dbformfield></td>
		<td class="td_font"><i18n:message res="i18n.comframe_resource"  key="comframe.html.workflow.autoform.taskInfoMain35"></i18n:message>：</td>		            
		<td><ai:dbformfield fieldname="TASK_STAFF_ID" formid="taskForm" visible="true" editable="false" width="150"></ai:dbformfield></td>
           <td class="td_font"><i18n:message res="i18n.comframe_resource"  key="comframe.html.workflow.autoform.taskInfoMain40"></i18n:message>：</td>		            
           <td><ai:dbformfield fieldname="WORKFLOW_OBJECT_ID" formid="taskForm" visible="true" editable="true" width="150"></ai:dbformfield></td>
      </tr>
      <tr>
      	<td class="td_font"><i18n:message res="i18n.comframe_resource"  key="html.workflow.startWorkflow_area"></i18n:message>:</td>
      	<td><ai:dbformfield fieldname="REGION_ID" formid="taskForm" visible="true" editable="true" width="150"></ai:dbformfield></td>
      </tr>
		</table>
	</ai:dbform>
</ai:contractframe>

    <!--流程任务信息-->
<ai:contractframe width="100%" i18nRes="i18n.comframe_resource" title="comframe.html.workflow.autoform.taskInfoMain63" id="" allowcontract="false">
   	<ai:contractitem></ai:contractitem>
  		<ai:table setname="com.ai.comframe.config.set.SETQTaskInfo" tableid="SETTaskInfo" 
         implservice_name="com.ai.comframe.config.service.interfaces.IWorkflowConsoleSV"
         implservice_querymethod="getTaskInfo(String queueID,String stations,String staffId,String state,String orderId, int $STARTROWINDEX,int $ENDROWINDEX)"
         implservice_countmethod="getTaskInfoCount(String queueID,String stations,String staffId,String state,String orderId)"
         tablemodel="com.ai.appframe2.web.datamodel.MethodModelForService"
         pagesize="20" editable="true" footdisplay="block" height="280" width="100%" rowheight="-1"
          initial="false" multiselect="false" needrefresh="true" onrowchange="checkBusiTypeAction" >
          <ai:col fieldname="WORKFLOW_OBJECT_ID" editable="false"  visible="true" width="100"/>
          <ai:col fieldname="LABEL" editable="false"  visible="true" width="120"/>
          <ai:col fieldname="DESCRIPTION" editable="false"  visible="true" width="400"/>
          <ai:col fieldname="CREATE_DATE" editable="false"  visible="true" width="150"/>
          <ai:col fieldname="DURATION" editable="false"  visible="true" width="100"/>
          <ai:col fieldname="STATE" editable="false"  visible="true" width="100"/>
          <ai:col fieldname="TASK_STAFF_ID" editable="false"  visible="false" width="100"/>
          <ai:col fieldname="STATION_ID" editable="false"  visible="false" width="100"/>
          <ai:col fieldname="TASK_ID" editable="false"  visible="false" width="100"/>
          <ai:col fieldname="QUEUE_ID" editable="false"  visible="true" width="100"/>
          <ai:col fieldname="WORKFLOW_NAME" editable="false"  visible="true" width="120"/>
          <ai:col fieldname="WORKFLOW_ID" editable="false"  visible="false" width="100"/>
          <ai:col fieldname="WORKFLOW_OBJECT_TYPE" editable="false"  visible="true" width="150"/>
          <ai:col fieldname="WORKFLOW_STATE" editable="false"  visible="false" width="100"/>
          <ai:col fieldname="TEMPLATE_VERSION_ID" editable="false"  visible="false" width="100"/>
          <ai:col fieldname="TASK_TEMPLATE_ID" editable="false"  visible="false" width="100"/>
   		  <ai:col fieldname="PARENT_TASK_ID" editable="false"  visible="false" width="100"/>
   		  <ai:col fieldname="TEMPLATE_TAG" editable="false"  visible="false" width="120"/>
   		  <ai:col fieldname="REGION_ID" editable="false"  visible="false" width="120"/>
   	</ai:table>
</ai:contractframe> 
<div class="area_button">
	<ai:button text="comframe.html.workflow.autoform.taskInfoMain104" id="btn_print" i18nRes="i18n.comframe_resource" onclick="dotask('2');"/>
  <ai:button text="comframe.html.workflow.autoform.taskInfoMain105" id="btn_ok" i18nRes="i18n.comframe_resource" onclick="dotask('1');"/>
  <ai:button text="comframe.html.workflow.autoform.taskInfoMain108" id="btn_view" i18nRes="i18n.comframe_resource" onclick="dotask('3');"/>
  <ai:button text="comframe.html.workflow.autoform.taskInfoMain109" id="btn_viewsvg" i18nRes="i18n.comframe_resource" onclick="viewWorkFlow();"/>
</div>
</body>

<script>
var stations="";
function getSETTaskInfoTable(){
	return g_TableRowSetManager.get("SETTaskInfo");
}
function getTaskForm(){
	return g_FormRowSetManager.get("taskForm");
}
function refreshTable(){
 if(stations==null||stations=='null'){
 	stations="";
 }
 var regionId=getTaskForm().getValue("REGION_ID");
 var queueId =getTaskForm().getValue("QUEUE_ID");
 var condition = "queueID="+queueId+"&stations="+stations+"&staffId=<%=staffId%>"+"&state="+"&regionId="+regionId+getCenterStr(regionId);
 getSETTaskInfoTable().refresh(condition);
}
/*页面初始化*/
function init(){
	var formset = getTaskForm();
		formset.setValue("TASK_STAFF_ID","<%=staffId%>","<%=staffName%>",false);
	   		
		stations = "<%=stations%>";
		
		//refreshTable();
}
function query(){
  var oState = -1;//getTaskForm().getValue("STATE");
   if(stations==null||stations=='null'){
 	stations="";
 }
  var regionId=getTaskForm().getValue("REGION_ID");
 var queueId =getTaskForm().getValue("QUEUE_ID");
  var oOrderId = getTaskForm().getValue("WORKFLOW_OBJECT_ID");
  var condition = "queueID="+queueId+"&stations="+stations+"&staffId=<%=staffId%>"+"&state="+"&orderId="+oOrderId+"&regionId="+regionId+getCenterStr(regionId);
  getSETTaskInfoTable().refresh(condition);
}
/*任务回单*/
function dotask(type){
  var selectedRow = -1;
  var tableSet = getSETTaskInfoTable();
  selectedRow = tableSet.getRow();
  //复选框选中
  if(selectedRow < 0){
    alert(g_I18NMessage("comframe_resources","comframe_html_workflow_autoform_taskInfoMain160"));    return;
  }else{
  	var aWorkFlowCode;
  	var aParentTaskId = tableSet.getValue(selectedRow,"PARENT_TASK_ID");                                //父流程号
  	//if(aParentTaskId > 0){
  		//aWorkFlowCode = tableSet.getValue(selectedRows[0],"ROOT_WOEK_FLOW_CODE");                           //根流程模板号，有子流程
  	//}else{
  		aWorkFlowCode = tableSet.getValue(selectedRow,"TEMPLATE_TAG");                                 //流程模板号，无子流程
  	//}	
  	var currentWorkFlowCode = tableSet.getValue(selectedRow,"TEMPLATE_TAG");                           //当前流程模板号
  	var aWorkFlowNodeCode = currentWorkFlowCode+ "." + tableSet.getValue(selectedRow,"TASK_TEMPLATE_ID");      //流程节点号
  	var aOrderId = tableSet.getValue(selectedRow,"WORKFLOW_OBJECT_ID");                                 //工单号
  	var aTaskId = tableSet.getValue(selectedRow,"TASK_ID");                                             //任务编号
  	var queueID = tableSet.getValue(selectedRow,"QUEUE_ID"); 
  	var regionId= tableSet.getValue(selectedRow,"REGION_ID"); 
  	var aWorkFlowId = tableSet.getValue(selectedRow,"WORKFLOW_ID");                                     //工作流编号
    var param="WORK_FLOW_CODE="+aWorkFlowCode+"&WORK_FLOW_NODE_CODE="+aWorkFlowNodeCode+"&ORDER_ID="
  			+aOrderId+"&TASK_ID="+aTaskId+"&WORK_FLOW_ID="+aWorkFlowId+"&urlType="+type+"&regionId="+regionId+getCenterStr(regionId);
 
   	var url="<%=request.getContextPath()%>/business/com.ai.comframe.autoform.web.AutoFormAction?action=checkURL&"+param;
	var ret=PostInfo(url);
	var checkUrl=ret.getValueByName("url");
	
	if(checkUrl==""||checkUrl=='null'){
		if(type==1){
			if(confirm(g_I18NMessage("comframe_resources","comframe_html_workflow_autoform_taskInfoMain_noURLReturn"))){
				finishUserTask(aTaskId,queueID);
				return;
			}
			return;
		}else if(type==2){
			alert(g_I18NMessage("comframe_resources","comframe_html_workflow_autoform_taskInfoMain_printURL"));
			return;
		}else if(type==3){
			alert(g_I18NMessage("comframe_resources","comframe_html_workflow_autoform_taskInfoMain_taskInfo"));
			return;
			
		}else{
			alert(g_I18NMessage("comframe_resources","comframe_html_workflow_autoform_taskInfoMain_notRealize"));
			return;
		}
	}else{
		window.showModalDialog("WorkFlowNodeAutoPage.jsp?"+param,this,"scroll:auto;resizable:no;status:no;dialogHeight:768px;dialogWidth:1024px");
	}
	query();
  }
}
function finishUserTask(taskID,queueID){
	var selectedRow = getSETTaskInfoTable().getRow();
  	var regionId= getSETTaskInfoTable().getValue(selectedRow,"REGION_ID"); 
  	
	var url="<%=request.getContextPath()%>/business/com.ai.comframe.config.action.WorkflowAction?action=finish&staff_id=<%=staffId%>" 
	+"&taskid="+taskID 
	+"&queueID="+queueID 
	+"&result=S" 
	+"&reason=autoformReturn"+getCenterStr(regionId);
	var ret =PostInfo(url,'');
	alert(ret.getValueByName("MESSAGE"));
	refreshTable();
}
function viewWorkFlow(){
  var selectedRow = -1;
  var tableSet = getSETTaskInfoTable();
  selectedRow = tableSet.getRow();
  //复选框选中
  if(selectedRow < 0){
    alert(g_I18NMessage("comframe_resources","comframe_html_workflow_autoform_taskInfoMain160"));    return;
  }else{
	var tableSet = getSETTaskInfoTable();
	var aWorkFlowId = tableSet.getValue(selectedRow,"WORKFLOW_ID");
	var aTemplateId = tableSet.getValue(selectedRow,"TEMPLATE_VERSION_ID");
	var aWorkFlowCode = tableSet.getValue(selectedRow,"TEMPLATE_TAG");     
	var regionID = tableSet.getValue(selectedRow,"REGION_ID");      
	var param = "?workflow_id="+aWorkFlowId+"&template_id="+aTemplateId+"&task_tag="+aWorkFlowCode+"&regionID="+regionID;
	window.open("<%=request.getContextPath()%>/workflow/SvgView.jsp"+param,"","scroll=yes,resizable=no,status=no,help=no,height=650px,width=720px");
  }
}
function checkBusiTypeAction(){
  var selectedRow = -1;
  var tableSet = getSETTaskInfoTable();
  selectedRow = tableSet.getRow();
  if(selectedRow < 0){
  	  g_AIButtonManager.get("btn_print").setDisabled(true);
      g_AIButtonManager.get("btn_ok").setDisabled(true);
  }else {
  	//var aTaskId = tableSet.getValue(selectedRow,"TASK_ID"); 
  	//var queueID = tableSet.getValue(selectedRow,"QUEUE_ID"); 
  	//var regionID = tableSet.getValue(selectedRow,"REGION_ID"); 
  	//var postURL = "<%=request.getContextPath()%>/business/com.ai.comframe.config.action.WorkflowAction?action=checkBusiTypeAction";
    //var param =  "&queueID="+queueID+"&aTaskId="+aTaskId+getCenterStr(regionID);
     //var retObj = PostInfo(postURL+param,"");
    //var flag = retObj.getValueByName("retVal");
    var flag = tableSet.getValue(selectedRow,"STATE"); 
    if(flag=="N"){
        alert(retObj.getValueByName("retMsg"));
    }else if(flag=="5"){
      g_AIButtonManager.get("btn_print").setDisabled(true);
      g_AIButtonManager.get("btn_ok").setDisabled(false);
    }else if(flag=="9"){
      g_AIButtonManager.get("btn_print").setDisabled(false);
      g_AIButtonManager.get("btn_ok").setDisabled(true);
    }else{
    	g_AIButtonManager.get("btn_print").setDisabled(true);
        g_AIButtonManager.get("btn_ok").setDisabled(true);
    }
  }
}
init();
</script>
</html>
