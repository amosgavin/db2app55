<%@ page contentType="text/html; charset=GBK"%>
<%@ include file="/secframe/common/common.jsp"%>
<%@ include file="/webframe/common/commonhead.jsp"%>

<html>
<head>
<title>工单投诉查询</title>
<script language="javascript" src="<%=request.getContextPath()%>/jsv2/Calendar.jsp" type="text/javascript"></script>
</head>
  
<body onload="init()">
<ai:contractframe id="orderComplainQueryframe" contenttype="table" title="查询条件" width="100%" allowcontract="true" frameclosed="fale">
	<ai:contractitem/>
	<ai:dbform formid="orderComplainQueryForm" initial="false"
			setname="com.asiainfo.sale.complain.web.SETOrderComplains">
		<table width="98%" align="center" border="0" cellpadding="1" cellspacing="2">
			<tr>
	           	<td class="td_font">工单号：</td>
	           	<td><ai:dbformfield formid="orderComplainQueryForm" fieldname="COMPLAINS_ID" width="150"/></td>
	           	<td class="td_font">名称：</td>
	           	<td><ai:dbformfield formid="orderComplainQueryForm" fieldname="APPLY_NAME" width="150"/></td>        	
			</tr>
			<tr>
	           	<td class="td_font">申请人：</td>
	           	<td><ai:dbformfield formid="orderComplainQueryForm" fieldname="PROP_STAFF" width="150" editable="false"/><img id="selectStaff" border="0" src="<%=request.getContextPath()%>/webframe/images/query.gif" onClick="selectStaff();" style="cursor:hand;"/>&nbsp;<a href="javascript:clsStaff();">清空</a></td>
	           		<ai:dbformfield formid="orderComplainQueryForm" fieldname="PRINCIPLE" width="150" editable="false" visible="false"/>
	           	<td class="td_font">申请地市：</td>
	           	<td><ai:dbformfield formid="orderComplainQueryForm" fieldname="ORG" width="150"/></td>
			</tr>
			<tr>
	           	<td class="td_font">提交时间大于：</td>
	           	<td><ai:dbformfield formid="orderComplainQueryForm" fieldname="PROP_TIME" width="170"/></td>
	           	<td class="td_font">提交时间小于：</td>
	           	<td><ai:dbformfield formid="orderComplainQueryForm" fieldname="QUERY_END_TIME" width="170"/></td>
			</tr>
			<tr>
	           	<td class="td_font">工单状态：</td>
	           	<td><ai:dbformfield formid="orderComplainQueryForm" fieldname="STATE" width="150"/><%--<img id="selectOrgnize" border="0" src="<%=request.getContextPath()%>/webframe/images/check.gif" onClick="selectOrgnize();" align="absmiddle" style="cursor:hand;"/>--%>
					<ai:button id="query2table" text="查询" onclick="doWork('query2table()')"/></td>
			</tr>
		</table>
	</ai:dbform>
</ai:contractframe>
<ai:contractframe id="orderComplainMainframe" contenttype="table" title="业务变更信息" width="100%" allowcontract="true" frameclosed="false">
	<ai:contractitem><ai:button text="删除" id="del_bt" onclick="delOrderComplainMainInfo()"/>
	<ai:button id="bt_backBusiChange" text="回撤工单"  onclick="backComplainChange()"/></ai:contractitem>
	<ai:table tableid="orderComplainMainTab" setname="com.asiainfo.sale.complain.web.SETOrderComplains" 
		height="200" multiselect="false" oncellchange="" ondbclick="redirectToDetailInfo"
		oncontextmenu="" needrefresh="true" onrowchange="changeColor" pagesize="30"
		width="100%" tablemodel="com.ai.appframe2.web.datamodel.MethodModelForService"
		implservice_name="com.asiainfo.sale.complain.service.interfaces.IOrderComplainSV"
		implservice_querymethod="queryOrderComplainValue(String complainId,String applyName, String principle, String cityId, String state,String beginTime, String endTime, int $STARTROWINDEX, int $ENDROWINDEX)" 
		implservice_countmethod="queryOrderComplainCount(String complainId, String applyName,String principle, String cityId, String state, String beginTime,String endTime)" 
		initial="false" editable="false">
				<ai:col fieldname="COMPLAINS_ID" width="80" visible="true"/>
				<ai:col fieldname="ORG" width="150" visible="false"/>
	        	<ai:col fieldname="ORG_NAME" width="150" visible="true"/>
	        	<ai:col fieldname="PROP_STAFF" width="100" visible="true"/>
	        	<ai:col fieldname="PRINCIPLE" width="100" visible="false"/>
	            <ai:col fieldname="TEL" width="80" visible="true"/>
	            <ai:col fieldname="APPLY_NAME" width="200" visible="true"/>
	        	<ai:col fieldname="STATE" width="80" visible="true"/>
	            <ai:col fieldname="PROP_TIME" width="150" visible="true"/>
	            <ai:col fieldname="DESCRIPTION" width="250" visible="true"/>
	</ai:table>
