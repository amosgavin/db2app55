<%@ page contentType="text/html; charset=GBK"%>
<%@ include file="/secframe/common/common.jsp"%>
<%@include file="/webframe/common/commonhead.jsp"%>
<%
   String recordId = request.getParameter("recordId");
 %>
<html>
<head>
<title><i18n:message key="logger.query.login.titile" res="i18n.secframe_resource"/></title>
<script language="javascript" src="<%=request.getContextPath()%>/jsv2/Calendar.jsp" type="text/javascript"></script>
</head>
<body onload="initPage()">
<ai:contractframe id="weaponListframe" contenttype="table" title="武器信息" width="100%" allowcontract="false" frameclosed="fale" >
	<ai:contractitem/>
 	<ai:table
		tableid="weaponMainListTable"
		setname="com.asiainfo.sale.weapon.web.SETSaleWeaponSignOrAduit"
		tablemodel="com.ai.appframe2.web.datamodel.MethodModelForService"
		implservice_name="com.asiainfo.sale.weapon.service.interfaces.ISaleWeaponSV"
		implservice_querymethod="getSaleWeaponSignOrAduit(String wid,String taskTag,int $STARTROWINDEX, int $ENDROWINDEX)"
		implservice_countmethod="getCountSignOrAduit()"
	 	ondbclick="showTagInfo" 
		initial="false" pagesize="15" editable="false" width="100%"
		height="150" needrefresh="true">
		<ai:col title="编号" fieldname="WID" width="100" />
		<ai:col title="类别" fieldname="SALE_FLAG" width="150" />
		<ai:col title="名称" fieldname="WEAPON_NAME" width="200" />
		<ai:col title="细分市场" fieldname="MARKET_TYPE" width="150" />
		<ai:col title="工单状态" fieldname="TLABEL" width="100" />
		<ai:col title="流程类型" fieldname="WLABEL" width="150" />
		<ai:col title="创建时间" fieldname="CREATE_DATE" width="150" />
		<ai:col title="进行状态" fieldname="TASK_TAG" width="150"/>
	</ai:table>
</ai:contractframe>

<ai:contractframe id="tagDetailframe" contenttype="table" title="需要测试备用标签" width="100%" allowcontract="true" frameclosed="false" >
	<ai:contractitem/>
	<ai:table setname="com.asiainfo.sale.tag.web.SETPromationTag"
			  tableid="detailTagTab" editable="false" width="100%" 
			  needrefresh="true" initial="false" height = "100"
			  tablemodel="com.ai.appframe2.web.datamodel.MethodModelForService"
			  implservice_name="com.asiainfo.sale.tag.service.interfaces.ITagDetailSV"
			  implservice_querymethod="getSpareTagDetailByWeaponId(int weaponId)"			  
			  operator="query">
		<table width="98%" align="center" border="0" cellpadding="1" cellspacing="1">
	        <tr>
	       		<td align = "left"><ai:col fieldname="ID" width="220" editable="false" visible="true" /> </td>
	        	<td align = "left"><ai:col fieldname="TAG_TYPE" width="220" editable="false" visible="true" /> </td>
				<td align = "left"><ai:col fieldname="NAME" width="250" editable="false" visible="true" /> </td>
				<td align = "left"><ai:col fieldname="CHARGE" width="220" editable="false" visible="true"/> </td>
				<td align = "left"><ai:col fieldname="CYCLE" width="220" editable="false" visible="true"/> </td>
			</tr>
		</table>
	</ai:table>
</ai:contractframe>	

<ai:contractframe id="weaponframe" contenttype="table" title="配置完成时间" width="100%" allowcontract="true" frameclosed="true" >
	<ai:contractitem/>
 	<ai:table tableid="weaponTable" setname="com.asiainfo.sale.weapon.web.SETSaleWeapon" 
		height="20" needrefresh="true" initial="false" editable="false" width="100%"
		tablemodel="com.ai.appframe2.web.datamodel.MethodModelForService"
		implservice_name="com.asiainfo.sale.weapon.service.interfaces.ISaleWeaponSV"
		implservice_querymethod="getSaleWeaponByID(int wid, int $STARTROWINDEX, int $ENDROWINDEX)">
		<ai:col title="标签配置完成时间" fieldname="SUGGEST_DATE" width="200" />
	</ai:table>
