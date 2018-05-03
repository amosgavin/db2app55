<%@ page contentType="text/html; charset=GBK"%>
<%@ include file="/secframe/common/common.jsp"%>
<%@include file="/webframe/common/commonhead.jsp"%>

<html>
<head>
<title><i18n:message key="工单配置环节处理时间"/></title>
<script language="javascript" src="<%=request.getContextPath()%>/jsv2/Calendar.jsp" type="text/javascript"></script>
</head>
<body onload="initPage();">
<ai:contractframe id="queryframe" contenttype="table" title="查询条件" width="100%" allowcontract="false" frameclosed="false">
<ai:contractitem/>
<ai:dbform formid="queryForm" 
			setname="com.asiainfo.bi.web.SETTaskNodeDT"
			conditionname="condition" parametersname="parameters"
			onvalchange="" editable="true" initial="false"
			datamodel="com.ai.appframe2.web.datamodel.MethodModelForService"
			implservice_name="com.asiainfo.bi.service.interfaces.ITaskNodeDealTimeSV">
		<table width="98%" align="center" border="0" cellpadding="1" cellspacing="2">
		    <tr>
		    	<td class="td_font">工单编号：</td>
		    	<td><ai:dbformfield formid="queryForm" fieldname="WORKFLOW_OBJECT_ID" width="150"/></td>
		    	<td class="td_font">工单类型：</td>
		    	<td><ai:dbformfield formid="queryForm" fieldname="WORKFLOW_OBJECT_TYPE" width="150"/></td>
		    	<td class="td_font">流程节点：</td>
		    	<td><ai:dbformfield formid="queryForm" fieldname="NODE" width="150"/></td>
		    	<td class="td_font">任务接受人：</td>
		    	<td><ai:dbformfield formid="queryForm" fieldname="STAFF_NAME" width="150"/></td>
		    	<!-- <td class="td_font">工单完成时间（从）：</td>
		    	<td><ai:dbformfield formid="queryForm" fieldname="FINISH_DATE_FROM" width="150"/></td>
		    	<td class="td_font">工单完成时间（截止）：</td>
		    	<td><ai:dbformfield formid="queryForm" fieldname="FINISH_DATE_TO" width="150"/></td> -->
		    </tr>
		    <tr>
		    	<td class="td_font">是否延迟：</td>
		    	<td><ai:dbformfield formid="queryForm" fieldname="IS_DELAY" width="150"/></td>
		    	<td class="td_font">延迟时间（>=）：</td>
		    	<td><ai:dbformfield formid="queryForm" fieldname="DAY_GE" width="150"/>天</td>
		    	<td class="td_font">延迟时间（<=）：</td>
		    	<td><ai:dbformfield formid="queryForm" fieldname="DAY_LE" width="150"/>天
		    	<ai:button text="查询" onclick="query()"/></td>
		    </tr>
		</table>
	</ai:dbform>
</ai:contractframe>

<ai:contractframe id="taskNodeiframe" contenttype="table" title="工单配置环节处理时间" width="100%" allowcontract="false" frameclosed="false">
<ai:contractitem><ai:button id="agreeApprove" text="同意延迟原因" onclick="changeApproveFlag(1)"/>
				 <ai:button id="noAgreeApprove" text="不同意延迟原因" onclick="changeApproveFlag(0)"/> </ai:contractitem>
<ai:table tableid="taskNodeDTTab" setname="com.asiainfo.bi.web.SETTaskNodeDT" 
    height="460" multiselect="false" onrowchange="changeColor" editable="false" 
	needrefresh="true" pagesize="30" initial="false" rowheight="25"
	width="100%" tablemodel="com.ai.appframe2.web.datamodel.MethodModelForService"
	implservice_name="com.asiainfo.bi.service.interfaces.ITaskNodeDealTimeSV"
	implservice_querymethod="query(String itemId, String itemType,
			String taskReceiverOpid, String taskReceiver, String node,
			String finishDateFrom, String finishDateTo, String dayLe,
			String dayGe, String isDelay, int $STARTROWINDEX,int $ENDROWINDEX)"
	implservice_countmethod="queryCn(String itemId, String itemType,
			String taskReceiverOpid, String taskReceiver, String node,
			String finishDateFrom, String finishDateTo, String dayLe,
			String dayGe, String isDelay)">
		 <ai:col fieldname="WORKFLOW_OBJECT_ID" width="80"/>
		 <ai:col fieldname="WF_NAME" width="150"/>
		 <ai:col fieldname="TLABEL" width="160"/>
		 <ai:col fieldname="TASK_TAG" width="180" visible="false"/>
		 <ai:col fieldname="TASK_REC_TIME" width="100"/>
		 <ai:col fieldname="TASK_END_TIME" width="100"/>
		 <ai:col fieldname="ADVISE_DEAL_TIME" width="100"/>
		 <ai:col fieldname="TASK_STAFF_ID" width="130" visible="false"/>
		 <ai:col fieldname="STAFF_NAME" width="90"/>
		 <ai:col fieldname="IS_DELAY" width="70"/>
		 <ai:col fieldname="DIFF_DAY" width="110"/>
		 <ai:col fieldname="APPROVE_FLAG" width="100"/>
		 <ai:col fieldname="DELAY_REASON" width="400"/>
