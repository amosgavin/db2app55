<%@ page import="com.ai.common.i18n.CrmLocaleFactory" %>
<% response.setHeader("Cache-Control", "no-cache"); %>
<%@ taglib uri="/WEB-INF/appframe2.tld" prefix="ai" %>
<%@ taglib uri="/WEB-INF/appframe-i18n.tld" prefix="i18n" %>
<%@ page contentType="text/html; charset=GBK"%>
<%@ include file="/bce/configtool/common/bcetoolhead.jsp"%>
<%
//����ͼ
String title= CrmLocaleFactory.getResource("BES0000517");
//Դ�ļ�
String sourceFileTitle= CrmLocaleFactory.getResource("BES0000813");
    //BES0000890
String selectWvmTitle= CrmLocaleFactory.getResource("BES0000890");
%>
<html>
<head>
<title><%=CrmLocaleFactory.getResource("BES0000611")%> WVM</title>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
<script src="<%=request.getContextPath()%>/jsv2/Globe_v2.jsp"></script>
<script type="text/javascript">
var dispUrl = "workflowChart.jsp?fileType=WVM&workflowCode=";
var srcUrl = "../common/sourceView.jsp?fileType=WVM&workflowCode=";

var curTabId = "";	//��ǰѡ�е�Tab id

var curTreeSelect = {	//��ǰ����ѡ��
	value:"",
	userobj:"",
	text:""		
};	
var curMethodPath = "";	//��ǰ����Tab��·��
var curSourcePath = "";	//��ǰԴ�ļ���ʾ��·��

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

/** ��ѡ�� */
function onTreeSelect(value, label){
	var curNodeInfo = getTree().getCurNodeInfo();

	if(curNodeInfo.value != "D"){	//��ΪĿ¼		
		var aTabItemId = getCurrentTabFocusItem("main_tab");
		curTreeSelect = getTree().getCurNodeInfo();//value;
		refreshTabById(aTabItemId, curTreeSelect);
	}else{
		curTreeSelect = getTree().getCurNodeInfo();
	}
}

/** ����tabItemId��valueˢ��Tabҳ */
function refreshTabById(aTabItemId, curTreeSelect){
	if(aTabItemId ==0){		//��ʾTab
		if(curMethodPath != curTreeSelect.value){	//��ֻ֤����һ��
			curMethodPath = curTreeSelect.value;
			refreshTabItem("main_tab", "dispTab","<%=title%>" , dispUrl + curTreeSelect.value, true);
		}
	}else if(aTabItemId ==1){		//Դ�ļ�Tab
		if(curSourcePath != curTreeSelect.userobj){	//��֤Դ�ļ�ֻ����һ��
			curSourcePath = curTreeSelect.userobj;		
			refreshTabItem("main_tab", "srcTab", "<%=sourceFileTitle%>", srcUrl + curTreeSelect.value + "&filePath="
					+ curSourcePath, false);
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
			   datamodel="com.ai.bce.configtool.model.wvm.WVMTreeModel" 
			   initial="true" ishaveline="true"
			   onselect="onTreeSelect" />
			</div>
		</td>
		<td width="10"></td>
		<td valign="top" align="right">
			<div class="area_tab">
				<ai:tab id="main_tab" width="100%" height="430" type="h" beforeSetTab="tabBeforeSetTab" afterSetTab="tabAfterSetTab">
					<ai:tabitem src="workflowChart.jsp" id="dispTab" title="<%=title%>" initial="true" />
					<ai:tabitem src="../common/sourceView.jsp" id="srcTab" title="<%=sourceFileTitle%>" />
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

		var retObj = {
			treeValue: treeValue
		};		
		window.returnValue = retObj;
		window.close();
	}else{
		alert("<%=selectWvmTitle%>");
	}
}

function cancel(){
	window.self.close();
}
</script>
</html>