<%@ page language="java" pageEncoding="GBK"%> 
<%@ include file="/workflow/common/WorkflowHead.jsp"%>
<%
	String workflow_id =request.getParameter("workflow_id");
  	String template_id = request.getParameter("template_id");
  	String task_tag = request.getParameter("task_tag");
  	String regionID = request.getParameter("regionID");
  	String sdate	= request.getParameter("sdate");
  	if(regionID==null||regionID.length()==0){
  		regionID="";
  	}
  %>
<html>
  <head>
    <title><i18n:message res="i18n.comframe_resource"  key="comframe.html.workflow.GoBackTask18"></i18n:message></title>    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
  </head>
  <script type='text/javascript' src='<%=request.getContextPath() %>/workflow/common/dojo-release-1.7.1/dojo/dojo.js' djConfig='isDebug: true'></script>
  <body onload="init()" scroll="yes">
    <div id="instDiv" align="center" style="display: none;">
    <ai:contractframe  width="100%"  title="comframe.html.workflow.SvgView35" id="comframe.html.workflow.SvgView35" i18nRes="i18n.comframe_resource">
     <ai:contractitem></ai:contractitem>
           <ai:table tableid="workflowTable" setname="com.ai.comframe.config.set.SETVmWF"
                    tablemodel="com.ai.appframe2.web.datamodel.MethodModelForService"
                    implservice_name="com.ai.comframe.config.service.interfaces.IWorkflowConsoleSV"
                    implservice_querymethod="queryHisChildWorkflow(String taskId,int $STARTROWINDEX,int $ENDROWINDEX,String sdate)"
                    implservice_countmethod="queryHisChildWorkflowCount(String taskId,String sdate)"
					onlyquery="true" width="100%" height="80" pagesize="5" onrowchange="showChildDOJO" ondbclick="showChildDOJO"
					needrefresh="true" multiselect="false" initial="false" editable="false" >
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
        </ai:table>
   </ai:contractframe>
    </div>    
    
   <div id='container' style="height:650;width:1100"></div>
   <div id="btnDiv1" align="right" style="display:none" >
   <ai:button i18nRes="i18n.comframe_resource" text="comframe.html.workflow.GoBackTask34" onclick="goBack()"/></div> 
   
  </body>
</html>
<script defer>
function getTbl(){
  return g_TableRowSetManager.get("workflowTable");
}

function init(){
	var workflow_id="<%=workflow_id %>";
	var template_id = "<%=template_id%>";
	var task_tag = "<%=task_tag%>";
  var url = "<%=request.getContextPath()%>/business/com.ai.comframe.config.action.WorkflowAction?";
  if(isBlank(workflow_id) == false){
    url += "action=hisworkflowInst2Dojo&workflow_id=" + workflow_id+getCenterStr('<%=regionID%>')+"&sdate=<%=sdate%>";
  }
  else if(isBlank(template_id) == false || isBlank(task_tag) == false){
    url += "action=template2Dojo&template_id=" + template_id + "&task_tag="+task_tag;
  }
  else{
	  // 传入参数：流程实例标识、模板标识、模板编码不能同时为空,无法展现流程图！
	  container.innerText = g_I18NMessage("comframe_resources","comframe_html_workflow_dojo_paramerror");
	  return;
  }
  showDojo(url);
}


var popMenu=null;
//单击节点事件
function  onDojoClick(taskTemplateId,taskLabel,taskId,childCode,taskType,state,taskTag,exceptionPiid){
	if( popMenu!==null){
		 popMenu.hidePopMenu(); 
	}
	
}
//双击节点事件
function ondbDojoClick(taskTemplateId,taskLabel,taskId,childCode,taskType,state,taskTag,exceptionPiid){//exceptionPiid如果是异常流程则为异常的流程ID号，否则为空 	
  	if( popMenu!==null){
		 popMenu.hidePopMenu(); 
	}
	if(isBlank(childCode) == false){
		if(!isBlank(taskId)){
			 var model = new AIPopMenuModel();//
			 var meunName=g_I18NMessage("comframe_resources","comframe_html_workflow_dojo_meun1");
			  model.addPopMenuItem(1,meunName,null,"showTaskInfo('"+taskTemplateId+"','"+taskLabel+"','"+taskId+"','"+childCode+"','"+taskType+"','"+state+"','"+taskTag+"','"+exceptionPiid+"')");
			  meunName=g_I18NMessage("comframe_resources","comframe_html_workflow_dojo_meun2");         
		      if(!isBlank(exceptionPiid)){		     
		    	  meunName=g_I18NMessage("comframe_resources","comframe_html_workflow_dojo_meun3");
	          }
			  model.addPopMenuItem(2,meunName,null,"showChildWorkflow('"+taskTemplateId+"','"+taskLabel+"','"+taskId+"','"+childCode+"','"+taskType+"','"+state+"','"+taskTag+"','"+exceptionPiid+"')");
			  
			 popMenu = new AIPopMenu(model);
			 popMenu.showPopMenu(); 
		}else{
			showChildWorkflow(taskTemplateId,taskLabel,taskId,childCode,taskType,state,taskTag,exceptionPiid);			
		}		
	    
	}else{
		if(!isBlank(taskId)){
			showTaskInfo(taskTemplateId,taskLabel,taskId,childCode,taskType,state,taskTag,exceptionPiid);
		}
		
	}
}
/**/
function showTaskInfo(taskTemplateId,taskLabel,taskId,childCode,taskType,state,taskTag,exceptionPiid){
	//alert("任务编号："+taskId);
}

