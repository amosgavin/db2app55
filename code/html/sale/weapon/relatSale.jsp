<%@ page contentType="text/html; charset=GBK"%>
<%@ include file="/secframe/common/common.jsp"%>
<%@include file="/webframe/common/commonhead.jsp"%>
<html>
<head>
<title>��������Ӫ���</title>
<body onload="initPage()">
<ai:contractframe id="saleMainframe" contenttype="table" title="����Ӫ�������" width="100%" allowcontract="true" frameclosed="fale">
	<ai:contractitem/>
 	<ai:table
		tableid="saleOrderTable"
		setname="com.asiainfo.sale.activity.web.SETSaleOrder"
		tablemodel="com.ai.appframe2.web.datamodel.MethodModelForService"
		implservice_name="com.asiainfo.sale.activity.service.interfaces.ISaleOrderSV"
		implservice_querymethod="getRelatSaleOrderByWpId(String wpId,int $STARTROWINDEX, int $ENDROWINDEX)"
		implservice_countmethod="getRelatSaleOrderCnByWpId(String wpId)"
		ondbclick="showSaleDetailInfo" onrowchange='changeColor1'
		initial="false"  multiselect="false" 
		pagesize="15" editable="false" width="100%"
		height="150" needrefresh="true">
        <ai:col title="������" fieldname="ORDER_ID" width="100"/>
		<ai:col title="��������" fieldname="ORDER_NAME" width="400" />
		<ai:col title="������" fieldname="PROP_NAME" width="70" />
		<ai:col title="����ID" fieldname="ORG_ID" width="70" visible="false"/>
		<ai:col title="���벿��" fieldname="ORG_NAME" width="180" />
        <ai:col title="����ʱ��" fieldname="CREATE_DATE" width="130" />
        <ai:col title="����״̬" fieldname="STATE" width="80" />
		
	</ai:table>
</ai:contractframe>
<div class="area_button">
    <ai:button id="bt_saveSaleMain" text="�鿴��ϸ" onclick="showSaleDetailInfo()"/>&nbsp;&nbsp;
</div>

<ai:contractframe id="saleFWframe" contenttype="table" title="������ת��ϸ" width="100%" allowcontract="true" frameclosed="fale">
    <ai:contractitem/>
<ai:table tableid="taskAllList" setname="com.asiainfo.task.bo.SETCurTask" height="290" multiselect="false" oncellchange="" editable="false" oncontextmenu="" needrefresh="true" onrowchange="" pagesize="200"
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
 <ai:col fieldname="STAFF_NAME" width="90"/> 
 <ai:col fieldname="NEXT_TASK" width="140"/>
 <ai:col fieldname="DECISION_RESULT" width="70" visible="false"/>
 <ai:col fieldname="DESCRIPTION" width="300"/>
 <ai:col fieldname="STATE_NAME" width="120" visible="false"/>
 <ai:col fieldname="TASK_DATE" width="130"/>
 <ai:col fieldname="FINISH_DATE" width="130"/>
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
<script language="javascript" src="<%=request.getContextPath()%>/jsv2/DBListBox.js"></script>
<script language="javascript" src="<%=request.getContextPath()%>/sale/common/js/openSelect.js"></script>
<script type="text/javascript">
var _tableSaleOrderInfoTableRowSet = g_TableRowSetManager.get("saleOrderTable");
var _tableFWTableRowSet = g_TableRowSetManager.get("taskAllList");

