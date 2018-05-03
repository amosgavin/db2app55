<%@ page contentType="text/html; charset=GBK"%>
<%@ include file="/secframe/common/common.jsp"%>
<%@ include file="/webframe/common/commonhead.jsp"%>
<html>
<head>
<title>资费档次</title>
<script language="javascript" src="<%=request.getContextPath()%>/jsv2/Calendar.jsp" type="text/javascript"></script>
<script language="javascript" src="<%=request.getContextPath()%>/sale/common/js/openSelect.js" type="text/javascript"></script>	
</head>
  
  <body onload="init()">
    <ai:contractframe id="chargeMainDeframe" contenttype="table" title="资费案主要信息" width="100%" allowcontract="true" frameclosed="fale">
    <ai:contractitem/>
    <ai:dbform formid="chargeMainframe" 
            setname="com.asiainfo.charge.web.SETChargeApplyMain"
            conditionname="condition" parametersname="parameters"
            onvalchange="" editable="true" initial="false"
            datamodel="com.ai.appframe2.web.datamodel.MethodModelForService"
          	 implservice_name="com.asiainfo.charge.service.interfaces.IChargeMainSV"
            implservice_querymethod="IChargeMainshow(String id)"
           >
        <table width="100%" align="center" border="0" cellpadding="1" cellspacing="2">
        	<tr>
		         <td class="td_font">工单号：</td>
		         <td><ai:dbformfield formid="chargeMainframe" fieldname="APPLY_ID" width="150" editable=""/>
		         </td>
		      	 <td class="td_font">名称：</td>
		         <td><ai:dbformfield formid="chargeMainframe" fieldname="APPLY_NAME" width="150" editable=""/>
		         </td>
		         <td class="td_font">申请人：</td>
		         <td><ai:dbformfield formid="chargeMainframe" fieldname="PRINCIPLE" width="150" editable="false"/><img id="selectStaff" border="0" src="<%=request.getContextPath()%>/webframe/images/query.gif" onClick="selectStaff();" align="absmiddle" style="cursor:hand;"/>
		         </td>
		         <td class="td_font">地市：</td>
		         <td><ai:dbformfield formid="chargeMainframe" fieldname="TOWNNAME" width="150" editable=""/></td>
            </tr>
            <tr>
	        </tr>
	        <tr>
		         <td class="td_font">开始时间大于：</td>
		         <td><ai:dbformfield formid="chargeMainframe" fieldname="APPLY_TIME" width="150" editable=""/>
		         </td>
		         <td class="td_font">开始时间小于：</td>
		         <td><ai:dbformfield formid="chargeMainframe" fieldname="APPLY_END_TIME" width="150" editable=""/></td>
		         <td class="td_font">工单状态：</td>
		         <td colspan="2"><ai:dbformfield formid="chargeMainframe" fieldname="IS_SUBMIT" width="150" editable=""/>
		         	<ai:button id="queryWeapon" text="查询" onclick="queryChargeMain()"/>
		         	<ai:button id="queryClear" text="清空" onclick="clearPrinciple()"/></td>
        	</tr>
		</table>
	</ai:dbform>
</ai:contractframe>

  <ai:contractframe id="chargeListTable" contenttype="table" title="资费案主要信息" width="100%" allowcontract="true" frameclosed="fale">
    <ai:contractitem>
    <ai:button id="bt_delcharge" text="删除工单"  onclick="delChargeMain()"/>
    <ai:button id="bt_backChargeMain" text="撤销工单(未被审核)"  onclick="backChargeMain()"/>
    </ai:contractitem>
<ai:table
        tableid="chargeListTable"
        setname="com.asiainfo.charge.web.SETChargeMain"
        tablemodel="com.ai.appframe2.web.datamodel.MethodModelForService"
        implservice_name="com.asiainfo.charge.service.interfaces.IChargeNewMainSV"
        implservice_querymethod="IChargeNewMainByMessage(String id,String applyTime,String applyEndTime,String principle
	        ,String isSubmit,String townname,String appname, int $STARTROWINDEX, int $ENDROWINDEX)"
        implservice_countmethod="IChargeNewMainByMessageCount(String id,String applyTime,String applyEndTime,String principle
	        ,String isSubmit,String townname,String appname)"
        initial="false"   ondbclick="showMainInfo" onrowchange="onrowchange1" 
        pagesize="9" editable="" width="100%"
        height="180" needrefresh="true">
        	<ai:col title="工单号" fieldname="MAIN_ID" width="10%" visible=""/>
        	<ai:col title="名称" fieldname="REAMRK_1" width="20%" />
            <ai:col title="申请人" fieldname="REAMRK_2" width="20%" visible=""/>
            <ai:col title="申请人" fieldname="PRINCIPLE" width="20%" visible="false"/>
            <ai:col title="部门" fieldname="ORG" width="20%" visible="false"/>
            <ai:col title="部门" fieldname="REAMRK_3" width="20%" visible=""/>
            <ai:col title="工单状态" fieldname="STATE" width="10%" />
            <ai:col title="工单创建时间" fieldname="CREATE_TIME" width="20%" />
    </ai:table>
    </ai:contractframe>
    <div id="copy" class="area_button" > <ai:button  text="复制选择资费案" onclick="copyChargeMain()"/></div>
    
