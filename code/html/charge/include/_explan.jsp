<%@ page contentType="text/html; charset=GBK"%>
<ai:contractframe id="saleOtherframe" contenttype="table" title="�����ʷѷ���ģ������" width="100%" allowcontract="true" frameclosed="fale">
    <ai:contractitem/>
    
        <table width="98%" align="center" border="0" cellpadding="1" cellspacing="2">
        	 <tr>
                <td colspan="6"><B>���ù���Ϊ�����������أ�������ϴ�����,�ô�Ϊ����ģ��</B></td>
            </tr>
            <tr>
            	<td colspan="6">����ģ�棺<a href="javascript:downTemplate(7)"><span style="font-style:italic; font-weight:normal; TEXT-DECORATION: underline; color:blue; ">һ������������Ʒ����.xlsx</span></a></td></tr>
            </tr>
            <tr><td><br/></td></tr><!--
           
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
        --></table>
   
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