<%@ page contentType="text/html; charset=GBK"%>
<%@ include file="/secframe/common/common.jsp"%>
<%@ include file="/webframe/common/commonhead.jsp"%>

<html>
<head>
<title>营销案效果评估查询</title>
<script language="javascript" src="<%=request.getContextPath()%>/jsv2/Calendar.jsp" type="text/javascript"></script>
</head>
  <body onload="init()"> 
    <ai:contractframe id="saleCostEffectiveForm" contenttype="table" title="查询条件" width="100%" allowcontract="true" frameclosed="fale">
	<ai:contractitem/>
	<ai:dbform formid="saleCostEffectiveForm" initial="false"
			setname="com.asiainfo.sale.activity.web.SETSaleCostEffective">
		<table width="98%" align="center" border="0" cellpadding="1" cellspacing="2">
			<tr>
			    <td class="td_font" style="display:none">时间：</td>
	           	<td><ai:dbformfield formid="saleCostEffectiveForm" fieldname="DATE_TIME" width="150" visible="false"/></td>
	           	<td class="td_font">地市：</td>
	           	<td><ai:dbformfield formid="saleCostEffectiveForm" fieldname="COL_ALIAS_2" width="150"/></td>
	           	<td class="td_font">活动类型：</td>
	           	<td><ai:dbformfield formid="saleCostEffectiveForm" fieldname="COL_ALIAS_4" width="150"/></td>       
	           	<td><ai:button id="querytable" text="查询" onclick="doWork('querytable()')"/></td>
			</tr>
			
		</table>
	</ai:dbform>
</ai:contractframe>

<ai:contractframe id="saleCostEffectiveframe" contenttype="table" title="营销活动效益前10名" width="100%" allowcontract="true" frameclosed="false">
	<ai:contractitem/>
	<ai:table tableid="saleCostEffectiveTab" setname="com.asiainfo.sale.activity.web.SETSaleCostEffective" 
		height="250" multiselect="false" oncellchange="" 
		oncontextmenu="" needrefresh="true"  pagesize="30"
		width="100%" tablemodel="com.ai.appframe2.web.datamodel.MethodModelForService"
		implservice_name="com.asiainfo.sale.activity.service.interfaces.ISaleCostEffectiveSV"
		implservice_querymethod="querySaleCostEffectiveValue(String cityCode, String activityType, String datetime, int $STARTROWINDEX, int $ENDROWINDEX)" 
		implservice_countmethod="querySaleCostEffectiveCount(String cityCode, String activityType, String datetime)" 
		initial="false" editable="false">
				<ai:col fieldname="COL_ALIAS_1" width="500" visible="true"/>
	        	<ai:col fieldname="COL_ALIAS_12" width="150" visible="true"/>
	</ai:table>
</ai:contractframe>

<script language="javascript" type="text/javascript">
function doWork(fun){ 
    beginAIWaitBanner(fun,"正在处理，请稍后...");
}
</script>

<script type="text/javascript">
var _saleCostEffectiveForm= g_FormRowSetManager.get("saleCostEffectiveForm");
var _saleCostEffectiveTab=g_TableRowSetManager.get("saleCostEffectiveTab");

function querytable(){
	var datetime = _saleCostEffectiveForm.getValue("DATE_TIME");
	var cityCode = _saleCostEffectiveForm.getValue("COL_ALIAS_2");
	var activityType = _saleCostEffectiveForm.getValue("COL_ALIAS_4");
	var date=new Date;
    var year=date.getFullYear(); 
    var month=date.getMonth()-1;
        month =(month<10 ? "0"+month:month); 
    var datetime = (year.toString()+month.toString());
<%--	if(datetime!='201605'){--%>
<%--		alert('该月数据还未生成!');--%>
<%--		return;--%>
<%--	}--%>
	_saleCostEffectiveTab.refresh("&cityCode="+cityCode+"&activityType="+activityType+"&datetime="+datetime);
}

function init(){
	_saleCostEffectiveForm.setFocus("COL_ALIAS_2");
	_saleCostEffectiveForm.setFocus("COL_ALIAS_4");
	_saleCostEffectiveForm.setFocus("DATE_TIME");
}
</script>
</body>
</html>