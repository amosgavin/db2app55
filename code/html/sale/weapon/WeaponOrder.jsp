<%@ page contentType="text/html; charset=GBK" %>
<%@ include file="/secframe/common/common.jsp" %>
<%@ include file="/webframe/common/commonhead.jsp" %>
<html><head><title>testDBGrid</title>
</head>
<body bgcolor="#ffffff">
<br>	
<ai:table tableid="taskCurList" setname="com.asiainfo.task.bo.SETCurTask" height="50%" multiselect="false" oncellchange="" editable="false" 
oncontextmenu="" needrefresh="true" onrowchange="onrowchange" pagesize="20" ondbclick="dbclick"
width="100%" tablemodel="com.ai.appframe2.web.datamodel.MethodModelForService"
implservice_name="com.asiainfo.task.service.interfaces.ICurTaskSV"  
implservice_querymethod="getAllCurTaskByCaseType(String staffId,String caseType,int $STARTROWINDEX, int $ENDROWINDEX)" 
implservice_countmethod="getCurCountByType(String staffId, String caseType)">
 <ai:col fieldname="CREATE_CORPORATION" width="100"/>
 <ai:col fieldname="CREATE_STAFF_NAME" width="90"/> 
 <ai:col fieldname="LABEL" width="120"/>
 <ai:col fieldname="TLABEL" width="150"/>
 <ai:col fieldname="STATE_NAME" width="90" />
 <ai:col fieldname="WORKFLOW_OBJECT_TYPE" width="120" />
 <ai:col fieldname="OBJECT_TYPE_NAME" width="100" visible="false"/>
 <ai:col fieldname="WORKFLOW_OBJECT_ID" width="100"/>
 <ai:col fieldname="APPLY_NAME" width="200"/>
 <ai:col fieldname="CREATE_DATE" width="150"/>
 <ai:col fieldname="TASK_ID" width="200" visible="false"/>
 <ai:col fieldname="WORKFLOW_ID" width="200" visible="false"/>
 <ai:col fieldname="STATION_ID" width="100" visible="false"/>
 <ai:col fieldname="TASK_STAFF_ID" width="100" visible="false"/>
 <ai:col fieldname="TEMPLATE_TAG" width="100" visible="false"/>
 <ai:col fieldname="TASK_TAG" width="100" visible="false"/>
 <ai:col fieldname="TASK_TEMPLATE_ID" width="100" visible="false"/>
  <ai:col fieldname="STATE" width="100" visible="false"/>
</ai:table>
<div class="area_button"><ai:button id="newSaleMain" text="处理工单" onclick="orderTask()"/></div>
<ai:table tableid="taskAllList" setname="com.asiainfo.task.bo.SETCurTask" height="30%" multiselect="false" oncellchange="showcell" editable="false" oncontextmenu="" needrefresh="true" onrowchange="onrowchange2" pagesize="200"
width="100%" height="160" tablemodel="com.ai.appframe2.web.datamodel.MethodModelForService"
implservice_name="com.asiainfo.task.service.interfaces.ICurTaskSV"  
implservice_querymethod="getAllTaskByWorkFlowId(String workflowId,int $STARTROWINDEX, int $ENDROWINDEX)" 
implservice_countmethod="getAllCurTaskCount(String workflowId)">
 <ai:col fieldname="TLABEL" width="180"/>
 <ai:col fieldname="LABEL" width="180" visible="false"/>
 <ai:col fieldname="CORPORATION" width="120"/>
 <ai:col fieldname="ORG_NAME" width="120"/>
 <ai:col fieldname="TASK_STAFF_NAME" width="90"/>
 <ai:col fieldname="STAFF_NAME" width="90" visible="true"/> 
 <ai:col fieldname="NEXT_TASK" width="240"/>
 <ai:col fieldname="DESCRIPTION" width="300"/>
 <ai:col fieldname="STATE_NAME" width="120"/>
 <ai:col fieldname="TASK_DATE" width="150"/>
 <ai:col fieldname="FINISH_DATE" width="150"/>
 <ai:col fieldname="APPLY_NAME" width="180"  visible="false"/>
 <ai:col fieldname="WORKFLOW_OBJECT_TYPE" width="100" visible="false"/>
 <ai:col fieldname="OBJECT_TYPE_NAME" width="100" visible="false"/>
 <ai:col fieldname="WORKFLOW_OBJECT_ID" width="100"  visible="false"/>
 <ai:col fieldname="TASK_ID" width="50" visible="false"/>
 <ai:col fieldname="WORKFLOW_ID" width="200" visible="false"/>
 <ai:col fieldname="STATION_ID" width="100" visible="false"/>
 <ai:col fieldname="TASK_STAFF_ID" width="100" visible="false"/>
 <ai:col fieldname="TASK_TAG" width="100" visible="false"/>
 <ai:col fieldname="ERROR_MESSAGE" width="200"/>
 <ai:col fieldname="FINISH_STAFF_ID" width="150" visible="false"/>
 <ai:col fieldname="STATE" width="150" visible="false"/>
  <ai:col fieldname="CREATE_STAFF_ID" width="150" visible="false"/>
</ai:table>


 </body>
