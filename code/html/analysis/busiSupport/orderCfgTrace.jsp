<%@ page contentType="text/html; charset=GBK"%>
<%@ include file="/secframe/common/common.jsp"%>
<%@include file="/webframe/common/commonhead.jsp"%>

<html>
<head>
<title><i18n:message key="���ù�����ϸ�嵥"/></title>
<script language="javascript" src="<%=request.getContextPath()%>/jsv2/Calendar.jsp" type="text/javascript"></script>
</head>
<body onload="initPage();">
<ai:contractframe id="queryframe" contenttype="table" title="��ѯ����" width="100%" allowcontract="false" frameclosed="false">
<ai:contractitem/>
<ai:dbform formid="queryForm" 
			setname="com.asiainfo.bi.web.SETBusiSupport"
			conditionname="condition" parametersname="parameters"
			onvalchange="" editable="true" initial="false" onvalchange="onOrderTypeChange"
			datamodel="com.ai.appframe2.web.datamodel.MethodModelForService"
			implservice_name="com.asiainfo.bi.service.interfaces.IBusiSupportSV"
			implservice_querymethod="getStatisticsINBusiSu(String dispatchTimeF,String dispatchTimeTo)">
		<table width="98%" align="center" border="0" cellpadding="1" cellspacing="2">
		    <tr>
		    	<td class="td_font">�������ͣ�</td>
		    	<td><ai:dbformfield formid="queryForm" fieldname="ITEMTYPE" width="150"/></td>
		    	<td class="td_font">�����ˣ�</td>
		    	<td><ai:dbformfield formid="queryForm" fieldname="STAFF_NAME" width="150"/></td>
		    </tr><tr>
				<td class="td_font">�������ʱ�䣨�ӣ���</td>
		        <td><ai:dbformfield formid="queryForm" fieldname="DISPATCHF" width="150"/></td>
		        <td class="td_font">�������ʱ�䣨��������</td>
	           	<td><ai:dbformfield formid="queryForm" fieldname="DISPATCHT" width="150"/>
	           		<ai:button text="��ѯ" onclick="query()"/></td>
			</tr>
		</table>
	</ai:dbform>
</ai:contractframe>

<ai:contractframe id="itemInfoframe" contenttype="table" title="�����������" width="100%" allowcontract="false" frameclosed="false">
<ai:contractitem/>
<ai:table tableid="orderCfgTraceTab" setname="com.asiainfo.bi.web.SETOrderCfgTrace" height="500" multiselect="false" oncellchange="" editable="false" 
	needrefresh="true" pagesize="500" initial="false" 
	width="100%" tablemodel="com.ai.appframe2.web.datamodel.MethodModelForService"
	implservice_name="com.asiainfo.bi.service.interfaces.IOrderCfgTraceSV"
	implservice_querymethod="getOrderCfgInfo(String orderType,
			String cfgStaff, String startTime, String endTime, int $STARTROWINDEX,int $ENDROWINDEX)"
	implservice_countmethod="getOrderCfgCn(String orderType,
			String cfgStaff, String startTime, String endTime)">
		 <ai:col title="������" fieldname="ORDER_ID" width="60"/>
		 <ai:col title="��������" fieldname="ORDER_NAME" width="290"/>
		 <ai:col title="������" fieldname="APPLY_STAFF" width="70"/>
		 <ai:col title="���벿��" fieldname="ORGANIZE_NAME" width="90"/>
		 <ai:col title="�ʷ����α��" fieldname="PC_ID" width="100" visible="false"/>
		 <ai:col title="�ʷ���������" fieldname="PC_NAME" width="100" visible="false"/>
		 <ai:col title="��������" fieldname="DC_NAME" width="290" />
		 <ai:col title="����BOSS����" fieldname="DC_CODE" width="150" />
		 <ai:col title="������Ա" fieldname="CFG_STAFF" width="90"/>
		 <ai:col title="�������ʱ��" fieldname="FINISH_DATE" width="100" />
</ai:table>
</ai:contractframe>
</body>
<script type="text/javascript">
var queryForm = g_FormRowSetManager.get("queryForm");
var orderCfgTraceTab = g_TableRowSetManager.get("orderCfgTraceTab");
function initPage(){
	queryForm.setValue("itemType","weapon");
}

function onOrderTypeChange(pFieldName,pOldVal,pOldText,pNewVal,pNewText){
	
	if (pFieldName == 'ITEMTYPE'){
		if(pOldText !="charge" && pOldText != "weapon") {
			queryForm.setValue("itemType","weapon");
		}
	}
}

function query() {
	var itemType = queryForm.getValue("ITEMTYPE");
	var dealP = queryForm.getValue("STAFF_NAME");
	var dispatchTimeF = queryForm.getValue("DISPATCHF");
	var dispatchTimeT = queryForm.getValue("DISPATCHT");
	if(itemType !="charge" && itemType != "weapon") {
		return alert("����ֻ֧���������ʷѲ�ѯ��");
	}
	orderCfgTraceTab.refresh("&orderType=" + itemType + "&cfgStaff=" + encodeURI(trim(dealP)) + "&startTime=" + dispatchTimeF + "&endTime=" + dispatchTimeT);
}

function trim(str)
{
     return str.replace(/(^\s*)|(\s*$)/g, '');
}
</script>
</html>