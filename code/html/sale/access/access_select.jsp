<%@ page contentType="text/html; charset=GBK"%>
<%@ include file="/secframe/common/common.jsp"%>
<%@ include file="/webframe/common/commonhead.jsp"%>

<html>
<head>
<title>业务变更申请查询</title>
<script language="javascript" src="<%=request.getContextPath()%>/jsv2/Calendar.jsp" type="text/javascript"></script>
</head>
  
  <body onload="">
<ai:contractframe id="accessFrame" contenttype="table" title="在办任务查询" width="100%" allowcontract="true" frameclosed="fale">
	<ai:contractitem/>
	<ai:dbform formid="accessF" 
			setname="com.asiainfo.task.bo.SETWebTaskQuery"
			conditionname="condition" parametersname="parameters"
			onvalchange="" editable="true" initial="false"
			datamodel="com.ai.appframe2.web.datamodel.MethodModelForService"
			implservice_name=""
			implservice_querymethod="">
		<table width="98%" align="center" border="0" cellpadding="1" cellspacing="2">
			<tr>
	           	<td class="td_font">开始时间：</td>
	           	<td><ai:dbformfield formid="accessF" fieldname="CREATE_DATE" width="150"/></td>
	           	<td class="td_font">结束时间：</td>
	           	<td><ai:dbformfield formid="accessF" fieldname="FINISH_DATE" width="150"/></td>
	           	<td class="td_font">申请地市：</td>
	           	<td><ai:dbformfield formid="accessF" fieldname="CORPORATION" width="150"/></td>
	        </tr>
	        <tr>   	
	           	<td class="td_font">申请人：</td>
                <td><ai:dbformfield formid="accessF" fieldname="CREATE_STAFF_NAME" width="150" editable="false"/><img id="selectStaff" border="0" src="<%=request.getContextPath()%>/webframe/images/query.gif" onClick="selectStaff();" align="absmiddle" style="cursor:hand;"/></td>
	           	<td class="td_font">工单名称：</td>
	           	<td><ai:dbformfield formid="accessF" fieldname="APPLY_NAME" width="150"/></td>
	           	<td class="td_font">工单编号：</td>
	           	<td><ai:dbformfield formid="accessF" fieldname="WORKFLOW_OBJECT_ID" width="150"/>
			    <ai:button id="newSaleMain" text="查询"  onclick="query()"/></td>
			</tr>
		</table>
	</ai:dbform>
</ai:contractframe>

<ai:contractframe id="accessChangeframe" contenttype="table" title="详细信息" width="100%" allowcontract="true" frameclosed="fale">
    <ai:contractitem><%--
    <ai:button id="bt_delcharge" text="删除业务变更申请"  onclick="delAccessChange()"/>
    --%><ai:button id="bt_backChargeMain" text="回撤业务变更申请"  onclick="backAccessChange()"/>
    </ai:contractitem>
<ai:table tableid="accessChangeTable" setname="com.asiainfo.sale.access.web.SETAccessChange" height="200" multiselect="true" oncellchange="" 
oncontextmenu="" needrefresh="true" onrowchange="onrowchange1" pagesize="30" ondbclick="selectAccessInfo"
width="100%" tablemodel="com.ai.appframe2.web.datamodel.MethodModelForService"
implservice_name="com.asiainfo.sale.access.service.interfaces.IAccessChangeSV"  
implservice_querymethod="queryAccessChangeValue(String beginTime,String endTime,String applyname,String objectid,String principle,String town,int $STARTROWINDEX, int $ENDROWINDEX)" 
implservice_countmethod="queryAccessChangeCount(String beginTime,String endTime,String applyname,String objectid, String principle,String town)" 
initial="false" editable="false" width="100%" >
        	<ai:col fieldname="ACCESS_ID" width="100" visible="true"/>
            <ai:col fieldname="APPLY_NAME" width="150" visible="true"/>
        	<ai:col fieldname="CREATE_TIME" width="120" visible="true"/>
            <ai:col fieldname="B_TIME" width="100" visible="true"/>
            <ai:col fieldname="E_TIME" width="100" visible="true"/>
            <ai:col fieldname="O_OBJECT" width="100" visible="true"/>
            <ai:col fieldname="O_TYPE" width="100" visible="true"/>
            <ai:col fieldname="SCALE" width="100" visible="true"/>  
            <ai:col fieldname="OLD_BAND" width="120" visible="true"/>  
            <ai:col fieldname="NEW_BAND" width="120" visible="true"/>  
            <ai:col fieldname="STATE" width="100" visible="true"/>
            <ai:col fieldname="REMARK" width="150" visible="true"/> 
            <ai:col fieldname="PRINCIPLE" width="150" visible="false"/>            
