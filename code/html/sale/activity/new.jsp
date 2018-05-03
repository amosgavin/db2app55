<%@ page contentType="text/html; charset=GBK"%>
<%@ include file="/secframe/common/common.jsp"%>
<%@include file="/webframe/common/commonhead.jsp"%>
<html>
<head>
<title>编辑营销案</title>
<script type="text/javascript">
var isNew = true;
function checkTab(aOldItemId,aNewItemId) {
	if(isNew){
		return true;
	}
	if("activity_1" == aNewItemId){
		return true;
	} else if(!isDoJump("activityTab",aNewItemId)) {
        alert("在查看其他页签时，请先填写并保存“营销活动主要信息”！");
        return false;
	}

	if("activity_2" == aNewItemId){
		return true;
	}
	if("activity_3" == aNewItemId){
		return true;
	} else if(!isDoJump("activityTab",aNewItemId)) {
        alert("在查看其他页签时，请先填写并保存“营销活动主要信息”！");
        return false;
	}

	return true;
}

function resetTabitem(orderId,editable) {
	isNew = true;
	if ("" == orderId || "null" == orderId || undefined == orderId){
		orderId = "";
	} 
    refreshTabItem("activityTab","activity_2","第二步：档次信息：","new_detail.jsp?orderId=" + orderId + "&editable=" + editable);
    refreshTabItem("activityTab","activity_3","第三步：服务相关信息 ：","new_explan.jsp?orderId=" + orderId + "&editable=" + editable);
    refreshTabItem("activityTab","activity_4","第四步：确认及提交：","new_overview.jsp?orderId=" + orderId + "&editable=" + editable);
    refreshTabItem("activityTab","activity_1","第一步：营销活动主要信息：","new_main.jsp?orderId=" + orderId + "&editable=" + editable);
	isNew = false;
}

function resetTabitemsMainShow(orderId) {
    if ("" == orderId || "null" == orderId || undefined == orderId){
        alert("刷新页签主要信息时，mainId为空！");
    } else {
        //getTabitem("activityTab","activity_1").contentWindow.showDetailList();
        getTabitem("activityTab","activity_2").contentWindow.include_refreshSaleMainTable(orderId);
        getTabitem("activityTab","activity_3").contentWindow.include_refreshSaleMainTable(orderId);
        getTabitem("activityTab","activity_4").contentWindow.include_refreshSaleMainTable(orderId);
        //getTabitem("activityTab","activity_4").contentWindow.refreshSaleMainOverviewForm(orderId);
    }
}

function refreshMainTab(orderId) {
    if ("" == orderId || "null" == orderId || undefined == orderId){
        alert("刷新页签主要信息时，mainId为空！");
    } else {
        getTabitem("activityTab","activity_1").contentWindow.initPage();
        getTabitem("activityTab","activity_4").contentWindow.initPage();
    }
}

function isDoJump(tabId,itemId) {
    return getTabitem(tabId,itemId).contentWindow.include_isShowAllow();
}

function getTabitem(tabId,itemId) {
    return document.getElementById(tabId + "_" + itemId);
}
</script>
</head>
<body>
<ai:tab id="activityTab" width="100%" type="h" height="100%" beforeSetTab="checkTab">
   <ai:tabitem id="activity_1" title="" src="" />
   <ai:tabitem id="activity_2" title="" src=""/>
   <ai:tabitem id="activity_3" title="" src=""/>
   <ai:tabitem id="activity_4" title="" src=""/>
</ai:tab>
</body>
</html>
<script type="text/javascript">
var orderId = "<%=request.getParameter("orderId")%>";
var editable = "<%=request.getParameter("editable")%>";
resetTabitem(orderId,editable);
</script>