<ai:contractframe id="workflowInfoframe" contenttype="table" title="流程信息" width="100%" allowcontract="true" frameclosed="false">
<ai:contractitem/>
<ai:table tableid="taskAllList" setname="com.asiainfo.task.bo.SETCurTask" height="200" multiselect="false" oncellchange="showcell" editable="false" oncontextmenu="" needrefresh="true"  pagesize="100"
width="100%" onrowchange="changeColor2" tablemodel="com.ai.appframe2.web.datamodel.MethodModelForService"
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
 <ai:col fieldname="ERROR_MESSAGE" width="200" visible="false"/>
 <ai:col fieldname="FINISH_STAFF_ID" width="150" visible="false"/>
 <ai:col fieldname="STATE" width="150" visible="false"/>
  <ai:col fieldname="CREATE_STAFF_ID" width="150" visible="false"/>
</ai:table>
</ai:contractframe>
  </body>
</html>
<ai:loginuser/>
<script language="javascript" src="<%=request.getContextPath()%>/sale/common/js/ModaDialog.js" type="text/javascript"></script>
<script type="text/javascript">
var _fromChargeMainFormRowSet= g_FormRowSetManager.get("chargeMainframe");
var chargeListTable=g_TableRowSetManager.get("chargeListTable");
var iscopy="<%=request.getParameter("iscopy")%>";
function init(){
 if(iscopy=="yes"){
 document.getElementById("copy").style.display="block";
 }else{
 document.getElementById("copy").style.display="none";
 }
 _fromChargeMainFormRowSet.refreshListBox("FEE_TYPE","codeType=feetypes",true);
 _fromChargeMainFormRowSet.setValue("PRINCIPLE",g_GetUserInfo().STAFF_ID,g_GetUserInfo().STAFF_NAME);
 _fromChargeMainFormRowSet.setValue("APPLY_TIME",getPre1MonTime());
  _fromChargeMainFormRowSet.setValue("APPLY_END_TIME",getCurrentTime());
 _fromChargeMainFormRowSet.setValue("");
 }

function queryChargeMain(){
	var applyid=_fromChargeMainFormRowSet.getValue("APPLY_ID");
	var feetype=_fromChargeMainFormRowSet.getValue("FEE_TYPE");
	var applyTime=_fromChargeMainFormRowSet.getValue("APPLY_TIME");
	var applyEndTime=_fromChargeMainFormRowSet.getValue("APPLY_END_TIME");
	var principle=_fromChargeMainFormRowSet.getValue("PRINCIPLE");
	var isSubmit=_fromChargeMainFormRowSet.getValue("IS_SUBMIT");
	//新增地市，资费名称查询
	var townname=_fromChargeMainFormRowSet.getValue("TOWNNAME");
	var appname=_fromChargeMainFormRowSet.getValue("APPLY_NAME");
	if("0"==townname){
	townname="";
	}
	if("0"==isSubmit){
	isSubmit="";
	}
	if("00"==feetype){
	feetype="";
	}
	chargeListTable.refresh("&id="+applyid+"&applyTime="+applyTime+"&applyEndTime="+applyEndTime
	+"&principle="+principle+"&isSubmit="+isSubmit+"&townname="+townname+"&appname="+encodeURI(trim(appname)));
	
}

 function trim(str)
{
     return str.replace(/(^\s*)|(\s*$)/g, '');
}

