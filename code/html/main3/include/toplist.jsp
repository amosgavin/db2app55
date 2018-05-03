<%@ page contentType="text/html; charset=GBK" %>
<%@ page import="com.ai.appframe2.common.SessionManager" %>  
<%@ page import="com.ai.appframe2.privilege.UserInfoInterface" %>  
<%@ include file="/secframe/common/common.jsp" %>
<%@ include file="/webframe/common/commonhead.jsp" %>
<html><head><title>待办事项</title>
</head>
<% 
  String path = request.getContextPath();
  UserInfoInterface user = SessionManager.getUser();
  String staffId = String.valueOf(user.getID());
%>
<script language="javascript" src="<%=request.getContextPath()%>/jsv2/AIFileUpload.js" type="text/javascript"></script>

<body bgcolor="#ffffff">
<ai:contractframe id="taskCurList" contenttype="table" title="当前需要处理工单" width="100%" allowcontract="true" frameclosed="false">
<ai:contractitem>
<div class="t-bot-mc-button">
    <ai:button id="apprise" text="SOS0100095" i18nRes="CRM" onclick="apprise()"/>
</div>
</ai:contractitem>
	<ai:table tableid="taskCurList" setname="com.asiainfo.task.bo.SETCurTask" height="250" multiselect="false" oncellchange="" editable="false" 
		oncontextmenu="" needrefresh="true" onrowchange="onrowchange" pagesize="30" ondbclick="dealtask"
		width="100%" tablemodel="com.ai.appframe2.web.datamodel.MethodModelForService"
		implservice_name="com.asiainfo.task.service.interfaces.ICurTaskSV"  
		implservice_querymethod="getCurTask(String staffId,int $STARTROWINDEX, int $ENDROWINDEX)" 
		implservice_countmethod="getCurCount(String staffId)"
		initial="false" editable="false" width="100%"
		needrefresh="true">
		 <ai:col fieldname="CREATE_CORPORATION" width="100"/>
		 <ai:col fieldname="CREATE_STAFF_NAME" width="70"/> 
		 <ai:col fieldname="WORKFLOW_OBJECT_ID" width="70"/>
		 <ai:col fieldname="WORKFLOW_OBJECT_TYPE" width="120" />
		 <ai:col fieldname="APPLY_NAME" width="300"/>
		 <ai:col fieldname="TLABEL" width="150" />
		 <ai:col fieldname="PZ_STAFF" width="70" />
		 <ai:col fieldname="TEST_STAFF" width="70" />
		 <ai:col fieldname="CREATE_DATE" width="130"/>
		 <ai:col fieldname="TASK_DATE" width="130"/>
		 <ai:col fieldname="LABEL" width="120" visible="false"/>
		 <ai:col fieldname="OBJECT_TYPE_NAME" width="100" visible="false"/>
		 <ai:col fieldname="STATE_NAME" width="90" visible="false"/>
		 <ai:col fieldname="TASK_ID" width="200" visible="false"/>
		 <ai:col fieldname="WORKFLOW_ID" width="200" visible="false"/>
		 <ai:col fieldname="STATION_ID" width="100" visible="false"/>
		 <ai:col fieldname="TASK_STAFF_ID" width="100" visible="false"/>
		 <ai:col fieldname="TEMPLATE_TAG" width="100" visible="false"/>
		 <ai:col fieldname="TASK_TAG" width="100" visible="false"/>
		 <ai:col fieldname="TASK_TEMPLATE_ID" width="100" visible="false"/>
		 <ai:col fieldname="STATE" width="100" visible="false"/>
	</ai:table>
</ai:contractframe>
<div align="center">
	<ai:button text="任务处理" onclick="dealtask()"/>
	<ai:button text="查看流程信息" onclick="doDbclick()"/>
</div>

