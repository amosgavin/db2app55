<%@ page contentType="text/html; charset=GBK" %>
<%@ page import="com.ai.appframe2.common.SessionManager" %>  
<%@ page import="com.ai.appframe2.privilege.UserInfoInterface" %>  
<%@ include file="/secframe/common/common.jsp" %>
<%@ include file="/webframe/common/commonhead.jsp" %>

<script src="<%=request.getContextPath()%>/jsv2/UserData_v2.js"></script>
<script language="JavaScript" src="<%=request.getContextPath()%>/jsv2/Globe_v2.jsp"></script>
<script language="JavaScript" src="<%=request.getContextPath()%>/jsv2/CommUtil.js"></script>

<html><head>
<title>已办未结事项</title>
<script language="javascript" src="<%=request.getContextPath()%>/jsv2/Calendar.jsp" type="text/javascript"></script>
</head>
<% 
  String path = request.getContextPath();
  UserInfoInterface user = SessionManager.getUser();
  
  String staffId = String.valueOf(SessionManager.getUser().getID());
%>

<body bgcolor="#ffffff">
<ai:contractframe id="finishTask" contenttype="table" title="在办任务查询" width="100%" allowcontract="true" frameclosed="fale">
	<ai:contractitem/>
	<ai:dbform formid="taskF" 
			setname="com.asiainfo.task.bo.SETWebTaskQuery"
			conditionname="condition" parametersname="parameters"
			onvalchange="" editable="true" initial="false"
			datamodel="com.ai.appframe2.web.datamodel.MethodModelForService"
			implservice_name="com.asiainfo.task.service.interfaces.ICurTaskSV"
			implservice_querymethod="getFihishTask(String roleId,String staffId,String beginTime,String endTime)">
		<table width="98%" align="center" border="0" cellpadding="1" cellspacing="2">
			<tr>
	           	<td class="td_font">开始时间：</td>
	           	<td><ai:dbformfield formid="taskF" fieldname="CREATE_DATE" width="150"/></td>
	           	<td class="td_font">结束时间：</td>
	           	<td><ai:dbformfield formid="taskF" fieldname="FINISH_DATE" width="150"/></td>
	           	<td class="td_font">申请地市：</td>
	           	<td><ai:dbformfield formid="taskF" fieldname="CORPORATION" width="150"/></td>
	        </tr>
	        <tr>   	
	           	<td class="td_font">申请人：</td>
	           	<td><ai:dbformfield formid="taskF" fieldname="CREATE_STAFF_NAME" width="150"/></td>
	           	<td class="td_font">工单名称：</td>
	           	<td><ai:dbformfield formid="taskF" fieldname="APPLY_NAME" width="150"/></td>
	           	<td class="td_font">工单编号：</td>
	           	<td><ai:dbformfield formid="taskF" fieldname="WORKFLOW_OBJECT_ID" width="150"/>
			    <ai:button id="newSaleMain" text="查询" onclick="doWork('query()')"/></td>
			</tr>
		</table>
	</ai:dbform>
</ai:contractframe>
<ai:contractframe id="taskFinishList" contenttype="table" title="" width="100%" allowcontract="true" frameclosed="false">
	<ai:contractitem/>