function showMainInfo(){
	var curRow = chargeListTable.getRow();
	var applyid = chargeListTable.getValue(curRow,"MAIN_ID");
	var isSubmit = chargeListTable.getValue(curRow,"STATE");
	var applicantOrgId = chargeListTable.getValue(curRow,"ORG");
	var openUrl = "";
	if (applyid > 22718) {
		if(isSubmit!="1" || chargeListTable.getValue(curRow, "REAMRK_2") != g_GetUserInfo().STAFF_NAME){
			openUrl = "<%=request.getContextPath()%>/charge/chargeinfo/chargeAudit.jsp?recordId="+applyid+"&taskTag=&orderState="+isSubmit+"&applicantOrgId="+applicantOrgId;
		} else {
			openUrl = "<%=request.getContextPath()%>/charge/chargeinfo/chargeAddInfo.jsp?applyid="+applyid+"&editable=true";
		}
	} else {
		if(isSubmit!="1"){
			openUrl = "<%=request.getContextPath()%>/charge/chargeinfo/chargeApprove.jsp?applyid="+applyid+"&stype=y";
		} else {
			var editable=false;
	    	if (chargeListTable.getValue(curRow, "REAMRK_2") == g_GetUserInfo().STAFF_NAME) {
	    		editable=true;
	    	}
			openUrl = "<%=request.getContextPath()%>/charge/chargeinfo/chargeAddInfo.jsp?applyid="+applyid+"&editable="+editable;
		}
	}
	window.open(openUrl,"","height=490,width=860,top=0,left=0,toolbar=no,menubar=no,scrollbars=yes,resizable=yes,location=no,status=no");
}

function selectStaff()
    {
        //var url = "<%=request.getContextPath()%>/sale/common/modaldialog/StaffSelect_ss.jsp?org_id=10";
       //var result = window.showModalDialog(url, null, "scroll:yes;resizable:no;help:no;status:no;dialogHeight:490px;dialogWidth:560px");
        var result=openSelect.staffSelect("tsd",'10');
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
            _fromChargeMainFormRowSet.setValue("PRINCIPLE", operatorId, name); 
        }
    } 
    
function clearPrinciple(){
	_fromChargeMainFormRowSet.setValue("PRINCIPLE", ""); 
	_fromChargeMainFormRowSet.setValue("APPLY_ID","");
	_fromChargeMainFormRowSet.setValue("FEE_TYPE","");
	_fromChargeMainFormRowSet.setValue("APPLY_TIME","");
	_fromChargeMainFormRowSet.setValue("APPLY_END_TIME","");
	_fromChargeMainFormRowSet.setValue("IS_SUBMIT","");
}
function copyChargeMain(){
	var staffid = g_GetUserInfo().STAFF_ID;
	var org=g_GetUserInfo().ORG_ID;
	var curRow = chargeListTable.getRow();
	var chargeid = chargeListTable.getValue(curRow,"APPLY_ID");
	if(chargeid==""){
	 	return alert("请选择一行数据！");
	}
	var strUrl = _gModuleName + '/business/com.asiainfo.charge.web.ChargeMainAction?action=copyChargeMain&applyid='+chargeid+"&staffid="+staffid+"&org="+org;
	var recode = PostInfo(strUrl, null);
	var aid=recode.getValueByName("APPLYID");
	window.returnValue = aid;
	window.self.close();
}
 
function delChargeMain(){
    var ss = new Array();
    ss = chargeListTable.getSelectedRows();
    var isSubmit=chargeListTable.getValue(g_TableRowSetManager.get("chargeListTable").getRow(), "STATE");
    var delid=chargeListTable.getValue(g_TableRowSetManager.get("chargeListTable").getRow(), "MAIN_ID");
    var staffid=chargeListTable.getValue(g_TableRowSetManager.get("chargeListTable").getRow(), "PRINCIPLE");
 
    if (ss.length < 1) {
	     alert("请选择要删除的数据！");
	     return;
	}
	if(isSubmit=="1"&&g_GetUserInfo().STAFF_ID==staffid){
		if(!confirm("您确定要删除！")){
			return;
		}
	    for ( var i = ss.length; i > 0; i--) {
	        chargeListTable.deleteRow(ss[i - 1]);
	    }
	    var strUrl = _gModuleName + '/business/com.asiainfo.charge.web.ChargeMainAction?action=saveChargeNewMain&applyid='+delid;
	    var recode = PostInfo(strUrl, null);
	    alert("操作成功！");
	 } else if(isSubmit=="1"&&g_GetUserInfo().STAFF_ID!=staffid){
	 	return  alert("不能删除别人做的单子！");
	 } else {
	  	return  alert("当前状态不能删除！");
	 }
}
 
