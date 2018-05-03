<%@ page contentType="text/html; charset=GBK" %>
<%@page import="com.ai.comframe.locale.ComframeLocaleFactory"%>
<%@page import="com.ai.comframe.utils.PropertiesUtil"%>
<%@page import="com.ai.comframe.utils.TimeUtil"%>
<%@ include file="/workflow/common/WorkflowHead.jsp"%>
<html>
<head>
<title><i18n:message res="i18n.comframe_resource"  key="comframe.html.workflow.WorkflowInst10"></i18n:message></title></head>
<body>
    <ai:contractframe i18nRes="i18n.comframe_resource" title="html.workfow.templateQuery_query" id="" width="100%">   
      <ai:contractitem>
      <div class="t-bot-mc-button">
      	<ai:button id="qryBtn" i18nRes="i18n.comframe_resource" text="comframe.html.workflow.Alarm28" onclick="qryVmWF()"/>
      </div>
      </ai:contractitem>
      <table border="0" cellpadding="1" cellspacing="2" width="98%">
      	<tr>
          <td class="td_font">
          <i18n:message res="i18n.comframe_resource"  key="comframe.html.workflow.WorkflowInst19"></i18n:message>:</td>          
          <td><input name="txtBusiOrderId" type="text" style="width:170;height:20"/></td>
          <td class="td_font">
          <i18n:message res="i18n.comframe_resource"  key="comframe.html.workflow.WorkflowInst21"></i18n:message>:</td>         
          <td>
           <ai:listbox ds="com.ai.comframe.config.ds.DSWorkObjectType" id="selBusiOrderType" nullid="-1" nulltext="" width="170" />
          </td>
          <td class="td_font">
          <i18n:message res="i18n.comframe_resource"  key="comframe.html.workflow.WorkflowInst25"></i18n:message>:</td>         
          <td><ai:listbox ds="com.ai.comframe.config.ds.DSTaskState" id="lbxState" nullid="-1" nulltext='<%=ComframeLocaleFactory.getResource("comframe.html.workflow.WorkflowInst26") %>' width="170"/></td>
        </tr>
        <tr>    
          <td class="td_font">
          	<i18n:message res="i18n.comframe_resource"  key="comframe.html.workflow.WorkflowInst90"></i18n:message>:</td>          
          <td>
            <input name="txtStartDate" type="text" class="dbform_dbdate_input_style" style="width:150"/><input type="button" class="dbform_dbdate_btn_style" style="width:20" id="start" onClick="getNewDateTime(document.all.item('txtStartDate'))"/>
          </td>
          <td class="td_font"><i18n:message res="i18n.comframe_resource"  key="comframe.html.workflow.WorkflowInst91"></i18n:message>:</td>
          <td><input name="txtEndDate" type="text" class="dbform_dbdate_input_style" style="width:150"/><input type="button" class="dbform_dbdate_btn_style" style="width:20" id="end" onClick="getNewDateTime(document.all.item('txtEndDate'))"/></td>
          <td class="td_font"><i18n:message res="i18n.comframe_resource"  key="html.workflow.alarm_queue"></i18n:message>:</td>         
          <td>
           <ai:listbox ds="com.ai.comframe.config.ds.DSQueue" id="queue"  width="170" />
          </td>
          </tr>
          <tr>
          	  <td class="td_font"><i18n:message res="i18n.comframe_resource"  key="html.workflow.startWorkflow_area"></i18n:message>:</td>          
	          <td>
	            <input name="regionID" type="text"  style="width:170"/>
	          </td>  
	         
	          <td id="histd" class="td_font"><i18n:message res="i18n.comframe_resource"  key="html.workflow.workflowHisInst_hisdate"></i18n:message>:</td>          
	          <td id="hisvalue">
	            <ai:listbox ds="com.ai.comframe.config.ds.DSHisDate" id="hisDate"  width="170" />
	          </td> 

          </tr>
      </table>
    </ai:contractframe>
    <ai:contractframe title="comframe.html.workflow.WorkflowInst42" id="comframe.html.workflow.WorkflowInst42" i18nRes="i18n.comframe_resource" width="100%">
  		<ai:contractitem>
  			<div class="t-bot-mc-word"><span class="font_red"><i18n:message res="i18n.comframe_resource"  key="comframe.html.workflow.Alarm87"></i18n:message></span><i18n:message res="i18n.comframe_resource"  key="comframe.html.workflow.WorkflowInst92"></i18n:message></div>
  		</ai:contractitem>
           <ai:table tableid="workflowTable" setname="com.ai.comframe.config.set.SETVmWF"
                    tablemodel="com.ai.appframe2.web.datamodel.MethodModelForService"
                    implservice_name="com.ai.comframe.config.service.interfaces.IWorkflowConsoleSV"
                    implservice_querymethod="queryHisWorkflow(String sdate,String regionID,String queueID,String busiOrderId,String busiOrderType,int state,String startTime,String endTime,int $STARTROWINDEX,int $ENDROWINDEX)"
                    implservice_countmethod="getHVmWorkflowCount(String sdate,String regionID,String queueID,String busiOrderId,String busiOrderType,int state,String startTime,String endTime)"
					width="100%" oncontextmenu="showWorkFlow"
					height="160" pagesize="7" onrowchange="showSrvErrMsg"
					needrefresh="true" multiselect="false" initial="false"
					editable="false" >
           			<ai:col fieldname="WORKFLOW_ID" width="100" visible="true" />
					<ai:col fieldname="LABEL" width="120" visible="true" />
					<ai:col fieldname="TEMPLATE_TAG" width="165" visible="true" />
					<ai:col fieldname="WORKfLOW_OBJECT_ID" width="100" visible="true" />
					<ai:col fieldname="WORKFLOW_OBJECT_TYPE" width="100" visible="true" />
					<ai:col fieldname="QUEUE_ID" width="100" visible="true" />
					<ai:col fieldname="STATE" width="100" visible="true" />
					<ai:col fieldname="CREATE_DATE" width="150" visible="true" />
					<ai:col fieldname="STATE_DATE" width="150" visible="true" />
					<ai:col fieldname="CURRENT_TASK_ID" width="165" visible="true" />
					<ai:col fieldname="CREATE_STAFF_ID" width="165" visible="true" />
					<ai:col fieldname="VARS" width="200" visible="false" />
					<ai:col fieldname="ERROR_MESSAGE" width="165" visible="false" />
					<ai:col fieldname="ENGINE_WORKFLOW_ID" width="165" visible="true" />
					<ai:col fieldname="ENGINE_TYPE" width="165" visible="true" />
			        <ai:col fieldname="PARENT_TASK_ID" width="100" visible="true" />
			        <ai:col fieldname="WORKFLOW_TEMPLATE_ID" width="100" visible="true" />
			        <ai:col fieldname="WARNING_DATE" width="100" visible="true" />
			        <ai:col fieldname="WARNING_TIMES" width="100" visible="true" />
			        <ai:col fieldname="ERROR_MESSAGE" width="100" visible="false" />
			        <ai:col fieldname="REGION_ID" width="100" visible="false" />
			        <ai:col fieldname="TRANSFER_DATE" width="100" visible="false" />
        </ai:table>
        <table  width="99%" align="center" border="0" cellpadding="1" cellspacing="2">
        <tr><td><TEXTAREA style="width:100%;height:50;" ID="txtTableErr" readonly="readonly"></TEXTAREA></td>
      </tr>
      </table>
