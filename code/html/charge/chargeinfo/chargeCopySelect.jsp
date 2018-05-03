<%@ page contentType="text/html; charset=GBK"%>
<%@ include file="/secframe/common/common.jsp"%>
<%@ include file="/webframe/common/commonhead.jsp"%>
<html>
<head>
<title>�ʷѵ���</title>
<script language="javascript" src="<%=request.getContextPath()%>/jsv2/Calendar.jsp" type="text/javascript"></script>
<script language="javascript" src="<%=request.getContextPath()%>/sale/common/js/openSelect.js" type="text/javascript"></script>	
</head>
  
  <body onload="init()">
    <ai:contractframe id="chargeMainDeframe" contenttype="table" title="�ʷѰ���Ҫ��Ϣ" width="100%" allowcontract="true" frameclosed="fale">
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
           <td class="td_font">�����ˣ�</td>
         <td><ai:dbformfield formid="chargeMainframe" fieldname="PRINCIPLE" width="150" editable="false"/><img id="selectStaff" border="0" src="<%=request.getContextPath()%>/webframe/images/query.gif" onClick="selectStaff();" align="absmiddle" style="cursor:hand;"/>
         </td>
             <td class="td_font">���У�</td>
         <td><ai:dbformfield formid="chargeMainframe" fieldname="TOWNNAME" width="150" editable=""/></td>
        </tr>
          <tr>
         <td class="td_font">�ʷѻID��</td>
         <td><ai:dbformfield formid="chargeMainframe" fieldname="APPLY_ID" width="150" editable=""/>
         </td>
         <td class="td_font">�ʷ����ͣ�</td>
         <td><ai:dbformfield formid="chargeMainframe" fieldname="FEE_TYPE" width="150" editable=""/></td>
        </tr>
        <tr>
         <td class="td_font">��ʼʱ����ڣ�</td>
         <td><ai:dbformfield formid="chargeMainframe" fieldname="APPLY_TIME" width="150" editable=""/>
         </td>
         <td class="td_font">��ʼʱ��С�ڣ�</td>
         <td><ai:dbformfield formid="chargeMainframe" fieldname="APPLY_END_TIME" width="150" editable=""/></td>
        </tr>
        <tr>
      <td class="td_font">�ʷ����ƣ�</td>
         <td><ai:dbformfield formid="chargeMainframe" fieldname="APPLY_NAME" width="150" editable=""/>
         </td>
         <td class="td_font">����״̬��</td>
         <td><ai:dbformfield formid="chargeMainframe" fieldname="IS_SUBMIT" width="150" editable=""/>
         <ai:button id="queryWeapon" text="��ѯ" onclick="queryChargeMain()"/>
          <ai:button id="queryClear" text="���" onclick="clearPrinciple()"/></td>
        </tr>
</table>
</ai:dbform>
</ai:contractframe>

  <ai:contractframe id="chargeListTable" contenttype="table" title="�ʷѰ���Ҫ��Ϣ" width="100%" allowcontract="true" frameclosed="fale">
    <ai:contractitem>
    <ai:button id="bt_delcharge" text="ɾ���ʷѰ�"  onclick="delChargeMain()"/>
    <ai:button id="bt_backChargeMain" text="�س��ʷѰ�"  onclick="backChargeMain()"/>
    </ai:contractitem>
<ai:table
        tableid="chargeListTable"
        setname="com.asiainfo.charge.web.SETChargeApplyMainDe"
        tablemodel="com.ai.appframe2.web.datamodel.MethodModelForService"
        implservice_name="com.asiainfo.charge.service.interfaces.IChargeMainSV"
        implservice_querymethod="ChargeMainshow(String applyid,String feetype,String applyTime,String applyEndTime,String principle
        ,String isSubmit,String townname,String appname, int $STARTROWINDEX, int $ENDROWINDEX)"
        implservice_countmethod="ChargeMainshow(String applyid,String feetype,String applyTime,String applyEndTime,String principle
        ,String isSubmit,String townname,String appname)"
        initial="false"   ondbclick="showMainInfo" onrowchange="onrowchange1" 
        pagesize="9" editable="" width="100%"
        height="180" needrefresh="true">
        	<ai:col title="�ʷѻID" fieldname="APPLY_ID" width="8%" visible=""/>
        	 <ai:col title="����" fieldname="APPLY_NAME" width="12%" />
            <ai:col title="�ʷ�����" fieldname="FEE_TYPE" width="10%" />
            <ai:col title="������" fieldname="PRINCIPLE" width="" visible="false"/>
            <ai:col title="������" fieldname="STAFF_NAME" width="10%" visible=""/>
            <ai:col title="����" fieldname="ORGANIZE_NAME" width="10%" visible=""/>
            <ai:col title="����״̬" fieldname="IS_SUBMIT" width="10%" />
             <ai:col title="���ʼʱ��" fieldname="APPLY_TIME" width="20%" />
            <ai:col title="�����ʱ��" fieldname="APPLY_END_TIME" width="20%" />
    </ai:table>
    </ai:contractframe>
    <div id="copy" class="area_button" > <ai:button  text="����ѡ���ʷѰ�" onclick="copyChargeMain()"/></div>
    
