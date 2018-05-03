<%@ page contentType="text/html; charset=GBK"%>
<%@ include file="/secframe/common/common.jsp"%>
<%@include file="/webframe/common/commonhead.jsp"%>

<html>
<head>
<title><i18n:message key="����ȯӪ�����浥"/></title>
</head>
<body onload="initOper()">

<ai:contractframe id="saleEitAppriseframe" contenttype="table" title="����ȯӪ�����浥" width="100%" allowcontract="true" frameclosed="false">
    <ai:contractitem/>
    <ai:dbform formid="saleEitAppriseForm" 
            setname="com.asiainfo.sale.activity.web.SETSaleEitApprise"
            conditionname="condition" parametersname="parameters"
            initial="false" onvalchange="onSaleEitFormValChange"
            datamodel="com.ai.appframe2.web.datamodel.MethodModelForService"
            implservice_name="com.asiainfo.sale.activity.service.interfaces.ISaleEitAppriseSV"
            implservice_querymethod="getSaleEitAppriseByMainId(String mainId, String appriseType)">
        <table width="98%" align="center" border="0" cellpadding="1" cellspacing="2">
            <tr>
                <td class="td_font">����ƣ�</td>
                <td><ai:dbformfield formid="saleEitAppriseForm" fieldname="SALE_NAME" width="260"/>
                	<ai:dbformfield formid="saleEitAppriseForm" fieldname="ID" width="150" visible="false"/></td>
                <td class="td_font">����ȯ���ƣ�</td>
                <td><ai:dbformfield formid="saleEitAppriseForm" fieldname="EIT_NAME" width="260" /></td>
            </tr>
            <tr>
                <td class="td_font">�����ܶ</td>
                <td><ai:dbformfield formid="saleEitAppriseForm" fieldname="PROVIDE_WHOLESALE_NUM" width="150"/>(Ԫ)<span class="font_red">*</span></td>
                <td><ai:dbformfield formid="saleEitAppriseForm" fieldname="REMARK2" width="150" visible='false'/></td>
            </tr>
            <tr>
                <td class="td_font">���з�/���ʷ���</td>
                <td><ai:dbformfield formid="saleEitAppriseForm" fieldname="PROVIDE_CALL" height="50" width="450" editable="false"/></td>
            </tr>
            <tr>
                   <td class="td_font">����ͣ�</td>
                   <td><ai:dbformfield formid="saleEitAppriseForm" fieldname="ACTIVE_TYPE" width="150" editable="false"/></td>
                   <td class="td_font">���ŷ�Χ��</td>
                   <td><ai:dbformfield formid="saleEitAppriseForm" fieldname="PROVIDE_AREA" width="150" editable="false"/></td>
               </tr>
            <tr>
                <td class="td_font">������ʼ���ڣ�</td>
                <td><ai:dbformfield formid="saleEitAppriseForm" fieldname="PROVIDE_BEGIN_DATE"  width="150"/><span class="font_red">*</span></td>
                <td class="td_font">���Ž�ֹ���ڣ�</td>
                <td><ai:dbformfield formid="saleEitAppriseForm" fieldname="PROVIDE_END_DATE"  width="150"/><span class="font_red">*</span></td>
            </tr>
            <tr>
                <td class="td_font">���ŵ���ȯ����Ч�ڣ�</td>
                <td><ai:dbformfield formid="saleEitAppriseForm" fieldname="SAMPLE_EIT_VALID"  width="150" editable="false"/>��</td>
                <td class="td_font">����ʹ�ý�ֹ���ڣ�</td>
                <td><ai:dbformfield formid="saleEitAppriseForm" fieldname="ALLUSE_VALID_DATE"  width="150" editable="false"/></td>
            </tr>
            <tr>
                <td class="td_font">���ú�����Ч��</td>
                <td><ai:dbformfield formid="saleEitAppriseForm" fieldname="AFTER_BUYEIT_VALID" width="150" editable="false"/></td>
                <td class="td_font">ÿ�շ��������ƣ�</td>
                <td><ai:dbformfield formid="saleEitAppriseForm" fieldname="MAX_PROVIDENUM_ONEDAY" width="150" editable="false"/></td>
            </tr>
            <tr>
                <td class="td_font">����������</td>
                <td><ai:dbformfield formid="saleEitAppriseForm" fieldname="TRIGGER_CONDITION" width="150"/><span class="font_red">*</span></td>
                <td class="td_font">�û���������ܴ�����</td>
                <td><ai:dbformfield formid="saleEitAppriseForm" fieldname="MAX_RECEIVENUM_INLIQUID" width="150" editable="false"/></td>
            </tr>
            <tr>
                <td class="td_font">�û��������ڣ�</td>
                <td><ai:dbformfield formid="saleEitAppriseForm" fieldname="PARTICIPATE_CYCLE" width="150" editable="false"/></td>
                <td class="td_font">���������������</td>
                <td><ai:dbformfield formid="saleEitAppriseForm" fieldname="MAX_RECEIVENUM_INCYCLE" width="150" editable="false"/></td>
            </tr>
            <tr>
                <td class="td_font">�����̻����ʣ�</td>
                <td><ai:dbformfield formid="saleEitAppriseForm" fieldname="RECEIVE_BUSI_PROP" width="450" editable="false"/></td>
            </tr>
            <tr>
                <td class="td_font">�����̻�������</td>
                <td><ai:dbformfield formid="saleEitAppriseForm" fieldname="RECEIVE_BUSI_PERSON" height="50" width="450"/></td>
            </tr>
            <tr>
                <td class="td_font">ʹ���̻����ʣ�</td>
                <td><ai:dbformfield formid="saleEitAppriseForm" fieldname="USE_BUSI_PROP" width="450"/></td>
            </tr>
            <tr>
                <td class="td_font">ʹ���̻�������</td>
                <td><ai:dbformfield formid="saleEitAppriseForm" fieldname="USE_BUSI_PERSON" height="50" width="450"/></td>
            </tr>
            <tr>
                <td class="td_font">�������ʽ��������ƣ�</td>
                <td><ai:dbformfield formid="saleEitAppriseForm" fieldname="CHANNEL_CHARGE_PROP" width="260" editable="false"/></td>
            </tr>
            <tr>
                <td class="td_font">���ʽ��׽�������������ڷ�����</td>
                <td><ai:dbformfield formid="saleEitAppriseForm" fieldname="SAMPLE_DEAL_INTERVAL" width="150" editable="false"/></td>
            </tr>
             <tr>
               <td class="td_font">�Ƿ���Ҫ���˶��ţ�</td>
                <td><ai:dbformfield formid="saleEitAppriseForm" fieldname="ARRIVE_OF_MONEY_SMS" width="150"/></td>
            </tr>
            <tr id="aom_sms_id" style="display: block;">
                <td class="td_font">���˶������ݣ�</td>
                <td><ai:dbformfield formid="saleEitAppriseForm" fieldname="AOM_SMS_CONTENT" height="50" width="450"/><span class="font_red">*</span></td>
            </tr>
            <tr id="aom_sms_case" style="display: block;"><td class="td_font"><span class="font_red">���˶������ݲο�ģ�壺</span></td>
            <td colspan="3"><span class="font_green">��ϲ���μ�XXX����[$]Ԫ����ȯ��������[$]��Ч���ڷ��͡���������վ������ƶ��ֻ�֧�������̼��ֳ����ѡ���Ч��90�죬��ѯ12580�����ο���XXΪ��Ҫ��д�ĵط���ʹ���̻����޸ģ�</span></td></tr>
            <tr>
                <td class="td_font">�Ƿ���Ҫ���ڶ��ţ�</td>
                <td colspan="3"><ai:dbformfield formid="saleEitAppriseForm" fieldname="OUT_OF_DATE_SMS" width="150"/></td>
            </tr>
            <tr id="ofd_sms_day" style="display: block;"><td class="td_font">��ǰ������е��ڶ������ѣ�</td>
            	<td><ai:dbformfield formid="saleEitAppriseForm" fieldname="REMARK1" width="50"/> ��(���ڻ����15��)<span class="font_red">*</span></td></tr>
            <tr id="ofd_sms_id" style="display: block;">
                <td class="td_font">���ڶ������ݣ�</td>
                <td colspan="3"><ai:dbformfield formid="saleEitAppriseForm" fieldname="OFD_SMS_CONTENT" height="50" width="450"/><span class="font_red">*</span></td>
            </tr>
            <tr id="ofd_sms_case" style="display: block;"><td class="td_font"><span class="font_red">���ڶ������ݲο�ģ�壺</span></td>
            	<td colspan="3"><span class="font_green">�𾴵Ŀͻ��������ֻ�֧������ȯ����[$]����ʧЧ�����ڵ���ǰ�ڷ��͡���������վ������ƶ��ֻ�֧�������̼��ֳ����ѡ���ѯ12580</span></td></tr>
            <tr>
            	<td class="td_font">��ע��</td>
                <td colspan="3"><span class="font_red">��رոû����ȯת������</span></td>
            </tr>
             <tr>
                <td class="td_font">�������ƺ͵���ID��Ӧ��ϵ��</td>
                <td colspan="3"><ai:dbformfield formid="saleEitAppriseForm" fieldname="LEVCODE_RELA_LEVID" height="50" width="450"/></td>
            </tr>
        </table>

    </ai:dbform>
