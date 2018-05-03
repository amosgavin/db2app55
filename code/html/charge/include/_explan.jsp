<%@ page contentType="text/html; charset=GBK"%>
<ai:contractframe id="saleOtherframe" contenttype="table" title="电渠资费发布模板下载" width="100%" allowcontract="true" frameclosed="fale">
    <ai:contractitem/>
    
        <table width="98%" align="center" border="0" cellpadding="1" cellspacing="2">
        	 <tr>
                <td colspan="6"><B>若该工单为电子渠道承载，则必须上传附件,该处为附件模板</B></td>
            </tr>
            <tr>
            	<td colspan="6">下载模版：<a href="javascript:downTemplate(7)"><span style="font-style:italic; font-weight:normal; TEXT-DECORATION: underline; color:blue; ">一级自有渠道商品发布.xlsx</span></a></td></tr>
            </tr>
            <tr><td><br/></td></tr><!--
           
            <tr>
                <td colspan="6">特殊情况说明：&nbsp;&nbsp;<a href="javascript:include_showOffInfo('SPECIALNOTE')"><font color="red">填写说明</font></a></td>
            </tr>
            <tr>
                <td colspan="6"><ai:dbformfield formid="saleMainExplanForm" fieldname="SPECIALNOTE" height="100" width="650"/></td>
            </tr>
            <tr id='SPECIALNOTE' style='display: none;'>
                <td colspan="6"><font color="blue"> 1、 若需身份证件/密码办理，则要说明非实名制/无密码客户是否可以参与，如何参与；<br/>
                                2、 对于带保底要求的营销案，若参与的客户停机保号，需明确保底是否继续收取；<br/>
                                3、 营销案的办理权限管理，如只限自办厅、只限市公司特定部门、只限指定工号等；<br/>
                                4、 明确营销案客户是否可以重复参加；<br/>
                                5、 明确参与营销案的客户，能否再办理分合户、过户、等付费账户发生变化的业务；<br/>
                                6、 明确可参与营销案的客户其付费方式的要求，如仅限现金客户；<br/>
                                7、 明确已合户客户的参与原则，即一个账户下多个用户，每个用户(号码)是否可以分别参与营销案；</font></td>
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