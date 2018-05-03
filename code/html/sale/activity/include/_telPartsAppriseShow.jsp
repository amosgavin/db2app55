<%@ page contentType="text/html; charset=GBK"%>
<%@ include file="/secframe/common/common.jsp"%>
<%@include file="/webframe/common/commonhead.jsp"%>

<ai:contractframe id="saleTelPartsAppriseframe" contenttype="table" title="�ֻ��������ר�õ���ȯӪ�����浥" width="100%" allowcontract="true" frameclosed="true">
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
            <tr id="telparts_aom_sms_id" style="display: block;">
                <td class="td_font">���˶������ݣ�</td>
                <td><ai:dbformfield formid="saleTelPartsAppriseForm" fieldname="AOM_SMS_CONTENT" height="50" width="450"/><span class="font_red">*</span></td>
            </tr>
            <tr id="telparts_aom_sms_case" style="display: block;"><td class="td_font"><span class="font_red">���˶������ݲο�ģ�壺</span></td>
            <td colspan="3"><span class="font_green">��ϲ���μ�XX����[$]Ԫ�ֻ����ר�õ���ȯ����Ч��XX�죬����XX�̻����ѡ���ѯ12580�����ο���XXΪ��Ҫ��д�ĵط����̻���ע�������ѵ��̻����ƣ���Ч�ڽ���7-30�죬������90�죩</span></td></tr>
            <tr>
                <td class="td_font">�Ƿ���Ҫ���ڶ��ţ�</td>
                <td colspan="3"><ai:dbformfield formid="saleTelPartsAppriseForm" fieldname="OUT_OF_DATE_SMS" width="150"/></td>
            </tr>
            <tr id="telparts_ofd_sms_day" style="display: block;"><td class="td_font">��ǰ������е��ڶ������ѣ�</td>
            	<td><ai:dbformfield formid="saleTelPartsAppriseForm" fieldname="REMARK1" width="50"/> ��(���ڻ����15��)<span class="font_red">*</span></td></tr>
            <tr id="telparts_ofd_sms_id" style="display: block;">
                <td class="td_font">���ڶ������ݣ�</td>
                <td colspan="3"><ai:dbformfield formid="saleTelPartsAppriseForm" fieldname="OFD_SMS_CONTENT" height="50" width="450"/><span class="font_red">*</span></td>
            </tr>
            <tr id="telparts_ofd_sms_case" style="display: block;"><td class="td_font"><span class="font_red">���ڶ������ݲο�ģ�壺</span></td>
            	<td colspan="3"><span class="font_green">�𾴵Ŀͻ��������ֻ����ר��ȯ����[$]����ʧЧ�����ڵ���ǰ��XX�̼��ֳ����ѡ���ѯ12580�����ο���XXΪ��Ҫ��д�ĵط����̻���ע�������ѵ��̻����ƣ�</span></td></tr>
        </table>
   </ai:dbform>
</ai:contractframe>