<table align="center">
	<ai:button id="_bt_save" text="����" onclick="saveSaleEitApprise()"/>
</table>
</ai:contractframe>
</body>
<script type="text/javascript">
var saleEitAppriseF = g_FormRowSetManager.get("saleEitAppriseForm");
var mainId = "<%=request.getParameter("mainId")%>";
var saleName = "<%=request.getParameter("saleName")%>";

function initOper() {
    if (null == mainId){
    	return;
    }
    saleEitAppriseF.refresh("&mainId=" + mainId+"&appriseType=dzj_sgd");
    if (saleEitAppriseF.getValue("ARRIVE_OF_MONEY_SMS") == '0') {
    	document.getElementById("aom_sms_id").style.display="none";
    	document.getElementById("aom_sms_case").style.display="none";
    }
    if (saleEitAppriseF.getValue("OUT_OF_DATE_SMS") == '0') {
    	document.getElementById("ofd_sms_id").style.display="none";
    	document.getElementById("ofd_sms_day").style.display="none";
    	document.getElementById("ofd_sms_case").style.display="none";
    }
    if (saleEitAppriseF.getValue("SALE_NAME") == "") {
    	saleEitAppriseF.setValue("SALE_NAME", saleName);
    	saleEitAppriseF.setValue("EIT_NAME", saleName);
    	saleEitAppriseF.setValue("REMARK2", 'dzj_sgd');
    }
    saleEitAppriseF.setValue("AFTER_BUYEIT_VALID",4);
}

