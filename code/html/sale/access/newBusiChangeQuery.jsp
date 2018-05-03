<%@ page contentType="text/html; charset=GBK"%>
<%@ include file="/secframe/common/common.jsp"%>
<%@ include file="/webframe/common/commonhead.jsp"%>

<html>
<head>
<title>业务变更申请</title>
<script language="javascript" src="<%=request.getContextPath()%>/jsv2/Calendar.jsp" type="text/javascript"></script>
</head>
  
<body onload="init()">
<ai:contractframe id="newBusiChangeQueryframe" contenttype="table" title="查询条件" width="100%" allowcontract="true" frameclosed="fale">
	<ai:contractitem/>
	<ai:dbform formid="newBusiChangeQueryForm" initial="false"
			setname="com.asiainfo.sale.access.web.SETBusiChange">
		<table width="98%" align="center" border="0" cellpadding="1" cellspacing="2">
			<tr>
	           	<td class="td_font">工单号：</td>
	           	<td><ai:dbformfield formid="newBusiChangeQueryForm" fieldname="BUSI_ID" width="150"/></td>
	           	<td class="td_font">名称：</td>
	           	<td><ai:dbformfield formid="newBusiChangeQueryForm" fieldname="APPLY_NAME" width="150"/></td>        	
			</tr>
			<tr>
	           	<td class="td_font">申请人：</td>
	           	<td><ai:dbformfield formid="newBusiChangeQueryForm" fieldname="PROP_STAFF" width="150" editable="false"/><img id="selectStaff" border="0" src="<%=request.getContextPath()%>/webframe/images/query.gif" onClick="selectStaff();" style="cursor:hand;"/>&nbsp;<a href="javascript:clsStaff();">清空</a></td>
	           		<ai:dbformfield formid="newBusiChangeQueryForm" fieldname="PRINCIPLE" width="150" editable="false" visible="false"/>
	           	<td class="td_font">申请地市：</td>
	           	<td><ai:dbformfield formid="newBusiChangeQueryForm" fieldname="ORG" width="150"/></td>
			</tr>
			<tr>
	           	<td class="td_font">提交时间大于：</td>
	           	<td><ai:dbformfield formid="newBusiChangeQueryForm" fieldname="PROP_TIME" width="170"/></td>
	           	<td class="td_font">提交时间小于：</td>
	           	<td><ai:dbformfield formid="newBusiChangeQueryForm" fieldname="QUERY_END_TIME" width="170"/></td>
			</tr>
			<tr>
	           	<td class="td_font">工单状态：</td>
	           	<td><ai:dbformfield formid="newBusiChangeQueryForm" fieldname="STATE" width="150"/><%--<img id="selectOrgnize" border="0" src="<%=request.getContextPath()%>/webframe/images/check.gif" onClick="selectOrgnize();" align="absmiddle" style="cursor:hand;"/>--%>
					<ai:button id="query2table" text="查询" onclick="doWork('query2table()')"/></td>
			</tr>
		</table>
	</ai:dbform>
</ai:contractframe>
<ai:contractframe id="newBusiChangeMainframe" contenttype="table" title="业务变更信息" width="100%" allowcontract="true" frameclosed="false">
	<ai:contractitem><ai:button text="删除" id="del_bt" onclick="delBusiChangeMainInfo()"/>
	<ai:button id="bt_backBusiChange" text="回撤工单"  onclick="backBusiChange()"/></ai:contractitem>
	<ai:table tableid="newBusiChangeMainTab" setname="com.asiainfo.sale.access.web.SETBusiChange" 
		height="200" multiselect="false" oncellchange="" ondbclick="redirectToDetailInfo"
		oncontextmenu="" needrefresh="true" onrowchange="changeColor" pagesize="30"
		width="100%" tablemodel="com.ai.appframe2.web.datamodel.MethodModelForService"
		implservice_name="com.asiainfo.sale.access.service.interfaces.IBusiChangeSV"
		implservice_querymethod="queryBusiChangeValue(String busiId, String applyName, String principle, String cityId, String state, String beginTime, String endTime, int $STARTROWINDEX, int $ENDROWINDEX)" 
		implservice_countmethod="queryBusiChangeCount(String busiId, String applyName, String principle, String cityId, String state, String beginTime, String endTime)" 
		initial="false" editable="false">
				<ai:col fieldname="BUSI_ID" width="80" visible="true"/>
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
<ai:contractframe id="busiChangeFWframe" contenttype="table" title="工单流转详细" width="100%" allowcontract="true" frameclosed="fale">
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
			<ai:col fieldname="DECISION_RESULT" width="70"/>
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
var newBusiChangeQueryForm= g_FormRowSetManager.get("newBusiChangeQueryForm");
var newBusiChangeMainTab = g_TableRowSetManager.get("newBusiChangeMainTab");
var newBusiChangeTaskTab = g_TableRowSetManager.get("taskAllList");
function init(){ 
	
   newBusiChangeQueryForm.setValue("PROP_STAFF",g_GetUserInfo().STAFF_NAME);
   newBusiChangeQueryForm.setValue("PRINCIPLE",g_GetUserInfo().STAFF_ID);
   newBusiChangeQueryForm.setValue("PROP_TIME",getPre1MonTime());
   newBusiChangeQueryForm.setValue("QUERY_END_TIME",getCurrentTime());
   //busiChangeDetailForm.setEditSts("false");
   //g_AIButtonManager.get("busid_bt").setDisabled("false");
}