</ai:table>
<ai:table tableid="taskAllList" setname="com.asiainfo.task.bo.SETCurTask" height="200" multiselect="false" oncellchange="showcell" editable="false" oncontextmenu="" needrefresh="true" onrowchange="" pagesize="100"
width="100%" onrowchange='changeColor2' tablemodel="com.ai.appframe2.web.datamodel.MethodModelForService"
implservice_name="com.asiainfo.task.service.interfaces.ICurTaskSV"  
implservice_querymethod="getTaskByWorkFlowIdForQ(String workflowId,int $STARTROWINDEX, int $ENDROWINDEX)" 
implservice_countmethod="getTaskByWorkFlowIdForQCnt(String workflowId)"
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
<ai:loginuser/>
<div id="include" style="display:none">
<%@include file="/sale/common/include/_createWF.jsp"%>
</div>
</body>
</html>
<script language="javascript" src="<%=request.getContextPath()%>/sale/common/js/ModaDialog.js" type="text/javascript"></script>
<script language="javascript" type="text/javascript" src="<%=request.getContextPath()%>/jsv2/AIWaitBanner.js"></script>
<script language="javascript" src="<%=request.getContextPath()%>/sale/common/js/openSelect.js" type="text/javascript"></script>
<script language="javascript" type="text/javascript">
function doWork(fun){ 
    beginAIWaitBanner(fun,"正在处理，请稍后...");
}
</script>
<script language="javascript" type="text/javascript">
var _flowType = "accessCaseT";
var _accessFRowSet = g_FormRowSetManager.get("accessF");
var accessChangeTable= g_TableRowSetManager.get("accessChangeTable");
var taskAllListTable= g_TableRowSetManager.get("taskAllList");
_accessFRowSet.setValue("CREATE_DATE",getPre1MonTime());
_accessFRowSet.setValue("FINISH_DATE",getCurrentTime());

_accessFRowSet.setValue("CREATE_STAFF_NAME",g_GetUserInfo().STAFF_ID,g_GetUserInfo().STAFF_NAME);

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

  
function onrowchange1(oldIndex,newIndex){
    if(-1 != oldIndex) {
    	accessChangeTable.setRowBgColor(oldIndex,"");
    }
    accessChangeTable.setRowBgColor(newIndex,"yellow");
    beginAIWaitBanner(showSenderInfo,"正在处理，请稍后...");
}
  
function showSenderInfo(){
	var selectedRows = accessChangeTable.getSelectedRows();
	if (selectedRows.length != 0) {
		for (var i=0; i<selectedRows.length; ++i){
    		accessChangeTable.rowSelected(selectedRows[i],false);
    	}
    }
	var curRowIndex = accessChangeTable.getCurRowIndex();
	accessChangeTable.rowSelected(curRowIndex,true);
	var apply_id = accessChangeTable.getValue(curRowIndex, "ACCESS_ID");
	var state = accessChangeTable.getValue(curRowIndex, "STATE");
	if(state !="1"){
	     var url=_gModuleName + '/business/com.asiainfo.task.web.CurTaskAction?action=getWorkflowId&apply_id='+apply_id+'&state='+state;
	     var recode= PostInfo(url);
	     var workflowId= recode.getValueByName("workflowId");
	     taskAllListTable.refresh("&workflowId="+workflowId);
	     return;
	}else{ taskAllListTable.refresh("&workflowId="+" "); return ;}
}

function changeColor2(oldIndex,newIndex){
	showcell();
    if(-1 != oldIndex) {
    	g_TableRowSetManager.get("taskAllList").setRowBgColor(oldIndex,"");
    }
    	g_TableRowSetManager.get("taskAllList").setRowBgColor(newIndex,"yellow");
}

 function query(){
    var beginTime = _accessFRowSet.getValue("CREATE_DATE");
    var endTime = _accessFRowSet.getValue("FINISH_DATE");
    var applyname= _accessFRowSet.getValue("APPLY_NAME");
    var objectid = _accessFRowSet.getValue("WORKFLOW_OBJECT_ID");
    var staff_id = _accessFRowSet.getValue("CREATE_STAFF_NAME");
    var town = _accessFRowSet.getValue("CORPORATION");
	 var param = "beginTime="+ beginTime
	           +"&endTime="+ endTime
	           +"&applyname="+ encodeURI(applyname)
	           +"&objectid=" + objectid
	           +"&principle=" + staff_id
	           +"&town=" + town;
    accessChangeTable.refresh(param);
    var i =0;
    var scale="";
   	while(i<accessChangeTable.getTotalRowCount()){
   		scale=accessChangeTable.getValue(i,"SCALE");
   		if(scale!=""){
   			var v = new Array();
   			v=scale.split(";");
   			var j =0;
   			var str="";
   			for(j=0;j<v.length;j++){
   				if(v[j]=="1"){
   					str=str+"指定渠道;"
   				}
   				if(v[j]=="2"){
   					str=str+"自办厅;"
   				}
   				if(v[j]=="3"){
   					str=str+"代理商;"
   				}
            }
   		   accessChangeTable.setValue(i,"SCALE",str);
   		}
   		
   		oldBand=accessChangeTable.getValue(i,"OLD_BAND");
   		if(oldBand!=""){
   			var v = new Array();
   			v=oldBand.split(";");
   			var j =0;
   			var str="";
   			for(j=0;j<v.length;j++){
   				if(v[j]=="qqt"){
   					str=str+"全球通;"
   				}
   				if(v[j]=="szx"){
   					str=str+"神州行;"
   				}
   				if(v[j]=="dgdd"){
   					str=str+"动感地带;"
   				}
            }
   		   accessChangeTable.setValue(i,"OLD_BAND",str);
   		}
   		
   		newBand=accessChangeTable.getValue(i,"NEW_BAND");
   		if(newBand!=""){
   			var v = new Array();
   			v=newBand.split(";");
   			var j =0;
   			var str="";
   			for(j=0;j<v.length;j++){
   				if(v[j]=="qqt"){
   					str=str+"全球通;"
   				}
   				if(v[j]=="szx"){
   					str=str+"神州行;"
   				}
   				if(v[j]=="dgdd"){
   					str=str+"动感地带;"
   				}
            }
   		   accessChangeTable.setValue(i,"NEW_BAND",str);
   		}

      i++;
    }
    accessChangeTable.setFocus(0,0);
    accessChangeTable.setFocusByName(0,"name"); 
  }
 
