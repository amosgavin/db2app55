<%@ page contentType="text/html; charset=GBK"%>
<%@ include file="/secframe/common/common.jsp"%>
<%@ include file="/webframe/common/commonhead.jsp"%>

<html>
<head>
<title>资费停售查询</title>
<script language="javascript" src="<%=request.getContextPath()%>/jsv2/Calendar.jsp" type="text/javascript"></script>
</head>
  
<body onload="init()">
<ai:contractframe id="newBusiChangeQueryframe" contenttype="table" title="查询条件" width="100%" allowcontract="true" frameclosed="fale">
	<ai:contractitem/>
	<ai:dbform formid="chargeStopSellQueryForm" 
            setname="com.asiainfo.stopSelling.set.SETStopSellM"
            conditionname="condition" parametersname="parameters"
            editable="true" initial="false"
            datamodel="com.ai.appframe2.web.datamodel.MethodModelForService"
            implservice_name="com.asiainfo.stopSelling.service.interfaces.IStopSellMSV"
            implservice_querymethod="getStopSellMInfoById(String mainId)">
		<table width="98%" align="center" border="0" cellpadding="1" cellspacing="2">
			<tr>
	           	<td class="td_font">工单号：</td>
	           	<td><ai:dbformfield formid="chargeStopSellQueryForm" fieldname="MAINID" width="150"/></td>
	           	<td class="td_font">名称：</td>
	           	<td><ai:dbformfield formid="chargeStopSellQueryForm" fieldname="APPLY_NAME" width="150"/></td>        	
			</tr>
			<tr>
	           	<td class="td_font">申请人：</td>
	           	<td><ai:dbformfield formid="chargeStopSellQueryForm" fieldname="PROP_STAFF" width="150" editable="false"/><img id="selectStaff" border="0" src="<%=request.getContextPath()%>/webframe/images/query.gif" onClick="selectStaff();" style="cursor:hand;"/>&nbsp;<a href="javascript:clsStaff();">清空</a></td>
	           		<ai:dbformfield formid="chargeStopSellQueryForm" fieldname="PRINCIPAL" width="150" editable="false" visible="false"/>
	           	<td class="td_font">申请地市：</td>
	           	<td><ai:dbformfield formid="chargeStopSellQueryForm" fieldname="ORG_ID" width="150"/></td>
			</tr>
			<tr>
	           	<td class="td_font">提交时间大于：</td>
	           	<td><ai:dbformfield formid="chargeStopSellQueryForm" fieldname="PROP_TIME" width="170"/></td>
	           	<td class="td_font">提交时间小于：</td>
	           	<td><ai:dbformfield formid="chargeStopSellQueryForm" fieldname="QUERY_END_TIME" width="170"/></td>
			</tr>
			<tr>
	           	<td class="td_font">工单状态：</td>
	           	<td><ai:dbformfield formid="chargeStopSellQueryForm" fieldname="STATE" width="150"/>
					<ai:button id="query2table" text="查询" onclick="doWork('query2table()')"/></td>
			</tr>
		</table>
	</ai:dbform>
</ai:contractframe>
<ai:contractframe id="chargeStopSellframe" contenttype="table" title="停售信息" width="100%" allowcontract="true" frameclosed="false">
	<ai:contractitem><ai:button text="删除" id="del_bt" onclick="del()"/>
	<ai:button id="bt_backBusiChange" text="回撤工单"  onclick="back()"/></ai:contractitem>
	<ai:table tableid="chargeStopSellTab" setname="com.asiainfo.stopSelling.set.SETStopSellM" 
		height="200" multiselect="false" oncellchange="" ondbclick="redirectToDetailInfo"
		oncontextmenu="" needrefresh="true" onrowchange="changeColor" pagesize="30"
		initial="false" editable="false" width="100%"
		tablemodel="com.ai.appframe2.web.datamodel.MethodModelForService"
		implservice_name="com.asiainfo.stopSelling.service.interfaces.IStopSellMSV"
		implservice_querymethod="query(String mainId, String applyName, String itemType,
			String principal, String cityId, String state, String beginTime,
			String endTime, int $STARTROWINDEX, int $ENDROWINDEX)" 
		implservice_countmethod="queryCn(String mainId, String applyName, String itemType, String principal,
			String cityId, String state, String beginTime, String endTime)" >
				<ai:col fieldname="MAINID" width="80" visible="true"/>
				<ai:col fieldname="ORG_ID" width="150" visible="false"/>
	        	<ai:col fieldname="ORG_NAME" width="150" visible="true"/>
	        	<ai:col fieldname="PROP_STAFF" width="100" visible="true"/>
	        	<ai:col fieldname="PRINCIPAL" width="100" visible="false"/>
	            <ai:col fieldname="TEL" width="130" visible="true"/>
	            <ai:col fieldname="APPLY_NAME" width="300" visible="true"/>
	        	<ai:col fieldname="STATE" width="100" visible="true"/>
	            <ai:col fieldname="PROP_TIME" width="130" visible="true"/>
	            <ai:col fieldname="DESCRIPTION" width="370" visible="false"/>
	</ai:table>
