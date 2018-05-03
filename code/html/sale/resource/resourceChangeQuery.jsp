<%@ page contentType="text/html; charset=GBK"%>
<%@ include file="/secframe/common/common.jsp"%>
<%@ include file="/webframe/common/commonhead.jsp"%>

<html>
<head>
<title>资源借调信息查询</title>
<script language="javascript" src="<%=request.getContextPath()%>/jsv2/Calendar.jsp" type="text/javascript"></script>
</head>
  <body onload="init()"> 
    <ai:contractframe id="resourceChangeQueryForm" contenttype="table" title="查询条件" width="100%" allowcontract="true" frameclosed="fale">
	<ai:contractitem/>
	<ai:dbform formid="resourceChangeQueryForm" initial="false"
			setname="com.asiainfo.sale.activity.web.SETResourceChange">
		<table width="98%" align="center" border="0" cellpadding="1" cellspacing="2">
			<tr>
	           	<td class="td_font">工单号：</td>
	           	<td><ai:dbformfield formid="resourceChangeQueryForm" fieldname="RESOURCE_ID" width="150"/></td>
	           	<td class="td_font">名称：</td>
	           	<td><ai:dbformfield formid="resourceChangeQueryForm" fieldname="APPLY_NAME" width="150"/></td>        	
			</tr>
			<tr>
	           	<td class="td_font">申请人：</td>
	           	<td><ai:dbformfield formid="resourceChangeQueryForm" fieldname="PROP_STAFF" width="150" editable="false"/><img id="selectStaff" border="0" src="<%=request.getContextPath()%>/webframe/images/query.gif" onClick="selectStaff();" style="cursor:hand;"/>&nbsp;<a href="javascript:clsStaff();">清空</a></td>
	           		<ai:dbformfield formid="resourceChangeQueryForm" fieldname="PRINCIPLE" width="150" editable="false" visible="false"/>
	           	<td class="td_font">申请地市：</td>
	           	<td><ai:dbformfield formid="resourceChangeQueryForm" fieldname="ORG" width="150"/></td>
			</tr>
			<tr>
	           	<td class="td_font">提交时间大于：</td>
	           	<td><ai:dbformfield formid="resourceChangeQueryForm" fieldname="PROP_TIME" width="170"/></td>
	           	<td class="td_font">提交时间小于：</td>
	           	<td><ai:dbformfield formid="resourceChangeQueryForm" fieldname="QUERY_END_TIME" width="170"/></td>
			</tr>
			<tr>
	           	<td class="td_font">工单状态：</td>
	           	<td><ai:dbformfield formid="resourceChangeQueryForm" fieldname="STATE" width="150"/><%--<img id="selectOrgnize" border="0" src="<%=request.getContextPath()%>/webframe/images/check.gif" onClick="selectOrgnize();" align="absmiddle" style="cursor:hand;"/>--%>
					<ai:button id="query2table" text="查询" onclick="doWork('query2table()')"/></td>
			</tr>
		</table>
	</ai:dbform>
</ai:contractframe>

<ai:contractframe id="resourceChangeMainframe" contenttype="table" title="资源借调信息" width="100%" allowcontract="true" frameclosed="false">
	<ai:contractitem><ai:button text="删除" id="del_bt" onclick="delResChangeMainInfo()"/>
	<ai:button id="bt_backBusiChange" text="回撤工单"  onclick="backResChange()"/></ai:contractitem>
	<ai:table tableid="resourceChangeMainTab" setname="com.asiainfo.sale.activity.web.SETResourceChange" 
		height="200" multiselect="false" oncellchange="" ondbclick="redirectToDetailInfo"
		oncontextmenu="" needrefresh="true" onrowchange="changeColor" pagesize="30"
		width="100%" tablemodel="com.ai.appframe2.web.datamodel.MethodModelForService"
		implservice_name="com.asiainfo.sale.activity.service.interfaces.IResourceChangeSV"
		implservice_querymethod="queryResourceChangeValue(String resourceId, String applyName, String principle, String cityId, String state, String beginTime, String endTime, int $STARTROWINDEX, int $ENDROWINDEX)" 
		implservice_countmethod="queryResourceChangeCount(String resourceId, String applyName, String principle, String cityId, String state, String beginTime, String endTime)" 
		initial="false" editable="false">
				<ai:col fieldname="RESOURCE_ID" width="80" visible="true"/>
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