function showChildWorkflow(taskTemplateId,taskLabel,taskId,childCode,taskType,state,taskTag,exceptionPiid){ 	
 	var workflow_id="<%=workflow_id%>";
	var template_id = "<%=template_id%>";
	if(isBlank(childCode) == false){
		
	  //流程实例
	  if(isBlank(workflow_id) == false && isBlank(taskId) == false){
		  var isProcessUrl = "<%=request.getContextPath()%>/business/com.ai.comframe.config.action.WorkflowAction?"
	            + "action=isProcess&workflowCode="+childCode+getCenterStr('<%=regionID%>');
	        var result = PostInfo(isProcessUrl);
	        if("Y"==result.getValueByName("FLAG")){
		        //不能查询Process的实例化流程图！
	            alert(g_I18NMessage("comframe_resources","comframe_html_workflow_svgview_cannotviewinschat"));
	            return;
	        }
	      //查询出全部子流程
		  getTbl().refresh("taskId="+taskId+"&sdate=<%=sdate%>");
		  if(getTbl().count() > 1){
			  document.all.instDiv.style.display = "block";
		  	 document.getElementById("container").innerHTML = "";	
		    return;
		  }
		  else{
		      //如果只有一个子流程实例则直接显示
			  var workflowId = getTbl().getValue(0,"WORKFLOW_ID");			
			  if(!isBlank(exceptionPiid)){
				  workflowId=exceptionPiid;
			  }
		       var url = "<%=request.getContextPath()%>/business/com.ai.comframe.config.action.WorkflowAction?"
  		      + "action=hisworkflowInst2Dojo&workflow_id="+workflowId+getCenterStr('<%=regionID%>')+"&sdate=<%=sdate%>";
			  showDojo(url);
			  return;
		  }
	   }
	//流程模板，尚未执行到该子流程节点，该子流程节点未创建出子流程
	
	 var workflowId = getTbl().getValue(0,"WORKFLOW_ID");
	document.all.btnDiv1.style.display = "block";
	 var url = "<%=request.getContextPath()%>/business/com.ai.comframe.config.action.WorkflowAction?"
     + "action=template2Dojo&template_id=-1&task_tag="+childCode+getCenterStr('<%=regionID%>')+"&sdate=<%=sdate%>";
	 showDojo(url);
	}
}

function showParentDOJO(parentWorkflowId){
  	var rowIndex = getTbl().getRow();
  	var url = "<%=request.getContextPath()%>/business/com.ai.comframe.config.action.WorkflowAction?"
  		      + "action=hisworkflowInst2Dojo&workflow_id="+parentWorkflowId+getCenterStr('<%=regionID%>')+"&sdate=<%=sdate%>";
  	showDojo(url);
}

function showChildDOJO(){
  var rowIndex = getTbl().getRow();
  var workflowId = getTbl().getValue(rowIndex,"WORKFLOW_ID");
  var url = "<%=request.getContextPath()%>/business/com.ai.comframe.config.action.WorkflowAction?"
  		      + "action=hisworkflowInst2Dojo&workflow_id="+workflowId+getCenterStr('<%=regionID%>')+"&sdate=<%=sdate%>";
  showDojo(url);
}
var currdiv="currdiv";
var oldleft="20px";




function showDojo(url) {
    var r = PostInfo(url, null);
    var s = r.getValueByName("msg");
    var error = r.getValueByName("error");
    if(!isBlank(error)){
    	 document.getElementById("container").innerText = error;	
    }else{
    	 document.getElementById("container").innerHTML = "";	
    	 eval(s); 
    }
   
}
function goBack(){
  location.reload();
}
</script>




