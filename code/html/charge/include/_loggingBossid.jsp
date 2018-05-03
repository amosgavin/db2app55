<%@ page contentType="text/html; charset=GBK"%>
<%@ include file="/secframe/common/common.jsp"%>
<%@include file="/webframe/common/commonhead.jsp"%>

<html>
<head>
<title><i18n:message key="填写BOSS系统的批次/档次ID"/></title>
<script language="javascript" src="<%=request.getContextPath()%>/jsv2/Calendar.jsp" type="text/javascript"></script>
</head>
<body onload="initOper()">
<span class="font_red">BOSS系统中的档次ID请按照与系统生成的编码相同填写,如有特殊情况请说明原因</span>
<ai:contractframe id="chargeDetailListframe" contenttype="table" title="已保存的档次信息  (请填写档次对应boss优惠ID)" width="100%" allowcontract="true" frameclosed="false">
<ai:contractitem/>
    <ai:table
        tableid="chargeDetailListTable"
        setname="com.asiainfo.charge.web.SETChargeInfo"
        tablemodel="com.ai.appframe2.web.datamodel.MethodModelForService"
        implservice_name="com.asiainfo.charge.service.interfaces.IChargeMainSV"
        implservice_querymethod="getChargeDetailByNewMainid(String mainId, int $STARTROWINDEX, int $ENDROWINDEX)"
        implservice_countmethod="getChargeDetailByNewMainidCount(String mainId)"
        initial="false" 
        pagesize="15" editable="true" width="100%"
        height="180" needrefresh="true">
        	<ai:col title="档次ID" fieldname="MID" visible="false" editable="false"/>
            <ai:col title="类型" fieldname="CHARGE_TYPE" width="150"editable="false"/>
            <ai:col title="名称" fieldname="FEE_NAME" width="400" editable="false"/>
            <ai:col title="资费档次编码" fieldname="CASE" width="130" editable="false"/>
            <ai:col title="BOSS系统编码" fieldname="INADD_USER_COUNT" width="130" editable="true"/>
            <ai:col title="优惠ID1" fieldname="PREFERENTIAL_ID1" width="100" editable="true"/>
            <ai:col title="优惠ID2" fieldname="PREFERENTIAL_ID2" width="100" editable="true"/>
            <ai:col title="优惠ID3" fieldname="PREFERENTIAL_ID3" width="100" editable="true"/>
            <ai:col title="优惠ID4" fieldname="PREFERENTIAL_ID4" width="100" editable="true"/>
            <ai:col title="优惠ID5" fieldname="PREFERENTIAL_ID5" width="100" editable="true"/>
    </ai:table>
</ai:contractframe>

<table align="center">
<ai:button id="_main_bt_copy" text="复制系统生成编码到BOSSID" onclick="copy2Boss()"/>
<ai:button id="_main_bt_save" text="保存Bossid" onclick="saveBossInfo()"/>
</table>
</body>

<script type="text/javascript">

var chargeDetailListTable = g_TableRowSetManager.get("chargeDetailListTable");
var mainId = "<%=request.getParameter("mainId")%>";

function initOper()
{
    if ("" == mainId || "null" == mainId){
    	return;
    }
    chargeDetailListTable.refresh("&mainId=" + mainId);
}

function copy2Boss(){
	
	var length = chargeDetailListTable.getTotalRowCount();
	for (var i=0; i<length; ++i){
		chargeDetailListTable.setValue(i, "INADD_USER_COUNT",chargeDetailListTable.getValue(i, "CASE"));
	}
}

function saveBossInfo(){
	
	if(!checkHasEmptyBossidDe()){
		return;
	}
	if(!checkBossidEqualSysCode()){
		if(!checkBossidIsNull()){
		return ;
		}else{
			if(!confirm("系统生成编码与填写Bossid存在不一致,您确定要保存！")){
				return;
			}
			}
	}
	//var strUrlBossId = '<%=request.getContextPath()%>/business/com.asiainfo.charge.web.ChargeMainDeAction?action=haveBossId&BossId='+;
	//var recodeBossId = PostInfo(strUrlBossId, null);
	//if(recodeBossId.getValueByName("BOSS")=="YES"){
	checkPreferentialId();
	var strUrl2 = '<%=request.getContextPath()%>/business/com.asiainfo.charge.web.ChargeMainDeAction?action=saveChargeMainDe';
	var xmlbody = chargeDetailListTable.toXmlString(true);
	if (xmlbody != null || xmlbody != "") {
		var xml = "<RootInfo>" + xmlbody + "</RootInfo>";
		var recode2 = PostInfo(strUrl2, xml);
		if(recode2.getValueByName("FLAG") == "N"){
			alert("保存失败！");
			return;
		}else if(recode2.getValueByName("FLAG") == "Y"){
			alert("保存成功！");
		}
	}
    chargeDetailListTable.refresh("&mainId=" + mainId+"&feeType=");
    window.opener.chargeDetailListTable.refresh("&mainId="+mainId+"&feeType=");
    //}else{
    //return alert("系统中已有相同的BOSSID，请重新填写！");
    // }
}

function checkPreferentialId(){
	for (var i=0; i<chargeDetailListTable.getTotalRowCount(); ++i){
		levelCode = chargeDetailListTable.getValue(i, "PREFERENTIAL_ID1");
		if (null == levelCode || "" == levelCode){
			alert("请填写档次对应boss优惠ID!");
			break;
		}
	}
}

function checkHasEmptyBossidDe(){
	var length = chargeDetailListTable.getTotalRowCount();
	for (var i=0; i<length; ++i){
		levelCode = chargeDetailListTable.getValue(i, "CASE");
		if (null == levelCode || "" == levelCode){
			alert("请填写好档次Bossid!");
			return false;
		}
	}
	return true;
}

function checkBossidEqualSysCode(){
	
	var length = chargeDetailListTable.getTotalRowCount();
	for (var i=0; i<length; ++i){
		levelCode = chargeDetailListTable.getValue(i, "CASE");
		sysCode = chargeDetailListTable.getValue(i, "INADD_USER_COUNT")
		if (levelCode != sysCode) return false;
	}
	return true;
}

function checkBossidIsNull(){
	
	var length = chargeDetailListTable.getTotalRowCount();
	for (var i=0; i<length; ++i){
		levelCode = chargeDetailListTable.getValue(i, "CASE");
		sysCode = chargeDetailListTable.getValue(i, "INADD_USER_COUNT");
		var strUrlBossId = '<%=request.getContextPath()%>/business/com.asiainfo.charge.web.ChargeMainDeAction?action=haveBossId&BossId='+sysCode;
		var recodeBossId = PostInfo(strUrlBossId, null);
		if (""== sysCode||recodeBossId.getValueByName("BOSS")=="NO") {
		alert("第"+(i+1)+"行BOSS系统编码已存在或者BOSS系统编码为空，请重新填写!");
		return false;
		}
	}
	return true;
}
</script>
</html>