<%@ page contentType="text/html; charset=GBK" %>
<%@ include file="/secframe/common/common.jsp" %>
<%@ include file="/webframe/common/commonhead.jsp" %>
<html><head><title>testDBGrid</title>
</head>
<body bgcolor="#ffffff">
<ai:contractframe id="saleMainframe" contenttype="table" title="当前代办工单" width="100%" allowcontract="true" frameclosed="fale">
    <ai:contractitem/>
<ai:table tableid="taskCurList" setname="com.asiainfo.task.bo.SETCurTask" height="200" multiselect="false" oncellchange="" editable="false" 
oncontextmenu="" needrefresh="true"  pagesize="10" ondbclick="doCheck"
width="100%" onrowchange='changeColor1' tablemodel="com.ai.appframe2.web.datamodel.MethodModelForService"
implservice_name="com.asiainfo.task.service.interfaces.ICurTaskSV"  
implservice_querymethod="getAllCurTaskByCaseType(String staffId,String caseType,int $STARTROWINDEX, int $ENDROWINDEX)" 
implservice_countmethod="getCurCountByType(String staffId, String caseType)">
 <ai:col fieldname="WORKFLOW_OBJECT_ID" width="100"/>
 <ai:col fieldname="APPLY_NAME" width="200"/>
 <ai:col fieldname="LABEL" width="180"/>
 <ai:col fieldname="TLABEL" width="160"/>
 <ai:col fieldname="STATE_NAME" width="180" visible="false"/>
 <ai:col fieldname="WORKFLOW_OBJECT_TYPE" width="100"/>
 <ai:col fieldname="OBJECT_TYPE_NAME" width="100" visible="false"/>
 <ai:col fieldname="CREATE_DATE" width="180"/>
 <ai:col fieldname="TASK_DATE" width="200"/>
 <ai:col fieldname="TASK_TEMPLATE_ID" width="200" visible="false"/>
 <ai:col fieldname="TASK_ID" width="200" visible="false"/>
 <ai:col fieldname="WORKFLOW_ID" width="200" visible="false"/>
 <ai:col fieldname="STATION_ID" width="100" visible="false"/>
 <ai:col fieldname="TASK_STAFF_ID" width="100" visible="false"/>
 <ai:col fieldname="TEMPLATE_TAG" width="100" visible="false"/>
 <ai:col fieldname="TASK_TAG" width="100" visible="false"/>
</ai:table>
<table align="center"><tr><td><ai:button text="查看流转明细" onclick="showWFDetail()"/>&nbsp;&nbsp;<ai:button text="任务处理" onclick="doCheck()"/></td></tr></table>
</ai:contractframe>
<ai:contractframe id="saleMainframe" contenttype="table" title="工单流转详细" width="100%" allowcontract="true" frameclosed="fale">
    <ai:contractitem/>
<ai:table tableid="taskAllList" setname="com.asiainfo.task.bo.SETCurTask" height="200" multiselect="false" oncellchange="" editable="false" oncontextmenu="" needrefresh="true" onrowchange="" pagesize="200"
width="100%" onrowchange='changeColor2' tablemodel="com.ai.appframe2.web.datamodel.MethodModelForService"
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
<table align="center"><tr><td><ai:button text="任务处理" onclick="doCheck()"/></td></tr></table>
</ai:contractframe>
 </body>
</html>
<ai:loginuser/>
<script language="JavaScript" for="window" even="onload">
	//var roleId = "5000";
	var staffId = "<%=SessionManager.getUser().getID()%>";
	var workflowId = "0^0"
	var gRowSet1 = g_TableRowSetManager.get("taskCurList");
    var gRowSet2 = g_TableRowSetManager.get("taskAllList");	
    

  function initTask(){
	var param = "&staffId=" + staffId + "&caseType=saleCase";
    gRowSet1.refresh(param);
    
    gRowSet1.setFocus(0,0);
    gRowSet1.setFocusByName(0,"name");
  }
  initTask();
  
  function doCheck(){ //获取条件后刷新记录
     var curRow = gRowSet1.getRow();
     var curCol = gRowSet1.getCol();
     var taskId = gRowSet1.getValue(curRow,"TASK_ID");
     if(""==taskId){
         alert("请选择要处理的工单");
         return;
     }
     var taskTemplateId = gRowSet1.getValue(curRow,"TASK_TEMPLATE_ID");
     var mainId = gRowSet1.getValue(curRow,"WORKFLOW_OBJECT_ID");
     var templateCode = gRowSet1.getValue(curRow,"TEMPLATE_TAG");
	 var taskTag = gRowSet1.getValue(curRow,"TASK_TAG");
     var WORKFLOW_ID = gRowSet1.getValue(curRow,"WORKFLOW_ID");
  	 window.open("<%=request.getContextPath()%>/sale/activity/check.jsp?templateCode=" + templateCode
  	  					+ "&taskTag=" + taskTag
                        + "&mainId=" + mainId
                        + "&taskId=" + taskId
                        + "&taskTemplateId=" + taskTemplateId
                        + "&workflowId="+WORKFLOW_ID, 
  	  			 		null, 'height=490,width=860,top=0,left=0,toolbar=no,menubar=no,scrollbars=no,resizable=yes,location=no,status=no');
  	 //window.location.reload();
  }
  
  function showWFDetail(){ //获取条件后刷新记录
     var curRow = gRowSet1.getRow();
     var curCol = gRowSet1.getCol();
     var WORKFLOW_ID = gRowSet1.getValue(curRow,"WORKFLOW_ID");
     var param1 = "workflowId="+WORKFLOW_ID;
     gRowSet2.refresh(param1);//刷新
  }
  
  function changeColor1(oldIndex,newIndex){
	showcell();
	showWFDetail();
    if(-1 != oldIndex) {
    	gRowSet1.setRowBgColor(oldIndex,"");
    }
   		gRowSet1.setRowBgColor(newIndex,"yellow");
}

function changeColor2(oldIndex,newIndex){
	showcell();
    if(-1 != oldIndex) {
    	gRowSet2.setRowBgColor(oldIndex,"");
    }
    	gRowSet2.setRowBgColor(newIndex,"yellow");
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
</script>
