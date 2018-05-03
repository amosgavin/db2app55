<%@ page contentType="text/html; charset=GBK"%>
<%@ include file="/secframe/common/common.jsp"%>
<%@include file="/webframe/common/commonhead.jsp"%>
<html>
<head>
<title><i18n:message key="预警接收人员" res="i18n.secframe_resource"/></title>
<script language="javascript" src="<%=request.getContextPath()%>/jsv2/Calendar.jsp" type="text/javascript"></script>
</head>
<body onload="initPage()">

<ai:contractframe id="costWarnRecTframe" contenttype="table" title="预警接收人设置" width="100%" allowcontract="true" frameclosed="false" >
	<ai:contractitem>
	<ai:button id="add-id" text="新增" onclick="addCostWarnRec()"/>
	<ai:button id="delete-id" text="删 除" onclick="deleteCostWarnRec()"/>
	</ai:contractitem>
	<ai:table setname="com.asiainfo.costWarn.web.CostWarnReceiver"
			  tableid="costWarnRecTab2" editable="false" width="100%" height = "250"
			  needrefresh="true" initial="false" multiselect="true" pagesize="7"
			  tablemodel="com.ai.appframe2.web.datamodel.MethodModelForService"
			  implservice_name="com.asiainfo.costWarn.service.interfaces.ICostWarnReceiverSV"
			  implservice_querymethod="getCostWarnReceiverValues(String personId, String cityId, String target, String levelId, String grade, String bill_id, int $STARTROWINDEX, int $ENDROWINDEX)"
			  implservice_countmethod="getCountCostWarnReceiverValues(String personId, String cityId, String target, String levelId, String grade, String bill_id)"			  
			  onrowchange="showToForm">
			    <ai:col fieldname="PERSON_ID" width="20%" editable="false" visible="false" />
			    <ai:col fieldname="CITY_ID" width="15%" editable="false" visible="false" />
	        	<ai:col fieldname="TARGET" width="20%" editable="false" visible="false" />
				<ai:col fieldname="GRADE" width="10%" editable="false" visible="false" /> 
				<ai:col fieldname="LEVEL_ID" width="15%" editable="false" visible="false" /> 
				<ai:col fieldname="BILL_ID" width="45%" editable="false" visible="true"/>
				<ai:col fieldname="EMAIL" width="45%" editable="false" visible="true"/>
	</ai:table>
</ai:contractframe>

<ai:contractframe id="costWarnRecFframe" contenttype="table" title="预警接收人设置" width="100%" allowcontract="true" frameclosed="false" >
	<ai:contractitem/>
	<ai:dbform formid="costWarnRecForm2" initial="false"
			setname="com.asiainfo.costWarn.web.CostWarnReceiver" 
			datamodel="com.ai.appframe2.web.datamodel.MethodModelForService"
			implservice_name="com.asiainfo.costWarn.service.interfaces.ICostWarnReceiverSV"
			implservice_querymethod="getCostWarnReceiverValue(String personId, String cityId, String target, String levelId, String grade, String bill_id)"
		    editable="true">
		<table width="98%" align="center" border="0" cellpadding="1" cellspacing="2">
	    
	            <tr id="city_tr" style="display: none">
	           		<td class="td_font">预警地市：</td>
	           		<td><ai:dbformfield formid="costWarnRecForm2" fieldname="CITY_ID" width="180"/><span class="font_red">*</span>
	           		</td>
	           		<td class="td_font">预警资源类型：</td>
	           		<td><ai:dbformfield formid="costWarnRecForm2" fieldname="TARGET" width="180"/><span class="font_red">*</span>
	           		</td>
	           	</tr>
	           	<tr id="level_grade_tr" style="display: none">
	           		<td class="td_font">预警级别：</td>
	           		<td><ai:dbformfield formid="costWarnRecForm2" fieldname="GRADE" width="180"/><span class="font_red">*</span>
	           		</td>
	           		<td class="td_font">档次ID：</td>
	           		<td><ai:dbformfield formid="costWarnRecForm2" fieldname="LEVEL_ID" width="180"/><span class="font_red">*</span>
	           		</td>
	           	</tr>
	           	 <tr>
	           	 	<td class="td_font">手机号码：</td>
	           		<td><ai:dbformfield formid="costWarnRecForm2" fieldname="BILL_ID" width="180"/><span class="font_red">*</span>
	           		</td>
	           		<td class="td_font">电子邮箱：</td>
	           		<td><ai:dbformfield formid="costWarnRecForm2" fieldname="EMAIL" width="180"/><span class="font_red">*</span>
	           		</td>
	           	</tr>
		</table>
	</ai:dbform>
	<ai:button id="bt_saveCostWarnRec" text="保存" onclick="saveCostWarnRec()"/>
</ai:contractframe>



