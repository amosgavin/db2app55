<%@ page contentType="text/html; charset=GBK"%>
<ai:contractframe id="saleOtherframe" contenttype="table" title="���������Ϣ" width="100%" allowcontract="true" frameclosed="fale">
    <ai:contractitem/>
    <ai:dbform formid="saleMainExplanForm" 
            setname="com.asiainfo.sale.activity.web.SETSaleMain"
            conditionname="condition" parametersname="parameters"
            onvalchange="" editable="true" initial="false"
            datamodel="com.ai.appframe2.web.datamodel.MethodModelForService"
            implservice_name="com.asiainfo.sale.activity.service.interfaces.ISaleMainSV"
            implservice_querymethod="getSaleMainById(String id)">
        <table width="98%" align="center" border="0" cellpadding="1" cellspacing="2">
        	 <tr>
                <td colspan="6"><B>���ա�������˾�����·����й��ƶ�������˾Ӫ�������׼�򡷵�֪ͨ�������ƿ�[2014]767�ţ��ļ�Ҫ������Ӫ����������д����Ԥ����</B></td>
            </tr>
            <tr>
            	<td colspan="6">����ģ�棺<a href="javascript:downTemplate(1)"><span style="font-style:italic; font-weight:normal; TEXT-DECORATION: underline; color:blue; ">����Ԥ����.xlsx</span></a></td></tr>
            <tr><td colspan="6">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
            	<a href="javascript:downTemplate(3)"><span style="font-style:italic; font-weight:normal; TEXT-DECORATION: underline; color:blue; ">ҵ��Ӫ������˷���ģ��.xlsx</span></a></td></tr></tr>
            <tr><td><br/></td></tr>
            <!--  
            <tr>
                <td colspan="6">����������&nbsp;&nbsp;<a href="javascript:include_showOffInfo('PRORPLAN')"><font color="red">��д˵��</font></a></td>
            </tr>
            <tr>
                <td colspan="6"><ai:dbformfield formid="saleMainExplanForm" fieldname="PRORPLAN" height="56" width="650" editable="true"/>
                    <ai:dbformfield formid="saleMainExplanForm" fieldname="MAINID" width="50" visible="false"/></td>
            </tr>
            <tr id='PRORPLAN' style='display: none;'>
                <td colspan="6"><font color="blue"> 1�������ںţ�<br/>
                                 2��������ʽ���������㲥���ӡ���ֽ��־�������桢�������������չ����ӡˢ�����������ȣ�</font></td>
            </tr>
            <tr>
                <td colspan="6">�ͷ����Ϳھ���&nbsp;&nbsp;<a href="javascript:include_showOffInfo('EXPLANATION')"><font color="red">��д˵��</font></a></td>
            </tr>
            <tr>
                <td colspan="6"><ai:dbformfield formid="saleMainExplanForm" fieldname="EXPLANATION" height="160" width="650"/></td>
            </tr>
            <tr id='EXPLANATION' style='display: none;'>
                <td colspan="6"><font color="blue"> 1������һ�������������Ҫ������ʲô��<br/>
                                �ÿͻ��������Լ�Ҫ��������������(��Ҫ���㣩<br/>
                                2�����Ƿ��ܲ�����δ������<br/>
                                �����ͻ������ʸ�Ʒ��Ҫ�󣬻���Ҫ���<br/>
                                3���ҿ�����������а���<br/>
                                �������������Ͱ���ʽ<br/>
                                4���Ҳμ���λ��������Щ�Żݣ�<br/>
                                �����ͻ��������ܵ��Żݣ��ͻ��ѡ�����ȯ����Ʒ���նˡ�����ҵ��ȣ�<br/>
                                5���Ҳμӱ��λʲôʱ����Կ�ʼ�����Żݣ��Ż���ʲôʱ�������<br/>
                                �����Żݵĳ���ʱ��<br/>
                                6���Żݵ��ں��ҽ����ȡ��ҵ�񣿣�ֻ�������ҵ��Ӫ����<br/>
                                ����ȡ����ʽ<br/>
                                7��ÿ�·���ʱ����ʲôʱ��<br/>
                                ����ÿ�¸��ֽ��ķ���ʱ��<br/>
                                8���Ҳμӱ��λ����ʷѱ�׼��ʲô���Ƿ������ȡ�������ã�<br/>
                                �����ʷѱ�׼<br/>
                                9���Ƿ��б��׼�����Ҫ��<br/>
                                �����ͻ��踶���Ĵ��ۣ����֡����ס�����Ĳ�Ʒ�������ڣ�<br/>
                                10��������������ϻ�����Ԥ�滰�Ѽ����ױ�ʶ������ĸ������ϣ�<br/>
                                ����BOSSϵͳ�ж�Ӧ���ʶ��Ԥ�滰�Ѽ����ױ�ʶ��ӹ���<br/>
                                11���������Ƿ��SP������ҵ��<br/>
                                �����������Ƿ��SP������ҵ��<br/>
                                12�����Ƿ������ǰ��ֹ��Լ��<br/>
                                 ������Լ�Ƿ����ֹ������<br/>
                                13���μ�������û��ʲôҪ�ر�ע��ģ�<br/>
                                ��������Ĵ���ԭ��˵�������ɰ���ͣ�����ţ��������ԭ��ȣ���</font></td>
            </tr>
            -->
            <tr>
                <td colspan="6">����Ӫ��Ҫ��&nbsp;&nbsp;<a href="javascript:include_showOffInfo('SALEDEMAND')"><font color="red">��д˵��</font></a></td>
            </tr>
            <tr>
                <td colspan="6"><ai:dbformfield formid="saleMainExplanForm" fieldname="SALEDEMAND" height="80" width="650"/></td>
            </tr>
            <tr id='SALEDEMAND' style='display: none;'>
                <td colspan="6"><font color="blue"> 1������Ӫ���ʱ�䷶Χ��ʾ�� 4��1����4��30��<br/>
                                 2������Ӫ���û���ȡ����ʾ����GPRS5Ԫ�ײͣ�ARPU��30Ԫ����/�ֻ�֧������/����ͨ����������50��<br/>
                                 3������Ӫ�����<br/>
                                10086�һ����ţ�70�����ڣ�ʾ�����������ѵĵ绰�����������ʵ���������������Ľ�����й��ƶ������Ż�music.10086.cn���������³�������Բ��壬���족��72�䣬�������ǰ��ϸ����绰��<br/>
                                ������½���ţ�70�����ڣ�ʾ�����й��ƶ��ֻ������������ײͳ����ʷѣ�������ʡ����������ô�����ô�档��ʱ���졢�����ҳ���������ۡ��鿴��ͼ�����ֻ��������ϵ��ԡ�<br/>
                                ����ʹ�ö��ţ�70�����ڣ�ʾ��������Ʊ�����Ƶꡢ��·�ߡ����Żݡ����ʹ�12580���������ɸ㶨��С�¡��ƶ��ͻ��������ܲ�ѯ�����ѷ��͵��ֻ�����һ�ݱ�������һ�ݰ��ġ�</font></td>
            <!--  
            <tr>
                <td colspan="6">����ͳ��Ҫ��&nbsp;&nbsp;<a href="javascript:include_showOffInfo('STATREQUEST')"><font color="red">��д˵��</font></a></td>
            </tr>
            <tr>
                <td colspan="6"><ai:dbformfield formid="saleMainExplanForm" fieldname="STATREQUEST" height="60" width="650"/></td>
            </tr>
            <tr id='STATREQUEST' style='display: none;'>
                <td colspan="6"><font color="blue"> 1������ͳ�Ƶ�ָ�ꡢ�ھ���ȡ������<br/>
                                2�������ʽ��ģ��<br/>
                                3��ʵ�ֵ�ʱ��Ҫ��</font></td>
            </tr>
            <tr>
                <td colspan="6">�����ҵ����˷���(<font color="red">�����ģ����д</font>)&nbsp;&nbsp;<a href="javascript:include_showOffInfo('BUSINESSCHECKPLAN')"><font color="red">��д˵��</font></a></td>
            </tr>
            <tr>
                <td colspan="6"><ai:dbformfield formid="saleMainExplanForm" fieldname="BUSINESSCHECKPLAN" height="70" width="650"/></td>
            </tr>
            <tr id='BUSINESSCHECKPLAN' style='display: none;'>
                <td colspan="6"><font color="blue"> 1�� ���˸���λ/���ţ�<br/>
                                2�� �������ڣ�ÿ�ա�ÿѮ��ÿ�£�<br/>
                                3�� �������ݵ���Դ�����л���ϵͳ��ֹ�˾֧������������ȡ�ȣ�<br/>
                                4�� ���˵ķ�����������ˣ�������쳣���������������ȡ���ݺ�˲飻<br/>
                                5�� ���˲����ֲ᣺����ȫʡ���еĻ����ֶ�����Լ�Ҫ˵���������µĻ������ݣ������ṩ�꾡˵�����ϡ�</font></td>
            </tr>
            -->
            <tr>
                <td colspan="6">�������˵����&nbsp;&nbsp;<a href="javascript:include_showOffInfo('SPECIALNOTE')"><font color="red">��д˵��</font></a></td>
            </tr>
            <tr>
                <td colspan="6"><ai:dbformfield formid="saleMainExplanForm" fieldname="SPECIALNOTE" height="100" width="650"/></td>
            </tr>
            <tr id='SPECIALNOTE' style='display: none;'>
                <td colspan="6"><font color="blue"> 1�� �������֤��/���������Ҫ˵����ʵ����/������ͻ��Ƿ���Բ��룬��β��룻<br/>
                                2�� ���ڴ�����Ҫ���Ӫ������������Ŀͻ�ͣ�����ţ�����ȷ�����Ƿ������ȡ��<br/>
                                3�� Ӫ�����İ���Ȩ�޹�����ֻ���԰�����ֻ���й�˾�ض����š�ֻ��ָ�����ŵȣ�<br/>
                                4�� ��ȷӪ�����ͻ��Ƿ�����ظ��μӣ�<br/>
                                5�� ��ȷ����Ӫ�����Ŀͻ����ܷ��ٰ���ֺϻ����������ȸ����˻������仯��ҵ��<br/>
                                6�� ��ȷ�ɲ���Ӫ�����Ŀͻ��丶�ѷ�ʽ��Ҫ��������ֽ�ͻ���<br/>
                                7�� ��ȷ�Ѻϻ��ͻ��Ĳ���ԭ�򣬼�һ���˻��¶���û���ÿ���û�(����)�Ƿ���Էֱ����Ӫ������</font></td>
            </tr>
        </table>
    </ai:dbform>
</ai:contractframe>
<script type="text/javascript">
function _include_fromSaleMainExplanFormRowSet(){
    return g_FormRowSetManager.get("saleMainExplanForm");
}

function include_refreshSaleMainExplanForm(mainId) {
    _include_fromSaleMainExplanFormRowSet().refresh("&id=" + mainId);
}

function include_showOffInfo(obj)
{
    if (document.getElementById(obj).style.display == "none")
    {
        document.getElementById(obj).style.display = "block";
    } else {
        document.getElementById(obj).style.display = "none";
    }
}

function downTemplate(id) {
	var strUrl = '<%=request.getContextPath()%>/business/com.asiainfo.sale.common.web.AttachAction?action=downLoadFile&idList='+id;
    window.location.href = strUrl;
}
</script>