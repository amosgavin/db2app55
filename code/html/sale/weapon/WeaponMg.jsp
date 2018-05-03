<%@ page contentType="text/html; charset=GBK"%>
<%@ include file="/secframe/common/common.jsp"%>
<%@include file="/webframe/common/commonhead.jsp"%>
<html>
<head>
<title>������Ϣ</title>
<script language="javascript" src="<%=request.getContextPath()%>/jsv2/Calendar.jsp" type="text/javascript"></script>
</head>
<body>
<ai:contractframe id="weaponMainSelectframe" contenttype="table" title="����������ѯ" width="100%" allowcontract="false" frameclosed="fale">
	<ai:contractitem/>
	<ai:dbform formid="weaponMainSelectForm" setname="com.asiainfo.sale.weapon.web.SETSaleWeaponMain" initial="false">
		<table width="98%" align="center" border="0" cellpadding="1" cellspacing="2">
			<tr>
	           	<td class="td_font">�����������ƣ�</td>
	           	<td><ai:dbformfield formid="weaponMainSelectForm" fieldname="WEAPON_NAME" width="150"/></td>           	
	           	<td class="td_font">�����ˣ�</td>
	           	<td><ai:dbformfield formid="weaponMainSelectForm" fieldname="APPLICANT" width="150"/><img id="selectStaff" border="0" src="<%=request.getContextPath()%>/webframe/images/query.gif" onClick="selectStaff();" align="absmiddle" style="cursor:hand;"/></td>	
	           	<td class="td_font">���뵥λ��</td>
	           	<td><ai:dbformfield formid="weaponMainSelectForm" fieldname="ORG" width="130"/><img id="selectOrgType" border="0" src="<%=request.getContextPath()%>/webframe/images/query.gif"  alt="" onClick="selectOrgType();" align="absmiddle" style="cursor:hand;"/></td>	
	           	<td class="td_button">
	           		<ai:button id="queryWeapon" text="��ѯ" onclick="queryWeaponMain()"/>
	           	</td>
			</tr>
		</table>
	</ai:dbform>
</ai:contractframe>
<ai:contractframe id="weaponMainListframe" contenttype="table" title="����������Ϣ" width="100%" allowcontract="false" frameclosed="fale">
	<ai:contractitem/>
 	<ai:table
		tableid="weaponMainListTable"
		setname="com.asiainfo.sale.weapon.web.SETSaleWeaponMain"
		tablemodel="com.ai.appframe2.web.datamodel.MethodModelForService"
		implservice_name="com.asiainfo.sale.weapon.service.interfaces.ISaleWeaponMainSV"
		implservice_querymethod="getSaleWeaponMain(String name, String applicant, String org, int $STARTROWINDEX, int $ENDROWINDEX)"
		implservice_countmethod="getCount(String name, String applicant, String org)"
		ondbclick="showWeaponInfo"
		initial="false" pagesize="15" editable="false" width="100%"
		height="150" needrefresh="true">
		<ai:col title="���" fieldname="ID" width="10%" />
		<ai:col title="����" fieldname="NAME" width="15%" />
		<ai:col title="������" fieldname="APPLICANT" width="15%" />
		<ai:col title="���뵥λ" fieldname="ORG" width="15%" />
		<ai:col title="����ʱ��" fieldname="CREATE_TIME" width="20%" />
		<ai:col title="����ʱ��" fieldname="OPT_TIME" visible="false" />
	</ai:table>