<ai:table tableid="taskFinishList" setname="com.asiainfo.task.bo.SETFinishTask" height="250" multiselect="false" oncellchange="" editable="false" 
oncontextmenu="" needrefresh="true" onrowchange="onrowchange1" pagesize="30" ondbclick="showDetail"
width="100%" tablemodel="com.ai.appframe2.web.datamodel.MethodModelForService"
implservice_name="com.asiainfo.task.service.interfaces.ICurTaskSV"  
implservice_querymethod="getFinishTask(String staffId,String beginTime,String endTime,String applyname,String objectid,String corporation,String staffname,int $STARTROWINDEX, int $ENDROWINDEX)" 
implservice_countmethod="getFinishTaskCount(String staffId,String beginTime,String endTime,String applyname,String objectid,String corporation,String staffname)"
initial="false" editable="false" width="100%">
 <ai:col fieldname="APPLY_NAME" width="180"/>
 <ai:col fieldname="OBJECT_TYPE_NAME" width="180" visible="false" />
 <ai:col fieldname="TEMPLATE_TAG" width="160" visible="false" />
 <ai:col fieldname="WORKFLOW_ID" width="180" visible="false" />
 <ai:col fieldname="WORKFLOW_OBJECT_ID" width="100" />
 <ai:col fieldname="WORKFLOW_OBJECT_TYPE" width="150" />
 <ai:col fieldname="STAFF_NAME" width="150" />
 <ai:col fieldname="DEPARTMENT" width="150" />
 <ai:col fieldname="ORG_NAME" width="150" />
 <ai:col fieldname="OBJECT_TYPE_NAME" width="180" visible="false" />
</ai:table>
</ai:contractframe>
<table align="center">
  <tr><td>
	<ai:button id="show" text="查看工单详情"  onclick="showDetail()"/>
	<ai:button text="查看知会痕迹" onclick="showMark()"/>
	<ai:button id="apprise" text="知会其他人"  onclick="apprise()"/>
	<ai:button text="任务回退" onclick="doWork('taskback()')"/>
  </td></tr>
</table>
<ai:contractframe id="taskAllList" contenttype="table" title="" width="100%" allowcontract="true" frameclosed="false">
 <ai:contractitem>
 </ai:contractitem>
<ai:table tableid="taskAllList" setname="com.asiainfo.task.bo.SETCurTask" height="200" multiselect="false" oncellchange="showcell" editable="false" oncontextmenu="" needrefresh="true" onrowchange="onrowchange2" pagesize="20"
width="100%" tablemodel="com.ai.appframe2.web.datamodel.MethodModelForService"
implservice_name="com.asiainfo.task.service.interfaces.ICurTaskSV"  
implservice_querymethod="getAllTaskByWorkFlowId(String workflowId,int $STARTROWINDEX, int $ENDROWINDEX)" 
implservice_countmethod="getAllCurTaskCount(String workflowId)"
initial="false">
 <ai:col fieldname="TLABEL" width="180"/>
 <ai:col fieldname="LABEL" width="180" visible="false"/>
 <ai:col fieldname="CORPORATION" width="120"/>
 <ai:col fieldname="ORG_NAME" width="120"/>
 <ai:col fieldname="TASK_STAFF_NAME" width="90"/>
 <ai:col fieldname="STAFF_NAME" width="90" visible="true"/> 
 <ai:col fieldname="DECISION_RESULT" width="70"/>
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
	var staffStr = "<%=staffId%>" ;
	var gRowSet1 = g_TableRowSetManager.get("taskFinishList");
	var gRowSet2 = g_TableRowSetManager.get("taskAllList");
	var finishTask = g_FormRowSetManager.get("taskF");
    //gRowSet1.setFocus(0,0);
    //gRowSet1.setFocusByName(0,"name");
    
    finishTask.setValue("CREATE_DATE",getPre1MonTime());
    finishTask.setValue("FINISH_DATE",getCurrentTime());

  function query(){
    var beginTime = finishTask.getValue("CREATE_DATE");
    var endTime = finishTask.getValue("FINISH_DATE");
    var applyname= finishTask.getValue("APPLY_NAME");
    var objectid = finishTask.getValue("WORKFLOW_OBJECT_ID");
    var corporation = finishTask.getDisplayText("CORPORATION");
    var staffname = finishTask.getValue("CREATE_STAFF_NAME");
    if(beginTime.toString() == "") return alert("请输入开始时间");
    if(endTime.toString() == "") return alert("请输入结束时间");
	if (corporation == "全部") {
		corporation = "";
	} else if (corporation.toString() == "省公司"){
		corporation = "省";
    }
	var param = "staffId=" + staffStr 
	           +"&beginTime="+ beginTime
	           +"&endTime="+ endTime
	           +"&applyname="+ encodeURI(applyname)
	           +"&objectid=" + objectid
	           +"&corporation="+encodeURI(corporation)
	           +"&staffname="+encodeURI(staffname);
    gRowSet1.refresh(param);
    gRowSet1.setFocus(0,0);
    gRowSet1.setFocusByName(0,"name");    
  }

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

