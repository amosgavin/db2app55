<%@ page contentType="text/html; charset=GBK"%>
<%@ include file="/secframe/common/common.jsp"%>
<%@include file="/webframe/common/commonhead.jsp"%>

<html>
<head>
<title><i18n:message key="��дBOSSϵͳ������/����ID"/></title>
<script language="javascript" src="<%=request.getContextPath()%>/jsv2/Calendar.jsp" type="text/javascript"></script>
</head>
<body onload="initOper()">
<span class="font_red">BOSSϵͳ�еĵ���ID�밴����ϵͳ���ɵı�����ͬ��д,�������������˵��ԭ��</span>
<ai:contractframe id="chargeDetailListframe" contenttype="table" title="�ѱ���ĵ�����Ϣ  (����д���ζ�Ӧboss�Ż�ID)" width="100%" allowcontract="true" frameclosed="false">
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
        	<ai:col title="����ID" fieldname="MID" visible="false" editable="false"/>
            <ai:col title="����" fieldname="CHARGE_TYPE" width="150"editable="false"/>
            <ai:col title="����" fieldname="FEE_NAME" width="400" editable="false"/>
            <ai:col title="�ʷѵ��α���" fieldname="CASE" width="130" editable="false"/>
            <ai:col title="BOSSϵͳ����" fieldname="INADD_USER_COUNT" width="130" editable="true"/>
            <ai:col title="�Ż�ID1" fieldname="PREFERENTIAL_ID1" width="100" editable="true"/>
            <ai:col title="�Ż�ID2" fieldname="PREFERENTIAL_ID2" width="100" editable="true"/>
            <ai:col title="�Ż�ID3" fieldname="PREFERENTIAL_ID3" width="100" editable="true"/>
            <ai:col title="�Ż�ID4" fieldname="PREFERENTIAL_ID4" width="100" editable="true"/>
            <ai:col title="�Ż�ID5" fieldname="PREFERENTIAL_ID5" width="100" editable="true"/>
    </ai:table>
</ai:contractframe>

<table align="center">
<ai:button id="_main_bt_copy" text="����ϵͳ���ɱ��뵽BOSSID" onclick="copy2Boss()"/>
<ai:button id="_main_bt_save" text="����Bossid" onclick="saveBossInfo()"/>
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
			if(!confirm("ϵͳ���ɱ�������дBossid���ڲ�һ��,��ȷ��Ҫ���棡")){
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
			alert("����ʧ�ܣ�");
			return;
		}else if(recode2.getValueByName("FLAG") == "Y"){
			alert("����ɹ���");
		}
	}
    chargeDetailListTable.refresh("&mainId=" + mainId+"&feeType=");
    window.opener.chargeDetailListTable.refresh("&mainId="+mainId+"&feeType=");
    //}else{
    //return alert("ϵͳ��������ͬ��BOSSID����������д��");
    // }
}

function checkPreferentialId(){
	for (var i=0; i<chargeDetailListTable.getTotalRowCount(); ++i){
		levelCode = chargeDetailListTable.getValue(i, "PREFERENTIAL_ID1");
		if (null == levelCode || "" == levelCode){
			alert("����д���ζ�Ӧboss�Ż�ID!");
			break;
		}
	}
}

function checkHasEmptyBossidDe(){
	var length = chargeDetailListTable.getTotalRowCount();
	for (var i=0; i<length; ++i){
		levelCode = chargeDetailListTable.getValue(i, "CASE");
		if (null == levelCode || "" == levelCode){
			alert("����д�õ���Bossid!");
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
		alert("��"+(i+1)+"��BOSSϵͳ�����Ѵ��ڻ���BOSSϵͳ����Ϊ�գ���������д!");
		return false;
		}
	}
	return true;
}
</script>
</html>