</ai:contractframe>
<table align="center">
	<tr><td colspan="4" align="center"><ai:button text="查看工单信息" id="savem_bt" onclick="redirectToDetailInfo()" /></td></tr>
</table>
<ai:loginuser/>
<ai:contractframe id="busiChangeFWframe" contenttype="table" title="工单流转详细" width="100%" allowcontract="true" frameclosed="fale">
<ai:contractitem/>
	<ai:table tableid="taskAllList" setname="com.asiainfo.task.bo.SETCurTask" height="150" multiselect="false" oncellchange="" editable="false" oncontextmenu="" needrefresh="true" onrowchange="" pagesize="200"
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

<script language="javascript" src="<%=request.getContextPath()%>/sale/common/js/ModaDialog.js" type="text/javascript"></script>
<script language="javascript" type="text/javascript" src="<%=request.getContextPath()%>/jsv2/AIWaitBanner.js"></script>
<script language="javascript" src="<%=request.getContextPath()%>/sale/common/js/openSelect.js" type="text/javascript"></script>
<script language="javascript" type="text/javascript">
function doWork(fun){ 
    beginAIWaitBanner(fun,"正在处理，请稍后...");
}
</script>
<script language="javascript" type="text/javascript">
var chargeStopSellQueryForm= g_FormRowSetManager.get("chargeStopSellQueryForm");
var chargeStopSellTab = g_TableRowSetManager.get("chargeStopSellTab");
var taskTab = g_TableRowSetManager.get("taskAllList");
function init(){ 
	
   chargeStopSellQueryForm.setValue("PROP_STAFF",g_GetUserInfo().STAFF_NAME);
   chargeStopSellQueryForm.setValue("PRINCIPAL",g_GetUserInfo().STAFF_ID);
   chargeStopSellQueryForm.setValue("PROP_TIME",getPre1MonTime());
   chargeStopSellQueryForm.setValue("QUERY_END_TIME",getCurrentTime());
}

function query2table(){
	
	var mainId = chargeStopSellQueryForm.getValue("MAINID");
	var cityId = chargeStopSellQueryForm.getValue("ORG_ID");
	var state = chargeStopSellQueryForm.getValue("STATE");
	var principal = chargeStopSellQueryForm.getValue("PRINCIPAL");
	var applyName = chargeStopSellQueryForm.getValue("APPLY_NAME");
	var beginTime = chargeStopSellQueryForm.getValue("PROP_TIME");
	var endTime = chargeStopSellQueryForm.getValue("QUERY_END_TIME");
	chargeStopSellTab.refresh("&mainId="+mainId+"&itemType=charge"+"&cityId="+cityId+"&principal="+principal
		+ "&state="+state+"&beginTime="+beginTime+"&endTime="+endTime                        
		+"&applyName="+encodeURI(trim(applyName)));
}

function redirectToDetailInfo(){
	
	var curRow = chargeStopSellTab.getRow();
    var mainId = chargeStopSellTab.getValue(curRow, "MAINID");
    var state = chargeStopSellTab.getValue(curRow, "STATE");
    if("" == mainId){
    	alert("请选择要查看的工单！");
    	return;
    }
    var url = "<%=request.getContextPath()%>/stopSelling/charge/chargeStopSellShow.jsp?mainId=" + mainId;
    window.open(url, null, 'height=490,width=860,top=0,left=0,toolbar=no,menubar=no,scrollbars=yes,resizable=yes,location=no,status=no');
}

