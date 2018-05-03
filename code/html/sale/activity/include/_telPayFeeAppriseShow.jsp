<%@ page contentType="text/html; charset=GBK"%>
<%@ include file="/secframe/common/common.jsp"%>
<%@include file="/webframe/common/commonhead.jsp"%>

<html>
<head>
<title><i18n:message key="省公司手机支付话费营销活动申告单"/></title>
</head>
<body>
<ai:contractframe id="saleTelPayFeeAppriseframe" contenttype="table" title="省公司手机支付话费营销活动申告单" width="100%" allowcontract="true" frameclosed="true">
    <ai:contractitem/>
    <ai:dbform formid="telPayFeeAppriseForm" 
            setname="com.asiainfo.sale.activity.web.SETSaleEitApprise"
            conditionname="condition" parametersname="parameters"
            initial="false"
            datamodel="com.ai.appframe2.web.datamodel.MethodModelForService"
            implservice_name="com.asiainfo.sale.activity.service.interfaces.ISaleEitAppriseSV"
            implservice_querymethod="getSaleEitAppriseByMainId(String mainId, String appriseType)">
        <table width="98%" align="center" border="0" cellpadding="1" cellspacing="2">
            <tr>
                <td class="td_font">活动名称：</td>
                <td><ai:dbformfield formid="telPayFeeAppriseForm" fieldname="SALE_NAME" width="260"/>
                	<ai:dbformfield formid="telPayFeeAppriseForm" fieldname="ID" width="150" visible="false"/></td>
                <td class="td_font">活动简称：</td>
                <td><ai:dbformfield formid="telPayFeeAppriseForm" fieldname="EIT_NAME" width="260" /></td>
                <td><ai:dbformfield formid="telPayFeeAppriseForm" fieldname="REMARK2" width="150" visible='false'/></td>
            </tr>
            <tr>
                <td class="td_font">发行总额：</td>
                <td><ai:dbformfield formid="telPayFeeAppriseForm" fieldname="PROVIDE_WHOLESALE_NUM" width="150"/>(元)<span class="font_red">*</span></td>
                <td class="td_font">单笔最大金额：</td>
                <td><ai:dbformfield formid="telPayFeeAppriseForm" fieldname="REMARK3" width="150"/>(元)<span class="font_red">*</span></td>
            </tr>
            <tr>
                <td class="td_font">发行方/出资方：</td>
                <td><ai:dbformfield formid="telPayFeeAppriseForm" fieldname="PROVIDE_CALL" height="50" width="450"/></td>
                <td class="td_font">活动描述：</td>
                <td><ai:dbformfield formid="telPayFeeAppriseForm" fieldname="REMARK4" height="50" width="450"/></td>
            </tr>
           
            <tr>
                <td class="td_font">活动起始日期：</td>
                <td><ai:dbformfield formid="telPayFeeAppriseForm" fieldname="PROVIDE_BEGIN_DATE"  width="150"/><span class="font_red">*</span></td>
                <td class="td_font">活动截止日期：</td>
                <td><ai:dbformfield formid="telPayFeeAppriseForm" fieldname="PROVIDE_END_DATE"  width="150"/><span class="font_red">*</span></td>
            </tr>
            <tr>
                <td class="td_font">发放生效日期：</td>
                <td><ai:dbformfield formid="telPayFeeAppriseForm" fieldname="REMARK5"  width="150" /><span class="font_red">*</span></td>
                <td class="td_font">发放失效日期：</td>
                <td><ai:dbformfield formid="telPayFeeAppriseForm" fieldname="ALLUSE_VALID_DATE"  width="150" /><span class="font_red">*</span></td>
            </tr>
            <tr>
               <td class="td_font">是否需要到账短信：</td>
                <td><ai:dbformfield formid="telPayFeeAppriseForm" fieldname="ARRIVE_OF_MONEY_SMS" width="150"/></td>
            </tr>
            <tr id="tel_sms_id" style="display: block;">
                <td class="td_font">到账短信内容：</td>
                <td><ai:dbformfield formid="telPayFeeAppriseForm" fieldname="AOM_SMS_CONTENT" height="50" width="450" /></td>
            </tr>
            
        </table>
    </ai:dbform>

</ai:contractframe>
</body>
<script type="text/javascript">

function initTelPayFeeApprise() {
	
	var saleTelPayFeeApprise = g_FormRowSetManager.get("telPayFeeAppriseForm");
	var mainId = "<%=request.getParameter("mainId")%>";
    if (null == mainId){
    	return;
    }
    saleTelPayFeeApprise.refresh("&mainId=" + mainId+"&appriseType=sjzf_sgd");
    if (saleTelPayFeeApprise.getValue("ARRIVE_OF_MONEY_SMS") == '0') {
    	document.getElementById("aom_sms_id").style.display="none";
    }
    saleTelPayFeeApprise.setEditSts('false');
}

</script>
