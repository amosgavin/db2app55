<%@ page contentType="text/html; charset=GBK"%>
<%@ include file="/webframe/common/commonhead.jsp"%>
<%@ page import="com.ai.secframe.sysmgr.web.LoginFunctionDataModel"%>
<html>
<head>
<title>tree</title>
</head>

<body>
<ai:dbtree_new id="secfunction_tree" height="100%" width="100%" datamodel="com.ai.secframe.sysmgr.web.LoginFunctionDataModel" initial="true" ishaveline="true" onselect="openUrl" />
</body>
</html>

<script type="text/javascript">
function openUrl(){
   var dbtree = g_DBTreeNewManager.get("secfunction_tree");
   var curNode = dbtree.getCurNodeInfo();
   if (null !=curNode.userobj && "null" != curNode.userobj)
   {
        openMainFrame('<%=request.getContextPath()%>'+curNode.userobj);
   }
}

function openMainFrame(url){
window.top.document.getElementById("mainFrame").src = url;
}
</script>