<%@ page contentType="text/html; charset=GBK"%>
<%@ include file="/secframe/common/common.jsp"%>
<%@include file="/webframe/common/commonhead.jsp"%>
<html>
<head>
<script language="javascript" src="<%=request.getContextPath()%>/jsv2/Calendar.jsp" type="text/javascript"></script>
</head>
<body onload="init()">

<ai:contractframe id="queryframe" contenttype="table" title="查询条件" width="100%" allowcontract="false" frameclosed="false">
<ai:contractitem/>
<ai:dbform formid="queryForm" 
			setname="com.asiainfo.sale.common.web.SETAppriseTask"
			conditionname="condition" parametersname="parameters"
			onvalchange="" editable="true" initial="false"
			datamodel="com.ai.appframe2.web.datamodel.MethodModelForService"
			implservice_name="com.asiainfo.sale.common.service.interfaces.IAppriseSV"
			implservice_querymethod="getAppriseTask(String operatorId)">
		<table width="98%" align="center" border="0" cellpadding="1" cellspacing="2">
			<tr>
	           	<td class="td_font">工单号：</td>
	           	<td><ai:dbformfield formid="queryForm" fieldname="TASK_ID" width="150"/></td>
	           	<td class="td_font">工单申请名：</td>
	           	<td><ai:dbformfield formid="queryForm" fieldname="APPLY_NAME" width="150"/></td>
	           	<td class="td_font">申请人：</td>
	           	<td><ai:dbformfield formid="queryForm" fieldname="STAFF_NAME" width="150"/></td>
			</tr><tr>
	           	<td class="td_font">申请地市：</td>
	           	<td><ai:dbformfield formid="queryForm" fieldname="APPLY_ORG" width="150"/></td>
	           	<td class="td_font">类型：</td>
	           	<td><ai:dbformfield formid="queryForm" fieldname="APPRISE_FLAG" width="150"/></td>
	           	<td class="td_font">状态：</td>
	           	<td><ai:dbformfield formid="queryForm" fieldname="IS_READED" width="150"/></td>
			</tr>
			<tr>
				<td class="td_font">从时间：</td>
		        <td><ai:dbformfield formid="queryForm" fieldname="CREATE_DATE" width="150"/></td>
		        <td class="td_font">到时间：</td>
	           	<td><ai:dbformfield formid="queryForm" fieldname="SEND_TIME" width="150"/>
	           		<ai:button id="newSaleMain" text="查询" onclick="query()"/></td>
			</tr>
		</table>
	</ai:dbform>
</ai:contractframe>

<ai:contractframe id="appriseInfoframe" contenttype="table" title="知会信息" width="100%" allowcontract="false" frameclosed="false">
<ai:contractitem/>
<ai:table tableid="appriseTask" setname="com.asiainfo.sale.common.web.SETAppriseTask" height="230" multiselect="true" oncellchange="" editable="false" 
	needrefresh="true" pagesize="15" ondbclick="doWork" initial="false" onrowchange='changeColor1'
	width="100%" tablemodel="com.ai.appframe2.web.datamodel.MethodModelForService"
	implservice_name="com.asiainfo.sale.common.service.interfaces.IAppriseSV"  
	implservice_querymethod="getAppriseTask(String operatorId,String taskId,String applyName,String applyPerson,String organizeName,String fromTime,String toTime,String readSts,String appriseSts,int $STARTROWINDEX,int $ENDROWINDEX)" 
	implservice_countmethod="getAppriseTaskCount(String operatorId,String taskId,String applyName,String applyPerson,String organizeName,String fromTime,String toTime,String readSts,String appriseSts)">
		 <ai:col fieldname="ORGANIZE_NAME" width="100"/>
		 <ai:col fieldname="DEPART" width="135"/>
		 <ai:col fieldname="STAFF_NAME" width="70"/>
		 <ai:col fieldname="AID" width="100" visible="false"/>
		 <ai:col fieldname="WORKFLOW_ID" width="200" visible="false"/>
		 <ai:col fieldname="WORKFLOW_OBJECT_TYPE" width="200" visible="false"/>
		 <ai:col fieldname="WF_LABEL" width="150" />
		 <ai:col fieldname="APPLY_NAME" width="180"/>
		 <ai:col fieldname="TASK_LABEL" width="150" visible="false"/>
		 <ai:col fieldname="APPRISE_FLAG" width="70"/>
		 <ai:col fieldname="IS_READED" width="70"/>
		 <ai:col fieldname="DEAL_TIME" width="120"/>
		 <ai:col fieldname="TASK_ID" width="80"/>
		 <ai:col fieldname="CREATE_DATE" width="120"/>
