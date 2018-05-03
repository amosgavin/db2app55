<%@ page contentType="text/html; charset=GBK"%>
<%@ include file="/secframe/common/common.jsp"%>
<%@ include file="/webframe/common/commonhead.jsp"%>

<html>
<head>
<title>投入营销资源查询</title>
<script language="javascript" src="<%=request.getContextPath()%>/jsv2/Calendar.jsp" type="text/javascript"></script>
</head>
  <body onload="init()"> 
    <ai:contractframe id="usedQueryForm" contenttype="table" title="查询条件" width="100%" allowcontract="true" frameclosed="fale">
	<ai:contractitem/>
	<ai:dbform formid="usedQueryForm" initial="false"
			setname="com.asiainfo.sale.activity.web.SETUsedQuery">
		<table width="98%" align="center" border="0" cellpadding="1" cellspacing="2">
			<tr>
			    <td class="td_font">时间：</td>
	           	<td><ai:dbformfield formid="usedQueryForm" fieldname="DATE_TIME" width="150"/></td>
	           	<td class="td_font">地市：</td>
	           	<td><ai:dbformfield formid="usedQueryForm" fieldname="CITY_CODE" width="150"/></td>
	        </tr><tr>
	           	<td class="td_font">资源类型：</td>
	           	<td><ai:dbformfield formid="usedQueryForm" fieldname="RESOURCE_TYPE" width="150"/></td>       
	           	<td class="td_font">执行范围：</td>
	           	<td><ai:dbformfield formid="usedQueryForm" fieldname="CREATEORG" width="150"/></td>   
	           	<td><ai:button id="querytable" text="查询" onclick="doWork('querytable()')"/></td>
			</tr>
		</table>
	</ai:dbform>
</ai:contractframe>

<ai:contractframe id="usedQueryframe" contenttype="table" title="营销案投入营销资源前10名" width="100%" allowcontract="true" frameclosed="false">
	<ai:contractitem/>
	<ai:table tableid="usedQueryTab" setname="com.asiainfo.sale.activity.web.SETUsedQuery" 
		height="250" multiselect="false" oncellchange="" 
		oncontextmenu="" needrefresh="true"  pagesize="30"
		width="100%" tablemodel="com.ai.appframe2.web.datamodel.MethodModelForService"
		implservice_name="com.asiainfo.sale.activity.service.interfaces.IUsedQuerySV"
		implservice_querymethod="queryUsedValue(String cityCode, String resourcetype, String createorg, String datetime, int $STARTROWINDEX, int $ENDROWINDEX)" 
		implservice_countmethod="queryUsedCount(String cityCode, String resourcetype, String createorg, String datetime)" 
		initial="false" editable="false">
				<ai:col fieldname="PRIVSETID_NAME" width="200" visible="true"/>
	        	<ai:col fieldname="CREATEORG" width="50" visible="true"/>
	        	<ai:col fieldname="USER_NUM" width="100" visible="true"/>
	        	<ai:col fieldname="TERMINAL_COST_YEAR" width="100" visible="true"/>
	        	<ai:col fieldname="ACTION_OUT_YEAR" width="100" visible="true"/>
	        	<ai:col fieldname="JF_DZQ_COST_YEAR" width="100" visible="true"/>
	        	<ai:col fieldname="FJF_DZQ_COST_YEAR" width="100" visible="true"/>
	        	<ai:col fieldname="CXP_COST_YEAR" width="100" visible="true"/>
	        	<ai:col fieldname="TERMINAL_COST_YEAR_PER" width="100" visible="true"/>
	        	<ai:col fieldname="ACTION_OUT_YEAR_PER" width="100" visible="true"/>
	        	<ai:col fieldname="JF_DZQ_COST_YEAR_PER" width="100" visible="true"/>
	        	<ai:col fieldname="FJF_DZQ_COST_YEAR_PER" width="100" visible="true"/>
	        	<ai:col fieldname="CXP_COST_YEAR_PER" width="100" visible="true"/>
	</ai:table>
</ai:contractframe>

<script language="javascript" type="text/javascript">
function doWork(fun){ 
    beginAIWaitBanner(fun,"正在处理，请稍后...");
}
</script>

<script type="text/javascript">
var _usedQueryForm= g_FormRowSetManager.get("usedQueryForm");
var _usedQueryTab=g_TableRowSetManager.get("usedQueryTab");

function querytable(){
	var datetime = _usedQueryForm.getValue("DATE_TIME");
	var cityCode = _usedQueryForm.getValue("CITY_CODE");
	var resourcetype = _usedQueryForm.getValue("RESOURCE_TYPE");
	var createorg = _usedQueryForm.getValue("CREATEORG");
<%--	if(datetime!='201606'&&datetime!='201607'){--%>
<%--		alert('该月数据还未生成!');--%>
<%--		return;--%>
<%--	}--%>
	_usedQueryTab.refresh("&cityCode="+cityCode+"&resourcetype="+resourcetype+"&createorg="+createorg+"&datetime="+datetime);
}

function init(){
	_usedQueryForm.setFocus("CITY_CODE");
	_usedQueryForm.setFocus("RESOURCE_TYPE");
	_usedQueryForm.setFocus("CREATEORG");	
	_usedQueryForm.setFocus("DATE_TIME");	
}
</script>
</body>
</html>