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
var xmlHttpReq;
(function createXmlRequest(){
	try{
		xmlHttpReq=new ActiveXObject("Msxml2.XMLHTTP");
	}catch(e){
		xmlHttpReq=new ActiveXObjec("Microsoft.XMLHTTP");
	}if(!xmlHttpReq && typeof XMLHttpRequest!='undefined'){
		try{
			xmlHttpReq=new XMLHttpRequest();
		}catch(e){
			xmlHttpReq=false;
		}
	}
})();

var parentName="" ;
function openUrl(){
   var dbtree = g_DBTreeNewManager.get("secfunction_tree");
   var curNode = dbtree.getCurNodeInfo();
   if(curNode.value=='-1'){
       curNode.userobj='/main3/right.jsp';
   }
   if (null !=curNode.userobj && "null" != curNode.userobj)
   {
        openMainFrame(curNode,'<%=request.getContextPath()%>'+curNode.userobj);
   }else{
	   parentName =  curNode.text;
   }
}
 	
function openMainFrame(curNode,url){
	window.top.document.getElementById("mainFrame").src = url;
	createOperLog(curNode);
}

function createOperLog(curNode){
    var menuName ="统一营销管理平台-"+parentName +"-"+ trim(curNode.text);
    var menuUri =trim(curNode.userobj);
    var menuMid ="6-432-"+curNode.value;
	var url = "<%=request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()%>" + 
			  "/db2app55/servlet/OperLogServlet?menuName="+menuName+"&menuUri="+menuUri+"&menuMid="+menuMid;
	xmlHttpReq.open("POST",url, false);
	xmlHttpReq.send();
	 
}
 function trim(str)
{
     return str.replace(/(^\s*)|(\s*$)/g, '');
}
</script>