</ai:contractframe>
<ai:contractframe title="comframe.html.workflow.WorkflowInst84"  i18nRes="i18n.comframe_resource" id="comframe.html.workflow.WorkflowInst84" width="100%">
	<ai:contractitem>
		<div class="t-bot-mc-word"><span class="font_red"><i18n:message res="i18n.comframe_resource"  key="comframe.html.workflow.Alarm87"></i18n:message></span><i18n:message res="i18n.comframe_resource"  key="comframe.html.workflow.WorkflowInst93"></i18n:message></div>
	</ai:contractitem>
	<ai:table tableid="task" setname="com.ai.comframe.config.set.SETVmTask"
			tablemodel="com.ai.appframe2.web.datamodel.MethodModelForService"
            implservice_name="com.ai.comframe.config.service.interfaces.IWorkflowConsoleSV"
            implservice_querymethod="queryHVmTask(Date sdate,String workflowId,int workflowState)"
             width="100%" initial="false" onrowchange="qryTaskTrans" 
			height="150" pagesize="20" needrefresh="true" multiselect="false"  oncontextmenu="showTask"
			editable="false" footdisplay="none">
			<ai:col fieldname="TASK_ID" width="100" visible="true" />
			<ai:col fieldname="WORKFLOW_ID" width="165" visible="false" />
			<ai:col fieldname="TASK_TEMPLATE_ID" width="165" visible="false" />
			<ai:col fieldname="TASK_TYPE" width="80" visible="true" />
			<ai:col fieldname="LABEL" width="100" visible="true" />
			<ai:col fieldname="DECISION_RESULT" width="100" visible="true" />
			<ai:col fieldname="IS_CURRENT_TASK" width="100" />
			<ai:col fieldname="STATE" width="100" visible="true" />
			<ai:col fieldname="CREATE_DATE" width="130" visible="true" />
			<ai:col fieldname="STATE_DATE" width="130" visible="true" />
			<ai:col fieldname="FINISH_STAFF_ID" visible="true" />
			<ai:col fieldname="ERROR_MESSAGE" visible="true" />
			<ai:col fieldname="LOCK_STAFF_ID" visible="true" />
			<ai:col fieldname="LOCK_DATE" width="130" visible="true" />
			<ai:col fieldname="TASK_STAFF_ID" visible="true" />
			<ai:col fieldname="STATION_ID" visible="true" />
			<ai:col fieldname="WARNING_DATE" visible="true" />
			<ai:col fieldname="WARNING_TIMES" visible="true" />
			<ai:col fieldname="REGION_ID" width="100" visible="false" />
			<ai:col fieldname="TRANSFER_DATE" width="100" visible="false" />
			</ai:table>
</ai:contractframe>
<ai:contractframe title="comframe.html.workflow.WorkflowInst118" i18nRes="i18n.comframe_resource" id="comframe.html.workflow.WorkflowInst118" width="100%">
	<ai:contractitem></ai:contractitem>
	<ai:table tableid="tasktrans" setname="com.ai.comframe.config.set.SETVmTaskTS"
			tablemodel="com.ai.appframe2.web.datamodel.MethodModelForService"
            implservice_name="com.ai.comframe.config.service.interfaces.IWorkflowConsoleSV"
            implservice_querymethod="queryHVmTaskTrans(Date sdate,String parentTaskId,String workflowId)"
             width="100%" initial="false"
			height="100" pagesize="5" needrefresh="true" multiselect="false"  oncontextmenu="showTaskTrans"
			editable="false" footdisplay="none">
			<ai:col fieldname="TASK_ID" width="100" visible="true" />
			<ai:col fieldname="PARENT_TASK_ID" width="100" visible="true" />
			<ai:col fieldname="WORKFLOW_ID" width="165" visible="false" />
			<ai:col fieldname="TASK_TYPE" width="80" visible="true" />
			<ai:col fieldname="LABEL" width="100" visible="true" />
			<ai:col fieldname="DECISION_RESULT" width="100" visible="true" />
			<ai:col fieldname="IS_CURRENT_TASK" width="100" />
			<ai:col fieldname="STATE" width="100" visible="true" />
			<ai:col fieldname="CREATE_DATE" width="130" visible="true" />
			<ai:col fieldname="STATE_DATE" width="130" visible="true" />
			<ai:col fieldname="FINISH_STAFF_ID" visible="true" />
			<ai:col fieldname="ERROR_MESSAGE" visible="true" />
			<ai:col fieldname="LOCK_STAFF_ID" visible="true" />
			<ai:col fieldname="LOCK_DATE" width="130" visible="true" />
			<ai:col fieldname="TASK_STAFF_ID" visible="true" />
			<ai:col fieldname="STATION_ID" visible="true" />
			<ai:col fieldname="WARNING_DATE" visible="true" />
			<ai:col fieldname="WARNING_TIMES" visible="true" />
			<ai:col fieldname="REGION_ID" width="100" visible="false" />
			 <ai:col fieldname="TRANSFER_DATE" width="100" visible="false" />
			</ai:table>
</ai:contractframe>
</body>
</html>
<script>
//初始化时间显示
    init();
	var workflowTable = g_TableRowSetManager.get("workflowTable");
	var task = g_TableRowSetManager.get("task");
	var tasktrans = g_TableRowSetManager.get("tasktrans");
	function init(){
  		//var mDate = new Date();
  		//var mYear = mDate.getYear();
  		//var mMonth = mDate.getMonth()+1;
  		//var mDay = mDate.getDate();
  		//if(mMonth<10){
		//	mMonth="0"+mMonth;
  		//}
  		//if(mDay<10){
		//	mDay="0"+mDay;
  		//}
  	var current =  '<%=TimeUtil.getSysDateBySV()%>';//mYear+"-"+mMonth+"-"+mDay;
  	document.all.txtStartDate.value = current+" 00:00:00";
  	document.all.txtEndDate.value = current+" 23:59:59";
}




//双击工作流列表中某一条记录时，在task中显示相应的信息
	function query(){
  		var curRow = workflowTable.getRow();
		var workflowID = workflowTable.getValue(curRow,"WORKFLOW_ID");
		var workflowState = workflowTable.getValue(curRow,"STATE");
		var regionID = workflowTable.getValue(curRow,"REGION_ID");
		var sdate = workflowTable.getValue(curRow,"TRANSFER_DATE");
		
		var condition="sdate="+sdate+"&workflowId="+workflowID+"&workflowState="+workflowState+getCenterStr(regionID);
		task.refresh(condition);
		g_TableRowSetManager.get("tasktrans").clear();
     }

//在工作流列表中单击某一条记录时，显示其中的Error Message
	function showSrvErrMsg(oldRowIndex,newRowIndex){        
		document.all.txtTableErr.value = workflowTable.getValue(newRowIndex,"ERROR_MESSAGE");
		query();
    }

