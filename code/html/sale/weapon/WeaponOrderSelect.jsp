<%@ page contentType="text/html; charset=GBK"%>
<%@ include file="/secframe/common/common.jsp"%>
<%@include file="/webframe/common/commonhead.jsp"%>
<html>
<head>
<title>武器</title>
<script language="javascript" src="<%=request.getContextPath()%>/jsv2/Calendar.jsp" type="text/javascript"></script>
</head>
<body>
<ai:contractframe id="weaponMainSelectframe" contenttype="table" title="武器订单查询" width="100%" allowcontract="false" frameclosed="fale">
	<ai:contractitem/>
	<ai:dbform formid="weaponMainSelectForm" setname="com.asiainfo.sale.weapon.web.SETSaleWeaponMain" initial="false">
		<table width="98%" align="center" border="0" cellpadding="1" cellspacing="2">
			<tr>
	           	<td class="td_font">武器订单名称：</td>
	           	<td><ai:dbformfield formid="weaponMainSelectForm" fieldname="WEAPON_NAME" width="150"/></td>           	
	           	<td class="td_font">申请人：</td>
	           	<td><ai:dbformfield formid="weaponMainSelectForm" fieldname="APPLICANT" width="150"/><img id="selectStaff" border="0" src="<%=request.getContextPath()%>/webframe/images/query.gif" onClick="selectStaff();" align="absmiddle" style="cursor:hand;"/></td>	
	           	<td class="td_font">申请单位：</td>
	           	<td><ai:dbformfield formid="weaponMainSelectForm" fieldname="ORG" width="130"/><img id="selectOrgType" border="0" src="<%=request.getContextPath()%>/webframe/images/query.gif"  alt="" onClick="selectOrgType();" align="absmiddle" style="cursor:hand;"/></td>	
			</tr>
			<tr>
	           	<td class="td_font">当前环节：</td>
	           	<td><ai:dbformfield formid="weaponMainSelectForm" fieldname="REMARK1" width="150"/></td>           	
	           	<td class="td_font">当前状态：</td>
	           	<td><ai:dbformfield formid="weaponMainSelectForm" fieldname="REMARK2" width="150"/></td> 
	           	<td class="td_button">
	           		<ai:button id="queryWeapon" text="查询" onclick="queryWeaponMain()"/>
	           	</td>
			</tr>
		</table>
	</ai:dbform>
</ai:contractframe>
<ai:contractframe id="weaponMainListframe" contenttype="table" title="武器订单信息" width="100%" allowcontract="false" frameclosed="fale">
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
		<ai:col title="编号" fieldname="ID" width="10%" />
		<ai:col title="申请人" fieldname="APPLICANT" width="15%" />
		<ai:col title="申请单位" fieldname="ORG" width="15%" />
	</ai:table>
</ai:contractframe>
<!--<ai:contractframe id="weaponMainInfoframe" contenttype="table" title="武器订单查询" width="100%" allowcontract="false" frameclosed="false">
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
	           	<td class="td_font">武器订单名称：</td>
	           	<td><ai:dbformfield formid="weaponMainInfoForm" fieldname="NAME" width="150"/></td>           	
	           	<td class="td_font">申请人：</td>
	           	<td><ai:dbformfield formid="weaponMainInfoForm" fieldname="APPLICANT" width="150"/></td>	
	           	<td class="td_font">申请单位：</td>
	           	<td><ai:dbformfield formid="weaponMainInfoForm" fieldname="ORG" width="150"/></td>	
			</tr>
		</table>
	</ai:dbform>
</ai:contractframe>-->
<ai:contractframe id="weaponListframe" contenttype="table" title="武器详情" width="100%" allowcontract="false" frameclosed="fale" >
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
	           	<td><ai:dbformfield formid="weaponInfoForm" fieldname="L_LIMIT"/></td>
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
	           	<td><ai:dbformfield formid="weaponInfoForm" fieldname="CREATE_TIME" editable="false"/></td>	
			</tr>
		</table>
	</ai:dbform>
</ai:contractframe>

	

              <div class="area_button">
                    <ai:button  text="sec.modify" i18nRes="i18n.secframe_resource" id="updateBtn" onclick="update()"/>
                    <ai:button  text="sec.add" i18nRes="i18n.secframe_resource" id="addBtn" onclick="addWeaponMain()"/>
                    <ai:button  text="sec.save" i18nRes="i18n.secframe_resource" id="saveBtn" onclick="save()"/>
                    <ai:button  text="sec.delete" i18nRes="i18n.secframe_resource" id="delBtn" onclick="del()"/>
                  </div>
<!--<ai:contractframe id="flowframe" contenttype="table" title="审批详情" width="100%" allowcontract="false" frameclosed="fale" >
	<ai:contractitem/>
	<ai:dbform formid="weaponInfoForm" 
		setname="com.asiainfo.sale.weapon.web.SETSaleWeaponMain" initial="false"
						conditionname="condition" parametersname="parameters"
						onvalchange="" editable="true"
						datamodel="com.ai.appframe2.web.datamodel.MethodModelForService"
						implservice_name="com.asiainfo.sale.weapon.service.interfaces.ISaleWeaponSV"
						implservice_querymethod="getSaleWeaponByMainId(int mainId, int $STARTROWINDEX, int $ENDROWINDEX)">
		<table width="98%" align="center" border="0" cellpadding="1" cellspacing="2">
			<tr>
	           	<td class="td_font">编号：</td>
	           	<td><ai:dbformfield formid="weaponInfoForm" fieldname="ID" editable="false"/></td>
	           	<td class="td_font">名称：</td>
	           	<td><ai:dbformfield formid="weaponInfoForm" fieldname="NAME" editable="false"/></td>
			</tr>
			<tr>
	           	<td class="td_font">细分市场：</td>
	           	<td><ai:dbformfield formid="weaponInfoForm" fieldname="MARKET_TYPE" editable="false"/></td>
	           	<td class="td_font">网龄：</td>
	           	<td><ai:dbformfield formid="weaponInfoForm" fieldname="NET_AGE" editable="false"/></td>
	        </tr>
		</table>
	</ai:dbform>
</ai:contractframe>-->
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
	document.getElementById("updateBtn").disabled = true;
    document.getElementById("addBtn").disabled = true;
    document.getElementById("saveBtn").disabled = false;
    document.getElementById("delBtn").disabled = true;
     var weaponInfoForm = g_FormRowSetManager.get("weaponInfoForm");
    weaponInfoForm.setEditSts(true);
    weaponInfoForm.setValue("NAME","");
    weaponInfoForm.setValue("NET_AGE","");
    weaponInfoForm.setValue("L_LIMIT","");
    weaponInfoForm.setValue("BASE_MONTH","");
    weaponInfoForm.setValue("PRESENT_PERMON","");
    weaponInfoForm.setValue("PRESENT_MONTH","");
    weaponInfoForm.setValue("P_LIMIT","");
    weaponInfoForm.setValue("COUPONS_VALUE","");
       weaponInfoForm.setValue("SELF_BUSI","");
          weaponInfoForm.setValue("DIRECTORY","");
      
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