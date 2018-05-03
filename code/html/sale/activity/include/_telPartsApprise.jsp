<%@ page contentType="text/html; charset=GBK"%>
<%@ include file="/secframe/common/common.jsp"%>
<%@include file="/webframe/common/commonhead.jsp"%>

<html>
<head>
<title><i18n:message key="�ֻ��������ר�õ���ȯӪ�����浥"/></title>
</head>
<body onload="initOper()">

<ai:contractframe id="saleTelPartsAppriseframe" contenttype="table" title="����ȯӪ�����浥" width="100%" allowcontract="true" frameclosed="false">
    <ai:contractitem/>
    <ai:dbform formid="saleTelPartsAppriseForm" 
            setname="com.asiainfo.sale.activity.web.SETSaleEitApprise"
            conditionname="condition" parametersname="parameters"
            initial="false" onvalchange="onSaleEitFormValChange"
            datamodel="com.ai.appframe2.web.datamodel.MethodModelForService"
            implservice_name="com.asiainfo.sale.activity.service.interfaces.ISaleEitAppriseSV"
            implservice_querymethod="getSaleEitAppriseByMainId(String mainId, String appriseType)">
        <table width="98%" align="center" border="0" cellpadding="1" cellspacing="2">
            <tr>
                <td class="td_font">����ƣ�</td>
                <td><ai:dbformfield formid="saleTelPartsAppriseForm" fieldname="SALE_NAME" width="260"/>
                	<ai:dbformfield formid="saleTelPartsAppriseForm" fieldname="ID" width="150" visible="false"/></td>
                <td class="td_font">����ȯ���ƣ�</td>
                <td><ai:dbformfield formid="saleTelPartsAppriseForm" fieldname="EIT_NAME" width="260" /></td>
            </tr>
            <tr>
                <td class="td_font">�����ܶ</td>
                <td><ai:dbformfield formid="saleTelPartsAppriseForm" fieldname="PROVIDE_WHOLESALE_NUM" width="150"/>(Ԫ)<span class="font_red">*</span></td>
                <td><ai:dbformfield formid="saleTelPartsAppriseForm" fieldname="REMARK2" width="150" visible='false'/></td>
            </tr>
            <tr>
                <td class="td_font">���з�/���ʷ���</td>
                <td><ai:dbformfield formid="saleTelPartsAppriseForm" fieldname="PROVIDE_CALL" height="50" width="180" editable="false"/></td>
            </tr>
            <tr>
                   <td class="td_font">����ͣ�</td>
                   <td><ai:dbformfield formid="saleTelPartsAppriseForm" fieldname="ACTIVE_TYPE" width="150" editable="false"/></td>
                   <td class="td_font">���ŷ�Χ��</td>
                   <td><ai:dbformfield formid="saleTelPartsAppriseForm" fieldname="PROVIDE_AREA" width="150" editable="false"/></td>
               </tr>
            <tr>
                <td class="td_font">������ʼ���ڣ�</td>
                <td><ai:dbformfield formid="saleTelPartsAppriseForm" fieldname="PROVIDE_BEGIN_DATE"  width="150"/><span class="font_red">*</span></td>
                <td class="td_font">���ŵ���ȯ����Ч�ڣ�</td>
                <td><ai:dbformfield formid="saleTelPartsAppriseForm" fieldname="SAMPLE_EIT_VALID"  width="150" editable="true"/><span class="font_red">��  (����7-30�죬������90��)</span></td>
            </tr>
            <tr>
                <td class="td_font">���Ž�ֹ���ڣ�</td>
                <td><ai:dbformfield formid="saleTelPartsAppriseForm" fieldname="PROVIDE_END_DATE"  width="150"/><span class="font_red">*������д���ŵ���ȯ��Ч��</span></td>
                <td class="td_font">����ʹ�ý�ֹ���ڣ�</td>
                <td><ai:dbformfield formid="saleTelPartsAppriseForm" fieldname="ALLUSE_VALID_DATE"  width="150" editable="false"/></td>
            </tr>
            <tr>
                <td class="td_font">���ú�����Ч��</td>
                <td><ai:dbformfield formid="saleTelPartsAppriseForm" fieldname="AFTER_BUYEIT_VALID" width="150" editable="false"/></td>
                <td class="td_font">ÿ�շ��������ƣ�</td>
                <td><ai:dbformfield formid="saleTelPartsAppriseForm" fieldname="MAX_PROVIDENUM_ONEDAY" width="150" editable="false"/></td>
            </tr>
            <tr>
                <td class="td_font">�û�����ά�ȣ�</td>
                <td><ai:dbformfield formid="saleTelPartsAppriseForm" fieldname="USE_BUSI_PROP" width="150" editable="false"/></td>
                <td class="td_font">�û���������ܴ�����</td>
                <td><ai:dbformfield formid="saleTelPartsAppriseForm" fieldname="MAX_RECEIVENUM_INLIQUID" width="150" editable="false"/></td>
            </tr>
            <tr>
                <td class="td_font">�û��������ڣ�</td>
                <td><ai:dbformfield formid="saleTelPartsAppriseForm" fieldname="PARTICIPATE_CYCLE" width="150" editable="false"/></td>
                <td class="td_font">���������������</td>
                <td><ai:dbformfield formid="saleTelPartsAppriseForm" fieldname="MAX_RECEIVENUM_INCYCLE" width="150" editable="false"/></td>
            </tr>
            <tr>
                <td class="td_font">����������</td>
                <td><ai:dbformfield formid="saleTelPartsAppriseForm" fieldname="TRIGGER_CONDITION" width="150" editable="false"/></td>
                <td class="td_font">�������ʽ��������ƣ�</td>
                <td><ai:dbformfield formid="saleTelPartsAppriseForm" fieldname="CHANNEL_CHARGE_PROP" width="200" editable="false"/></td>
            </tr>
            <tr>
                <td class="td_font">ȯ�������ԣ�</td>
                <td><ai:dbformfield formid="saleTelPartsAppriseForm" fieldname="USE_BUSI_PERSON" width="150" editable="false"/></td>
                <td class="td_font">�����̻���Χ��</td>
                <td><ai:dbformfield formid="saleTelPartsAppriseForm" fieldname="RECEIVE_BUSI_PROP" width="150" editable="false"/></td>
            </tr>
            <tr>
                <td class="td_font">�����̻���Χ��</td>
                <td><ai:dbformfield formid="saleTelPartsAppriseForm" fieldname="RECEIVE_BUSI_PERSON" height="50" width="450"/><span class="font_red">*</span></td>
            </tr>
            <tr ><td class="td_font">˵����</td><td>�г�ר��ȯ�����̻����̻�Զ�̡��ֳ���ż���Ӧ���̻�����</td></tr>
            <tr>
               <td class="td_font">�Ƿ���Ҫ���˶��ţ�</td>
                <td><ai:dbformfield formid="saleTelPartsAppriseForm" fieldname="ARRIVE_OF_MONEY_SMS" width="150"/></td>
            </tr>
            <tr id="aom_sms_id" style="display: block;">
                <td class="td_font">���˶������ݣ�</td>
                <td><ai:dbformfield formid="saleTelPartsAppriseForm" fieldname="AOM_SMS_CONTENT" height="50" width="450"/><span class="font_red">*</span></td>
            </tr>
            <tr id="aom_sms_case" style="display: block;"><td class="td_font"><span class="font_red">���˶������ݲο�ģ�壺</span></td>
            <td colspan="3"><span class="font_green">��ϲ���μ�XX����[$]Ԫ�ֻ����ר�õ���ȯ����Ч��XX�죬����XX�̻����ѡ���ѯ12580�����ο���XXΪ��Ҫ��д�ĵط����̻���ע�������ѵ��̻����ƣ���Ч�ڽ���7-30�죬������90�죩</span></td></tr>
            <tr>
                <td class="td_font">�Ƿ���Ҫ���ڶ��ţ�</td>
                <td colspan="3"><ai:dbformfield formid="saleTelPartsAppriseForm" fieldname="OUT_OF_DATE_SMS" width="150"/></td>
            </tr>
            <tr id="ofd_sms_day" style="display: block;"><td class="td_font">��ǰ������е��ڶ������ѣ�</td>
            	<td><ai:dbformfield formid="saleTelPartsAppriseForm" fieldname="REMARK1" width="50"/> ��(���ڻ����15��)<span class="font_red">*</span></td></tr>
            <tr id="ofd_sms_id" style="display: block;">
                <td class="td_font">���ڶ������ݣ�</td>
                <td colspan="3"><ai:dbformfield formid="saleTelPartsAppriseForm" fieldname="OFD_SMS_CONTENT" height="50" width="450"/><span class="font_red">*</span></td>
            </tr>
            <tr id="ofd_sms_case" style="display: block;"><td class="td_font"><span class="font_red">���ڶ������ݲο�ģ�壺</span></td>
            	<td colspan="3"><span class="font_green">�𾴵Ŀͻ��������ֻ����ר��ȯ����[$]����ʧЧ�����ڵ���ǰ��XX�̼��ֳ����ѡ���ѯ12580�����ο���XXΪ��Ҫ��д�ĵط����̻���ע�������ѵ��̻����ƣ�</span></td></tr>
        </table>

    </ai:dbform>