<ai:contractframe id="taskAllListframe" contenttype="table" title="工单流转明细" width="100%" allowcontract="true" frameclosed="fale">
<ai:contractitem/>
	<ai:table tableid="taskAllList" setname="com.asiainfo.task.bo.SETCurTask" height="250" multiselect="false" oncellchange="showcell" editable="false" oncontextmenu="" needrefresh="true" onrowchange="onrowchange2" pagesize="20"
		width="100%" tablemodel="com.ai.appframe2.web.datamodel.MethodModelForService"
		implservice_name="com.asiainfo.task.service.interfaces.ICurTaskSV"  
		implservice_querymethod="getAllTaskByWorkFlowId(String workflowId,int $STARTROWINDEX, int $ENDROWINDEX)" 
		implservice_countmethod="getAllCurTaskCount(String workflowId)"
		initial="false" editable="false" width="100%"
		needrefresh="true">
		 <ai:col fieldname="TLABEL" width="150"/>
		 <ai:col fieldname="LABEL" width="180" visible="false"/>
		 <ai:col fieldname="CORPORATION" width="120"/>
		 <ai:col fieldname="ORG_NAME" width="120"/>
		 <ai:col fieldname="TASK_STAFF_NAME" width="70"/>
		 <ai:col fieldname="STAFF_NAME" width="60" visible="true"/> 
		 <ai:col fieldname="DECISION_RESULT" width="70"/>
		 <ai:col fieldname="NEXT_TASK" width="160"/>
		 <ai:col fieldname="DESCRIPTION" width="300"/>
		 <ai:col fieldname="STATE_NAME" width="100"/>
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
</ai:contractframe>
</body>
</html>

<script language="javascript" src="<%=request.getContextPath()%>/jsv2/AIWaitBanner.js"></script>
<script type="text/javascript">
function doWork(fun){ 
    beginAIWaitBanner(fun,"正在处理，请稍后...");
}
</script>

<script language="JavaScript" for="window" even="onload">
	var staffStr ="<%=SessionManager.getUser().getID()%>";
	var gRowSet1 = g_TableRowSetManager.get("taskCurList");
    var gRowSet2 = g_TableRowSetManager.get("taskAllList");	
    
   gRowSet1.setFocus(0,0);
   gRowSet1.setFocusByName(0,"name");

  function initTask(){
	var param = "staffId=" + staffStr;
    gRowSet1.refresh(param);
  }
  initTask();

  function doDbclick(){
    doWork('dbclick()');
  }
  function dbclick(){ //获取条件后刷新记录
     var curRow = gRowSet1.getRow();
     var curCol = gRowSet1.getCol();
     var WORKFLOW_ID = gRowSet1.getValue(curRow,"WORKFLOW_ID");
  	 var param1 = "workflowId="+WORKFLOW_ID;
     gRowSet2.refresh(param1);//刷新
  }

  function deal(){
    doWork('dealtask()');
  }
  
  function dealtask(){//处理工单
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
     //alert(url);
     if (taskId == '' || taskId == null || taskId == 0){
    	 alert('请先选择要处理的单子！');
    	 return;
     }
     window.open(url,null,'height=490,width=860,top=0,left=0,toolbar=no,menubar=no,scrollbars=yes,resizable=yes,location=no,status=no',false);
  }

function onrowchange(oldIndex,newIndex){
    if(-1 != oldIndex) {
    	gRowSet1.setRowBgColor(oldIndex,"");
    }
    	gRowSet1.setRowBgColor(newIndex,"yellow");
    	gRowSet2.clear();
    	//doDbclick();
}

function onrowchange2(oldIndex,newIndex){
    if(-1 != oldIndex) {
    	gRowSet2.setRowBgColor(oldIndex,"");
    }
    	gRowSet2.setRowBgColor(newIndex,"yellow");
}

function onrowselected(rowIndex,isSelected){
  if(isSelected==true){
     doDbclick();
  }
}


  function testPost(){
		var ud = postParam("<%=request.getContextPath()%>/business/com.asiainfo.task.web.CustomerCodeAction?action=test","para1=#123#&para2=#456#&para3=#789#");
		var para1 = ud.getValueByName("para1");
		var para2 = ud.getValueByName("para2");
		var para3 = ud.getValueByName("para3");
		alert("The para1 is '"+para1+"'");
		alert("The para2 is '"+para2+"'");
		alert("The para3 is '"+para3+"'");
  }
  
