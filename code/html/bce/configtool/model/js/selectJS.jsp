<% response.setHeader("Cache-Control", "no-cache"); %>
<%@ taglib uri="/WEB-INF/appframe2.tld" prefix="ai" %>
<%@ taglib uri="/WEB-INF/appframe-i18n.tld" prefix="i18n" %>
<%@ page contentType="text/html; charset=GBK"%>
<%@ include file="/bce/configtool/common/bcetoolhead.jsp"%>
<html>
<head>
<title><%=LocaleResourceFactory.getResource("BES0000611")%> JS</title>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
<script src="<%=request.getContextPath()%>/jsv2/Globe_v2.jsp"></script>
<script type="text/javascript">
var dispUrl = "jsView.jsp?filePath=";
var srcUrl = "../common/sourceView.jsp?fileType=JS&filePath=";

var curTabId = "";	//当前选中的Tab id

var curTreeSelect = {	//当前树的选择
	value:"",
	userobj:"",
	text:""		
};	
var curMethodPath = "";	//当前方法Tab的路径
var curSourcePath = "";	//当前源文件显示的路径

function tabBeforeSetTab(a, itemId){
	if(curTabId == itemId){
		return false;
	}else{
		return true;
	}
}

function tabAfterSetTab(a, itemId){
	curTabId = itemId;
	if(getTabItemIdxsByTabItemId){		
		var ind = getTabItemIdxsByTabItemId("main_tab",curTabId);
		if(refreshTabById && curTreeSelect.value != "D"){
			refreshTabById(ind, curTreeSelect);
		}
	}
}

/** 树选择 */
function onTreeSelect(value, label){
	var curNodeInfo = getTree().getCurNodeInfo();
	
	if(curNodeInfo.value != "D"){	//不为目录		
		var aTabItemId = getCurrentTabFocusItem("main_tab");
		curTreeSelect = curNodeInfo;
		refreshTabById(aTabItemId, curTreeSelect);
	}else{
		curTreeSelect = curNodeInfo;
	}
}

/** 根据tabItemId和value刷新Tab页 */
function refreshTabById(aTabItemId, curTreeSelect){
	if(aTabItemId ==0){		//显示Tab
		if(curMethodPath != curTreeSelect.value){	//保证只解析一次
			curMethodPath = curTreeSelect.value;
			var frmObj = frames["main_tab" + "_" + "dispTab"];
			if(frmObj.refresh){
				frmObj.refresh(curTreeSelect.userobj);
			}
		}
	}else if(aTabItemId ==1){		//源文件Tab
		if(curSourcePath != curTreeSelect.value){	//保证源文件只解析一次
			curSourcePath = curTreeSelect.value;		
			refreshTabItem("main_tab", "srcTab", null, srcUrl + curTreeSelect.userobj, false);
		}
	}
}
</script>
</head>
<body onload="init()">
<table width="100%" align="center" border="0" cellpadding="0" cellspacing="0">
	<tr>
		<td width="320" valign="top">
			<div class="area_tab">
          	<ai:dbtree_new id="dbTree" height="455" width="100%" 
			   datamodel="com.ai.bce.configtool.model.js.JSTreeModel" 
			   initial="true" ishaveline="true"
			   onselect="onTreeSelect" />
			</div>
		</td>
		<td width="10"></td>
		<td valign="top" align="right">
			<div class="area_tab">
				<ai:tab id="main_tab" width="100%" height="430" type="h" beforeSetTab="tabBeforeSetTab" afterSetTab="tabAfterSetTab">
					<ai:tabitem src="jsView.jsp" id="dispTab" title="JS" initial="true" />
					<ai:tabitem src="../common/sourceView.jsp" id="srcTab" title="BES0000813" i18nRes="CRM"/>
				</ai:tab>
			</div>
		</td>
	</tr>
	<tr>
		<td colspan="2" height="20">&nbsp;</td>
	</tr>
</table>
<div class="area_button">
	<ai:button text="BES0000321" i18nRes="CRM" id="okBtn" onclick="ok()"/>&nbsp;&nbsp;&nbsp;&nbsp;
	<ai:button text="BES0000320" i18nRes="CRM" id="cancelBtn" onclick="cancel()" enable="true"/>
</div>
</body>
<script language="javascript">

function getTree(){
	return g_DBTreeNewManager.get("dbTree");
}

function init(){
	getTree().refresh(null);
}

function ok(){
	if(curTreeSelect.value && curTreeSelect.value != "D"){
		var treeValue = curTreeSelect.value;
		var tableValue = frames["main_tab" + "_" + "dispTab"].getValue();

		var retObj = {
			treeValue: treeValue,
			tableValue: tableValue
		};		
		window.returnValue = retObj;
		window.close();
	}else{
		alert(crm_i18n_msg("BEC0000338"));
	}
}

function cancel(){
	window.self.close();
}
</script>
</html>