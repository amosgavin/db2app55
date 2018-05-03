<%@ page contentType="text/html; charset=GBK"%>
<%@ include file="/secframe/common/common.jsp"%>
<%@include file="/webframe/common/commonhead.jsp"%>
<html>
<head>
<title><i18n:message key="logger.query.login.titile" res="i18n.secframe_resource"/></title>
<script language="javascript" src="<%=request.getContextPath()%>/jsv2/Calendar.jsp" type="text/javascript"></script>
</head>
<body onload="initOper()">
<ai:contractframe id="selectSaleMainframe" contenttype="table" title="查询条件" width="100%" allowcontract="true" frameclosed="fale">
	<ai:contractitem/>
	<ai:dbform formid="queryForm" initial="false"
			setname="com.asiainfo.sale.prestore.web.SETSaleBatchPrestore"
			onvalchange="" >
		<table width="98%" align="center" border="0" cellpadding="1" cellspacing="2">
			<tr>
	           	<td class="td_font">申请编号：</td>
	           	<td><ai:dbformfield formid="queryForm" fieldname="ID" width="150"/></td>
	           	<td class="td_font">申请名称：</td>
	           	<td><ai:dbformfield formid="queryForm" fieldname="APPLY_NAME" width="150"/></td>        	
			</tr>
			<tr>
	           	<td class="td_font">申请人：</td>
	           	<td><ai:dbformfield formid="queryForm" fieldname="PRINCIPAL" width="150" editable="false"/><img id="selectStaff" border="0" src="<%=request.getContextPath()%>/webframe/images/query.gif" onClick="selectStaff();" style="cursor:hand;"/>&nbsp;<a href="javascript:clsStaff();">清空</a></td>
	           	<td class="td_font">申请地市：</td>
	           	<td><ai:dbformfield formid="queryForm" fieldname="AREA_CODE" width="150"/></td>
			</tr>
			<tr>
	           	<td class="td_font">申请时间大于：</td>
	           	<td><ai:dbformfield formid="queryForm" fieldname="CREATE_TIME" width="150"/></td>
	           	<td class="td_font">申请时间小于：</td>
	           	<td><ai:dbformfield formid="queryForm" fieldname="DONE_TIME" width="150"/></td>
			</tr>
			<tr>
	           	<td class="td_font">工单状态：</td>
	           	<td><ai:dbformfield formid="queryForm" fieldname="IS_SUBMIT" width="150"/><%--<img id="selectOrgnize" border="0" src="<%=request.getContextPath()%>/webframe/images/check.gif" onClick="selectOrgnize();" align="absmiddle" style="cursor:hand;"/>--%>
	           	<ai:dbformfield formid="queryForm" fieldname="PROMOTE_DEPART" visible="false"/>
					<ai:button id="selecttable" text="查询" onclick="doWork('doQuery()')"/></td>
			</tr>
		</table>
	</ai:dbform>
</ai:contractframe>
<ai:contractframe id="saleMainframe" contenttype="table" title="预存信息" width="100%" allowcontract="true" frameclosed="fale">
	<ai:contractitem>
	<ai:button id="bt_del" text="删除工单" onclick="doWork('doDel()')"/>&nbsp;&nbsp;
    <ai:button id="bt_cancel" text="回撤工单" onclick="doCancelWF()"/></ai:contractitem>
 	
 	<ai:table
		tableid="queryList"
		setname="com.asiainfo.sale.prestore.web.SETSaleBatchPrestore"
		tablemodel="com.ai.appframe2.web.datamodel.MethodModelForService"
		implservice_name="com.asiainfo.sale.prestore.service.interfaces.ISaleBatchPrestoreSV"
		implservice_querymethod="queryPrestoreInfo(String applyId, String applyName, String principal, String regionCode, String beginTime, String endTime, String isSubmit, int $STARTROWINDEX, int $ENDROWINDEX)"
		implservice_countmethod="queryPrestoreInfoCount(String applyId, String applyName, String principal, String regionCode, String beginTime, String endTime, String isSubmit)"
		initial="false"  multiselect="true" footdisplay="block" ondbclick="doShowDetailInfo" onrowchange="onRowChangeT"
		pagesize="15" editable="false" width="100%"
		height="150" needrefresh="true">
        <ai:col title="编号" fieldname="ID" width="8%"/>
		<ai:col title="申请名称" fieldname="APPLY_NAME" width="20%" />
		<ai:col title="申请人" fieldname="EXT1" width="10%" />
		<ai:col title="申请部门" fieldname="ORGANIZE_NAME" width="20%" />
        <ai:col title="工单状态" fieldname="IS_SUBMIT" width="10%" />
        <ai:col title="执行开始时间" fieldname="PROVIDE_BEGIN_DATE" width="18%" />
        <ai:col title="执行结束时间" fieldname="PROVIDE_END_DATE" width="18%" />
		
	</ai:table>