</html>
<ai:loginuser/>
<script language="JavaScript" for="window" even="onload">
	var staffId = g_GetUserInfo().STAFF_ID;
	var workflowId = "0^0"
	var gRowSet1 = g_TableRowSetManager.get("taskCurList");
    var gRowSet2 = g_TableRowSetManager.get("taskAllList");	
   // alert(staffId);
    gRowSet1.setFocus(0,0);
    gRowSet1.setFocusByName(0,"name");

  function initTask(){
  
	var param = "staffId=" + staffId +"&caseType=weaponCase";
    gRowSet1.refresh(param);
  }
  initTask();
  
  
  function onrowchange(oldIndex,newIndex){
    if(-1 != oldIndex) {
    	gRowSet1.setRowBgColor(oldIndex,"");
    }
    	gRowSet1.setRowBgColor(newIndex,"yellow");
    	dbclick();
}
  
function onrowchange2(oldIndex,newIndex){
    if(-1 != oldIndex) {
    	gRowSet2.setRowBgColor(oldIndex,"");
    }
    	gRowSet2.setRowBgColor(newIndex,"yellow");
}  
  
  function dbclick(){ //获取条件后刷新记录
     var curRow = gRowSet1.getRow();
     var curCol = gRowSet1.getCol();
     var WORKFLOW_ID = gRowSet1.getValue(curRow,"WORKFLOW_ID");
  	 var param1 = "workflowId="+WORKFLOW_ID;
     gRowSet2.refresh(param1);//刷新
  }
  
  
  
 function showcell(){
	 var curRow = gRowSet2.getRow();
	 var curCol = gRowSet2.getCol();
	 var taskStaffId=gRowSet2.getValue(curRow,"TASK_STAFF_ID");
	 if(taskStaffId==""){
		 taskStaffId=gRowSet2.getValue(curRow,"CREATE_STAFF_ID");
	 }
	 if(curCol==6||curCol==4||curCol==3){
	   var msg = gRowSet2.getValue(curRow,"DESCRIPTION");
       var obj= new Object();
	   //if(msg!=""){
        //window.alert(msg);
        //document.write(msg);
        var url="<%=request.getContextPath()%>/main3/include/showmsg.jsp?&taskStaffId="+taskStaffId;
        obj.name = msg;
        window.showModalDialog(url, obj, "scroll:yes;resizable:yes;help:no;status:yes;dialogHeight:200px;dialogWidth:400px;unadorned:yes");
        //window.open(url, obj, "scroll:yes;resizable:yes;help:no;status:no;dialogHeight:200px;dialogWidth:400px");
	   //}
	 }
}



  
//  function showcell(){
//	 var curRow = gRowSet2.getRow();
//	 var curCol = gRowSet2.getCol();
//	 if(curCol==6){
//	   var msg = gRowSet2.getValue(curRow,"DESCRIPTION");
//       var obj= new Object();
//	   if(msg!=""){
//        //window.alert(msg);
//        //document.write(msg);
//       var url="<%=request.getContextPath()%>/main3/include/showmsg.jsp";
//       obj.name = msg;-->
//        window.showModalDialog(url, obj, "scroll:yes;resizable:yes;help:no;status:yes;dialogHeight:200px;dialogWidth:400px;unadorned:yes");
//        //window.open(url, obj, "scroll:yes;resizable:yes;help:no;status:no;dialogHeight:200px;dialogWidth:400px");
//	   }
//	 }
//}
  
  function orderTask(){
    var curRow = gRowSet1.getRow();
     var curCol = gRowSet1.getCol();
     var templateTag = gRowSet1.getValue(curRow,"TEMPLATE_TAG");
     var taskTag = gRowSet1.getValue(curRow,"TASK_TAG");
  	 var recordId = gRowSet1.getValue(curRow,"WORKFLOW_OBJECT_ID");
  	 var recordType = gRowSet1.getValue(curRow,"OBJECT_TYPE_NAME");
  	 var taskId = gRowSet1.getValue(curRow,"TASK_ID");
     var taskTemplateId = gRowSet1.getValue(curRow,"TASK_TEMPLATE_ID");
     var templateCode = gRowSet1.getValue(curRow,"TEMPLATE_TAG");
     var workflowId = gRowSet1.getValue(curRow,"WORKFLOW_ID");
     var state = gRowSet1.getValue(curRow,"STATE");
     if(taskId == ""){
        alert("请选择需要处理的任务！");
        return;
     }
     if(state=="12"){
        var r=confirm("该工单已经被代理，请确认是否处理!");
        if (r==false){
          return;
        }
     }

     var url = "<%=request.getContextPath()%>/main3/task/assignTask.jsp?&templateTag="+templateTag
                                                                       +"&taskTag="+taskTag
                                                                       +"&recordId="+recordId
                                                                       +"&recordType="+recordType
                                                                       +"&taskId="+taskId
                                                                       +"&taskTemplateId="+taskTemplateId
                                                                       +"&templateCode="+templateCode
                                                                       +"&workflowId="+workflowId;
     if (taskId == '' || taskId == null || taskId == 0){
    	 alert('请先选择要处理的单子！');
    	 return;
     }
     window.location.href = url;
  }
  

  
</script>
