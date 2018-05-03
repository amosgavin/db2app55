<%@ page contentType="text/html; charset=GBK"%>
<%@ include file="/secframe/common/common.jsp"%>
<%@include file="/webframe/common/commonhead.jsp"%>

<html>
<head>
<title><i18n:message key="填写BOSS系统的批次/档次ID"/></title>
<script language="javascript" src="<%=request.getContextPath()%>/jsv2/Calendar.jsp" type="text/javascript"></script>
</head>
<body onload="initOper()">
<ai:contractframe id="_main_frame" contenttype="table" title="营销活动批次编码信息(BOSS系统中的批次/档次ID请按照与系统生成的编码相同填写,如有特殊情况请说明原因)" width="100%" allowcontract="false" frameclosed="false">
    <ai:contractitem/>
    <ai:table
        tableid="saleMainListTable" 
        setname="com.asiainfo.sale.activity.web.SETSaleMain"
        tablemodel="com.ai.appframe2.web.datamodel.MethodModelForService"
        implservice_name="com.asiainfo.sale.activity.service.interfaces.ISaleOrderSV"
        implservice_querymethod="getSaleMainByOrderId(String orderId, int $STARTROWINDEX, int $ENDROWINDEX)"
        implservice_countmethod="getSaleMainCountByOrderId(String orderId)"
        initial="false"  multiselect="false"
        pagesize="20" editable="true" width="100%"
        height="150" needrefresh="true">
        <ai:col title="批次ID" fieldname="MAINID" width="100" editable="false"/>
        <ai:col title="批次名称" fieldname="SALE_MAIN_NAME" width="300" editable="false"/>
        <ai:col title="执行范围" fieldname="EXEAREA" width="100" editable="false"/>
        <ai:col title="系统生成的批次编码：" fieldname="SALE_MAIN_CODE" width="180" editable="false"/>
        <ai:col title="BOSS系统中的批次ID：" fieldname="PROMOTE_MANAGER" width="180" />
    </ai:table>
</ai:contractframe>

<ai:contractframe id="saleDetailListframe" contenttype="table" title="营销活动档次编码信息 (以LEV开头,长度为24位)" width="100%" allowcontract="false" frameclosed="fale" frameclosed="false">
	    <ai:contractitem>
         </ai:contractitem>
	    <ai:table
	        tableid="saleDetailListTable"
	        setname="com.asiainfo.sale.activity.web.SETSaleDetail"
	        tablemodel="com.ai.appframe2.web.datamodel.MethodModelForService"
	        implservice_name="com.asiainfo.sale.activity.service.interfaces.ISaleOrderSV"
	        implservice_querymethod="getSaleDetailByOrderId(String orderId, int $STARTROWINDEX, int $ENDROWINDEX)"
	        implservice_countmethod="getSaleDetailCountByOrderId(String orderId)"
	        initial="false" pagesize="300"   width="100%" editable="true" 
	        height="300" needrefresh="true">
	        <ai:col title="批次ID" fieldname="SALE_ID" width="80" visible="true" editable="false"/>
	        <ai:col title="档次ID" fieldname="DETAIL_ID" width="80" visible="true" editable="false"/>
            <ai:col title="类型" fieldname="SALE_FLAG" width="100" editable="false"/>
            <ai:col title="名称" fieldname="SALE_ACTIVE_NAME" width="200" editable="false"/>
            <ai:col title="系统生成档次编码" fieldname="SALE_ACTIVE_CODE" width="200" editable="false"/>
            <ai:col title="BOSSS系统中档次ID" fieldname="LEVEL_CODE" width="230" editable="true" />
	    </ai:table>
</ai:contractframe>

<table align="center">
<ai:button id="_main_bt_copy" text="复制系统生成编码到BOSSID" onclick="copy2Boss()"/>
<ai:button id="_main_bt_save" text="保存填写" onclick="saveBossInfo()"/>
</table>
</body>

<script type="text/javascript">

var saleMainTab = g_TableRowSetManager.get("saleMainListTable");
var saleDetailTab = g_TableRowSetManager.get("saleDetailListTable");
var orderId = "<%=request.getParameter("orderId")%>";

function initOper()
{
    if ("" == orderId || "null" == orderId){
    	return;
    }
    saleMainTab.refresh("&orderId=" + orderId);
    saleDetailTab.refresh("&orderId=" + orderId);
}

function copy2Boss(){
	var saleMainCount = saleMainTab.getTotalRowCount();
	//saleMainTab.setValue("PROMOTE_MANAGER",saleMainForm.getValue("SALE_MAIN_CODE"));
	for (var i=0; i<saleMainCount; ++i){
		saleMainTab.setValue(i, "PROMOTE_MANAGER",saleMainTab.getValue(i, "SALE_MAIN_CODE"));
	} 
	var saleDetailCount = saleDetailTab.getTotalRowCount();
	for (var i=0; i<saleDetailCount; ++i){
		saleDetailTab.setValue(i, "LEVEL_CODE",saleDetailTab.getValue(i, "SALE_ACTIVE_CODE"));
	}
}

