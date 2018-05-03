<%@ page contentType="text/html; charset=GBK"%>
<ai:contractframe id="saleOtherframe" contenttype="table" title="模板下载(电子渠道承载)" width="100%" allowcontract="true" frameclosed="fale">
    <ai:contractitem/>
    
        <table width="98%" align="center" border="0" cellpadding="1" cellspacing="2">
        	 <tr>
                <td colspan="6"><B>若该工单为电子渠道承载，则必须上传附件,该处为附件模板</B></td>
            </tr>
            <tr>
            	<td colspan="6">下载模版：<a href="javascript:downTemplate(7)"><span style="font-style:italic; font-weight:normal; TEXT-DECORATION: underline; color:blue; ">一级自有渠道商品发布.xlsx</span></a></td></tr>
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