<%--  function taskback(){//处理工单--%>
<%--     var curRow = gRowSet2.getRow();--%>
<%--     var curCol = gRowSet2.getCol();--%>
<%--     var taskId = gRowSet2.getValue(curRow,"TASK_ID");--%>
<%--     var staffId = gRowSet2.getValue(curRow,"TASK_STAFF_ID");--%>
<%--     if(staffId==""){--%>
<%--       staffId = staffStr;--%>
<%--     }--%>
<%--     var finishstaffId = gRowSet2.getValue(curRow,"FINISH_STAFF_ID");--%>
<%--     var state = gRowSet2.getValue(curRow,"STATE");--%>
<%--     var WORKFLOW_ID = gRowSet2.getValue(curRow,"WORKFLOW_ID");--%>
<%--     var tlabel = gRowSet2.getValue(curRow,"TLABEL");--%>
<%--     var param2 = "workflowId="+WORKFLOW_ID;--%>
<%--     var object_type=gRowSet2.getValue(curRow,"OBJECT_TYPE_NAME");--%>
<%--     var object_id=gRowSet2.getValue(curRow,"WORKFLOW_OBJECT_ID");--%>
<%--     var curstaff = "<%=staffId%>";--%>
<%--     if(taskId == ""){--%>
<%--       alert("请选择已完成的任务！");--%>
<%--       return;--%>
<%--     }--%>
<%--    //alert("curstaff:"+curstaff+";"+"finishstaffId:"+finishstaffId+"taskId:"+taskId);--%>
<%--     if(staffId != curstaff&&finishstaffId!=curstaff){--%>
<%--       alert("只能回退自己的工单！");--%>
<%--       return;--%>
<%--     }--%>
<%--     if(state=="5"){--%>
<%--       alert("不能回退当前工单！");--%>
<%--       return;--%>
<%--     }--%>
<%--     var url="";--%>
<%--     if(tlabel =="开始"){--%>
<%--       url= "<%=request.getContextPath()%>/business/com.asiainfo.task.web.CurTaskAction?action=terminateWorkflow&object_type="+object_type+"&object_id="+object_id+"&staffId="+staffId;--%>
<%--     }else{--%>
<%--       url= "<%=request.getContextPath()%>/business/com.asiainfo.task.web.CurTaskAction?action=backTask&taskId="+taskId+"&staffId="+staffId;--%>
<%--     }--%>
<%--     var result = PostInfo(url,"");--%>
<%--     alert(result.getValueByName("MESSAGE"));--%>
<%--    gRowSet2.refresh(param2);//刷新--%>
<%-- }--%>

  function taskback(){//处理工单
	 var taskcnt = gRowSet2.getTotalRowCount();
     var url="";	 
	 if(taskcnt==2){
		gRowSet2.setRow(0);
		curRow = gRowSet2.getRow();
        var taskId = gRowSet2.getValue(curRow,"TASK_ID");
        var staffId = gRowSet2.getValue(curRow,"CREATE_STAFF_ID");
        var finishstaffId = gRowSet2.getValue(curRow,"FINISH_STAFF_ID");
        var state = gRowSet2.getValue(curRow,"STATE");
        var WORKFLOW_ID = gRowSet2.getValue(curRow,"WORKFLOW_ID");
        var tlabel = gRowSet2.getValue(curRow,"TLABEL");
        var param2 = "workflowId="+WORKFLOW_ID;
        var object_type=gRowSet2.getValue(curRow,"OBJECT_TYPE_NAME");
        var object_id=gRowSet2.getValue(curRow,"WORKFLOW_OBJECT_ID");
        var curstaff = "<%=staffId%>";
        if(staffId != curstaff&&finishstaffId!=curstaff){
           alert("只能回退自己的工单！");
           return;
         }
        if(state=="5"){
           alert("不能回退当前工单！");
           return;
        }
       url= "<%=request.getContextPath()%>/business/com.asiainfo.task.web.CurTaskAction?action=terminateWorkflow&object_type="+object_type+"&object_id="+object_id+"&staffId="+staffId;
	 }else{
		gRowSet2.setRow(taskcnt-2);
		curRow = gRowSet2.getRow();
        var taskId = gRowSet2.getValue(curRow,"TASK_ID");
        var staffId = gRowSet2.getValue(curRow,"TASK_STAFF_ID");
        var finishstaffId = gRowSet2.getValue(curRow,"FINISH_STAFF_ID");
        var state = gRowSet2.getValue(curRow,"STATE");
        var WORKFLOW_ID = gRowSet2.getValue(curRow,"WORKFLOW_ID");
        var tlabel = gRowSet2.getValue(curRow,"TLABEL");
        var param2 = "workflowId="+WORKFLOW_ID;
        var object_type=gRowSet2.getValue(curRow,"OBJECT_TYPE_NAME");
        var object_id=gRowSet2.getValue(curRow,"WORKFLOW_OBJECT_ID");
        var curstaff = "<%=staffId%>";
        if(staffId != curstaff&&finishstaffId!=curstaff){
           alert("只能回退自己的工单！");
           return;
         }
        if(state=="5"){
           alert("不能回退当前工单！");
           return;
        }
       url= "<%=request.getContextPath()%>/business/com.asiainfo.task.web.CurTaskAction?action=backTask&taskId="+taskId+"&staffId="+staffId;
	 }
	 
     var result = PostInfo(url,"");
     alert(result.getValueByName("MESSAGE"));
    gRowSet2.refresh(param2);//刷新--%>
 }