function saveBossInfo(){
	
	if(!checkHasEmptyBossid()){
		return;
	}
	if(!checkHasSameBossId()){
		return;
	}
	if(!checkBossidEqualSysCode()){
		if(!confirm("系统生成编码与填写Bossid存在不一致,您确定要保存！")){
			return;
		}
	}
	
	var strUrl1 = '<%=request.getContextPath()%>/business/com.asiainfo.sale.activity.web.SaleMainAction?action=saveSaleMain';
	var strUrl2 = '<%=request.getContextPath()%>/business/com.asiainfo.sale.activity.web.SaleDetailAction?action=saveSaleDetail';
	
	var xmlbody1 = saleMainTab.toXmlString(true);
	var xmlbody2 = saleDetailTab.toXmlString(true);
	var recode1 = "";
	var recode2 = "";
	if (xmlbody1 != null || xmlbody1 != "") {
		var xml = "<RootInfo>" + xmlbody1 + "</RootInfo>";
		recode1 = PostInfo(strUrl1, xml);
	}
        if (saleDetailTab.getTotalRowCount() >= 1){
	   if (xmlbody2 != null || xmlbody2 != "") {
		var xml = "<RootInfo>" + xmlbody2 + "</RootInfo>";
		recode2 = PostInfo(strUrl2, xml);
	   }
        }
	if(recode1.getValueByName("FLAG") == "N" || recode2.getValueByName("FLAG") == "N"){
		return alert("保存失败！");
	} else {
		alert("保存成功！");
	}
    saleMainTab.refresh("&orderId=" + orderId);
    saleDetailTab.refresh("&orderId=" + orderId);
}

function checkHasEmptyBossid(){
	
	var saleMainCount = saleMainTab.getTotalRowCount();
	for (var i=0; i<saleMainCount; ++i){
		actCode = saleMainTab.getValue(i, "PROMOTE_MANAGER");
		if (null == actCode || "" == actCode){
			alert("请填写好批次Bossid!");
			return false;
		} 
	}
	for(var m = 1; m < saleMainCount; ++m){
		for(var j = 0; j < m; ++j){
			if ( saleMainTab.getValue(m, "PROMOTE_MANAGER") == saleMainTab.getValue(j, "PROMOTE_MANAGER") ){
				alert("填写的批次bossid有重复的！");
				return false;	
			}
		}
	}
	
	var saleDetCount = saleDetailTab.getTotalRowCount();
	for (var n=0; n<saleDetCount; ++n){
		levelCode = saleDetailTab.getValue(n, "LEVEL_CODE");
		if (null == levelCode || "" == levelCode){
			alert("请填写好档次Bossid!");
			return false;
		} 
	}
	for(var l = 1; l < saleDetCount; ++l){
		for(var k = 0; k < l; ++k){
			if ( saleDetailTab.getValue(l, "LEVEL_CODE") == saleDetailTab.getValue(k, "LEVEL_CODE") ){
				alert("填写的档次bossid有重复的！");
				return false;	
			}
		}
	} 
	return true;
}

function checkBossidEqualSysCode(){
	
	//if (saleMainForm.getValue("SALE_MAIN_CODE") == '0000') return true;
	
	var saleMainCount = saleMainTab.getTotalRowCount();
	for (var i=0; i<saleMainCount; ++i){
		var actCode = saleMainTab.getValue(i, "PROMOTE_MANAGER");
		var sysCode = saleMainTab.getValue(i, "SALE_MAIN_CODE")
		if (actCode != sysCode) return false;
	}
	var saleDetCount = saleDetailTab.getTotalRowCount();
	for (var i=0; i<saleDetCount; ++i){
		var levelCode = saleDetailTab.getValue(i, "LEVEL_CODE");
		var sysCode = saleDetailTab.getValue(i, "SALE_ACTIVE_CODE")
		if (levelCode != sysCode) return false;
	}
	return true;
}

function checkHasSameBossId() {
	var actBossid = "";
	var levBossid = "";
	var saleMainCount = saleMainTab.getTotalRowCount();
	for (var i=0; i<saleMainCount; ++i){
		if (actBossid != "") {
			actBossid += ",";
		} 
		actBossid += "'" + saleMainTab.getValue(i, "PROMOTE_MANAGER") + "'";
	}
	var saleDetCount = saleDetailTab.getTotalRowCount();
	for (var i=0; i<saleDetCount; ++i){
		if (levBossid != "") {
			levBossid += ",";
		} 
		levBossid += "'" + saleDetailTab.getValue(i, "LEVEL_CODE") + "'";
	}
	if (saleDetCount == 0) {
           return true;
        }
        var strUrl = '<%=request.getContextPath()%>/business/com.asiainfo.sale.activity.web.SaleOrderAction?action=isHasSameBossId&actBossid='+actBossid+'&levBossid='+levBossid + '&orderId=' + orderId;
	var ret = PostInfo(strUrl, null);
	if (ret.getValueByName("FLAG") == "N") {
		alert(ret.getValueByName("MESSAGE"));
		return false;
	} else {
		return true;
	}
}
</script>
</html>