function initPage(){
	var wpId = "<%=request.getParameter("wpId")%>";
	_tableSaleOrderInfoTableRowSet.refresh("&wpId=" + wpId);
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

function showSaleDetailInfo(){
    var curRow = _tableSaleOrderInfoTableRowSet.getRow();
    var orderId = _tableSaleOrderInfoTableRowSet.getValue(curRow, "ORDER_ID");
    if("" == orderId) return alert("��ѡ��Ҫ�鿴��Ӫ����");
    var url = "<%=request.getContextPath()%>/sale/activity/new.jsp?orderId="+orderId+"&editable=false";
    window.open(url, null, 'height=490,width=860,top=0,left=0,toolbar=no,menubar=no,scrollbars=yes,resizable=yes,location=no,status=no');
}

function trim(str)
{
     return str.replace(/(^\s*)|(\s*$)/g, '');
}

function select2table()
{
	var createDateBegin = _fromSelectSaleOrderFormRowSet.getValue("CREATE_DATE");
	var createDateEnd = _fromSelectSaleOrderFormRowSet.getValue("QUERY_END_DATE");
    if (1 == g_CompareDate(createDateBegin,createDateEnd))
    {
        return alert("����ʱ�䲻��С�ڿ�ʼʱ�䣡");
    }
	var orderId = _fromSelectSaleOrderFormRowSet.getValue("ORDER_ID");
	var orderName = _fromSelectSaleOrderFormRowSet.getValue("ORDER_NAME");
	var pinciple = _fromSelectSaleOrderFormRowSet.getValue("PRINCIPLE");
	var orgId = _fromSelectSaleOrderFormRowSet.getValue("ORG_ID");
    var state = _fromSelectSaleOrderFormRowSet.getValue("STATE");
    
    //��չ�����ת��ϸ
    _tableFWTableRowSet.clear();
    
	var condition = "&orderId=" + orderId
					+ "&orderName=" + encodeURI(trim(orderName))
					+ "&pinciple=" + pinciple
					+ "&orgId=" +  orgId
					+ "&beginTime=" + createDateBegin
					+ "&endTime=" + createDateEnd
					+ "&state=" + state;
	_tableSaleOrderInfoTableRowSet.refresh(condition);
}

function selectOrgnize()
{
	var url = "<%=request.getContextPath()%>/secframe/orgmodel/operator/OrgRelate.jsp";
	var result = window.showModalDialog(url,"org","scroll:no;resizable:no;status:no;dialogHeight:460px;dialogWidth:300px");
	if(result.value=='undefined'||result.value==null){
		result="";
	} else {
		_fromSelectSaleOrderFormRowSet.setValue("PROMOTE_DEPART",result.value,result.text);
	}
}
function clsStaff(){
    _fromSelectSaleOrderFormRowSet.setValue("PRINCIPLE", "", "");
    _fromSelectSaleOrderFormRowSet.setValue("PROP_NAME", "", "");
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
        _fromSelectSaleOrderFormRowSet.setValue("PRINCIPLE", operatorId);
        _fromSelectSaleOrderFormRowSet.setValue("PROP_NAME", name); 
    }
} 

function showWFDetail() {
     var curRow = _tableSaleOrderInfoTableRowSet.getRow();
     var state = _tableSaleOrderInfoTableRowSet.getValue(curRow, "STATE");
     var orderId = _tableSaleOrderInfoTableRowSet.getValue(curRow, "ORDER_ID");
     //��չ�����ת��ϸ
     _tableFWTableRowSet.clear();
     if (state == '1') return;
     _tableFWTableRowSet.refresh("&recordId="+orderId+"&state="+state);//ˢ��
}

function delSaleMain() {
	
	var curRow = _tableSaleOrderInfoTableRowSet.getRow();
	var saleState = _tableSaleOrderInfoTableRowSet.getValue(curRow, "STATE");
	if (saleState != '1') {
		return alert("ֻ��ɾ������״̬�Ĺ�����");
	}
	if (g_GetUserInfo().STAFF_NAME == _tableSaleOrderInfoTableRowSet.getValue(curRow, "PROP_NAME")){
		if(confirm("��ȷ��Ҫɾ����")){
			
			//var curRow = _fromSelectSaleOrderFormRowSet.getRow();
			var orderId = _tableSaleOrderInfoTableRowSet.getValue(curRow, "ORDER_ID");
			
			if("" == orderId){
		        alert("��ѡ��Ҫɾ����Ӫ����");
		        return;
		    }
			_tableSaleOrderInfoTableRowSet.deleteRow(curRow);
			var list = new Array();
			list.push(_tableSaleOrderInfoTableRowSet);
		    var strUrl = _gModuleName + '/business/com.asiainfo.sale.activity.web.SaleOrderAction?action=saveSaleOrderInfo';
		    var recode = saveRowSet(strUrl, list);
		
		    var message = recode.getValueByName("MESSAGE");
		    var rFlag = recode.getValueByName("FLAG");
		    if ("Y" == rFlag)
		    {
		    	//alert(message);
		    	select2table();
		    	return;
		    } else {
		        //alert(message);
		        select2table();
		        return;
		    }
		} else {
			return;
		}
	} else {
		alert("ֻ��ɾ���Լ��Ĺ�����");
	}
}