function saveSaleEitApprise() {
	
	if (saleEitAppriseF.getValue("PROVIDE_WHOLESALE_NUM") == ""){
		return alert("����д����������");
	}
	if (trim(saleEitAppriseF.getValue("PROVIDE_BEGIN_DATE")) == "") {
		return alert("����д������ʼ���ڣ�");
	}
	if (trim(saleEitAppriseF.getValue("PROVIDE_END_DATE")) == "") {
		return alert("����д���Ž�ֹ���ڣ�");
	}
	if (trim(saleEitAppriseF.getValue("TRIGGER_CONDITION")) == "") {
		return alert("��ѡ�񴥷�������");
	}
	if (saleEitAppriseF.getValue("ARRIVE_OF_MONEY_SMS") == '1') {
		if (trim(saleEitAppriseF.getValue("AOM_SMS_CONTENT")) == "") {
			return alert("����д���˶������ݣ�");
		}
	}
	if (saleEitAppriseF.getValue("OUT_OF_DATE_SMS") == '1') {
		
		if (saleEitAppriseF.getValue("REMARK1") == '') {
			return alert("����д��ǰ������е��ڶ������ѣ�");
		}
		if (trim(saleEitAppriseF.getValue("OFD_SMS_CONTENT")) == '') {
			return alert("����д���ڶ������ݣ�");
		}
		if (saleEitAppriseF.getValue("REMARK1") > 15) {
			return alert("���ڶ�����������������15�죡");
		}
	}
	var list = new Array();
	list.push(saleEitAppriseF);
	var strUrl = '<%=request.getContextPath()%>/business/com.asiainfo.sale.activity.web.SaleMainAction?action=saveSaleEitApprise&mainId='+mainId;
	var recode = saveRowSet(strUrl, list);
	saleEitAppriseF.refresh("&mainId=" + mainId+"&appriseType=dzj_sgd");
}

function onSaleEitFormValChange(pFieldName,pOldVal,pOldText,pNewVal,pNewText){
	if (pFieldName == 'ARRIVE_OF_MONEY_SMS') {
		if ("1" == pOldText) {
			document.getElementById("aom_sms_id").style.display="block";
			document.getElementById("aom_sms_case").style.display="block";
		} else {
			document.getElementById("aom_sms_id").style.display="none";
			document.getElementById("aom_sms_case").style.display="none";
		}
	}
	if (pFieldName == 'OUT_OF_DATE_SMS') {
		if ("1" == pOldText) {
			document.getElementById("ofd_sms_id").style.display="block";
			document.getElementById("ofd_sms_day").style.display="block";
			document.getElementById("ofd_sms_case").style.display="block";
		} else {
			document.getElementById("ofd_sms_id").style.display="none";
			document.getElementById("ofd_sms_day").style.display="none";
			document.getElementById("ofd_sms_case").style.display="none";
		}
	}
	if (pFieldName=="PROVIDE_END_DATE"){
		if(""!=pFieldName){
			saleEitAppriseF.setValue("ALLUSE_VALID_DATE",addDate(4,90,saleEitAppriseF.getValue("PROVIDE_END_DATE")));
		}
	}
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