<table align="center">
	<ai:button id="_bt_save" text="����" onclick="saveSaleEitApprise()"/>
</table>
</ai:contractframe>
</body>
<script type="text/javascript">
var saleTelPartsAppriseForm = g_FormRowSetManager.get("saleTelPartsAppriseForm");
var mainId = "<%=request.getParameter("mainId")%>";
var saleName = "<%=request.getParameter("saleName")%>";

function initOper() {
    if (null == mainId){
    	return;
    }
    saleTelPartsAppriseForm.refresh("&mainId=" + mainId+"&appriseType=sjpj_sgd");
    if (saleTelPartsAppriseForm.getValue("ARRIVE_OF_MONEY_SMS") == '0') {
    	document.getElementById("aom_sms_id").style.display="none";
    	document.getElementById("aom_sms_case").style.display="none";
    }
    if (saleTelPartsAppriseForm.getValue("OUT_OF_DATE_SMS") == '0') {
    	document.getElementById("ofd_sms_id").style.display="none";
    	document.getElementById("ofd_sms_day").style.display="none";
    	document.getElementById("ofd_sms_case").style.display="none";
    }
    if (saleTelPartsAppriseForm.getValue("SALE_NAME") == "") {
    	saleTelPartsAppriseForm.setValue("SALE_NAME", saleName);
    	saleTelPartsAppriseForm.setValue("EIT_NAME", saleName);
    	saleTelPartsAppriseForm.setValue("REMARK2", 'sjpj_sgd');
	    saleTelPartsAppriseForm.setValue("SAMPLE_EIT_VALID","");
	    saleTelPartsAppriseForm.setValue("MAX_PROVIDENUM_ONEDAY","�����ƣ�����/��");
	    saleTelPartsAppriseForm.setValue("AFTER_BUYEIT_VALID",0);
	    saleTelPartsAppriseForm.setValue("USE_BUSI_PERSON","5Ԫ");
	    saleTelPartsAppriseForm.setValue("USE_BUSI_PROP","���ֻ���");
	    saleTelPartsAppriseForm.setValue("USE_BUSI_PROP","���ֻ���");
	    saleTelPartsAppriseForm.setValue("RECEIVE_BUSI_PROP","��");
    }
	saleTelPartsAppriseForm.setValue("TRIGGER_CONDITION","ʡƽ̨����");
}