function delAccessChange(){
	var vr = new Array();
	vr = accessChangeTable.getSelectedRows();
    if (vr.length < 1) {
	     alert("请选择要删除的数据！");
	        return;
	 }
    for(var i=0;i<vr.length;i++){
    	if(accessChangeTable.getValue(vr[i],"STATE")!="1"){
    		alert("不能删除已经提交的工单！");
    		return;
    	}
    }
    
    for(var i=0;i<vr.length;i++){
    	var accessid = accessChangeTable.getValue(vr[i],"ACCESS_ID");
    	var strUrl = _gModuleName + '/business/com.asiainfo.sale.access.web.AccessChangeAction?action=delAccessChangeInfo&accessid='+accessid;
	    var recode = PostInfo(strUrl,null);
    }
    query();
}

function backAccessChange(){
	var vr = new Array();
	vr = accessChangeTable.getSelectedRows();
    if (vr.length < 1) {
	     alert("请选择要回退的数据！");
	        return;
	 }
    for(var i=0;i<vr.length;i++){
    	if(accessChangeTable.getValue(vr[i],"STATE")=="1"){
    		alert("不能回退未提交的工单！");
    		return;
    	}
    	if(accessChangeTable.getValue(vr[i],"PRINCIPLE")!=g_GetUserInfo().STAFF_ID){
    		alert("不能回退他人的工单！");
    		return;
    	}
    }
    for(var i=0;i<vr.length;i++){
    	var accessid = accessChangeTable.getValue(vr[i],"ACCESS_ID");
		var strUrl=_gModuleName + '/business/com.asiainfo.task.web.CurTaskAction?action=terminateWorkflow&object_id='+accessid+'&staffId='+g_GetUserInfo().STAFF_ID+'&object_type='+_flowType;
		var recode = PostInfo(strUrl,null);
    }
    taskAllListTable.refresh("&workflowId="+"0");
    query();
} 

function selectAccessInfo(){
	var curRowIndex = 0;
	var selectedRows = accessChangeTable.getSelectedRows();
	if (selectedRows.length == 0) {
		curRowIndex = gRowSet1.getCurRowIndex();
	} else if (selectedRows.length == 1){
		curRowIndex = selectedRows[0];
	} else {
		alert("请勾选唯一的工单查看");
		return;
	}
	var state =accessChangeTable.getValue(curRowIndex, "STATE");
	var accessid = accessChangeTable.getValue(curRowIndex, "ACCESS_ID");
	var staffid =accessChangeTable.getValue(curRowIndex, "PRINCIPLE");
	var url = "";
	if(state=="1"&&g_GetUserInfo().STAFF_ID==staffid){
	   url = "<%=request.getContextPath()%>/sale/access/access_apply.jsp?applyid="+accessid;
	   window.open(url, null, 'height=490,width=860,top=0,left=0,toolbar=no,menubar=no,scrollbars=yes,resizable=yes,location=no,status=no');
	}else{
		url = "<%=request.getContextPath()%>/sale/access/access_apply_show.jsp?applyid="+accessid;
		window.open(url, null, 'height=490,width=860,top=0,left=0,toolbar=no,menubar=no,scrollbars=yes,resizable=yes,location=no,status=no');
	}
	
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
            _accessFRowSet.setValue("CREATE_STAFF_NAME", operatorId, name); 
        }
    } 

</script>