</ai:contractframe>
<!--<ai:contractframe id="weaponMainInfoframe" contenttype="table" title="����������ѯ" width="100%" allowcontract="false" frameclosed="false">
	<ai:contractitem/>
	<ai:dbform formid="weaponMainInfoForm" 
						setname="com.asiainfo.sale.weapon.web.SETSaleWeaponMain"
						conditionname="condition" parametersname="parameters"
						onvalchange="" editable="true"
						datamodel="com.ai.appframe2.web.datamodel.MethodModelForService"
						implservice_name="com.asiainfo.sale.weapon.service.interfaces.ISaleWeaponMainSV"
						implservice_querymethod="getSaleWeaponMainById(String id, int $STARTROWINDEX, int $ENDROWINDEX)">
		<table width="98%" align="center" border="0" cellpadding="1" cellspacing="2">
			<tr>
	           	<td class="td_font">�����������ƣ�</td>
	           	<td><ai:dbformfield formid="weaponMainInfoForm" fieldname="NAME" width="150"/></td>           	
	           	<td class="td_font">�����ˣ�</td>
	           	<td><ai:dbformfield formid="weaponMainInfoForm" fieldname="APPLICANT" width="150"/></td>	
	           	<td class="td_font">���뵥λ��</td>
	           	<td><ai:dbformfield formid="weaponMainInfoForm" fieldname="ORG" width="150"/></td>	
			</tr>
		</table>
	</ai:dbform>
</ai:contractframe>-->
<ai:contractframe id="weaponListframe" contenttype="table" title="��������" width="100%" allowcontract="false" frameclosed="fale" >
	<ai:contractitem/>
	<ai:dbform formid="weaponInfoForm" 
		setname="com.asiainfo.sale.weapon.web.SETSaleWeaponMain" initial="false"
						conditionname="condition" parametersname="parameters"
						onvalchange="" editable="true"
						datamodel="com.ai.appframe2.web.datamodel.MethodModelForService"
						implservice_name="com.asiainfo.sale.weapon.service.interfaces.ISaleWeaponSV"
						implservice_querymethod="getSaleWeaponByMainId(String mainId, int $STARTROWINDEX, int $ENDROWINDEX)">
		<table width="98%" align="center" border="0" cellpadding="1" cellspacing="2">
			<tr>
	           	<td class="td_font">��ţ�</td>
	           	<td><ai:dbformfield formid="weaponInfoForm" fieldname="ID" editable="false"/></td>
	           	<td class="td_font">���ƣ�</td>
	           	<td><ai:dbformfield formid="weaponInfoForm" fieldname="NAME" editable="false"/></td>
			</tr>
			<tr>
	           	<td class="td_font">ϸ���г���</td>
	           	<td><ai:dbformfield formid="weaponInfoForm" fieldname="MARKET_TYPE" editable="false"/></td>
	           	<td class="td_font">���䣺</td>
	           	<td><ai:dbformfield formid="weaponInfoForm" fieldname="NET_AGE" editable="false"/></td>
	        </tr>
			<tr>
	           	<td class="td_font">������ȣ�</td>
	           	<td><ai:dbformfield formid="weaponInfoForm" fieldname="L_LIMIT" editable="false"/></td>
	           	<td class="td_font">�����·ݣ�</td>
	           	<td><ai:dbformfield formid="weaponInfoForm" fieldname="BASE_MONTH" editable="false"/></td>
			</tr>
			<tr>
	           	<td class="td_font">ÿ�����ͣ�</td>
	           	<td><ai:dbformfield formid="weaponInfoForm" fieldname="PRESENT_PERMON" editable="false"/></td>
	           	<td class="td_font">�����·ݣ�</td>
	           	<td><ai:dbformfield formid="weaponInfoForm" fieldname="PRESENT_MONTH" editable="false"/></td>
			</tr>
			<tr>
	           	<td class="td_font">���Ͷ�ȣ�</td>
	           	<td><ai:dbformfield formid="weaponInfoForm" fieldname="P_LIMIT" editable="false"/></td>
	           	<td class="td_font">���ƣ�</td>
	           	<td><ai:dbformfield formid="weaponInfoForm" fieldname="NAME" editable="false"/></td>
			</tr>
			<tr>
	           	<td class="td_font">����ҵ��</td>
	           	<td><ai:dbformfield formid="weaponInfoForm" fieldname="SELF_BUSI"/></td>	
	           	<td class="td_font">��Ʒ�ɹ�Ŀ¼��</td>
	           	<td><ai:dbformfield formid="weaponInfoForm" fieldname="DIRECTORY"/></td>	
			</tr>
			<tr>
	           	<td class="td_font">֧��ȯ��</td>
	           	<td><ai:dbformfield formid="weaponInfoForm" fieldname="COUPONS_VALUE"/></td>	
	           	<td class="td_font">����ʱ�䣺</td>
	           	<td><ai:dbformfield formid="weaponInfoForm" fieldname="CREATE_TIME"/></td>	
			</tr>
		</table>
	</ai:dbform>