function cancelWF(){
	
	var curRow = _tableSaleOrderInfoTableRowSet.getRow();
	var saleState = _tableSaleOrderInfoTableRowSet.getValue(curRow, "STATE");
	var propOrgId = _tableSaleOrderInfoTableRowSet.getValue(curRow, "ORG_ID");
	var _flowType = "";
	var _orgId = g_GetUserInfo().ORG_ID;
	if ("1003" == _orgId.substr(0,4)) {
    	_flowType = "saleCaseI";
	} else if ("10" == _orgId.substr(0,2)){
    	_flowType = "saleCase";
	} else {
    	_flowType = "saleCaseT";
	}
	if (saleState != '2') {
		return alert("��ǰ״̬�������ܻس���");
	}
	if (g_GetUserInfo().STAFF_NAME == _tableSaleOrderInfoTableRowSet.getValue(curRow, "PROP_NAME")){
		
		if(confirm("��ȷ��Ҫ�س���")){
			
			var orderId = _tableSaleOrderInfoTableRowSet.getValue(curRow, "ORDER_ID");
			
			var strUrl=_gModuleName + '/business/com.asiainfo.task.web.CurTaskAction?action=terminateWorkflow&object_id='+orderId+'&staffId='+g_GetUserInfo().STAFF_ID+'&object_type=' +_flowType;
			var recode = PostInfo(strUrl,null);
			var message = recode.getValueByName("MESSAGE");
			var rFlag = recode.getValueByName("FLAG");
			if ("Y" == rFlag)
		    {
		    	alert(message);
		    	select2table();
		    	return;
		    } else {
		        alert(message);
		        select2table();
		        return;
		    }
		} else {
			alert("ֻ�ܻس��Լ��Ĺ�����");
		}
	}
}

function onValChange(pFieldName,pOldVal,pOldText,pNewVal,pNewText){
    if (pFieldName == 'IS_SUBMIT') {
    	var saleState = _fromSelectSaleOrderFormRowSet.getValue("IS_SUBMIT");
    	select2table();
    }
}

function cloneSaleInfo()
{
    if(window.confirm("���ȷ����������ѡ��Ĺ������ݲ������µĹ�����ȷ��Ҫ������"))
    {
        //����
    } else {
    	return;
    }
    var curRow = _tableSaleOrderInfoTableRowSet.getRow();
    var orderId = _tableSaleOrderInfoTableRowSet.getValue(curRow, "ORDER_ID");
    if("" == orderId){
        alert("��ѡ��Ҫ�鿴��Ӫ����");
        return;
    }
    var strUrl = _gModuleName + '/business/com.asiainfo.sale.activity.web.SaleOrderAction?action=cloneSaleOrder&orderId='+orderId;
    var recode = PostInfo(strUrl);

    var message = recode.getValueByName("MESSAGE");
    var rFlag = recode.getValueByName("FLAG");
    if ("Y" == rFlag)
    {
    	alert("���Ƴɹ���");
    	select2table();
    	return;
    } else {
        alert("����ʧ�ܣ�"+message);
        select2table();
        return;
    }
}

function changeColor1(oldIndex,newIndex){
	showWFDetail();
    if(-1 != oldIndex) {
    	_tableSaleOrderInfoTableRowSet.setRowBgColor(oldIndex,"");
    }
   		_tableSaleOrderInfoTableRowSet.setRowBgColor(newIndex,"yellow");
}

function changeColor2(oldIndex,newIndex){
	showcell();
    if(-1 != oldIndex) {
    	_tableFWTableRowSet.setRowBgColor(oldIndex,"");
    }
    	_tableFWTableRowSet.setRowBgColor(newIndex,"yellow");
}

function changeColor3(oldIndex,newIndex){
	showcellHis();
    if(-1 != oldIndex) {
    	_tableFWHisTableRowSet.setRowBgColor(oldIndex,"");
    }
    	_tableFWHisTableRowSet.setRowBgColor(newIndex,"yellow");
}

function showcell(){
	 var curRow = _tableFWTableRowSet.getRow();
	 var curCol = _tableFWTableRowSet.getCol();
	 var taskStaffId=_tableFWTableRowSet.getValue(curRow,"TASK_STAFF_ID");
	 if(taskStaffId==""){
		 taskStaffId=_tableFWTableRowSet.getValue(curRow,"CREATE_STAFF_ID");
	 }
	 if(curCol==6||curCol==4||curCol==3){
	   var msg = _tableFWTableRowSet.getValue(curRow,"DESCRIPTION");
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

function showcellHis(){
	 var curRow = _tableFWHisTableRowSet.getRow();
	 var curCol = _tableFWHisTableRowSet.getCol();
	 var taskStaffId=_tableFWHisTableRowSet.getValue(curRow,"TASK_STAFF_ID");
	 if(taskStaffId==""){
		 taskStaffId=_tableFWHisTableRowSet.getValue(curRow,"CREATE_STAFF_ID");
	 }
	 if(curCol==6||curCol==4||curCol==3){
	   var msg = _tableFWHisTableRowSet.getValue(curRow,"DESCRIPTION");
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
    beginAIWaitBanner(fun,"���ڴ������Ժ�...");
}
</script>