function backChargeMain(){
	var crows= g_TableRowSetManager.get("chargeListTable").getRow();
	var mid=chargeListTable.getValue(crows, "MAIN_ID");
	var staffid=chargeListTable.getValue(crows, "PRINCIPLE");
	var isSubmit=chargeListTable.getValue(crows, "STATE");
	var objectType = "";
	//var org=chargeListTable.getValue(crows, "ORGANIZE_NAME");
	if("10"==g_GetUserInfo().ORG_ID.substring(0,2)){
	  	objectType="newChargeCaseP";
	}else {
	  	objectType="newChargeCaseT";
	}
	if (mid  > 22718) objectType="UniteChargeFlow";
	if(g_GetUserInfo().STAFF_ID!=staffid){
	 	return  alert("不能回撤别人的单子");
	}else{
		 if("2"==isSubmit){
		 	var strMainUrl=_gModuleName + '/business/com.asiainfo.task.web.CurTaskAction?action=terminateWorkflow&object_id='+mid+'&staffId='+g_GetUserInfo().STAFF_ID+'&object_type='+objectType;
			var recode= PostInfo(strMainUrl);
			alert(recode.getValueByName("MESSAGE"));
			queryChargeMain();
		 } else {
		 	return alert("当前状态不能回撤!");
		 }
	 }
} 
 
function onrowchange1(oldIndex,newIndex){
    if(-1 != oldIndex) {
    	chargeListTable.setRowBgColor(oldIndex,"");
    }
    	chargeListTable.setRowBgColor(newIndex,"yellow");
    	beginAIWaitBanner(showSenderInfo,"正在处理，请稍后...");
}

function changeColor2(oldIndex,newIndex){
    if(-1 != oldIndex) {
    	g_TableRowSetManager.get("taskAllList").setRowBgColor(oldIndex,"");
    }
    	g_TableRowSetManager.get("taskAllList").setRowBgColor(newIndex,"yellow");
}

<!--function showcell(){-->
<!--	 var curRow = g_TableRowSetManager.get("taskAllList").getRow();-->
<!--	 var curCol = g_TableRowSetManager.get("taskAllList").getCol();-->
<!--	 if(curCol==6){-->
<!--	   var msg = g_TableRowSetManager.get("taskAllList").getValue(curRow,"DESCRIPTION");-->
<!--       var obj= new Object();-->
<!--	   if(msg!=""){-->
<!--        //window.alert(msg);-->
<!--        //document.write(msg);-->
<!--   		 var url="<%=request.getContextPath()%>/main3/include/showmsg.jsp";-->
<!--        obj.name = msg;-->
<!--        window.showModalDialog(url, obj, "scroll:yes;resizable:yes;help:no;status:yes;dialogHeight:200px;dialogWidth:400px;unadorned:yes");-->
<!--        //window.open(url, obj, "scroll:yes;resizable:yes;help:no;status:no;dialogHeight:200px;dialogWidth:400px");-->
<!--	   }-->
<!--	 }-->
<!--}-->

function showcell(){
	 var curRow = g_TableRowSetManager.get("taskAllList").getRow();
	 var curCol = g_TableRowSetManager.get("taskAllList").getCol();
	 var taskStaffId=g_TableRowSetManager.get("taskAllList").getValue(curRow,"TASK_STAFF_ID");
	 if(taskStaffId==""){
		 taskStaffId=g_TableRowSetManager.get("taskAllList").getValue(curRow,"CREATE_STAFF_ID");
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


function showSenderInfo(){
	
	var selectedRows = chargeListTable.getSelectedRows();
	if (selectedRows.length != 0) {
		for (var i=0; i<selectedRows.length; ++i){
    		chargeListTable.rowSelected(selectedRows[i],false);
    	}
    }
	var curRowIndex = chargeListTable.getCurRowIndex();
	chargeListTable.rowSelected(curRowIndex,true);
	var apply_id = chargeListTable.getValue(curRowIndex, "MAIN_ID");
	g_TableRowSetManager.get("taskAllList").clear();
	var state = chargeListTable.getValue(curRowIndex, "STATE");
	if (state == '1') return;
	g_TableRowSetManager.get("taskAllList").refresh("recordId="+apply_id+"&state="+state);
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
 
</script>
<script language="javascript" src="<%=request.getContextPath()%>/jsv2/AIWaitBanner.js"></script>
<script type="text/javascript">
function doWork(fun){ 
    beginAIWaitBanner(fun,"正在处理，请稍后...");
}
</script>
