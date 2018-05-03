<%@ page contentType="text/html; charset=GBK"%>
<%@ include file="/secframe/common/common.jsp"%>
<%@include file="/webframe/common/commonhead.jsp"%>

<html>
<head>
<title><i18n:message key="省公司手机支付话费营销活动申告单"/></title>
</head>
<body onload="initOper()">

<ai:contractframe id="saleEitAppriseframe" contenttype="table" title="省公司手机支付话费营销活动申告单" width="100%" allowcontract="true" frameclosed="false">
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
                <td class="td_font">活动名称：</td>
                <td><ai:dbformfield formid="saleEitAppriseForm" fieldname="SALE_NAME" width="260"/>
                	<ai:dbformfield formid="saleEitAppriseForm" fieldname="ID" width="150" visible="false"/></td>
                <td class="td_font">活动简称：</td>
                <td><ai:dbformfield formid="saleEitAppriseForm" fieldname="EIT_NAME" width="260" /></td>
                <td><ai:dbformfield formid="saleEitAppriseForm" fieldname="REMARK2" width="150" visible='false'/></td>
            </tr>
            <tr>
                <td class="td_font">发行总额：</td>
                <td><ai:dbformfield formid="saleEitAppriseForm" fieldname="PROVIDE_WHOLESALE_NUM" width="150"/>(元)<span class="font_red">*</span></td>
                <td class="td_font">单笔最大金额：</td>
                <td><ai:dbformfield formid="saleEitAppriseForm" fieldname="REMARK3" width="150"/>(元)<span class="font_red">*</span></td>
            </tr>
            <tr>
                <td class="td_font">发行方/出资方：</td>
                <td><ai:dbformfield formid="saleEitAppriseForm" fieldname="PROVIDE_CALL" height="50" width="450"/></td>
                <td class="td_font">活动描述：</td>
                <td><ai:dbformfield formid="saleEitAppriseForm" fieldname="REMARK4" height="50" width="450"/></td>
            </tr>
           
            <tr>
                <td class="td_font">活动起始日期：</td>
                <td><ai:dbformfield formid="saleEitAppriseForm" fieldname="PROVIDE_BEGIN_DATE"  width="150"/><span class="font_red">*</span></td>
                <td class="td_font">活动截止日期：</td>
                <td><ai:dbformfield formid="saleEitAppriseForm" fieldname="PROVIDE_END_DATE"  width="150"/><span class="font_red">*</span></td>
            </tr>
            <tr>
                <td class="td_font">发放生效日期：</td>
                <td><ai:dbformfield formid="saleEitAppriseForm" fieldname="REMARK5"  width="150" /><span class="font_red">*</span></td>
                <td class="td_font">发放失效日期：</td>
                <td><ai:dbformfield formid="saleEitAppriseForm" fieldname="ALLUSE_VALID_DATE"  width="150" /><span class="font_red">*</span></td>
            </tr>
            <tr>
               <td class="td_font">是否需要到账短信：</td>
                <td><ai:dbformfield formid="saleEitAppriseForm" fieldname="ARRIVE_OF_MONEY_SMS" width="150"/></td>
            </tr>
            <tr id="aom_sms_id" style="display: block;">
                <td class="td_font">到账短信内容：</td>
                <td><ai:dbformfield formid="saleEitAppriseForm" fieldname="AOM_SMS_CONTENT" height="50" width="450" /></td>
            </tr>
            
        </table>
    </ai:dbform>
<table align="center">
	<ai:button id="_bt_save" text="保存" onclick="savetelPayFeeApprise()"/>
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
    saleEitAppriseF.refresh("&mainId=" + mainId+"&appriseType=sjzf_sgd");
    if (saleEitAppriseF.getValue("ARRIVE_OF_MONEY_SMS") == '0') {
    	document.getElementById("aom_sms_id").style.display="none";
    }
    if (saleEitAppriseF.getValue("SALE_NAME") == "") {
    	saleEitAppriseF.setValue("SALE_NAME", saleName);
        saleEitAppriseF.setValue("EIT_NAME", saleName);
        saleEitAppriseF.setValue("REMARK2", 'sjzf_sgd');
        saleEitAppriseF.setValue("PROVIDE_CALL", '湖北移动');
        saleEitAppriseF.setValue("AOM_SMS_CONTENT", '尊敬的客户，感谢您参加XXXX活动获得[$]元话费。编辑YE发送至10086或拨打1008611即可查询话费余额。详询10086（仅供参考）');
    }
}

function savetelPayFeeApprise() {
	
	if (saleEitAppriseF.getValue("PROVIDE_WHOLESALE_NUM") == ""){
		return alert("请填写发行总额！");
	}
	if (saleEitAppriseF.getValue("REMARK3") == ""){
		return alert("请填写单笔最大金额！");
	}
	if (trim(saleEitAppriseF.getValue("PROVIDE_BEGIN_DATE")) == "") {
		return alert("请选择活动起始日期！");
	}
	if (trim(saleEitAppriseF.getValue("PROVIDE_END_DATE")) == "") {
		return alert("请选择活动截止日期！");
	}
	if (trim(saleEitAppriseF.getValue("REMARK5")) == "") {
		return alert("请选择发放生效日期！");
	}
	if (trim(saleEitAppriseF.getValue("ALLUSE_VALID_DATE")) == "") {
		return alert("请选择发放失效日期！");
	}
	var list = new Array();
	list.push(saleEitAppriseF);
	var strUrl = '<%=request.getContextPath()%>/business/com.asiainfo.sale.activity.web.SaleMainAction?action=saveSaleEitApprise&mainId='+mainId;
	var recode = saveRowSet(strUrl, list);
	saleEitAppriseF.refresh("&mainId=" + mainId+"&appriseType=sjzf_sgd");
}

function onSaleEitFormValChange(pFieldName,pOldVal,pOldText,pNewVal,pNewText){
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
		//	saleEitAppriseF.setValue("ALLUSE_VALID_DATE",addDate(4,92,saleEitAppriseF.getValue("PROVIDE_END_DATE")));
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
	type = parseInt(type) //类型 
	var lIntval = parseInt(NumDay)//间隔 
	switch(type) 
	{ 
		case 6 ://年 
		date.setYear(date.getFullYear() + lIntval) 
		break; 
		case 7 ://季度 
		date.setMonth(date.getMonth() + (lIntval * 3) ) 
		break; 
		case 5 ://月 
		date.setMonth(date.getMonth() + lIntval) 
		break; 
		case 4 ://天 
		date.setDate(date.getDate() + lIntval) 
		break 
		case 3 ://时 
		date.setHours(date.getHours() + lIntval) 
		break 
		case 2 ://分 
		date.setMinutes(date.getMinutes() + lIntval) 
		break 
		case 1 ://秒 
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