function query2table(){
	
	var busiId = newBusiChangeQueryForm.getValue("BUSI_ID");
	var cityId = newBusiChangeQueryForm.getValue("ORG");
	var state = newBusiChangeQueryForm.getValue("STATE");
	var principle = newBusiChangeQueryForm.getValue("PRINCIPLE");
	var applyName = newBusiChangeQueryForm.getValue("APPLY_NAME");
	var beginTime = newBusiChangeQueryForm.getValue("PROP_TIME");
	var endTime = newBusiChangeQueryForm.getValue("QUERY_END_TIME");
	newBusiChangeMainTab.refresh("&busiId="+busiId+"&cityId="+cityId+"&principle="+principle
		+ "&state="+state+"&beginTime="+beginTime+"&endTime="+endTime                        
		+"&applyName="+encodeURI(trim(applyName)));
}

function redirectToDetailInfo(){
	
	var curRow = newBusiChangeMainTab.getRow();
    var busiId = newBusiChangeMainTab.getValue(curRow, "BUSI_ID");
    var state = newBusiChangeMainTab.getValue(curRow, "STATE");
    if("" == busiId){
    	alert("请选择要查看的工单！");
    	return;
    }
    var url = "<%=request.getContextPath()%>/sale/access/newBusiChangeShow.jsp?busiId=" + busiId;
    window.open(url, null, 'height=490,width=860,top=0,left=0,toolbar=no,menubar=no,scrollbars=yes,resizable=yes,location=no,status=no');
}

function showWFDetail() {
     var curRow = newBusiChangeMainTab.getRow();
     var state = newBusiChangeMainTab.getValue(curRow, "STATE");
     var busiId = newBusiChangeMainTab.getValue(curRow, "BUSI_ID");
     newBusiChangeTaskTab.clear();
     if (state == '1') return;
     newBusiChangeTaskTab.refresh("recordId="+busiId+"&state="+state);//刷新
}

function delBusiChangeMainInfo(){
	
	var curRow = newBusiChangeMainTab.getRow();
    var busiId = newBusiChangeMainTab.getValue(curRow, "BUSI_ID");
    var orderState = newBusiChangeMainTab.getValue(curRow, "STATE");
    if (orderState != '1') {
    	return alert("只能删除保存状态的工单！");
    }
    if (g_GetUserInfo().STAFF_NAME == newBusiChangeMainTab.getValue(curRow, "PROP_STAFF")){
		if(confirm("您确定要删除！")){
			
			if("" == busiId){
		        alert("请选择要删除的工单！");
		        return;
		    }
		    try{
			newBusiChangeMainTab.deleteRow(curRow);
			}catch(e){
			}
			var list = new Array();
			list.push(newBusiChangeMainTab);
		    var strUrl = _gModuleName + '/business/com.asiainfo.sale.access.web.BusiChangeAction?action=saveBusiChangeMainInfo';
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

function backBusiChange() {
	var curRow = newBusiChangeMainTab.getRow();
    var busiId = newBusiChangeMainTab.getValue(curRow, "BUSI_ID");
    var orgId = newBusiChangeMainTab.getValue(curRow, "ORG");
    var itemType = "busiChangeCase";
    if (orgId.substr(0,2) == "10") {
    	itemType = "busiChangeCaseP";
    }
    if (busiId == "") {
    	return alert("请选择要回撤的工单！");
    }
    if (newBusiChangeMainTab.getValue(curRow, "STATE") !=2){
    	return alert("只能回撤审核中工单！");
    }
    if (newBusiChangeMainTab.getValue(curRow, "PRINCIPLE") != g_GetUserInfo().STAFF_ID){
    	return alert("不能回撤他人的工单！");
    }
    if(confirm("您确定要回撤！")){
    	
		var strUrl=_gModuleName + '/business/com.asiainfo.task.web.CurTaskAction?action=terminateWorkflow&object_id='+busiId+'&staffId='+g_GetUserInfo().STAFF_ID+'&object_type='+itemType;
		var recode = PostInfo(strUrl,null);
		var rFlag = recode.getValueByName("FLAG");
		if ("Y" == rFlag)
		 {
			newBusiChangeTaskTab.refresh("&workflowId="+"0");
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
        newBusiChangeQueryForm.setValue("PRINCIPLE", operatorId);
        newBusiChangeQueryForm.setValue("PROP_STAFF", name); 
    }
} 

function clsStaff(){
	newBusiChangeQueryForm.setValue("PRINCIPLE", "");
    newBusiChangeQueryForm.setValue("PROP_STAFF", ""); 
}

function changeColor(oldIndex,newIndex){
    if(-1 != oldIndex) {
    	newBusiChangeMainTab.setRowBgColor(oldIndex,"");
    }
    newBusiChangeMainTab.setRowBgColor(newIndex,"yellow");
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