<ai:contractframe id="workflowInfoframe" contenttype="table" title="������Ϣ" width="100%" allowcontract="true" frameclosed="false">
<ai:contractitem/>
<ai:table tableid="taskAllList" setname="com.asiainfo.task.bo.SETCurTask" height="200" multiselect="false" oncellchange="showcell" editable="false" oncontextmenu="" needrefresh="true"  pagesize="100"
width="100%" onrowchange="changeColor2" tablemodel="com.ai.appframe2.web.datamodel.MethodModelForService"
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
	//�������У��ʷ����Ʋ�ѯ
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
	chargeListTable.refresh("&applyid="+applyid+"&feetype="+feetype+"&applyTime="+applyTime+"&applyEndTime="+applyEndTime
	+"&principle="+principle+"&isSubmit="+isSubmit+"&townname="+townname+"&appname="+encodeURI(trim(appname)));
	
}

 function trim(str)
{
     return str.replace(/(^\s*)|(\s*$)/g, '');
}

function showMainInfo(){
	var curRow = chargeListTable.getRow();
	var applyid = chargeListTable.getValue(curRow,"APPLY_ID");
	var isSubmit = chargeListTable.getValue(curRow,"IS_SUBMIT");
	if(isSubmit!="1"){
	window.open("<%=request.getContextPath()%>/charge/chargeinfo/chargeSelectInfo.jsp?applyid="+applyid,"","height=490,width=860,top=0,left=0,toolbar=no,menubar=no,scrollbars=yes,resizable=yes,location=no,status=no");
	}else{
	window.open("<%=request.getContextPath()%>/charge/chargeinfo/chargeAddInfo.jsp?applyid="+applyid,"","height=490,width=860,top=0,left=0,toolbar=no,menubar=no,scrollbars=yes,resizable=yes,location=no,status=no");
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
 var mid="<%=request.getParameter("mid")%>";
 if(chargeid==""){
 return alert("��ѡ��һ�����ݣ�");
 }
 var strUrl = _gModuleName + '/business/com.asiainfo.charge.web.ChargeMainAction?action=copyChargeMain&applyid='+chargeid+"&staffid="+staffid+"&org="+org+"&mid="+mid;
 
 var recode = PostInfo(strUrl, null);
 var aid=recode.getValueByName("APPLYID");
 window.returnValue = aid;
 window.self.close();
 }
 
 function delChargeMain(){
	 return;
var ss = new Array();
 ss = chargeListTable.getSelectedRows();
 var isSubmit=chargeListTable.getValue(g_TableRowSetManager.get("chargeListTable").getRow(), "IS_SUBMIT");
 var delid=chargeListTable.getValue(g_TableRowSetManager.get("chargeListTable").getRow(), "APPLY_ID");
 var staffid=chargeListTable.getValue(g_TableRowSetManager.get("chargeListTable").getRow(), "PRINCIPLE");
  if (ss.length < 1) {
	        alert("��ѡ��Ҫɾ�������ݣ�");
	        return;
	    }
	if(isSubmit=="1"&&g_GetUserInfo().STAFF_ID==staffid){
	    for ( var i = ss.length; i > 0; i--) {
	        chargeListTable.deleteRow(ss[i - 1]);
	    }
	      	//var list = new Array();
		    //list.push(chargeListTable);/db2app55/business/com.asiainfo.charge.web.ChargeMainAction
		    var strUrl = _gModuleName + '/business/com.asiainfo.charge.web.ChargeMainAction?action=saveChargeMain&applyid='+delid;
		    var recode = PostInfo(strUrl, null);
		    alert("�����ɹ���");
	 }else if(isSubmit=="1"&&g_GetUserInfo().STAFF_ID!=staffid){
	 return  alert("����ɾ���������ĵ��ӣ�");
	 }else{
	  return  alert("��ǰ״̬����ɾ����");
	 }
}
 
function backChargeMain(){
var crows= g_TableRowSetManager.get("chargeListTable").getRow();
var mid=chargeListTable.getValue(crows, "APPLY_ID");
var staffid=chargeListTable.getValue(crows, "PRINCIPLE");
var isSubmit=chargeListTable.getValue(crows, "IS_SUBMIT");
var org=chargeListTable.getValue(crows, "ORGANIZE_NAME");
	if("11"==g_GetUserInfo().ORG_ID.substring(0,2)){
	var objectType="chargeCaseT";
	}else{
	var objectType="chargeCase";
	}
	 if(g_GetUserInfo().STAFF_ID!=staffid){
	 return  alert("���ܻس����˵ĵ���");
	 }else{
		 if("2"==isSubmit){
		 	var strMainUrl=_gModuleName + '/business/com.asiainfo.task.web.CurTaskAction?action=terminateWorkflow&object_id='+mid+'&staffId='+g_GetUserInfo().STAFF_ID+'&object_type='+objectType;
			var recode= PostInfo(strMainUrl);
			alert(recode.getValueByName("MESSAGE"));
			queryChargeMain();
		 }else{
		 return alert("��ǰ״̬���ܻس�!");
		 }
	 }
} 
 
function onrowchange1(oldIndex,newIndex){
    if(-1 != oldIndex) {
    	chargeListTable.setRowBgColor(oldIndex,"");
    }
    	chargeListTable.setRowBgColor(newIndex,"yellow");
    	beginAIWaitBanner(showSenderInfo,"���ڴ������Ժ�...");
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
	var apply_id = chargeListTable.getValue(curRowIndex, "APPLY_ID");
	var state = chargeListTable.getValue(curRowIndex, "IS_SUBMIT");
	//1023�ʷѵõ�Workflow_id
	var url=_gModuleName + '/business/com.asiainfo.task.web.CurTaskAction?action=getWorkflowId&apply_id='+apply_id+'&state='+state;
	var recode= PostInfo(url);
	var workflowId=	recode.getValueByName("workflowId");
	g_TableRowSetManager.get("taskAllList").refresh("&workflowId="+workflowId);
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
    beginAIWaitBanner(fun,"���ڴ������Ժ�...");
}
</script>