<ai:contractframe id="resChangeFWframe" contenttype="table" title="工单流转详细" width="100%" allowcontract="true" frameclosed="fale">
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
<script language="javascript" type="text/javascript">
function doWork(fun){ 
    beginAIWaitBanner(fun,"正在处理，请稍后...");
}
</script>
<script type="text/javascript">
var resourceChangeQueryForm= g_FormRowSetManager.get("resourceChangeQueryForm");
var resourceChangeMainTab=g_TableRowSetManager.get("resourceChangeMainTab");
var resChangeTaskTab=g_TableRowSetManager.get("taskAllList");
function init(){ 
	
   resourceChangeQueryForm.setValue("PROP_STAFF",g_GetUserInfo().STAFF_NAME);
   resourceChangeQueryForm.setValue("PRINCIPLE",g_GetUserInfo().STAFF_ID);
   resourceChangeQueryForm.setValue("PROP_TIME",getPre1MonTime());
   resourceChangeQueryForm.setValue("QUERY_END_TIME",getCurrentTime());
}

function query2table(){
	var resourceId = resourceChangeQueryForm.getValue("RESOURCE_ID");
	var cityId = resourceChangeQueryForm.getValue("ORG");
	var state = resourceChangeQueryForm.getValue("STATE");
	var principle = resourceChangeQueryForm.getValue("PRINCIPLE");
	var applyName = resourceChangeQueryForm.getValue("APPLY_NAME");
	var beginTime = resourceChangeQueryForm.getValue("PROP_TIME");
	var endTime = resourceChangeQueryForm.getValue("QUERY_END_TIME");
	resourceChangeMainTab.refresh("&resourceId="+resourceId+"&cityId="+cityId+"&principle="+principle
		+ "&state="+state+"&beginTime="+beginTime+"&endTime="+endTime                        
		+"&applyName="+encodeURI(trim(applyName)));
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

function redirectToDetailInfo(){
	
	var curRow = resourceChangeMainTab.getRow();
    var resourceId = resourceChangeMainTab.getValue(curRow, "RESOURCE_ID");
    var state = resourceChangeMainTab.getValue(curRow, "STATE");
    if("" == resourceId){
    	alert("请选择要查看的工单！");
    	return;
    }
    var url = "<%=request.getContextPath()%>/sale/resource/resourceShow01.jsp?resourceId=" + resourceId;
    window.open(url, null, 'height=490,width=860,top=0,left=0,toolbar=no,menubar=no,scrollbars=yes,resizable=yes,location=no,status=no');
}

function changeColor(oldIndex,newIndex){
    if(-1 != oldIndex) {
    	resourceChangeMainTab.setRowBgColor(oldIndex,"");
    }
    resourceChangeMainTab.setRowBgColor(newIndex,"yellow");
    showWFDetail();
}

function showWFDetail() {
     var curRow = resourceChangeMainTab.getRow();
     var state = resourceChangeMainTab.getValue(curRow, "STATE");
     var resourceId = resourceChangeMainTab.getValue(curRow, "RESOURCE_ID");
     resChangeTaskTab.clear();
     if (state == '1') return;
     resChangeTaskTab.refresh("recordId="+resourceId+"&state="+state);//刷新
}

function clsStaff(){
	resourceChangeQueryForm.setValue("PRINCIPLE", "");
    resourceChangeQueryForm.setValue("PROP_STAFF", ""); 
}
function trim(str)
{
     return str.replace(/(^\s*)|(\s*$)/g, '');
}

function delResChangeMainInfo(){
	
	var curRow = resourceChangeMainTab.getRow();
    var resourceId = resourceChangeMainTab.getValue(curRow, "RESOURCE_ID");
    var orderState = resourceChangeMainTab.getValue(curRow, "STATE");
    if (orderState != '1') {
    	return alert("只能删除保存状态的工单！");
    }
    if (g_GetUserInfo().STAFF_NAME == resourceChangeMainTab.getValue(curRow, "PROP_STAFF")){
		if(confirm("您确定要删除！")){
			
			if("" == resourceId){
		        alert("请选择要删除的工单！");
		        return;
		    }
		    try{
			resourceChangeMainTab.deleteRow(curRow);
			}catch(e){
			}
			var list = new Array();
			list.push(resourceChangeMainTab);
		    var strUrl = _gModuleName + '/business/com.asiainfo.sale.activity.web.ResourceChangeAction?action=saveResourceChangeMainInfo';
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
</script>
  </body>
</html>
