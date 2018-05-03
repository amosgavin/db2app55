<%@ page contentType="text/html; charset=GBK"%>
<%@ include file="/secframe/common/common.jsp"%>
<%@include file="/webframe/common/commonhead.jsp"%>
<html>
<head>
<title><i18n:message key="logger.query.login.titile" res="i18n.secframe_resource"/></title>
<script language="javascript" src="<%=request.getContextPath()%>/jsv2/Calendar.jsp" type="text/javascript"></script>
</head>
<body onload="initPage()">

<ai:contractframe id="queryframe" contenttype="table" title="查询条件" width="100%" allowcontract="false" frameclosed="false">
<ai:contractitem/>
<ai:dbform formid="queryForm" 
			setname="com.asiainfo.costWarn.web.CostWarnReceiver" 
			datamodel="com.ai.appframe2.web.datamodel.MethodModelForService"
			implservice_name="com.asiainfo.costWarn.service.interfaces.ICostWarnReceiverSV"
			implservice_querymethod="getCostWarnReceiverValue(String personId, String cityId, String target, String grade, String bill_id)"
			editable="true" initial="false">
		<table width="98%" align="center" border="0" cellpadding="1" cellspacing="2">
			  <tr>
	           		<td class="td_font">预警地市：</td>
	           		<td><ai:dbformfield formid="queryForm" fieldname="CITY_ID" width="180"/>
	           		</td>
	           		<td class="td_font">预警资源类型：</td>
	           		<td><ai:dbformfield formid="queryForm" fieldname="TARGET" width="180"/>
	           		</td>
	           		<td class="td_font">预警级别：</td>
	           		<td><ai:dbformfield formid="queryForm" fieldname="GRADE" width="180"/>
	           		</td>
	           	</tr>
	           	<tr>
	           		<td class="td_font">档次ID：</td>
	           		<td><ai:dbformfield formid="queryForm" fieldname="RESERVE1" width="180"/>
	           		</td>
	           		<td class="td_font">手机号码：</td>
	           		<td><ai:dbformfield formid="queryForm" fieldname="BILL_ID" width="180"/>
	           		</td>
	           		<td class="td_font">电子邮箱：</td>
	           		<td><ai:dbformfield formid="queryForm" fieldname="EMAIL" width="180"/>
	           		    <ai:button id="bt_query" text="查询" onclick="queryCostWarnRec()"/>
	           		</td>
	           	</tr>
		</table>
	</ai:dbform>
</ai:contractframe>

<ai:contractframe id="costWarnRecTframe" contenttype="table" title="预警接收人设置" width="100%" allowcontract="true" frameclosed="false" >
	<ai:contractitem>
	<ai:button id="add-id" text="新增" onclick="addCostWarnRec()"/>
	<ai:button id="delete-id" text="删 除" onclick="deleteCostWarnRec()"/>
	</ai:contractitem>
	<ai:table setname="com.asiainfo.costWarn.web.CostWarnReceiver"
			  tableid="costWarnRecTab" editable="false" width="100%" height = "250"
			  needrefresh="true" initial="false" multiselect="true" pagesize="7"
			  tablemodel="com.ai.appframe2.web.datamodel.MethodModelForService"
			  implservice_name="com.asiainfo.costWarn.service.interfaces.ICostWarnReceiverSV"
			  implservice_querymethod="getCostWarnReceiverValues(String personId, String cityId, String target, String grade, String bill_id, int $STARTROWINDEX, int $ENDROWINDEX)"
			  implservice_countmethod="getCountCostWarnReceiverValues(String personId, String cityId, String target, String grade, String bill_id)"			  
			  initial="false" multiselect="true" pagesize="10" editable="false"
				width="100%" height="200" needrefresh="true" onrowchange="showToForm">
			    <ai:col fieldname="PERSON_ID" width="20%" editable="false" visible="false" />
			    <ai:col fieldname="CITY_ID" width="15%" editable="false" visible="true" />
	        	<ai:col fieldname="TARGET" width="20%" editable="false" visible="true" />
				<ai:col fieldname="GRADE" width="10%" editable="false" visible="true" /> 
				<ai:col fieldname="RESERVE1" width="15%" editable="false" visible="true" /> 
				<ai:col fieldname="BILL_ID" width="15%" editable="false" visible="true"/>
				<ai:col fieldname="EMAIL" width="15%" editable="false" visible="true"/>
	</ai:table>
</ai:contractframe>

