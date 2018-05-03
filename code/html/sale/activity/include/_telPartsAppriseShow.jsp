<%@ page contentType="text/html; charset=GBK"%>
<%@ include file="/secframe/common/common.jsp"%>
<%@include file="/webframe/common/commonhead.jsp"%>

<ai:contractframe id="saleTelPartsAppriseframe" contenttype="table" title="手机配件定向专用电子券营销活动申告单" width="100%" allowcontract="true" frameclosed="true">
    <ai:contractitem/>
    <ai:dbform formid="saleTelPartsAppriseForm" 
            setname="com.asiainfo.sale.activity.web.SETSaleEitApprise"
            conditionname="condition" parametersname="parameters"
            initial="false"
            datamodel="com.ai.appframe2.web.datamodel.MethodModelForService"
            implservice_name="com.asiainfo.sale.activity.service.interfaces.ISaleEitAppriseSV"
            implservice_querymethod="getSaleEitAppriseByMainId(String mainId, String appriseType)">
        <table width="98%" align="center" border="0" cellpadding="1" cellspacing="2">
            <tr>
                <td class="td_font">活动名称：</td>
                <td><ai:dbformfield formid="saleTelPartsAppriseForm" fieldname="SALE_NAME" width="260"/>
                	<ai:dbformfield formid="saleTelPartsAppriseForm" fieldname="ID" width="150" visible="false"/></td>
                <td class="td_font">电子券名称：</td>
                <td><ai:dbformfield formid="saleTelPartsAppriseForm" fieldname="EIT_NAME" width="260" /></td>
            </tr>
            <tr>
                <td class="td_font">发行总额：</td>
                <td><ai:dbformfield formid="saleTelPartsAppriseForm" fieldname="PROVIDE_WHOLESALE_NUM" width="150"/>(元)<span class="font_red">*</span></td>
                <td><ai:dbformfield formid="saleTelPartsAppriseForm" fieldname="REMARK2" width="150" visible='false'/></td>
            </tr>
            <tr>
                <td class="td_font">发行方/出资方：</td>
                <td><ai:dbformfield formid="saleTelPartsAppriseForm" fieldname="PROVIDE_CALL" height="50" width="180" editable="false"/></td>
            </tr>
            <tr>
                   <td class="td_font">活动类型：</td>
                   <td><ai:dbformfield formid="saleTelPartsAppriseForm" fieldname="ACTIVE_TYPE" width="150" editable="false"/></td>
                   <td class="td_font">发放范围：</td>
                   <td><ai:dbformfield formid="saleTelPartsAppriseForm" fieldname="PROVIDE_AREA" width="150" editable="false"/></td>
               </tr>
            <tr>
                <td class="td_font">发放起始日期：</td>
                <td><ai:dbformfield formid="saleTelPartsAppriseForm" fieldname="PROVIDE_BEGIN_DATE"  width="150"/><span class="font_red">*</span></td>
                <td class="td_font">单张电子券包有效期：</td>
                <td><ai:dbformfield formid="saleTelPartsAppriseForm" fieldname="SAMPLE_EIT_VALID"  width="150" editable="true"/><span class="font_red">天  (建议7-30天，不超过90天)</span></td>
            </tr>
            <tr>
                <td class="td_font">发放截止日期：</td>
                <td><ai:dbformfield formid="saleTelPartsAppriseForm" fieldname="PROVIDE_END_DATE"  width="150"/><span class="font_red">*请先填写单张电子券有效期</span></td>
                <td class="td_font">整体使用截止日期：</td>
                <td><ai:dbformfield formid="saleTelPartsAppriseForm" fieldname="ALLUSE_VALID_DATE"  width="150" editable="false"/></td>
            </tr>
            <tr>
                <td class="td_font">领用后几天生效：</td>
                <td><ai:dbformfield formid="saleTelPartsAppriseForm" fieldname="AFTER_BUYEIT_VALID" width="150" editable="false"/></td>
                <td class="td_font">每日发放量限制：</td>
                <td><ai:dbformfield formid="saleTelPartsAppriseForm" fieldname="MAX_PROVIDENUM_ONEDAY" width="150" editable="false"/></td>
            </tr>
            <tr>
                <td class="td_font">用户限制维度：</td>
                <td><ai:dbformfield formid="saleTelPartsAppriseForm" fieldname="USE_BUSI_PROP" width="150" editable="false"/></td>
                <td class="td_font">用户活动期限领总次数：</td>
                <td><ai:dbformfield formid="saleTelPartsAppriseForm" fieldname="MAX_RECEIVENUM_INLIQUID" width="150" editable="false"/></td>
            </tr>
            <tr>
                <td class="td_font">用户参与活动周期：</td>
                <td><ai:dbformfield formid="saleTelPartsAppriseForm" fieldname="PARTICIPATE_CYCLE" width="150" editable="false"/></td>
                <td class="td_font">周期内限领次数：</td>
                <td><ai:dbformfield formid="saleTelPartsAppriseForm" fieldname="MAX_RECEIVENUM_INCYCLE" width="150" editable="false"/></td>
            </tr>
            <tr>
                <td class="td_font">触发条件：</td>
                <td><ai:dbformfield formid="saleTelPartsAppriseForm" fieldname="TRIGGER_CONDITION" width="150" editable="false"/></td>
                <td class="td_font">渠道、资金种类限制：</td>
                <td><ai:dbformfield formid="saleTelPartsAppriseForm" fieldname="CHANNEL_CHARGE_PROP" width="200" editable="false"/></td>
            </tr>
            <tr>
                <td class="td_font">券别面额及属性：</td>
                <td><ai:dbformfield formid="saleTelPartsAppriseForm" fieldname="USE_BUSI_PERSON" width="150" editable="false"/></td>
                <td class="td_font">领用商户范围：</td>
                <td><ai:dbformfield formid="saleTelPartsAppriseForm" fieldname="RECEIVE_BUSI_PROP" width="150" editable="false"/></td>
            </tr>
            <tr>
                <td class="td_font">适用商户范围：</td>
                <td><ai:dbformfield formid="saleTelPartsAppriseForm" fieldname="RECEIVE_BUSI_PERSON" height="50" width="450"/><span class="font_red">*</span></td>
            </tr>
            <tr ><td class="td_font">说明：</td><td>列出专用券适用商户的商户远程、现场编号及对应的商户名称</td></tr>
            <tr>
               <td class="td_font">是否需要到账短信：</td>
                <td><ai:dbformfield formid="saleTelPartsAppriseForm" fieldname="ARRIVE_OF_MONEY_SMS" width="150"/></td>
            </tr>
            <tr id="telparts_aom_sms_id" style="display: block;">
                <td class="td_font">到账短信内容：</td>
                <td><ai:dbformfield formid="saleTelPartsAppriseForm" fieldname="AOM_SMS_CONTENT" height="50" width="450"/><span class="font_red">*</span></td>
            </tr>
            <tr id="telparts_aom_sms_case" style="display: block;"><td class="td_font"><span class="font_red">到账短信内容参考模板：</span></td>
            <td colspan="3"><span class="font_green">恭喜您参加XX活动获得[$]元手机配件专用电子券，有效期XX天，请在XX商户消费。详询12580（供参考，XX为需要填写的地方，商户需注明可消费的商户名称，有效期建议7-30天，不超过90天）</span></td></tr>
            <tr>
                <td class="td_font">是否需要到期短信：</td>
                <td colspan="3"><ai:dbformfield formid="saleTelPartsAppriseForm" fieldname="OUT_OF_DATE_SMS" width="150"/></td>
            </tr>
            <tr id="telparts_ofd_sms_day" style="display: block;"><td class="td_font">提前几天进行到期短信提醒：</td>
            	<td><ai:dbformfield formid="saleTelPartsAppriseForm" fieldname="REMARK1" width="50"/> 天(少于或等于15天)<span class="font_red">*</span></td></tr>
            <tr id="telparts_ofd_sms_id" style="display: block;">
                <td class="td_font">到期短信内容：</td>
                <td colspan="3"><ai:dbformfield formid="saleTelPartsAppriseForm" fieldname="OFD_SMS_CONTENT" height="50" width="450"/><span class="font_red">*</span></td>
            </tr>
            <tr id="telparts_ofd_sms_case" style="display: block;"><td class="td_font"><span class="font_red">到期短信内容参考模板：</span></td>
            	<td colspan="3"><span class="font_green">尊敬的客户！您的手机配件专用券将于[$]到期失效，请于到期前在XX商家现场消费。详询12580（供参考，XX为需要填写的地方，商户需注明可消费的商户名称）</span></td></tr>
        </table>
   </ai:dbform>
</ai:contractframe>

