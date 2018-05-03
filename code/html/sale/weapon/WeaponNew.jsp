<%@ page contentType="text/html; charset=GBK"%>
<%@ include file="/secframe/common/common.jsp"%>
<%@include file="/webframe/common/commonhead.jsp"%>
<html>
<head>
<title>������</title>
<script language="javascript" src="<%=request.getContextPath()%>/jsv2/Calendar.jsp" type="text/javascript"></script>
</head>
<body>
<ai:contractframe id="weaponMainSelectframe" contenttype="table" title="����������Ҫ��Ϣ" width="100%" allowcontract="true" frameclosed="fale">
	<ai:contractitem/>
	<ai:dbform formid="weaponMainSelectForm" setname="com.asiainfo.sale.weapon.web.SETSaleWeaponMain" initial="false">
		<table width="98%" align="center" border="0" cellpadding="1" cellspacing="2">
			<tr>
	           	<td class="td_font">�����������ƣ�</td>
	           	<td><ai:dbformfield formid="weaponMainSelectForm" fieldname="WEAPON_NAME" width="150"/></td>        	
	           	<td class="td_font">�����ˣ�</td>
	           	<td><ai:dbformfield formid="weaponMainSelectForm" fieldname="APPLICANT" width="150" editable="false"/></td>
	           	<td class="td_font">���뵥λ��</td>
	           	<td><ai:dbformfield formid="weaponMainSelectForm" fieldname="ORG" width="130" editable="false"/></td>
			</tr>
			<tr>
	           	<td class="td_font">˵����</td>
	           	<td colspan="5"><ai:dbformfield formid="weaponMainSelectForm" fieldname="WEAPON_NAME" width="600"/>
	           	<ai:button id="newWeapon" text="��һ��" onclick="newWeapon()"/></td>
			</tr>
		</table>
	</ai:dbform>
</ai:contractframe>
<ai:contractframe id="weaponListframe" contenttype="table" title="��������" width="100%" allowcontract="true" frameclosed="false" >
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
	           	<td class="td_font">��ţ�</td>
	           	<td><ai:dbformfield formid="weaponInfoForm" fieldname="WEAPONID" editable="false"/></td>
	           	<td class="td_font">���ƣ�</td>
	           	<td><ai:dbformfield formid="weaponInfoForm" fieldname="NAME"/></td>
			</tr>
			<tr>
	           	<td class="td_font">ϸ���г���</td>
	           	<td><ai:dbformfield formid="weaponInfoForm" fieldname="MARKET_TYPE"/></td>
	           	<td class="td_font">���䣺</td>
	           	<td><ai:dbformfield formid="weaponInfoForm" fieldname="NET_AGE"/></td>
	        </tr>
			<tr>
	           	<td class="td_font">������ȣ�</td>
	           	<td><ai:dbformfield formid="weaponInfoForm" fieldname="L_LIMIT" /></td>
	           	<td class="td_font">�����·ݣ�</td>
	           	<td><ai:dbformfield formid="weaponInfoForm" fieldname="BASE_MONTH"/></td>
			</tr>
			<tr>
	           	<td class="td_font">ÿ�����ͣ�</td>
	           	<td><ai:dbformfield formid="weaponInfoForm" fieldname="PRESENT_PERMON"/></td>
	           	<td class="td_font">�����·ݣ�</td>
	           	<td><ai:dbformfield formid="weaponInfoForm" fieldname="PRESENT_MONTH"/></td>
			</tr>
			<tr>
	           	<td class="td_font">���Ͷ�ȣ�</td>
	           	<td><ai:dbformfield formid="weaponInfoForm" fieldname="P_LIMIT"/></td>
	           	<td class="td_font">֧��ȯ��</td>
	           	<td><ai:dbformfield formid="weaponInfoForm" fieldname="COUPONS_VALUE"/></td>	
			</tr>
			<tr>
	           	<td class="td_font">����ҵ��</td>
	           	<td><ai:dbformfield formid="weaponInfoForm" fieldname="SELF_BUSI"/></td>	
	           	<td class="td_font">��Ʒ�ɹ�Ŀ¼��</td>
	           	<td><ai:dbformfield formid="weaponInfoForm" fieldname="DIRECTORY"/></td>	
			</tr>
			<tr>
	           	<td class="td_font">����ʱ�䣺</td>
	           	<td><ai:dbformfield formid="weaponInfoForm" fieldname="CREATE_TIME"/></td>	
			</tr>
		</table>
	</ai:dbform>
</ai:contractframe>
<table>
<tr>
	           	<td class="td_button">
	           		<ai:button id="queryWeapon" text="����" onclick="queryWeaponMain()"/>
	           	</td>
	           	<td class="td_button">
	           		<ai:button id="queryWeapon" text="�ύ" onclick="queryWeaponMain()"/>
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