</ai:contractframe>
<ai:loginuser/>
<ai:contractframe id="orderComplainFWframe" contenttype="table" title="工单流转详细" width="100%" allowcontract="true" frameclosed="fale">
<ai:contractitem/>
	<ai:table tableid="taskAllList" setname="com.asiainfo.task.bo.SETCurTask" height="150" multiselect="false" oncellchange="" editable="false" oncontextmenu="" needrefresh="true" onrowchange="" pagesize="200"
		width="100%" onrowchange='' tablemodel="com.ai.appframe2.web.datamodel.MethodModelForService" 
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
var orderComplainQueryForm= g_FormRowSetManager.get("orderComplainQueryForm");
var orderComplainMainTab = g_TableRowSetManager.get("orderComplainMainTab");
var orderComplainTaskTab = g_TableRowSetManager.get("taskAllList");
function init(){ 
   orderComplainQueryForm.setValue("PROP_STAFF",g_GetUserInfo().STAFF_NAME);
   orderComplainQueryForm.setValue("PRINCIPLE",g_GetUserInfo().STAFF_ID);
   orderComplainQueryForm.setValue("PROP_TIME",getPre1MonTime());
   orderComplainQueryForm.setValue("QUERY_END_TIME",getCurrentTime());
   //busiChangeDetailForm.setEditSts("false");
   //g_AIButtonManager.get("busid_bt").setDisabled("false");
}

function query2table(){
	var complainId = orderComplainQueryForm.getValue("COMPLAINS_ID");
	var cityId = orderComplainQueryForm.getValue("ORG");
	var state = orderComplainQueryForm.getValue("STATE");
	var principle = orderComplainQueryForm.getValue("PRINCIPLE");
	var applyName = orderComplainQueryForm.getValue("APPLY_NAME");
	var beginTime = orderComplainQueryForm.getValue("PROP_TIME");
	var endTime = orderComplainQueryForm.getValue("QUERY_END_TIME");
	orderComplainMainTab.refresh("&complainId="+complainId+"&cityId="+cityId+"&principle="+principle
		+ "&state="+state+"&beginTime="+beginTime+"&endTime="+endTime                        
		+"&applyName="+encodeURI(trim(applyName)));
}

function redirectToDetailInfo(){
	
	var curRow = orderComplainMainTab.getRow();
    var complainId = orderComplainMainTab.getValue(curRow, "COMPLAINS_ID");
    var state = orderComplainMainTab.getValue(curRow, "STATE");
    if("" == complainId){
    	alert("请选择要查看的工单！");
    	return;
    }
    var url = "<%=request.getContextPath()%>/sale/complain/complainAddInfo.jsp?mainId=" + complainId;
    window.open(url, null, 'height=490,width=860,top=0,left=0,toolbar=no,menubar=no,scrollbars=yes,resizable=yes,location=no,status=no');
}

function showWFDetail() {
     var curRow = orderComplainMainTab.getRow();
     var state = orderComplainMainTab.getValue(curRow, "STATE");
     var complainId = orderComplainMainTab.getValue(curRow, "COMPLAINS_ID");
     orderComplainTaskTab.clear();
     if (state == '1') return;
     orderComplainTaskTab.refresh("recordId="+complainId+"&state="+state);//刷新
}

function delOrderComplainMainInfo(){
	var curRow = orderComplainMainTab.getRow();
    var complainId = orderComplainMainTab.getValue(curRow, "COMPLAINS_ID");
    var orderState = orderComplainMainTab.getValue(curRow, "STATE");
	if("" == complainId){
		alert("请选择要删除的工单！");
		return;
	}
    if (orderState != '1') {
    	return alert("只能删除保存状态的工单！");
    }
    if (g_GetUserInfo().STAFF_NAME == orderComplainMainTab.getValue(curRow, "PROP_STAFF")){
		if(confirm("您确定要删除！")){
			orderComplainMainTab.deleteRow(curRow);
			var list = new Array();
			list.push(orderComplainMainTab);
		    var strUrl = _gModuleName + '/business/com.asiainfo.sale.complain.web.OrderComplainAction?action=delComplain';
		    var recode = saveRowSet(strUrl, list);
		    var message = recode.getValueByName("MESSAGE");
		    var rFlag = recode.getValueByName("FLAG");
		    if ("Y" == rFlag)
		    {
		    	query2table();
		    	return;
		    } else {
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

function backComplainChange() {
	var curRow = orderComplainMainTab.getRow();
    var complainId = orderComplainMainTab.getValue(curRow, "COMPLAINS_ID");
    var orgId = orderComplainMainTab.getValue(curRow, "ORG");
    var itemType = "complainCase";
    if (complainId == "") {
    	return alert("请选择要回撤的工单！");
    }
    if (orderComplainMainTab.getValue(curRow, "STATE") !=2){
    	return alert("只能回撤审核中工单！");
    }
    if (orderComplainMainTab.getValue(curRow, "PRINCIPLE") != g_GetUserInfo().STAFF_ID){
    	return alert("不能回撤他人的工单！");
    }
    if(confirm("您确定要回撤！")){
    	
		var strUrl=_gModuleName + '/business/com.asiainfo.task.web.CurTaskAction?action=terminateWorkflow&object_id='+complainId+'&staffId='+g_GetUserInfo().STAFF_ID+'&object_type='+itemType;
		var recode = PostInfo(strUrl,null);
		var rFlag = recode.getValueByName("FLAG");
		if ("Y" == rFlag)
		 {
			orderComplainTaskTab.refresh("&workflowId="+"0");
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
        orderComplainQueryForm.setValue("PRINCIPLE", operatorId);
        orderComplainQueryForm.setValue("PROP_STAFF", name); 
    }
} 

function clsStaff(){
	orderComplainQueryForm.setValue("PRINCIPLE", "");
    orderComplainQueryForm.setValue("PROP_STAFF", ""); 
}

function changeColor(oldIndex,newIndex){
    if(-1 != oldIndex) {
    	orderComplainMainTab.setRowBgColor(oldIndex,"");
    }
    orderComplainMainTab.setRowBgColor(newIndex,"yellow");
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

function trim(str)
{
     return str.replace(/(^\s*)|(\s*$)/g, '');
}
</script>
</body>
</html>