</ai:table>
<table align="center"> 
	<ai:button id="show" text="查看工单详情" onclick="showDetail()"/>
	<ai:button id="mark" text="查看工单知会痕迹" onclick="showMark()"/>
	<ai:button id="apprise" text="标记为已阅或已办" onclick="markDealed()"/>
</table>
</ai:contractframe>

<ai:contractframe id="workflowInfoframe" contenttype="table" title="流程信息" width="100%" allowcontract="true" frameclosed="false">
<ai:contractitem/>
<ai:table tableid="taskAllList" setname="com.asiainfo.task.bo.SETCurTask" height="200" multiselect="false" oncellchange="" editable="false" oncontextmenu="" needrefresh="true" onrowchange="" pagesize="100"
width="100%" onrowchange='changeColor2' tablemodel="com.ai.appframe2.web.datamodel.MethodModelForService"
implservice_name="com.asiainfo.task.service.interfaces.ICurTaskSV"  
implservice_querymethod="getTaskByWorkFlowIdForQ(String recordId,String state,int $STARTROWINDEX, int $ENDROWINDEX)" 
implservice_countmethod="getTaskByWorkFlowIdForQCnt(String recordId,String state)"
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

<ai:contractframe id="senderInfoframe" contenttype="table" title="发送人信息" width="100%" height="250" allowcontract="false" frameclosed="false">
<ai:contractitem/>
<ai:dbform formid="senderInfoForm" 
			setname="com.asiainfo.sale.common.web.SETApprise"
			conditionname="condition" parametersname="parameters"
			onvalchange="" editable="false" initial="false"
			datamodel="com.ai.appframe2.web.datamodel.MethodModelForService"
			implservice_name="com.asiainfo.sale.common.service.interfaces.IAppriseSV"
			implservice_querymethod="getAppriseSender(String operatorId,String workflowId)">
		<table width="98%" align="center" border="0" cellpadding="1" cellspacing="1">
			<tr><td class="td_font">发送人：</td>
				<td><ai:dbformfield formid="senderInfoForm" fieldname="SENDER_INFO" width="350" /></td>
			</tr><tr>
				<td class="td_font">发送时间：</td>
				<td><ai:dbformfield formid="senderInfoForm" fieldname="SEND_TIME" width="350" /></td>
			</tr>
			<tr>
	           	<td class="td_font">内容：</td>
	           	<td><ai:dbformfield formid="senderInfoForm" fieldname="CONTENT" width="600" height="110"/></td>
			</tr>
		</table>
</ai:dbform>
<table align = "center">
	<ai:button id="apprise" text="知会其他人" onclick="apprise()"/>
</table>
</ai:contractframe>

<ai:loginuser/>
<script type="text/javascript">

