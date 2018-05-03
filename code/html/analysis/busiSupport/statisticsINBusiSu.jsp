<%@ page contentType="text/html; charset=GBK"%>
<%@ include file="/secframe/common/common.jsp"%>
<%@include file="/webframe/common/commonhead.jsp"%>

<html>
<head>
<title><i18n:message key="配置工单办理跟踪统计"/></title>
<script language="javascript" src="<%=request.getContextPath()%>/jsv2/Calendar.jsp" type="text/javascript"></script>
</head>
<body onload="initPage();">
<ai:contractframe id="queryframe" contenttype="table" title="查询条件" width="100%" allowcontract="false" frameclosed="false">
<ai:contractitem/>
<ai:dbform formid="queryForm" 
			setname="com.asiainfo.bi.web.SETBusiSupportS"
			conditionname="condition" parametersname="parameters"
			onvalchange="" editable="true" initial="false"
			datamodel="com.ai.appframe2.web.datamodel.MethodModelForService"
			implservice_name="com.asiainfo.bi.service.interfaces.IBusiSupportSSV"
			implservice_querymethod="getStatisticsINBusiSu(String dispatchTimeF,String dispatchTimeTo)">
		<table width="98%" align="center" border="0" cellpadding="1" cellspacing="2">
			<tr>
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
<ai:table tableid="headTab" setname="com.asiainfo.bi.web.SETBusiSupportS" height="1" multiselect="false" oncellchange="" editable="false" 
	needrefresh="true" pagesize="0" initial="false" footdisplay ="none"
	width="100%" tablemodel="com.ai.appframe2.web.datamodel.MethodModelForService"
	implservice_name="com.asiainfo.bi.service.interfaces.IBusiSupportSSV"
	implservice_querymethod="getStatisticsINBusiSu(String dispatchTimeF,String dispatchTimeTo)">
		 <ai:col title = "" fieldname="STAFF_NAME" width="160"/>
		 <ai:col title = "已经完成数量" fieldname="TOTALY" width="300"/>
		 <ai:col title = "未完成数量" fieldname="TOTALN" width="650" />
</ai:table>
<ai:table tableid="busiSupportSTab" setname="com.asiainfo.bi.web.SETBusiSupportS" height="450" multiselect="false" oncellchange="" editable="false" 
	needrefresh="true" pagesize="200" initial="false" rowheight="25" footdisplay ="none"
	width="100%" tablemodel="com.ai.appframe2.web.datamodel.MethodModelForService"
	implservice_name="com.asiainfo.bi.service.interfaces.IBusiSupportSSV"
	implservice_querymethod="getStatisticsINBusiSu(String dispatchTimeF,String dispatchTimeTo)">
		 <ai:col fieldname="STAFF_NAME" width="60"/>
		 <ai:col fieldname="TOTAL" width="100"/>
		 <ai:col fieldname="TOTALY" width="50"/>
		 <ai:col fieldname="SALEY" width="60"/>
		 <ai:col fieldname="CHARGEY" width="60"/>
		 <ai:col fieldname="BUSIY" width="70" />
		 <ai:col fieldname="WEAPONY" width="60" />
		 <ai:col fieldname="TOTALN" width="50" />
		 <ai:col fieldname="SALEN" width="60"/>
		 <ai:col fieldname="CHARGEN" width="60" />
		 <ai:col fieldname="BUSIN" width="70"/>
		 <ai:col fieldname="WEAPONN" width="60" />
		 <ai:col fieldname="DIFFLS15" width="110"/>
		 <ai:col fieldname="DIFF15TO30" width="120"/>
		 <ai:col fieldname="DIFFGT30" width="120"/>
</ai:table>
</ai:contractframe>
</body>
<script type="text/javascript">
var queryForm = g_FormRowSetManager.get("queryForm");
var busiSupportSTab = g_TableRowSetManager.get("busiSupportSTab");
function initPage(){
	//busiSupportSTab.refresh();
}

function query() {
	var dispatchTimeF = queryForm.getValue("DISPATCHF");
	var dispatchTimeT = queryForm.getValue("DISPATCHT");
	busiSupportSTab.refresh("&dispatchTimeF=" + dispatchTimeF + "&dispatchTimeTo=" + dispatchTimeT);
}
</script>
</html>