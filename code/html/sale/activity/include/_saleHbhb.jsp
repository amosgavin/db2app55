<%@ page contentType="text/html; charset=GBK"%>
<%@ include file="/secframe/common/common.jsp"%>
<%@include file="/webframe/common/commonhead.jsp"%>

<html>
<head>
<title><i18n:message key="Ӫ����Ͱ������浥"/></title>
</head>
<body onload="initOper()">

<ai:contractframe id="saleHbHbframe" contenttype="table" title="Ӫ����Ͱ������浥" width="100%" allowcontract="true" frameclosed="false">
    <ai:contractitem/>
    <ai:dbform formid="saleHbHbForm" 
            setname="com.asiainfo.sale.activity.web.SETSaleHbHb"
            conditionname="condition" parametersname="parameters"
            initial="false" onvalchange="onSaleEitFormValChange"
            datamodel="com.ai.appframe2.web.datamodel.MethodModelForService"
            implservice_name="com.asiainfo.sale.activity.service.interfaces.ISaleHbHbSV"
            implservice_querymethod="getSaleHbHbByMainId(String mainId)">
        <table width="98%" align="center" border="0" cellpadding="1" cellspacing="2">
            <tr>
                <td class="td_font">����ƣ�</td>
                <td><ai:dbformfield formid="saleHbHbForm" fieldname="SALE_NAME" width="200"/>
                	<ai:dbformfield formid="saleHbHbForm" fieldname="ID" width="200" visible="false"/></td>
                <td class="td_font">���ƣ�</td>
                <td><ai:dbformfield formid="saleHbHbForm" fieldname="EIT_NAME" width="200" /></td>
                <%-- <td><ai:dbformfield formid="saleHbHbForm" fieldname="REMARK2" width="200" visible='false'/></td> --%>
            </tr>
            <tr>
                <td class="td_font">�����ܶ</td>
                <td><ai:dbformfield formid="saleHbHbForm" fieldname="PROVIDE_WHOLESALE_NUM" width="200"/>(Ԫ)<span class="font_red">*</span></td>
                <td class="td_font">��������</td>
                <td><ai:dbformfield formid="saleHbHbForm" fieldname="REMARK3" width="200"/>(Ԫ)<span class="font_red">*</span></td>
            </tr>
            <tr>
                <td class="td_font">���з�/���ʷ���</td>
                <td><ai:dbformfield formid="saleHbHbForm" fieldname="PROVIDE_CALL" height="40" width="200"/></td>
                <td class="td_font">���з�Χ��</td>
                <td><ai:dbformfield formid="saleHbHbForm" fieldname="PROVIDE_AREA" width="200"/></td>
            </tr>
            <tr>
            	<td class="td_font">�������</td>
                <td colspan="3"><ai:dbformfield formid="saleHbHbForm" fieldname="REMARK4" height="50" width="650"/></td>
            </tr>
           
            <tr>
                <td class="td_font">���ʼ���ڣ�</td>
                <td><ai:dbformfield formid="saleHbHbForm" fieldname="PROVIDE_BEGIN_DATE"  width="200"/><span class="font_red">*</span></td>
                <td class="td_font">���ֹ���ڣ�</td>
                <td><ai:dbformfield formid="saleHbHbForm" fieldname="PROVIDE_END_DATE"  width="200"/><span class="font_red">*</span></td>
            </tr>
            <tr>
                <td class="td_font">������Ч���ڣ�</td>
                <td><ai:dbformfield formid="saleHbHbForm" fieldname="TAKE_EFFECT_TIME"  width="200" /><span class="font_red">*</span></td>
                <td class="td_font">����ʧЧ���ڣ�</td>
                <td><ai:dbformfield formid="saleHbHbForm" fieldname="LOSE_EFFECT_TIME"  width="200" /></td>
            </tr>
            <tr>
               <td class="td_font">�Ƿ���Ҫ���˶��ţ�</td>
                <td><ai:dbformfield formid="saleHbHbForm" fieldname="ARRIVE_OF_MONEY_SMS" width="200"/></td>
            </tr>
            <tr id="aom_sms_id" style="display: block;">
                <td class="td_font">���˶������ݣ�</td>
                <td colspan="3"><ai:dbformfield formid="saleHbHbForm" fieldname="AOM_SMS_CONTENT" height="50" width="650" /></td>
            </tr>
            <tr>
            	<td class="td_font">��ע��</td>
                <td colspan="3"><ai:dbformfield formid="saleHbHbForm" fieldname="REMARK1" height="50" width="650" /></td>
            </tr>
        </table>
    </ai:dbform>
<table align="center">
	<ai:button id="_bt_save" text="����" onclick="savetelPayFeeApprise()"/>
</table>
</ai:contractframe>
</body>
<script type="text/javascript">
var saleHbHbF = g_FormRowSetManager.get("saleHbHbForm");
var mainId = "<%=request.getParameter("mainId")%>";
var saleName = "<%=request.getParameter("saleName")%>";