</ai:contractframe>

<ai:contractframe id="reasonframe" contenttype="table" title="工单已审批意见" width="100%" height="20" allowcontract="true" frameclosed="true" >
<ai:contractitem/>
<%@ include file="/main3/include/reasonlist.jsp" %>
</ai:contractframe>

<ai:contractframe id="tagApproveframe" contenttype="table" title="标签审批信息" width="100%" allowcontract="true" frameclosed="false">
	<ai:contractitem/>
	<ai:dbform formid="approveForm" 
			setname="com.asiainfo.sale.tag.web.SETApproveColumn"
			conditionname="condition" parametersname="parameters"
			onvalchange="" editable="true" initial="false"
			datamodel="com.ai.appframe2.web.datamodel.MethodModelForService">
		<table width="98%" align="center" border="0" cellpadding="1" cellspacing="1">
			<tr>
	           	<td class="td_font">测试结果 ：</td>
	           	<td><ai:dbformfield formid="approveForm" fieldname="ADVISE" width="600" height="160"/></td>
			</tr><tr>
				<td class="td_font"></td>
				<td><ai:button id="submit" text="提交" onclick="commit()"/></td>
			</tr>
		</table>
	</ai:dbform>
</ai:contractframe>
<ai:loginuser/>
<script type="text/javascript">
var taskId = 0;
var taskTag = "w03";
var weaponId = -1;
var taskState = "taskIsEnd";
var _tableTagDetailRowSet = g_TableRowSetManager.get("detailTagTab");
var weaponRs = g_TableRowSetManager.get("weaponMainListTable");
var weap = g_TableRowSetManager.get("weaponTable");
var rid = <%=recordId%>;
function initPage()
{
	if (rid == null){
		weaponRs.refresh("&taskTag=" + taskTag);
	} else {
		weaponRs.refresh("&taskTag=" + taskTag+"&wid="+rid);
	}
}

function reasonGo(wid, taskType){
  reason(wid,taskType);
}

function showTagInfo()
{
	var curRowIndex = weaponRs.getCurRowIndex();
	weaponId = weaponRs.getValue(curRowIndex, "WID");
	var param = "&id="+weaponId+"&startNum=0"+"&endNum=0";
	_tableTagDetailRowSet.refresh("&weaponId=" + weaponId);
	reasonGo(weaponId,"weaponCase");
	weap.refresh("&wid=" + weaponId);
}
function commit()
{
	var id = g_FormRowSetManager.get("approveForm").getValue("ID");
	var reason = g_FormRowSetManager.get("approveForm").getValue("ADVISE");
	//var staffId = document.getElementById("staffId").value;
	var condition = "&id=" + id + "&reason=" + trim(reason) + "&weaponId=" + weaponId + "&taskState=" + taskState;
	//alert(condition);
	var strUrl = '<%=request.getContextPath()%>/business/com.asiainfo.sale.tag.web.TagFlowAction?action=finishTask&condition=' + condition;
	var recode = PostInfo(strUrl, null);
	alert("提交成功！");
	//window.self.close();
}

function trim(str)
{
     return str.replace(/(^\s*)(\s*$)/g, '');
}

function selectStaff()
{
	var url = "<%=request.getContextPath()%>/secframe/orgmodel/operator/StaffSelect_s.jsp";
	var result = window.showModalDialog(url, null, "scroll:no;resizable:no;help:no;status:no;dialogHeight:490px;dialogWidth:560px");
	if(result != null){
		var value;
		var text;
   		for(var i=0;i < result.elements.length;i++)
  		{
  			if (i == 0)
  			{
	  			value = result.elements[i].value;
	  			text = result.elements[i].text;
  			} else {
	  			value = value + "," + result.elements[i].value;
	  			text = text + "," + result.elements[i].text;
  			}
  		}
	  	document.getElementById("staffId").value=text;
	}
} 
 
</script>
