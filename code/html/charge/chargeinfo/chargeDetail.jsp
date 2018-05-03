<%@ page contentType="text/html; charset=GBK"%>
<%@ include file="/secframe/common/common.jsp"%>
<%@include file="/webframe/common/commonhead.jsp"%>
<html>
<head>
<title>资费详细</title>
<script type="text/javascript">
//0918
function resetTabitem(feeType,applyId,mid,state,feeName,taskId,zfbmmark,typecards,isSendSmsVal,taskTag) {
	refreshTabItem("chargeTab","charge_2","业务规则信息","chargeBusiRules.jsp?mid="+mid+"&state="+state);
	refreshTabItem("chargeTab","charge_1","资费信息","chargeDetailInfo.jsp?feeType="+feeType+"&applyId="+applyId+"&mid="+mid+"&state="+state+"&feeName="+feeName+
	                                                                  "&taskId="+taskId+"&zfbmmark="+zfbmmark+"&typecards="+typecards + "&taskTag="+taskTag+
	                                                                  "&isSendSmsVal="+isSendSmsVal+"&userSms="+userSms+"&isNewFee="+isNewFee);
}
function getTabitem(tabId,itemId) {
    return document.getElementById(tabId + "_" + itemId);
}
</script>
</head>
<body>
<ai:tab id="chargeTab" width="100%" type="h" height="100%" beforeSetTab="">
   <ai:tabitem id="charge_1" title="" src="" />
   <ai:tabitem id="charge_2" title="" src=""/>
</ai:tab>
</body>
</html>
<script type="text/javascript">
var feeType="<%=request.getParameter("feeType")%>";
var applyId="<%=request.getParameter("applyId")%>";
var mid="<%=request.getParameter("mid")%>";
var state="<%=request.getParameter("state")%>";
var taskId="<%=request.getParameter("taskId")%>";
var taskTag="<%=request.getParameter("taskTag")%>";
var feeName="<%=request.getParameter("feeName")%>";
//0918
var zfbmmark="<%=request.getParameter("zfbmmark")%>";
var typecards="<%=request.getParameter("typecards")%>";
//var feeName="<%=new String(request.getParameter("feeName").trim().getBytes("GBK"))%>";
//var feeName="<%=new String(request.getParameter("feeName").trim().getBytes("ISO-8859-1"))%>";

var isSendSmsVal="<%=request.getParameter("isSendSmsVal")%>";
var userSms="<%=request.getParameter("userSms")%>";

var isNewFee="<%=request.getParameter("isNewFee")%>";

resetTabitem(feeType,applyId,mid,state,feeName,taskId,zfbmmark,typecards,isSendSmsVal,taskTag);
</script>