<%@ page contentType="text/html; charset=GBK" pageEncoding="GBK"%>
<%@include file="/secframe/common/common.jsp"%>
<%@include file="/webframe/common/commonhead.jsp"%>
<%@ page import="com.ai.secframe.common.Constants"%>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=GBK">
		<title><i18n:message key="sec.functionselectdialog.title" res="i18n.secframe_resource"/></title>
	</head>
    <%
         String rootId = Constants.STR_FUNC_ROOT_ID;
    %>
    <body onLoad="closeTree();initFuncTree();sysfunction_tree.setNodeSelect(<%=rootId%>);">
         <ai:contractframe id="" contenttype="table" title="sec.functionselectdialog.available" i18nRes="i18n.secframe_resource" width="100%" allowcontract="false" frameclosed="false">
            <ai:contractitem/>
            <table width="99%" align="center" border="0" cellpadding="0" cellspacing="0">
        		<tr>
         		  <td>
                     <ai:dbtree_new id="sysfunction_tree" height="380" width="100%" datamodel="com.ai.secframe.sysmgr.web.BaseFunctionDataModel" 
                         initial="false" ishaveline="true" multiselect="true" onwillexpand="expandNode" oncheckboxclick="chkSelected" explanonselect="true"/>
                  </td>
                </tr>
             </table>	
         </ai:contractframe>
         <div class="area_button">
				<ai:button id="okBtn" text="sec.functionselectdialog.ok" i18nRes="i18n.secframe_resource" onclick="OK()"/>&nbsp;&nbsp;
				<ai:button text="sec.functionselectdialog.cancel" i18nRes="i18n.secframe_resource" id="cancelBtn" onclick="cancel()"/>
         </div>
   
	</body>
</html>
<script type="text/javascript">
var rootId = "<%=rootId%>";
var sysfunction_tree = g_DBTreeNewManager.get("sysfunction_tree");

function Func(funcId,funcName,url)
{
	this.funcId = funcId;
	this.funcName = funcName;
	this.url = url;
}

// 初始化菜单树
function initFuncTree()
{
	sysfunction_tree.setCheckBoxSts(rootId, false);
	sysfunction_tree.refresh(rootId,"-1");
	setCheckBoxState(rootId);
}

//确认
function OK()
{
	var arr = sysfunction_tree.getCheckedNodesInfo();
	window.returnValue = arr;
	alert(arr[0].value + "," + arr[0].text + ","+arr[0].userobj)
	window.self.close();
}

// 展开/收缩节点
function expandNode(isExpand, nodeVal,nodeText,nodeUsrObj)
{
	if(isExpand == true)
	{
		setCheckBoxState(nodeVal);
	}
}

// 设置节点的复选框状态，可编辑不可编辑
function setCheckBoxState(nodeVal)
{
	var childNodes = sysfunction_tree.getChildrenNodesInfo(nodeVal);
	for(var i=0; i < childNodes.length; i++)
	{
		if(childNodes[i].userobj != null && childNodes[i].userobj == "3")
		{
			sysfunction_tree.setCheckBoxSts(childNodes[i].value, true);
		}
		else
		{
			sysfunction_tree.setCheckBoxSts(childNodes[i].value, false);
		}
	}
}
// 勾选/去勾选复选框
function chkSelected(value,text,userobj,isChecked,nType)
{
	// 不是根节点并且必须是叶子节点
	if( value!=rootId && userobj=="3")
	{
		sysfunction_tree.setNodeChecked(value,isChecked);
	}
}

//收缩节点
function closeTree()
{
    var arr = sysfunction_tree.getChildrenNodesInfo(rootId);
  
    if(arr==null)
    {
      return;
    } 
    for(i=0;i<arr.length;i++)
    {
	    sysfunction_tree.expandNodeByValue(arr[i].value,false);
    }
}
// 取消
function cancel()
{	
	window.self.close();
}
</script>
