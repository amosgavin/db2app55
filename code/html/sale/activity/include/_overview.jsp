<%@ page contentType="text/html; charset=GBK"%>
<ai:contractframe id="saleMainOverviewframe" contenttype="table" title="Ӫ������Ҫ��Ϣ" width="100%" allowcontract="true" frameclosed="fale">
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
                <td colspan="6"><b>��Ҫ����</b></td>
           </tr><tr>
                <td class="td_font">Ӫ�������ƣ�</td>
                <td colspan="5"><ai:dbformfield formid="saleMainOverviewForm" fieldname="SALE_MAIN_NAME" width="350" />
                    <ai:dbformfield formid="saleMainOverviewForm" fieldname="MAINID" visible="false"/></td>
           </tr>
           <tr style="display: none;">
                <td class="td_font">���룺</td>
                <td colspan="5"><ai:dbformfield formid="saleMainOverviewForm" fieldname="SALE_MAIN_CODE" width="200"/>
           </tr>
           <tr>
                <td class="td_font">������</td>
                <td colspan="5"><ai:dbformfield formid="saleMainOverviewForm" fieldname="BACK_GROUND" height="86" width="650"/></td>
            </tr>
            <tr>
                <td class="td_font">Ŀ�꣺</td>
                <td colspan="5"><ai:dbformfield formid="saleMainOverviewForm" fieldname="AIM" height="86" width="650"/></td>
            </tr>
            <tr>
                <td class="td_font">��ϸ��</td>
                <td colspan="5"><ai:dbformfield formid="saleMainOverviewForm" fieldname="CONTENT" height="86" width="650"/></td>
            </tr>
            <tr>
                <td colspan="6"><b>һ�������</b></td>
            </tr>
            <tr>
                <td class="td_font">��ʼʱ�䣺</td>
                <td><ai:dbformfield formid="saleMainOverviewForm" fieldname="BEGIN_TIME" width="150"/></td>
                <td class="td_font">����ʱ�䣺</td>
                <td><ai:dbformfield formid="saleMainOverviewForm" fieldname="END_TIME" width="150"/></td>
                <td class="td_font">ִ�з�Χ��</td>
                <td><ai:dbformfield formid="saleMainOverviewForm" fieldname="EXEAREA" width="150"/>
            </tr>
            <tr>
                <%-- <td class="td_font">�Ƿ�����Ϣ����</td>
    			<td><ai:dbformfield formid="saleMainOverviewForm" fieldname="ISGROUP" width="150"/></td>--%>
                <td class="td_font">�Ƿ�����Ӫ����</td>
                <td><ai:dbformfield formid="saleMainOverviewForm" fieldname="ISACTIVE_SALE" width="150"/></td>
                <td class="td_font">����Ӫ���㣺</td>
                <td colspan="3"><ai:dbformfield formid="saleMainOverviewForm" fieldname="ACTIVE_SALE_SITE"  width="400"/></td>
            </tr>
            <tr>
                <td colspan="6"><b>����ϸ���г�</b></td>
            </tr>
            <tr>
                <td class="td_font"></td>
                <td colspan="5"><ai:dbformfield formid="saleMainOverviewForm" fieldname="MARKTYPE" width="400"/>
            </tr>
            <%-- <TR>
            <td class="td_font">���ŵ�λ���ԣ�</td>
             <td><ai:dbformfield formid="saleMainOverviewForm" fieldname="GROUP_PROP" width="150"/></td>
             <td class="td_font">Ӫ������</td>
             <td><ai:dbformfield formid="saleMainOverviewForm" fieldname="SALE_OBJECT" width="150"/></td>
             <td class="td_font">����ͣ�</td>
             <td><ai:dbformfield formid="saleMainOverviewForm" fieldname="ACTIVITY_TYPE" width="150"/></td>
            </TR> --%>
            <tr>
                <td colspan="6"><b>����ҵ��չĿ�����</b></td>
            </tr>
            <tr>
               <td class="td_font">Ԥ���û���ģ��</td>
               <td><ai:dbformfield formid="saleMainOverviewForm" fieldname="PRE_PERSON" width="150"/></td>
               <%--<td class="td_font">�����û�Ŀ�꣺</td>
               <td><ai:dbformfield formid="saleMainOverviewForm" fieldname="PRE_ADD_PERSON" width="150"/></td>
               --%><td class="td_font">Ԥ�����룺</td>
               <td colspan="3"><ai:dbformfield formid="saleMainOverviewForm" fieldname="PRE_INCOME" width="150"/>(Ԫ)</td>
             </tr>
        <%--<tr>
            <td class="td_font">����Ŀ�꣺</td>
            <td colspan="5"><ai:dbformfield formid="saleMainOverviewForm" fieldname="OTHER_BUSI_TARGET" width="150"/></td>
            </tr>
            --%>
            <tr>
                <td colspan="6"><b>�ġ�Ӫ����Դ����</b></td>
            </tr>
            <tr>
                <td class="td_font">��ԴͶ��ϼƣ�</td>
                <td colspan="5"><ai:dbformfield formid="saleMainOverviewForm" fieldname="COST_TOTAL" width="150"/>(Ԫ)</td>
            </tr>
            <tr>
                <td class="td_font">�ն˳ɱ���</td>
                <td><ai:dbformfield formid="saleMainOverviewForm" fieldname="MOBILE_COST" width="150"/>(Ԫ)</td>
                <td class="td_font">���ӹ���ȯ�ɱ���</td>
                <td><ai:dbformfield formid="saleMainOverviewForm" fieldname="ELECPAY_COST" width="150"/>(Ԫ)</td>
                <td class="td_font">�ֻ�֧�������</td>
                <td><ai:dbformfield formid="saleMainOverviewForm" fieldname="MOBILEPAY_COST" width="150"/>(Ԫ)</td>
            </tr>
            <tr>
                <td class="td_font">�������ȯ��</td>
                <td><ai:dbformfield formid="saleMainOverviewForm" fieldname="ELECGOODS_COST" width="150"/>(Ԫ)</td>
                <td class="td_font">��Ʒ�ɱ���</td>
                <td><ai:dbformfield formid="saleMainOverviewForm" fieldname="GOODS_COST" width="150"/>(Ԫ)</td>
                <td class="td_font">�����ۿۣ�</td>
                <td><ai:dbformfield formid="saleMainOverviewForm" fieldname="FEE_DISCOUNT" width="150"/>(Ԫ)</td>
            </tr>
            <tr>
                <td class="td_font">ҵ���ۿۣ�</td>
                <td><ai:dbformfield formid="saleMainOverviewForm" fieldname="BUSINESS_DISCOUNT" width="150"/>(Ԫ)</td>
                <td class="td_font">�������</td>
                <td><ai:dbformfield formid="saleMainOverviewForm" fieldname="CHANNEL_PAY" width="150"/>(Ԫ)</td>
                <td class="td_font">��������ѣ�</td>
                <td><ai:dbformfield formid="saleMainOverviewForm" fieldname="ESTIMATE_AD_FEE" width="150"/>(Ԫ)</td>
            </tr>
            <tr>
                <td class="td_font">������</td>
                <td colspan="5"><ai:dbformfield formid="saleMainOverviewForm" fieldname="ESTIMATE_OTHER_FEE" width="150"/>(Ԫ)</td>
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