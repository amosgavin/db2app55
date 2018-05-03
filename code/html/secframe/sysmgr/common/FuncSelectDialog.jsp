<%@ page contentType="text/html; charset=GBK"
	pageEncoding="GBK"%>
<%@include file="/secframe/common/common.jsp"%>
<%@include file="/webframe/common/commonhead.jsp"%>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=GBK">
		<title></title>
	</head>
	<body>
		<ai:contractframe id="" contenttype="table" title="funcselectdialog.selectfunc" i18nRes="i18n.secframe_resource" width="100%" allowcontract="false" frameclosed="false">
        <ai:contractitem/>
					<ai:dbtree_new id="funcTree"
						datamodel="com.ai.secframe.sysmgr.web.SecFunctionDataModel"	multiselect="false" height="340" width="100%" ishaveline="true" ondblclick="chkCur"/>
	   </ai:contractframe>					
        <div class="area_button">
		<ai:button text="funcselectdialog.confirm" i18nRes="i18n.secframe_resource" onclick="affirm()"/>
		<ai:button text="funcselectdialog.cancel" i18nRes="i18n.secframe_resource" onclick="cancel()"/>
		</div>
	</body>
</html>
<script type="text/javascript">
<!--
var curNode = null;
var dbTree = g_DBTreeNewManager.get("funcTree");
dbTree.refresh(null,-1,"stationTypeId=100000");

function affirm(){
	curNode = dbTree.getCurNodeInfo();
	if(curNode == null){
		//alert("请选择菜单！");
		alert(g_I18NMessage("secframe_funcselectdialog", "secframe_funcselectdialog_func"));
		return false;
	}
	var v_func = new Func(curNode.value,curNode.text,curNode.userobj);
	var list = new Array();
	list[0] = v_func
	window.returnValue = list;
	window.self.close();
}
function Func(funcId,funcName,url){
	this.funcId = funcId;
	this.funcName = funcName;
	this.url = url;
}
function cancel(){	
	window.self.close();
}
function chkCur(){
	affirm();
}
//-->
</script>