function showWFDetail() {
     var curRow = chargeStopSellTab.getRow();
     var state = chargeStopSellTab.getValue(curRow, "STATE");
     var mainId = chargeStopSellTab.getValue(curRow, "MAINID");
     taskTab.clear();
     if (state == '1') return;
     taskTab.refresh("recordId="+mainId+"&state="+state);//刷新
}

function del(){
	var curRow = chargeStopSellTab.getRow();
    var mainId = chargeStopSellTab.getValue(curRow, "MAINID");
    var orderState = chargeStopSellTab.getValue(curRow, "STATE");
    if (orderState != '1') {
    	return alert("只能删除保存状态的工单！");
    }
    if (g_GetUserInfo().STAFF_NAME == chargeStopSellTab.getValue(curRow, "PROP_STAFF")){
		if(confirm("您确定要删除！")){
			
			if("" == mainId){
		        alert("请选择要删除的工单！");
		        return;
		    }
			chargeStopSellTab.deleteRow(curRow);
			var list = new Array();
			list.push(chargeStopSellTab);
		    var strUrl = _gModuleName + '/business/com.asiainfo.stopSelling.web.StopSellMAction?action=saveStopSellMInfo';
		    var recode = saveRowSet(strUrl, list);
		
		    var message = recode.getValueByName("MESSAGE");
		    var rFlag = recode.getValueByName("FLAG");
		    if ("Y" == rFlag)
		    {
		    	//alert(message);
		    	query2table();
		    	return;
		    } else {
		        //alert(message);
		        query2table();
		        return;
		    }
		} else {
			return;
		}
	} else {
		alert("只能删除自己的工单！");
	}
}

function back() {
	var curRow = chargeStopSellTab.getRow();
    var mainId = chargeStopSellTab.getValue(curRow, "MAINID");
    var orgId = chargeStopSellTab.getValue(curRow, "ORG_ID");
    var itemType = "chargeSellStopCaseT";
    if (orgId.substr(0,2) == "10") {
    	itemType = "chargeSellStopCaseP";
    }
    if (mainId == "") {
    	return alert("请选择要回撤的工单！");
    }
    if (chargeStopSellTab.getValue(curRow, "STATE") !=2){
    	return alert("只能回撤审核中工单！");
    }
    if (chargeStopSellTab.getValue(curRow, "PRINCIPAL") != g_GetUserInfo().STAFF_ID){
    	return alert("不能回撤他人的工单！");
    }
    if(confirm("您确定要回撤！")){
    	
		var strUrl=_gModuleName + '/business/com.asiainfo.task.web.CurTaskAction?action=terminateWorkflow&object_id='+mainId+'&staffId='+g_GetUserInfo().STAFF_ID+'&object_type=' + itemType;
		var recode = PostInfo(strUrl,null);
		var rFlag = recode.getValueByName("FLAG");
		if ("Y" == rFlag)
		 {
			//chargeStopSellTab.refresh("&workflowId=''");
			alert("回退成功！");
		    query2table();
		    return;
		 } else {
			alert("回退失败！");
		    return;
		 }
    }
}

function selectStaff()
{
	var result = openSelect.staffSelect("tsd",'10',g_GetUserInfo().ORG_ID);
    if(result != null){
        var operatorId;
        var name;
        for(var i=0;i < result.elements.length;i++)
        {
            if (i == 0)
            {
                operatorId = result.elements[i].operatorId;
                name = result.elements[i].name;
            } else {
                operatorId = operatorId + ";" + result.elements[i].operatorId;
                name = name + ";" + result.elements[i].name;
            }
        }
        chargeStopSellQueryForm.setValue("PRINCIPAL", operatorId);
        chargeStopSellQueryForm.setValue("PROP_STAFF", name); 
    }
} 

function clsStaff(){
	chargeStopSellQueryForm.setValue("PRINCIPAL", "");
    chargeStopSellQueryForm.setValue("PROP_STAFF", ""); 
}

function changeColor(oldIndex,newIndex){
    if(-1 != oldIndex) {
    	chargeStopSellTab.setRowBgColor(oldIndex,"");
    }
    chargeStopSellTab.setRowBgColor(newIndex,"yellow");
    showWFDetail();
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

function trim(str)
{
     return str.replace(/(^\s*)|(\s*$)/g, '');
}
</script>
</body>
</html>