var operatorId;
var gRowSet = g_TableRowSetManager.get("appriseTask");
var workflowId = '';
var senderInfoFrom = g_FormRowSetManager.get("senderInfoForm");
function init(){
	
	operatorId = g_GetUserInfo().STAFF_ID;
    //gRowSet.refresh("operatorId=" + operatorId);
    //gRowSet.rowSelected(0,true);
    var queryForm = g_FormRowSetManager.get("queryForm");
    queryForm.setValue("CREATE_DATE",getPre1MonTime());
    queryForm.setValue("SEND_TIME",getCurrentTime());
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

function showSenderInfo(){
	
	var selectedRows = gRowSet.getSelectedRows();
	if (selectedRows.length != 0) {
		for (var i=0; i<selectedRows.length; ++i){
    		gRowSet.rowSelected(selectedRows[i],false);
    	}
    }
	var curRowIndex = gRowSet.getCurRowIndex();
	gRowSet.rowSelected(curRowIndex,true);
	workflowId = gRowSet.getValue(curRowIndex, "WORKFLOW_ID");
	var recordId = gRowSet.getValue(curRowIndex, "TASK_ID");
	var param = "&operatorId="+operatorId+"&workflowId="+workflowId;
	g_TableRowSetManager.get("taskAllList").refresh("&recordId="+recordId+"&state=2");
	senderInfoFrom.refresh(param);
	
}

function showMark(){
	
	var curRowIndex = 0;
	var selectedRows = gRowSet.getSelectedRows();
	if (selectedRows.length == 0) {
		curRowIndex = gRowSet.getCurRowIndex();
	} else if(selectedRows.length == 1){
		curRowIndex = selectedRows[selectedRows.length-1];
	} else {
		alert("请勾选唯一的工单查看");
		return;
	}
	var workflowId = gRowSet.getValue(curRowIndex, "WORKFLOW_ID");
	if (workflowId!=""){
		
		var url = "<%=request.getContextPath()%>/main3/include/appriseMark.jsp?workflowId="+workflowId;
		window.showModalDialog(url, null, "scroll:no;resizable:no;help:no;status:s;dialogHeight:600px;dialogWidth:680px");
		   
      }else{
           alert(crm_i18n_msg("SOC0100068"));
      }
}

function showDetail(){
	
	var curRowIndex = 0;
	var selectedRows = gRowSet.getSelectedRows();
	if (selectedRows.length == 0) {
		curRowIndex = gRowSet.getCurRowIndex();
	} else if (selectedRows.length == 1){
		curRowIndex = selectedRows[0];
	} else {
		alert("请勾选唯一的工单查看");
		return;
	}
	var itemId = gRowSet.getValue(curRowIndex, "TASK_ID");
	var itemType = gRowSet.getValue(curRowIndex, "WORKFLOW_OBJECT_TYPE");
	var url = "";
	if (itemId!=""){
		
			if (itemType=="weaponCase"){
				
				var strUrl = '<%=request.getContextPath()%>/business/com.asiainfo.sale.tag.web.TagFlowAction?action=getWeaponTypeByWeaponId&weaponId=' + itemId;
		    	var ret = PostInfo(strUrl, null);
		    	var saleFale = ret.getValueByName("WEAPONTYPE");
		    	
				window.open("<%=request.getContextPath()%>/sale/weapon/appriseWeaponInfo.jsp?WID="+itemId + "&saleFale="+saleFale,"","height=650,width=600,top=0,left=0,toolbar=no,menubar=no,scrollbars=yes,resizable=yes,location=no,status=no");

				 
			} else if (itemType=="saleCaseT" || itemType=="saleCase" || itemType=="saleCaseI" || itemType=="saleCaseZQ") {
				
				url = "<%=request.getContextPath()%>/sale/activity/new.jsp?orderId="+itemId+"&editable=false";
				window.open(url, null, 'height=490,width=860,top=0,left=0,toolbar=no,menubar=no,scrollbars=yes,resizable=yes,location=no,status=no');
				
			} else if (itemType == "chargeCaseT" || itemType == "chargeCase" || itemType == "newChargeCaseT" || itemType == "newChargeCaseP") {
				
				url = "<%=request.getContextPath()%>/charge/chargeinfo/chargeApprove.jsp?applyid="+itemId+"&stype=y";
				window.open(url, null, 'height=490,width=860,top=0,left=0,toolbar=no,menubar=no,scrollbars=yes,resizable=yes,location=no,status=no');
				
			} else if (itemType == "accessCaseT") {
				url = "<%=request.getContextPath()%>/sale/access/access_apply_show.jsp?applyid="+itemId;
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
	var selectedRows = gRowSet.getSelectedRows();
	if (selectedRows.length == 0) {
		curRowIndex = gRowSet.getCurRowIndex();
	} else if (selectedRows.length == 1){
		curRowIndex = selectedRows[0];
	} else {
		alert("请勾选唯一的工单知会");
		return;
	}
	if (gRowSet.getValue(curRowIndex,"TASK_ID") == ''){
		alert(crm_i18n_msg("SOC0100097"));
		return;
	}
	workflowId = gRowSet.getValue(curRowIndex, "WORKFLOW_ID");
	var url = "<%=request.getContextPath()%>/sale/promationTag/appriseDialog.jsp?org_id=10&workflowId=" + workflowId + "&orgInit=false";
    var result = window.showModalDialog(url, null, "scroll:no;resizable:no;help:no;status:s;dialogHeight:400px;dialogWidth:600px");
}

function cancel()
{
	top.close();
}

function markDealed(){
	
	var markedStr = '';
	var selectedRows = gRowSet.getSelectedRows();
	if (selectedRows.length == 0) {
		alert(crm_i18n_msg("SOC0100115"));
		return;
	}
    for (var i=0; i<selectedRows.length; ++i){
    	var isReaded = gRowSet.getValue(selectedRows[i],"IS_READED");
    	//var appriseFlag = gRowSet.getValue(selectedRows[i],"APPRISE_FLAG");
    	if (isReaded == '0' || isReaded == '2'){
    		if (i != 0 && markedStr != '') markedStr += ',';
    		markedStr += gRowSet.getValue(selectedRows[i],"AID");
    	}
    }
    if (markedStr == '') return;
    
    var condition = '&markedStr=' + markedStr;
    var strUrl = '<%=request.getContextPath()%>/business/com.asiainfo.sale.common.web.AppriseAction?action=changeAppriseSta&' + condition;
    var ud = PostInfo(strUrl, null);
    if (ud.getValueByName("FLAG") == "N"){
    	alert(ud.getValueByName("MESSAGE"));
    } else if (ud.getValueByName("FLAG") == "Y"){
    	alert('操作成功！');
    	query();
    	//gRowSet.refresh("operatorId=" + operatorId);
    }
}

function query(){
	var queryForm = g_FormRowSetManager.get("queryForm");
	var taskId = trim(queryForm.getValue("TASK_ID"));
	var applyName = trim(queryForm.getValue("APPLY_NAME"));
	var applyPerson = trim(queryForm.getValue("STAFF_NAME"));
	var organizeName = queryForm.getDisplayText("APPLY_ORG");
	
	if (organizeName == '全部') {
		organizeName = '';
	} else if (organizeName == '省公司') {
		organizeName = '湖北省移动公司';
	}
	
	var fromTime = queryForm.getValue("CREATE_DATE");
	var toTime = queryForm.getValue("SEND_TIME");
	var readSts = queryForm.getValue("IS_READED");
	var appriseSts = queryForm.getValue("APPRISE_FLAG");
	gRowSet.refresh("&operatorId=" + operatorId + "&taskId=" + taskId + "&applyName=" + encodeURI(applyName) + "&applyPerson=" + encodeURI(applyPerson)
					+"&organizeName=" + encodeURI(organizeName) +"&fromTime=" + fromTime + "&toTime=" 
					+ toTime + "&readSts=" + readSts + "&appriseSts=" + appriseSts);
}
function trim(str)
{	
     return str.replace(/(^\s*)|(\s*$)/g, '');
}

function doWork(){ 
	showDetail();
}

function changeColor1(oldIndex,newIndex){
    if(-1 != oldIndex) {
    	gRowSet.setRowBgColor(oldIndex,"");
    }
   		gRowSet.setRowBgColor(newIndex,"yellow");
   		beginAIWaitBanner(showSenderInfo,"正在处理，请稍后...");
}

function changeColor2(oldIndex,newIndex){
	showcell();
    if(-1 != oldIndex) {
    	g_TableRowSetManager.get("taskAllList").setRowBgColor(oldIndex,"");
    }
    	g_TableRowSetManager.get("taskAllList").setRowBgColor(newIndex,"yellow");
}

function showcell(){
	 var curRow = g_TableRowSetManager.get("taskAllList").getRow();
	 var curCol = g_TableRowSetManager.get("taskAllList").getCol();
	 var taskStaffId = g_TableRowSetManager.get("taskAllList").getValue(curRow,"TASK_STAFF_ID");
	 
	  if(taskStaffId==""){
		 taskStaffId = g_TableRowSetManager.get("taskAllList").getValue(curRow,"CREATE_STAFF_ID");
	 }
	 if(curCol==6||curCol==4||curCol==3){
	   var msg = g_TableRowSetManager.get("taskAllList").getValue(curRow,"DESCRIPTION");
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
