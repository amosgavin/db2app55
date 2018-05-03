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
		setname="com.asiainfo.sale.weapon.web.SETSaleWeapon"
		tablemodel="com.ai.appframe2.web.datamodel.MethodModelForService"
		implservice_name="com.asiainfo.sale.weapon.service.interfaces.ISaleWeaponSV"
		implservice_querymethod="getSaleWeapon(String mid,String wwid,String wid,String weaponName, String marketType,
			String backMonth, String baseMonth, String lLimit, String bLimit,
			String presentValuePermon, String presentBusiMonth, String busiType,
			String netAge, String couponsValue, String selfBusi,
			String goodAdoptDirectory,String state,String presentBusiAmount,
			String presentReachAmount,String presentValuePermon,String presentBusi2Amount,
			String zfqType,String minNetAge,String maxNetAge,
			int $STARTROWINDEX, int $ENDROWINDEX)"
		implservice_countmethod="getCount(String mid,String wwid,String wid,String weaponName,
			String marketType, String backMonth, String baseMonth, String lLimit,
			String bLimit, String saleFlag, String presentBusiMonth, String busiType,
			String netAge, String couponsValue, String selfBusi, String goodAdoptDirectory,
			String state,String presentBusiAmount,String presentReachAmount,
			String presentValuePermon,String presentBusi2Amount,
			String zfqType,String minNetAge,String maxNetAge)"
		onrowchange="" 
		initial="false" pagesize="7" editable="false" width="100%"
		height="160" needrefresh="true">
		<ai:col title="编号" fieldname="WID" width="10%"  visible="false"/>
		<ai:col title="武器编号" fieldname="MID" width="10%"/>
		<ai:col title="武器名称" fieldname="WEAPON_NAME" width="20%" />
		<ai:col title="类型" fieldname="SALE_FLAG" width="15%" />
		<ai:col title="细分市场" fieldname="MARKET_TYPE" width="15%" />
		<ai:col title="网龄" fieldname="NET_AGE" width="15%" />
		<ai:col title="创建时间" fieldname="CREATE_TIME" width="17%" />
	</ai:table>
</ai:contractframe>

<ai:contractframe id="tagDetailframe" contenttype="table" title="需要开发备用标签" width="100%" allowcontract="true" frameclosed="false" >
	<ai:contractitem/>
	<ai:table setname="com.asiainfo.sale.tag.web.SETPromationTag"
			  tableid="detailTagTab" editable="false" width="100%" 
			  needrefresh="true" initial="false" height = "100"
			  tablemodel="com.ai.appframe2.web.datamodel.MethodModelForService"
			  implservice_name="com.asiainfo.sale.weapon.service.interfaces.ISaleWeaponSV"
			  implservice_querymethod="getSpareTagDetailByWeaponId(String weaponId)"			  
			  operator="query">
		<table width="98%" align="center" border="0" cellpadding="1" cellspacing="1">
	        <tr>
	       		<td align = "left"><ai:col fieldname="WPID" width="220" editable="false" visible="true" /> </td>
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
	           	<td class="td_font">给出建议：</td>
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
var taskTag = "w04";
var weaponId = -1;
var taskState = "runing";
var _tableTagDetailRowSet = g_TableRowSetManager.get("detailTagTab");
var weaponRs = g_TableRowSetManager.get("weaponMainListTable");
var weap = g_TableRowSetManager.get("weaponTable");
var rid = <%=recordId%>;
function initPage()
{
	if (rid == null){
		//weaponRs.refresh("&taskTag=" + taskTag);
	} else {
		weaponRs.refresh("&wid="+rid);
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
	var strUrl = '<%=request.getContextPath()%>/business/com.asiainfo.sale.weapon.web.SaleWeaponAction?action=finishTask&condition=' + condition;
	var recode = PostInfo(strUrl, null);
	alert("提交成功！");
	  location.reload();
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
