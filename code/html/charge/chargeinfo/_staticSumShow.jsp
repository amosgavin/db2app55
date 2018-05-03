<%@ page contentType="text/html; charset=GBK"%>
<%@include file="/webframe/common/commonhead.jsp"%>
<html>
<body onload="_staticSumInit()"> 
<ai:contractframe id="_staticSumShowFrame" contenttype="table" title="静态损益测算（存量用户转资费后不考虑业务量激发情况下的损益测算）" width="100%" allowcontract="true" frameclosed="false">
<ai:contractitem/>
	<ai:dbform formid="_staticSumShowForm" 
			setname="com.asiainfo.charge.web.SETChargeStaticSum"
			conditionname="condition" parametersname="parameters"
			onvalchange="" editable="false" initial="false"
			datamodel="com.ai.appframe2.web.datamodel.MethodModelForService"
			implservice_name="com.asiainfo.charge.service.interfaces.IChargeStaticSumSV"
			implservice_querymethod="getStaticSumCount(String grandId)">
		<table width="98%" align="center" border="0" cellpadding="1" cellspacing="1">
			<tr>
	           	<td>存量转资费用户数：<ai:dbformfield formid="_staticSumShowForm" fieldname="SWITCH_USER" width="150" editable="false"/></td>
			</tr>
		</table>
	</ai:dbform>
	<ai:table
		tableid="_staticSumShowTable"
		setname="com.asiainfo.charge.web.SETChargeStaticSum"
		tablemodel="com.ai.appframe2.web.datamodel.MethodModelForService"
		implservice_name="com.asiainfo.charge.service.interfaces.IChargeStaticSumSV"
		implservice_querymethod="getStaticSumByGrandId(String grandId)"
		initial="false" pagesize="13" editable="false" width="100%"
		height="261" needrefresh="true" footdisplay ="none">
			<ai:col fieldname="ITEM" width="150" />
			<ai:col fieldname="BEFORE_CHANGE" width="100" />
			<ai:col fieldname="AFTER_CHANGE" width="100" />
			<ai:col fieldname="SWITCH_USER" width="180" visible="false"/>
			<ai:col fieldname="FLUCTUATE" width="150" />
			<ai:col fieldname="USER_CHANGE" width="100" />
			<ai:col fieldname="SUM_CHANGE" width="100" />
	</ai:table>
</ai:contractframe>
</body>
<script type="text/javascript">

function _staticSumInit(){
	
	var grandId =_fromChargeMainDeFormRowSet.getValue("MID");
	var _staticSumForm = g_FormRowSetManager.get("_staticSumShowForm");
	var _staticSumTableRowSet = g_TableRowSetManager.get("_staticSumShowTable");
	_staticSumTableRowSet.refresh("&grandId=" + grandId);
	_staticSumForm.setValue("SWITCH_USER",_staticSumTableRowSet.getValue(1, "SWITCH_USER"));
}
</script> 
</html>
