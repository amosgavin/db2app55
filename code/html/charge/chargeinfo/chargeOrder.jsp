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
<ai:table tableid="taskCurList" setname="com.asiainfo.task.bo.SETCurTask" height="50%" multiselect="false" oncellchange="" editable="false" 
oncontextmenu="" needrefresh="true" onrowchange="" pagesize="20" ondbclick="dbclick"
width="100%" tablemodel="com.ai.appframe2.web.datamodel.MethodModelForService"
implservice_name="com.asiainfo.task.service.interfaces.ICurTaskSV"  
implservice_querymethod="getAllCurTaskByCaseType(String staffId,String caseType,int $STARTROWINDEX, int $ENDROWINDEX)" 
implservice_countmethod="getCurCountByType(String staffId, String caseType)">
<ai:col fieldname="LABEL" width="180"/>
 <ai:col fieldname="TLABEL" width="160"/>
 <ai:col fieldname="STATE_NAME" width="180" visible="false"/>
 <ai:col fieldname="WORKFLOW_OBJECT_TYPE" width="100"/>
 <ai:col fieldname="OBJECT_TYPE_NAME" width="100"/>
 <ai:col fieldname="WORKFLOW_OBJECT_ID" width="150"/>
 <ai:col fieldname="TASK_DATE" width="200"/>
  <ai:col title="申请名称" fieldname="APPLY_NAME" width="200"/>
 <ai:col fieldname="TASK_ID" width="200" visible="false"/>
 <ai:col fieldname="WORKFLOW_ID" width="200" visible="false"/>
 <ai:col fieldname="STATION_ID" width="100" visible="false"/>
 <ai:col fieldname="TASK_STAFF_ID" width="100" visible="false"/>
 <ai:col fieldname="TEMPLATE_TAG" width="100" visible="false"/>
 <ai:col fieldname="TASK_TAG" width="100" visible="false"/>
  <ai:col fieldname="TASK_TEMPLATE_ID" width="100" visible="false"/>
   <ai:col fieldname="STATE" width="100" visible="false"/>
</ai:table>

<ai:button text="任务处理" onclick="dealtask()"/>
<ai:button text="导出EXCEL" onclick="toExcel()"/>

<ai:table tableid="taskAllList" setname="com.asiainfo.task.bo.SETCurTask" height="200" multiselect="false" oncellchange="" editable="false" oncontextmenu="" needrefresh="true" onrowchange="" pagesize="20"
width="100%" tablemodel="com.ai.appframe2.web.datamodel.MethodModelForService"
implservice_name="com.asiainfo.task.service.interfaces.ICurTaskSV"  
implservice_querymethod="getAllTaskByWorkFlowId(String workflowId,int $STARTROWINDEX, int $ENDROWINDEX)" 
implservice_countmethod="getAllCurTaskCount(String workflowId)"
initial="false" editable="false" width="100%"
height="160" needrefresh="true">
 <ai:col fieldname="CORPORATION" width="120"/>
 <ai:col fieldname="ORG_NAME" width="120"/>
 <ai:col fieldname="TASK_STAFF_NAME" width="90"/>
 <ai:col fieldname="STAFF_NAME" width="90" visible="true"/> 
 <ai:col fieldname="LABEL" width="180"/>
 <ai:col fieldname="TLABEL" width="180"/>
 <ai:col fieldname="FINISH_DATE" width="150"/>
 <ai:col fieldname="APPLY_NAME" width="180"/>
 <ai:col fieldname="STATE_NAME" width="120" visible="false"/>
 <ai:col fieldname="WORKFLOW_OBJECT_TYPE" width="100" visible="false"/>
 <ai:col fieldname="OBJECT_TYPE_NAME" width="100" visible="false"/>
 <ai:col fieldname="WORKFLOW_OBJECT_ID" width="100"/>
 <ai:col fieldname="TASK_ID" width="50" visible="false"/>
 <ai:col fieldname="WORKFLOW_ID" width="200" visible="false"/>
 <ai:col fieldname="STATION_ID" width="100" visible="false"/>
 <ai:col fieldname="TASK_STAFF_ID" width="100" visible="false"/>
 <ai:col fieldname="TASK_TAG" width="100" visible="false"/>
 <ai:col fieldname="DESCRIPTION" width="300"/>
 <ai:col fieldname="ERROR_MESSAGE" width="300"/>
</ai:table>

 </body>
</html>

<script language="JavaScript" for="window" even="onload">
	var staffStr ="<%=SessionManager.getUser().getID()%>";
	var gRowSet1 = g_TableRowSetManager.get("taskCurList");
    var gRowSet2 = g_TableRowSetManager.get("taskAllList");	
    
    gRowSet1.setFocus(0,0);
    gRowSet1.setFocusByName(0,"name");

  function initTask(){
	var param = "staffId=" + staffStr +"&caseType=chargeCase";
    gRowSet1.refresh(param);
    gRowSet1.setFocus(0,0);
    gRowSet1.setFocusByName(0,"name");    
  }
  initTask();
  
  function dbclick(){ //获取条件后刷新记录
     var curRow = gRowSet1.getRow();
     var curCol = gRowSet1.getCol();
     var WORKFLOW_ID = gRowSet1.getValue(curRow,"WORKFLOW_ID");
  	 var param1 = "workflowId="+WORKFLOW_ID;
     gRowSet2.refresh(param1);//刷新
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
     if(taskTag=="PC001"||taskTag=="C002"){
     var url = "<%=request.getContextPath()%>/charge/chargeinfo/chargeAuditEditInfo.jsp?&templateTag="+templateTag
                                                                       +"&taskTag="+taskTag
                                                                       +"&recordId="+recordId
                                                                       +"&recordType="+recordType
                                                                       +"&taskId="+taskId
                                                                       +"&taskTemplateId="+taskTemplateId
                                                                       +"&templateCode="+templateCode
                                                                       +"&workflowId="+workflowId;
     }
     else{
     var url = "<%=request.getContextPath()%>/charge/chargeinfo/chargeAuditInfo.jsp?&templateTag="+templateTag
                                                                       +"&taskTag="+taskTag
                                                                       +"&recordId="+recordId
                                                                       +"&recordType="+recordType
                                                                       +"&taskId="+taskId
                                                                       +"&taskTemplateId="+taskTemplateId
                                                                       +"&templateCode="+templateCode
                                                                       +"&workflowId="+workflowId;
     }
     //alert(url);
     if (taskId == '' || taskId == null || taskId == 0){
    	 alert('请先选择要处理的单子！');
    	 return;
     }
     //window.location.href = url;
     window.open (url, '', 'height=100, width=400, top=yes,left=0, toolbar=no, menubar=yes, scrollbars=yes, resizable=yes,location=yes, status=yes');
     //window.open(url, null, "scroll:no;resizable:yes;help:no;status:no;dialogHeight:490px;dialogWidth:860px");
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
   var templateTag = gRowSet1.getValue(curRow,"TASK_ID");
   //var url = "<%=request.getContextPath()%>/business/com.asiainfo.task.web.CurTaskAction?action=toExcel&mid="+mid+"&type="+type;
   //var result = PostInfo(url,"");
   var url = "<%=request.getContextPath()%>/main3/task/downloadExcel.jsp?&mid="+mid+"&type="+type;
   window.location.href = url;
}
</script>
