<%@ page contentType="text/html; charset=GBK"%>
<%@ include file="/secframe/common/common.jsp"%>
<%@include file="/webframe/common/commonhead.jsp"%>
<html>
<head>
<title><i18n:message key="logger.query.login.titile" res="i18n.secframe_resource"/></title>
<script language="javascript" src="<%=request.getContextPath()%>/jsv2/Calendar.jsp" type="text/javascript"></script>
</head>
<body>
<ai:loginuser/>
<%@include file="/sale/activity/include/_allSaleInfoShow.jsp"%>
<%@include file="/sale/activity/include/_eitAppriseShow.jsp"%>
<%@include file="/sale/activity/include/_telPayFeeAppriseShow.jsp"%>
<%@include file="/sale/activity/include/_telPartsAppriseShow.jsp"%>
<%@include file="/sale/activity/include/_overview.jsp"%>
<script type="text/javascript">
var pageName = 'overview';
var _templateCode = "";
var _flowType = "";
var _mainId = "";
var _orgId = g_GetUserInfo().ORG_ID;
if ("1003" == _orgId.substr(0,4) || "29" == _orgId.substr(0,2)) {
	_templateCode = "template.InternetSaleCaseApprove";
    _flowType = "saleCaseI";
} else if ("1010" == _orgId.substr(0,4)) {
	_templateCode = "template.ZqSaleFlow";
    _flowType = "saleCaseZQ";
} else if ("10" == _orgId.substr(0,2)){
    _templateCode = "template.ProvinceSaleCaseApprove";
    _flowType = "saleCase";
} else {
    _templateCode = "template.TownSaleCaseApprove";
    _flowType = "saleCaseT";
}

</script>
<div id="div_createWorkflow" style="display:none">
<%@include file="/sale/common/include/_createWF.jsp"%>
</div>
</body>
</html>
<script type="text/javascript">
function initPage(){
    var orderId = "<%=request.getParameter("orderId")%>";
    _mainId = orderId;
    if ("" == orderId || "null" == orderId){
        return;
    }
    _fromSaleOrderFormRowSet().refresh("&orderId="+orderId);
	include_refreshAllSaleInfoTable(orderId);
    var editable = "<%=request.getParameter("editable")%>";
    if (editable == "false") {
    	//_include_fromSaleMainExplanFormRowSet().setEditSts(false);
    	setButtonDisabled(true);
    } else {
    	setButtonDisabled(false);
    }
    //_mainId = _include_fromSaleMainFormRowSet().getValue("MAINID");
    //include_refreshSaleMainOverviewForm(_mainId);
}

function refreshSaleMainOverviewForm(orderId){
	include_refreshSaleMainOverviewForm(orderId);
	_mainId = orderId;
}

function _fromWfCheckFormRowSet(){
	return g_FormRowSetManager.get("wfCheckForm");
}

function test1()
{
	_fromSaleDetailFormRowSet.refreshListBox("SALE_FLAG","codeType=qd",true);
}
</script>
<script type="text/javascript">
function setButtonDisabled(style){
    if (true == style || false == style){
    	if(style){
            document.getElementById("div_createWorkflow").style.display="none";
    	} else {
            document.getElementById("div_createWorkflow").style.display="block";
    	}
        include_setButtonDisabled(style);
    } else {
        setButtonDisabled(include_setButtonDisabled());
    }
}
</script>
<script language="javascript" src="<%=request.getContextPath()%>/jsv2/AIWaitBanner.js"></script>
<script type="text/javascript">
function doWork(fun){ 
    beginAIWaitBanner(fun,"正在处理，请稍后...");
}
</script>
<script type="text/javascript">
function addLoadEvent(func) {  
    var oldonload = window.onload;  
    if(typeof window.onload != "function"){  
        window.onload = func;  
    }else{  
        window.onload = function(){  
            oldonload();  
            func();  
        }  
    }  
}  
addLoadEvent(initPage);
addLoadEvent(initCheckPage);
</script>