function onrowchange1(oldIndex,newIndex){
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

  
  function showMark(){
	
	var curRowIndex = 0;
	var selectedRows = gRowSet1.getSelectedRows();
	if (selectedRows.length == 0) {
		curRowIndex = gRowSet1.getCurRowIndex();
	} else {
		curRowIndex = selectedRows[selectedRows.length-1];
	}
	var workflowId = gRowSet1.getValue(curRowIndex,"WORKFLOW_ID");
	if (workflowId!=""){
		
		var url = "<%=request.getContextPath()%>/main3/include/appriseMark.jsp?workflowId="+workflowId;
		window.showModalDialog(url, null, "scroll:no;resizable:no;help:no;status:s;dialogHeight:600px;dialogWidth:680px");
		   
      }else{
           alert(crm_i18n_msg("SOC0100068"));
      }
}

function showDetail(){
	var curRowIndex = 0;
	var selectedRows = gRowSet1.getSelectedRows();
	if (selectedRows.length == 0) {
		curRowIndex = gRowSet1.getCurRowIndex();
	} else if (selectedRows.length == 1){
		curRowIndex = selectedRows[0];
	} else {
		alert("请勾选唯一的工单查看");
		return;
	}
	var itemId = gRowSet1.getValue(curRowIndex, "WORKFLOW_OBJECT_ID");
	var itemType = gRowSet1.getValue(curRowIndex, "OBJECT_TYPE_NAME");
	var url = "";
	if (itemId!=""){
			if (itemType=="weaponCase"){
				var strUrl = '<%=request.getContextPath()%>/business/com.asiainfo.sale.tag.web.TagFlowAction?action=getWeaponTypeByWeaponId&weaponId=' + itemId;
		    	var ret = PostInfo(strUrl, null);
		    	var saleFale = ret.getValueByName("WEAPONTYPE");
				window.open("<%=request.getContextPath()%>/sale/weapon/appriseWeaponInfo.jsp?WID="+itemId + "&saleFale="+saleFale,"","height=650,width=600,top=0,left=0,toolbar=no,menubar=no,scrollbars=yes,resizable=yes,location=no,status=no");
			} else if (itemType=="saleCaseT"||itemType=="saleCase"||itemType=="saleCaseI"||itemType=="saleCaseZQ") {
				
				url = "<%=request.getContextPath()%>/sale/activity/new.jsp?orderId="+itemId+"&editable=false";
				window.open(url, null, 'height=490,width=860,top=0,left=0,toolbar=no,menubar=no,scrollbars=yes,resizable=yes,location=no,status=no');
				
			} else if (itemType == "chargeCaseT" || itemType == "chargeCase"  || itemType == "newChargeCaseT" || itemType == "newChargeCaseP") {
				
				url = "<%=request.getContextPath()%>/charge/chargeinfo/chargeApprove.jsp?applyid="+itemId+"&stype=y";
				window.open(url, null, 'height=490,width=860,top=0,left=0,toolbar=no,menubar=no,scrollbars=yes,resizable=yes,location=no,status=no');
				
			} else if (itemType == "accessCaseT") {
				
				url = "<%=request.getContextPath()%>/sale/access/access_apply_show.jsp?applyid="+itemId;
				window.open(url, null, 'height=490,width=860,top=0,left=0,toolbar=no,menubar=no,scrollbars=yes,resizable=yes,location=no,status=no');
				
			} else if (itemType == "productCase") {
				
				url = "<%=request.getContextPath()%>/sale/activity/include/_goodsTagSelect.jsp";
				window.open(url, null, 'height=490,width=860,top=0,left=0,toolbar=no,menubar=no,scrollbars=yes,resizable=yes,location=no,status=no');
				
			} else if (itemType == "busiChangeCase" || itemType == "busiChangeCaseP") {
				url = "<%=request.getContextPath()%>/sale/access/newBusiChangeShow.jsp?busiId="+itemId;
				window.open(url, null, 'height=490,width=860,top=0,left=0,toolbar=no,menubar=no,scrollbars=yes,resizable=yes,location=no,status=no');
			} else if (itemType == "prestoreCase") {
				url = "<%=request.getContextPath()%>/sale/prestore/prestoreAddInfo.jsp?applyId="+itemId;
				window.open(url, null, 'height=530,width=860,top=0,left=0,toolbar=no,menubar=no,scrollbars=yes,resizable=yes,location=no,status=no');
			} else if (itemType == "chargeSellStopCaseT" || itemType == "chargeSellStopCaseP") {
				url = "<%=request.getContextPath()%>/stopSelling/charge/chargeStopSellShow.jsp?mainId="+itemId;
				window.open(url, null, 'height=530,width=860,top=0,left=0,toolbar=no,menubar=no,scrollbars=yes,resizable=yes,location=no,status=no');
			} else if (itemType == "saleSellStopCaseT" || itemType == "saleSellStopCaseP") {
				url = "<%=request.getContextPath()%>/stopSelling/sale/saleStopSellShow.jsp?mainId="+itemId;
				window.open(url, null, 'height=530,width=860,top=0,left=0,toolbar=no,menubar=no,scrollbars=yes,resizable=yes,location=no,status=no');
			} else if (itemType == "complainCase") {
				url = "<%=request.getContextPath()%>/sale/complain/complainAddInfo.jsp?mainId="+itemId;
				window.open(url, null, 'height=530,width=860,top=0,left=0,toolbar=no,menubar=no,scrollbars=yes,resizable=yes,location=no,status=no');
			} else if (itemType == "UniteChargeFlow") {
				url = "<%=request.getContextPath()%>/charge/chargeinfo/chargeAudit.jsp?recordId="+itemId+"&taskTag=";
				window.open(url, null, 'height=530,width=860,top=0,left=0,toolbar=no,menubar=no,scrollbars=yes,resizable=yes,location=no,status=no');
			} else {
				alert(crm_i18n_msg("SOC0100096"));
			}
      }else{
           alert(crm_i18n_msg("SOC0100068"));
      }
}

function apprise(){
	var curRowIndex = 0;
	var selectedRows = gRowSet1.getSelectedRows();
	if (selectedRows.length == 0) {
		curRowIndex = gRowSet1.getCurRowIndex();
	} else if (selectedRows.length == 1){
		curRowIndex = selectedRows[0];
	} else {
		alert("请勾选唯一的工单知会");
		return;
	}
	workflowId = gRowSet1.getValue(curRowIndex, "WORKFLOW_ID");
	var url = "<%=request.getContextPath()%>/sale/promationTag/appriseDialog.jsp?org_id=10&workflowId=" + workflowId + "&orgInit=false";
    var result = window.showModalDialog(url, null, "scroll:no;resizable:no;help:no;status:s;dialogHeight:400px;dialogWidth:600px");
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
        var url="showmsg.jsp?&taskStaffId="+taskStaffId;
        obj.name = msg;
        window.showModalDialog(url, obj, "scroll:yes;resizable:yes;help:no;status:yes;dialogHeight:200px;dialogWidth:400px;unadorned:yes");
        //window.open(url, obj, "scroll:yes;resizable:yes;help:no;status:no;dialogHeight:200px;dialogWidth:400px");
	   //}
	 }
}