function qryTaskTrans(){
  var curRow = task.getRow();
  var taskId = task.getValue(curRow,"TASK_ID");
  var workflowId = task.getValue(curRow,"WORKFLOW_ID");
  var taskType = task.getValue(curRow,"TASK_TYPE");
   var regionID = task.getValue(curRow,"REGION_ID");
   var sdate = task.getValue(curRow,"TRANSFER_DATE");
  if(taskType != "user" && taskType != "sign"){
    return;
  }
  tasktrans.refresh("sdate="+sdate+"&parentTaskId="+taskId+"&workflowId="+workflowId+getCenterStr(regionID));
}

//查询
function qryVmWF(){
		var queueID=g_getListBox("queue").getValue();
		if(queueID==-1||queueID==""){
			alert(g_I18NMessage("comframe_resources","comframe_html_workflow_workflowInst_queueSelect"));
			return;
		}
 		
 		var workflow_object_id = document.all.txtBusiOrderId.value;
 		var workflow_object_type_id=g_getListBox("selBusiOrderType").getID();
 		var sDate = document.all.txtStartDate.value;
 		var eDate = document.all.txtEndDate.value;
 		var State = g_getListBox("lbxState").getID();
 		var sdate = g_getListBox("hisDate").getID();
 		//if(sdate==""||sdate=="-1"){
 		//	return;
 		//}
 		var cond = "sdate="+sdate+"&regionID="+document.all.regionID.value+"&queueID="+queueID;
 		if(workflow_object_type_id == "-1"){
 		  workflow_object_type_id = "";
 		}
    	if(!g_IsDateTime(sDate)){
	   		alert(g_I18NMessage("comframe_resources","comframe_html_monitor_analyse_AppframeStatSelectByServerId248"));    		
	   		document.all.txtStartDate.value = "";
	   		document.all.txtStartDate.focus();
	   		return;
 		}
 		if(!g_IsDateTime(eDate)){
   			alert(g_I18NMessage("comframe_resources","comframe_html_monitor_analyse_AppframeStatSelectByServerId254"));   				
   			document.all.txtEndDate.value = "";
   			document.all.txtEndDate.focus();
   			return;
 					}
 		if(sDate!="" && eDate!="" && g_CompareDate(sDate ,eDate)=="1"){
  			 alert(g_I18NMessage("comframe_resources","comframe_html_monitor_analyse_AppframeStatSelectByServerId269"));   			 
  			 return;
	}
	if(workflow_object_id == "" && workflow_object_type_id=="" && State == "-1" && sDate == "" && eDate == ""){
	  alert(g_I18NMessage("comframe_resources","comframe_html_workflow_WorkflowInst238"));    	  return;
	}
 		cond += "&busiOrderId=" + workflow_object_id
 		      + "&busiOrderType="+ workflow_object_type_id
 		      + "&state="+State+"&startTime="+sDate+"&endTime="+eDate+getCenterStr(document.all.regionID.value);
	g_TableRowSetManager.get("workflowTable").refresh(cond);
	document.all.txtTableErr.value = "";
	g_TableRowSetManager.get("task").clear();
	g_TableRowSetManager.get("tasktrans").clear();
	if(g_TableRowSetManager.get("workflowTable").count()==0){
	  alert(g_I18NMessage("comframe_resources","comframe_html_monitor_analyse_AppframeStatSelectByServerId277"));		}

}

//工作流列表右键菜单
var popMenuWorkFlow =null;

  		function showWorkFlow(){
  		  taskHide();
  		  var index = g_TableRowSetManager.get("workflowTable").getRow();
	      if(index<0){
	        alert(g_I18NMessage("comframe_resources","comframe_html_workflow_WorkflowInst261"));	        
	        return;
	      }
	      var state= g_TableRowSetManager.get("workflowTable").getValue(index,"STATE");
	     
          buildPopMenuWorkFlow(state);
          if(popMenuWorkFlow != null){
            popMenuWorkFlow.showPopMenu();
          }
		}
		
		function buildPopMenuWorkFlow(state){
		 // alert(state);
		  var modelWorkFlow = new AIPopMenuModel();
		  var param ="flow_state="+state
		  var msg = PostInfo(_gModuleName+"/business/com.ai.comframe.config.action.WorkflowAction?action=getHisWorkflowPopMenu&"+param,"");
                 // alert(msg.getValueByName("MESSAGE"));
		  var strJosn = eval(msg.getValueByName("MESSAGE"));
		   for(var i=0; i<strJosn.length; i++){
		   //  alert(strJosn[i].id+"|"+strJosn[i].name+"|"+strJosn[i].func)
		     modelWorkFlow.addPopMenuItem(i,strJosn[i].name,null,strJosn[i].func);
		   }
		   
		   var dojoMsg = PostInfo(_gModuleName+"/business/com.ai.comframe.config.action.WorkflowAction?action=getDojoHisWorkflowPopMenu&"+param,"");
                 // alert(msg.getValueByName("MESSAGE"));
		  var strJosn = eval(dojoMsg.getValueByName("MESSAGE"));
		   for(var i=0; i<strJosn.length; i++){
		   //  alert(strJosn[i].id+"|"+strJosn[i].name+"|"+strJosn[i].func)
		     modelWorkFlow.addPopMenuItem(i+1,strJosn[i].name,null,strJosn[i].func);
		   }
   	           popMenuWorkFlow =new AIPopMenu(modelWorkFlow)
		   for(var i=0; i<strJosn.length; i++){
               if(strJosn[i].enable =='false'){
                 //alert(strJosn[i].id +"：" + strJosn[i].enable);
                 popMenuWorkFlow.setItemEnabledById( i +"",false);
               }
		   }
		}

//暂停工作流
function suspendWorkflow(){
	var index = g_TableRowSetManager.get("workflowTable").getRow();
	var taskId= g_TableRowSetManager.get("workflowTable").getValue(index,"WORKFLOW_ID");
	var regionID = g_TableRowSetManager.get("workflowTable").getValue(index,"REGION_ID");
	if (index<0){
		   alert(g_I18NMessage("comframe_resources","comframe_html_workflow_WorkflowInst295"));		   
		   return;
	}
	var rtn = saveRowSet('<%=request.getContextPath()%>/business/com.ai.comframe.config.action.WorkflowAction?action=suspendWorkflow&TASK_ID='+taskId+getCenterStr(regionID),false);
	var ret = rtn.getValueByName("FLAG");
    if (ret == "INFO"){
         qryVmWF();
    }
}

//恢复工作流
function resumeWorkflow(){
	var index = g_TableRowSetManager.get("workflowTable").getRow();
	var taskId= g_TableRowSetManager.get("workflowTable").getValue(index,"WORKFLOW_ID");
	var regionID = g_TableRowSetManager.get("workflowTable").getValue(index,"REGION_ID");
	if (index<0){
		   alert(g_I18NMessage("comframe_resources","comframe_html_workflow_WorkflowInst295"));		   
		   return;
	}
	var rtn = saveRowSet('<%=request.getContextPath()%>/business/com.ai.comframe.config.action.WorkflowAction?action=resumeWorkflow&TASK_ID='+taskId+getCenterStr(regionID),false);
	var ret = rtn.getValueByName("FLAG");
    if (ret == "INFO"){
         qryVmWF();
    }
}

