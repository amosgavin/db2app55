<%@ page contentType="text/html; charset=GBK" %>
<%@ include file="/secframe/common/common.jsp" %>
<%@ include file="/webframe/common/commonhead.jsp" %>
<html><head><title>testDBGrid</title>
</head>
<body bgcolor="#ffffff">
<ai:table tableid="taskCurList" setname="com.asiainfo.task.bo.SETCurTask" height="50%" multiselect="false" oncellchange="" editable="false" 
oncontextmenu="" needrefresh="true" onrowchange="" pagesize="200" ondbclick="dbclick"
width="100%" tablemodel="com.ai.appframe2.web.datamodel.MethodModelForService"
implservice_name="com.asiainfo.task.service.interfaces.ICurTaskSV"  
implservice_querymethod="getCurTask(String roleId,String staffId)" 
implservice_countmethod="">
 <ai:col fieldname="CREATE_DATE" width="180"/>
 <ai:col fieldname="LABEL" width="180"/>
 <ai:col fieldname="TLABEL" width="160"/>
 <ai:col fieldname="TASK_TAG" width="160"/>
 <ai:col fieldname="STATE_NAME" width="180"/>
 <ai:col fieldname="WORKFLOW_OBJECT_TYPE" width="100"/>
 <ai:col fieldname="WORKFLOW_OBJECT_ID" width="150"/>
 <ai:col fieldname="TASK_DATE" width="200"/>
 <ai:col fieldname="TASK_ID" width="200"/>
 <ai:col fieldname="WORKFLOW_ID" width="200"/>
 <ai:col fieldname="STATION_ID" width="100"/>
 <ai:col fieldname="TASK_STAFF_ID" width="100"/>
</ai:table>
<ai:loginuser/>
<script language="JavaScript" for="window" even="onload">
	var roleId = "5000";
	var staffId = "1";//g_GetUserInfo().STAFF_ID;
	var workflowId = "0^0"
	var gRowSet1 = g_TableRowSetManager.get("taskCurList");
    var gRowSet2 = g_TableRowSetManager.get("taskAllList");	
    
    gRowSet1.setFocus(0,0);
    gRowSet1.setFocusByName(0,"name");

  function initTask(){
	var param = "roleId=" + roleId + "&staffId=" + staffId;
    gRowSet1.refresh(param);
  }
  initTask();
  
  function dbclick(){ //获取条件后刷新记录
     var curRow = gRowSet1.getRow();
     var curCol = gRowSet1.getCol();
     var WORKFLOW_ID = gRowSet1.getValue(curRow,"WORKFLOW_ID");
     var mainId = gRowSet1.getValue(curRow,"WORKFLOW_OBJECT_ID");
	 var objectTypeId = "saleCase";
	 var taskTag = gRowSet1.getValue(curRow,"TASK_TAG");
  	 window.location.href="<%=request.getContextPath()%>/sale/activity/check.jsp?objectTypeId=" + objectTypeId
  	  					+ "&taskTag=" + taskTag
  	  			 		+ "&mainId=" + mainId;
  }
  
</script>
</body>
</html>