function initOper() {
    if (null == mainId){
    	return;
    }
    saleHbHbF.refresh("&mainId=" + mainId);
    if(saleEitAppriseF.getValue("ARRIVE_OF_MONEY_SMS") == '0'){
    	document.getElementById("aom_sms_id").style.display="none";
    }
    if (saleHbHbF.getValue("SALE_NAME") == "") {
    	saleHbHbF.setValue("SALE_NAME", saleName);
        saleHbHbF.setValue("EIT_NAME", saleName);
       // saleHbHbF.setValue("REMARK2", 'sjzf_sgd');
        saleHbHbF.setValue("PROVIDE_CALL", '���з�:\n���ʷ�:');
        saleHbHbF.setValue("AOM_SMS_CONTENT", '����ģ��ʾ�����𾴵Ŀͻ�����л���μ�XXX�����[$]Ԫ������ɵ�½�Ͱ�APP�鿴�������ѯ10086.');
    }
}

function savetelPayFeeApprise() {
	
	if (saleHbHbF.getValue("PROVIDE_WHOLESALE_NUM") == ""){
		return alert("����д�����ܶ");
	}
	if (saleHbHbF.getValue("REMARK3") == ""){
		return alert("����д��������");
	}
	if (trim(saleHbHbF.getValue("PROVIDE_BEGIN_DATE")) == "") {
		return alert("��ѡ����ʼ���ڣ�");
	}
	if (trim(saleHbHbF.getValue("PROVIDE_END_DATE")) == "") {
		return alert("��ѡ����ֹ���ڣ�");
	}
	if (trim(saleHbHbF.getValue("TAKE_EFFECT_TIME")) == "") {
		return alert("��ѡ����Ч���ڣ�");
	}
	/* if (trim(saleHbHbF.getValue("ALLUSE_VALID_DATE")) == "") {
		return alert("��ѡ�񷢷�ʧЧ���ڣ�");
	} */
	var list = new Array();
	list.push(saleHbHbF);
	var strUrl = '<%=request.getContextPath()%>/business/com.asiainfo.sale.activity.web.SaleMainAction?action=saveSaleHbHb&mainId='+mainId;
	var recode = saveRowSet(strUrl, list);
	saleHbHbF.refresh("&mainId=" + mainId);
}

function onSaleEitFormValChange(pFieldName,pOldVal,pOldText,pNewVal,pNewText){
	alert(pOldText);
	if (pFieldName == 'ARRIVE_OF_MONEY_SMS') {
		if ("1" == pOldText) {
			document.getElementById("aom_sms_id").style.display="block";
		} else {
			document.getElementById("aom_sms_id").style.display="none";
		}
	}
	if (pFieldName == 'OUT_OF_DATE_SMS') {
		if ("1" == pOldText) {
			document.getElementById("ofd_sms_id").style.display="block";
		} else {
			document.getElementById("ofd_sms_id").style.display="none";
		}
	}
	//if (pFieldName=="PROVIDE_END_DATE"){
		//if(""!=pFieldName){
		//	saleHbHbF.setValue("ALLUSE_VALID_DATE",addDate(4,92,saleHbHbF.getValue("PROVIDE_END_DATE")));
		//}
	//}
}

function trim(str)
{
     return str.replace(/(^\s*)|(\s*$)/g, '');
}

function addDate(type,NumDay,dtDate) 
{ 
	var date = new Date(StringToDate(dtDate)); 
	type = parseInt(type) //���� 
	var lIntval = parseInt(NumDay)//��� 
	switch(type) 
	{ 
		case 6 ://�� 
		date.setYear(date.getFullYear() + lIntval) 
		break; 
		case 7 ://���� 
		date.setMonth(date.getMonth() + (lIntval * 3) ) 
		break; 
		case 5 ://�� 
		date.setMonth(date.getMonth() + lIntval) 
		break; 
		case 4 ://�� 
		date.setDate(date.getDate() + lIntval) 
		break 
		case 3 ://ʱ 
		date.setHours(date.getHours() + lIntval) 
		break 
		case 2 ://�� 
		date.setMinutes(date.getMinutes() + lIntval) 
		break 
		case 1 ://�� 
		date.setSeconds(date.getSeconds() + lIntval) 
		break; 
		default: 
	} 
	var month= date.getMonth()+1;
	var second=date.getDate();
	
	return date.getFullYear() + '-' + month + '-' +second +dtDate.substr(10); 
} 
	
StringToDate=function(DateStr){
	if(typeof DateStr=="undefined")return new Date();
	if(typeof DateStr=="date")return DateStr;
	var converted = Date.parse(DateStr);
	var myDate = new Date(converted);
	if(isNaN(myDate)){
	DateStr=DateStr.replace(/:/g,"-");
	DateStr=DateStr.replace(" ","-");
	DateStr=DateStr.replace(".","-");
	var arys= DateStr.split('-');
	switch(arys.length){
	case 7 : myDate = new Date(arys[0],--arys[1],arys[2],arys[3],arys[4],arys[5],arys[6]);break;
	case 6 : myDate = new Date(arys[0],--arys[1],arys[2],arys[3],arys[4],arys[5]);break;
	default: myDate = new Date(arys[0],--arys[1],arys[2]);break;};};return myDate;
}

</script>