//终止工作流
function terminateWorkflow(){
	var index = g_TableRowSetManager.get("workflowTable").getRow();
	var taskId= g_TableRowSetManager.get("workflowTable").getValue(index,"WORKFLOW_ID");
	var regionID = g_TableRowSetManager.get("workflowTable").getValue(index,"REGION_ID");
	if (index<0){
		   alert(g_I18NMessage("comframe_resources","comframe_html_workflow_WorkflowInst326"));		   
		   return;
	}
  if(!confirm(g_I18NMessage("comframe_resources","comframe_html_workflow_WorkflowInst329"))){    
	  return;
  }
	var rtn = saveRowSet('<%=request.getContextPath()%>/business/com.ai.comframe.config.action.WorkflowAction?action=terminateWorkflow&WORKFLOW_ID='+taskId+getCenterStr(regionID),false);
	var ret = rtn.getValueByName("FLAG");
    if (ret == "INFO"){
         qryVmWF();
    }
}
//停止工作流告警
function stopWarningWorkflow(){
	var index = g_TableRowSetManager.get("workflowTable").getRow();
	var taskId= g_TableRowSetManager.get("workflowTable").getValue(index,"WORKFLOW_ID");
	var warningTimes=g_TableRowSetManager.get("workflowTable").getValue(index,"WARNING_TIMES");
	var warningDate=g_TableRowSetManager.get("workflowTable").getValue(index,"WARNING_DATE");
	var regionID=g_TableRowSetManager.get("workflowTable").getValue(index,"REGION_ID");
	if (warningDate==null||warningDate=="null"||warningDate=="undefined"||warningDate==""){
		alert(g_I18NMessage("comframe_resources","comframe_html_workflow_WorkflowInst346"));		return;
	}
	if (warningTimes==null||warningTimes=="null"||warningTimes=="undefined"||warningTimes==""){
		warningTimes=0;
	}
	if (index<0){
		   alert(g_I18NMessage("comframe_resources","comframe_html_workflow_WorkflowInst326"));		   return;
	}
  if(!confirm(g_I18NMessage("comframe_resources","comframe_html_workflow_WorkflowInst356"))){    return;
  }
	var rtn = saveRowSet('<%=request.getContextPath()%>/business/com.ai.comframe.config.action.WorkflowAction?action=stopWarning&TASK_ID='+taskId+'&WARNING_TIMES='+warningTimes+'&TYPE=workflow'+getCenterStr(regionID),false);
	var ret = rtn.getValueByName("FLAG");

    qryVmWF();
  
}
//删除流程数据
function dropWorkflow(){
	var index = g_TableRowSetManager.get("workflowTable").getRow();
	var taskId= g_TableRowSetManager.get("workflowTable").getValue(index,"WORKFLOW_ID");
	var regionID= g_TableRowSetManager.get("workflowTable").getValue(index,"REGION_ID");
	if (index<0){
		   alert(g_I18NMessage("comframe_resources","comframe_html_workflow_WorkflowInst326"));
		   return;
	}
  if(!confirm(g_I18NMessage("comframe_resources","comframe_html_workflow_WorkflowInst373"))){    return;
  }
	var rtn =saveRowSet('<%=request.getContextPath()%>/business/com.ai.comframe.config.action.WorkflowAction?action=dropWorkflow&TASK_ID='+taskId+getCenterStr(regionID),false);
	ret = rtn.getValueByName("FLAG");
	if (ret == "INFO"){
         qryVmWF();
    }
}

//生成SVG图
function toSvg(){
	var index = g_TableRowSetManager.get("workflowTable").getRow();
	var workflow_id= g_TableRowSetManager.get("workflowTable").getValue(index,"WORKFLOW_ID");
	var regionID= g_TableRowSetManager.get("workflowTable").getValue(index,"REGION_ID");
	var sdate = g_TableRowSetManager.get("workflowTable").getValue(index,"TRANSFER_DATE");
	if (index<0){
		   alert(g_I18NMessage("comframe_resources","comframe_html_workflow_WorkflowInst326"));		   
		   return;
	}
 	window.open("HSvgView.jsp?workflow_id="+workflow_id+getCenterStr(regionID)+"&regionID="+regionID+"&sdate="+sdate,"","scroll=yes,resizable=no,status=no,help=no,height=680px,width=720px");

}

//生成DOJO图
function toDojo(){
	var index = g_TableRowSetManager.get("workflowTable").getRow();
	var workflow_id= g_TableRowSetManager.get("workflowTable").getValue(index,"WORKFLOW_ID");
	var regionID= g_TableRowSetManager.get("workflowTable").getValue(index,"REGION_ID");
	var sdate = g_TableRowSetManager.get("workflowTable").getValue(index,"TRANSFER_DATE");
	if (index<0){
		   alert(g_I18NMessage("comframe_resources","comframe_html_workflow_WorkflowInst326"));		   
		   return;
	}
 	window.open("HDojoView.jsp?workflow_id="+workflow_id+getCenterStr(regionID)+"&regionID="+regionID+"&sdate="+sdate,"","scroll=yes,resizable=no,status=no,help=no,height=680px,width=1024px ");
}

//获取流程实例变量
function getWorkflowVars(){
var s=Math.random()*10000;
	var index = g_TableRowSetManager.get("workflowTable").getRow();

	if (index<0){
		   alert(g_I18NMessage("comframe_resources","comframe_html_workflow_WorkflowInst326"));		   return;
	}

	var workflowId= g_TableRowSetManager.get("workflowTable").getValue(index,"WORKFLOW_ID");
	var templateTag= g_TableRowSetManager.get("workflowTable").getValue(index,"TEMPLATE_TAG");
	var regionID= g_TableRowSetManager.get("workflowTable").getValue(index,"REGION_ID");
	var url = "InstVars.jsp?showType=view&workflowId="+workflowId+"&templateTag="+templateTag+"&rand="+s+"&regionID="+regionID;
	window.showModalDialog(url,null,"resizable:no;status:no;help:no;dialogHeight:400px;dialogWidth:600px");
}

//设置流程实例变量
function setWorkflowVars(){
	var s=Math.random()*10000;
	var index = g_TableRowSetManager.get("workflowTable").getRow();
	if (index<0){
		   alert(g_I18NMessage("comframe_resources","comframe_html_workflow_WorkflowInst326"));		   
		   return;
	}
	var workflowId= g_TableRowSetManager.get("workflowTable").getValue(index,"WORKFLOW_ID");
	var templateTag= g_TableRowSetManager.get("workflowTable").getValue(index,"TEMPLATE_TAG");
	var regionID= g_TableRowSetManager.get("workflowTable").getValue(index,"REGION_ID");
	var url = "InstVars.jsp?showType=edit&workflowId="+workflowId+"&templateTag="+templateTag+"&rand="+s+"&regionID="+regionID;
	window.showModalDialog(url,null,"resizable:no;status:no;help:no;dialogHeight:400px;dialogWidth:600px");
}

//任务列表右键菜单
var popMenu = null;
document.onclick = taskHide;
  	//点击左键 菜单隐藏
function taskHide(){
    if(popMenuWorkFlow!=null)
      popMenuWorkFlow.hidePopMenu();
    if(popMenu!=null)
   		  popMenu.hidePopMenu();
   		  if(popMenuTrans != null){
   		    popMenuTrans.hidePopMenu();
   		  }
}
		
		//点击右键 显示右键菜单
