<%@ page contentType="text/html; charset=GBK"%>
<%@ include file="/secframe/common/common.jsp"%>
<%@include file="/webframe/common/commonhead.jsp"%>

<html>
<head>
<title>延时说明</title>
<script language="javascript" src="<%=request.getContextPath()%>/jsv2/Calendar.jsp" type="text/javascript"></script>
</head>
<body onload="init()">
<ai:contractframe id="delayiframe" contenttype="table" title="填写延时原因" width="100%" allowcontract="false" frameclosed="false">
<ai:contractitem/>
<ai:dbform formid="delayReasonForm" 
			setname="com.asiainfo.bi.web.SETTaskNodeDT"
			conditionname="condition" parametersname="parameters"
			onvalchange="" editable="true" initial="false"
			datamodel="com.ai.appframe2.web.datamodel.MethodModelForService"
			implservice_name="com.asiainfo.common.service.interfaces.IItemOtherInfoSV"
			implservice_querymethod="getItemOtherInfoByIdAndTag(String itemId, String taskTag)">
		<table width="98%" align="center" border="0" cellpadding="1" cellspacing="2">
		    <tr>
		    	<td class="td_font">延时原因：</td>
		    	<td><ai:dbformfield formid="delayReasonForm" fieldname="DELAY_REASON" width="600" height="150"/></td>
		    </tr>
		</table>
	</ai:dbform>
</ai:contractframe>
<table align = "center" id="tablefalse">
    <ai:button id="certain" text="提交" onclick="submit()"/>
	<ai:button id="cansel" text="关闭" onclick="cancel()"/>
</table>
</body>
<script language="javascript" src="<%=request.getContextPath()%>/sale/common/js/openSelect.js"></script>
<script type="text/javascript">

var itemId = "<%=request.getParameter("itemId")%>";
var taskTag = "<%=request.getParameter("taskTag")%>";
var delayReasonForm = g_FormRowSetManager.get("delayReasonForm");

function init(){
	
	delayReasonForm.refresh('itemId=' + itemId + '&taskTag=' + taskTag);
}

function cancel()
{
	top.close();
}

function submit()
{
	var delayReason = delayReasonForm.getValue("DELAY_REASON");
	if(trim(delayReason) == '') return alert("请填写好原因！");
    var condition = 'itemId=' + itemId + '&taskTag=' + taskTag + '&delayReason=' + delayReason;
	var strUrl = _gModuleName+'/business/com.asiainfo.common.web.ItemOtherInfoAction?action=saveItemOtherInfo&'+condition;
	var recode = PostInfo(strUrl);
	if (recode.getValueByName("FLAG") == "Y") {
		alert("提交成功！");
		top.close();
	} else {
		alert("提交失败！");
		return;
	}
}

function trim(str)
{
     return str.replace(/(^\s*)(\s*$)/g, '');
}
</script>
</html>