</ai:contractframe>
<ai:contractframe id="flowframe" contenttype="table" title="��������" width="100%" allowcontract="false" frameclosed="fale" >
	<ai:contractitem/>
	<ai:dbform formid="weaponInfoForm" 
		setname="com.asiainfo.sale.weapon.web.SETSaleWeaponMain" initial="false"
						conditionname="condition" parametersname="parameters"
						onvalchange="" editable="true"
						datamodel="com.ai.appframe2.web.datamodel.MethodModelForService"
						implservice_name="com.asiainfo.sale.weapon.service.interfaces.ISaleWeaponSV"
						implservice_querymethod="getSaleWeaponByMainId(String mainId, int $STARTROWINDEX, int $ENDROWINDEX)">
		<table width="98%" align="center" border="0" cellpadding="1" cellspacing="2">
			<tr>
	           	<td class="td_font">��ţ�</td>
	           	<td><ai:dbformfield formid="weaponInfoForm" fieldname="ID" editable="false"/></td>
	           	<td class="td_font">���ƣ�</td>
	           	<td><ai:dbformfield formid="weaponInfoForm" fieldname="NAME" editable="false"/></td>
			</tr>
			<tr>
	           	<td class="td_font">ϸ���г���</td>
	           	<td><ai:dbformfield formid="weaponInfoForm" fieldname="MARKET_TYPE" editable="false"/></td>
	           	<td class="td_font">���䣺</td>
	           	<td><ai:dbformfield formid="weaponInfoForm" fieldname="NET_AGE" editable="false"/></td>
	        </tr>
		</table>
	</ai:dbform>
</ai:contractframe>
</body>
</html>

<script type="text/javascript">
function queryWeaponMain()
{
	var weaponQueryForm = g_FormRowSetManager.get("weaponMainSelectForm");
	var weaponInfoTable = g_TableRowSetManager.get("weaponMainListTable");
	var weaponName = weaponQueryForm.getValue("WEAPON_NAME");
	var applicant = weaponQueryForm.getValue("APPLICANT");
	var org = weaponQueryForm.getValue("ORG");
	var param = "name=" + weaponName + "&applicant=" + applicant + "&org=" + org;
	
    weaponInfoTable.refresh(param);
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

function selectOrgType()
{
	var url = "<%=request.getContextPath()%>/secframe/orgmodel/organize/OrgTypeTree.jsp";
	var result = window.showModalDialog(url,"org","scroll:no;resizable:no;status:no;dialogHeight:460px;dialogWidth:300px");
	if(result=='undefined'||result==null){
		result="";
	} else {
		g_FormRowSetManager.get("weaponMainSelectForm").setValue("ORG",result);	
	}
}

function selectStaff()
{
	var url = "<%=request.getContextPath()%>/secframe/orgmodel/operator/StaffSelect.jsp";
	var result = window.showModalDialog(url, null, "scroll:no;resizable:no;help:no;status:no;dialogHeight:600px;dialogWidth:320px");
	if(result=='undefined'||result==null){
		result="";
	} else {
		g_FormRowSetManager.get("weaponMainSelectForm").setValue("APPLICANT", result); 
	}
} 
</script>