function showTask(){
 	taskHide();
 	var indexw = g_TableRowSetManager.get("workflowTable").getRow();
    var workflowstate= g_TableRowSetManager.get("workflowTable").getValue(indexw,"STATE");
    var regionID= g_TableRowSetManager.get("workflowTable").getValue(indexw,"REGION_ID");
 	var index = g_TableRowSetManager.get("task").getRow();
    if(index<0){
      alert(g_I18NMessage("comframe_resources","comframe_html_workflow_WorkflowInst454"));	
      return;
    }
    var taskstate= g_TableRowSetManager.get("task").getValue(index,"STATE");
    // buildPopMenuTask(workflowstate,taskstate)
    if(popMenu != null){
      popMenu.showPopMenu();
    }
}
function buildPopMenuTask(workflowstate,state){

var modelTask = new AIPopMenuModel();
var param ="flow_state="+workflowstate+"&task_state="+state
var msg = PostInfo(_gModuleName+"/business/com.ai.comframe.config.action.WorkflowAction?action=getWorkflowTaskPopMenu&"+param,"");
var strJosn = eval(msg.getValueByName("MESSAGE"));
      for(var i=0; i<strJosn.length; i++){
                 //alert(strJosn[i].id+"|"+strJosn[i].name+"|"+strJosn[i].func)
          modelTask.addPopMenuItem(strJosn[i].id,strJosn[i].name,null,strJosn[i].func);
      }
      popMenu =new AIPopMenu(modelTask)
      for(var i=0; i<strJosn.length; i++){
         if(strJosn[i].enable =='false'){
            popMenu.setItemEnabledById(strJosn[i].id,false);
         }
 }
 }
//任务回单
function finishUserTask(){
	var s=Math.random()*10000;
  	var indexW = g_TableRowSetManager.get("workflowTable").getRow();
	if (indexW<0){
		   alert(g_I18NMessage("comframe_resources","comframe_html_workflow_WorkflowInst326"));		   return;
	}
	var indexT = g_TableRowSetManager.get("task").getRow();
	if (indexT<0){
		   alert(g_I18NMessage("comframe_resources","comframe_html_workflow_WorkflowInst493"));		   return;
	}
	var taskId= g_TableRowSetManager.get("task").getValue(indexT,"TASK_ID");
	var state= g_TableRowSetManager.get("task").getValue(indexT,"STATE");
	var regionID= g_TableRowSetManager.get("task").getValue(indexT,"REGION_ID");
	var workflowId= g_TableRowSetManager.get("workflowTable").getValue(indexW,"WORKFLOW_ID");
	var templateTag= g_TableRowSetManager.get("workflowTable").getValue(indexW,"TEMPLATE_TAG");
	var url = "InstVars.jsp?showType=dealTask&workflowId="+workflowId+"&templateTag="+templateTag+"&rand="+s+"&regionID="+regionID;
	var vars = window.showModalDialog(url,null,"resizable:no;status:no;help:no;dialogHeight:400px;dialogWidth:600px");
	if(vars == null){
	  return;
	}
	
	var dealResult=prompt(g_I18NMessage("comframe_resources","comframe_html_workflow_WorkflowInst509")+":","");	if(dealResult == null){
    return;
  }
  while(dealResult != null && dealResult.length == 0){
    alert(g_I18NMessage("comframe_resources","comframe_html_workflow_WorkflowInst509"));    
    dealResult = prompt(g_I18NMessage("comframe_resources", "comframe_html_workflow_WorkflowInst509")+":","");  }

	var rtn = saveRowSet("<%=request.getContextPath()%>/business/com.ai.comframe.config.action.WorkflowAction?action=finishUserTask&taskId="+taskId+"&vars="+vars+"&result="+dealResult+getCenterStr(regionID),false);
	var ret = rtn.getValueByName("FLAG");
  if (ret == "INFO"){
    qryVmWF();
  }
}
//停止任务告警
function stopWarningTask(){
	var indexW = g_TableRowSetManager.get("workflowTable").getRow();
	if (indexW<0){
		   alert(g_I18NMessage("comframe_resources","comframe_html_workflow_WorkflowInst326"));		   return;
	}
	var indexT = g_TableRowSetManager.get("task").getRow();
	if (indexT<0){
		   alert(g_I18NMessage("comframe_resources","comframe_html_workflow_WorkflowInst533"));		   return;
	}
	var taskId= g_TableRowSetManager.get("task").getValue(indexT,"TASK_ID");
	var warningTimes=g_TableRowSetManager.get("task").getValue(indexT,"WARNING_TIMES");
	var warningDate=g_TableRowSetManager.get("task").getValue(indexT,"WARNING_DATE");
	var regionID=g_TableRowSetManager.get("task").getValue(indexT,"REGION_ID");
	if (warningDate==null||warningDate=="null"||warningDate=="undefined"||warningDate==""){
		alert(g_I18NMessage("comframe_resources","comframe_html_workflow_WorkflowInst540"));		return;
	}
	if (warningTimes==null||warningTimes=="null"||warningTimes=="undefined"||warningTimes==""){
		warningTimes=0;
	}
  if(!confirm(g_I18NMessage("comframe_resources","comframe_html_workflow_WorkflowInst546"))){    return;
  }
	var rtn = saveRowSet('<%=request.getContextPath()%>/business/com.ai.comframe.config.action.WorkflowAction?action=stopWarning&TASK_ID='+taskId+'&WARNING_TIMES='+warningTimes+'&TYPE=task'+getCenterStr(regionID),false);
	var ret = rtn.getValueByName("FLAG");
    
    qryVmWF();

}
//锁定任务
function lockTask(){
	var index = g_TableRowSetManager.get("task").getRow();
	var taskId= g_TableRowSetManager.get("task").getValue(index,"TASK_ID");
	var regionID= g_TableRowSetManager.get("task").getValue(index,"REGION_ID");
	if (index<0){
		   alert(g_I18NMessage("comframe_resources","comframe_html_workflow_WorkflowInst326"));		   return;
	}
	saveRowSet('<%=request.getContextPath()%>/business/com.ai.comframe.config.action.WorkflowAction?action=lockTask&TASK_ID='+taskId+getCenterStr(regionID),false);


}