function saveSaleEitApprise() {
	
	if (saleTelPartsAppriseForm.getValue("PROVIDE_WHOLESALE_NUM") == ""){
		return alert("����д����������");
	}
	if (trim(saleTelPartsAppriseForm.getValue("PROVIDE_BEGIN_DATE")) == "") {
		return alert("����д������ʼ���ڣ�");
	}
	if (trim(saleTelPartsAppriseForm.getValue("SAMPLE_EIT_VALID")) == "") {
		return alert("����д���ŵ���ȯ��Ч�ڣ�");
	}
	if (trim(saleTelPartsAppriseForm.getValue("SAMPLE_EIT_VALID")) > 90) {
		return alert("���ŵ���ȯ��Ч�ڳ���90�죡");
	}
	if (trim(saleTelPartsAppriseForm.getValue("PROVIDE_END_DATE")) == "") {
		return alert("����д���Ž�ֹ���ڣ�");
	}
	if (saleTelPartsAppriseForm.getValue("ARRIVE_OF_MONEY_SMS") == '1') {
		if (trim(saleTelPartsAppriseForm.getValue("AOM_SMS_CONTENT")) == "") {
			return alert("����д���˶������ݣ�");
		}
	}
	if (saleTelPartsAppriseForm.getValue("OUT_OF_DATE_SMS") == '1') {
		
		if (saleTelPartsAppriseForm.getValue("REMARK1") == '') {
			return alert("����д��ǰ������е��ڶ������ѣ�");
		}
		if (trim(saleTelPartsAppriseForm.getValue("OFD_SMS_CONTENT")) == '') {
			return alert("����д���ڶ������ݣ�");
		}
		if (saleTelPartsAppriseForm.getValue("REMARK1") > 15) {
			return alert("���ڶ�����������������15�죡");
		}
	}
	var list = new Array();
	list.push(saleTelPartsAppriseForm);
	var strUrl = '<%=request.getContextPath()%>/business/com.asiainfo.sale.activity.web.SaleMainAction?action=saveSaleEitApprise&mainId='+mainId;
	var recode = saveRowSet(strUrl, list);
	saleTelPartsAppriseForm.refresh("&mainId=" + mainId+"&appriseType=sjpj_sgd");
	saleTelPartsAppriseForm.setValue("TRIGGER_CONDITION","ʡƽ̨����");
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
			if ("" == trim(saleTelPartsAppriseForm.getValue("SAMPLE_EIT_VALID"))){
				saleTelPartsAppriseForm.setValue("PROVIDE_END_DATE","");
				return;
			}
			saleTelPartsAppriseForm.setValue("ALLUSE_VALID_DATE",addDate(4,saleTelPartsAppriseForm.getValue("SAMPLE_EIT_VALID"),saleTelPartsAppriseForm.getValue("PROVIDE_END_DATE")));
		}
	}
	if (pFieldName=="SAMPLE_EIT_VALID"){
		if(""!=pFieldName){
			if ("" == trim(saleTelPartsAppriseForm.getValue("PROVIDE_END_DATE"))){
				return;
			}
			saleTelPartsAppriseForm.setValue("ALLUSE_VALID_DATE",addDate(4,saleTelPartsAppriseForm.getValue("SAMPLE_EIT_VALID"),saleTelPartsAppriseForm.getValue("PROVIDE_END_DATE")));
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