</ai:table>
</ai:contractframe>
</body>
<script type="text/javascript">
var queryForm = g_FormRowSetManager.get("queryForm");
var taskNodeDTTab = g_TableRowSetManager.get("taskNodeDTTab");
function initPage(){
	//busiSupportTab.refresh();
}

function changeApproveFlag(state) {
	var curRow = taskNodeDTTab.getCurRowIndex();
	var itemId = taskNodeDTTab.getValue(curRow, "WORKFLOW_OBJECT_ID");
	var taskTag = taskNodeDTTab.getValue(curRow, "TASK_TAG");
	var isDelay = taskNodeDTTab.getValue(curRow, "IS_DELAY");
	if (isDelay != '0') return alert("工单未延迟！");
	var condition = 'itemId=' + itemId + '&taskTag=' + taskTag + '&approveFlag=' + state;
	var strUrl = _gModuleName+'/business/com.asiainfo.common.web.ItemOtherInfoAction?action=saveItemOtherInfo&'+condition;
	var recode = PostInfo(strUrl);
	if (recode.getValueByName("FLAG") == "Y") {
		alert("审核成功！");
		query();
	} else {
		alert("审核失败！");
		return;
	}
}

function query() {
	var itemId = queryForm.getValue("WORKFLOW_OBJECT_ID");
	var itemType = queryForm.getValue("WORKFLOW_OBJECT_TYPE");
	//var finishDateFrom = queryForm.getValue("FINISH_DATE_FROM");
	//var finishDateTo = queryForm.getValue("FINISH_DATE_TO");
	var dayLe = queryForm.getValue("DAY_LE");
	var dayGe = queryForm.getValue("DAY_GE");
	var isDelay = queryForm.getValue("IS_DELAY");
	var node = queryForm.getValue("NODE");
	var taskReceiver = queryForm.getValue("STAFF_NAME");
	if (dayGe > dayLe && dayLe != 0) return alert("延迟时间查询条件有误！");
	taskNodeDTTab.refresh("&itemId=" + itemId + "&itemType=" + itemType + "&dayGe=" + dayGe + "&dayLe=" + dayLe//+ "&finishDateFrom=" + finishDateFrom +　"&finishDateTo=" + finishDateTo
		                   + "&isDelay=" + isDelay + "&node=" + node + "&taskReceiver=" +encodeURI(taskReceiver));
}

function changeColor(oldIndex,newIndex){
    if(-1 != oldIndex) {
    	taskNodeDTTab.setRowBgColor(oldIndex,"");
    }
    taskNodeDTTab.setRowBgColor(newIndex,"yellow");
	showcell();
}
function showcell(){
	 var curRow = taskNodeDTTab.getRow();
	 var curCol = taskNodeDTTab.getCol();
	 var taskStaffId=taskNodeDTTab.getValue(curRow,"TASK_STAFF_ID");
	 if(curCol == 10){
	    var msg = taskNodeDTTab.getValue(curRow,"DELAY_REASON");
        var obj= new Object();
        var url="<%=request.getContextPath()%>/main3/include/showmsg.jsp?&taskStaffId="+taskStaffId;
        obj.name = msg;
        window.showModalDialog(url, obj, "scroll:yes;resizable:yes;help:no;status:yes;dialogHeight:200px;dialogWidth:400px;unadorned:yes");
	 }
}

function trim(str)
{
     return str.replace(/(^\s*)|(\s*$)/g, '');
}
</script>
</html>