<ai:table tableid="taskAllList" setname="com.asiainfo.task.bo.SETCurTask" height="200" multiselect="false" oncellchange="showcell" editable="false" oncontextmenu="" needrefresh="true" onrowchange="" pagesize="100"
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
<div class="area_button">
    <ai:button id="bt_saveSaleMain" text="查看详细" onclick="doShowDetailInfo()"/>
</div>

</body>
</html>
<ai:loginuser/>
<script language="javascript" src="<%=request.getContextPath()%>/jsv2/DBListBox.js"></script>
<script language="javascript" src="<%=request.getContextPath()%>/sale/common/js/openSelect.js"></script>
<script type="text/javascript">
var queryForm = g_FormRowSetManager.get("queryForm");
var queryList = g_TableRowSetManager.get("queryList");
var taskAllListTable = g_TableRowSetManager.get("taskAllList");


function initOper()
{
    queryForm.setValue("PRINCIPAL",g_GetUserInfo().STAFF_ID,g_GetUserInfo().STAFF_NAME);
    queryForm.setValue("CREATE_TIME",getPre1MonTime());
    queryForm.setValue("DONE_TIME",getCurrentTime());
    
}


function doQuery()
{
    
    if (1 == g_CompareDate(queryForm.getValue("PROVIDE_BEGIN_DATE"),queryForm.getValue("PROVIDE_END_DATE")))
    {
        return alert("结束时间不能小于开始时间！");
    }
    var applyId = g_StringTrim(queryForm.getValue("ID"));
	var applyName = queryForm.getValue("APPLY_NAME");
	var principal = queryForm.getValue("PRINCIPAL");
	var regionCode = queryForm.getValue("AREA_CODE");
	var beginTime = queryForm.getValue("CREATE_TIME");
	var endTime = queryForm.getValue("DONE_TIME");
    var isSubmit = queryForm.getValue("IS_SUBMIT");
	
  	var regionCode = queryForm.getValue("AREA_CODE");
	//alert(regionCode);
	
	var condition = "&applyId="+applyId
					+ "&applyName=" + encodeURI(trim(applyName))
					+ "&principal=" + principal
					+ "&regionCode=" + regionCode
					+ "&beginTime=" + beginTime
					+ "&endTime=" + endTime
					+ "&isSubmit=" + isSubmit;
					
	queryList.refresh(condition);
    queryList.setFocus(0,0);
}

function trim(str)
{
    return str.replace(/(^\s*)|(\s*$)/g, '');
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
	day = day>9?day.toString():'0' + day;
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

function clsStaff(){
    queryForm.setValue("PRINCIPAL", "", "");
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
        queryForm.setValue("PRINCIPAL", operatorId, name); 
    }
} 

function doDel1() {
	var curRow = queryList.getRow();
	var saleState = queryList.getValue(curRow, "IS_SUBMIT");
	if (saleState != '1') {
		return alert("只能删除保存状态的工单！");
	}
	if (g_GetUserInfo().STAFF_NAME == queryList.getValue(curRow, "STAFF_NAME")){
		if(confirm("您确定要删除！")){
			
			var curRow = queryList.getRow();
			var applyId = queryList.getValue(curRow, "ID");
			
		    var strUrl = _gModuleName + '/business/com.asiainfo.sale.prestore.web.SaleBatchPrestoreAction?action=delSaleBatchPrestore&applyId='+applyId;
		    var recode = PostInfo(strUrl);
		
		    var message = recode.getValueByName("MESSAGE");
		    var rFlag = recode.getValueByName("FLAG");
		    if ("Y" == rFlag)
		    {
		    	alert(message);
		    	doQuery();
		    	return;
		    } else {
		        alert(message);
		        doQuery();
		        return;
		    }
		} else {
			return;
		}
	} else {
		alert("只能删除自己的工单！");
	}
}

