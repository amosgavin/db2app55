<%@ page contentType="text/html; charset=GBK"%>
<%@ include file="/secframe/common/common.jsp"%>
<%@include file="/webframe/common/commonhead.jsp"%>

<html>
<head>
<title><i18n:message key="电子券营销活动申告单"/></title>
</head>
<body onload="initOper()">

<ai:contractframe id="saleEitAppriseframe" contenttype="table" title="电子券营销活动申告单" width="100%" allowcontract="true" frameclosed="false">
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
                <td class="td_font">电子券名称：</td>
                <td><ai:dbformfield formid="saleEitAppriseForm" fieldname="EIT_NAME" width="260" /></td>
            </tr>
            <tr>
                <td class="td_font">发行总额：</td>
                <td><ai:dbformfield formid="saleEitAppriseForm" fieldname="PROVIDE_WHOLESALE_NUM" width="150"/>(元)<span class="font_red">*</span></td>
                <td><ai:dbformfield formid="saleEitAppriseForm" fieldname="REMARK2" width="150" visible='false'/></td>
            </tr>
            <tr>
                <td class="td_font">发行方/出资方：</td>
                <td><ai:dbformfield formid="saleEitAppriseForm" fieldname="PROVIDE_CALL" height="50" width="450" editable="false"/></td>
            </tr>
            <tr>
                   <td class="td_font">活动类型：</td>
                   <td><ai:dbformfield formid="saleEitAppriseForm" fieldname="ACTIVE_TYPE" width="150" editable="false"/></td>
                   <td class="td_font">发放范围：</td>
                   <td><ai:dbformfield formid="saleEitAppriseForm" fieldname="PROVIDE_AREA" width="150" editable="false"/></td>
               </tr>
            <tr>
                <td class="td_font">发放起始日期：</td>
                <td><ai:dbformfield formid="saleEitAppriseForm" fieldname="PROVIDE_BEGIN_DATE"  width="150"/><span class="font_red">*</span></td>
                <td class="td_font">发放截止日期：</td>
                <td><ai:dbformfield formid="saleEitAppriseForm" fieldname="PROVIDE_END_DATE"  width="150"/><span class="font_red">*</span></td>
            </tr>
            <tr>
                <td class="td_font">单张电子券包有效期：</td>
                <td><ai:dbformfield formid="saleEitAppriseForm" fieldname="SAMPLE_EIT_VALID"  width="150" editable="false"/>天</td>
                <td class="td_font">整体使用截止日期：</td>
                <td><ai:dbformfield formid="saleEitAppriseForm" fieldname="ALLUSE_VALID_DATE"  width="150" editable="false"/></td>
            </tr>
            <tr>
                <td class="td_font">领用后几天生效：</td>
                <td><ai:dbformfield formid="saleEitAppriseForm" fieldname="AFTER_BUYEIT_VALID" width="150" editable="false"/></td>
                <td class="td_font">每日发放量限制：</td>
                <td><ai:dbformfield formid="saleEitAppriseForm" fieldname="MAX_PROVIDENUM_ONEDAY" width="150" editable="false"/></td>
            </tr>
            <tr>
                <td class="td_font">触发条件：</td>
                <td><ai:dbformfield formid="saleEitAppriseForm" fieldname="TRIGGER_CONDITION" width="150"/><span class="font_red">*</span></td>
                <td class="td_font">用户活动期限领总次数：</td>
                <td><ai:dbformfield formid="saleEitAppriseForm" fieldname="MAX_RECEIVENUM_INLIQUID" width="150" editable="false"/></td>
            </tr>
            <tr>
                <td class="td_font">用户参与活动周期：</td>
                <td><ai:dbformfield formid="saleEitAppriseForm" fieldname="PARTICIPATE_CYCLE" width="150" editable="false"/></td>
                <td class="td_font">周期内限领次数：</td>
                <td><ai:dbformfield formid="saleEitAppriseForm" fieldname="MAX_RECEIVENUM_INCYCLE" width="150" editable="false"/></td>
            </tr>
            <tr>
                <td class="td_font">领用商户性质：</td>
                <td><ai:dbformfield formid="saleEitAppriseForm" fieldname="RECEIVE_BUSI_PROP" width="450" editable="false"/></td>
            </tr>
            <tr>
                <td class="td_font">领用商户名单：</td>
                <td><ai:dbformfield formid="saleEitAppriseForm" fieldname="RECEIVE_BUSI_PERSON" height="50" width="450"/></td>
            </tr>
            <tr>
                <td class="td_font">使用商户性质：</td>
                <td><ai:dbformfield formid="saleEitAppriseForm" fieldname="USE_BUSI_PROP" width="450"/></td>
            </tr>
            <tr>
                <td class="td_font">使用商户名单：</td>
                <td><ai:dbformfield formid="saleEitAppriseForm" fieldname="USE_BUSI_PERSON" height="50" width="450"/></td>
            </tr>
            <tr>
                <td class="td_font">渠道、资金种类限制：</td>
                <td><ai:dbformfield formid="saleEitAppriseForm" fieldname="CHANNEL_CHARGE_PROP" width="260" editable="false"/></td>
            </tr>
            <tr>
                <td class="td_font">单笔交易金额区间与区间内发行面额：</td>
                <td><ai:dbformfield formid="saleEitAppriseForm" fieldname="SAMPLE_DEAL_INTERVAL" width="150" editable="false"/></td>
            </tr>
             <tr>
               <td class="td_font">是否需要到账短信：</td>
                <td><ai:dbformfield formid="saleEitAppriseForm" fieldname="ARRIVE_OF_MONEY_SMS" width="150"/></td>
            </tr>
            <tr id="aom_sms_id" style="display: block;">
                <td class="td_font">到账短信内容：</td>
                <td><ai:dbformfield formid="saleEitAppriseForm" fieldname="AOM_SMS_CONTENT" height="50" width="450"/><span class="font_red">*</span></td>
            </tr>
            <tr id="aom_sms_case" style="display: block;"><td class="td_font"><span class="font_red">到账短信内容参考模板：</span></td>
            <td colspan="3"><span class="font_green">恭喜您参加XXX活动获得[$]元电子券，请您于[$]生效后在凡客、当当等网站或湖北移动手机支付联盟商家现场消费。有效期90天，详询12580（供参考，XX为需要填写的地方，使用商户可修改）</span></td></tr>
            <tr>
                <td class="td_font">是否需要到期短信：</td>
                <td colspan="3"><ai:dbformfield formid="saleEitAppriseForm" fieldname="OUT_OF_DATE_SMS" width="150"/></td>
            </tr>
            <tr id="ofd_sms_day" style="display: block;"><td class="td_font">提前几天进行到期短信提醒：</td>
            	<td><ai:dbformfield formid="saleEitAppriseForm" fieldname="REMARK1" width="50"/> 天(少于或等于15天)<span class="font_red">*</span></td></tr>
            <tr id="ofd_sms_id" style="display: block;">
                <td class="td_font">到期短信内容：</td>
                <td colspan="3"><ai:dbformfield formid="saleEitAppriseForm" fieldname="OFD_SMS_CONTENT" height="50" width="450"/><span class="font_red">*</span></td>
            </tr>
            <tr id="ofd_sms_case" style="display: block;"><td class="td_font"><span class="font_red">到期短信内容参考模板：</span></td>
            	<td colspan="3"><span class="font_green">尊敬的客户！您的手机支付电子券将于[$]到期失效，请于到期前在凡客、当当等网站或湖北移动手机支付联盟商家现场消费。详询12580</span></td></tr>
            <tr>
            	<td class="td_font">备注：</td>
                <td colspan="3"><span class="font_red">请关闭该活动电子券转赠功能</span></td>
            </tr>
             <tr>
                <td class="td_font">档次名称和档次ID对应关系：</td>
                <td colspan="3"><ai:dbformfield formid="saleEitAppriseForm" fieldname="LEVCODE_RELA_LEVID" height="50" width="450"/></td>
            </tr>
        </table>

    </ai:dbform>
