<%@ page contentType="text/html; charset=GBK"%>
<ai:contractframe id="saleMainOverviewframe" contenttype="table" title="营销案主要信息" width="100%" allowcontract="true" frameclosed="fale">
    <ai:contractitem/>
    <ai:dbform formid="saleMainOverviewForm" 
            setname="com.asiainfo.sale.activity.web.SETSaleMainShow"
            conditionname="condition" parametersname="parameters"
            onvalchange="" editable="false" initial="false"
            datamodel="com.ai.appframe2.web.datamodel.MethodModelForService"
            implservice_name="com.asiainfo.sale.activity.service.interfaces.ISaleMainShowSV"
            implservice_querymethod="getSaleMainOverviewById(String id)">
        <table width="98%" align="center" border="0" cellpadding="1" cellspacing="2" bordercolor="blue">
           <tr>
                <td colspan="6"><b>主要内容</b></td>
           </tr><tr>
                <td class="td_font">营销案名称：</td>
                <td colspan="5"><ai:dbformfield formid="saleMainOverviewForm" fieldname="SALE_MAIN_NAME" width="350" />
                    <ai:dbformfield formid="saleMainOverviewForm" fieldname="MAINID" visible="false"/></td>
           </tr>
           <tr style="display: none;">
                <td class="td_font">编码：</td>
                <td colspan="5"><ai:dbformfield formid="saleMainOverviewForm" fieldname="SALE_MAIN_CODE" width="200"/>
           </tr>
           <tr>
                <td class="td_font">背景：</td>
                <td colspan="5"><ai:dbformfield formid="saleMainOverviewForm" fieldname="BACK_GROUND" height="86" width="650"/></td>
            </tr>
            <tr>
                <td class="td_font">目标：</td>
                <td colspan="5"><ai:dbformfield formid="saleMainOverviewForm" fieldname="AIM" height="86" width="650"/></td>
            </tr>
            <tr>
                <td class="td_font">详细：</td>
                <td colspan="5"><ai:dbformfield formid="saleMainOverviewForm" fieldname="CONTENT" height="86" width="650"/></td>
            </tr>
            <tr>
                <td colspan="6"><b>一、活动概述</b></td>
            </tr>
            <tr>
                <td class="td_font">开始时间：</td>
                <td><ai:dbformfield formid="saleMainOverviewForm" fieldname="BEGIN_TIME" width="150"/></td>
                <td class="td_font">结束时间：</td>
                <td><ai:dbformfield formid="saleMainOverviewForm" fieldname="END_TIME" width="150"/></td>
                <td class="td_font">执行范围：</td>
                <td><ai:dbformfield formid="saleMainOverviewForm" fieldname="EXEAREA" width="150"/>
            </tr>
            <tr>
                <%-- <td class="td_font">是否集团信息化：</td>
    			<td><ai:dbformfield formid="saleMainOverviewForm" fieldname="ISGROUP" width="150"/></td>--%>
                <td class="td_font">是否主动营销：</td>
                <td><ai:dbformfield formid="saleMainOverviewForm" fieldname="ISACTIVE_SALE" width="150"/></td>
                <td class="td_font">主动营销点：</td>
                <td colspan="3"><ai:dbformfield formid="saleMainOverviewForm" fieldname="ACTIVE_SALE_SITE"  width="400"/></td>
            </tr>
            <tr>
                <td colspan="6"><b>二、细分市场</b></td>
            </tr>
            <tr>
                <td class="td_font"></td>
                <td colspan="5"><ai:dbformfield formid="saleMainOverviewForm" fieldname="MARKTYPE" width="400"/>
            </tr>
            <%-- <TR>
            <td class="td_font">集团单位属性：</td>
             <td><ai:dbformfield formid="saleMainOverviewForm" fieldname="GROUP_PROP" width="150"/></td>
             <td class="td_font">营销对象：</td>
             <td><ai:dbformfield formid="saleMainOverviewForm" fieldname="SALE_OBJECT" width="150"/></td>
             <td class="td_font">活动类型：</td>
             <td><ai:dbformfield formid="saleMainOverviewForm" fieldname="ACTIVITY_TYPE" width="150"/></td>
            </TR> --%>
            <tr>
                <td colspan="6"><b>三、业务发展目标估算</b></td>
            </tr>
            <tr>
               <td class="td_font">预计用户规模：</td>
               <td><ai:dbformfield formid="saleMainOverviewForm" fieldname="PRE_PERSON" width="150"/></td>
               <%--<td class="td_font">新增用户目标：</td>
               <td><ai:dbformfield formid="saleMainOverviewForm" fieldname="PRE_ADD_PERSON" width="150"/></td>
               --%><td class="td_font">预计收入：</td>
               <td colspan="3"><ai:dbformfield formid="saleMainOverviewForm" fieldname="PRE_INCOME" width="150"/>(元)</td>
             </tr>
        <%--<tr>
            <td class="td_font">其他目标：</td>
            <td colspan="5"><ai:dbformfield formid="saleMainOverviewForm" fieldname="OTHER_BUSI_TARGET" width="150"/></td>
            </tr>
            --%>
            <tr>
                <td colspan="6"><b>四、营销资源估算</b></td>
            </tr>
            <tr>
                <td class="td_font">资源投入合计：</td>
                <td colspan="5"><ai:dbformfield formid="saleMainOverviewForm" fieldname="COST_TOTAL" width="150"/>(元)</td>
            </tr>
            <tr>
                <td class="td_font">终端成本：</td>
                <td><ai:dbformfield formid="saleMainOverviewForm" fieldname="MOBILE_COST" width="150"/>(元)</td>
                <td class="td_font">电子购物券成本：</td>
                <td><ai:dbformfield formid="saleMainOverviewForm" fieldname="ELECPAY_COST" width="150"/>(元)</td>
                <td class="td_font">手机支付红包：</td>
                <td><ai:dbformfield formid="saleMainOverviewForm" fieldname="MOBILEPAY_COST" width="150"/>(元)</td>
            </tr>
            <tr>
                <td class="td_font">电子提货券：</td>
                <td><ai:dbformfield formid="saleMainOverviewForm" fieldname="ELECGOODS_COST" width="150"/>(元)</td>
                <td class="td_font">货品成本：</td>
                <td><ai:dbformfield formid="saleMainOverviewForm" fieldname="GOODS_COST" width="150"/>(元)</td>
                <td class="td_font">话费折扣：</td>
                <td><ai:dbformfield formid="saleMainOverviewForm" fieldname="FEE_DISCOUNT" width="150"/>(元)</td>
            </tr>
            <tr>
                <td class="td_font">业务折扣：</td>
                <td><ai:dbformfield formid="saleMainOverviewForm" fieldname="BUSINESS_DISCOUNT" width="150"/>(元)</td>
                <td class="td_font">渠道酬金：</td>
                <td><ai:dbformfield formid="saleMainOverviewForm" fieldname="CHANNEL_PAY" width="150"/>(元)</td>
                <td class="td_font">广告宣传费：</td>
                <td><ai:dbformfield formid="saleMainOverviewForm" fieldname="ESTIMATE_AD_FEE" width="150"/>(元)</td>
            </tr>
            <tr>
                <td class="td_font">其他：</td>
                <td colspan="5"><ai:dbformfield formid="saleMainOverviewForm" fieldname="ESTIMATE_OTHER_FEE" width="150"/>(元)</td>
            </tr>
        </table>
    </ai:dbform>
</ai:contractframe>
<script type="text/javascript">
function _include_fromSaleMainOverviewFormRowSet(){
    return g_FormRowSetManager.get("saleMainOverviewForm");
}
function include_refreshSaleMainOverviewForm(mainId) {
	if (mainId == null || mainId == "") return;
    _include_fromSaleMainOverviewFormRowSet().refresh("&id=" + mainId);
}
</script>