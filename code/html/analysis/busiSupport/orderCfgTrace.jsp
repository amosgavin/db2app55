<%@ page contentType="text/html; charset=GBK"%>
<%@ include file="/secframe/common/common.jsp"%>
<%@include file="/webframe/common/commonhead.jsp"%>

<html>
<head>
<title><i18n:message key="配置工单明细清单"/></title>
<script language="javascript" src="<%=request.getContextPath()%>/jsv2/Calendar.jsp" type="text/javascript"></script>
</head>
<body onload="initPage();">
<ai:contractframe id="queryframe" contenttype="table" title="查询条件" width="100%" allowcontract="false" frameclosed="false">
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
		    	<td class="td_font">工单类型：</td>
		    	<td><ai:dbformfield formid="queryForm" fieldname="ITEMTYPE" width="150"/></td>
		    	<td class="td_font">配置人：</td>
		    	<td><ai:dbformfield formid="queryForm" fieldname="STAFF_NAME" width="150"/></td>
		    </tr><tr>
				<td class="td_font">配置完成时间（从）：</td>
		        <td><ai:dbformfield formid="queryForm" fieldname="DISPATCHF" width="150"/></td>
		        <td class="td_font">配置完成时间（截至）：</td>
	           	<td><ai:dbformfield formid="queryForm" fieldname="DISPATCHT" width="150"/>
	           		<ai:button text="查询" onclick="query()"/></td>
			</tr>
		</table>
	</ai:dbform>
</ai:contractframe>

<ai:contractframe id="itemInfoframe" contenttype="table" title="工单办理跟踪" width="100%" allowcontract="false" frameclosed="false">
<ai:contractitem/>
<ai:table tableid="orderCfgTraceTab" setname="com.asiainfo.bi.web.SETOrderCfgTrace" height="500" multiselect="false" oncellchange="" editable="false" 
	needrefresh="true" pagesize="500" initial="false" 
	width="100%" tablemodel="com.ai.appframe2.web.datamodel.MethodModelForService"
	implservice_name="com.asiainfo.bi.service.interfaces.IOrderCfgTraceSV"
	implservice_querymethod="getOrderCfgInfo(String orderType,
			String cfgStaff, String startTime, String endTime, int $STARTROWINDEX,int $ENDROWINDEX)"
	implservice_countmethod="getOrderCfgCn(String orderType,
			String cfgStaff, String startTime, String endTime)">
		 <ai:col title="工单号" fieldname="ORDER_ID" width="60"/>
		 <ai:col title="工单名称" fieldname="ORDER_NAME" width="290"/>
		 <ai:col title="申请人" fieldname="APPLY_STAFF" width="70"/>
		 <ai:col title="申请部门" fieldname="ORGANIZE_NAME" width="90"/>
		 <ai:col title="资费批次编号" fieldname="PC_ID" width="100" visible="false"/>
		 <ai:col title="资费批次名称" fieldname="PC_NAME" width="100" visible="false"/>
		 <ai:col title="配置名称" fieldname="DC_NAME" width="290" />
		 <ai:col title="配置BOSS编码" fieldname="DC_CODE" width="150" />
		 <ai:col title="配置人员" fieldname="CFG_STAFF" width="90"/>
		 <ai:col title="配置完成时间" fieldname="FINISH_DATE" width="100" />
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
		return alert("现在只支持武器、资费查询！");
	}
	orderCfgTraceTab.refresh("&orderType=" + itemType + "&cfgStaff=" + encodeURI(trim(dealP)) + "&startTime=" + dispatchTimeF + "&endTime=" + dispatchTimeT);
}

function trim(str)
{
     return str.replace(/(^\s*)|(\s*$)/g, '');
}
</script>
</html>