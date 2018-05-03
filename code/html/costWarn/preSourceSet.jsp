<%@ page contentType="text/html; charset=GBK"%>
<%@ include file="/secframe/common/common.jsp"%>
<%@include file="/webframe/common/commonhead.jsp"%>
<html>
<head>
<title><i18n:message key="地市折扣及终端补贴预算值设置" res="i18n.secframe_resource"/></title>
<script language="javascript" src="<%=request.getContextPath()%>/jsv2/Calendar.jsp" type="text/javascript"></script>
</head>
<body onload="initPage()">

<ai:contractframe id="costWarnStaticDataTframe" contenttype="table" title="地市折扣及终端补贴预算值设置" width="100%" allowcontract="true" frameclosed="false" >
	<ai:contractitem/>
	<ai:table setname="com.asiainfo.costWarn.web.CostWarnStaticData"
			  tableid="costWarnStaticDataTab" editable="true" width="100%" height = "320"
			  needrefresh="true" initial="false" pagesize="15"
			  tablemodel="com.ai.appframe2.web.datamodel.MethodModelForService"
			  implservice_name="com.asiainfo.costWarn.service.interfaces.ICostWarnStaticDataSV"
			  implservice_querymethod="getAllSets()">
			    <ai:col fieldname="CITY_ID" width="10%" editable="true" visible="false" />
			    <ai:col fieldname="CITY_CODE" width="10%" editable="true" visible="false" />
			    <ai:col fieldname="CITY_NAME" width="10%" editable="false" visible="true" />
			    <ai:col fieldname="DISCOUNT_FEE" width="15%" editable="true" visible="true" />
	        	<ai:col fieldname="ENDPOINT_SUB" width="15%" editable="true" visible="true" />
				<ai:col fieldname="RESERVE1" width="15%" editable="true" visible="true" /> 
				<ai:col fieldname="RESERVE2" width="15%" editable="true" visible="true" /> 
				<ai:col fieldname="RESERVE3" width="15%" editable="true" visible="true"/>
	</ai:table>
<ai:button id="bt_save" text="保存" onclick="saveModified()"/>
</ai:contractframe>

<ai:loginuser />
<script type="text/javascript">

var costWarnStaticDataTab = g_TableRowSetManager.get("costWarnStaticDataTab");

function initPage(){

	costWarnStaticDataTab.refresh();
}

function saveModified()
{
    var list = new Array();
    list.push(costWarnStaticDataTab);
    var strUrl = _gModuleName + '/business/com.asiainfo.costWarn.web.CostWarnStaticDataAction?action=saveCostWarnStaticData';
    var recode = saveRowSet(strUrl, list);
    var rFlag = recode.getValueByName("FLAG");
    if ("Y" == rFlag)
    {
    	//alert("保存成功！");
    	costWarnStaticDataTab.refresh();
    } 
    //return rFlag;
}

</script>
</body>
</html>