function toExcel(){
   var curRow = gRowSet1.getRow();
   var curCol = gRowSet1.getCol();
   var type = gRowSet1.getValue(curRow,"OBJECT_TYPE_NAME");
   var mid = gRowSet1.getValue(curRow,"WORKFLOW_OBJECT_ID");
    
   if(mid==""){
      alert("请选择要导出的任务！");
      return;
   }
   if(type=="chargeCaseT"){
      alert("资费案暂时无excel导出模板，无法导出！");
      return;
   }
   if(type=="chargeCase"){
      alert("资费案暂时无excel导出模板，无法导出！");
      return;
   }
   var templateTag = gRowSet1.getValue(curRow,"TASK_ID");
   //var url = "<%=request.getContextPath()%>/business/com.asiainfo.task.web.CurTaskAction?action=toExcel&mid="+mid+"&type="+type;
   //var result = PostInfo(url,"");
   var url = "<%=request.getContextPath()%>/main3/task/downloadExcel.jsp?&mid="+mid+"&type="+type;
   window.location.href = url;
}

function showcell(){
	 var curRow = gRowSet2.getRow();
	 var curCol = gRowSet2.getCol();
	 var taskStaffId=gRowSet2.getValue(curRow,"TASK_STAFF_ID");
	 if(taskStaffId==""){
		 taskStaffId=gRowSet2.getValue(curRow,"CREATE_STAFF_ID");
	 }
	 if(curCol==7){
	   var msg = gRowSet2.getValue(curRow,"DESCRIPTION");
       var obj= new Object();
	   //if(msg!=""){
        //window.alert(msg);
        //document.write(msg);
        var url="showmsg.jsp?&taskStaffId="+taskStaffId;
        obj.name = msg;
        window.showModalDialog(url, obj, "scroll:yes;resizable:yes;help:no;status:yes;dialogHeight:200px;dialogWidth:400px;unadorned:yes");
        //window.open(url, obj, "scroll:yes;resizable:yes;help:no;status:no;dialogHeight:200px;dialogWidth:400px");
	   //}
	 }
}

function apprise(){
	var curRowIndex = gRowSet1.getCurRowIndex();
	workflowId = gRowSet1.getValue(curRowIndex, "WORKFLOW_ID");
	if (workflowId == "") return alert("请选择需要知会的工单！");
	var url = "<%=request.getContextPath()%>/sale/promationTag/appriseDialog.jsp?org_id=10&workflowId=" + workflowId + "&orgInit=false";
    var result = window.showModalDialog(url, null, "scroll:no;resizable:no;help:no;status:s;dialogHeight:400px;dialogWidth:600px");
}

function toDojo(){
     var curRow = gRowSet1.getRow();
     var curCol = gRowSet1.getCol();
     var templateTag = gRowSet1.getValue(curRow,"TEMPLATE_TAG");
     var taskTag = gRowSet1.getValue(curRow,"TASK_TAG");
     var objectType = gRowSet1.getValue(curRow,"OBJECT_TYPE_NAME");
     
     if(objectType==""){
       alert("请选择展现的任务！");
       return;
     }
     
     var url = "";
     if(objectType=="saleCaseT"){
    	 url ="<%=request.getContextPath()%>/main3/workflowshow/TownSaleCaseApprove.jsp?taskTag=" +taskTag;
     }
     if(objectType=="saleCase"){
    	 url ="<%=request.getContextPath()%>/main3/workflowshow/ProvinceSaleCaseApprove.jsp?taskTag=" +taskTag;
     }
     if(objectType=="chargeCaseT"){
    	 url ="<%=request.getContextPath()%>/main3/workflowshow/TownChargeApplyFlow.jsp?taskTag=" +taskTag;
     }
     if(objectType=="chargeCase"){
    	 url ="<%=request.getContextPath()%>/main3/workflowshow/ProvinceChargeApplyFlow.jsp?taskTag=" +taskTag;
     }
     if(objectType=="weaponCase"){
    	 url ="<%=request.getContextPath()%>/main3/workflowshow/WeaponNewApprove.jsp?taskTag=" +taskTag;
     }
     if(objectType=="saleCaseI"){
    	 url ="<%=request.getContextPath()%>/main3/workflowshow/InternetSaleCaseApprove.jsp?taskTag=" +taskTag;
     }
     if(objectType=="accessCaseT"){
    	 url ="<%=request.getContextPath()%>/main3/workflowshow/AccessChangeFlow.jsp?taskTag=" +taskTag;
     }
     
    // if(objectType=="prestoreCase"){
    //	 url ="<%=request.getContextPath()%>/main3/workflowshow/TownBatchPreApprove.jsp?taskTag=" +taskTag;
     //}
     if(url == ""){
    	 return;
     }
     window.open(url,"","scroll=yes,resizable=no,status=no,help=no,height=680px,width=1024px");
}
</script>
