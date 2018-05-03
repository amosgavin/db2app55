<%@ page contentType="text/html; charset=GBK"%>
<%@ include file="/secframe/common/common.jsp"%>
<%@include file="/webframe/common/commonhead.jsp"%>

<html>
<head>
<title><i18n:message key="营销活动和包红包申告单"/></title>
</head>
<body onload="initOper()">

<ai:contractframe id="saleHbHbframe" contenttype="table" title="营销活动和包红包申告单" width="100%" allowcontract="true" frameclosed="false">
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
                <td class="td_font">活动名称：</td>
                <td><ai:dbformfield formid="saleHbHbForm" fieldname="SALE_NAME" width="200"/>
                	<ai:dbformfield formid="saleHbHbForm" fieldname="ID" width="200" visible="false"/></td>
                <td class="td_font">活动简称：</td>
                <td><ai:dbformfield formid="saleHbHbForm" fieldname="EIT_NAME" width="200" /></td>
                <%-- <td><ai:dbformfield formid="saleHbHbForm" fieldname="REMARK2" width="200" visible='false'/></td> --%>
            </tr>
            <tr>
                <td class="td_font">发行总额：</td>
                <td><ai:dbformfield formid="saleHbHbForm" fieldname="PROVIDE_WHOLESALE_NUM" width="200"/>(元)<span class="font_red">*</span></td>
                <td class="td_font">单笔最大金额：</td>
                <td><ai:dbformfield formid="saleHbHbForm" fieldname="REMARK3" width="200"/>(元)<span class="font_red">*</span></td>
            </tr>
            <tr>
                <td class="td_font">发行方/出资方：</td>
                <td><ai:dbformfield formid="saleHbHbForm" fieldname="PROVIDE_CALL" height="40" width="200"/></td>
                <td class="td_font">发行范围：</td>
                <td><ai:dbformfield formid="saleHbHbForm" fieldname="PROVIDE_AREA" width="200"/></td>
            </tr>
            <tr>
            	<td class="td_font">活动描述：</td>
                <td colspan="3"><ai:dbformfield formid="saleHbHbForm" fieldname="REMARK4" height="50" width="650"/></td>
            </tr>
           
            <tr>
                <td class="td_font">活动起始日期：</td>
                <td><ai:dbformfield formid="saleHbHbForm" fieldname="PROVIDE_BEGIN_DATE"  width="200"/><span class="font_red">*</span></td>
                <td class="td_font">活动截止日期：</td>
                <td><ai:dbformfield formid="saleHbHbForm" fieldname="PROVIDE_END_DATE"  width="200"/><span class="font_red">*</span></td>
            </tr>
            <tr>
                <td class="td_font">发放生效日期：</td>
                <td><ai:dbformfield formid="saleHbHbForm" fieldname="TAKE_EFFECT_TIME"  width="200" /><span class="font_red">*</span></td>
                <td class="td_font">发放失效日期：</td>
                <td><ai:dbformfield formid="saleHbHbForm" fieldname="LOSE_EFFECT_TIME"  width="200" /></td>
            </tr>
            <tr>
               <td class="td_font">是否需要到账短信：</td>
                <td><ai:dbformfield formid="saleHbHbForm" fieldname="ARRIVE_OF_MONEY_SMS" width="200"/></td>
            </tr>
            <tr id="aom_sms_id" style="display: block;">
                <td class="td_font">到账短信内容：</td>
                <td colspan="3"><ai:dbformfield formid="saleHbHbForm" fieldname="AOM_SMS_CONTENT" height="50" width="650" /></td>
            </tr>
            <tr>
            	<td class="td_font">备注：</td>
                <td colspan="3"><ai:dbformfield formid="saleHbHbForm" fieldname="REMARK1" height="50" width="650" /></td>
            </tr>
        </table>
    </ai:dbform>
<table align="center">
	<ai:button id="_bt_save" text="保存" onclick="savetelPayFeeApprise()"/>
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
        saleHbHbF.setValue("PROVIDE_CALL", '发行方:\n出资方:');
        saleHbHbF.setValue("AOM_SMS_CONTENT", '短信模板示例：尊敬的客户，感谢您参加XXX活动获赠[$]元红包。可登陆和包APP查看红包余额。详询10086.');
    }
}

function savetelPayFeeApprise() {
	
	if (saleHbHbF.getValue("PROVIDE_WHOLESALE_NUM") == ""){
		return alert("请填写发行总额！");
	}
	if (saleHbHbF.getValue("REMARK3") == ""){
		return alert("请填写单笔最大金额！");
	}
	if (trim(saleHbHbF.getValue("PROVIDE_BEGIN_DATE")) == "") {
		return alert("请选择活动起始日期！");
	}
	if (trim(saleHbHbF.getValue("PROVIDE_END_DATE")) == "") {
		return alert("请选择活动截止日期！");
	}
	if (trim(saleHbHbF.getValue("TAKE_EFFECT_TIME")) == "") {
		return alert("请选择生效日期！");
	}
	/* if (trim(saleHbHbF.getValue("ALLUSE_VALID_DATE")) == "") {
		return alert("请选择发放失效日期！");
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
