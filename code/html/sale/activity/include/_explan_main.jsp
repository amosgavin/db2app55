<%@ page contentType="text/html; charset=GBK"%>
<ai:contractframe id="saleOtherframe" contenttype="table" title="ģ������(������������)" width="100%" allowcontract="true" frameclosed="fale">
    <ai:contractitem/>
    
        <table width="98%" align="center" border="0" cellpadding="1" cellspacing="2">
        	 <tr>
                <td colspan="6"><B>���ù���Ϊ�����������أ�������ϴ�����,�ô�Ϊ����ģ��</B></td>
            </tr>
            <tr>
            	<td colspan="6">����ģ�棺<a href="javascript:downTemplate(7)"><span style="font-style:italic; font-weight:normal; TEXT-DECORATION: underline; color:blue; ">һ������������Ʒ����.xlsx</span></a></td></tr>
            </tr>
            <tr><td><br/></td></tr></table>
   
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