function doDel(){
	var selectedRows = queryList.getSelectedRows(); 
	var RowCount = selectedRows.length;
	if(!confirm("您确定要删除选中的记录吗？")){
		return false;
	}
	
	if(RowCount < 1){
		alert("请选择要删除的记录！");
		return;
	}
	while (RowCount > 0) {
		RowCount--;
		var so_nbr = queryList.getValue(selectedRows[RowCount], "ID")
		if (g_GetUserInfo().STAFF_NAME == queryList.getValue(selectedRows[RowCount], "EXT1")){
			var saleState = queryList.getValue(selectedRows[RowCount], "IS_SUBMIT");
			if (saleState != '1') {
				alert("工单号："+so_nbr+"，不是已保存状态，不允许删除，请重新选择！");
				return;
				//if(RowCount > 0){
				//	continue;
				//}else{return;}	
			}else{
			queryList.deleteRow(selectedRows[RowCount]);
			}
		}else {
			alert("工单号："+so_nbr+"，不是自己的，不允许删除！");
			return;
		}
	}
	var list = new Array();
	list.push(queryList);
	var ud = saveRowSet("<%=request.getContextPath()%>/business/com.asiainfo.sale.prestore.web.SaleBatchPrestoreAction?action=deletePrestoreInfo",list);
	if(ud.getValueByName("retVal") == "Y"){
		alert(ud.getValueByName("retMsg"));
		doQuery();
	}else{
		alert(ud.getValueByName("retMsg"));
		return;
	}		
}

function doShowDetailInfo(){
	var curRow = queryList.getRow();
	var applyId = queryList.getValue(curRow,"ID");
	var isSubmit = queryList.getValue(curRow,"IS_SUBMIT");
	//isSubmit=1 已保存状态

	window.open("<%=request.getContextPath()%>/sale/prestore/prestoreAddInfo.jsp?applyId="+applyId+"&isSubmit="+isSubmit,"","height=490,width=860,top=0,left=0,toolbar=no,menubar=no,scrollbars=yes,resizable=yes,location=no,status=no");
	
}

//回撤工单
function doCancelWF(){
var objectType = "prestoreCase";
var curRow = queryList.getRow();
var mid = queryList.getValue(curRow, "ID");
var staffid = queryList.getValue(curRow, "PRINCIPAL");
var isSubmit = queryList.getValue(curRow, "IS_SUBMIT");

if(g_GetUserInfo().STAFF_ID != staffid){
	return  alert("不能回撤别人的单子");
}else{
	if("2"==isSubmit){
		var strMainUrl=_gModuleName + '/business/com.asiainfo.task.web.CurTaskAction?action=terminateWorkflow&object_id='+mid+'&staffId='+g_GetUserInfo().STAFF_ID+'&object_type='+objectType;
		var recode= PostInfo(strMainUrl);
		alert(recode.getValueByName("MESSAGE"));
		doQuery();
	}else{
		return alert("当前状态不能回撤!");
		 }
	}
} 


function onRowChangeT(oldIndex,newIndex){
    if(-1 != oldIndex) {
    	queryList.setRowBgColor(oldIndex,"");
    }
    queryList.setRowBgColor(newIndex,"yellow");
    beginAIWaitBanner(showSenderInfo,"正在处理，请稍后...");
}

function changeColor2(oldIndex,newIndex){
    if(-1 != oldIndex) {
    	g_TableRowSetManager.get("queryList").setRowBgColor(oldIndex,"");
    }
    	g_TableRowSetManager.get("queryList").setRowBgColor(newIndex,"yellow");
}

function showSenderInfo(){
	
	var selectedRows = queryList.getSelectedRows();
	if (selectedRows.length != 0) {
		for (var i=0; i<selectedRows.length; ++i){
    		queryList.rowSelected(selectedRows[i],false);
    	}
    }
	var curRowIndex = queryList.getCurRowIndex();
	queryList.rowSelected(curRowIndex,true);
	var apply_id = queryList.getValue(curRowIndex, "ID");
	var state = queryList.getValue(curRowIndex, "IS_SUBMIT");
	taskAllListTable.clear();
	if(state != "1"){
	    taskAllListTable.refresh("recordId="+apply_id+"&state="+state);
	}
}

function showcell(){
	 var curRow = taskAllListTable.getRow();
	 var curCol = taskAllListTable.getCol();
	 var taskStaffId=taskAllListTable.getValue(curRow,"TASK_STAFF_ID");
	 if(taskStaffId==""){
		 taskStaffId=taskAllListTable.getValue(curRow,"CREATE_STAFF_ID");
	 }
	 if(curCol==6||curCol==4||curCol==3){
	   var msg = taskAllListTable.getValue(curRow,"DESCRIPTION");
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
<script language="javascript" src="<%=request.getContextPath()%>/jsv2/AIWaitBanner.js"></script>
<script type="text/javascript">
function doWork(fun){ 
    beginAIWaitBanner(fun,"正在处理，请稍后...");
}
</script>