function getPre1MonTime(){
	var now=new Date();
	var year=now.getYear();
	var month=now.getMonth();
	var day=now.getDate();
	var hour=now.getHours();
	var minute=now.getMinutes();
	var second=now.getSeconds();
	if (month == 0){
		year = year - 1;
		month = 12;
	}
	month = month>9?month.toString():'0' + month;
	day = '01';
	hour = hour>9?hour.toString():'0' + hour;
	minute = minute>9?minute.toString():'0' + minute;
	second = second>9?second.toString():'0' + second;
	
	return year+"-"+month+"-"+day+" "+hour+":"+minute+":"+second;
}
function getCurrentTime(){
	var now=new Date();
	var year=now.getYear();
	var month=now.getMonth()+1;
	var day=now.getDate();
	var hour=now.getHours();
	var minute=now.getMinutes();
	var second=now.getSeconds();
	
	month = month>9?month.toString():'0' + month;
	day = day>9?day.toString():'0' + day;
	hour = hour>9?hour.toString():'0' + hour;
	minute = minute>9?minute.toString():'0' + minute;
	second = second>9?second.toString():'0' + second;
	
	return year+"-"+month+"-"+day+" "+hour+":"+minute+":"+second;
}

function toDojo(){
	 var curRow = gRowSet1.getRow();
     var WORKFLOW_ID = gRowSet1.getValue(curRow,"WORKFLOW_ID");
     var objectType = gRowSet1.getValue(curRow,"OBJECT_TYPE_NAME");
     if(WORKFLOW_ID==""){
       alert("请选择展现的任务！");
       return;
     }
  	 var param1 = "workflowId="+WORKFLOW_ID;
     var taskcnt = gRowSet2.getTotalRowCount();
     gRowSet2.setRow(taskcnt-1);
     curRow = gRowSet2.getRow();
     var taskTag = gRowSet2.getValue(curRow,"TASK_TAG");
     
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
     //if(objectType=="prestoreCase"){
    //	 url ="<%=request.getContextPath()%>/main3/workflowshow/TownBatchPreApprove.jsp?taskTag=" +taskTag;
     //}
     if(url == ""){
    	 return;
     }
     window.open(url,"","scroll=yes,resizable=no,status=no,help=no,height=680px,width=1024px");
}
</script>