//释放锁定的任务
function releaseTask(){

	var index = g_TableRowSetManager.get("task").getRow();
	var taskId= g_TableRowSetManager.get("task").getValue(index,"TASK_ID");
	var regionID= g_TableRowSetManager.get("task").getValue(index,"REGION_ID");
	if (index<0){
		   alert(g_I18NMessage("comframe_resources","comframe_html_workflow_WorkflowInst326"));		   return;
	}
	saveRowSet('<%=request.getContextPath()%>/business/com.ai.comframe.config.action.WorkflowAction?action=releaseTaskLock&TASK_ID='+taskId+getCenterStr(regionID),false);

}
//跳转到指定任务
function jumpToTask(){
	var indexW = g_TableRowSetManager.get("workflowTable").getRow();
	if (indexW<0){
		   alert(g_I18NMessage("comframe_resources","comframe_html_workflow_WorkflowInst326"));			   return;
	}
	
	var indexT = g_TableRowSetManager.get("task").getRow();
	if (indexT<0){
		   alert(g_I18NMessage("comframe_resources","comframe_html_workflow_WorkflowInst590"));			   return;
	}
	var workflowId= g_TableRowSetManager.get("workflowTable").getValue(indexW,"WORKFLOW_ID");	
	var templateTag= g_TableRowSetManager.get("workflowTable").getValue(indexW,"TEMPLATE_TAG");
	var taskId= g_TableRowSetManager.get("task").getValue(indexT,"TASK_ID");	
	var state= g_TableRowSetManager.get("task").getValue(indexT,"STATE");
	var regionID= g_TableRowSetManager.get("task").getValue(indexT,"REGION_ID");

	var param = window.showModalDialog("GoBackTask.jsp?workflowId="+ workflowId+"&task_tag="+templateTag+"&regionID="+regionID,null,"resizable:no;status:no;help:no;dialogHeight:750px;dialogWidth:630px");
	if(param == null){
	  return;
	}
	
	var dealInfo=prompt(g_I18NMessage("comframe_resources","comframe_html_workflow_WorkflowInst603")+":","");	
	if(dealInfo == null){
    return;
  }
  while(dealInfo != null && dealInfo.length == 0){
    alert(g_I18NMessage("comframe_resources","comframe_html_workflow_WorkflowInst603"));    
    dealInfo = prompt(g_I18NMessage("comframe_resources","comframe_html_workflow_WorkflowInst603")+":","");  }
	var tmp = param.split("$$");
	var taskTemplateId = tmp[0];
	var vars = "";
	if(param.length > 1){
	  vars = tmp[1];
	}
	var url = "<%=request.getContextPath()%>/business/com.ai.comframe.config.action.WorkflowAction?action=jumpToTask"
	        + "&taskId="+taskId+"&taskTemplateId="+taskTemplateId+"&vars="+vars+"&notes="+dealInfo+getCenterStr(regionID);
	var rtn = saveRowSet(url,false);
	var ret = rtn.getValueByName("FLAG");
  if (ret == "INFO"){
    qryVmWF();
  }
}
//回退到指定任务
function goBackToTask(){
	var indexW = g_TableRowSetManager.get("workflowTable").getRow();
	if (indexW<0){
		   alert(g_I18NMessage("comframe_resources","comframe_html_workflow_WorkflowInst326"));			   return;
	}
	
	var indexT = g_TableRowSetManager.get("task").getRow();
	if (indexT<0){
		   alert(g_I18NMessage("comframe_resources","comframe_html_workflow_WorkflowInst635"));			   return;
	}
	var workflowId= g_TableRowSetManager.get("workflowTable").getValue(indexW,"WORKFLOW_ID");	
	var templateTag= g_TableRowSetManager.get("workflowTable").getValue(indexW,"TEMPLATE_TAG");
	var taskId= g_TableRowSetManager.get("task").getValue(indexT,"TASK_ID");	
	var state= g_TableRowSetManager.get("task").getValue(indexT,"STATE");
	var regionID= g_TableRowSetManager.get("task").getValue(indexT,"REGION_ID");

	var param = window.showModalDialog("GoBackTask.jsp?workflowId="+ workflowId+"&templateTag="+templateTag+"&regionID="+regionID,null,"resizable:no;status:no;help:no;dialogHeight:750px;dialogWidth:630px");
	if(param == null){
	  return;
	}
	var dealInfo=prompt(g_I18NMessage("comframe_resources","comframe_html_workflow_WorkflowInst648")+":","");	if(dealInfo == null){
    return;
  }
  while(dealInfo != null && dealInfo.length == 0){
    alert(g_I18NMessage("comframe_resources","comframe_html_workflow_WorkflowInst648"));    
    dealInfo = prompt(g_I18NMessage("comframe_resources","comframe_html_workflow_WorkflowInst648")+":","");  }
	var tmp = param.split("$$");
	var taskTemplateId = tmp[0];
	var vars = "";
	if(param.length > 1){
	  vars = tmp[1];
	}
	var url = "<%=request.getContextPath()%>/business/com.ai.comframe.config.action.WorkflowAction?action=goBackToTask"
	        + "&taskId="+taskId+"&taskTemplateId="+taskTemplateId+"&vars="+vars+"&notes="+dealInfo+getCenterStr(regionID);
	var rtn = saveRowSet(url,false);
	var ret = rtn.getValueByName("FLAG");
  if (ret == "INFO"){
    qryVmWF();
  }
}

//设置为已打印
function printUserTask(){
	var indexW = g_TableRowSetManager.get("workflowTable").getRow();
	if (indexW<0){
		   alert(g_I18NMessage("comframe_resources","comframe_html_workflow_WorkflowInst326"));			   return;
	}
	var indexT = g_TableRowSetManager.get("task").getRow();
	if (indexT<0){
		   alert(g_I18NMessage("comframe_resources","comframe_html_workflow_WorkflowInst680"));			   return;
	}
	
	var taskId= g_TableRowSetManager.get("task").getValue(indexT,"TASK_ID");	
	var state= g_TableRowSetManager.get("task").getValue(indexT,"STATE");
	var regionID= g_TableRowSetManager.get("task").getValue(indexT,"REGION_ID");
		
	var workflowId= g_TableRowSetManager.get("workflowTable").getValue(indexW,"WORKFLOW_ID");	
	var templateTag= g_TableRowSetManager.get("workflowTable").getValue(indexW,"TEMPLATE_TAG");	
	var url = "InstVars.jsp?showType=dealTask&workflowId="+workflowId+"&templateTag="+templateTag;
	
	var vars = window.showModalDialog(url,null,"resizable:no;status:no;help:no;dialogHeight:400px;dialogWidth:600px");
	if(vars == null){
	  return;
	}
	
	var rtn = saveRowSet("<%=request.getContextPath()%>/business/com.ai.comframe.config.action.WorkflowAction?action=printUserTask&taskId="+taskId+"&vars="+vars+getCenterStr(regionID),false);
	var ret = rtn.getValueByName("FLAG");
  if (ret == "INFO"){
    qryVmWF();
  }
}

//释放异常
function fireException(){
	var index = g_TableRowSetManager.get("task").getRow();
	var taskId= g_TableRowSetManager.get("task").getValue(index,"TASK_ID");
	var regionID= g_TableRowSetManager.get("task").getValue(index,"REGION_ID");
	if (index<0){
		   alert(g_I18NMessage("comframe_resources","comframe_html_workflow_WorkflowInst454"));		   return;
	}
	var dealInfo=prompt(g_I18NMessage("comframe_resources","comframe_html_workflow_WorkflowInst711")+":","");	if(dealInfo == null){
    return;
  }
  while(dealInfo != null && dealInfo.length == 0){
    alert(g_I18NMessage("comframe_resources","comframe_html_workflow_WorkflowInst716"));    
    dealInfo = prompt(g_I18NMessage("comframe_resources","comframe_html_workflow_WorkflowInst711")+":","");  }
	var rtn = saveRowSet('<%=request.getContextPath()%>/business/com.ai.comframe.config.action.WorkflowAction?action=fireException&TASK_ID='+taskId+'&errorCode='+dealInfo+getCenterStr(regionID),false);
  var ret = rtn.getValueByName("FLAG");
  if (ret == "INFO"){
    qryVmWF();
  }
}

