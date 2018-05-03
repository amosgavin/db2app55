<%@ page contentType="text/html; charset=GBK"%>
<%@ include file="/secframe/common/common.jsp"%>
<%@include file="/webframe/common/commonhead.jsp"%>
<html>
<head>
<title>服务相关信息</title>
<script language="javascript" src="<%=request.getContextPath()%>/jsv2/Calendar.jsp" type="text/javascript"></script>
</head>
<body onload="initPage();">
<%@include file="/sale/activity/include/_mainShow_simple.jsp"%>
<%@include file="/sale/activity/include/_explan.jsp"%>
<div id="div_attach" style="display:block">
<%@include file="/sale/common/include/_attach.jsp"%>
</div>
<div class="area_button">
    <ai:button id="bt_saveSaleMainExplan" text="保存当前" onclick="doWork('saveSaleMainExplan()')"/>
    <ai:button id="bt_gotoOverview" text="下一步：确认及提交" onclick="doWork('gotoOverview()')"/>
</div>
</body>
</html>
<ai:loginuser/>
<script type="text/javascript">
var pageName = 'explan';
function initPage(){
    var orderId = "<%=request.getParameter("orderId")%>";
    if ("" == orderId || "null" == orderId){
        return;
    }
    _fromSaleOrderFormRowSet().refresh("&orderId="+orderId);
	include_refreshSaleMainTable(orderId);
	_include_fromSaleMainTabRowSet().setRow(0);
    //include_refreshSaleMainExplanForm(mainId);
    include_reflashAttachTable();
    include_attach_setButtonDisabled();
    var editable = "<%=request.getParameter("editable")%>";
    if (editable == "false") {
    	_include_fromSaleMainExplanFormRowSet().setEditSts(false);
    	setButtonDisabled();
    }
}

function saveSaleMainExplan()
{    
    if ("O" != _include_fromSaleMainExplanFormRowSet().getSts())
    {
        var list = new Array();
        list.push(_include_fromSaleMainExplanFormRowSet());
        var strUrl = _gModuleName + '/business/com.asiainfo.sale.activity.web.SaleMainAction?action=saveSaleMain';
        
        var recode = saveRowSet(strUrl, list);
    
        var mainId = recode.getValueByName("MAINID");
        var rFlag = recode.getValueByName("FLAG");
        return rFlag;
    } else {
        return "Y";
    }
   
}
function gotoOverview(){
	
    if ("Y" == saveSaleMainExplan())
    {
        window.parent.setTabItem("activityTab","activity_4");
    }
}

</script>
<script type="text/javascript">
function setButtonDisabled(){
	var taskId = "<%=request.getParameter("taskId")%>";
	if (taskId == null || taskId == '' || taskId == 'null') {
		include_attach_setButtonDisabled(true);
		g_AIButtonManager.get("importFile").setDisabled(true);
	} else {
		document.getElementById("div_attach").style.display="none";
	}
	document.getElementById('bt_saveSaleMainExplan').style.visibility='hidden';
	document.getElementById('bt_gotoOverview').style.visibility='hidden';
}
</script>
<script language="javascript" src="<%=request.getContextPath()%>/jsv2/AIWaitBanner.js"></script>
<script type="text/javascript">
function doWork(fun){ 
    beginAIWaitBanner(fun,"正在处理，请稍后...");
}
</script>