<table align="center">
	<ai:button id="_bt_save" text="保存" onclick="saveSaleEitApprise()"/>
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
		return alert("请填写发行总量！");
	}
	if (trim(saleEitAppriseF.getValue("PROVIDE_BEGIN_DATE")) == "") {
		return alert("请填写发放起始日期！");
	}
	if (trim(saleEitAppriseF.getValue("PROVIDE_END_DATE")) == "") {
		return alert("请填写发放截止日期！");
	}
	if (trim(saleEitAppriseF.getValue("TRIGGER_CONDITION")) == "") {
		return alert("请选择触发条件！");
	}
	if (saleEitAppriseF.getValue("ARRIVE_OF_MONEY_SMS") == '1') {
		if (trim(saleEitAppriseF.getValue("AOM_SMS_CONTENT")) == "") {
			return alert("请填写到账短信内容！");
		}
	}
	if (saleEitAppriseF.getValue("OUT_OF_DATE_SMS") == '1') {
		
		if (saleEitAppriseF.getValue("REMARK1") == '') {
			return alert("请填写提前几天进行到期短信提醒！");
		}
		if (trim(saleEitAppriseF.getValue("OFD_SMS_CONTENT")) == '') {
			return alert("请填写到期短信内容！");
		}
		if (saleEitAppriseF.getValue("REMARK1") > 15) {
			return alert("到期短信提醒天数不大于15天！");
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