//流程撤销
function cancelWorkflow(){
	var index = g_TableRowSetManager.get("workflowTable").getRow();
	var workflowID= g_TableRowSetManager.get("workflowTable").getValue(index,"WORKFLOW_ID");
	var regionID= g_TableRowSetManager.get("workflowTable").getValue(index,"REGION_ID");
	if (index<0){
		   alert(g_I18NMessage("comframe_resources","comframe_html_workflow_WorkflowInst326"));		   return;
	}
	var dealInfo=prompt(g_I18NMessage("comframe_resources","comframe_html_workflow_WorkflowInst711")+":","");
		if(dealInfo == null){
    return;
  }
  while(dealInfo != null && dealInfo.length == 0){
    alert(g_I18NMessage("comframe_resources","comframe_html_workflow_WorkflowInst716"));
    dealInfo = prompt(g_I18NMessage("comframe_resources","comframe_html_workflow_WorkflowInst711")+":","");  }
	var rtn = saveRowSet('<%=request.getContextPath()%>/business/com.ai.comframe.config.action.WorkflowAction?action=cancelWorkflow&WORKFLOW_ID='+workflowID+'&errorCode='+dealInfo+getCenterStr(regionID),false);
  var ret = rtn.getValueByName("FLAG");
  if (ret == "INFO"){
    qryVmWF();
  }
}

//再授权处理
function reAuthorizeTask(){
	var index = g_TableRowSetManager.get("task").getRow();
	if (index<0){
		   alert(g_I18NMessage("comframe_resources","comframe_html_workflow_WorkflowInst454"));		   return;
	}
	
	var param = window.showModalDialog("StaffSelect.jsp",null,"resizable:no;status:no;help:no;dialogHeight:200px;dialogWidth:400px");
	if(param == null){
	  return;
	}
	if(!confirm(g_I18NMessage("comframe_resources","comframe_html_workflow_WorkflowInst761"))){	  return;
	}
	
	var taskId= g_TableRowSetManager.get("task").getValue(index,"TASK_ID");
	var regionID= g_TableRowSetManager.get("task").getValue(index,"REGION_ID");
	
	var url = "<%=request.getContextPath()%>/business/com.ai.comframe.config.action.WorkflowAction?action=reAuthorizeTask&taskId="
	        + taskId + "&staffId="+param[0]+"&stationId="+param[1]+getCenterStr(regionID);
	var rtn = saveRowSet(url,false);
  var ret = rtn.getValueByName("FLAG");
  if (ret == "INFO"){
    qryVmWF();
  }
}

function resumeExceptionWorkflow(){
  var curRow = workflowTable.getRow();
  if(curRow<0){
    alert(g_I18NMessage("comframe_resources","comframe_html_workflow_WorkflowInst326"));    return;
  }
  var state = workflowTable.getValue(curRow,"state");

  if(!confirm(g_I18NMessage("comframe_resources","comframe_html_workflow_WorkflowInst784"))){    return;
  }
  var workflow_id = workflowTable.getValue(curRow,"WORKFLOW_ID");
  var regionID = workflowTable.getValue(curRow,"REGION_ID");
  var param = "TASK_ID="+workflow_id+getCenterStr(regionID);
  var msg = PostInfo(_gModuleName+"/business/com.ai.comframe.config.action.WorkflowAction?action=resumeExceptionWorkflow&"+param,"");
  var flag=msg.getValueByName("FLAG");
  if(flag=="INFO"){
	qryVmWF();
  }
  else{
	alert(msg.getValueByName("MESSAGE"));
  }
}

 function startExceptionWorkFlow(){
 	var index = g_TableRowSetManager.get("workflowTable").getRow();
	var taskId= g_TableRowSetManager.get("workflowTable").getValue(index,"WORKFLOW_ID");
	var state= g_TableRowSetManager.get("workflowTable").getValue(index,"STATE");
	
	var queueId =g_TableRowSetManager.get("workflowTable").getValue(index,"QUEUE_ID");
	var workFlowTypeId =g_TableRowSetManager.get("workflowTable").getValue(index,"WORKfLOW_OBJECT_TYPE_ID");
	var workFlowObjId =g_TableRowSetManager.get("workflowTable").getValue(index,"WORKfLOW_OBJECT_ID");
	var regionID =g_TableRowSetManager.get("workflowTable").getValue(index,"REGION_ID");
	var param ="?task_id="+taskId+"&workflow_obj_type="+workFlowTypeId+"&workflow_obj_id="+workFlowObjId;
	param =param+"&queue_id="+queueId+getCenterStr(regionID);
	//alert(param);

    var rtn=window.showModalDialog("ManualStartExceptionWorkFlow.jsp"+param,window,"resizable:no;status:no;help:no;dialogHeight:585px;dialogWidth:600px");
    if (rtn == 1)
        qryVmWF();

  }
  
//任务列表右键菜单
var popMenuTrans = null;
		
//点击右键 显示右键菜单
function showTaskTrans(){

	taskHide();
 	var indexw = g_TableRowSetManager.get("workflowTable").getRow();
    var workflowstate= g_TableRowSetManager.get("workflowTable").getValue(indexw,"STATE");
 	var index = g_TableRowSetManager.get("tasktrans").getRow();
    if(index<0){
      alert(g_I18NMessage("comframe_resources","comframe_html_workflow_WorkflowInst454"));	       return;
    }
    var taskstate= g_TableRowSetManager.get("tasktrans").getValue(index,"STATE");
    // buildPopMenuTaskTrans(workflowstate,taskstate)
            if(popMenuTrans != null){
              popMenuTrans.showPopMenu();
            }
}


        function buildPopMenuTaskTrans(workflowstate,state){

		  var modelTask = new AIPopMenuModel();
		  var param ="flow_state="+workflowstate+"&task_state="+state;
		  var msg = PostInfo(_gModuleName+"/business/com.ai.comframe.config.action.WorkflowAction?action=getWorkflowTaskTransPopMenu&"+param,"");

		  var strJosn = eval(msg.getValueByName("MESSAGE"));
                    for(var i=0; i<strJosn.length; i++){
                   
                      modelTask.addPopMenuItem(strJosn[i].id,strJosn[i].name,null,strJosn[i].func);
                    }
                    popMenuTrans =new AIPopMenu(modelTask)
                    for(var i=0; i<strJosn.length; i++){
                     if(strJosn[i].enable =='false'){
                       popMenuTrans.setItemEnabledById(strJosn[i].id,false);
                     }
		   }
	    }

//设置为已打印
function printTaskTrans(){
	var indexW = g_TableRowSetManager.get("workflowTable").getRow();
	if (indexW<0){
		   alert(g_I18NMessage("comframe_resources","comframe_html_workflow_WorkflowInst326"));			   return;
	}
	var indexT = g_TableRowSetManager.get("tasktrans").getRow();
	if (indexT<0){
		   alert(g_I18NMessage("comframe_resources","comframe_html_workflow_WorkflowInst680"));			   return;
	}
	
	var taskId= g_TableRowSetManager.get("tasktrans").getValue(indexT,"TASK_ID");	
	var state= g_TableRowSetManager.get("tasktrans").getValue(indexT,"STATE");
	var regionID= g_TableRowSetManager.get("tasktrans").getValue(indexT,"REGION_ID");
		
	var workflowId= g_TableRowSetManager.get("workflowTable").getValue(indexW,"WORKFLOW_ID");	
	var templateTag= g_TableRowSetManager.get("workflowTable").getValue(indexW,"TEMPLATE_TAG");	
	var url = "InstVars.jsp?showType=dealTask&workflowId="+workflowId+"&templateTag="+templateTag+"&regionID="+regionID;
	
	var vars = window.showModalDialog(url,null,"resizable:no;status:no;help:no;dialogHeight:400px;dialogWidth:600px");
	if(vars == null){
	  return;
	}
	
	var rtn = saveRowSet("<%=request.getContextPath()%>/business/com.ai.comframe.config.action.WorkflowAction?action=printUserTask&taskId="+taskId+"&vars="+vars+getCenterStr(regionID),false);
	var ret = rtn.getValueByName("FLAG");
  if (ret == "INFO"){
    qryVmWF();
  }
}