<ai:contractframe id="costWarnRecFframe" contenttype="table" title="预警接收人设置" width="100%" allowcontract="true" frameclosed="false" >
	<ai:contractitem/>
	<ai:dbform formid="costWarnRecForm" initial="false"
			setname="com.asiainfo.costWarn.web.CostWarnReceiver" 
			datamodel="com.ai.appframe2.web.datamodel.MethodModelForService"
			implservice_name="com.asiainfo.costWarn.service.interfaces.ICostWarnReceiverSV"
			implservice_querymethod="getCostWarnReceiverValue(String personId, String cityId, String target, String grade, String bill_id)"
		    editable="true">
		<table width="98%" align="center" border="0" cellpadding="1" cellspacing="2">
	    
	            <tr>
	           		<td class="td_font">预警地市：</td>
	           		<td><ai:dbformfield formid="costWarnRecForm" fieldname="CITY_ID" width="180"/><span class="font_red">*</span>
	           		</td>
	           		<td class="td_font">预警资源类型：</td>
	           		<td><ai:dbformfield formid="costWarnRecForm" fieldname="TARGET" width="180"/><span class="font_red">*</span>
	           		</td>
	           	</tr>
	           	<tr>
	           		<td class="td_font">预警级别：</td>
	           		<td><ai:dbformfield formid="costWarnRecForm" fieldname="GRADE" width="180"/><span class="font_red">*</span>
	           		</td>
	           		<td class="td_font">档次ID：</td>
	           		<td><ai:dbformfield formid="costWarnRecForm" fieldname="RESERVE1" width="180"/><span class="font_red">*</span>
	           		</td>
	           	</tr>
	           	 <tr>
	           	 	<td class="td_font">手机号码：</td>
	           		<td><ai:dbformfield formid="costWarnRecForm" fieldname="BILL_ID" width="180"/><span class="font_red">*</span>
	           		</td>
	           		<td class="td_font">电子邮箱：</td>
	           		<td><ai:dbformfield formid="costWarnRecForm" fieldname="EMAIL" width="180"/><span class="font_red">*</span>
	           		</td>
	           	</tr>
		</table>
	</ai:dbform>
	<ai:button id="bt_saveCostWarnRec" text="保存" onclick="saveCostWarnRec()"/>
</ai:contractframe>



<ai:loginuser />
<script type="text/javascript">
var costWarnRecForm = g_FormRowSetManager.get("costWarnRecForm");	
var costWarnRecTab = g_TableRowSetManager.get("costWarnRecTab");

function initPage(){

	//costWarnRecTab.refresh();
}

function addCostWarnRec()
{
	costWarnRecForm.newRow();
	costWarnRecForm.setEditSts(true);
}

function saveCostWarnRec()
{
	if ("" == costWarnRecForm.getValue("CITY_ID"))
    {
        alert("在保存之前，请选择“预警地市”！");
        costWarnRecForm.setFocus("CITY_ID");
        return;
    }
	if ("" == costWarnRecForm.getValue("TARGET"))
    {
        alert("在保存之前，请选择“预警资源类型”！");
        costWarnRecForm.setFocus("TARGET");
        return;
    }
	if ("" == costWarnRecForm.getValue("GRADE"))
    {
        alert("在保存之前，请选择“预警级别”！");
        costWarnRecForm.setFocus("GRADE");
        return;
    }
	if ("" == costWarnRecForm.getValue("BILL_ID"))
    {
        alert("在保存之前，请输入“手机号码”！");
        costWarnRecForm.setFocus("BILL_ID");
        return;
    }
	if ("" == costWarnRecForm.getValue("EMAIL"))
    {
        alert("在保存之前，请输入“电子邮箱”！");
        costWarnRecForm.setFocus("EMAIL");
        return;
    }
	if ("O" != costWarnRecForm.getSts())
    {
        var list = new Array();
        list.push(costWarnRecForm);
        var strUrl = _gModuleName + '/business/com.asiainfo.costWarn.web.CostWarnReceiverAction?action=saveCostWarnReceiver';
        var recode = saveRowSet(strUrl, list);
        var rFlag = recode.getValueByName("FLAG");
        if ("Y" == rFlag)
        {
        	//alert("保存成功！");
        	costWarnRecTab.refresh(null);
        	costWarnRecForm.newRow();
			costWarnRecForm.setEditSts(true);
        } else {
        	costWarnRecForm.newRow();
        }
        return rFlag;
    } else {
        return;
    }
}

function deleteCostWarnRec()
{
	if(confirm("您确定要删除！")){
		
		var delRows = costWarnRecTab.getSelectedRows();
		var delRowCount = delRows.length;
		if (delRowCount == 0) {
			alert("请先选择要删除的行");
			return;
		}
		while (delRowCount > 0) {
			delRowCount--;
			costWarnRecTab.deleteRow(delRows[delRowCount]);
		}
		var list = new Array();
		list.push(costWarnRecTab);
		var strUrl = '<%=request.getContextPath()%>/business/com.asiainfo.costWarn.web.CostWarnReceiverAction?action=saveCostWarnReceiver';
		var ud = saveRowSet(strUrl, list);
		if (ud.getValueByName("FLAG") == "Y") {
			costWarnRecTab.refresh(null);
	        costWarnRecForm.newRow();
		} else {
			alert(ud.getValueByName("MESSAGE"));
			return;
		}
	}
}

function showToForm(oldIndex,newIndex)
{
   if(-1 != oldIndex) {
     costWarnRecTab.setRowBgColor(oldIndex,"");
   }
   costWarnRecTab.setRowBgColor(newIndex,"yellow");
   var rowIndex = costWarnRecTab.getRow();
   var personId = costWarnRecTab.getValue(rowIndex,"PERSON_ID");
   costWarnRecForm.refresh("&personId="+personId);
}

function queryCostWarnRec()
{
	var cityId = g_FormRowSetManager.get("queryForm").getValue("CITY_ID");
	var target = g_FormRowSetManager.get("queryForm").getValue("TARGET");
	var grade = g_FormRowSetManager.get("queryForm").getValue("GRADE");
	var billId = g_FormRowSetManager.get("queryForm").getValue("BILL_ID");
	var email = g_FormRowSetManager.get("queryForm").getValue("EMAIL");
	//costWarnRecTab.refresh("&cityId=" + cityId + "&target=" + target+ "&grade=" 
		//+ grade + "&billId=" + billId + "&email=" + email);
	costWarnRecTab.refresh();
}
</script>
</body>
</html>