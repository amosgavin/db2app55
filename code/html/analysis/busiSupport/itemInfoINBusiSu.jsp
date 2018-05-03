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
			onvalchange="" editable="true" initial="false"
			datamodel="com.ai.appframe2.web.datamodel.MethodModelForService"
			implservice_name="com.asiainfo.bi.service.interfaces.IBusiSupportSV"
			implservice_querymethod="getStatisticsINBusiSu(String dispatchTimeF,String dispatchTimeTo)">
		<table width="98%" align="center" border="0" cellpadding="1" cellspacing="2">
		    <tr>
		    	<td class="td_font">工单编号：</td>
		    	<td><ai:dbformfield formid="queryForm" fieldname="WID" width="150"/></td>
		    	<td class="td_font">工单状态：</td>
		    	<td><ai:dbformfield formid="queryForm" fieldname="STATE" width="150"/></td>
		    	<td class="td_font">工单类型：</td>
		    	<td><ai:dbformfield formid="queryForm" fieldname="ITEMTYPE" width="150"/></td>
		    </tr>
			<tr>
		    	<td class="td_font">处理人：</td>
		    	<td><ai:dbformfield formid="queryForm" fieldname="STAFF_NAME" width="150"/></td>
				<td class="td_font">分派时间（从）：</td>
		        <td><ai:dbformfield formid="queryForm" fieldname="DISPATCHF" width="150"/></td>
		        <td class="td_font">分派时间（截至）：</td>
	           	<td><ai:dbformfield formid="queryForm" fieldname="DISPATCHT" width="150"/>
	           		<ai:button text="查询" onclick="query()"/></td>
			</tr>
		</table>
	</ai:dbform>
</ai:contractframe>

<ai:contractframe id="itemInfoframe" contenttype="table" title="工单办理跟踪" width="100%" allowcontract="false" frameclosed="false">
<ai:contractitem/>
<ai:table tableid="busiSupportTab" setname="com.asiainfo.bi.web.SETBusiSupport" height="420" multiselect="false" oncellchange="" editable="false" 
	needrefresh="true" pagesize="16" initial="false" rowheight="25"
	width="100%" tablemodel="com.ai.appframe2.web.datamodel.MethodModelForService"
	implservice_name="com.asiainfo.bi.service.interfaces.IBusiSupportSV"
	implservice_querymethod="getItemInfoINBusiSu(String itemId, String itemType,
			String state, String dispatchTimeF, String dispatchTimeTo,
			String dealPerson, int $STARTROWINDEX,int $ENDROWINDEX)"
	implservice_countmethod="getItemInfoINBusiSuCount(String itemId, String itemType, String state,
			String dispatchTimeF, String dispatchTimeTo, String dealPerson)">
		 <ai:col fieldname="WID" width="70"/>
		 <ai:col fieldname="ITEMTYPE" width="100"/>
		 <ai:col fieldname="APPLY_NAME" width="280"/>
		 <ai:col fieldname="BCN" width="100"/>
		 <ai:col fieldname="LCN" width="100"/>
		 <ai:col fieldname="ORGANIZE_NAME" width="100"/>
		 <ai:col fieldname="CREATE_DATE" width="120" />
		 <ai:col fieldname="SUPERIOR" width="70" />
		 <ai:col fieldname="DISPATCHF" width="130"/>
		 <ai:col fieldname="STAFF_NAME" width="70" />
		 <ai:col fieldname="STATE" width="70"/>
		 <ai:col fieldname="FINISH_DATE" width="120"/>
</ai:table>
</ai:contractframe>
</body>
<script type="text/javascript">
var queryForm = g_FormRowSetManager.get("queryForm");
var busiSupportTab = g_TableRowSetManager.get("busiSupportTab");
function initPage(){
	//busiSupportTab.refresh();
}

function query() {
	var wid = queryForm.getValue("WID");
	var state = queryForm.getValue("STATE");
	var itemType = queryForm.getValue("ITEMTYPE");
	var dealP = queryForm.getValue("STAFF_NAME");
	var dispatchTimeF = queryForm.getValue("DISPATCHF");
	var dispatchTimeT = queryForm.getValue("DISPATCHT");
	busiSupportTab.refresh("&itemId=" + wid + "&itemType=" + itemType +　"&state=" + state + "&dealPerson=" + encodeURI(trim(dealP)) + "&dispatchTimeF=" + dispatchTimeF + "&dispatchTimeTo=" + dispatchTimeT);
}

function trim(str)
{
     return str.replace(/(^\s*)|(\s*$)/g, '');
}
</script>
</html>