<ai:loginuser />
<script type="text/javascript">
var cityId="<%=request.getParameter("cityId")%>";
var target="<%=request.getParameter("target")%>";
var levelId="<%=request.getParameter("levelId")%>";
var grade="<%=request.getParameter("grade")%>";

var costWarnRecForm2 = g_FormRowSetManager.get("costWarnRecForm2");	
var costWarnRecTab2 = g_TableRowSetManager.get("costWarnRecTab2");

function initPage(){

	costWarnRecTab2.refresh("&cityId="+cityId+"&target="+target+"&levelId="+levelId+"&grade="+grade);
	costWarnRecForm2.setValue("CITY_ID",cityId);
	costWarnRecForm2.setValue("TARGET",target);
	costWarnRecForm2.setValue("LEVEL_ID",levelId);
	costWarnRecForm2.setValue("GRADE",grade);
}

function addCostWarnRec()
{
	costWarnRecForm2.newRow();
	costWarnRecForm2.setEditSts(true);
	
}

function saveCostWarnRec()
{
	costWarnRecForm2.setValue("CITY_ID",cityId);
	costWarnRecForm2.setValue("TARGET",target);
	costWarnRecForm2.setValue("LEVEL_ID",levelId);
	costWarnRecForm2.setValue("GRADE",grade);
	
	if ("" == costWarnRecForm2.getValue("BILL_ID"))
    {
        alert("在保存之前，请输入“手机号码”！");
        costWarnRecForm2.setFocus("BILL_ID");
        return;
    }
	if ("" == costWarnRecForm2.getValue("EMAIL"))
    {
        alert("在保存之前，请输入“电子邮箱”！");
        costWarnRecForm2.setFocus("EMAIL");
        return;
    }
	if ("O" != costWarnRecForm2.getSts())
    {
        var list = new Array();
        list.push(costWarnRecForm2);
        var strUrl = _gModuleName + '/business/com.asiainfo.costWarn.web.CostWarnReceiverAction?action=saveCostWarnReceiver';
        var recode = saveRowSet(strUrl, list);
        var rFlag = recode.getValueByName("FLAG");
        if ("Y" == rFlag)
        {
        	//alert("保存成功！");
        	costWarnRecTab2.refresh("&cityId="+cityId+"&target="+target+"&levelId="+levelId+"&grade="+grade);
        	costWarnRecForm2.newRow();
			costWarnRecForm2.setEditSts(true);
        } else {
        	costWarnRecForm2.newRow();
        }
        return rFlag;
    } else {
        return;
    }
}

function deleteCostWarnRec()
{
	if(confirm("您确定要删除！")){
		
		var delRows = costWarnRecTab2.getSelectedRows();
		var delRowCount = delRows.length;
		if (delRowCount == 0) {
			alert("请先选择要删除的行");
			return;
		}
		while (delRowCount > 0) {
			delRowCount--;
			costWarnRecTab2.deleteRow(delRows[delRowCount]);
		}
		var list = new Array();
		list.push(costWarnRecTab2);
		var strUrl = '<%=request.getContextPath()%>/business/com.asiainfo.costWarn.web.CostWarnReceiverAction?action=saveCostWarnReceiver';
		var ud = saveRowSet(strUrl, list);
		if (ud.getValueByName("FLAG") == "Y") {
			costWarnRecTab2.refresh("&cityId="+cityId+"&target="+target+"&levelId="+levelId+"&grade="+grade);
	        costWarnRecForm2.newRow();
		} else {
			alert(ud.getValueByName("MESSAGE"));
			return;
		}
	}
}

function showToForm(oldIndex,newIndex)
{
   if(-1 != oldIndex) {
     costWarnRecTab2.setRowBgColor(oldIndex,"");
   }
   costWarnRecTab2.setRowBgColor(newIndex,"yellow");
   var rowIndex = costWarnRecTab2.getRow();
   var personId = costWarnRecTab2.getValue(rowIndex,"PERSON_ID");
   costWarnRecForm2.refresh("&personId="+personId);
}

function queryCostWarnRec()
{
	var cityId = g_FormRowSetManager.get("queryForm").getValue("CITY_ID");
	var target = g_FormRowSetManager.get("queryForm").getValue("TARGET");
	var grade = g_FormRowSetManager.get("queryForm").getValue("GRADE");
	var levelId = g_FormRowSetManager.get("queryForm").getValue("LEVEL_ID");
	var billId = g_FormRowSetManager.get("queryForm").getValue("BILL_ID");
	var email = g_FormRowSetManager.get("queryForm").getValue("EMAIL");
	costWarnRecTab2.refresh("&cityId=" + cityId + "&target=" + target+ "&grade=" 
		+ grade + "&billId=" + billId );
}
</script>
</body>
</html>