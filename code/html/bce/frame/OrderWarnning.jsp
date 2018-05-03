<%@ page contentType="text/html; charset=GBK"%>
<%@ include file="/bce/frame/BceFrameHead.jsp"%>
<%@page import="com.ai.bce.auto.plugin.qr.PrintUtil"%>
<%@page import="com.ai.appframe2.web.HttpUtil"%>
<%@page import="com.ai.bce.util.BceUtil"%>
<%
	long bceFrameId = HttpUtil.getAsLong(request,
			BceUtil.BCE_FRAME_ID_KEY);
	String businessId = HttpUtil.getAsString(request,
			BceUtil.BUSIOPER_ID_KEY);;
	String content = PrintUtil.getWarnContent(bceFrameId, businessId,
			"-1", "-1");
	if(StringUtils.isNotBlank(content)){
%>

<ai:contractframe i18nRes="CRM" id="OMS3000200" contenttype="table"
	title="OMS3000200" width="100%" allowcontract="false"
	frameclosed="false">
	<ai:contractitem></ai:contractitem>
	<div style="line-height: 22px;padding:10px 20px;text-align:left;" id="content_warn" name="content_warn">

		<%=content%>
	</div>
</ai:contractframe>
<%} %>
<script type="text/javascript">
/**
 * 设置改变值：
 */
function ChangeWarnning(businessId,bceFrameId,changeName,changeValue){
	var url = _gModuleName + "/business/com.ai.bce.web.BceFrameAction?action=getWarnNingContent&BUSINESS_ID="+businessId+"&BCE_FRAME_ID="+bceFrameId+"&CHANGE_NAME="+changeName+"&CHANGE_VALUE="+changeValue;
    //alert(url);
	var reVal = PostInfo(url,"");
	var ret = reVal.getValueByName("FALG");
	if(ret =='N'){
		//alert("获取提醒内容出错");
        alert(crm_i18n_msg("BEC0000342"));
		return;
	}
	var content  = reVal.getValueByName("CONTENT");
	ChangeWarning_Text(content);
}

function ChangeWarning_Text(typeContent){
	var warnning  = document.getElementById('content_warn');
	warnning.innerHTML = typeContent;
}
function ChangeWarnningValue(src,value){
	var warnObj= document.getElementById("WARN_"+src);
	warnObj.innerHTML=value;
}
</script>