//任务回单
function finishTaskTrans(){
var s=Math.random()*10000;
  var indexW = g_TableRowSetManager.get("workflowTable").getRow();
	if (indexW<0){
		   alert(g_I18NMessage("comframe_resources","comframe_html_workflow_WorkflowInst454"));		   return;
	}
	var indexT = g_TableRowSetManager.get("tasktrans").getRow();
	if (indexT<0){
		   alert(g_I18NMessage("comframe_resources","comframe_html_workflow_WorkflowInst493"));		   return;
	}

	var taskId= g_TableRowSetManager.get("tasktrans").getValue(indexT,"TASK_ID");
	var state= g_TableRowSetManager.get("tasktrans").getValue(indexT,"STATE");
	var regionID= g_TableRowSetManager.get("tasktrans").getValue(indexT,"REGION_ID");
	
	var workflowId= g_TableRowSetManager.get("workflowTable").getValue(indexW,"WORKFLOW_ID");
	var templateTag= g_TableRowSetManager.get("workflowTable").getValue(indexW,"TEMPLATE_TAG");
	
	var url = "InstVars.jsp?showType=dealTask&workflowId="+workflowId+"&templateTag="+templateTag+"&rand="+s+"&regionID="+regionID;

	var vars = window.showModalDialog(url,null,"resizable:no;status:no;help:no;dialogHeight:400px;dialogWidth:600px");
	if(vars == null){
	  return;
	}
	
	var dealResult=prompt(g_I18NMessage("comframe_resources","comframe_html_workflow_WorkflowInst509")+":","");	if(dealResult == null){
    return;
  }
  while(dealResult != null && dealResult.length == 0){
    alert(g_I18NMessage("comframe_resources","comframe_html_workflow_WorkflowInst509"));    
    dealResult = prompt(g_I18NMessage("comframe_resources","comframe_html_workflow_WorkflowInst509")+":","");  }

	var rtn = saveRowSet("<%=request.getContextPath()%>/business/com.ai.comframe.config.action.WorkflowAction?action=finishUserTask&taskId="+taskId+"&vars="+vars+"&result="+dealResult+getCenterStr(regionID),false);
	var ret = rtn.getValueByName("FLAG");
  if (ret == "INFO"){
    qryVmWF();
  }
}
//停止任务告警
function stopWarningTaskTrans(){
	var indexW = g_TableRowSetManager.get("workflowTable").getRow();
	if (indexW<0){
		   alert(g_I18NMessage("comframe_resources","comframe_html_workflow_WorkflowInst326"));		   return;
	}
	var indexT = g_TableRowSetManager.get("tasktrans").getRow();
	if (indexT<0){
		   alert(g_I18NMessage("comframe_resources","comframe_html_workflow_WorkflowInst533"));		   return;
	}
	var taskId= g_TableRowSetManager.get("tasktrans").getValue(indexT,"TASK_ID");
	var warningTimes=g_TableRowSetManager.get("tasktrans").getValue(indexT,"WARNING_TIMES");
	var warningDate=g_TableRowSetManager.get("tasktrans").getValue(indexT,"WARNING_DATE");
	var regionID=g_TableRowSetManager.get("tasktrans").getValue(indexT,"REGION_ID");
	if (warningDate==null||warningDate=="null"||warningDate=="undefined"||warningDate==""){
		alert(g_I18NMessage("comframe_resources","comframe_html_workflow_WorkflowInst947"));		return;
	}
	if (warningTimes==null||warningTimes=="null"||warningTimes=="undefined"||warningTimes==""){
		warningTimes=0;
	}
  if(!confirm(g_I18NMessage("comframe_resources","comframe_html_workflow_WorkflowInst546"))){    return;
  }
	var rtn = saveRowSet('<%=request.getContextPath()%>/business/com.ai.comframe.config.action.WorkflowAction?action=stopWarning&TASK_ID='+taskId+'&WARNING_TIMES='+warningTimes+'&TYPE=taskTrans'+getCenterStr(regionID),false);
	var ret = rtn.getValueByName("FLAG");
	
    qryVmWF();
}
function lockTaskTrans(){
	var index = g_TableRowSetManager.get("tasktrans").getRow();
	var taskId= g_TableRowSetManager.get("tasktrans").getValue(index,"TASK_ID");
	var regionID= g_TableRowSetManager.get("tasktrans").getValue(index,"REGION_ID");
	if (index<0){
		   alert(g_I18NMessage("comframe_resources","comframe_html_workflow_WorkflowInst326"));	
		   return;
	}
	saveRowSet('<%=request.getContextPath()%>/business/com.ai.comframe.config.action.WorkflowAction?action=lockTask&TASK_ID='+taskId+getCenterStr(regionID),false);
}

//释放锁定的流程
function releaseTaskTrans(){
	var index = g_TableRowSetManager.get("tasktrans").getRow();
	var taskId= g_TableRowSetManager.get("tasktrans").getValue(index,"TASK_ID");
	var regionID= g_TableRowSetManager.get("tasktrans").getValue(index,"REGION_ID");
	if (index<0){
		   alert(g_I18NMessage("comframe_resources","comframe_html_workflow_WorkflowInst326"));		   return;
	}
	saveRowSet('<%=request.getContextPath()%>/business/com.ai.comframe.config.action.WorkflowAction?action=releaseTaskLock&TASK_ID='+taskId+getCenterStr(regionID),false);
}

function reAuthorizeTaskTrans(){
  	var index = g_TableRowSetManager.get("tasktrans").getRow();
	if (index<0){
		   alert(g_I18NMessage("comframe_resources","comframe_html_workflow_WorkflowInst454"));		   return;
	}
	
	var param = window.showModalDialog("StaffSelect.jsp",null,"resizable:no;status:no;help:no;dialogHeight:200px;dialogWidth:400px");
	if(param == null){
	  return;
	}
	if(!confirm(g_I18NMessage("comframe_resources","comframe_html_workflow_WorkflowInst761"))){	  return;
	}
	
	var taskId= g_TableRowSetManager.get("tasktrans").getValue(index,"TASK_ID");
	var regionID= g_TableRowSetManager.get("tasktrans").getValue(index,"REGION_ID");
	
	var url = "<%=request.getContextPath()%>/business/com.ai.comframe.config.action.WorkflowAction?action=reAuthorizeTask&taskId="
	        + taskId + "&staffId="+param[0]+"&stationId="+param[1]+getCenterStr(regionID);
	var rtn = saveRowSet(url,false);
  var ret = rtn.getValueByName("FLAG");
  if (ret == "INFO"){
    qryVmWF();
  }
}
</script>
