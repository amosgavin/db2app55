<%@ page contentType="text/html; charset=GBK"%>
<%@ include file="/secframe/common/common.jsp"%>
<%@include file="/webframe/common/commonhead.jsp"%>
<html>
<head>
<title>新武器</title>
<script language="javascript" src="<%=request.getContextPath()%>/jsv2/Calendar.jsp" type="text/javascript"></script>
</head>
<body>
<ai:contractframe id="weaponMainSelectframe" contenttype="table" title="武器订单主要信息" width="100%" allowcontract="true" frameclosed="fale">
	<ai:contractitem/>
	<ai:dbform formid="weaponMainSelectForm" setname="com.asiainfo.sale.weapon.web.SETSaleWeaponMain" initial="false">
		<table width="98%" align="center" border="0" cellpadding="1" cellspacing="2">
			<tr>
	           	<td class="td_font">武器订单名称：</td>
	           	<td><ai:dbformfield formid="weaponMainSelectForm" fieldname="WEAPON_NAME" width="150"/></td>        	
	           	<td class="td_font">申请人：</td>
	           	<td><ai:dbformfield formid="weaponMainSelectForm" fieldname="APPLICANT" width="150" editable="false"/></td>
	           	<td class="td_font">申请单位：</td>
	           	<td><ai:dbformfield formid="weaponMainSelectForm" fieldname="ORG" width="130" editable="false"/></td>
			</tr>
			<tr>
	           	<td class="td_font">说明：</td>
	           	<td colspan="5"><ai:dbformfield formid="weaponMainSelectForm" fieldname="WEAPON_NAME" width="600"/>
	           	<ai:button id="newWeapon" text="下一步" onclick="newWeapon()"/></td>
			</tr>
		</table>
	</ai:dbform>
</ai:contractframe>
<ai:contractframe id="weaponListframe" contenttype="table" title="武器详情" width="100%" allowcontract="true" frameclosed="false" >
	<ai:contractitem/>
	<ai:dbform formid="weaponInfoForm" 
		setname="com.asiainfo.sale.weapon.web.SETSaleWeapon" initial="false"
						conditionname="condition" parametersname="parameters"
						onvalchange="" editable="false"
						datamodel="com.ai.appframe2.web.datamodel.MethodModelForService"
						implservice_name="com.asiainfo.sale.weapon.service.interfaces.ISaleWeaponSV"
						implservice_querymethod="getSaleWeaponByMainId(String mainId, int $STARTROWINDEX, int $ENDROWINDEX)">
		<table width="98%" align="center" border="0" cellpadding="1" cellspacing="2">
			<tr>
	           	<td class="td_font">编号：</td>
	           	<td><ai:dbformfield formid="weaponInfoForm" fieldname="WEAPONID" editable="false"/></td>
	           	<td class="td_font">名称：</td>
	           	<td><ai:dbformfield formid="weaponInfoForm" fieldname="NAME"/></td>
			</tr>
			<tr>
	           	<td class="td_font">细分市场：</td>
	           	<td><ai:dbformfield formid="weaponInfoForm" fieldname="MARKET_TYPE"/></td>
	           	<td class="td_font">网龄：</td>
	           	<td><ai:dbformfield formid="weaponInfoForm" fieldname="NET_AGE"/></td>
	        </tr>
			<tr>
	           	<td class="td_font">返还额度：</td>
	           	<td><ai:dbformfield formid="weaponInfoForm" fieldname="L_LIMIT" /></td>
	           	<td class="td_font">返还月份：</td>
	           	<td><ai:dbformfield formid="weaponInfoForm" fieldname="BASE_MONTH"/></td>
			</tr>
			<tr>
	           	<td class="td_font">每月赠送：</td>
	           	<td><ai:dbformfield formid="weaponInfoForm" fieldname="PRESENT_PERMON"/></td>
	           	<td class="td_font">赠送月份：</td>
	           	<td><ai:dbformfield formid="weaponInfoForm" fieldname="PRESENT_MONTH"/></td>
			</tr>
			<tr>
	           	<td class="td_font">赠送额度：</td>
	           	<td><ai:dbformfield formid="weaponInfoForm" fieldname="P_LIMIT"/></td>
	           	<td class="td_font">支付券面额：</td>
	           	<td><ai:dbformfield formid="weaponInfoForm" fieldname="COUPONS_VALUE"/></td>	
			</tr>
			<tr>
	           	<td class="td_font">自有业务：</td>
	           	<td><ai:dbformfield formid="weaponInfoForm" fieldname="SELF_BUSI"/></td>	
	           	<td class="td_font">货品采购目录：</td>
	           	<td><ai:dbformfield formid="weaponInfoForm" fieldname="DIRECTORY"/></td>	
			</tr>
			<tr>
	           	<td class="td_font">创建时间：</td>
	           	<td><ai:dbformfield formid="weaponInfoForm" fieldname="CREATE_TIME"/></td>	
			</tr>
		</table>
	</ai:dbform>
</ai:contractframe>
<table>
<tr>
	           	<td class="td_button">
	           		<ai:button id="queryWeapon" text="重置" onclick="queryWeaponMain()"/>
	           	</td>
	           	<td class="td_button">
	           		<ai:button id="queryWeapon" text="提交" onclick="queryWeaponMain()"/>
	           	</td>
			</tr>
		</table>
</body>
</html>
<ai:loginuser/>
<script type="text/javascript">
g_FormRowSetManager.get("weaponMainSelectForm").setValue("APPLICANT",g_GetUserInfo().STAFF_ID+"|"+g_GetUserInfo().STAFF_NAME);
g_FormRowSetManager.get("weaponMainSelectForm").setValue("ORG",g_GetUserInfo().ORG_ID+"|"+g_GetUserInfo().ORG_NAME);
function newWeapon()
{
	g_FormRowSetManager.get("weaponInfoForm").setEditSts(true);
}

function addWeaponMain()
{
	
}

function showWeaponInfo()
{
	var curRow = g_TableRowSetManager.get("weaponMainListTable").getRow();
	var mainId = g_TableRowSetManager.get("weaponMainListTable").getValue(curRow, "ID");
	g_FormRowSetManager.get("weaponInfoForm").refresh("&mainId=" + mainId);
} 
</script>
