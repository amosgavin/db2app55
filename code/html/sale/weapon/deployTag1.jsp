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
<ai:contractframe id="weaponListframe" contenttype="table" title="������Ϣ" width="100%" allowcontract="false" frameclosed="fale" >
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
		<ai:col title="���" fieldname="WID" width="100" />
		<ai:col title="���" fieldname="SALE_FLAG" width="150" />
		<ai:col title="����" fieldname="WEAPON_NAME" width="200" />
		<ai:col title="ϸ���г�" fieldname="MARKET_TYPE" width="100" />
		<ai:col title="����״̬" fieldname="TLABEL" width="130" />
		<ai:col title="��������" fieldname="WLABEL" width="150" />
		<ai:col title="����ʱ��" fieldname="CREATE_DATE" width="150" />
		<ai:col title="����״̬" fieldname="TASK_TAG" width="100"/>
	</ai:table>
</ai:contractframe>

<ai:contractframe id="tagDetailframe" contenttype="table" title="��Ҫ�������ñ�ǩ" width="100%" allowcontract="true" frameclosed="false" >
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
	       		<td align = "left"><ai:col fieldname="ID" width="200" editable="false" visible="true" /> </td>
	        	<td align = "left"><ai:col fieldname="TAG_TYPE" width="200" editable="false" visible="true" /> </td>
				<td align = "left"><ai:col fieldname="NAME" width="250" editable="false" visible="true" /> </td>
				<td align = "left"><ai:col fieldname="CHARGE" width="200" editable="false" visible="true"/> </td>
				<td align = "left"><ai:col fieldname="CYCLE" width="200" editable="false" visible="true"/> </td>
			</tr>
		</table>
	</ai:table>
	<ai:dbform formid="weaponForm" setname="com.asiainfo.sale.weapon.web.SETSaleWeapon" 
		initial="false" editable="false" datamodel="com.ai.appframe2.web.datamodel.MethodModelForService"
		implservice_name="com.asiainfo.sale.weapon.service.interfaces.ISaleWeaponSV"
		implservice_querymethod="getSaleWeaponByID(int wid, int $STARTROWINDEX, int $ENDROWINDEX)">
		<table width="98%" align="center" border="0" cellpadding="1" cellspacing="1">
	          <tr><td class="td_font">�������ʱ�䣺</td>
	           	<td><ai:dbformfield formid="weaponForm" fieldname="SUGGEST_DATE" width="170"/></td>
	          </tr>
	      </table>
	</ai:dbform>
</ai:contractframe>	

<ai:contractframe id="reasonframe" contenttype="table" title="�������������" width="100%" height="20" allowcontract="true" frameclosed="true" >
<ai:contractitem/>
<%@ include file="/main3/include/reasonlist.jsp" %>
</ai:contractframe>

<ai:contractframe id="tagApproveframe" contenttype="table" title="��ǩ������Ϣ" width="100%" allowcontract="true" frameclosed="false">
	<ai:contractitem/>
	<ai:dbform formid="approveForm" 
			setname="com.asiainfo.sale.tag.web.SETApproveColumn"
			conditionname="condition" parametersname="parameters"
			onvalchange="" editable="true" initial="false"
			datamodel="com.ai.appframe2.web.datamodel.MethodModelForService">
		<table width="98%" align="center" border="0" cellpadding="1" cellspacing="1">
			<tr>
	           	<td class="td_font">���������</td>
	           	<td><ai:dbformfield formid="approveForm" fieldname="ADVISE" width="600" height="160"/></td>
			</tr><tr>
				<td class="td_font"></td>
				<td><ai:button id="submit" text="�ύ" onclick="commit()"/></td>
			</tr>
		</table>
	</ai:dbform>
</ai:contractframe>
<ai:loginuser/>
<script type="text/javascript">
var taskId = 0;
var taskTag = "w05";
var weaponId = -1;
var taskState = "runing";
var _tableTagDetailRowSet = g_TableRowSetManager.get("detailTagTab");
var weaponRs = g_TableRowSetManager.get("weaponMainListTable");
var weap = g_FormRowSetManager.get("weaponForm");
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
{   alert(condition);
	var id = g_FormRowSetManager.get("approveForm").getValue("ID");
	var reason = g_FormRowSetManager.get("approveForm").getValue("ADVISE");
	//var staffId = document.getElementById("staffId").value;
	var condition = "&id=" + id + "&reason=" + trim(reason) + "&weaponId=" + weaponId + "&taskState=" + taskState;
	alert(condition);
	var strUrl = '<%=request.getContextPath()%>/business/com.asiainfo.sale.weapon.web.SaleWeaponAction?action=finishTask&condition=' + condition;
	var recode = PostInfo(strUrl, null);
	alert("�ύ�ɹ���");
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
